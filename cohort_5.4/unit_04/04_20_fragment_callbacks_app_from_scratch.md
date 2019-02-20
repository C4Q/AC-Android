# Fragments "App From Scratch"

## Objectives
* Fellows will attempt to follow steps within a mock coding challenge
* Fellows will demonstrate this step in front of the class with the instructor

## Resources
* [Intro to Fragments](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_03_intro_to_fragments.md)
* [Fragments and Fragment Transactions](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_04_fragments_and_fragment_transactions.md)
* [Fragment Lifecycle and Communications](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_05_fragment_lifecycle_and_communications.md)
* [Fragments Review](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_06_fragments_review.md)
* [Creating Custom Listeners](https://guides.codepath.com/android/Creating-Custom-Listeners)
* [Fragment Callback Communication Revisited](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_19_fragment_callback_communication_revisited.md)

# Lecture

Today we will build an "App From Scratch", for time. The goal of today's lesson is to 
build an app from scratch that instantiates and communicates between Fragments, using interface callback methods:
* Create a Fragment that holds an interface for a listener
* Implement that listener in your MainActivity
* Pass data with a click event through the listener, back to the activity
* Create a Fragment with a static factory method for arguments
* Switch to that new Fragment, using the data received by the interface method, and pass data along

We are tasked to complete this challenge within 3 (three) hours.

The tasks are as follows:
### Open a new Android Studio Project (5 Minutes)
Open up a new Android Studio Project, using an Empty Activity

### Make a MainActivity with a Container Layout (5 Minutes)
Make a new activity that acts as an intermediary between two or more fragments.

### Create an Input Fragment with 3 (three) EditTexts and a Button (15 Minutes)
Add the views, and override the attach/detach methods.

### Add an inner public interface to the Input Fragment (5 Minutes)
Create an interface class for the listener, and add an abstract method for passing data between the fragment and the activity.

### Have the MainActivity implement the Fragment's Interface (10 Minutes)
Have the MainActivity implement the Fragment's Interface, then override the interface's abstract method.

### Grab the activity from the `onAttach()` callback, and store it in the Fragment as a listener object (10 Minutes)
Assign the context (after casting it) to a listener variable. Clean up the reference in the `onDetach()` method.

### Pass data from the EditTexts to the fragment listener, based on the onClick action (10 Minutes)
When the button is clicked, move data from the fragment, to the activity.

### Create a new DisplayFragment class to display the 3 (three) Strings in the form of a fun sentence (15 Minutes)
Create a new fragment class to display a sentence consisting of strings from the previous fragment.

### Swap the first fragment with the second fragment (15 Minutes)
Swap the first fragment with the second fragment, passing the Strings from the Activity to the Fragment, using the second fragments static facorty method.

## Exercises
Push this project to Github, then submit the link to the exercises page on the cnvas calendar for today's date.
