# Exercises - Lesson 01.19

|Question|
|:-:|
|[01.19.01](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_19_generics.md#011901)|
|[01.19.02](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_19_generics.md#011902)|
|[01.19.03](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_19_generics.md#011903)|
|[01.19.04](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_19_generics.md#011904)|
|[01.19.05](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_19_generics.md#011905)|

#### 01.19.01

Create an instance of an `ArrayList` object, and store it in a variable of type `List<E>`.
Replace the `E` with a data type of your choosing.

Copy and paste the code you wrote below.

#### 01.19.02

Create a class called `StackList<E>` in a file called `StackList.java`.
It should have one field called `myStack`, of type `List<E>`.
It should have a constructor with a parameterized type of `<E>`, and set the value of `myStack` to `new ArrayList<>();`.

It should have two public methods:
* `push(E element)`, which returns nothing, and adds the parameter to the `ArrayList` instance
* `pop()`, which returns the last item in the `ArrayList`, then deletes it. If the `ArrayList` is empty, print that the method failed, and do nothing.
* `size(), which returns the size of the `ArrayList`

Copy and paste the code you wrote below.

#### 01.19.03

Create a class called `Coordinates<T1, T2>` in a file called `Coordinates.java`.
It should have 2 (two) fields:
* `lat`, of type `T1`
* `long`, of type `T2`

It should have a constructor with parameterized types of `<T1, T2>`, and parameters that set the values of `lat` and `long`.

It should have 2 (two) public methods:
* `getLat()`, which returns the value of `lat`
* `getLong()`, which returns the value of `long`

Copy and paste the code you wrote below.

#### 01.19.04

Create a class called `Basket<T1, T2, T3>` in a file called `Basket.java`.
It should have 2 (two) fields:
* `item01`, of type `T1`
* `item02`, of type `T2`
* `item03`, of type `T3`

It should have a constructor with parameterized types of `<T1, T2, T3>`.

It should have 6 (six) public methods:
* `getItem01()`, which returns the value of `item01`
* `getItem02()`, which returns the value of `item02`
* `getItem03()`, which returns the value of `item03`
* `setItem01()`, which returns nothing, accepts a parameter of type `T1`, and sets the value of `item01`
* `setItem02()`, which returns nothing, accepts a parameter of type `T2`, and sets the value of `item02`
* `setItem03()`, which returns nothing, accepts a parameter of type `T3`, and sets the value of `item03`

Copy and paste the code you wrote below.
