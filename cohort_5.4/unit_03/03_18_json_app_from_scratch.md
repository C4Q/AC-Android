# JSON "App From Scratch"

## Objectives
* Fellows will attempt to follow steps within a mock coding challenge
* Fellows will demonstrate this step in front of the class with the instructor

## Resources
* [RecyclerView Review](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_02/02_20_recyclerview_review.md) 
* [Retrofit and JSON](https://github.com/joinpursuit/Pursuit-Core-Android/edit/master/cohort_5.4/unit_03/03_18_json_app_from_scratch.md)

# Lecture

Today we will build an "App From Scratch", for time. The goal of today's lesson is to get you used to completing code challenges within a certain amount of time, so that:
* you may be able to complete assessments within the time allotted
* you may be able to complete coding challenges within the time allotted

The JSON Endpoint we will be working with today [can be found here](https://api.learn2crack.com/android/jsonandroid/). First you will be asked to complete a task within a certain block of time. Then, once the time alloted has ended, a fellow will be randomly selected by the instructor, and asked to complete the task in front of the class.

The tasks are as follows:
### Open a new Android Studio Project (10 Minutes)
Open up a new Android Studio Project, using an Empty Activity

### Make data model class(es) based on the JSON Endpoint (20 Minutes)
Evaluate the JSON, then form one or more data model classes based on the JSON

### Create Singleton Class for Retrofit Instance (20 Minutes)
Create a Singleton class using the Static Factory Method design pattern, to contain a unique single instance of the Retrofit class.

### Create Retrofit Service Interface (30 Minutes)
Create an Interface for a Retrofit service, adding methods for creating get requests that include the path that comes after the base url.

### Make a Retrofit Get Request, then use the Response (30 Minutes)
Make a request to the JSON endpoint, then receive the data from the response body.

### Subclass a RecyclerView ViewHolder Class, with corresponding ItemView XML Layout (30 Minutes)
Create a ViewHolder class, which references the views declared in an ItemView XML Layout.

### Subclass a RecyclerView Adapter Class (30 Minutes)
Create an Adapter class, which overrides all inherited methods, and binds the list data passed to it to the appropriate views as needed.

### Add a RecyclerView that fills the screen, and populate it with data from the Retrofit `onResponse()` callback (20 Minutes)
Add a RecyclerView to your activity, then pass a list of data to it, the list received from the Retrofit Response.

### Make a Display Activity (30 Minutes)
Make a new activity that displays the data contained in an instance of the data model.

### When a List Tile is clicked, it should pass data to, and move to, the Display Activity (20 Minutes)
Make the itemview clickable, then fire off an intent with intent extras that moves to the display activity

### Display Activity should display the data received from the sending Intent (20 Minutes)
Take the four values received from the sending intent, and display them in views within the Display Activity.

## Exercises
Push this project to Github, then submit the link to the exercises page on the cnvas calendar for today's date.
