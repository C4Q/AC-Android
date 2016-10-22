- title: Intro to Retrofit
- tags: networking, rest apis 

# Objectives
- Review key networking terminology: HTTP, REST API, URL, client, server.
- Practice building Retrofit services to interact via HTTP with a REST API from an Android App.
- Practice serializing and deserializing JSON data with Retrofit's Gson Converter.

# Resources
- [HTTP Methods](http://www.restapitutorial.com/lessons/httpmethods.html)
- [Retrofit - A type-safe HTTP client for Android and Java](https://square.github.io/retrofit/)
- [Retrofit Tutorial](https://futurestud.io/tutorials/retrofit-getting-started-and-android-client)
- [Gson Tutorial](https://futurestud.io/tutorials/gson-getting-started-with-java-json-serialization-deserialization)

# Lecture
# What is a REST API?
A REST API defines a set of interactions which developers can use to perform requests and receive responses via an HTTP protocol such as GET or POST.

REST works almost exactly like a website in a browser. A resource is exposed to your program via a URL. Your program can access that URL via HTTP and receive data about the resource -- not unlike when you type in a URL to your browser and get a web page back.

Some properties of REST APIs:
- Client–server – The client handles the front-end, the server handles the back-end.
- Stateless – No client data is stored on the server between requests and session state is stored on the client.
- Cacheable – Clients can cache responses (just like browsers cache elements of a web page) to improve performance.

Some ways we interact with REST APIs via HTTP:
- POST: create
- GET: read
- PUT: update or create
- PATCH: update or modify
- DELETE: destroy

# What is Retrofit?
[Retrofit](https://square.github.io/retrofit/) is a popular, open-source networking library for Android and Java that simplifies and reduces the code needed to interact with REST APIs.

In this lesson, we'll first use Retrofit to make a single, simple GET request to [api.chucknorris.io](https://api.chucknorris.io), a REST API that returns a random Chuck Norris joke.

## First Steps
Make sure your app has permission to use the internet. In AndroidManifest.xml:

```xml

<uses-permission android:name="android.permission.INTERNET" />
```

Add Retrofit as a dependency to your app level build.gradle:

```groovy
dependencies {
    // ...

    compile 'com.squareup.retrofit2:retrofit:2.1.0'
    compile 'com.squareup.retrofit2:converter-gson:2.1.0'
}
```

## Writing the service
Create a new Java interface, ChuckNorrisService.java. Our interface will contain a single method `getRandomJoke()` -- a GET request to the `jokes/random` endpoint that returns a JSON response. 

```java
// ChuckNorrisService.java

public interface ChuckNorrisService {

    @GET("jokes/random")
    Call<ResponseBody> getRandomJoke();

}
```

## Creating the service

```java
// ChuckNorrisActivity.java


Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/")
                .build();

ChuckNorrisService service = retrofit.create(ChuckNorrisService.class);
```

## Synchronous call - fails on the main thread!

```java
Call<ResponseBody> call = service.getRandomJoke();

try {
    ResponseBody response = call.execute().body();
    Log.d(TAG, "response: " + response.string());
} catch(IOException e) {
    Log.e(TAG, e.getMessage());
}
```

## Asynchronous call with callback

```java
Call<ResponseBody> call = service.getRandomJoke();

call.enqueue(new Callback<ResponseBody>() {
    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        try {
            if(response.isSuccessful()) {
                Log.d(TAG, "Success: " + response.body().string());
            } else {
                Log.d(TAG, "Error" + response.errorBody().string());
            }
        } catch(IOException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        // Something went completely wrong (like no internet connection)
        Log.d("Error", t.getMessage());
    }
});
```

# Handling JSON with Gson
## Writing the POJO
From the API docs, we can see that the Chuck Norris API returns a JSON response with the following structure:

```javascript
{
    "icon_url" : "https://assets.chucknorris.host/img/avatar/chuck-norris.png",
    "id" : "Pl6TbDPXQ0iBCZJ9AjxZJQ",
    "url" : "http://api.chucknorris.io/jokes/Pl6TbDPXQ0iBCZJ9AjxZJQ"
    "value" : "chuck norris is such a beast that when he punches you in the face you fight the urge not to thank him"
}
```

Let's create a POJO to represent it:

```java
// ChuckNorrisJoke.java

public class ChuckNorrisJoke {

    private String iconUrl;

    private String id;

    private String url;

    private String value;

    // getters and setters ...
}
```

## Returning a ChuckNorrisJoke
Modify our `ChuckNorrisService` interface to return a `ChuckNorrisJoke` from our GET request:

```java
public interface ChuckNorrisService {

    @GET("jokes/random")
    Call<ChuckNorrisJoke> getRandomJoke();

}
```

Add a `GsonConverterFactory` to our Retrofit client:

```java
Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
```

Modify our call:

```java
Call<ChuckNorrisJoke> call = service.getRandomJoke();

call.enqueue(new Callback<ChuckNorrisJoke>() {
    @Override
    public void onResponse(Call<ChuckNorrisJoke> call, Response<ChuckNorrisJoke> response) {
        try {
            if(response.isSuccessful()) {
                Log.d(TAG, "Success: " + response.body().getValue());
                chuckTV.setText(response.body().getValue());
            } else {
                Log.d(TAG, "Error" + response.errorBody().string());
            }
        } catch(IOException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override
    public void onFailure(Call<ChuckNorrisJoke> call, Throwable t) {
        // Something went completely wrong (like no internet connection)
        Log.d("Error", t.getMessage());
    }
});
```

# Afternoon Exercise: Spotify Client
- If you don't already have one, sign up for a Spotify user account at [www.spotify.com](www.spotify.com).
- When you have a user account, go to the [My Applications](https://developer.spotify.com/my-applications) page at the Spotify Developer website and, if necessary, log in. Accept the latest Developer Terms of Use to complete the set-up of your account.
- Once you are logged in, click **Create a new application**.
- Enter the name of your application (for example, "Ramona's Spotify Client").
- Enter a short application description (for example, "Spotify Client for Android").
- Click **Create**. The application details screen will open. Make a note of your **Client ID** and **Client Secret**, which your app will use to authenticate with Spotify's API. **_Remember that we should never expose secret API keys on GitHub!_**
- Fork and clone the Spotify Client repo and follow the instructions.

# Glossary
**HTTP** - Hypertext Transfer Protocol. An underlying protocol used by the internet. It defines how messages are formatted and transmitted, and what actions web servers and browsers should take in response to various commands.

**REST** - REpresentational State Transfer, a style of web architecture that governs the behavior of clients and servers. When a web service uses this architecture, it is known as a REST API.

**API** - Application Programming Interface. An API specifies how software components should interact. Can be thought of as a contract provided by one piece of software to another.

**callback** - a piece of executable code that is passed as an argument to other code, which is expected to "call back" (execute) the argument at some convenient time.

**serialization** - the process of translating data structures or object state into a format that can be stored (for example, in a file or memory buffer, or transmitted across a network) and reconstructed later in the same or another computer environment.

**JSON** - JavaScript Object Notation. An extremely popular lightweight data-interchange format often used to transmit information over the internet between different applications.

**POJO** - "Plain Old Java Object". Just a normal Java class that may have fields, methods, getters, setters, etc...
