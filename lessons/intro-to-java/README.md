# Intro to Java

## Objectives

- Define programming and programming languages.
- Describe the components that make up the Java platform.
- Peek under the hood to understand how Java code is compiled and run.
- Describe the eight primitive data types, variable assignment rules and naming conventions.
- Use Java to perform basic arithmetic operations.
- Print output to the console.

## Resources

### Videos
* [Video: Printing 'Hello World!' to the console](https://www.youtube.com/watch?v=7WiPGP_0AUA)
* [Video: Using Variables in Java](https://www.youtube.com/watch?v=oPBWC4_Zmj0)
* [Video: Working with Strings](https://www.youtube.com/watch?v=p3EnEPP7SY8)

### Documentation
- [Java History](http://papa.det.uvigo.es/~theiere/cursos/Curso_Java/history.html)
- [Oracle's Java Tutorials](https://docs.oracle.com/javase/tutorial/)
- [Print Statements](https://www.cis.upenn.edu/~matuszek/General/JavaSyntax/print-statements.html)
- [Primitive Data Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)
- [List of Java keywords (reserved words)](https://en.wikipedia.org/wiki/List_of_Java_keywords)
- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)

### Programming Environment
- [repl.it](https://repl.it/languages/java)

## Vocabulary
|Term|Definition|
|:-:|:---------|
|platform|an environment for running other programs|
|virtual|the opposite of physical|
|virtual machine|a computer that doesn't exist as physical hardware, instead it is "emulated" by software|
|compiler|a program that translates source code into machine code|
|bytecode|the machine language of the Java Virtual Machine|
|javac|the Java compiler than translates Java source files into bytecode class files|
|JVM|Java Virtual Machine, a virtual machine that interprets Java bytecode and enables your computer to run it as a program|
|JRE|Java Runtime Environment, a software package that contains what is needed to run a Java program (including the JVM)|
|JDK|Java Development Kit, contains the basics needed to develop a Java program (including the JRE as well as tools such as javac)|

# Lecture

Welcome! 🌻

### What is programming?

Programming is a creative process by which we can instruct a computer in how to do a task.

Why are computers useful?
- They are fast
- They are accurate
- They do not get bored

What are some reasons that programming is useful?

In a basic way, we could summarize programming as:

1. Figuring out, step-by-step, how you would solve a problem.
2. Explaining your solution to the computer in a shared language.

### What is a programming language?

A programming language is a language designed to be read and written by humans and to be interpreted and carried out by computers.

What are some examples of programming languages?

How are the programs we write interpreted and carried out by computers?

### What is Java?

Java is a programming language and computing platform that was released by Sun Microsystems (now Oracle) in 1995.

Java is the primary programming language used to develop Android apps.

Java was created to solve a problem: it was the first programming language in which programs could be written to run anywhere, regardless of operating system or microprocessor.

In Java, source code is written in plain text files ending with a `.java` extension. 

These files are then compiled by the **javac** compiler into `.class` files containing Java **bytecode** -- the machine language of the Java Virtual Machine. The **java** tool then runs your program with an instance of the JVM tailored to your machine.

![diagram of flow from Java source to machine language](https://docs.oracle.com/javase/tutorial/figures/getStarted/helloWorld.gif)

### Exercises

1. [Command Line Java](command-line-java.md) (*We'll do this first one together*)

2. [Java Exercises](exercises.md#java)

### Java Output

To output a string to the console, use `System.out.println(`**`"some string"`**`)`

```java
public class Hello {
    public static void main(String[] args) {
        // Outputs "Hello, world!" to the console
        System.out.println("Hello, world!");
    }
}
```

Go to [repl.it](https://repl.it/languages/java) and try it out!

#### Exercise: [Printing to the Console](https://github.com/C4Q/AC3.3/blob/master/lessons/intro-to-java/exercises.md#java-output)


### Variables & data types

In programming, **variables** are kinds of values that can be stored and manipulated. 

A variable's **data type** determines the values it may contain and the operations that may be performed on it. A **primitive data type** is a name for data types that are provided by the language as a basic building block. There are eight primitive data types in Java:

* **boolean** - represents a truth and has only two possible values, `true` or `false`. A boolean can be inverted with the `!` operator. Booleans can also be created by comparing two variables. 

```java
boolean isCar = true;
boolean areWeThereYet = false;
boolean answer = 7 > 3;
```

* **byte** - a small integer between -128 and 127.

* **short** - a small integer between -32,768 and 32,767.

* **int** - an integer between -2<sup>31</sup> and 2<sup>31</sup>-1. In most cases this is the default type used to represent integer values. 

* **long** - an integer  between -2<sup>63</sup> and 2<sup>63</sup>-1.

```java
byte myAge = 28;
short activeCitiBikesInNyc = 6603;
int yearsSinceDinosaurs = 65000000;
long humansOnEarth = 7400000000;
```

* **float** - a real number, single-precision 32-bit floating point. For our uses, **real numbers** are just numbers that can have decimals in them. For example, 2 is an integer but 2.1 is a real number.

* **double** - a real number, double-precision 64-bit floating point. In most cases this is the default type used to represent decimal values. 

```java
float percentOfPizza = 33.3f;
double pi = 3.14159265359d;
```

* **char** - a single [Unicode](http://unicode.org/charts/) character.

```java
char initial = 'R';
char nine = '9';
char newLine = '\n';
```

`char` values are unique, in that they may also be stored as their decimal `int` value counterparts. For example, the letter `A` has a decimal value of `65` - so this code is still valid:

```java
char letterA = 'A';
int decimalValueOfA = letterA;
```

Also, since all `char` values are unique, different characters will have different decimal values, and so `A` and `a` are in fact not equal in the eyes of Java:

```java
char uppercaseA = 'A';
int decimalValueOfUppercaseA = uppercaseA;

char lowercaseA = 'a';
int decimalValueOfLowercaseA = lowercaseA;

System.out.println(decimalValueOfUppercaseA);
System.out.println(decimalValueOfLowercaseA);
```

Please see the character chart below for a more detailed list of `char` characters and their corresponding `int` values:

![ascii table](https://codehs.gitbooks.io/apjava/content/static/methods/ascii-table.jpg)

In addition to these eight, Java also has special support for character strings which allows them to assigned and used like a primitive data type. Wrapping a character string in double quotes will automatically create a new **String** object.

```java
String example = "This is a string";
```

Two strings can be **concatenated** using the ```+``` operator:

```java
String hello = "Hello, " + "world!";
```

[Exercises: Exploring Data Types](exercises.md#data-types)

### Naming & assigning variables

Java is a **strongly-typed** language, meaning variables are of an explicit type when they are assigned. Use `=` to assign a value to a variable.

```java
String myName = "Ramona";

boolean isSkyBlue = true;

char bang = '!';
```

### Variable naming conventions
Java variables are conventionally named in *lowerCamelCase*: the first letter of each word after the first is capitalized. Variable names should use only ASCII letters and digits.

Good variable names are concise and meaningful. A well-selected name will help to convey your intent to subsequent programmers (including yourself!) who are tasked with reading your code.

```java
// Some good variable names:

String favoriteColor;

byte tacoCount;

boolean isNewUser;


// What about these?

double thisVariableIsEqualToTwentyThreePointFive = 23.5d;

boolean LOL;

String HelloWorld;

int int;
```

See the Google Java Style Guide [section on naming conventions](https://google.github.io/styleguide/javaguide.html#s5-naming) for more detailed guidance here.

### Reserved words
A **reserved word** is a word that already has a defined meaning in Java. Because of this, it can't be used to name a variable, method, class or other identifier.

Some example reserved words: `int`, `for`, `if`, `else`, `this`, `new`, `return`, `void`.

You can find a full list of reserved words [here](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html) or [here](https://en.wikipedia.org/wiki/List_of_Java_keywords).

[Exercises: Assigning Variables](exercises.md#assigning)
    
### Math & Operators

We can use Java to perform basic arithmetic. The order of operations is just like standard arithmetic: parentheses, exponents, multiplication and division, addition and subtraction (PEMDAS).

```java

// Addition
int result = 4 + 5;

// Subtraction
result = result - 1;

// Multiplication
result = result * 2;

// Division
result = result / 2;

result = result + 8;

// Modulo: "%" divides one operand by another and returns the remainder as its result.
result = result % 7;

// You can also combine the arithmetic operators to create compound assignments:

result += 1;

result -= 1;

// The Unary operators require only one operand:

result++;

++result;

result--;

--result;

```

**Be careful when dividing integers!**  In Java, when you divide an integer by an integer, the answer will be an integer rounded towards zero from the real number value.

```java
// Integer division
int result = 7 / 2; // Evaluates to 3
int result = 3 / 4; // Evaluates to 0

// Double division
double result = 7.0/2.0;
```

| symbol |       use      |
|:------:|:--------------:|
|    +   |    Addition    |
|    -   |   Subtraction  |
|    *   | Multiplication |
|    /   |    Division    |
|    %   |     Modulo     |
|   ++   |    Increment   |
|   --   |    Decrement   |

[Exercises: Math and Arithmetic Expressions](exercises.md#math)

## More printing + Strings

String is the most commonly used class in Java. It represents a "character string", or sequence of characters.

The full documentation for the String class is here: [Java Docs: Strings](http://docs.oracle.com/javase/7/docs/api/java/lang/String.html).

Let's complete some more exercises to experiment with Strings and printing:

[Exercises: Working with Strings](exercises.md#strings)

## Next Steps

Please visit the Android Calendar on Canvas, and select **Midday Check-in: Intro to Java** to complete the daily check-in!
