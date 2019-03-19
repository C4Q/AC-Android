# ViewPager "App From Scratch"

# Fragments "App From Scratch"

## Objectives
* Fellows will attempt to follow steps within a mock coding challenge
* Fellows will demonstrate this step in front of the class with the instructor

## Resources
* [Retrofit and JSON](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_03/03_12_retrofit_and_json.md)
* [Fragments](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_04_fragments_and_fragment_transactions.md)
* [ViewPager](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_05/05_08_viewpager.md)

# Lecture

Today we will build an "App From Scratch", for time. The goal of today's lesson is to implement a ViewPager based on JSON input:
* Connect to JSON endpoint using Retrofit
* Create a Fragment to display data from the JSON
* Create a list of Fragments initialized with data using a static factory method
* Pass the list to a ViewPager Adapter
* Display the fragments within a ViewPager

The JSON Endpoint we will be working with today [can be found here](https://raw.githubusercontent.com/JDVila/storybook/master/zodiac.json). First you will be asked to complete a task within a certain block of time. Then, once the time alloted has ended, a fellow will be randomly selected by the instructor, and asked to complete the task in front of the class.

We are tasked to complete this challenge within 3 (three) hours.

The tasks are as follows:
### Open a new Android Studio Project (5 Minutes)
Open up a new Android Studio Project, using an Empty Activity that extends from `FragmentActivity`

### Make data model class(es) based on the JSON Endpoint (10 Minutes)
Evaluate the JSON, then form one or more data model classes based on the JSON

### Create Singleton Class for Retrofit Instance (10 Minutes)
Create a Singleton class using the Static Factory Method design pattern, to contain a unique single instance of the Retrofit class.

### Create Retrofit Service Interface (15 Minutes)
Create an Interface for a Retrofit service, adding methods for creating get requests that include the path that comes after the base url.

### Make a Retrofit Get Request, then use the Response (15 Minutes)
Make a request to the JSON endpoint, then receive the data from the response body.

### Create a Fragment with a static factory instance method, that will display data into views (15 Minutes)
Create a Fragment class, which references the views declared in an ItemView XML Layout.

### Subclass a ViewPager Adapter Class (15 Minutes)
Create an Adapter class, that extends `FragmentPagerAdapter`, which overrides all inherited methods, holds a list, and accepts a FragmentManager, and a list in its constructor.

### Create a list of Fragments with data from the Retrofit Response (15 Minutes)
Create a list of Fragments with parameters received from the list received from the Retrofit Response.

### Add a ViewPager that fills the screen, and populate it with fragments from the Fragment List (15 Minutes)
Add a ViewPager widget, and set an adapter, with the list of fragments in it.

## Exercises
Push this project to Github, then submit the link to the exercises page on the canvas calendar for today's date.
