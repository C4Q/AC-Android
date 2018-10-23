# Exercises - Lesson 01.21

|Question|
|:-:|
|[01.21.01](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_20_static_factory_enums.md#012101)|
|[01.21.02](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_20_static_factory_enums.md#012102)|
|[01.21.03](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_20_static_factory_enums.md#012103)|
|[01.21.04](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_20_static_factory_enums.md#012104)|

#### 01.21.01

Create an interface called `Scrapper` in a class called `Scrapper.java`.
It should accept a parameterized type of `T`. It should have 3 (three) method signatures:
* `punch`, no parameters, returns nothing
* `kick`, no parameters, returns nothing
* `steal`, 1 (one) parameter called `item` of type `T`, returns nothing

Copy and paste the code you wrote below.

#### 01.21.02

Create an anonymous class, with a static type of `Scrapper` in the `main(String[] args)` method.
Pass it a parameterized type of `String`.
When the `punch` method is called on the anonymous class instance, it should print to the screen: `I punched you!`
When the `kick` method is called on the anonymous class instance, it should print to the screen: `I kicked you!`
When the `grab` method is called on the anonymous class instance, it should print to the screen: `I stole the [[item parameter]]!`

Copy and paste the code you wrote below.

#### 01.21.03

Create a class with a private constructor, and a static factory method called `getInstance()` that returns a single instance of that class, using the class's private constructor, internally.

Copy and paste the code you wrote below.

#### 01.21.04

Create a class called `Lasagna`, in a file called `Lasagna.java`.
This class should have 5 (five) fields of your choosing, and an inner static `Builder` class.
Use this builder to create an instance of the `Lasagna` class.

Copy and paste the code you wrote below.
