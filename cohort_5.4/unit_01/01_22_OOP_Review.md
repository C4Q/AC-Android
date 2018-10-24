# OOP Review

## Objectives
* Review what has been covered concerning the Java programming language since the second day of class

## Resources
* [CodingBat]()

### Primitive Data Types
There are 8 (eight) primitive data types in Java:
* `byte`
* `short`
* `int`
* `long`
* `float`
* `double`
* `char`
* `boolean`

All primitive data types are written in lower case.

* `char` and `int` values are effectively interchangeable up to a certain value
* integer division rounds down the value of dividing two whole numbers by each other


### Variable Assignment

Variables can hold either values, or references to objects in memory, depending on their static type. When we declare a variable named `number` of type `int`, we may do the following:

|type|variable name|
|:-:|:-:|
|int|number;|

If we were to print the contents of this value to the screen, we would get an error, because **it is not initialized**. We should assign it a value before we can make any real use of it.

Assignment requires an `=` operator, where we assign a value on the right of the `=`, to a variable of the appropriate data type on the left:

|type|variable name|assignment|value|
|:-:|:-:|:-:|:-:|
|int|number|=|25;|

When a value or reference has been assigned to a variable, we say that **it has been initialized**.

### Comparison Operators

When comparing numerical values, we can use the following operators:

|operator|name|
|:-:|:-:|
|==|equals to|
|>|greater than|
|<|less than|
|>=|greater than or equal to|
|<=|less than or equal to|
|!=|not equal to|

Numerical comparisons result to true/false, or boolean values.

### Logical Operators

Logical operators are used in logical expressions, i.e. - when comparing 1 or more boolean values, or expressions that resolve to boolean values:

|operator|name|
|:-:|:-:|
|&&|AND|
|\|\||OR|
|!|NOT|

`&&` expressions evaluate to `true` if ALL values compared are `true`. Otherwise, they evaluate to `false`.

`||` expressions evaluate to `true` if AT LEAST ONE of the values compared are `true`.

`!` expressions evaluate to the opposite boolean value to the original value given.

### Control Structures

Control Structures redirect the flow of a program's execution based on certain conditions:

```java
if(true) {
  doThisThing();
}
```

You can use an if/else code block to direct a program's flow of execution even further:

```java
if(true) {
  doThisThing();
} else {
  doThatOtherThing();
}
```

If more than one condition needs to be evaluated, you might want to use an if/else if control block:

```java
if(true) {
  doThisThing();
} else if(true){
  doThatOtherThing();
} else {
  doSomethingElseEntirely();
}
```

You can compose a `switch` statement if you want to direct flow based on the value of a variable:

```java
char letter = 'B';
    switch (letter) {
      case 'A':
            System.out.println('A');
            break;
      case 'B':
            System.out.println('B');
            break;
      case 'C':
            System.out.println('C');
            break;
      default:
            System.out.println("Does not compute!");
            break;
    }
```

`break` statements are necessary for breaking out of the switch statement once a case has been met.

Ternary operators can be used to assign variables to values based on certain conditions as well:

```java
String greeting = time < 12 ? "Good Morning! : "Good Afternoon";

```

### Loops

There are 4 (four) loops we've discussed so far:
* while loop
* do-while loop
* for loop
* for-each loop

**While Loop:**

Do a thing as long as a condition evaluates to `true`:

```java
while(number < 10) {
  doThisThing();
  number++;
}
```

**Do-While Loop:**

Do a thing at least once whether the while condition is true or not, then do it again as long as a while condition evaluates to `true`:

```java
do {
  doThisThing();
  number++;
} while(number < 10);
```

**For Loop:**

Set a value for a counter variable, do a thing a certain number of times, as long as a condition evaluates to `true`, and also change the value of a counter variable with each iteration of a loop:

```java
for(int i = 0; i < 10; i++) {
  System.out.println("This loop: " + i);
}
```

**For-Each Loop**

```java
char[] name = {'J', 'o', 's', 'e'};
for(char c : name) {
  System.out.println(c);
}
```

### Strings

Strings are objects in Java, and NOT primitives. 

Concatenation is the process of combining a String with another data type to form a new String:

```java
String newName = "John" + "Doe";
String stringAndChar = "Letter: " + 'A';
String stringAndNumber = "Number: " + 100;
```

For concatenation to be effective, the first element being concatenated MUST be a String.

Strings have certain helper methods associated with them, which can be called on a String object:

|Method|Use Case|
|:-:|---|
|.substring()|allows you to copy and return a range of chars from a String|
|.charAt()|allows you to retreive a particular char in a String at a certain index|
|.length()|allows you to find out the number of chars in a String|
|.charAt(length()-1)|allows you to retreive the last char in a String|
|.toLowerCase|allows to you return a String from another String, where all of the characters are lower case|
|.toUpperCase|allows to you return a String from another String, where all of the characters are upper case|
|String.valueOf()|allows you to convert primitives to Strings|

`StringBuilder` is a helpful class when creating or modifying Strings with loops:

|StringBuilder()|allows you to manipulate a String before it is created|
|new StringBuilder().append()|allows you to append chars and Strings to a StringBuilder object|
|new StringBuilder().reverse()|allows you to reverse the order of chars in a StringBuilder object|
|new StringBuilder().toString()|allows you to return a completed String object as needed|

### Classes

Classes are blueprints for a compact object, containing fields (variables inside a class), methods (functions inside a class), and are based on the idea of real-world objects. Fields are used to store the **state** of an object, while methods are used to modify or exhibit the **behavior** of a class.

This is an example of a class:

```java
class Person {
  private String name;
  private int age;
  
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
  
  public void printNameAndAge(){
    System.out.println("Name: " + this.name);
    System.out.println("Age: " + this.age);
  }
}
```
