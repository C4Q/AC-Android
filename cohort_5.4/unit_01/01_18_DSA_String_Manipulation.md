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
