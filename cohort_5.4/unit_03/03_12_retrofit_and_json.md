# Retrofit - Parsing JSON the Easy Way 

## Objectives
* Fellows will learn how to pull data from JSON endpoint using Retrofit
* Fellows will create data models to map to that JSON Data
* Fellows will learn how to display that data as an image from a website using Picasso

## Resources
* [Dog API](https://dog.ceo/dog-api/) 
* [Picasso](https://github.com/square/picasso)
* [Retrofit](https://github.com/square/retrofit)
* [JSON and JSON Parsing - The Old School Way](https://github.com/C4Q/AC-Android/tree/master/lessons/json/json_parsing)

## Warm-Up 

Revisit the following lecture as reference: [JSON and JSON Parsing - The Old School Way](https://github.com/C4Q/AC-Android/tree/master/lessons/json/json_parsing)

Open up a new Android Studio Project. In the ```onCreate()``` method of your ```MainActivity.java``` class - create a single JSONObject instance. In this object, put two entries:

* a key of "name", with a value of your name as a String
* a key of "age", with a value of a number, without quotes

Log this JSONObject, as debug, and see that it shows up in Logcat as you run the project.

# Lecture

We have explored in class previously how to create JSONObjects, and parse JSON into data models that we can use to display that JSON data in some meaningful way. We've even explored how to use AsyncTasks (ugh, sorry...) to run tasks off the main thread, and make use of that information any way we chose to do so. You might have thought this was the only way to do this in Android, but...

![Retrofit, there is...](http://i.imgur.com/SRyMh.jpg)

much less exhausting, and much more predictable way to do this - using Retrofit.

## What is Retrofit?

It's amazing, is what it is. An open-source library built by Square, it allows you to easily make GET and PUT requests (among other things), by simply using a few boilerplate lines of code, without having to repeat yourself that often. It accounts for most edge cases specific to HTTP requests, and does everything off of the main thread, so you never have to worry about blocking the rest of your UI.

## Retrofit, by the Recipe

First, we'll break down the most important steps to a basic Retrofit call, as per the **first principles** technique, then we'll expand on these steps by making an app that displays random puppy images.

### Step 1: Add Internet Permissions

First, you'll need to add this permission to your ```AndroidManifest.xml``` file:

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
          package="org.pursuit.dogjson">
  
    <!--This will allow you to connect to the internet-->
    <uses-permission android:name="android.permission.INTERNET"/>

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>

                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>
    </application>

</manifest>
```

### Step 2: Add Gradle Dependencies

Add these dependencies to your app's build.gradle file:

```groovy
implementation 'com.squareup.retrofit2:retrofit:2.3.0'
implementation 'com.squareup.retrofit2:converter-gson:2.3.0'
```

### Step 3: Find your desired JSON Endpoint

In this example, we'll use the JSON provided by [Dog.ceo](https://dog.ceo/api/breeds/image/random), which looks something like this:

```json
{"status":"success","message":"https:\/\/dog.ceo\/api\/img\/poodle-toy\/n02113624_2224.jpg"}
```

We can see that this JSON is a single object, consisting of two key/value pairs - the key "status" has a value of "success", and the key "message" has a value of what looks like a weblink to an image. Both values are written as Strings - this is important to remember as we move foward.

### Step 4: Create your Data Model

In your app's package folder, make another package called "model", and create a class inside the 'model' directory to represent that JSON Object. Let's call it "RandoPuppy.java":

```java
package org.pursuit.dogjson.model;

public class RandoPuppy {
    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
```

It should have two String member variables that match the key names **EXACTLY AS THEY ARE WRITTEN** in the JSON, as well as Getter methods. Now that we have our model, let's parse some JSON through it.

### Step 5: Create a Retrofit instance, using the Builder Pattern

The Builder Pattern is a way to assign values to member variables/fields within a class using method chaining during instantiation - sort of like a constructor. However, it is arguably better - sort of the way you use beginTransaction() and commit() with a fragment.

**YOU DO NOT NEED TO KNOW HOW THIS WORKS RIGHT NOW.**

However, that's what's happening in the following code:

```java
Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dog.ceo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
```

Let's break it down line-by-line:
* ```Retrofit retrofit = new Retrofit.Builder()``` - this starts the builder process
* ```.baseUrl("https://dog.ceo/")``` - this is our "Base URL", or the gateway to our JSON endpoint. Our full endpoint link is: https://dog.ceo/api/breeds/image/random - so essentially everything up to our first forward slash is our base url
* ```.addConverterFactory(GsonConverterFactory.create())``` - this takes care of our JSON serialization/deserialization for us! Thanks, Google! If you want to take a deeper dive into Gson, you can read more about it [here](https://futurestud.io/tutorials/retrofit-2-adding-customizing-the-gson-converter)
* ```.build();``` - this ends the transaction, and returns to us a complete Retrofit instance!

### Step 6: Create a service:

Let's create a package called "backend" within the app's package, and create an interface called ```PuppyService.java```:

```java
package org.pursuit.dogjson.backend;

import org.pursuit.dogjson.model.RandoPuppy;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PuppyService {
    @GET("api/breeds/image/random")
    Call<RandoPuppy> getPuppy();
}
```

This will give us the opportunity to call on a method called ```getPuppy()``` - which will make an HTTP GET request for our JSON. As you can see, the rest of our JSON endpoint link is contained in our GET request. Let's go back to our MainActivity, and call the service:

```java
Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dog.ceo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // creating the service so we can use it to make requests:
        puppyService = retrofit.create(PuppyService.class);
```

### Step 7: Making the Call

Retrofit allows us to make a GET request Asynchronously - off the main thread, but without having to use an AsyncTask, we just wait for the right callbacks:

```java
Call<RandoPuppy> puppy = puppyService.getPuppy();
                puppy.enqueue(new Callback<RandoPuppy>() {
                    @Override
                    public void onResponse(Call<RandoPuppy> call, Response<RandoPuppy> response) {
                        Log.d(TAG, "onResponse: " + response.body().getMessage());
                    }

                    @Override
                    public void onFailure(Call<RandoPuppy> call, Throwable t) {
                        Log.d(TAG, "onResponse: " + t.toString());
                    }
                });
```

As you can see in Call<RandoPuppy>, we are saying that whatever JSON object we get back, we are treating it like our data model "RandoPuppy" and so we'll be able to use the getter methods in ```RandoPuppy.java``` to get the URL string for photo link from the JSON key "message". But that's only if we get a response. If we get a response (```onResponse()```), we should be able to log our response body, and its contents. If we fail, (```onFailure()```), we should be able to log our error, and fail gracefully.

### Step 8: That's essentially it

As you can see, this is much safer than using an AsyncTask to access the internet, and much cleaner than parsing the JSON step-by-step. But, this whole process begs the question - "How about JSON, but with puppies?!"

## Simple Internet App

Let's take the skills we've learned with JSON and Retrofit, and put them all together with another Square library called Picasso. Picasso is a great way to get URL links, and turn them into viewable images, as well as format them to your liking, as far as scaling is concerned.

First, let's have our ```activity_main.xml``` look a little something like this:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="org.pursuit.dogjson.MainActivity">

    <ImageView
        android:layout_weight="1"
        android:id="@+id/puppy_imageview"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:scaleType="centerCrop"/>
    <LinearLayout
        android:layout_weight="1"
        android:orientation="vertical"
        android:layout_width="match_parent"
        android:gravity="center"
        android:layout_height="0dp">
    <Button
        android:id="@+id/new_puppy_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:text="Get New Puppy"/>
    </LinearLayout>
</LinearLayout>
```

The goal being - everytime we click on the button, a new random puppy will appear from the internet. Let's modify our code a bit to include some views:

```java
package org.pursuit.dogjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.pursuit.dogjson.backend.PuppyService;
import org.pursuit.dogjson.model.RandoPuppy;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "JSON?";
    private ImageView imageView;
    private Button newPuppy;
    private PuppyService puppyService;
    private String puppyUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.puppy_imageview);
        newPuppy = (Button) findViewById(R.id.new_puppy_button);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dog.ceo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        puppyService = retrofit.create(PuppyService.class);

        newPuppy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<RandoPuppy> puppy = puppyService.getPuppy();
                puppy.enqueue(new Callback<RandoPuppy>() {
                    @Override
                    public void onResponse(Call<RandoPuppy> call, Response<RandoPuppy> response) {
                        Log.d(TAG, "onResponse: " + response.body().getMessage());
                        puppyUrl = response.body().getMessage();
                        Picasso.with(getApplicationContext())
                                .load(response.body().getMessage())
                                .into(imageView);
                    }

                    @Override
                    public void onFailure(Call<RandoPuppy> call, Throwable t) {
                        Log.d(TAG, "onResponse: " + t.toString());
                    }
                });
            }
        });
        newPuppy.callOnClick();
    }
}
```

As you can see, we've extracted the code specific to making a GET request, and placed it into the button's OnClickListener. We also added additional code, ```newPuppy.callOnClick();```, which will run the code in the onClick, so if everything works smoothly, we'll have a puppy waiting for us before we even have to click "Get new Puppy"!

So, how are we able to take the URL we get as a response from Retrofit's parsing of the JSON, and turn that into an image? With Picasso, of course!

First, add this dependency to your app's build.gradle file:

```groovy
    implementation 'com.squareup.picasso:picasso:2.5.2'
```

Next, let's break down the steps:
* ```Picasso.with(getApplicationContext())``` - using the current context....
* ```.load(response.body().getMessage())``` - load the image being pointed to in the link
* ```.into(imageView);``` - into the ImageView you want

And that's it! Now, let's add some more code to make sure that when we rotate the device by accident, we'll keep the last image queried, rather than make a new call every time onCreate() is called:

```java
package org.pursuit.dogjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.pursuit.dogjson.backend.PuppyService;
import org.pursuit.dogjson.model.RandoPuppy;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "JSON?";
    private ImageView imageView;
    private Button newPuppy;
    private PuppyService puppyService;
    private String puppyUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.puppy_imageview);
        newPuppy = (Button) findViewById(R.id.new_puppy_button);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dog.ceo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        puppyService = retrofit.create(PuppyService.class);

        newPuppy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<RandoPuppy> puppy = puppyService.getPuppy();
                puppy.enqueue(new Callback<RandoPuppy>() {
                    @Override
                    public void onResponse(Call<RandoPuppy> call, Response<RandoPuppy> response) {
                        Log.d(TAG, "onResponse: " + response.body().getMessage());
                        puppyUrl = response.body().getMessage();
                        Picasso.with(getApplicationContext())
                                .load(response.body().getMessage())
                                .into(imageView);
                    }

                    @Override
                    public void onFailure(Call<RandoPuppy> call, Throwable t) {
                        Log.d(TAG, "onResponse: " + t.toString());
                    }
                });
            }
        });

        if(savedInstanceState != null) {
            String savedPuppy = savedInstanceState.getString("puppyUrl");
            puppyUrl = savedPuppy;
            Picasso.with(getApplicationContext())
                    .load(savedPuppy)
                    .into(imageView);
        } else {
            newPuppy.callOnClick();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("puppyUrl", puppyUrl);
    }
}
```

Voila! Puppies!

![RandoPuppy](dog_json.PNG)

More complicated use cases for Retrofit are only expanded variations of the example we've just shown you. Together, we created an app that pulls data from the internet, and creates a different experience every time the user interacts with the app somehow! Let's see if we can't experiment with other free API's....
