- title: Enums and While Loops
- tags: java enums while loops

#Objectives
-Enums
-Write a While Loop
-How Android is built from Java

#Resources
-[Enum Types](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)
-[Activity Lifecycle](https://developer.android.com/training/basics/activity-lifecycle/starting.html)
-[Android Architecture](https://source.android.com/devices/)
-[Android Open Source Project](https://source.android.com/)

#Lecture
### Enums
Enums are used to represent constant values in code, that are related to each
other. Since our goal is to always write code that is self explanatory, enums
are a great tool for replacing magic numbers in code. For example, which is
easier to understand:

```java
// readGuest returns a number from System.in that represents a guest number
int input = readGuest();
switch (input) {
case 1:
  System.out.println("hello Tom");
	break;
case 2:
	System.out.println("hello Bob");
	break;
case 3:
	System.out.println("hello world");
	break;
default:
	System.out.println("I don't know this person");
}
```

compared to the following

```java
// Define an enum to represent our guests
enum Guest {
  TOM,
  BOB,
  THE_WORLD,
  UNKNOWN
}
```
```java
// readGuest returns a Guest that represents a number from System.in
Guest input = readGuest();
switch (input) {
case TOM:
  System.out.println("hello Tom");
	break;
case BOB:
	System.out.println("hello Bob");
	break;
case THE_WORLD:
	System.out.println("hello world");
	break;
default:
	System.out.println("Can't say hello that many times");
}
```

Enums can not be defined within functions. They are often used to describe nouns
or states in a code base.

### Exercises
> **Exercise:** Write an enum class named Operations for all the functions in a
calculator (addition, subtraction, division, multiplication).
> **Exercise:** Write four if statements that compares an input against each
Operation value. Leave the body of the if statement empty.
> **Exercise:** Write a switch statement that compares an input against each
Operation value. For each operation, print out its Operation name.

## While loops

* _loop_ - code that is run over and over again

Java's simplest loop construct is the `while` statement.  It looks like this:

```java
while (condition) {
  // do something over and over
}
```

As with an `if` statement, the `condition` is a boolean expression.  The code that runs over and over again is the _body_ of the loop.  Before the first and every subsequent iteration, Java evaluates the condition; if it comes out false, the loop ends and Java continues with the following code.  Note that if the condition initially evaluates false, the loop body is never evaluated.

As with `if`, you can leave out the curly braces if the body contains a single statement.

> **Exercise:** Write a program that tracks how many M&Ms you have left, as you eat them.  It should look like this:
>
> ```
> 100 M&Ms left
> eat how many? 20
> 80 M&Ms left
> eat how many? 60
> 20 M&Ms left
> eat how many? 18
> 2 M&Ms left
> eat how many? 2
> you ate all the M&Ms
> ```

> **Exercise:** [harder] Make sure you can't eat more M&Ms than you have left.

Using a while loop, we can count.

```java
int count = 0;
while (count < 10) {
    System.out.println(count);
    count = count + 1;
}
```

What happens if we switch the order of the two statements in the loop body?

> **Exercise:** Change this to count _down_ from 10.  The last number should be 1.
>
> **Exercise:** [harder] Change this to count down from 100 to 10 by 5, and then from 9 to 1.  The numbers it prints should be 100, 95, 90, ..., 20, 15, 10, 9, 8, ..., 2, 1.  At the end, print "blastoff".

A statement like `count = count - 5` is so common that Java gives us a shorter form: `count -= 5`.   Likewise for `+=`, `*=`, _etc_.


#### break

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

> **Exercise:** http://programmingbydoing.com/a/keep-guessing.html
>
> Use `break` to end the game when the player guesses correctly.
>
> For this program to be fun, you'll have to generate a random number between 1 and 10 (inclusive).  Here's how to do it:
>
> ```java
> Random random = new Random();
> int number = random.nextInt(10) + 1;
> ```

> **Exercise:** Change your program so that it doesn't use `break`.  Instead use a boolean variable that is false until the player guesses the number correctly.

> **Exercise:** [harder] Change the program to pick a random number between 1 and 1000.  Play it a few times.  What's the best strategy to guess the random number as quickly as possible?

> **Exercise:** http://programmingbydoing.com/a/adding-values-in-a-loop.html

### How Android is built from Java
Java is a programming language that can be used to build any program a
developer conceives of. Android is a collection of applications and interfaces,
referred to as a stack, that allow Java programs to interact with hardware.

Programs that mediate interaction with physical hardware are called operating
systems. Most people are familiar with Windows from Microsoft and iOS from
Apple, but the number one used operating system in the world is Linux, an open
source operating system created and maintained by Linus Torvalds. Linux is
the operating system that most routers, internet and corporate servers run.
Linux is a favorite with developers because the source code is freely available.
Windows and iOS do not give access to their source code.

Android is based off of the Linux operating system, and any device running
Android is also running Linux. Android is a collection of java classes and
programs that communicate with the Linux operating system running on the device.
Android is also open source, and that source code is maintained by the Android
Open Source Project (AOSP), a collaboration of companies that contribute to the
source.

Most people are familiar with Google's version of Android, which is a fork of
the AOSP codebase. Google modifies the code to add in extra services, including
the Play Store and Google Maps. This version of the code is then sent to mobile
carriers such as Verizon or AT&T, who modify the code to add in carrier specific
applications and services. This carrier version of the code is eventually loaded
onto the phones you can buy in Best Buy. Because the code is open source, it is
possible for any programmer to build a hardware device, including a cell plhone,
and run the AOSP code, as long as the hardware meets required specifications.

The same way Android is built out of Java classes, any Java developer can build
a system as complicated. Nor must one choose Java as the language to design it
in. Many programming languages exist, each one expressing logic in a different
pattern. Learning a different programming language will often teach you to think
about code in a new way.
