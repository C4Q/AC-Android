- title: Week 1 Review
- tags: java if else switch while enums for

#Objectives

* Solve If Else Problems
* Solve Switch Statement Problems
* Solve While Loop Problems
* Pair Programming

#Resources

* [Java coding in browser](https://repl.it/languages/java)
* [Control Flow Tutorial](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html)
* [Java Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html)
* [Boolean Logic](http://codingbat.com/doc/java-if-boolean-logic.html)

# Lecture
Input
=

Previously, we learned how to print. Remember the syntax?

    System.out.println("I am printing a line!");

But just printing gets a bit boring. Today, we're going to learn how to ask the user for feedback. In programming, we call this *reading user input*. Let's talk about how.

**Scanner**

In Java, a simple program that reads user input looks like this:

    import java.util.Scanner;

    public class Echo {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("Say something:");
            String something = input.next();
            System.out.println(something);
        }
    }

First, we *import the `Scanner`*, meaning we tell the Java compiler to include some code written by another developer. Then to create a new `Scanner`, we type:

    Scanner input = new Scanner(System.in);

Don't worry if you don't know exactly what this does. Think of this like driving: you don't need to know how a car engine works in order to drive a car. In programming, we call this *abstraction*. We don't care *how* the `Scanner` works, but we know what it *does*. What can you do with a `Scanner`?

**Functions**

The `Scanner` gives you the programmer some magical powers called *functions*. A function, like the gas and break pedals on a car, allows you to interact with the `Scanner`. For example, we can ask the `Scanner` to ask the user for an `int` like this:

    int usersAge = input.nextInt();

[This page](http://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html) has a full list of `Scanner` functions.

Let's go through the first exercise together.

> **Exercise:** [Asking Questions](http://programmingbydoing.com/a/asking-questions.html)

Now try to use the `Scanner` yourself, but first...

**Ground Rules for Exercises**

- Don't just copy and paste! Programming, like playing an instrument or speaking another language, requires muscle memory. It is important that you get used to *typing* Java for yourself. Also, you will notice things you would not otherwise if you are forced to type them.
- At the top of every exercise, write a *document comment*. A document comment is description of the program for another user (or your future self). Get used to documenting your work! Here is an example document comment for the previous exercise:

```
    /**
     * Access Code 2.1
     * Gregory Gundersen
     * AskingQuestions.java
     * This class prompts the user for some personal data and then repeats it back to them.
     */
```

- After every exercise, commit your work to GitHub!
## If Else Problems

> **Exercise:** [Forgetful Machine](http://programmingbydoing.com/a/the-forgetful-machine.html)
> **Exercise:** [What if](http://programmingbydoing.com/a/what-if.html)

## Switch Statement Problems
> **Exercise:**  Write a switch statement that checks an integer read from
System.in. If the integer is greater than five, print "Big Number". Otherwise,
print "Small Number"
> **Exercise:**   Write a switch statement that checks an integer read from
System.in. If the integer is greater than five, print "Big Number". If the
integer is greater than five and 9, print "Really Big Number" Otherwise,
print "Small Number";

## While Loop Problems
> **Exercise:**   Write a while loop that continuously reads integers from
System.in, until it reads 99. After reading 99, the code should print "Saw 99".

> **Exercise:**   Write a while loop that continuously reads integers from
System.in, until it reads 99. After reading 99, the code should print "Saw 99".
Until 99 is read, if the input number is less than 50, the code should print
"Small Number". If the input number is greater than 50, the code should print
"Large Number".

## Pair Programming While loops

In this project, we are going to build a typewriter. The keys of the typewriter
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
lines of code.
