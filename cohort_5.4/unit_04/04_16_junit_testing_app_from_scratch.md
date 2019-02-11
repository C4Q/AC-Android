# JUnit Testing "App from Scratch"

## Objectives
* Fellows will attempt to follow steps within a mock coding challenge
* Fellows will demonstrate this step in front of the class with the instructor

## Resources
* [Unit Testing in Android](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_02/02_08_app_testing.md)
* [JUnit Testing Revisited](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_13_junit_testing_revisited_creating_tests.md)

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
* return a `boolean` value
* if the argument passed to the method is less than 10 characters in length, return `true`, otherwise return `false`

Create at least two tests in the `StringManipulatorUnitTest.java` class to confirm that this method runs as expected.

### Create a method called `isOddLength(String input)` in `StringManipulator.java` (10 Minutes)
This method should:
* return a `boolean` value
* if the argument passed to the method has an odd-numbered length, return `true`, otherwise return `false`

Create at least two tests in the `StringManipulatorUnitTest.java` class to confirm that this method runs as expected.

### Create a method called `zipperWords(String first, String second)` in `StringManipulator.java` (10 Minutes)
This method should:
* return a `String` value
* return a `String` that consists of the characters from both parameters "zippered" together, i.e. - the words `apple` and `orange` should be zippered into `aoprpalngee`
* add the remainder of the longest word to the end of the newly zippered word

Create at least one test in the `StringManipulatorUnitTest.java` class to confirm that this method runs as expected.

### Create a method called `deconstructedWord(String word)` in `StringManipulator.java` (10 Minutes)
This method should:
* return a `String` value
* return a `String` that consists of the characters from both parameters separated by whether they are either vowels or consonants, i.e. - the word `goodbye` should be separated into `gdby ooe`

Create at least one test in the `StringManipulatorUnitTest.java` class to confirm that this method runs as expected.

### Create a method called `wordSum(String first, String second)` in `StringManipulator.java` (10 Minutes)
This method should:
* return an `int` value
* return the sum of the lengths of both strings passed as arguments

Create at least one test in the `StringManipulatorUnitTest.java` class to confirm that this method runs as expected.

### Create a method called `longestWord(String[] words)` in `StringManipulator.java` (10 Minutes)
This method should:
* return a `String` value
* return the word with the longest number of characters in the `String` array 

Create at least one test in the `StringManipulatorUnitTest.java` class to confirm that this method runs as expected.

### Create a method called `wordSort(String[] words)` in `StringManipulator.java` (10 Minutes)
This method should:
* return a `String[]` array
* return the contents of the original array, but sorted by length from smallest to largest

Create at least one test in the `StringManipulatorUnitTest.java` class to confirm that this method runs as expected.

## Exercises
Push project to Github, then submit the link to the exercises page on the canvas calendar for today's date.
