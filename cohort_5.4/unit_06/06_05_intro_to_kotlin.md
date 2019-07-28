# Intro to Kotlin

## Objectives

- Describe the components that make up Kotlin.
- Peek under the hood to understand how Kotlin code is compiled and run.
- Describe the eight primitive data types, variable assignment rules and naming conventions.
- Use Kotlin to perform basic arithmetic operations.
- Print output to the console.

## Resources

https://play.kotlinlang.org/koans/Introduction/Hello,%20world!/Task.kt

https://www.udacity.com/course/developing-android-apps-with-kotlin--ud9012

https://www.youtube.com/results?search_query=Kotlin+on+Android

https://github.com/Zhuinden/guide-to-kotlin

## Lecture

Kotlin is a modern programming language developed by JetBrains. It is a statically typed with type infrence that is 100% interoperational with Java meaning that they are able to function together and it is now the preferred language for Android development of Google and many more companies. It should feel similar to Java but it is reworked to be much more concise and easier to write meaning less code needs to be written meaning less logic needs to be tested. It has built in safety to help you stop NullPointerExceptions and avoid plenty of other coding mistakes.

### Hello World

```java
fun main(args: Array<String>){
    print("Hello World")
}
```

As opposed to java when we want to declare a main function it does not need to be in the class here the main method moves to the package level above the class. This method returns an object of type Unit which is similar to void in Java and will take an array of Strings as a param

`Semi colons are optional`

You can compile this code uing Kotlin's compiler like this

```
kotlinc hello.kt
kotlin HelloKt
```

#### Variables and Data Types

Variables are locations in memory that store some kind of data. They will have a name and a data type. The type of the variable will set the range of values that variable could possibly have

A variable is either declared using the var or val keywords.

A variable declared using val will be immutable (read-only) it cannot be reassigned after it is initialized

```java
val name = "Margaret Hamilton"
name = "Apollo 11" // Error: Val cannot be reassigned
```

If you want to be able to change the variable, you would use the var keyword

```java
var program = "Saturn"
program = "Apollo" // This works
```

#### Type Inference

Notice that the types of the variables were not declared earlier.

Kotlin is statically typed but it does not require you to specify the type of the variable you are writing. It will infer what the type of a variable should based off of the initializing expression.

```kotlin
val message = "Hello, World" // Type would be inferred as `String`
val year = 2019 // Type would be inferred as Int
```

But if you want to explicitly state the type of the variable you would do this

```kotlin
val message: String = "Hello World"
val year : Int = 2019
```

However type declaration is mandatory if you are not going to intialize the variable when you declare it since it will no longer have anything to infer from / make a guess about they type

```java
// Error the variable must either hava a type or be initialized
var change
change = 0.05

var change: Double // Works
change = 0.05
```

#### Data Types

Similar to Java, Kotlin has the types Byte, Short, Int, Float, Double, Boolean, Char, String

But in Kotlin everything behaves like an object so instead of just having seperate primitive types  int and wrappers like Integer. We would just be using the type classes.

Here are some examples of number types

```java
val myInt = 1025
val myLong = 1000L // Suffix L specifies a long
val myFloat = 126.78f // Suffix f or F represents Float
val myDouble = 325.49
```

#### Arrays

To create arrays we use the Array class and use the function arrayOf. We can have mixed values in an array but it is preferrable to declare the data type of the array and stick to a single type.

```java
var numbers = arrayOf(1,2,3)
var letters = arrayOf<Char>('a','b','c')
```

#### Type Conversion

Kotlin does not support functionallity like implicit type conversion. This would be like in java when you can pass a value of type int into a variable of type double and it would automatically accept and convert that value to a double.

```java
// this works
Double myNumber = 2
```

Instead conversion is handled by calling helper functions that explicity convert one type to another

```java
// Error variable of Type Double is being given an Integer instead
var myNumber : Double = 2
val myInt = 200
// This works
val myDouble = myInt.toDouble()
val myString = myDouble.toString()
```

### Control Flow

#### if and else

if statements can be used as an expression instead of a statement so a variable can be used to represent the result of an if-else statement

```java
var a = 32
var b = 55

var max = if(a > b) a else b

// String interpolation is started by  adding a $ followed by the variable name to a string and the compiler looks for this value earlier and add this to the string
println("max($a, $b) = $max")
```

#### when

When is a replacement for the standard switch statement in Java

```java
var dayOfWeek = 4

when(dayOfWeek) {
    1 -> println("monday")
    2 -> println("tuesday")
    3 -> println("wednesday")
    4 -> println("thursday")
    5 -> println("friday")
}

// Similar to if and else statements the result of a when statement can be saved as a variable
val someday = when(dayOfWeek) {
    1 -> someday = "Monday"
    2 -> someday = "Tuesday"
    3 -> someday = "Wednesday"
    4 -> someday = "Thursday"
    5 -> someday = "Friday"
}

/* when branches can be combined by using one comma
 can check if value is within a certain rain using the in val ... val notation or can check if something is the same data type the key word is would be used*/

dayOfWeek = 7

when(dayOfWeek) {
    in 1..5 -> println("Weekday")
    6, 7 -> println("Weekend")
    is !Integer -> print("Not a number")
}  

```

#### For loops

looping through an array is similar to java but instead the keyword ```in``` is used, Arrays in kotlin have the property indices which will give you the range of indexes of an array

```java
val fibNumbers = arrayOf(0,1,1,2,3,5,8)

for(index in fibNumbers.indices) {
    println(fibNumbers[index])
}
```

### Nulls

Avoiding nullpointer exceptions is a guard built into Kotlin. Nullability is part of the type system meaning that we are able to declare whether a variable can be a null value or not.

This means NullPointerExceptions are caught in compile time reducing how many we errors we would encounter. Variables are non nullable by default, to allow null values a question mark ```?``` needs to be appended next to type declaration of a variable

```java
val nullableMessage: String?
nullableMessage = null
```

There are times though that we might have to work with nullable variables so in order to safely call methods/operations on a null value we need to do a safe call which means adding a question mark before the method call these can be chained.

```java
nullableMessage?.toLowerCase()
```

this safely prints out the null value but if a value is set then it would print the message in lowercase

If we dont want to do anything if the value is null we can instead perform a ```let``` operation instead of having to write a null check if statement.

```java
val nullableMessage: String? = null

nullableMessage?.let {
    println(it.toUpperCase())
}
```

The lamda inside of the let will only execute if the variable is not null.

Finally if we want to provide a default value to the variable if it is null we can use an elvis operator ```?:```

```java
val message = nullableMessage ?: "Hello"
```

Basically the elvis operator will take two values and return the first if it is not null otherwise it will return the default value.

### Functions

Every function has a function name, a list of comma seperated params, and a method body similar to java.

Return types however are optional due to the inferences made about type.

If the function will only return a single value then return type and curly braces can be skipped and the operation itself is returned

```java
fun mean(a: Int, b: Int) = (a+b)/2
```

#### Default arguments

Default arguments can be specified for a functions parameter. The default value will be used when the argument is not passed in during the function call

```java
    // if not value is passed in for message "World" will be used
    fun sayHello(greeting: String, message: String = "World") {
        print("$greeting, $message")
    }
```

#### Named Args

Alternatively if you dont want to specify the values but want to specify the names of the arguments getting passed into the function you can map what value corresponds to what variable, This makes method calls much easier to read especially if you run into a method with lots of params to pass in.

```java
fun multiMathSum(a: Int, b: Int, c: Int, d :Int) {
  return a + b + c + d
}

// calling this method is easy
multiMathSum(a = 100, b = 2000, c = 30000, d = 10000)
```

#### Variable number of arguments

Finally if the number of parameters that you need to pass to a function will be unknown you should use vararg key words in the function.

```java
fun multiNumberSum(vararg nums : Float) : Float {
    val sum : Float = 0.0f
}

multiNumberSum(5f,6f,7f,8f,9f,10f)
```

In this case that you have more variables as parameters other than the vararg then when passing in values to the function you will need to Name the arguments during the function call

```java
fun multiNumberSum(vararg nums : Float, message : String) : Float {
    val sum : Float = 0.0f
}

multiNumberSum(1f,2f,3f,4f,5f,6f, message = "Hello")
```
