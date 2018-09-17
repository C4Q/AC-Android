# While Loops

## Objectives
* Write a While Loop
* Write a Do-While Loop

## Resources

### While Loops
* [Video: While Loops](https://www.youtube.com/watch?v=vnAYHVwrO4c)
* [Tutorial: Loop Control](https://www.tutorialspoint.com/java/java_loop_control.htm)
* [Tutorial: While Loops](https://www.tutorialspoint.com/java/java_while_loop.htm)
* [Tutorial: Do-While Loops](https://www.tutorialspoint.com/java/java_do_while_loop.htm)

## Warm Up

Let's review Strings! As we've seen before, if we want to declare and initialize a String variable by assigning it a value, we can do something like this:

```java
String musician = "Louis Armstrong";
```

If we wanted to get the value of that String variable, we could simply reference the variable somehow, or use it in another method or variable, like this:

```java
System.out.println(musician);
```

But what if we wanted to get just **ONE** of the letters, or _characters_ from the String, like the letter 'u'? What if we didn't even know what the character was, and we just wanted the third one in the String?

Strings are just collections of characters in a row - with each character located at a certain spot, or `index` of a String. Strings are `zero-indexed`, meaning the first character is said to be at index 0, the second character would be at index 1, the third character would be at index 2, and so on.

**Hint** - If you were to google "charAt() Java", that might be helpful....

# Lecture: While Loops

## Loops

A **loop** is a block of code that is run over and over again, with or without specific changes, as long as certain conditions are met.

## While loops

Java's simplest loop construct is the `while` statement.  It looks like this:

```java
while (condition) {
  // do something over and over
}
```

As with an `if` statement, the `condition` is a boolean expression.  The code that runs over and over again is the _body_ of the loop.  Before the first and every subsequent iteration, Java evaluates the condition; if it comes out false, the loop ends and Java continues with the following code.  Note that if the condition initially evaluates false, the loop body is never evaluated.

As with `if`, you can leave out the curly braces if the body contains a single statement. For example:
```java
// With curly braces
while(true) {
    System.out.println("This works!);
}
```
```java
// Without curly braces
while(true)
    System.out.println("This also works, but is not as easy to recognize!);
```
However, it is considered a best practice to include curly braces when creating code blocks, as it makes the intention of code much clearer for others to read.
<!--
#### Exercise 01: "M&M Tracker"
Write a program that tracks how many M&Ms you have left, as you eat them.  It should look like this:
```
100 M&Ms left
eat how many? 20
80 M&Ms left
eat how many? 60
20 M&Ms left
eat how many? 18
2 M&Ms left
eat how many? 2
you ate all the M&Ms
```

#### Exercise 02: "M&M Overdraft Protection" [harder] 

Make sure you can't eat more M&Ms than you have left.

--->

## Counting with Loops

Using a while loop, we can count.

```java
int count = 0;
while (count < 10) {
    System.out.println(count);
    count = count + 1;
}
```

What happens if we switch the order of the two statements in the loop body?

<!--

#### Exercise 03: "Countdown"
Change the code above from counting up to 10, to counting _down_ from 10. The last number should be 1.

#### Exercise 04: "Blastoff!" [harder]
Change this to count down from 100 to 10 by 5, and then from 9 to 1.  The numbers it prints should be 100, 95, 90, ..., 20, 15, 10, 9, 8, ..., 2, 1.  At the end, print "blastoff".

--->

### Incrementing and Decrementing
A statement like `count = count - 5` is so common that Java gives us a shorter form: `count -= 5`.   Likewise for `+=`, `*=`, _etc_.

### The ```break``` keyword
Java provides a special word that you can use only inside a loop: `break` says, Stop this loop right now!  So, we could count like this instead.

```java
int count = 0;
while (true) {
    System.out.println(count);
    count += 1;
    if (count > 10)
        break;
}
```

Generally, `while (true)` will cause the loop to run forever!  But we "break out" of it using the `break` statement.  

What are the first and last numbers this loop will print?

<!--

#### Exercise 05: [Keep Guessing](http://programmingbydoing.com/a/keep-guessing.html)
Use `break` to end the game when the player guesses correctly.

For this program to be fun, you'll have to generate a random number between 1 and 10 (inclusive).  Here's how to do it:

```java
Random random = new Random();
int number = random.nextInt(10) + 1;
```

#### Exercise 06: "Boolean Flag"
Change your program so that it doesn't use `break`.  Instead use a boolean variable that is false until the player guesses the number correctly.

#### Exercise 07: "Larger Random Range" [harder]
Change the program to pick a random number between 1 and 1000.  Play it a few times.  What's the best strategy to guess the random number as quickly as possible?

#### Exercise 08: [Adding Values in a Loop](http://programmingbydoing.com/a/adding-values-in-a-loop.html)
Write a program that gets several integers from the user. Sum up all the integers they give you. Stop looping when they enter a 0. Display the total at the end.

--->

## Do-While Loops

**Do-While** loops work much in the same way as a traditional ```while``` loop, except that **a do-while loop will run at least once, whether the condition is met or not**.

```java
// A traditional while loop: This code block will never run
while (false) {
    System.out.println("This will never print.");
}

// This will run at least once
do {
    System.out.println("This will print just once, and the while loop will not run, because its condition evaluates to false.");
} while(false);

// This will run at least once, then run as many times as the while condition allows
do {
    System.out.println("This will print at least once, followed by the while loop running over, and over, and over....");
} while(true);
```

## Next Steps: Accepting User Input

Until now, we have been using variables to manually store values within our programs. However, in order for our programs to grow in effectiveness, we need to add the option for our users to enter input.

Java programs can accept input from a variety of sources: Android views, websites, files, mouse clicks, servers, etc... - in this course, we will primarily accept input from users through the keyboard.

There are several ways to do this. The one we will introduce today, but use more often in the coming weeks, is with something called a Scanner object.

First, we *import* the ```Scanner```, meaning we tell the Java compiler to include some code written by another developer. 

```java
import java.util.Scanner;
```

Then to create a new `Scanner`, we type:

```java
Scanner input = new Scanner(System.in);
```

Don't worry if you don't know exactly what this does. Think of this like driving: you don't need to know how a car engine works in order to drive a car. In programming, we call this *abstraction*. We don't care *how* the `Scanner` works, but we know what it *does*. What can you do with a `Scanner`?

```java
Scanner scanner = new Scanner(System.in);
String name = scanner.next();
```

We will talk more about what a **Scanner** object is, and what the ```new``` keyword means in a later lecture. At this point, just know that this line of code will take a single word entered by the user on the keyboard, and after the user presses the ```enter``` key, the word will be saved as a ```String``` in the variable ```name```.

```scanner.next()``` isn't the only method, or function, associated with ```Scanner```:

|Method|Meaning|
|:----:|:------|
|\.next()|returns the 1st or next ```String``` without spaces after it|
|\.nextLine()|returns the entire ```String``` entered by a user|
|\.nextInt()|returns the 1st or next ```int``` value entered by a user|
|\.nextDouble()|returns the 1st or next ```double``` value entered by a user|
|\.nextBoolean()|returns the 1st or next ```boolean``` value entered by a user|
|**...and many, many more!**|You can find a complete list of all ```Scanner``` methods [here](https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html)|

### Functions

The ```Scanner``` gives you the programmer some magical powers called *functions*. A function, like the gas and break pedals on a car, allows you to interact with the `Scanner`. For example, we can ask the `Scanner` to ask the user for an `int` like this:

```java
int usersAge = input.nextInt();
```

Functions in Java are called **Methods**.

[This page](http://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html) has a full list of `Scanner` functions.

Let's go through the first exercise together.

#### Mid-Lecture Exercise: [Asking Questions](http://programmingbydoing.com/a/asking-questions.html)
For this exercise, we will ask the user a number of questions back-to-back, store thier answers in variables, and print their answers back to them. Follow the link above for more information.

Now try to use the `Scanner` yourself!

## Exercises

Please look at your Calendars to find and follow the link to the In-class exercises for today. We will work on the first two together as a class (M&M Questions), then work on our own, and eventually with each other, for the remainder of the questions.
