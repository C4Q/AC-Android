# Generics

# Objectives

* Review extending abstract classes
* Master reading types and Generic notation
* Understand when to use generics
* Review techniques to organize code in an object-oriented fashion.

# Resources

* [Video - Generics](https://www.youtube.com/watch?v=rOBtgaXaba0)
* [Video - Wildcards](https://www.youtube.com/watch?v=QqLBp7MdkEU)
* [Java Docs](https://docs.oracle.com/javase/tutorial/java/generics/types.html)

# Lecture

Recall that abstract classes are a special kind of class that are used just for inheritance and that cannot be instantiated?

Why would we use an abstract class over an interface? 
* An interface defines what an object can do, while... 
* An abstract class defines what an object is.

Distinct instances of the same type of object may need to be capable of representing different types of data. Java's Collections framework leverages Java's static typing to eliminate errors for end users (the programmers who will use these collections).

Think back to our examples of the `HashMap` and `ArrayList` data structures.

```java
// HashMap line of Inheritance
public class HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>{

}
```
```java
// ArrayList line of Inheritance
public class ArrayList<E> extends AbstractList<E> implements List<E>{

}
```

We can see that the HashMap class, its Abstract parent class, and implemented interface all have a reference to some K type for key, and V type for value- and for the ArrayList class, its Abstract parent class, and implemented interface all have a reference to some E type for element. 

```java
Map<String, Integer> map = new HashMap<>(); //Good

List<Integer> numbers = new ArrayList<>();  //Good
```

The above example is preferred, because Inheritance and Polymorphism allows us to swap out different dynamic instance types that extent from the classes used as the static type, if our current implementation demands it. 

It is also preferred because it is best practice to specify the parent types as static variable types when declaring and creating new instances of concrete objects like `HashMap` and `ArrayList`, and pass in parameterized return types in the angle brackets (also known as diamond operators). Parameterized return types leverage the power of something called **Generics**.

## Generics

Generic types, or generics for short are the secret to being able to specify a certain type when creating our earlier instances of HashMaps and ArraysLists.

Generics allow us to create a class that works for any Object, while the type isn't specified until instantiation. The syntax for Generics is angle brackets and an uppercase letter, e.g. ArrayList<E>. Some interesting things to note:

You can think of a type parameter as a placeholder for a type to be specified at the time the parameterized type is used, just as a formal method argument is a placeholder for a value that is passed at runtime.

Prior to Java 1.6, implementations of the Collections library required that the elements be implicitly upcasted to type `Object`, before being passed into these data structures, then be downcasted back into their original data types:

```java
List list = new ArrayList();
list.add("hello");
String s = (String) list.get(0);
```
In the above example, "hello" is a `String` object which extends from `Object`, so it is passed in without a problem. However, when the `.get()` method is called on that `list` object, it returns an element of type `Object`, which then must be downcasted back to a `String`. Downcasting, as we already know, can be dangerous if we get it wrong. This is why parameterized return types can be so useful.

### More on Generics

List<E> is read as "list of E", and List<String> is read as "list of string", where String is the actual type parameter.

Generics enhance Java with special syntax for dealing with entities, such as Lists, that you commonly want to step through element by element. If you want to iterate through ArrayList, for instance, you could write code like:

```
for (String s : myArrayList) {
    String s = System.out.println(s);
  }
```

This syntax works for any type of object that is Iterable (that is, implements the Iterable interface).

### Benefits of Generics

* Stronger type checks at compile time. Fixing compile-time errors is easier than fixing runtime errors
* Enabling programmers to implement generic algorithms
* Better code reusability: By using generics, programmers can implement generic algorithms that work on collections of different types, can be customized, and are type safe and easier to read.

### Naming type parameters

The recommended naming convention is to use uppercase, single-letter names for type parameters. For common generic patterns, some recommended names are:
K - A key, such as the key to a map
V - A value, such as the contents of a List, Set, or the values in a Map
E - Element - Can also be An exception class
T - A generic type

## Creating classes with Parameterized Types





Any parameter we pass to add would have to be a subtype of this unknown type. Since we don't know what type that is, we cannot pass anything in. The sole exception is null, which is a member of every type.

### Bounded WildCard

![Bounded WildCard](http://i.imgur.com/6ofVsCK.png)
