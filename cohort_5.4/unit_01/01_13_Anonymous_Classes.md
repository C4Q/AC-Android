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

|static type known at compile time|variable|assignment|new keyword|constructor for dynamic type at runtime|
|:-:|:-:|:-:|:-:|:-:|
|Apple|apple|=|new|Apple();|
