- title: For Loops and Methods
- tags: loops, for, strings

# Objectives

- Understand the components of a for loop
- Properly use 'continue' and 'break'
- Iterate through a String using a standard loop
- Understand how to define functions
- Understand how to properly call functions in Java

# Resources

- [Oracle Docs](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html)
- [Java For-Loops Examples](http://www.java-examples.com/loop)
- [Methods](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)
- [Return Values](https://docs.oracle.com/javase/tutorial/java/javaOO/returnvalue.html)


# Lecture

Loops are a very power control structure, and a great way for your program to do a repeated set of actions.

A for-loop has three important components that help determine how many times it will loop.

- Initialization
- Termination/Condition
- Increment

```java
for (initialization; termination; increment) {
    // do something
}
```


1. The *initialization* is executed once, beginning the loop.
2. When the *termination* expression is `false`, the loop terminates; this is analogous to the condition in a `while` statement. i.e, the condition must remain true for the loop to continue.
3. The *increment* expression is executed after each iteration; this can also decrement.

As with `if` and `while`, for loops have a body denoted by a pair of opening and closing braces.

All loops have a body, and any code within the body of your loop will run however many times your loop runs.

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



> **Exercise:** [Counting Machine](http://programmingbydoing.com/a/counting-machine.html): Write a program that counts from 0 to a user-specified number.


> **Exercise:** [harder] [Counting Machine Revisited](http://programmingbydoing.com/a/counting-machine-revisited.html): Now let the user input the initial value, the max value, and the increment.

> **Exercise:** "FizzBuzz" is a very famous program, up there with "Hello World!". Write [FizzBuzz](http://programmingbydoing.com/a/fizzbuzz.html) using a `for` loop.



`break` and `continue`
=

Remember `break`?

> *Definition:* `break` terminates a loop or switch statement and transfers execution to the statement immediately following the loop or switch.

Java also has another useful keyword, `continue`:

> *Definition:* `continue` jumps to the next iteration of the loop.

`continue` can be useful for skipping over some unnecessary computation.

A continue statement causes the loop to skip the remainder of its body and immediately retest its condition prior to reiterating.

```java
for (int i = 1; i <= 20; i++) {
    if (i % 2 == 0) continue;
    System.out.println(i);
}
```


> **Exercise:** Simplify your code for FizzBuzz using `continue`.

## Methods

Methods are another effective way for programmers to automate things, allowing us to repeatedly call a set of code on a number of inputs without retyping the code.

*Definition*
 A method is a piece of code that could perform some operations, then return something back to whatever happened to “call” the method. Or, a method will perform some operations, without needing to return anything when it’s done, the flow of code will just continue back from whatever called the method.  Either way, a method will execute some block of useful code that can be called repeatedly from anywhere in your program

  System.out.println() is an example of a method call. It takes a single String as its input parameter and prints it.

  Java provides many methods you may find familiar. Here are two particularly helpful methods for iterating through strings.

  - `String.length()` and
  - `String.charAt()`

  here is how they are invoked in Java:

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

*Composition of Methods*

 The first line of a method is know as it's declaration. Here, we declare the method's return type, name, and its parameters in the declaration. The block of code within the curly braces of a function is known as the body of the function. This code is evaluated and run each time a method is called. the The block methods except those that return void require a return statement within the body. Code written after a return statement is generally unreachable because once the method returns, the code flow exits from the method and returns a value


The following method is defined to take a number as an input and return a boolean.
```java    
//Method Defintion
boolean isOdd(int number){
   return number % 2 != 0;
}
```
//Method Call
isOdd(4)   //return false.


```java
void printHelloWorldNTimes(int N){
     for(int i = 0; i < N; i++){
       System.out.println("Hello World " + i);
     }
}
```

The above method prints "Hello World" N times. Notice that it simply prints and does not return anything. The return keyword is optional, because the method's declaration specifies a void return type. The following code is identical.

```java
void printHelloWorldNTimes(int N){
     for(int i = 0; i < N; i++){
       System.out.println("Hello World " + i);
     }
     return;
	}
```


> **Exercise:** The original fizzbuzz problem required printing the numbers from 1 to 100. Let's modify the problem by using a method that still prints fizz, buzz, and fizzbuzz when appropriate but that only goes up to a variable N.



> **In-class assignment:** [String exercise](exercises/string-loops.md)



> **In-class assignment:** [hard] []
Below is a quote from [Grace Hopper](http://en.wikipedia.org/wiki/Grace_Hopper), the inventor of the first compiler. Write a program that uses a `for` loop to count how many times she says the word "data". You'll need to call two `String` functions in order to complete this assignment. Make sure to verify your answer.

> > "We must include in any language with which we hope to describe complex **data**-processing situations the capability for describing **data**. We must also include a mechanism for determining the priorities to be applied to the **data**. These priorities are not fixed and are indicated in many cases by the **data**.

> > "Thus we must have a language and a structure that will take care of the **data** descriptions and priorities, as well as the operations we wish to perform. If we think seriously about these problems, we find that we cannot work with procedures alone, since they are sequential. We need to define the problem instead of the procedures. The Language Structures Group of the Codasyl Committee has been studying the structure of languages that can be used to describe **data**-processing problems. The Group started out by trying to design a language for stating procedures, but soon discovered that what was really required was a description of the **data** and a statement of the relationships between the **data** sets. The Group has since begun writing an algebra of processes, the background for a theory of **data** processing.

> > "Clearly, we must break away from the sequential and not limit the computers. We must state definitions and provide for priorities and descriptions of **data**. We must state relationships, not procedures."

### [Exit Ticket](http://bit.ly/2aFLSKE)
