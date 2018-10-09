# Exercises - Lesson 01.08

|Question|
|:-:|
|[01.08.01](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_08_Inheritance_and_Encapsulation.md#010801)|
|[01.08.02](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_08_Inheritance_and_Encapsulation.md#010802)|
|[01.08.03](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_08_Inheritance_and_Encapsulation.md#010803)|
|[01.08.04](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_08_Inheritance_and_Encapsulation.md#010804)|
|[01.08.05](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_08_Inheritance_and_Encapsulation.md#010805)|

#### 01.08.01

Create a class called `Fruit` in a file called `Fruit.java`.

This class should have 4 (four) `private` fields:

* `name` of type `String`
* `color` of type `String`
* `flavor` of type `String`
* `seedCount` of type `int`

This class should have a constructor that sets the values of all four fields at the moment of instantiation, and public getter methods for all four fields. 

This class should have a method called 'printCharacteristics`. When called, it should print the values of the class's fields.

For example:

```java
Fruit fruit = new Fruit("Pear", "green", "bittersweet", 8);

fruit.printCharacteristics();
```

should print to the screen:

```java
I am a pear. My color is green. I am bittersweet. I have 8 seeds.
```

Copy and paste the code you wrote below.

#### 01.08.02

Create a class called `Apple` in a file called `Apple.java`.

This class should `extend` from the `Fruit` class in `Fruit.java`.

This class should call the `super()` constructor from within its own custom constructor, and assign the values from its parameters to the super's constructor.

Copy and paste the code you wrote below.
 
#### 01.08.03

Create a class called `Orange` in a file called `Orange.java`.

This class should `extend` from the `Fruit` class in `Fruit.java`.

This class should call the `super()` constructor from within its own custom constructor, and assign the values from its parameters to the super's constructor.

Create a new method called `citrusFruit`. It will return nothing. When called, it should print to the screen:

```
The Orange is a citrus fruit.
```

Copy and paste the code you wrote below.

#### 01.08.04

Create a class called `Peach` in a file called `Peach.java`.

This class should `extend` from the `Fruit` class in `Fruit.java`.

This class should call the `super()` constructor from within its own custom constructor, and assign the values from its parameters to the super's constructor.

This class should also `@Override` the parent class's method `printCharacteristics`. Change the method so that it no longer prints what the parent class prints, but instead prints to the screen:

```I am a Peach. I refuse to follow your rules - I will make my own, thank you very much...```

Copy and paste the code you wrote below.

#### 01.08.05

Instantiate objects from each of the four classes, and assign them all to variables of type `Fruit`.

For example:

```java
Fruit fruit = new Fruit("Pear", "green", "bittersweet", 8);
Fruit apple = new Apple("Apple", "red", "sweet", 8);
Fruit orange = new Orange("Orange", "orange", "acidic sweet", 12);
Fruit peach = new Peach("Peach", "yellow", "sweet", 1);
```

For each class, write down:

* which methods ran as expected
* which methods did not run as expected

Copy and paste your answers below.
