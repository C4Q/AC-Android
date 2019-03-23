# SearchView and RecyclerView "App From Scratch"

## Objectives
* Fellows will attempt to follow steps within a mock coding challenge
* Fellows will demonstrate this step in front of the class with the instructor

## Resources
* [Retrofit and JSON](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_03/03_12_retrofit_and_json.md)
* [SearchView and RecyclerView](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_05/05_10_search_view.md)

# Lecture

Today we will build an "App From Scratch", for time. The goal of today's lesson is to implement a SearchView and RecyclerView based on JSON input:
* Connect to JSON endpoint using Retrofit
* Create a Activity and RecyclerView to display data from the JSON
* Add a SearchView on top of the RecyclerView
* Pass the list to the RecyclerView Adapter
* Implement the necessary listener and callbacks

The JSON Endpoint we will be working with today [can be found here](https://gist.githubusercontent.com/jpriebe/d62a45e29f24e843c974/raw/b1d3066d245e742018bce56e41788ac7afa60e29/us_state_capitals.json). First you will be asked to complete a task within a certain block of time. Then, once the time alloted has ended, a fellow will be randomly selected by the instructor, and asked to complete the task in front of the class.

We are tasked to complete this challenge within 3 (three) hours.

The tasks are as follows:
### Open a new Android Studio Project (5 Minutes)
Open up a new Android Studio Project, using an Empty Activity that implements `SearchView.OnQueryTextListener`

### Make data model class(es) based on the JSON Endpoint (10 Minutes)
Evaluate the JSON, then form one or more data model classes based on the JSON

### Create Singleton Class for Retrofit Instance (10 Minutes)
Create a Singleton class using the Static Factory Method design pattern, to contain a unique single instance of the Retrofit class.

### Create Retrofit Service Interface (15 Minutes)
Create an Interface for a Retrofit service, adding methods for creating get requests that include the path that comes after the base url.

### Make a Retrofit Get Request, then use the Response (15 Minutes)
Make a request to the JSON endpoint, then receive the data from the response body.

### Make a RecyclerView ViewHolder class (15 Minutes)
Make a class that subclasses ViewHolder, and compose an itemview layout to display the city and state in a single textview.

### Make a RecyclerView Adapter class (15 Minutes)
Make a class that subclasses Adapter, and compose an itemview layout to display the city and state in a single textview.

### Complete the Activity Layout (15 Minutes)
Complete the activity xml layout, which should include both the SearchView and the RecyclerView.

### Override the appropriate interface methods (15 Minutes)
Override both `public boolean onQueryTextSubmit(String s)` and `public boolean onQueryTextChange(String s)`, and add filtering logic to the most effective callback method.

### Set the SearchView's `setOnQueryTextListener` (5 minutes)
Set the SearchView's `setOnQueryTextListener` to the activity's context.

### Add a `setData()` method to your RecyclerView Adapter Class (10 minutes)
Add a method that will update the RecyclerView adapter with a new list of data whenever it is called.

### BONUS: Sort your list by Capital City Name
Sort your JSON list alphabetically by capital city name, before passing it into the RecyclerView Adapter.

## Exercises
Push this project to Github, then submit the link to the exercises page on the canvas calendar for today's date.
