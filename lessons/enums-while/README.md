- title: Enums and While Loops
- tags: java enums while loops

#Objectives
-Enums
-Write a While Loop
-How Android is built from Java

#Resources
-[Enum Types](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)
-[Activity Lifecycle](https://developer.android.com/training/basics/activity-lifecycle/starting.html)
-[Android Architecture](https://source.android.com/devices/)
-[Android Open Source Project](https://source.android.com/)

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

### How Android is built from Java
Java is a programming language that can be used to build any program a
developer conceives of. Android is a collection of applications and interfaces,
referred to as a stack, that allow Java programs to interact with hardware.

Programs that mediate interaction with physical hardware are called operating
systems. Most people are familiar with Windows from Microsoft and iOS from
Apple, but the number one used operating system in the world is Linux, an open
source operating system created and maintained by Linus Torvalds. Linux is
the operating system that most routers, internet and corporate servers run.
Linux is a favorite with developers because the source code is freely available.
Windows and iOS do not give access to their source code.

Android is based off of the Linux operating system, and any device running
Android is also running Linux. Android is a collection of java classes and
programs that communicate with the Linux operating system running on the device.
Android is also open source, and that source code is maintained by the Android
Open Source Project (AOSP), a collaboration of companies that contribute to the
source.

Most people are familiar with Google's version of Android, which is a fork of
the AOSP codebase. Google modifies the code to add in extra services, including
the Play Store and Google Maps. This version of the code is then sent to mobile
carriers such as Verizon or AT&T, who modify the code to add in carrier specific
applications and services. This carrier version of the code is eventually loaded
onto the phones you can buy in Best Buy. Because the code is open source, it is
possible for any programmer to build a hardware device, including a cell plhone,
and run the AOSP code, as long as the hardware meets required specifications.

The same way Android is built out of Java classes, any Java developer can build
a system as complicated. Nor must one choose Java as the language to design it
in. Many programming languages exist, each one expressing logic in a different
pattern. Learning a different programming language will often teach you to think
about code in a new way.
