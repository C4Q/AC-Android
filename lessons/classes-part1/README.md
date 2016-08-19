# Objectives
- How to instantiate a class.
- How to use a class's methods.
- To know the difference between primitive and reference types.
- To become comfortable reading API documentation.

# What you should know by now...
- How to print out using `System.out.println`.
- How to use primitive types, e.g. `int`, `char`, `boolean`, etc.
- How to use `String`s.
- How to read user input with `Scanner`.
- How to use `while` loops.
- How to use an `if` statement.
- How to use `for` loops
- How to call methods
- How to declare a method


# Warmup
As part of an in class competition, you will solve as many string questions as
you can from HackerRank, in the next 30 minutes.

[HackerRank](https://www.hackerrank.com/domains/java/java-strings/difficulty/all/page/1)
# Review
- [`DrawRocket.java`](https://github.com/accesscode-2-1/unit-0/blob/master/in-class%20exercise%20solutions/DrawRocket.java)

# Objects and classes
##### Lesson
- Object-oriented programming
- Creating classes
- Using static methods
- Creating our own classes
- References vs. values

### Object-oriented programming
Object-oriented programming is a style of computer programming in which the programmer represents the real world using "objects." An *object* is a very generic term in software development and will have different meanings depending on the context and language. For now, this definition is enough:

> *Definition:* An *object* is a group of primitive types, methods, and other objects.

Real world objects have state and behavior. For example, a car has state (color, make, model) and behavior (turning, accelerating). Object-oriented programming is an attempt to model this combination of state and behavior in a modular, comprehensible way.

![Object-oriented programming](https://github.com/accesscode-2-1/unit-0/blob/master/images/car.jpg)

*Figure: A car can be thought of as an object with certain state and behavior.*

We've already talked about methods. A method models the behavior of an object--it *does something*.

### But why?

![NYC](https://github.com/accesscode-2-1/unit-0/blob/master/images/nyc.jpg)

**Objects help us to build big programs.**

More technically:

- Modularity: Objects can be maintained independent of other objects in the system.
- Information-hiding: You can use an object without knowing how it is implemented!
- Code reuse: Many objects may share attributes or behavior.

### Classes

You may notice that many real world objects share attributes and behavior. For example, a motorcycle, sedan, truck, and semi-truck are all vehicles. They can be thought of as the same kind of object.

![Object-oriented programming](https://github.com/accesscode-2-1/unit-0/blob/master/images/oop.jpg)

In Java, objects of the same kind are said to share a "type", a word we already know! For example, we might say that `motorcycle` and `semi-truck` are both of type `vehicle`.

What if we'd like to make lots of a particular type of object? We can create a `class`:

> *Definition:* A *class* is a blueprint for creating objects.

Thus, we can amend our previous definition:

> *Definition:* An *object* is an *instance* of a *class*.

What's an instance? "Instance" and "object" mean the same thing; typically, "instance" is used to refer to an object in reference to its class. For example, "The sedan is an instance of a vehicle."

### Why classes?

![suburbs](https://github.com/accesscode-2-1/unit-0/blob/master/images/suburbs.jpg)

##### Creating a class

You've already used classes and objects. They're impossible to avoid, because in Java, **nearly everything is an object.** Some things aren't and we'll talk about those later.

For example, when you created a new Scanner instance, you wrote:

```java
Scanner input = new Scanner(System.in);
```

> *Definition:* We create an *instance* of a class, also called "instantiating a class", using the `new` keyword.

##### Classes are types

In the above code, the `new` keyword tells Java to create a new instance of type `Scanner`. Remember how we always put a type in front of our variable names...

```java
int myNumber = 9;
boolean isTrue = 99 < 100;
```

...? This is the same as when we say that `input` is of type `Scanner`. We'll talk later about why `int` and `boolean` do not require the `new` keyword, but for now, think of them as just simpler objects.

##### Classes have methods

We've also already used methods on a class.

```java
String queens = new String("Queens!");
char c = queens.charAt(0); // 'Q'
```

##### Composition

Perhaps the most important notion of object-oriented programming is simply that once you have an object, you can compose it with other objects. Today, we're going to play around with some custom classes to get a feel for this.

# In-class assignment

Use two custom classes, [`SecretWord`](https://github.com/accesscode-2-1/unit-0/blob/master/in-class%20exercise%20solutions/Hangman/SecretWord.java) and [`Drawing`](https://github.com/accesscode-2-1/unit-0/blob/master/in-class%20exercise%20solutions/Hangman/Drawing.java) to implement the game [Hangman](http://en.wikipedia.org/wiki/Hangman_%28game%29). Hint: you need to write your own class in `Hangman.java` and then use then other two classes to build your program! Some things to consider:

- Users can miss 5 times, after which they lose.
- User input should be uppercase letters.

You can choose how to precisely to implement hangman yourself, but here is an example game:

```
Let's play Hangman!

Word  : _ _ _
  |
Misses: 0
Guess : E
Word  : _ _ _
  |
 \
Misses: 1
Guess : G
Word  : G _ _
  |
 \
Misses: 1
Guess : I
Word  : G _ _
  |
 \0
Misses: 2
Guess : L
Word  : G _ _
  |
 \0/
Misses: 3
Guess : M
Word  : G _ M
  |
 \0/
Misses: 3
Guess : U
Word  : G _ M
  |
 \0/
  |
Misses: 4
Guess : T
Word  : G _ M
  |
 \0/
  |
 /
Misses: 5
Guess : Y

You won!
The word was: G Y M
```

You can look at the `.java` files directly to see what methods are available to you but in summary:

`SecretWord`

| Type | Method | Description |
|---|---|---|
| `boolean` | `isLetter(char letter)` | Returns `true` if `letter` is in the secret word, `false` otherwise. |
| `void` | `set(char letter)` | Sets `letter` as correctly guessed but throws an error if `letter` is not in the secret word. |
| `String` | `toString()` | Returns a `String` of the secret word with underscores for un-guessed letters. |
| `String` | `reveal()` | Returns a full `String` of the secret word. |
| `boolean` | `isGuessed()` | Returns `true` if the secret word has been guessed, `false` otherwise. |

`Drawing`

| Type | Method | Description |
|---|---|---|
| `String` | `get(int misses)` | Returns the drawing as a `String`, dependent on the number of `misses`. |

##### Bonus questions:

Have you already finished the assignment? Here are a few other things to try:
- `SecretWord` expects uppercase letters, but the user can input anything they'd like. Check user input and gracefully report back to the user ("Please only use uppercase letters") rather passing the input on to `SecretWord`.
- If the user guesses the same letter twice, we don't care. Can you instead report a specific message, for example, "You've already guessed that letter"? You can do this without any new tools, i.e. without arrays.
- So long as you do not effect the misses-to-output relationship of `Drawing`, the object can return whatever you'd like. Change how the stick figure is drawn.

# Hangman.java
Many students looked at the source code for `SecretWord` and `Drawing` before reading the API documentation. This is fine so long as you *used the API correctly*. Some questions such as...
- "What does `private` mean?"
- "How do I use `wordToHash`?"
- "What's this `HashMap`?"

...were asked because students were trying to figure out *how* `SecretWord` worked rather than what to do with it.

# Review
- Correction: I said, "Everything is an object," and this is not true. We'll talk about this later.
- *Definition:* A *class* is a blueprint for creating objects.
- *Definition:* An *object* is an instance of a class.
- We can create an instance using the `new` keyword, e.g. `String s = new String("Hi");`.
- We can call an object's methods using the *dot-notation*, e.g. `s.charAt(0);`.

# Person.java

Today, we'll be working with a small class, `Person.java`. Please [download](https://github.com/accesscode-2-1/unit-0/blob/master/in-class%20exercise%20solutions/Person.java) it from GitHub.

# Terminology

Let's introduce terminology for ideas that are becoming familiar:

> *Definition:* A *constructor* is a special function that creates an object. It differs from a method in that it has no explicit return type.

Below, `Person` is a constructor. The return value is an object, an instance of type or class `Person`.

```java
Person guy = new Person("Fred");
```

> *Definition:* A constructor (or other methods) can be *overloaded*, meaning the method can take multiple parameters.

```java
Person guy = new Person("Fred", 45);
```

> *Static method:* A *static method* is a method that belongs to a class, not an instance of the class.

You can call a static method directly on the class:

```java
String.format("Formatting the number %d", 9);
```

> *Definition:* A *factory method* is a static method on a class that creates an object.

This is another way of creating objects from classes:

```java
Calendar c = Calendar.getInstance();
```

The biggest difference for us right now is that a factory method is not required to return a new object each time it's called; it could be the same instance every time.

> *Definition:* A *getter* is a method that returns some value from an object.

A getter is just a method but by convention it often follows a simple naming convention `getSomeProperty`. If we want some attribute `foo`, we call `getFoo`. Let's try it with our `Person` class:

```java
String name = guy.getName(); // Stores "Fred" in `name`
```

> *Definition:* a *setter* is a method that sets a value on an object.

```java
// Returns `void` so we don't see anything happen,
// but the internal variable for the person's name will be updated to "Bob".
guy.setName("Bob");
```

# Reference Types

#### Review of types
In Java, every variable has a type. This tells Java...
- How much memory to allocate
- How to interpret that memory

Java has some basic types, such as `int`, `char`, etc. These are called *primitive types*.

A primitive type is a good example of something that is **not** an object.

#### Reference type

Classes allow us to create objects. When we create a new object, we have to declare its type. This is called a *reference type*. Also sometimes referred to as a "class type" or "object type."

```java
Person p = new Person("Fred");
Circle c = new Circle();
Date d = new Date();
Scanner in = new Scanner();
String s = new String("Hello");
```

In the above code, every variable is preceded by a capitalized type, the reference type.

#### What's different?

A variable that stores a reference type stores it differently than a variable that stores a primitive type. When we write...

```java
int n = 9;
```

...the number `9` is actually stored at the memory location of `n`. But what about our `Person` instance?

```java
Person p1 = new Person("Fred", 35);
Person p2;
p2 = p1;
p2.setName("Bob");

// This will print "Bob".
System.out.println(p1.getName());
```

Here, the variables `p1` and `p2` both reference the same object. When we change `p2`, `p1` also changes. This is beause a reference type refers to an object in memory but only stores the memory address of where the object is located.

#### Mutability

To *mutate* means to change while still having the same identity. Some reference types are *mutable* while others are *immutable*. `Person` is mutable. It is possible to change the state of the object. `String`, on the other hand, is immutable.

It's hard to demonstrate that a `String` is immutable. But when you write:

```java
String s = "foo";
s += "bar";
```

You are actually creating a *new* object of type `String` and assigning it to the variable `s`.

#### == vs equals()

The notion of a reference can be tricky; let's look at the `String` class for examples.

> *Definition:* `==` compares by reference.

> *Definition:* `equals()` compares by value.

Let's look at some examples:

This is `true` because they share the same value:

```java
String s1 = "Hello";
s1.equals("Hello");
```

The next two are both `true` but for tricky reasons! The compiler is performing an optimization where it only stores one copy of each distinct string:

```java
"Hello" == "Hello";
s1 == "Hello";
```

This is `true` because the compiler concatenates the Strings at compile time:

```java
System.out.println(s1 == "Hel" + "lo");
```

This is `false` because Java creates two new `String` objects:

```java
new String("Hello") == new String("Hello")
```

#### Null type

`null` is a special type used to indicate:
- Uninitialized state
- Termination condition
- Nonexistent object
- Unknown value

`null` is not an instance of any type.

This is from the Java Language Specification:

> "There is also a special null type, the type of the expression null, which has no name. Because the null type has no name, it is impossible to declare a variable of the null type or to cast to the null type. The null reference is the only possible value of an expression of null type. The null reference can always be cast to any reference type. **In practice, the programmer can ignore the null type and just pretend that null is merely a special literal that can be of any reference type.**"

The important thing is that any reference type can reference `null`:

```java
Person bob = null;
```

You cannot do this with a primitive type:

```java
int n = null;
```

The compiler will tell you that you have incompatible types.

#### toString()

All reference types have a method `toString()`. For example, this won't work because it is a primitive type:

```java
9.toString();
```

But this will:

```java
new Person("Tom").toString()
```

This will make more sense soon, but just know that Java will let you stringify almost anything.


# In-class assignments: BirthdayCalculator.java

Use Java's `Calendar` class to write a program `BirthdayCalculator` that asks a user for their birthday and then tells them how many days there are until their birthday. This is an example program execution:

```
Please enter your birthday:
What is the month (1-12): 7
What is the day (1-31): 4

There are 107 days until your birthday!
```

### The Calendar API

Part of this assignment is to have you starting to get comfortable reading API documentation. [Here](http://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html) is the documentation for `Calendar`. Read the API to see what methods are available to you. To get you started, here's an example method call after creating a `Calendar`:

```java
calendar.get(Calendar.YEAR);
```

`Calendar.YEAR` is called a *field*. Fields are similar to static methods in that we can access them directly from the class. If we call the static method `get` and pass in the correct field, the `Calendar` class returns us some useful information. In this case, it returns the current year.

#### Suggestions
- Start by skimming the API documentation. Do you generally understand the `Calendar` class, the fields, and how to get information from the calendar?
- Calculate what day of the year it is, for example today (19 March) is day 78 of the year.
- Calculate what day of the year the user's birthday is.
- Calculate the difference (this is tricky!).
- Use [WolframAlpha](http://www.wolframalpha.com/) to check your answers.

#### Bonus
- 2016 isn't a leap year, but what if it was? Could you handle it? First read the [algorithm](http://en.wikipedia.org/wiki/Leap_year#Algorithm) on Wikipedia; if that's too complicated, see if the [GregorianCalendar](http://docs.oracle.com/javase/7/docs/api/java/util/GregorianCalendar.html) API can help you.

### Custom Os
In this assignment we are going to build and use a miniature operating system. Our
operating system will allow programs to run that meet our specifications. We
will offer host programs a limited set of commands, and programs will have to
implement interfaces we define.

The commands we will offer are:

```java
public enum SystemCommands {
  READ_INPUT, // Read a single integer from input 0 - 9
  PRINT, // Print out a string
  ADD, // Add two integers
  MULTIPLY // Multiply two integers
}
```

The programs we run will have to have at least one function
```java
SystemCommands getNextCommand();
```

This is the only way for our programs to interface with the operating system,
and will be the function you implement.

Your job will be to write four classes. One do execute each of the following programs:

- Add any two numbers from input
- Add two numbers from input, then add another two numbers from input, then
multiply the two results
- Read numbers from input until you read a 0. Add all numbers and print the
result

To accomplish this, you will need to understand how the operating system
interacts with the computer.

The operating system has enough space for remember only two values. The
following diagram represents two empty memory locations. Memory starts with
default value 0:
[ 0 ] [ 0 ]

#### READ_INPUT
READ_INPUT will push a value into the first memory input.
[ 9 ] [ 0 ]

Another READ_INPUT will push the first memory value into the second location,
and push the new value into the first location
[ 8 ] [ 9 ]

Another READ_INPUT and the second memory location value is lost, being
overwritten by the value in the first location.
[ 7 ] [ 8 ]

#### PRINT
PRINT will print out the value of the first memory location.
// MEMORY contains [ 3 ] [ 5 ]
PRINT // outputs 3

#### ADD
ADD adds the values in both memory locations, stores the value in the first,
and sets the second location to 0
// MEMORY contains [ 3 ] [ 4 ]
ADD
// MEMORY contains [ 7 ] [ 0 ]

#### MULTIPLY
MULTIPLY multiplies the values in both memory locations, stores the value in the
first, and sets the second location to 0
// MEMORY contains [ 3 ] [ 4 ]
MULTIPLY
// MEMORY contains [ 12 ] [ 0 ]

The following is a program that reads an input and then prints the value read:

```java
public class TestProgram implements ICustomOs {

  int mCommandIndex = 0;
  private int mSavedValue;
  private int mInspectedValue;

  List<SystemCommands> mProblem1 = Arrays.asList(
      SystemCommands.READ_INPUT,
      SystemCommands.PRINT,
      SystemCommands.END
  );

  @Override
  public SystemCommands getNextCommand() {
    SystemCommands result = mProblem1.get(mCommandIndex);
    mCommandIndex++;
    return result;
  }
```
#### Assignment
For each problem, you will only have to replace the list mProblem1 in the
example code above. Each solution should look like the following, replacing #
with the problem number:

```java
List<SystemCommands> mProblem# = Arrays.asList(
  // COMMAND 1
  // COMMAND 2
  // COMMAND 3
);

The difficult part of this project is you can not test your solutions without an
instructor, so try your best at understanding the computer architecture fully
and executing the code mentally before asking to run your code for verification.

> **Exercise 1** Add any two numbers from input
> **Exercise 2** Add two numbers from input, then add another two numbers from
input, and then multiply the two results
> **Exercise 3** Read numbers from input until you read a 0. Add all numbers and
 print the result
