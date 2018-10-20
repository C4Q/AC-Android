# DS&A - String Manipulation

## Objectives

* Fellows will understand how to apply fundamental methods and algorithms to `String` objects
* Fellows will practice Whiteboarding techniques when solving simple `String` manipulation problems

## Resources

* [HackerRank]()
* [CodingBat]()

# Lecture

As we explored last week, there are two main types of coding challenges:

* complete an app from scratch
* complete an algorithm using a data structure of some sort on a whiteboard or on a screenshare

Today, we will explore some of the simplest whiteboarding questions you may ever encounter: String Manipulations.

### How can we manipulate a `String`?

`String` objects are immutable. This means that although you can reassign a variable of type `String` with a new `String` object, you won't actually be able to change the previous String, only replace it. However, the concept of String manipulation usually describes the action of taking a `String` parameter, and returning a variation of that parameter, based on certain requirements.

Remember this question from our first Homework Assignemnt?

**01.01.06 string-elide**

>Write a method called elide that takes a String parameter. For longer strings, the method returns a new string constructed out of the first three letters of the argument, followed by three periods ("..."), followed by the last letter of the argument.
>
>However, if the resulting string is not shorter than the argument, the method should return the argument instead.
>
>For example,
>
>elide("Hello!")               // returns "Hello!"
>elide("Hello, world!")        // returns "Hel...!"
>elide("That's not my name.")  // returns "Tha...."
>
>Remember that String.substring() can take two arguments: the start index and the end index.

Let's break down this question to see exactly what it's asking of us:
* Write a method that accepts a `String` as a parameter
* It should return a `String` value
* If a `String` parameter value is "too long", return the first 3 letters, then three dots, then the last char

So, those are given requirements. However, there are some inferred ones as well, for example:
* How long a `String` is too long a `String`?
* What is `String.substring()`, and how does that work?

Well, the first one is actually answered for us:
> if the resulting string is not shorter than the argument, the method should return the argument instead.

How do we know what that would be? If we pass in the `String` "1234567", using the given instructions, we'd get the string:

```
123...7
```

But guess what? That `String` is **equal** in length to the original input, **not less**, so we'd actually have to return the original value, which in this case is `1234567`. This means that if the `String` parameter length is less than or equal to 7, return the parameter unchanged. If its length is greater than 7, modify the `String`, and return a new `String` parameter with the the first 3 original letters, 3 dots, and the final character as one `String`.

Now, how can `String.substring()` help us in this situation?

When the method `substring()` is called on an object of type `String`, it returns a shorter version of the original `String` object, based on what parameters are passed into the `substring()` method.

The method `substring()` is an **Overloaded** method in the `String` class, meaning there are several methods with that same method signature, and are differntiated between each other based on the number, type, and order of its parameters. 

The method `substring()` takes in indices of chars within a string - one of its several methods takes in 1 (one) index, another takes in 2 (two). The method that takes only one index as a parameter, takes the string it is called on, and returns a new string with every char from the index passed into the `.substring()` method, up until the end of the string. For example:

```java
String name = "Apollo Creed";
name.substring(5);
```
should return the `String` value:

```
o Creed
```

Essentially, return a new `String` consisting of the `char` at index 5 of the `String` `name`, and every `char` after that until the end of the `String`.

The method that takes two indices as parameters, takes the string it is called on, and returns a new string with every char from the index passed into the `.substring()` method, up until the `char` at the index RIGHT BEFORE the index passed to the second parameter. For example:

```java
String name = "Apollo Creed";
name.substring(0, 5);
```
should return the `String` value:

```
Apoll
```

