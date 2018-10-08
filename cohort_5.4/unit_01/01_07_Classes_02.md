# Classes 02

## Objectives
- Fellows will learn what wrapper classes are
- Fellows will learn to become comfortable with the subject of auto-boxing and unboxing
- Fellows will learn what `null` is as a value
- Fellows will learn what exception handling is and how to use it
- Fellows will learn read input from a file

## Resources
- [Java Tutorials: Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/)

# Lecture

## Wrapper classes 

A **wrapper class** wraps (encloses) around a data type and gives it an object appearance. Wherever the data type is required as an object, this object can be instead. Wrapper classes include methods to unwrap the object and give back the original data type. 

Instead of:

```java
Integer i = new Integer(9);
```

use this:

```java
Integer i = 9;
```

A primitive-wrapper class in the Java language is one of eight classes provided in the `java.lang package` to provide object methods for the eight primitive types. All of the primitive wrapper classes in Java are immutable. J2SE 5.0 introduced **auto-boxing** of primitive types into their wrapper object, and automatic **unboxing** of the wrapper objects into their primitive value — the implicit conversion between the wrapper objects and primitive values.


| Primitive type  | Wrapper Class | Constructor Arguments |
|---|---|---|
| `byte` | `Byte` | `byte` or `String` |
| `short` | `Short` | `short` or `String`	 |
| `int` | `Integer` | `int` or `String` |
| `long` | `Long` | `long` or `String` |
| `float` | `Float` | `float`, `double` or `String` |
| `double` | `Double` | `double` or `String` |
| `char` | `Character` | `char` |
| `boolean` | `Boolean` | `boolean` or `String` |


## Auto-boxing and unboxing

**Auto-boxing** is the term for getting a reference type out of a value type just through type conversion (either implicit or explicit). The compiler automatically supplies the extra source code which creates the object.

If we move in the opposite direction, then it's called **unboxing**.

![Autoboxing/unboxing](https://github.com/accesscode-2-1/unit-0/blob/master/images/AutoBoxing_UnBoxing.png)

##### Here are a couple of examples:

- Value passed to a variable

```java
// Autoboxing an int value to an Integer object wrapper type
Integer number1 = 25;

// Unboxing an int value from an Integer object into an int value
int number2 = number1;

System.out.println(number1);
System.out.println(number2);
```

#### Why should you care? 

- Auto-boxing/unboxing is heavily used in Java Collections

- Value passed as a parameter

```java
List<Integer> numbers = new ArrayList<Integer>();

numbers.add(5); // Although the add method asks for a parameter of type Integer, we can use 
                // the primitive 5 because it gets automatically auto-boxed into 
                // an object of type Integer implicitly.

numbers.add(6);

System.out.println(numbers.get(0)); // prints 5

System.out.println(numbers.get(1)); // prints 6
```

More on this later!

## Static methods

A **static method** is a method that belongs to a class, not an instance of the class.

You can call a static method directly on the class, for example:

```java
String.format("Formatting the number %d", 9);
```

#### A useful static method of the Integer class:

```java
static int parseInt(String s) 
```

This method parses the string argument as a signed decimal integer.

The following will generate a compiler error:

```java
String stringNumber = "1000"; 
int value = stringNumber;
System.out.println(value);
```

Output:
```java
java: incompatible types
required: int
found: java.lang.String
```

#### Instead use:

```java
// Outputs 1000
String stringNumber = "1000";     
int value = Integer.parseInt(stringNumber);
System.out.println(value);
```

## Exception handling

An **exception** is an event occurring during the execution of a program that disrupts the normal flow of the program's instructions. You may have already encountered some Java exceptions while building and debugging your programs, like `NullPointerException` or `IndexOutOfBoundsException`.

The following block generates a `NumberFormatException`:

```java
String stringNumber = "1000cats";
int value = Integer.parseInt(stringNumber);
System.out.println(value);
```

Valid Java must honor the **Catch or Specify Requirement**. This means code might throw certain exceptions must be enclosed by either of the following:

* A `try` statement that catches the exception.
* A method that specifies that it can `throw` the exception.

Code that does not honor the Catch or Specify Requirement will not compile.

```java
// Try statement catches the exception
// Output: Not a proper integer value!
try {
    String stringNumber = "1000cats";
    int value = Integer.parseInt(stringNumber);
    System.out.println(value);
} catch (NumberFormatException e) {
    System.out.println("Not a proper integer value!");
}
```

```java
// Method specifies that it can throw the exception
public void parseToInteger() throws NumberFormatException {
    String stringNumber = "1000cats";
    int value = Integer.parseInt(stringNumber);
    System.out.println(value);
}
```

**Note:** You should only use try/catch blocks to handle exceptions - not control the flow of execution of your program. If you want to change the direction of your program you should instead use logic to do this - i.e. if/else statements, switch statements, loops, etc.

## What is `null`? (Java don't hurt me, don't hurt me, no more...)

When working with objects, you might have noticed that the unassigned fields of your classes have default values. For primitives, the values seemed predictable: `0` for `int` values, `0.0` for `double` values, `false` for `boolean` values, etc. However, class fields which were unassigned seemed to have an odd default value: `null`.

Fields of a class type which are unassigned possess a `null` value, which describes the absense of a reference to an object. Remember - variables do not store object instances as variables, but instead as references to the object's location in memory. If a field has no reference to an object in memory, its value is said to be `null`.

A developer can run into problems if they try to perform objects of fields which are `null`, since most code is written with the understanding that a field or parameter possesses some sort of value to work with. For example:

```java
class Fruit {
  private String name;

  public String getName() {
    return name;
  }
}

class Main {
  public static void main(String[] args) {
    Fruit apple = null;
    System.out.println(apple.getName()); // this will throw a NullPointerException
  }
}
```

We could easily avoid this by performing a `null` check - effectively checking if a field or variable passed to a parameter is `null` or not:

```java
Fruit apple = null;
if(apple != null) {
  System.out.println(apple.getName());
  }
```

Although this might seem like a good idea, it's more of a quick fix, and should be used sparingly. When you encounter a null object, it is usually caused by one of several reasons:

* the user accidentally passed an non-initialized variable
* the field was not properly assigned a reference
* the user treated `null` as a placeholder

In those situations, it makes sense to either give that field an actual value before using it, or let it throw an exception, so you can better diagnose the problem.

## File I/O

Last week, you learned how to accept user input with a Scanner object. A scanner can also be useful for reading input from a text file because it can break down formatted text into tokens. By default, a scanner uses white space (e.g. spaces, tabs, and `\n` line terminators) to separate tokens.

The following program uses a scanner to read the individual words in `my_text_file.txt` and print each one out on a new line.

```java
public class ScanFile {
    public static void main(String[] args) throws IOException {

        Scanner scanner = null;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader("my_text_file.txt")));
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
```

## Exercises

* TBD
