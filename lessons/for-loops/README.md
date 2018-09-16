# For Loops and Methods

## Objectives

- Understand the components of a for loop
- Properly use ```continue``` and ```break```
- Iterate through a String using a standard loop
- Understand how to define Methods
- Understand how to properly call methods in Java

## Resources

### Video
* [Video: Working with Strings](https://www.youtube.com/watch?v=p3EnEPP7SY8)
* [Video: For Loops](https://www.youtube.com/watch?v=42QGewg7AU4)
* [Video: Methods](www.youtube.com/watch?v=-eoNHtILOs4)

### Documentaion
- [Oracle Docs](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html)
- [Java For-Loops Examples](http://www.java-examples.com/loop)
- [Methods](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)
- [Return Values](https://docs.oracle.com/javase/tutorial/java/javaOO/returnvalue.html)

## Vocabulary

|Term|Definition|
|:--:|:---------|
|Initialization|assigning a value to a variable for the first time|
|Termination|the end of an action|
|Condition|an expression or evaluation of an expression which must be either ```true``` OR ```false```|
|Increment|increasing a variable's value by 1; for example: ```i++``` or ```++i```|
|Decrement|decreasing a variable's value by 1; for example: ```i--``` or ```--i```|
|```break```|keyword which terminates a loop or switch statement and transfers execution to the statement immediately following the loop or switch statement|
|```continue```|keyword which skips any code following it within a loop, and jumps to the next iteration of the loop|
|Method|a reusable block of code (function) that may be called/run within another block of code|
|Declaration|states the type of a variable (or ```return``` type for **methods**), along with its name|
|Parameter|a variable in the declaration of a method, which the code within a method can use to manipulate arguments|
|Argument|data passed into a method's parameters|

# Lecture

Loops are a very power control structure, and a great way for your program to do a repeated set of actions.

A for-loop has three important components that help determine how many times it will loop.

- Initialization
- Termination/Condition
- Increment/Decrement

```java
for (initialization; termination; increment) {
    // do something
}
```

1. The *initialization* is executed once, beginning the loop.
2. When the *termination* expression is `false`, the loop terminates; this is analogous to the condition in a `while` statement. i.e, the condition must remain true for the loop to continue.
3. The *increment* expression is executed after each iteration; this can also decrement.

As with `if` and `while`, for loops have a body denoted by a pair of opening braces ```{``` and closing braces ```}```.

All loops have a body, and any code within the body of your loop will run however many times your loop runs.

This is an example of a ```for``` loop, that prints the value of ```i```, if ```int i``` is an even number:

```java
for(int i = 0; i < 4; i++) {
    if(i % 2 == 0) {
    	System.out.println(i)
    }
}
```

**Exercise** Rewrite the following `while` loop as a `for` loop:

 ```java
 int i = 0;
 while (i <= 100) {
     i++;
     System.out.println(i);
 }
```
- Loops include conditional logic.
- You may also need to add an if-statement to the body of your loop.

The hardest part about `for` loops is properly stopping the loop. Programmers often make mistakes when setting the termination condition for a loop. In particular, we are often off-by-one. This kind of bug it so common, it has its own [Wikipedia page](http://en.wikipedia.org/wiki/Off-by-one_error).

<!--
#### Exercise: [Counting Machine](http://programmingbydoing.com/a/counting-machine.html) (Simple)
Write a program that counts from 0 to a user-specified number.

#### Exercise: [Counting Machine Revisited](http://programmingbydoing.com/a/counting-machine-revisited.html) (Intermediate)
Now let the user input the initial value, the max value, and the increment.

#### Exercise: [FizzBuzz](http://programmingbydoing.com/a/fizzbuzz.html) (Difficult)
"FizzBuzz" is a very famous program, up there with "Hello World!". Write "FizzBuzz" using a ```for``` loop. 

--->

## The `break` and `continue` keywords

Remember `break`?

The keyword `break` terminates a loop or switch statement and transfers execution to the statement immediately following the loop or switch.

Java also has another useful keyword, `continue` - which jumps to the next iteration of the loop.

The keyword `continue` can be useful for skipping over some unnecessary computation.

A ```continue``` statement causes the loop to skip the remainder of its body and immediately retest its condition prior to reiterating.

```java
for (int i = 1; i <= 20; i++) {
    if (i % 2 == 0) {
    	continue;
    }
    System.out.println(i);
}
```
<!--

#### Exercise:

Simplify your code for FizzBuzz using `continue`.

--->

## Methods

Methods are another effective way for programmers to automate things, allowing us to repeatedly run a block of code ("call" a Method) on a number of inputs without retyping the code.

A method is a piece of code that can perform one or many operations, then return something back to whatever block of code “called” the method. Or, a method will perform some operations, without needing to return anything when it’s done, and the flow of code will just continue back from whatever point the method was initially called. Either way, a method will execute some block of useful code that can be called repeatedly from anywhere in your program.

```System.out.println()``` is an example of a method call. It takes a single String as its input parameter and prints it.

Java provides many methods you may find familiar. Here are two particularly helpful methods for iterating through strings.

- ```String.length()```
- ```String.charAt()```

Here is how they are **invoked** in Java:

```java
System.out.println("Queens!".length()); // 7
```

The function `String.charAt()` returns the `char` at the index provided. For example:

```java
System.out.println("Queens!".charAt(3)); // e
```

We can also declare or define our own methods to add to our Java classes by specifying a name, required parameters, and return types. It's crucial to pay attention to four important things:

- What will the method do?
- What name will the method have?
- What parameters are required? - the number of parameters and the type(s) are important!- (When calling the method, you must provide the same number of parameters, same exact types as specified, and in the right order.)
- What type of value, if any, will the method return? (The data type of the return value must match the method's declared return type; EX: you can't return an integer value from a method declared to return a boolean.)

### Composition of Methods

Just as with variables - we must declare a method with types, before we use them.

However, a method's type is different from a variable's type. A variable type is the **type of value stored** in a variable, while a method type is the **type of the value returned** after the method is finished running.

The first line of a method is known as it's declaration. Here, we declare the method's return type, name, and its parameters in the declaration. The block of code within the curly braces of a function is known as the body of the function. This code is evaluated and run each time a method is called. the The block methods except those that return void require a return statement within the body. Code written after a return statement is generally unreachable because once the method returns, the code flow exits from the method and returns a value

The following method is defined to take a number as an input and return a boolean.
```java    
// Method Defintion

boolean isOdd(int number) {
   return number % 2 != 0;
}
```
```java
// Method Call - with this value (or argument) passed into the parameter,
// it will return the boolean value 'false'.

isOdd(4);

```
```java
void printHelloWorldNTimes(int n){
     for(int i = 0; i < n; i++){
       System.out.println("Hello World " + i);
     }
}
```

The above method prints "Hello World" N times. Notice that it simply prints and does not return anything. The return keyword is optional, because the method's declaration specifies a void return type. The following code is identical.

```java
void printHelloWorldNTimes(int n){
     for(int i = 0; i < n; i++){
       System.out.println("Hello World " + i);
     }
     return;
}
```

<!--
> **Exercise:** The original fizzbuzz problem required printing the numbers from 1 to 100. Let's modify the problem by using a method that still prints fizz, buzz, and fizzbuzz when appropriate but that only goes up to a variable N.



> **In-class assignment:** [String exercise](exercises/string-loops.md)

> **In-class assignment:** [hard] []
Below is a quote from [Grace Hopper](http://en.wikipedia.org/wiki/Grace_Hopper), the inventor of the first compiler. Write a program that uses a `for` loop to count how many times she says the word "data". You'll need to call two `String` functions in order to complete this assignment. Make sure to verify your answer.

> > "We must include in any language with which we hope to describe complex **data**-processing situations the capability for describing **data**. We must also include a mechanism for determining the priorities to be applied to the **data**. These priorities are not fixed and are indicated in many cases by the **data**.

> > "Thus we must have a language and a structure that will take care of the **data** descriptions and priorities, as well as the operations we wish to perform. If we think seriously about these problems, we find that we cannot work with procedures alone, since they are sequential. We need to define the problem instead of the procedures. The Language Structures Group of the Codasyl Committee has been studying the structure of languages that can be used to describe **data**-processing problems. The Group started out by trying to design a language for stating procedures, but soon discovered that what was really required was a description of the **data** and a statement of the relationships between the **data** sets. The Group has since begun writing an algebra of processes, the background for a theory of **data** processing.

> > "Clearly, we must break away from the sequential and not limit the computers. We must state definitions and provide for priorities and descriptions of **data**. We must state relationships, not procedures."
--->

