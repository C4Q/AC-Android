# Exercises - Lesson 01.10

|Question|
|:-:|
|[01.10.01](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_09_interfaces.md#011001)|
|[01.10.02](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_09_interfaces.md#011002)|
|[01.10.03](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_09_interfaces.md#011003)|
|[01.10.04](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_09_interfaces.md#011004)|
|[01.10.05](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_09_interfaces.md#011005)|

#### 01.10.01

Create a class called `Bird` in a file called `Bird.java`.

This class should have a single method called ancestor. It should return nothing. It should 

Copy and paste the code you wrote below.

#### 01.10.02

Create a class called `Parrot` in a file called `Parrot.java`.

This class should `extend` from the `Bird` class in `Bird.java`.

This class should have 3 (three) `private` fields:

* `food` of type `String`
* `lifespan` of type `int`
* `biome` of type `String`

This class should have a constructor that sets the values of all 3 fields at the moment of instantiation, and public getter methods for all 3 fields. 

This class should have a method called 'printCharacteristics`. When called, it should print the values of the class's fields.

For example:

```java
Parrot parrot = new Parrot("fruits", 80, "tropical");

parrot.printCharacteristics();
```

should print to the screen:

```java
I am a Parrot. I like to eat fruit. I live in a tropical environment. I can live to be about 80 years.
```

Copy and paste the code you wrote below.
 
#### 01.10.03

Create a class called `FruitBat` in a file called `Bat.java`.

This class should have 3 (three) `private` fields:

* `food` of type `String`
* `sleepStyle` of type `String`
* `home` of type `String`

This class should have a constructor that sets the values of all 3 fields at the moment of instantiation, and public getter methods for all 3 fields. 

This class should have a method called 'printCharacteristics`. When called, it should print the values of the class's fields.

For example:

```java
FruitBat fruitBat = new FruitBat("fruits", "nocturnal", "cave");

parrot.printCharacteristics();
```

should print to the screen:

```java
I am a Fruit Bat. I like to eat fruit. I am nocturnal. I live in a cave.
```

Copy and paste the code you wrote below.


#### 01.10.04

Create an `interface` called `Flier` in a file called `Flier.java`.

It should contain only one method signature for a method called `fly`. It should return nothing, and have no parameters.

#### 01.10.05

Have both the `Parrot` class and the `FruitBat` class implement the `Flier` interface. Both classes should override the method `fly` so that its actions reflect how each animal flies. For example:

The print output for the method `fly()` called on each object should look like:

```java
// parrot
I am flying using colorful feathers!

// fruit bat
I am flying using leathery wings!
```
