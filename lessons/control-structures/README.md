- title: Control Structures
- tags: java if else switch

#Standards:

#Objectives

-Write an If statement
-Write an If - Else statement
-Write a Switch statement
-Enums
-The relationship between Java and Android

#Resources
-[Java coding in browser](https://repl.it/languages/java)
-[Control Flow Tutorial](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html)
-[Java Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html)
-[Activity Lifecycle](https://developer.android.com/training/basics/activity-lifecycle/starting.html)

# Lecture

## Control structures
Programming requires telling a computer to make decisions based on inputs. There
are several ways to direct the flow of a program, using control structures. The
simplest is the if statement.

## If Statement
```java
if (BOOLEAN_CONDITION) {
  // do something
}
```
An if statement needs a boolean condition to operate. If that expression
evaluates to true, then the code within the if block will run. Otherwise, the
code within the block is skipped, and the program will continue.

```java
boolean alwaysTrue = true;
if (alwaysTrue) {
  System.out.println("This code always runs");
}
System.out.println("Then this code runs");
```

An if statement will evaluate code within the parenthesis. The statement must
return a true or false value;

```java
// Read input returns an integer read from System.in
int input = readInput();
if (input > 9) {
  System.out.println("A number greater than 9");
}
```
```java
boolean alwaysTrue = true || false;
boolean alwaysFalse = true && false;

// Read input returns an integer read from System.in
int input = readInput();
boolean isLessThanZeroOrGreaterThanFive = input < 0 || input > 5;
```

The list of boolean operators:
- == Equals
- != Not Equals
- > Greater than
- < Less than
- >= Greater than or equal to
- <= Less than or equal to
- && Condtional And
- || Conditional Or

```java
if (false || true) {
  System.out.println("This code always runs");
}
System.out.println("Then this code runs");
```

```java
if (false && true) {
  System.out.println("This code never runs");
}
System.out.println("Then this code runs");
```

## If - Else statement
At the end of an if statement, you can put an else statement. This code will
run if the code in the else statement is skipped.

```java
boolean alwaysTrue = true;
if (alwaysTrue) {
  System.out.println("This code always runs");
} else {
  System.out.println("This code never runs");
}
```

```java
// Read input returns an integer read from System.in
int input = readInput();
if (input > 9) {
  System.out.println("Input is greater than 9");
} else {
  System.out.println("Input is less than 9");
}
```

## Switch statement
```java
int input = 5;
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
	System.out.println("Can't say hello that many times");
}
```
