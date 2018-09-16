# Control Structures in Java

## Objectives

- Write an If statement
- Write an If - Else statement
- Write a Switch statement
- Write a Ternary Operator Expression

## Resources

### Videos

* [Video: If Statements](https://www.youtube.com/watch?v=jjx5mJOcLqM)
* [Video: Switch Statements](https://www.youtube.com/watch?v=oLpUfseieuE)
* [Video: Ternary Operators](https://www.youtube.com/watch?v=igc_jsQIoxY)

### Documentation

- [Control Flow Tutorial](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html)
- [Java Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html)

### Programming Environment

- [repl.it: Java coding in browser](https://repl.it/languages/java)
- [CodingBat: Boolean Logic](http://codingbat.com/doc/java-if-boolean-logic.html)

# Lecture

## Boolean Expressions

A ```boolean``` expression is an expression that evaluates to either ```true``` or ```false```. The result of an evaluated expression can be stored in a ```boolean``` variable. What will be printed on the screen after this code is run?

```java
// Is 5 greater than 2?
boolean thisEvaluatesToTrue = 5 > 2;
System.out.println(thisEvaluatesToTrue);
```
What about this one?

```java
// Is 10 less than 3?
boolean thisEvaluatesToFalse = 10 < 3;
System.out.println(thisEvaluatesToFalse);
```

Boolean expressions are evaluated using a number of boolean operators:

|Operator|Meaning|
|:-:|:--|
|```==```|Equals|
|```!=```|Not Equals|
|```>```|Greater than|
|```<```|Less than|
|```>=```|Greater than or equal to|
|```<=```|Less than or equal to|
|```&&```|Conditional And|
|```\|\|```|Conditional Or|

### ```&&``` and ```||``` Boolean Operators

The AND (```&&```) and OR (```||```) operators are used whenever we want to evaluate two ```boolean``` values, or expressions which evaluate to ```boolean``` values.

The statement "It is warm outside when the sun is shining AND the temperature is high" could be written as:

```java
boolean isSunShining = true;
boolean isTemperatureHigh = true;

boolean isWarmOutside = isSunShining && isTemperatureHigh;
```

When using the AND ```&&``` operator, all values in the expression **MUST** be ```true``` in order for the expression to evaluate to ```true```.

The operator ```&&``` described with a **truth table**:

|   p  |   q  | p && q |
|:----:|:----:|:------:|
| true | true |  true  |
| true | false|  false |
| false| true |  false |
| false| false|  false |

The statement "It is Summertime when the month is either July OR August" could be written as:

```java
boolean isJuly = false;
boolean isAugust = true;

boolean isSummertime = isJuly || isAugust;
```

When using the OR ```||``` operator, a **MINIMUM OF ONE** of the values in the expression **MUST** be ```true``` in order for the expression to evaluate to ```true```.

The operator ```||``` described with a **truth table**:

|   p  |   q  | p \|\| q |
|:----:|:----:|:------:|
| true | true |  true  |
| true | false|  true  |
| false| true |  true  |
| false| false|  false |

## Control Structures

Programming requires telling a computer to make decisions based on inputs. There are several ways to direct the flow of a program, using control structures. The simplest is the ```if``` statement.

## ```if``` statement
```java
if (BOOLEAN_CONDITION) {
  // do something
}
```
An ```if``` statement needs a boolean condition to operate. If that expression evaluates to ```true```, then the code within the if block will run. Otherwise, the code within the block is skipped, and the program will continue.

```java
boolean alwaysTrue = true;
if (alwaysTrue) {
  System.out.println("This code always runs");
}
System.out.println("Then this code runs");
```

```java
// readInput() returns an integer read from System.in
int input = readInput();
if (input > 9) {
  System.out.println("A number greater than 9");
}
```

An ```if``` statement will evaluate code within the parentheses. The boolean statement must
return a ```true``` or ```false``` value:

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

## ```else``` statement
At the end of an ```if``` statement, you can put an ```else``` statement. In the code below, the ```if``` code block will run (the condition evaluates to ```true```), while the code in the ```else``` statement is skipped:

```java
boolean alwaysTrue = true;
if (alwaysTrue) {
  System.out.println("This code always runs");
} else {
  System.out.println("This code never runs");
}
```

However, in the code below, the ```if``` code block will NOT run (the condition evaluates to ```false```) and will be skipped, while the code in the ```else``` statement will run instead:

```java
boolean alwaysFalse = false;
if (alwaysFalse) {
  System.out.println("This code never runs");
} else {
  System.out.println("This code always runs");
}
```

What do you think this code does?

```java
// Read input returns an integer read from System.in
int input = readInput();
if (input > 9) {
  System.out.println("Input is greater than 9");
} else {
  System.out.println("Input is less than 9");
}
```

## ```else if``` statement

An ```else if``` statement can also be added to the end of an ```if``` statement, to take further control of a program's flow. It can be seen as a combination of both the ```if``` and ```else``` statements, in that the ```else if``` only runs if the previous ```if``` statement's condition is not met, **AND** its own condition is **ALSO** met. Let's refactor (modify) the above code, so that it includes an ```else if``` statement that handles an input which is less than 9, but greater than 6:

```java
// Read input returns an integer read from System.in
int input = readInput();
if (input > 9) {
  System.out.println("Input is greater than 9");
} else if (input > 6) {
  System.out.println("Input is less than 9, but greater than 6");
} else {
  System.out.println("Input is less than 9 and 6");
}
```
## Boolean Expressions in Control Structures
As described earlier, a ```boolean``` expression is an expression that evaluates to either ```true``` or ```false```. Such expressions can take several forms. The simplest is the direct comparison of the value of a Boolean value to a boolean literal.

What do you think the following code snippets do?

```java
int DOWNLOAD_IMAGES_REQUEST = 111;
if(requestCode == DOWNLOAD_IMAGES_REQUEST && resultCode == RESULT_OK) {
    System.out.println("We downloaded all the images!");
}
```

```java
String word = readInput();
if(!word.isEmpty()) {
    System.out.println("You entered " + word);
}
```

## Switch statement
Switch statements are the equivalent of if-else statements, with one key difference. Of all blocks of code defined in an if else statement, only one will be executed. In a ```switch``` statement, multiple blocks of code can be executed.
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

Is the same as the following if-else statement:

```java
int input = 5;
if (input == 1) {
  	System.out.println("hello Tom");
} else if (input == 2) {
	System.out.println("hello Bob");
} else if (input == 3) {
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
int input = 1;
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
int input = 1;
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

Is the same as the following if else statement:

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

String comparison
  * When comparing two strings for equality, use the ```.equals()``` method not ```==```. The ```.equals()``` method will check that two Strings have identical content, while ```==``` checks whether both strings have the same in-memory reference.

```java
String studentName = "John";
String teacherName = "John";

// DO THIS
if (studentName.equals(teacherName)) {
    System.out.println("They have the same content!");
}

// DO NOT DO THIS
if (studentName == teacherName) {
    System.out.println("This is not a good idea!");
}
```
## Ternary Operator Statements

Another control statement which may come in handy when making decisions is called the Ternary Operator Statement, or the If-Then-Else statement. It gets its name from the ```?``` operator it uses to control the flow of a program.

The statement "If 5 is greater than 3, the expression is correct - otherwise, it is incorrect" can be written in code like this:

```java
boolean isCorrectExpression = (5 > 3) ? true : false
```

Let's break it down step-by-step:

|Type|Variable|Assignment|Condition|If Condition is True|Variable is assigned this value|Otherwise, it is assigned this value|
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
|boolean|isCorrectExpression|=|(5>3)|?|true|false|

