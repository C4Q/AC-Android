# Week 1 Review
- tags: java, if, else, switch, while, for, scanner

## Objectives

* Review reading input from command line
* Review declaring static methods
* Solve If Else Problems
* Solve Switch Statement Problems
* Solve While Loop Problems
* Pair Programming

## Resources

* [Java coding in browser](https://repl.it/languages/java)
* [Control Flow Tutorial](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html)
* [Java Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html)
* [Boolean Logic](http://codingbat.com/doc/java-if-boolean-logic.html)

# Lecture
### Input

Previously, we learned how to print. Remember the syntax?

```java
System.out.println("I am printing a line!");
```

But just printing gets a bit boring. Today, we're going to review how to ask the user for feedback. In programming, we call this *reading user input*. Let's talk about how.

### Scanner

In Java, a simple program that reads user input can look like this:

```java
import java.util.Scanner;

public class Echo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Say something:");
        String something = input.next();
        System.out.println(something);
    }
}
```

First, we *import* the ```Scanner```, meaning we tell the Java compiler to include some code written by another developer. 

```java
import java.util.Scanner;
```

Then to create a new `Scanner`, we type:

```java
Scanner input = new Scanner(System.in);
```

Don't worry if you don't know exactly what this does. Think of this like driving: you don't need to know how a car engine works in order to drive a car. In programming, we call this *abstraction*. We don't care *how* the `Scanner` works, but we know what it *does*. What can you do with a `Scanner`?

### Functions

The ```Scanner``` gives you the programmer some magical powers called *functions*. A function, like the gas and break pedals on a car, allows you to interact with the `Scanner`. For example, we can ask the `Scanner` to ask the user for an `int` like this:

```java
int usersAge = input.nextInt();
```

Functions in Java are called **Methods**.

[This page](http://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html) has a full list of `Scanner` functions.

Let's go through the first exercise together.

#### Mid-Lecture Exercise: [Asking Questions](http://programmingbydoing.com/a/asking-questions.html)
For this exercise, we will ask the user a number of questions back-to-back, store their answers in variables, and print their answers back to them. Follow the link above for more information.

Now try to use the `Scanner` yourself!

## Methods

Let's review **Methods** in Java - how they are declared, how they accept arguments into their parameters (if any), and the return types of the values they return.

When you create a method declaration - the first step is to determine its return type. If you want to write a method which runs a block of code when it is called, but returns nothing, we can write something like this:

```java
void returnNothing() {
    System.out.println("This prints to the screen, but returns nothing else after it is called.");
}
```
The ```void``` keyword lets the compiler know that when this method is called, and finishes running the code in its code block, it will not ```return``` a value to whatever code block the method was originally called.

If we want our method to both ***DO*** something **AND** return a value of a specific type, then we will use a return type other than ```void```:

```java
boolean returnBoolean() {
    System.out.println("This prints to the screen, but it will also RETURN a boolean value after it is called.");
    return true;
}

```

Now, you might have noticed that if you placed these methods in the ```class``` **Main** in repl.it, then try to call them from within the curly braces of the ```public static void main(String[] args)``` method, you will get an error, probably something like this:

<img src="https://github.com/C4Q/AC-Android/blob/master/lessons/week-1-review/images/non_static_context.PNG" alt="non-static context error" style="width:250px;height:316px;">

Yikes! That looks scary! However, the compiler is trying to help you! We will talk about the difference between static and non-static methods and variables at a later date. Just know that if you are trying to call a method inside another method with the keyword ```static``` in its declaration, the method you are calling should also be static. There are ways around this (instantiation, etc.), and we will explore them in the near future.

So, let's refactor (modify) our method a bit to add the keyword ```static```, so that it will run as expected:

```java
static void returnNothing() {
    System.out.println("This prints to the screen, but returns nothing else after it is called.");
}
```

<!--

**Ground Rules for Exercises**

- Don't just copy and paste! Programming, like playing an instrument or speaking another language, requires muscle memory. It is important that you get used to *typing* Java for yourself. Also, you will notice things you would not otherwise if you are forced to type them.
- At the top of every exercise, write a *document comment*. A document comment is description of the program for another user (or your future self). Get used to documenting your work! Here is an example document comment for the previous exercise:

```java
    /**
     * Access Code 4.3
     * Jamie Ramirez-Khan
     * AskingQuestions.java
     * This class prompts the user for some personal data and then repeats it back to them.
     */
```

- After every exercise, commit your work to GitHub!

--->

## If Else Problems

#### Exercise 01: [Forgetful Machine](http://programmingbydoing.com/a/the-forgetful-machine.html)
For this exercise, we will ask the user for two words and two numbers, and let the person at the keyboard type in some values, but we will not be storing their responses into any variables. Follow the link above for more information.

#### Exercise 02: [What If?](http://programmingbydoing.com/a/what-if.html)
For this exercise, we will refactor (modify) the code in the link above to print the correct results. Follow the link above for more information.

## Switch Statement Problems

#### Exercise 03: "Big Number, Small Number"
Write a ```switch``` statement that checks an integer read from ```System.in```. If the integer is greater than five, print "Big Number". Otherwise, print "Small Number".

#### Exercise 04: "Really Big Number"
Write a ```switch``` statement that checks an integer read from ```System.in```. If the integer is greater than five, print "Big Number". If the integer is greater than five and nine, print "Really Big Number" Otherwise, print "Small Number".

## While Loop Problems

#### Exercise 05: "Saw 99!"
Write a ```while``` loop that continuously reads integers from ```System.in```, until it reads 99. After reading 99, the code should print "Saw 99".

#### Exercise 06: "Saw 99, And Other Numbers Too!"
Write a ```while``` loop that continuously reads integers from ```System.in```, until it reads 99. After reading 99, the code should print "Saw 99". Until 99 is read, if the input number is less than 50, the code should print "Small Number". If the input number is greater than 50, the code should print "Large Number".

## Pair Programming While Loops

#### Exercise 07: "Secret Number"
Write a ```while``` loop that continuously reads integers from ```System.in```, until it reads and matches a "secret number" from a variable you created and stored within your code. Until the "secret number" matches the number entered by the user, the code should print "Please try again!", and request a new ```int``` from ```System.in```. If the values do match, the loop should stop running, and the code should print "You just guessed the secret number!".








<!---In this project, we are going to build a typewriter. The keys of the typewriter
will be represented by an enum class.
```java
public enum Keyboard_Keys {
  NEWLINE,
  SPACE,
  A,
  B,
  C,
  D,
  E,...
```

The typewriter we are building has 28 keys. 26 capital letters, plus a NEWLINE
and SPACE key. The NEWLINE key represents an ascii "\n", and the SPACE key will
represent a single space, " ".

Your assignment is to write a function that will be called repeatedly with a
single Keyboard_Keys parameter. For each of invocation, your function should
either print the capital letter corresponding to the Keyboard_Keys alphabet, a
newline character for NEWLINE, and a single space for SPACE.

We will test your program by having it write out a sentence. For example calling
your function with the inputs

```java
A, SPACE, D, O, NEWLINE, G
```

Should result in the output
```java
A DO
G
```

* Be sure to look at the functions of Enums and Strings to use as many built
in functions as possible. Instructors were able to solve this problem with 17
lines of code.--->
