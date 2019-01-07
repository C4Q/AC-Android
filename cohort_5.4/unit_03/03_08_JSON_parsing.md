# JSON and JSON Parsing - The Old School Way

## Objectives
* Fellows will learn how to interpret JSON Text
* Fellows will learn how to create JSON Objects
* Fellows will learn how to create JSON Arrays
* Fellows will learn how to add key/value pairs to JSON Objects
* Fellows will learn how to access the contents of a JSON Object
* Fellows will learn how to parse the contents of a JSON Object into Java Data Model Objects
* Fellows will learn how to display the data entered into these data models, in various ways

## Resources
* [What is JSON?](https://developers.squarespace.com/what-is-json/)
* [JSON Formatter](https://jsonformatter.org)
* [Java API for JSON Processing: An Introduction to JSON](http://www.oracle.com/technetwork/articles/java/json-1973242.html)

# Lecture

We live in a data-driven world: data is both displayed to us, or collected from us and analyzed frequently, on a daily basis. As average good citizens, this fact is both boring and scary. As developers, we should be aware of how to effectively get and send this data to and from external sources, so that we can make use of this data properly in our applications.

One way we can organize this data is by formatting it into something called JavaScript Object Notation, or **JSON**.

JSON is fairly human-readable, in that with very little introduction, a layperson can look at some JSON, and realize that it is mostly made up of three (3) fundamental parts:
* data organized into key/value pairs 
* a unit of data, which can contain key/value pairs (JSONObject)
* a list of either values, or JSONObjects (JSONArray)

### Key

A key in JSON is always wrapped by double quotation marks:

```json
"name"
```

### Value

A value in JSON can be one of the following data types, and nothing else:

* Array: An associative array of values, wrapped in square brackets ```[ ]```
* Boolean: boolean values - ```true``` or ```false```
* Number: An integer - ```25``` or double - ```2.5```
* Object: A unit of data filled with key/value pairs, wrapped in curly brackets - ```{ }```
* String: Several plain text characters which usually form a word - ```"Some String"```

### Key/Value Pairs

Key/Value pairs in JSON are separated by a colon - ``` : ``` - for example:

```json
"name" : "Jose"
```

where ```"name"``` is the key, and ```"Jose"``` is the value.

### Objects

Objects are collections of key/value pairs - objects can be empty:

```json
{}
```

or objects can have entries:

```json
{"name" : "Jose"}
```

Objects can also have multiple entries of key/value pairs, separated by commas:

```json
{"name" : "Jose", "role" : "Brother", "age" : 37}
```

Entries can be arranged in a single line, or more often, displayed on new lines:

```json
{
	"name" : "Jose",
	"role" : "Brother",
	"age" : 37
}
```

### Arrays

Arrays can be collections of either values or objects.

They can be empty:

```json
[ ]
```

They can contain a single value:

```json
["apple"]
```

They can contain multiple values, separated by commas:

```json
["apple", "orange"]
```

They can contain a single empty object:

```json
[ { } ]
```

They can contain a single populated object:

```json
[ {"fruit" : "apple"} ]
```

They can contain multiple populated objects, separated by commas:

```json
[ {"fruit" : "apple"}, {"fruit" : "orange"}, {"fruit" : "banana"} ]
```

But that's pretty much it. Almost all JSON (like 99.99%) you'll encounter will be variations of the examples you've seen above.

## Composing JSON in Java

There are multiple ways to create JSON in Java. For today, we'll import several libraries for our example in a basic Android Studio project:

```java
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
```

The need for the first two (2) imports is intuitive, since we will most likely be working with objects and arrays in JSON. However, the exception import is also necessary, to check that the operations we'll run on the JSON fail fast and effectively whenever they encounter errors.

Let's create a JSONObject together!

```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

	JSONObject newJsonWeAreMaking = new JSONObject();
	}
}
```

And that's it! Seriously! To prove it, let's log it as debug, with a TAG variable, after running ```.toString()``` on the object, to see it's contents as JSON in Logcat:

```java
public class MainActivity extends AppCompatActivity {

public static final String TAG = "Json Example";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

	JSONObject newJsonWeAreMaking = new JSONObject();

	Log.d(TAG, "onCreate: " + newJsonWeAreMaking.toString());
	}
}
```

And in Logcat, we should see:

```text
D/Json Example: onCreate: {}
```

Great! We've created an empty object - now let's add stuff to it. First, we'll have to wrap our code in a try/catch block:

```java
public class MainActivity extends AppCompatActivity {

public static final String TAG = "Json Example";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

	JSONObject newJsonWeAreMaking = new JSONObject();

	try {
            	newJsonWeAreMaking.put("name", "Jose");
        } catch (JSONException e) {
            	e.printStackTrace();
        }

	Log.d(TAG, "onCreate: " + newJsonWeAreMaking.toString());
	}
}
```

And in Logcat, we should see:

```text
D/Json Example: onCreate: {"name":"Jose"}
```

Okay, let's expand on these entries by adding an array. For our example, let's create an array of names, for members of a family:

```java
public class MainActivity extends AppCompatActivity {

public static final String TAG = "Json Example";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

	JSONObject newJsonWeAreMaking = new JSONObject();

	try {
            	newJsonWeAreMaking.put("family_members", new JSONArray()
			.put(new JSONObject()
				.put("name", "Jose")));
        } catch (JSONException e) {
            	e.printStackTrace();
        }

	Log.d(TAG, "onCreate: " + newJsonWeAreMaking.toString());
	}
}
```

And in Logcat, we should see:

```text
D/Json Example: onCreate: {"family_members":[{"name":"Jose"}]}
```

Excellent! Let's add a few more family member objects to this array:

```java
public class MainActivity extends AppCompatActivity {

public static final String TAG = "Json Example";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

	JSONObject newJsonWeAreMaking = new JSONObject();

	try {
            	newJsonWeAreMaking.put("family_members", new JSONArray()
                    .put(new JSONObject().put("name", "Jose"))
                    .put(new JSONObject().put("name", "Ramona"))
                    .put(new JSONObject().put("name", "Joe"))
                    .put(new JSONObject().put("name", "Barbara"))
                    .put(new JSONObject().put("name", "Aida"))
        } catch (JSONException e) {
            	e.printStackTrace();
        }

	Log.d(TAG, "onCreate: " + newJsonWeAreMaking.toString());
	}
}
```

And in Logcat, we should see:

```text
D/Json Example: onCreate: {"family_members":[{"name":"Jose"},{"name":"Ramona"},{"name":"Joe"},{"name":"Barbara"},{"name":"Aida"}]}
```

Well alright! Our JSON is really coming along! However, it's becoming a bit unruly... To see the JSON in an easier to read, or **unminified** format, we can copy the raw JSON, and paste it into a website like [https://jsonformatter.org](https://jsonformatter.org):

![](JSONFormatter.png)

And so the unminified version shoud look like this:

```json
{
  "family_members": [
    {
      "name": "Jose"
    },
    {
      "name": "Ramona"
    },
    {
      "name": "Joe"
    },
    {
      "name": "Barbara"
    },
    {
      "name": "Aida"
    }
  ]
}
```

Sweet! Okay, let's round off this data with a few more key/value pairs for each object, or family member:

```java
public class MainActivity extends AppCompatActivity {

public static final String TAG = "Json Example";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

	JSONObject newJsonWeAreMaking = new JSONObject();

	try {
            newJsonWeAreMaking.put("family_members", new JSONArray()
                    .put(new JSONObject()
                            .put("name", "Jose")
                            .put("role", "Brother")
                            .put("age", 37))
                    .put(new JSONObject()
                            .put("name", "Ramona")
                            .put("role", "Sister")
                            .put("age", 40))
                    .put(new JSONObject()
                            .put("name", "Joe")
                            .put("role", "Father")
                            .put("age", 69))
                    .put(new JSONObject()
                            .put("name", "Barbara")
                            .put("role", "Mother")
                            .put("age", 71))
                    .put(new JSONObject()
                            .put("name", "Aida")
                            .put("role", "Partner")
                            .put("age", 41)));
        } catch (JSONException e) {
            e.printStackTrace();
        }

	Log.d(TAG, "onCreate: " + newJsonWeAreMaking.toString());
	}
}
```

As you can see, we are doing something called **method chaining**, or "named parameter idiom", which means that we are calling mutiple methods on the same instance of these anonymous classes. Notice how we just used the ```new``` keyword - we didn't assign any of the other JSONObjects/JSONArrays to variables, except for the first JSONObject? It means that we are not explicitly referencing them, and so they are "anonymous", so to speak. So, while we still have access to the instance, we should call as many methods as we need to call on them, at the same time, while we have the chance.

## Parsing JSON in Java

So we have our JSON - great! But what can we do with it? Well - typically, we would encounter a string of JSON Text, and we will have to parse it into usable objects first. So let's do that:

```java
public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Json Example";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONObject newJsonWeAreMaking = new JSONObject();

        try {
            newJsonWeAreMaking.put("family_members", new JSONArray()
                    .put(new JSONObject()
                            .put("name", "Jose")
                            .put("role", "Brother")
                            .put("age", 37))
                    .put(new JSONObject()
                            .put("name", "Ramona")
                            .put("role", "Sister")
                            .put("age", 40))
                    .put(new JSONObject()
                            .put("name", "Joe")
                            .put("role", "Father")
                            .put("age", 69))
                    .put(new JSONObject()
                            .put("name", "Barbara")
                            .put("role", "Mother")
                            .put("age", 71))
                    .put(new JSONObject()
                            .put("name", "Aida")
                            .put("role", "Partner")
                            .put("age", 41)));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String jsonString = newJsonWeAreMaking.toString();

        Log.d(TAG, "onCreate: " + jsonString);
```

Okay - so now that we have our String, let's create a try/catch block, where we can manipulate JSONObjects safely:

```java
try {
// First, we're turning the String into a JSONObject
JSONObject oldJsonWeAreParsing = new JSONObject(jsonString);

// Next, we're extracting the part of the JSON we want, the JSONArray,
// and using the key "family_members" to get to it:
JSONArray familyMembersJsonArray = oldJsonWeAreParsing.getJSONArray("family_members");
...
```

Now, on to the tricky part - we'll need to map each of these values to a Java Data Model object schema into which we may store these values. This is also uncreatively known as a **POJO**, or "Plain Old Java Object". Silly, I know - but names are hard sometimes.

In essence, we'll need to create a class that can hold all the values of the objects we wish to parse. For the data we are parsing today, we can use a class like this, with a constructor, and setters/getters for each member variable:

```java
package org.pursuit.jsonexamples.model;

public class FamilyMember {

    private String name;
    private String role;
    private Integer age;

    public FamilyMember() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
```

Next, we'll need to create a List that will hold all of our objects once they've been created:

```List<FamilyMember> familyMemberList = new ArrayList<>();```

Now, for every key/value pair, for every JSONObject in the JSONArray, we can create a new ```FamilyMember``` object, set its instance variables, and add each new object to ```familyMemberList```:

```java
try {
            JSONObject oldJsonWeAreParsing = new JSONObject(jsonString);
            
            JSONArray familyMembersJsonArray = oldJsonWeAreParsing.getJSONArray("family_members");

            List<FamilyMember> familyMemberList = new ArrayList<>();

            for (int i = 0; i < familyMembersJsonArray.length(); i++) {
                FamilyMember member = new FamilyMember();
                member.setName((String) familyMembersJsonArray.getJSONObject(i).get("name"));
                member.setRole((String) familyMembersJsonArray.getJSONObject(i).get("role"));
                member.setAge((Integer) familyMembersJsonArray.getJSONObject(i).get("age"));
                familyMemberList.add(member);
            }
```

Nice! We've effectively parsed the JSON for the data we needed! Just to be sure, let's print to the debug log to confirm:

```java
package org.pursuit.jsonexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import org.pursuit.jsonexamples.model.FamilyMember;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Json Example";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONObject newJsonWeAreMaking = new JSONObject();

        try {
            newJsonWeAreMaking.put("family_members", new JSONArray()
                    .put(new JSONObject()
                            .put("name", "Jose")
                            .put("role", "Brother")
                            .put("age", 37))
                    .put(new JSONObject()
                            .put("name", "Ramona")
                            .put("role", "Sister")
                            .put("age", 40))
                    .put(new JSONObject()
                            .put("name", "Joe")
                            .put("role", "Father")
                            .put("age", 69))
                    .put(new JSONObject()
                            .put("name", "Barbara")
                            .put("role", "Mother")
                            .put("age", 71))
                    .put(new JSONObject()
                            .put("name", "Aida")
                            .put("role", "Partner")
                            .put("age", 41)));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String jsonString = newJsonWeAreMaking.toString();

        Log.d(TAG, "onCreate: " + jsonString);

        try {
            JSONObject oldJsonWeAreParsing = new JSONObject(jsonString);
            JSONArray familyMembersJsonArray = oldJsonWeAreParsing.getJSONArray("family_members");
            List<FamilyMember> familyMemberList = new ArrayList<>();

            for (int i = 0; i < familyMembersJsonArray.length(); i++) {
                FamilyMember member = new FamilyMember();
                member.setName((String) familyMembersJsonArray.getJSONObject(i).get("name"));
                member.setRole((String) familyMembersJsonArray.getJSONObject(i).get("role"));
                member.setAge((Integer) familyMembersJsonArray.getJSONObject(i).get("age"));
                familyMemberList.add(member);
            }

            for (FamilyMember fm : familyMemberList) {
                Log.d(TAG, "onCreate: " +
                        "\nName - " + fm.getName() +
                        "\nRole - " + fm.getRole() +
                        "\nAge - " + fm.getAge());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
```

And Logcat shows us our hard work come to life:

```text
12-10 01:04:47.479 30498-30498/? D/Json Example: onCreate: {"family_members":[{"name":"Jose","role":"Brother","age":37},{"name":"Ramona","role":"Sister","age":40},{"name":"Joe","role":"Father","age":69},{"name":"Barbara","role":"Mother","age":71},{"name":"Aida","role":"Partner","age":41}]}
12-10 01:04:47.480 30498-30498/? D/Json Example: onCreate: 
                                                 Name - Jose
                                                 Role - Brother
                                                 Age - 37
12-10 01:04:47.480 30498-30498/? D/Json Example: onCreate: 
                                                 Name - Ramona
                                                 Role - Sister
                                                 Age - 40
12-10 01:04:47.480 30498-30498/? D/Json Example: onCreate: 
                                                 Name - Joe
                                                 Role - Father
                                                 Age - 69
12-10 01:04:47.480 30498-30498/? D/Json Example: onCreate: 
                                                 Name - Barbara
                                                 Role - Mother
                                                 Age - 71
12-10 01:04:47.480 30498-30498/? D/Json Example: onCreate: 
                                                 Name - Aida
                                                 Role - Partner
                                                 Age - 41
```

So, what can we do with a List of robust objects? Something to pass into a RecyclerView Adapter rings a bell....

## Exercises

Please see the exercises available for today's lesson on Canvas.
