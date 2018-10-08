# Exercises - Lesson 01.07

|Question|
|:-:|
|[01.07.01](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_07_classes_02.md#010701)|
|[01.07.02](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_07_classes_02.md#010702)|
|[01.07.03](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_07_classes_02.md#010703)|
|[01.07.04](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_07_classes_02.md#010704)|
|[01.07.05](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_07_classes_02.md#010705)|

#### 01.07.01

Outside the `main(String[] args)` method, but inside the `Main` class, create a `public` and  `static` method called `convertStringToInteger` that:

* accepts an input of type `String` from its parameter of type `String`
* returns a value of type `Integer`
* the value returned should be the `Integer` version of the value found in the `String` argument passed to the parameter

For example:

When the method `System.out.println(convertStringToInteger("25"));` is called in the `main(String[] args)` method, this should print to the screen:

```java
25
```

Copy and paste the code you wrote below.

#### 01.07.02

Create a class called `Fruit` in a file called `Fruit.java`. Add a `public` and `static` field of type `String`. Assign a value to it, and make sure no one can change its value after it has been assigned.

Copy and paste the code you wrote below.
 
#### 01.07.03

Wrap a `try` block around code you know will throw an exception. In the `catch` block section, add an additional message, then print the stack trace.

Copy and paste the code you wrote below.

#### 01.07.04

Create a class called `Car` in a file called `Car.java`. This class should have 3 (three) fields that cannot be accessed from outside the class without getter methods:

* `make`, of type `String`
* `model`, of type `String`
* `year`, of type `int`

Create a constructor to set these fields at the moment of instantiation.

Create getter methods for each of these fields.

Add a method called `aboutCar`. It should return nothing. It should instead print a descriptive sentence about the fields. For example:

```java
Car car = new Car("Toyota", "Camry", 2018);
car.aboutCar();
```

should print to the screen:

```java
This is a 2018 Toyota Camry!
```

Copy and paste the code you wrote below.

#### 01.07.05

Create a class called `Fellow` in a file called `Fellow.java`.

This class should have two fields:

* `name`, of type `String`, that cannot be accessed from outside the class without a getter method
* `isPresent`, of type `boolean`, that cannot be accessed from outside the class without a getter method

This class should have getter methods for both fields, which can be accessed from outside the class.

Create another class called `AttendanceChecker` in a file called `AttendanceChecker.java`.

This class should use a default constructor, and have only one method called `fellowStatus`:

* returns nothing
* should have one parameter, that takes an object of type `Fellow`
* if the `Fellow` object has its field `isPresent` set to true, print that the fellow is present, else print that the fellow is absent

For example:

```java
Fellow john = new Fellow("John", false);
Fellow janice = new Fellow("Janice", true);
Fellow vivian = new Fellow("Vivian", false);

AttendanceChecker attendanceChecker = new AttendanceChecker();

attendanceChecker.fellowStatus(john);
attendanceChecker.fellowStatus(janice);
attendanceChecker.fellowStatus(vivian);
```

should print to the screen:

```java
The fellow John is absent.
The fellow Janice is present.
The fellow Vivian is absent.
```

Copy and paste the code you wrote below.
