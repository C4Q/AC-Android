- title: Methods
- tags: java, methods

# Objectives

- To be able to declare a method.
- To be able to call a method.

# Resources

- [Java Tutorials: Defining Methods](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)

# Lecture

## Methods
Methods are blocks of code that perform a computation. Methods can take in data, process it, and give back a result. While methods have many uses, we will focus on three:

1. Code reuse
2. Parameterization
3. Modularization

Before we talk about why we use them, let's talk about how.

##### Calling a method
Methods have names and can be used by writing their name followed by parentheses. When we use a method, we say we *call* or *invoke* it. Here is an example:

```java
public class Methods {
    // Here we are declaring a method "speak"
    public static void speak() {
        System.out.println("Hi, there!");
    }
    public static void main(String[] args) {
        // Here we are calling a method "speak"
        speak();
    }
}
```

First, notice we write `public static void` and then the name of the method, `speak`. When we want to *call* `speak`, we write `speak()`. Try it.

##### Parameterizing a method.
Methods can be *parameterized*. This means we can configure or change their behavior based on certain parameters. Parameters are specified as a comma-separated list names. Each name must also have a type.

```java
public class Methods {
    // "lastName" is the name of the parameter and is of type String.
    public static void shoutOut(String lastName) {
        System.out.println("Shout out to " + lastName + "!");
    }
    public static void main(String[] args) {
        // Here we are "passing in" a parameter "John Von Neumann".
        shoutOut("Von Neumann");
    }
}
```

Notice that when we call the method, we can put a word between the two parantheses. This word must have the same type as the one specified in the method declaration. Often, programmers say they are "passing in" the parameters. 

We can pass in multiple parameters:

```java
public class Methods {
    // "lastName" is the name of the parameter and is of type String.
    public static void shoutOut(String firstName, String lastName) {
        System.out.println("Shout out to " + firstName + " " + lastName + "!");
    }
    public static void main(String[] args) {
        // Here we are "passing in" a parameter "John Von Neumann".
        shoutOut("John", "Von Neumann");
    }
}
```

##### Getting a result
Methods can *return* a value. This means that the method call itself has a value and can be stored in a variable like any other value:

```java
public class Methods {
    public static String getGreeting() {
        return "Ohayo!";
    }
    public static void main(String[] args) {
        String greeting = getGreeting();
        System.out.println(greeting);
    }
}
```

In the above code...

    String greeting = getGreeting();

..is equivalent to...

    String greeting = "Ohayo!";

> **Food for thought:** Notice that we always declare a method `main()`. The type of `main()` is `void`. Why? Can you return a value from main?

#### Summary
The components of a method declaration are:

1. Modifiers such as `public` and `private`. Do not worry about these for now.
2. The type of the `return` value or *return type*. In the above examples, the return type is `String`. Notice it is declared before the method names. If the method does not return a value, it has type `void`.
3. The method name, in these cases `speak`, `shoutOut`, and `getGreeting`.
4. Parameters, a comma-separated list in parentheses. Notice each parameter has a type.
5. An exception list. Do not worry about this for now.
6. The method body. Just like a `while`, `if`, or `for` statement body, the method body is in curly braces.

> **Exercise:** Write a method `add` that takes two parameters two `int x` and `int y` returns the sum of `x` and `y`.

> **Exercise:** Write a method `subtract` that takes two parameters two `int x` and `int y` returns the difference, subtracting `y` from `x`.

## Why we use methods

This class calculates the hypotenuse of a right triangle. Notice that the method `hypotenuse()` allows us to:

1. Reuse some computation.
2. Parameterize the computation.
3. More easily reason about our code.

```java
public class Geometry {
    public static void main(String[] args) {
        double c  = hypotenuse(1, 2); // 2.236
        double c2 = hypotenuse(2, 4); // 4.472
    }
    public static double hypotenuse(int a, int b) {
        return Math.sqrt(a*a + b*b);
    }
}
```

> **Bonus question:** Can you simplify your *Twelve Days of Christmas* program using methods?

## In-class assignment: DrawRocket.java
We need to draw an [ASCII art](http://en.wikipedia.org/wiki/ASCII_art) rocket, but we want to parameterize our program so that the rocket can be any size. Write a class `DrawRocket` that can do this.

**Suggestion:** Write a function `drawRocket(int size)` that takes an `int` as a parameter. When `size` increases, so does the rocket.

### Example rockets

##### `drawRocket(1)`
```
 /**\
+*=*=+
|/\/\|
|\/\/|
+*=*=+
|\/\/|
|/\/\|
+*=*=+
 /**\
```

##### `drawRocket(2)`

```
   /**\
  //**\\
 ///**\\\
+*=*=*=*=+
|./\../\.|
|/\/\/\/\|
|\/\/\/\/|
|.\/..\/.|
+*=*=*=*=+
|\/\/\/\/|
|.\/..\/.|
|./\../\.|
|/\/\/\/\|
+*=*=*=*=+
   /**\
  //**\\
 ///**\\\
```

##### `drawRocket(3)`

```
     /**\
    //**\\
   ///**\\\
  ////**\\\\
 /////**\\\\\
+*=*=*=*=*=*=+
|../\..../\..|
|./\/\../\/\.|
|/\/\/\/\/\/\|
|\/\/\/\/\/\/|
|.\/\/..\/\/.|
|..\/....\/..|
+*=*=*=*=*=*=+
|\/\/\/\/\/\/|
|.\/\/..\/\/.|
|..\/....\/..|
|../\..../\..|
|./\/\../\/\.|
|/\/\/\/\/\/\|
+*=*=*=*=*=*=+
     /**\
    //**\\
   ///**\\\
  ////**\\\\
 /////**\\\\\
```

# Exit Ticket

// TODO
