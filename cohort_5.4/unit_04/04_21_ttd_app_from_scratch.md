# JUnit Test-Driven Development "App from Scratch"

## Objectives
* Fellows will attempt to follow steps within a mock coding challenge
* Fellows will demonstrate this step in front of the class with the instructor

## Resources
* [Unit Testing in Android](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_02/02_08_app_testing.md)
* [JUnit Testing Revisited](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_13_junit_testing_revisited_creating_tests.md)

# Lecture

Today we will build an "App From Scratch", for time. This "App from Scratch" will consist of tasks with which you are quite familiar - writing unit tests, using the concept of "Test-Driven Development."

Essentially:

* You will be given an idea for a non-void method which is expected to complete a single task
* This idea should then lead you to creating a method signature with (a) parameter(s), a return type, and an empty method body
* You will then plan out expected outputs for expected inputs
* you will create tests which will assert that certain inputs will provide expected outputs
* you will write a test for every expectation you wish to test
* you will then fill the method body of the method you wish to create with code that will hopefully pass your tests
* you will run your tests
* if all of your tests pass, you rejoice!
* if any of your tests fail, you refactor the method you created until the test(s) pass
* once all your tests pass, you move on to creating the next method

We are tasked to complete this challenge within 3 (three) hours.

The tasks are as follows:

### Open a new Android Studio Project (5 Minutes)
Open up a new Android Studio Project, using an Empty Activity

### Create a class called `ArrayMethodTesting.java` (5 Minutes)
Create a class called `ArrayMethodTesting.java`, as a class with a static factory method for creating singleton instances.

### Create a class called `ArrayMethodTestingTest.java` (5 Minutes)
Create a class called `ArrayMethodTestingTest.java`. Add a setup and teardown method to set up the test environment.

### Create a method called `isLessThan10(String[] input)` in `ArrayMethodTesting.java` (10 Minutes)
This method should:
* return a `boolean` value
* if the argument passed to the method is less than 10 elements in length, return `true`, otherwise return `false`

Add as many tests that you can think of to confirm that the expected output is returned, based on the input, in `ArrayMethodTestingTest.java`.

### Create a method called `smallEvensOnly(String[] input)` in `ArrayMethodTesting.java` (10 Minutes)
This method should:
* return a `String[]` value
* if the argument passed to the method has an even-numbered length, remove the `String` with the longest length
* return a new `String[]` with the expected values

Add as many tests that you can think of to confirm that the expected output is returned, based on the input, in `ArrayMethodTestingTest.java`.

### Create a method called `sortAlphabetically(char[] input)` in `ArrayMethodTesting.java` (10 Minutes)
This method should:
* return a `char[]` value
* return a new `char[]` with the expected values

Add as many tests that you can think of to confirm that the expected output is returned, based on the input, in `ArrayMethodTestingTest.java`.

### Create a method called `returnSum(double[] input)` in `ArrayMethodTesting.java` (10 Minutes)
This method should:
* return a `double` value
* return the sum of all the decimal numbers in the `input` array

Add as many tests that you can think of to confirm that the expected output is returned, based on the input, in `ArrayMethodTestingTest.java`.

### Create a method called `returnSum(double[] input)` in `ArrayMethodTesting.java` (10 Minutes)
This method should:
* return a `double` value
* return the sum of all the decimal numbers in the `input` array

Add as many tests that you can think of to confirm that the expected output is returned, based on the input, in `ArrayMethodTestingTest.java`.

### Create a method called `removeCaseSensitiveDuplicates(String[] input)` in `ArrayMethodTesting.java` (10 Minutes)
This method should:
* return a `Set` value
* return a set of only unique items in the `input` array
* if at least one version of the string from the array exists in the set (uppercase, lowercase, proper case, camel case, etc.), it is not unique, please don't add it to the set

Add as many tests that you can think of to confirm that the expected output is returned, based on the input, in `ArrayMethodTestingTest.java`.

### Create a method called `mapDuplicates(String[] input)` in `ArrayMethodTesting.java` (10 Minutes)
This method should:
* return a `Map` value
* return the `Map` containing every element of the array as the key, and the number of times it occurs in the array as its value

Add as many tests that you can think of to confirm that the expected output is returned, based on the input, in `ArrayMethodTestingTest.java`.

## Exercises
Push project to Github, then submit the link to the exercises page on the canvas calendar for today's date.
