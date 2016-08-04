- title: Control Structures
- tags: java if else switch

#Objectives

-Write an If statement
-Write an If - Else statement
-Write a Switch statement

#Resources
-[Java coding in browser](https://repl.it/languages/java)
-[Control Flow Tutorial](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html)
-[Java Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html)
[Boolean Logic](http://codingbat.com/doc/java-if-boolean-logic.html)

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
evaluates to true, then the code within the if block will run. Otherwise, the code within the block is skipped, and the program will continue.

```java
boolean alwaysTrue = true;
if (alwaysTrue) {
  System.out.println("This code always runs");
}
System.out.println("Then this code runs");
```

An if statement will evaluate code within the parenthesis. The boolean statement must
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
- && Conditional And
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

## Boolean expressions
A boolean expression is an expression that evaluates to either true or false. Such expressions can take several forms. The simplest is the direct comparison of the value of a Boolean value to a boolean literal.

What do you think the following code snippets do?

```java
int DOWNLOAD_IMAGES_REQUEST = 111;
if(requestCode == DOWNLOAD_IMAGES_REQUEST && resultCode == RESULT_OK{
    System.out.println("We downloaded all the images!")
}
```

```java
    String word = readInput();
    if(!word.isEmpty()){
    	System.out.println("You entered " + word);
    }
```

 *Todo - Cover DeMorgan's Law and add in-class exercises.

## Switch statement
Switch statements are the equivalent of if else statements, with one key difference. Of all blocks of code defined in an if else statement, only one will be executed. In a switch statement, multiple blocks of code can be executed.
First we demonstrate a switch statement runs one block of code at a time.

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

Is the same as the following if else statement:

```java
int input = 5;
if (input == 1) {
  System.out.println("hello Tom");
} else if (input == 2) {
	System.out.println("hello Bob");
} else if (input == 3) {}
	System.out.println("hello world");
} else {
	System.out.println("Can't say hello that many times");
}
```

In the switch statement, a single expression is used to evaluate all cases, and
the first case that matches will execute. The code within the switch block will
keep running until it reaches a break statement. Notice in our switch statement,
we stop execution with break statements, so that only one println statement
runs. We can execute all statements as follows:

```java
int input = 5;
switch (input) {
case 1:
  System.out.println("hello Tom");
case 2:
	System.out.println("hello Bob");
case 3:
	System.out.println("hello world");
default:
	System.out.println("Can't say hello that many times");
}
```

Is the same as the following if else statment:

```java
int input = 5;
if (input == 1) {
  System.out.println("hello Tom");
  System.out.println("hello Bob");
  System.out.println("hello world");
  System.out.println("Can't say hello that many times");
} else if (input == 2) {
  System.out.println("hello Bob");
  System.out.println("hello world");
  System.out.println("Can't say hello that many times");
} else if (input == 3) {
  System.out.println("hello world");
  System.out.println("Can't say hello that many times");
} else {
	System.out.println("Can't say hello that many times");
}
```

The switch statement is also special because of the default keyword. The
block of code following default will be executed if the other case expressions
do not evaluate to true. By selectively placing break statements, we can run
multiple blocks of code. However, it is important to write code that is easily
readable to others, so be careful not to write confusing switch statements.
For example:

```java
int input = 5;
switch (input) {
case 1:
  System.out.println("hello Tom");
case 2:
	System.out.println("hello Bob");
  break;
case 3:
	System.out.println("hello world");
default:
	System.out.println("Can't say hello that many times");
}
```

Is the same as the following if else statment:

```java
int input = 5;
if (input == 1) {
  System.out.println("hello Tom");
  System.out.println("hello Bob");
} else if (input == 2) {
  System.out.println("hello Bob");
} else if (input == 3) {
  System.out.println("hello world");
  System.out.println("Can't say hello that many times");
} else if(input != 1 && input != 2 && input != 3) {
	System.out.println("Can't say hello that many times");
}
```

Notice how the default case could not be translated to an else block of code
without an expression guarding its execution.
