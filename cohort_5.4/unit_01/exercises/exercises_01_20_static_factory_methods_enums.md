# Exercises - Lesson 01.20

|Question|
|:-:|
|[01.20.01](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_20_static_factory_enums.md#012001)|
|[01.20.02](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_20_static_factory_enums.md#012002)|
|[01.20.03](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_20_static_factory_enums.md#012003)|
|[01.20.04](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_20_static_factory_enums.md#012004)|

#### 01.20.01

Create a class called `Drawer<T>`, in a file called `Drawer.java`.
It should have a single field called `drawerContents`, of type `T`.
It should have a constructor that sets the value of `drawerContents` at instantiation.
It should have getters and setters of the appropriate type.

Copy and paste the code you wrote below.

#### 01.20.02

Create an enum called `MoonPhase`, in a file called `MoonPhase.java`. This enum should have 8 (eight) constants:

* NEW_MOON
* WAXING_CRESCENT
* FIRST_QUARTER
* WAXING_GIBBOUS
* FULL_MOON
* WANING_GIBBOUS
* THIRD_QUARTER
* WAXING_CRESCENT

Copy and paste the code you wrote below.

#### 01.20.03

Using the enum created above, create a method that returns nothing, accepts a parameter of type `MoonPhase`, and has a `switch` statement accounting for every phase of the moon.
This method should print a description of the phase passed in as a parameter. 

Copy and paste the code you wrote below.

#### 01.20.04

Create a class of your choosing with a private default constructor.
It should have a private static field of the data type of the class you created, the field should be called `instance`.
Create a public static method called `getInstance`, that checks that the value of `instance` is not null.
If it is, assign it the value of a new instance of the class, using the private constructor.
If it already has a value, return that value.

Copy and paste the code you wrote below.
