# JUnit Testing "App from Scratch" (Part Deux!)

## Objectives
* Fellows will attempt to follow steps within a mock coding challenge
* Fellows will demonstrate this step in front of the class with the instructor

## Resources
* [Unit Testing in Android](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_02/02_08_app_testing.md)
* [JUnit Testing Revisited](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_13_junit_testing_revisited_creating_tests.md)

# Lecture

Today we will build an "App From Scratch", for time. This "App from Scratch" will be similar to yesterday's project, in that the goal is to not create an actual app with a UI, but to create a class with methods, that can be tested with unit tests you will also create. However, the methods will focus not on Strings, but on numbers and arrays.

We are tasked to complete this challenge within 3 (three) hours.

The tasks are as follows:

### Open a new Android Studio Project (5 Minutes)
Open up a new Android Studio Project, using an Empty Activity

### Create a class called `NumberHelper.java` (5 Minutes)
Create a class called `NumberHelper.java`, as a class with a static factory method for creating singleton instances.

### Create a class called `NumberHelperUnitTest.java` (5 Minutes)
Create a class called `NumberHelperUnitTest.java`. Add a setup and teardown method to set up the test environment.

### Create a method called `oddOrEven(int input)` in `NumberHelper.java` (10 Minutes)
This method should:
* return a `String` value
* if the argument passed to the method is an even number, return `even`, otherwise return `odd`

Create at least two tests in the `NumberHelperUnitTest.java` class to confirm that this method runs as expected.

### Create a method called `divisibleBy5(int input)` in `NumberHelper.java` (10 Minutes)
This method should:
* return a `boolean` value
* if the argument passed to the method is divisible by the number 5, return `true`, otherwise return `false`

Create at least two tests in the `NumberHelperUnitTest.java` class to confirm that this method runs as expected.

### Create a method called `multiplesOfN(int baseNumber, int range)` in `NumberHelper.java` (10 Minutes)
This method should:
* return an `int[]` array value
* return an `int[]` that consists of the multiples of the base number, up to the number given in the `range` value, i.e. if the number in the baseNumber parameter is `3`, and the range is `10`, then the output should be:
```
int[]{3, 6, 9, 12, 15, 18, 21, 24, 27, 30}
```

Create at least one test in the `NumberHelperUnitTest.java` class to confirm that this method runs as expected.

### Create a method called `stringToNumber(String number)` in `NumberHelper.java` (10 Minutes)
This method should:
* return an `int` value
* return an `int` that grabs the int value from a String, i.e. - `stringToNumber("5")` should return `5`

Create at least one test in the `NumberHelperUnitTest.java` class to confirm that this method runs as expected, and handles all exceptions.

### Create a method called `arraySum(int[] numbers)` in `NumberHelper.java` (10 Minutes)
This method should:
* return an `int` value
* return the value of the sum of all the elements in the array combined

Create at least one test in the `NumberHelperUnitTest.java` class to confirm that this method runs as expected.

### Create a method called `largestNumber(int[] numbers)` in `NumberHelper.java` (10 Minutes)
This method should:
* return an `int` value
* return the largest number in the `int` array 

Create at least one test in the `NumberHelperUnitTest.java` class to confirm that this method runs as expected.

### Create a method called `numberSort(int[] numbers)` in `NumberHelper.java` (10 Minutes)
This method should:
* return an `int[]` array
* return the contents of the original array, but sorted by size from smallest to largest

Create at least one test in the `NumberHelperUnitTest.java` class to confirm that this method runs as expected.

## Exercises
Push project to Github, then submit the link to the exercises page on the canvas calendar for today's date.
