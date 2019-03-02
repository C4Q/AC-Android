# Unit 04 Assessment Postmortem

## Objectives
* Fellows will learn to complete the requirements of each task within the Unit 04 Final Assessment
* Fellows will figure out what they got wrong, and complete the assessment again **IN A NEW REPO AS A NEW PROJECT**

## Resources
* All of [Unit 02](https://github.com/joinpursuit/Pursuit-Core-Android/tree/master/cohort_5.4/unit_02), [Unit 03](https://github.com/joinpursuit/Pursuit-Core-Android/tree/master/cohort_5.4/unit_03), and [Unit 04](https://github.com/joinpursuit/Pursuit-Core-Android/tree/master/cohort_5.4/unit_04)

# Lecture

### What is a Postmortem?

Wikipedia describes a postmortem as:

*"A project post-mortem is a process, usually performed at the conclusion of a project, to determine and analyze elements of the project that were successful or unsuccessful... Project post-mortems are intended to inform process improvements which mitigate future risks and to promote iterative best practices."*

In class today, we will do the same. A fellow will be called, one-by-one, to come up and complete the task. Then, after each turn, the class will discuss whether the fellow completed the task correctly, or if their task will need improvement. However, all comments must be followed by a contribution of actual solution code.

These were the steps of the Unit 04 Assessment:

1. Create an Android Studio Project called **"Unit_04_Assessment"** with an activity called `MainActivity`

2. Make a `Retrofit` call to the following JSON endpoint using a Singleton Static Factory Instance for the base url, and a service with a `@GET` method for the rest of the url: [echinoderms.json](https://raw.githubusercontent.com/JDVila/storybook/master/echinoderms.json). Add the list response to a `RecyclerView` Adapter

3. Make an itemview in the `ViewHolder` that displays an image to the left using `Picasso`, and the title to the right using a `TextView`

4. Create an activity called `SecondActivity`, with a Container layout that fills the screen of the host Activity's layout

5. Make the itemview "clickable" - and when clicked, sends data with intent extras, and moves to the `SecondActivity`

6. Create a Fragment subclass called `DetailFragment`. Utilize a static factory instance method, with parameters that will take in the necessary `String` arguments

7. Create a listener `interface` within the Fragment called `OnFragmentInteractionListener`, with an abstract callback method called `onFragmentInteraction(String website)` that accepts a `String` as a parameter. In `SecondActivity`, implement the `OnFragmentInteractionListener`, and override the `onFragmentInteraction(String website)` method in this activity

8. Display the `DetailFragment` within the activity's host layout

9. In the `DetailFragment`, create a layout to display the animal name, the image using `Picasso`, and a button

10. Using the `onAttach()` Fragment lifecycle callback method, get the host activity's context (`SecondActivity`), cast it back to the type `OnFragmentInteractionListener`, and store it in a class field of type `OnFragmentInteractionListener`

11. When the button is clicked, it should call the `OnFragmentInteractionListener` interface listener's callback method `onFragmentInteraction(String website)` - add the website string to the listener callback method's parameter

12. In the `SecondActivity`, in the overridden method `onFragmentInteraction(String website)`, create an implicit intent that will open up a browser that can display the wikipedia website link from the given URL

## Exercises

Complete the entire assessment on your own AS A NEW PROJECT, and push the project TO A BRAND NEW REMOTE REPOSITORY.

For each task - write a comment above every method, describing what each method is intended to do.

Visit today's date on the Canvas calendar to upload the link to your repo during submission.
