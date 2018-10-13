# Exercises - Lesson 01.11

|Question|
|:-:|
|[01.11.01](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_11_abstract_classes.md#011101)|
|[01.11.02](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_11_abstract_classes.md#011102)|
|[01.11.03](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_11_abstract_classes.md#011103)|
|[01.11.04](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_11_abstract_classes.md#011104)|
|[01.11.05](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_11_abstract_classes.md#011105)|

#### 01.11.01

Create an `abstract` class called `Cephalopod` in a file called `Cephalopod.java`.

This class should have a method called ancestor. It should return nothing. It should print to the screen:

```java
I am a Cephalopod. Cephalopods descended from Mollusks.
```

This class should also have an `abstract` method signature called `tentacleCount`. It should return nothing.

Copy and paste the code you wrote below.

#### 01.11.02

Create a class called `Octopus` in a file called `Octopus.java`.

This class should `extend` from the `Cephalopod` class in `Cephalopod.java`.

This class should have a single `private` field:

* `tentacleCount` of type `int`

This class should have a constructor that sets the values of the field at the moment of instantiation, and public getter methods for the field. 

This class should have a method called 'printCharacteristics`. When called, it should print the values of the class's fields.

For example:

```java
Octopus octopus = new Octopus(8);

octopus.printCharacteristics();
```

should print to the screen:

```java
I am a Octopus. We descended from Cephalopods.
```

This class should also extend the abstract class `Cephalopod` - and override its single abstract method. It should print to the screen:

```java
Octopus Tentacle Count: 8
```

Copy and paste the code you wrote below.
 
#### 01.11.03

Create a class called `Squid` in a file called `Squid.java`.

This class should `extend` from the `Cephalopod` class in `Cephalopod.java`.

This class should have a single `private` field:

* `tentacleCount` of type `int`

This class should have a constructor that sets the values of the field at the moment of instantiation, and public getter methods for the field. 

This class should have a method called 'printCharacteristics`. When called, it should print the values of the class's fields.

For example:

```java
Squid squid = new Squid(10);

squid.printCharacteristics();
```

should print to the screen:

```java
I am a Squid. We descended from Cephalopods.
```

This class should also extend the abstract class `Cephalopod` - and override its single abstract method. It should print to the screen:

```java
Squid Tentacle Count: 10
```

Copy and paste the code you wrote below.

#### 01.11.04

Create an `interface` called `Swimmer` in a file called `Swimmer.java`.

It should contain only one method signature for a method called `swim`. It should return nothing, and have no parameters.

#### 01.11.05

Have both the `Octopus` class and the `Squid` class implement the `Swimmer` interface. Both classes should override the method `swim` so that its actions reflect how each animal flies. For example:

The print output for the method `fly()` called on each object should look like:

```java
// octopus
I am swimming using only my siphons!

// squid
I am swimming using my siphons and fins!
```
