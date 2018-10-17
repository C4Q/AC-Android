# Exercises - Lesson 01.16

|Question|
|:-:|
|[01.16.01](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_16_inheritance_and_polymorphism.md#011601)|
|[01.16.02](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_16_inheritance_and_polymorphism.md#011602)|
|[01.16.03](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_16_inheritance_and_polymorphism.md#011603)|
|[01.16.04](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_16_inheritance_and_polymorphism.md#011604)|
|[01.16.05](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_16_inheritance_and_polymorphism.md#011605)|

#### 01.16.01

Create a class called `Monster` in a file called `Monster.java`.

This class should have 3 (three) `private` fields:

* `food` of type `String`
* `habitat` of type `String`
* `attackWeapons` of type `String`

This class should have a constructor that sets the value of each of its fields at the moment of instantiation.

This class should also have the following public methods:

* `whoAmI()`, which returns nothing, but prints a sentence to the screen. For example, if the following code is called:

```java
Monster monster = new Monster("people", "anywhere", "anything");
monster.whoAmI();
```

should print the following to the screen:

```
I am a Monster. I live anywhere, and I attack with my anything"
```

Use the simple class name for the current instance of the class to print the name of the monster type.

Copy and paste the code you wrote below.

#### 01.16.02

Create a class called `Vampire` in a file called `Vampire.java`.

This class should extent the `Monster` class.

Create a custom constructor that calls the parent's constructor at the moment of instantiation.

Add a new field called `weakness`, and add a setter and getter for this new field.

Copy and paste the code you wrote below.
 
#### 01.16.03

Create a class called `Werewolf` in a file called `Werewolf.java`.

This class should extent the `Monster` class.

Create a custom constructor that calls the parent's constructor at the moment of instantiation.

Add a new field called `transformationTime`, and add a setter and getter for this new field.

Copy and paste the code you wrote below.

#### 01.16.04

Create a class called `LagoonMonster` in a file called `LagoonMonster.java`.

This class should extent the `Monster` class.

Create a custom constructor that calls the parent's constructor at the moment of instantiation.

`@Override` the parent's method called `whoAmI()`, so that when called, it instead prints to the screen:

```
I am not a LagoonMonster. I am a Fish God and I heal good people.
```

Copy and paste the code you wrote below.

#### 01.16.05

Add each of the previously created instances into a `HashMap` object which accepts objects of type `String` as keys, and objects of type `Monster` as values. Use the simple name of each class for each instance as a key, and each instance as a value.

Create a for-each loop to iterate through every `String` key, get its value, then run the method `whoAmI()` on each value obtained.

Copy and paste the code you wrote below.
