# Pursuit Android 5.4 Homework 01.01

### 01.01.01 add

Write a method named `add` that takes in two `int` numbers as arguments. The method should return and int as well - the sum of the two numbers.

Examples:
```java
add(1,2);  // returns 3
add(10,12);  // returns 22
```

### 01.01.02 calculateAge

Write a method named `calculateAge` that takes two `int` arguments: birth year and current year. The method should then calculate the two possible ages based on that year, returns absolutely nothing, but instead prints a `String` to the console in the following format: (replacing 'NN' with the possible years) : "You are either NN or NN."

Examples:

```java
calculateAge(1987, 2016);  // prints 'You are either 28 or 29.'
```

### 01.01.03 XO

Write a method named `XO`, that checks to see if a `String` has the same count of 'x's and 'o's. The method must return a boolean and be case insensitive (meaning 'X' is the same as 'x', 'O' is the same as 'o', etc). The `String` may contain any Unicode character -- not just 'x's and 'o's -- and may be of any length.

Example outputs:
```java
XO("ooxx")    // returns true
XO("xooxx")   // returns false
XO("ooxXm")   // returns true
XO("zpzpzpp") // returns true because zero 'x's and 'o's are present
XO("zzoo")    // returns false
```

### 01.01.04 endsly

Write a Java method called `endsly` that takes a `String` as a parameter, and returns `true` if it ends in "ly".

Example outputs:
```java
endsly("absolutely"); // returns true
endsly("powdered"); // returns false
endsly("politely"); // returns true
```

### 01.01.05 scanner-hungry-hippos

Hippos only like to eat foods that begin with the letter 'h'. In an effort to reduce food waste, the local zoo has hired you to write a Java program that can predict whether or not the hippos will eat a given food.

While running, your program should prompt the user to enter a food. If the food is one that hippos like to eat, the program should print "Yum!" -- otherwise, it should print "Yuck!".

For example:
```
Enter a food:
hot dogs
Yum!
Enter a food:
HAMBURGERS
Yum!
Enter a food:
frozen yogurt
Yuck!
```

### 01.01.06 string-elide

Write a method called `elide` that takes a `String` parameter.  For longer strings, the method returns a new string constructed out of the first three letters of the argument, followed by three periods (`"..."`), followed by the last letter of the argument.

However, if the resulting string is not shorter than the argument, the method should return the argument instead.

For example,

```java
elide("Hello!")               // returns "Hello!"
elide("Hello, world!")        // returns "Hel...!"
elide("That's not my name.")  // returns "Tha...."
```

Remember that `String.substring()` can take two arguments: the start index and the end index.

### 01.01.07 triangle

Write a loop that will print the following triangle to the console:

```
#
##
###
####
#####
######
#######
```

### 01.01.08 countCode

Write a Java method called `countCode` that takes a `String` parameter, and returns the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.

For example:

```
countCode("aaacodebbb") → 1
countCode("codexxcode") → 2
countCode("cozexxcope") → 2
```

### 01.01.09 countTheVowels

Write a method called `countTheVowels` that accepts a `String` as a parameter and counts the number of vowels within the string (vowels include a, e, i, o , u - don't count 'y'). The method should return the number of vowels, as an `int`, in the String.

Example output:
```java
vowelCount("test String"); // returns 2
vowelCount("longer string with more vowels"); // returns 8
```

### 01.01.10 cut-a-string-at-character

Write a method named `subStrAfterChars` to return a part of a `String` after a specified character. The method should take two arguments, the first being the `String`, and the second being the character as a `char`. The method should return only the part of the string that comes AFTER the specified character. In other words, the method should chop the string into two parts and return only the part that comes after the specified character.

Examples:
```java
subStrAfterChars("this is a test string", 'a') // returns " test string"
subStrAfterChars("this is another test", 'o') // returns "ther test"
```

### 01.01.11 stringToIntConverter

Write a method called `stringToIntConverter`. This method should accept one argument of type `String` that is a whole number. It should return an `int` value of the number passed as a `String`.

Examples:
```java
stringToIntConverter("25"); // returns the number 25
stringToIntConverter("Some String"); // should throw a NumberFormatException
```

### 01.01.12 reverseString

Write a method called `reverseString`. This method should accept a single argument of type `String`. This method should return a new `String`, which is the same as the original parameter, only in reverse.

Example output:
```java
reverseString("reverse"); // returns the String "esrever"
```

### 01.01.13 Car Class

Compose a `class` named `Car`. This class should have three private properties:

* a `model` field of type `String`
* a `year` field of type `String`
* a `mileage` field of type `int`

This `Car` class should also have a constructor that sets the values of all three fields at instantiation.

Each property should have its own public "getter" method.

### 01.01.14 Static and Instance

Compose a `class` called `MethodType`. This class should have a default constructor, and two private fields:

* a static field called `first` of type `String`
* a non-static field called `second` of type `String`

Assign the value "I belong to the class" to the `first` field.

Assign the value "I belong to an instance of the class" to the `second` field.

Create public "getter" methods that will work effectively for each field.

Example outputs:
```java
MethodType methodType = new MethodType();
System.out.println(MethodType.getFirst()); // this should work
System.out.println(MethodType.getSecond()); // this should cause an error
System.out.println(methodType.getFirst()); // this should work
System.out.println(methodType.getSecond()); // this should work as well
```
