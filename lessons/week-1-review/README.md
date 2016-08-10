- title: Week 1 Review
- tags: java if else switch while enums for

#Objectives

-Solve If Else Problems
-Solve Switch Statement Problems
-Solve While Loop Problems
-Pair Programming

#Resources

-[Java coding in browser](https://repl.it/languages/java)
-[Control Flow Tutorial](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html)
-[Java Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html)
-[Boolean Logic](http://codingbat.com/doc/java-if-boolean-logic.html)

# Lecture

## If Else Problems
## Switch Statement Problems
## While Loop Problems
## Pair Programming While loops

In this project, we are going to build a typewriter. The keys of the typewriter
will be represented by an enum class.
```java
public enum Keyboard_Keys {
  NEWLINE,
  SPACE,
  A,
  B,
  C,
  D,
  E,...
```

The typewriter we are building has 28 keys. 26 capital letters, plus a NEWLINE
and SPACE key. The NEWLINE key represents an ascii "\n", and the SPACE key will
represent a single space, " ".

Your assignment is to write a function that will be called repeatedly with a
single Keyboard_Keys parameter. For each of invocation, your function should
either print the capital letter corresponding to the Keyboard_Keys alphabet, a
newline character for NEWLINE, and a single space for SPACE.

We will test your program by having it write out a sentence. For example calling
your function with the inputs

```java
A, SPACE, D, O, NEWLINE, G
```

Should result in the output
```java
A DO
G
```

* Be sure to look at the functions of Enums and Strings to use as many built
in functions as possible. Instructors were able to solve this problem with 17
lines of code.
