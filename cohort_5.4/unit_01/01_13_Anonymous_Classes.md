# Anonymous Classes

## Objectives

* Fellows will learn to create Anonymous class instances
* Fellows will learn to identify the differences between concrete and anonymous class instances

## Resources

* [Video - Anonymous Classes](https://www.youtube.com/watch?v=ihAzMaUFjgY)

# Lecture

Anonymous classes are an important part of development in Java - they are easily implemented, but are often difficult to explore.

Anonymous classes are actually quite simple - they are object instances with a declared static type, but a nameless dynamic or instance type.

Remember when we spoke about how an object variable assignment has both a static type known at compile time, and a dynamic type known at runtime? Let's break it down:

|static type known at compile time|variable|assignment|new keyword|constructor for dynamic instance type at runtime|
|:-:|:-:|:-:|:-:|:-:|
|Apple|apple|=|new|Apple();|

If you're trying to create an instance of a class with only non-static methods that have full method signatures, you'll be okay - because the constructor exists, and all the methods are defined. But what if you want to create an instance of a concrete class, but you want to override a method on-the-go? Or what if you have abstract methods, like with an `interface`, or an `abstract` class?

![Dramatic Chipmunk](https://media.giphy.com/media/kKdgdeuO2M08M/giphy.gif)

This can be a problem, and it's why we say that interfaces and abstract classes SHOULD NOT be instantiated. However...

There is another way to do this, and it is called creating anonymous methods!

Let's start my creating two files - one for an `interface` called `SomeInterface` in a file called `SomeInterface.java`, and a `class` called `Apple.java`:

```java
public interface SomeInterface {

    public void pleaseOverrideMe();
}
```

```java
public class Apple {

    public void iAmAnApple() {
        System.out.println("I am an apple.");
    }
}
```
