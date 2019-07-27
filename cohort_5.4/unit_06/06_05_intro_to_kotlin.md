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

Kotlin is a modern programming language developed by JetBrains. It is a statically typed with type infrence that is 100% interoperational with Java meaning that they are able to function together and it is now the preferred language for Android development by Google. It should feel strangely similar to Java but is reworked to be much more conise and easier to write meaning less code needs to be written meaning less code needs to be tested. It has built in safety to help you stop NullPointerExceptions and avoid plenty of other mistakes.

### Hello World

```kotlin
fun main(args: Array<String>){
    print("Hello World")
}
```

We declare a package level function main which returns an object of type Unit and will take an array of Strings as a param

`Semi colons are optional`

You can compile this code uing Kotlins compiler like this 

```
kotlinc hello.kt
kotlin HelloKt
```

#### Variables and Data Types

variables are locations in memory that store some kind of data. They will have a name and a data type. The type of the variable will set the range of values that variable could possibly have

A variable is either declared using the var or val keywords.

A variable declared using val will be immutable (read-only) it cannot be reassigned after it is initialized

```kotlin
val name = "Margaret Hamilton"
name = "Apollo 11" // Error: Val cannot be reassigned
```

If you want to be able to change the variable, you would use the var keyword

```kotlin
val program = "Saturn"
program = "Apollo" // This works
```

#### Type Inference

Notice that the types of the variables variables were not declared earlier.

Kotlin is statically typed but it does not require you to specify the type of the variable you are writing. It will infer the type of a variable from the initializing expression

```kotlin
val message = "Hello, World" // Type would be inferred as `String`
val year = 2019 // Type would be inferred as Int
```

But if you want to explicitly state the type of the variable you would do this

```kotlin
val message: String = "Hello World"
val year : Int = 2019
```

However type declaration is mandatory if you are not going to intialize the variable when you declare it

```kotlin
/*
Error the variable muse either hava a type or be initialized
var change
change = 0.05
*/

var change: Double // Works
change = 0.05
```

#### Data Types

Similar to Java Kotlin has the same types like Int, Double, Boolean, Char

But in Kotlin everything is an object / behaves like an object instead of just having seperate primitive types  int and wrappers like Integer.

Here are some examples

```kotlin
val myInt = 1025
val myLong = 1000L // Suffix L specifies a long
val myFloat = 126.78f // Suffix f or F represents Float
val myDouble = 325.49
```

#### Arrays

To create arrays we use the Array class and use the function arrayOf we can have mixed values but it is preferrable to declare the data type of the array

```kotlin
var numbers = arrayOf(1,2,3)
var letters = arrayOf<Char>('a','b','c')
```

#### Type Conversion

Kotlin supports conversion by calling helper functions that explicity convert one type to another

```kotlin
val myInt = 200
val myDouble = myInt.toDouble()
val myString = myDouble.toString()
```

### Control Flow


#### if and else

if statements can be used as an expression instead of a statement so a variable can be used to represent the result of an if-else statement

```kotlin
var a = 32
var b = 55

var max = if(a > b) a else b
println("max($a, $b) = $max")
```

#### when

When is a replacement for the standard switch statement

```kotlin
var dayOfWeek = 4

when(dayOfWeek) {
    1 -> println("monday")
    2 -> println("tuesday")
    3 -> println("wednesday")
    4 -> println("thursday")
    5 -> println("friday")
}

val someday = when(dayOfWeek) {
    1 -> println("monday")
    2 -> println("tuesday")
    3 -> println("wednesday")
    4 -> println("thursday")
    5 -> println("friday")
}

/* when branches can be combined by using one comma
 can check if value is within a certain rain using the in val ... val notation or can check if something is equal using the is keyword */

dayOfWeek = 7

when(dayOfWeek) {
    1,2,3,4,5 -> println("Weekday")
    in 6..7 -> println("Weekend")
    is 10 -> println("none of the above")
}  

```

#### for loops

looping through an array is similar to java but instead the keyword in is used an arrays in kotlin have the property indices which will give you the proper indexes of the array

```kotlin
val fibNumbers = arrayOf(0,1,1,2,3,5,8)

for(index in fibNumbers.indices) {
    println(fibNumbers[index])
}
```

### Nulls

Avoiding nullpointer exceptions is a guard built into Kotlin. Nullability is part of the type system meaning that we are able to declare whether a variable can be a null value or not.

This means NullPointerExceptions are caught in comile time reducing how many we would encounter variables are non nullable by default to allow null values a question mark needs to bne appended next to type declaration of a variable

```kotlin

val nullableMessage: String?

nullableMessage = null
```

There are times though that we might have to work with nullable variables so in order to safely call methods/operations on a null value we need to do a safe call.

```kotlin
nullableMessage?.toLowerCase()
```

this safely prints out the null value but if a value is set then it would print the message in lowercase

If we dont want to do anything once the value is null we can instead perform a let operation. 

```kotlin
val nullableMessage: String? = null

nullableMessage?.let {
    println(it.toUpperCase())
}
```

the lamda inside of the let will only esecute if the variable is not null.

Finally if we want to provide a default value if the variable is null we can use an elvis operator ?:

```kotlin
val message = nullableMessage ?: "Hello"
```

basically the elvis operator will take two values and return the first if not null otherwise it will return the default value.

### Functions

Every function has a function name a list of comma seperated params and a method body similar to java.

Return types however are optional due to the inferences made about type.

If the function will only return a single value then return type and curly braces can be skipped.

```kotlin
fun mean(a: Int, b: Int) = (a+b)/2
```

#### Default arguments

Default arguments can be specified for a functions parameter. The default value will be used when the argument is not used during the function call

```kotlin
    fun sayHello(message: String, greeting: String = "World") {
        print($message, $greeting)
    }
```

#### Named Args

alternatively if you dont want to specify the values but want to specify the names of the arguments getting passed into the function you can, This makes methods much easier to read especially if you run into a method with lots of params to pass in. 

```kotlin
fun multiMathSum(a: Int, b: Int,
d: Int :Int {
 return a + b + c
})

// calling this method is easy

mathSeriesSum(a = 100, b = 2000, c = 30000)
```

#### Variable number of arguments

Finally if the number of parameters that you need to pass to a function will be unknown you should use vararg key word in the function.

```kotlin
fun multiNumberSum(vararg nums : Float) : Float {
    val sum : Float = 0.0f

}
```
