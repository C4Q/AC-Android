# JUnit Testing "App from Scratch"

## Objectives
* Fellows will attempt to follow steps within a mock coding challenge
* Fellows will demonstrate this step in front of the class with the instructor

## Resources
* [RecyclerView Review](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_02/02_20_recyclerview_review.md) 
* [Retrofit and JSON](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_03

# Lecture

Today we will build an "App From Scratch", for time. This "App from Scratch" will be quite unusual, in that the goal is to not create an actual app with a UI, but to create a class with methods, that can be tested with unit tests you will also create.

We are tasked to complete this challenge within 3 (three) hours.

The tasks are as follows:

### Open a new Android Studio Project (5 Minutes)
Open up a new Android Studio Project, using an Empty Activity

### Create a class called `StringManipulator.java` (5 Minutes)
Create a class called `StringManipulator.java`, as a class with a static factory method for creating singleton instances.

### Create a class called `StringManipulatorUnitTest.java` (5 Minutes)
Create a class called `StringManipulatorUnitTest.java`. Add a setup and teardown method to set up the test environment.

### Create a method called `isLessThan10(String input)` in `StringManipulator.java` (10 Minutes)
This method should:
* return a boolean value
* if the argument passed to the method is less than 10 characters in length, return `true`, otherwise return `false`

Create at least two tests in the `StringManipulatorUnitTest.java` class to confirm that this method runs as expected.

### Create a method called `isOddLength(String input)` in `StringManipulator.java` (10 Minutes)
This method should:
* return a boolean value
* if the argument passed to the method has an odd-numbered length, return `true`, otherwise return `false`

Create at least two tests in the `StringManipulatorUnitTest.java` class to confirm that this method runs as expected.



## Exercises
Push project to Github, then submit the link to the exercises page on the canvas calendar for today's date.
