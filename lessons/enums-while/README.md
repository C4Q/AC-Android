- title: Enums and While Loops
- tags: java enums while loops

#Objectives
-Enums
-Write a While Loop
-The relationship between Java and Android

#Resources
-[Enum Types](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)
-[Activity Lifecycle](https://developer.android.com/training/basics/activity-lifecycle/starting.html)
-[Android Architecture](https://source.android.com/devices/)

#Lecture
### Enums
Enums are used to represent constant values in code, that are related to each
other. Since our goal is to always write code that is self explanatory, enums
are a great tool for replacing magic numbers in code. For example, which is
easier to understand:

```java
// readGuest returns a number from System.in that represents a guest number
int input = readGuest();
switch (input) {
case 1:
  System.out.println("hello Tom");
	break;
case 2:
	System.out.println("hello Bob");
	break;
case 3:
	System.out.println("hello world");
	break;
default:
	System.out.println("I don't know this person");
}
```

compared to the following

```java
// Define an enum to represent our guests
enum Guest {
  TOM,
  BOB,
  THE_WORLD,
  UNKNOWN
}
```
```java
// readGuest returns a Guest that represents a number from System.in
Guest input = readGuest();
switch (input) {
case TOM:
  System.out.println("hello Tom");
	break;
case BOB:
	System.out.println("hello Bob");
	break;
case THE_WORLD:
	System.out.println("hello world");
	break;
default:
	System.out.println("Can't say hello that many times");
}
```

Enums can not be defined within functions. They are often used to describe nouns
or states in a code base.

### The relationship between Java and Android
Java is a programming language that can be used to build any program a
developer conceives of. Android is a collection of applications and interfaces,
referred to as a stack, that allow Java programs to interact with hardware.
Android is based off of the Linux operating system, and any device running
Android is also running Linux. The same way Android is built out of Java
classes, any Java developer could build a system as complicated. Nor must one
choose Java as the language to design it in. Many programming languages exist,
each one expressing logic in a different pattern. Learning a different
programming language will often teach you to thick about code in a new way.
