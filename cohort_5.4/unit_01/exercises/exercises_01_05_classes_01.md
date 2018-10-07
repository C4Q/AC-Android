# Exercises - Lesson 01.06

|Question|
|:-:|
|[01.06.01](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_05_classes_01.md#010601)|
|[01.06.02](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_05_classes_01.md#010602)|
|[01.06.03](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_05_classes_01.md#010603)|
|[01.06.04](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_05_classes_01.md#010604)|
|[01.06.05](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_05_classes_01.md#010605)|
|[01.06.06](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_05_classes_01.md#010606)|
|[01.06.07](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_05_classes_01.md#010607)|
|[01.06.08](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_05_classes_01.md#010608)|
|[01.06.09](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_05_classes_01.md#010609)|
|[01.06.10](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_05_classes_01.md#010610)|

#### 01.06.01

Outside the `main(String[] args)` method, but inside the `Main` class, create a `public` and  `static` method called `countMe` that:

* accepts an input of type `String` from its parameter of type `String`
* returns a value of type `int`
* the value returned should be the number of characters found in the `String` argument passed to the parameter

For example:

When the method `System.out.println(countMe("Hello"));` is called in the `main(String[] args)` method, this should print to the screen:

```java
5
```

#### 01.06.02

Outside the `main(String[] args)` method, but inside the `Main` class, create a `public` and  `static` method called `repeatMe` that:

* accepts an input of type `String` from its first parameter of type `String`
* accepts an input of type `int` from its second parameter of type `int`
* returns a value of type `String`
* the value returned should be the `String` argument passed to the first parameter, for as many times as requested by the second parameter

For example:

When the method `System.out.println(repeatMe("Hello", 5));` is called in the `main(String[] args)` method, this should print to the screen:

```java
HelloHelloHelloHelloHello
```
 
#### 01.06.03

Outside the `main(String[] args)` method, but inside the `Main` class, create a `public` and  `static` method called `repeatMyself` that:

* accepts an input of type `String` from its parameter of type `String`
* returns a value of type `String`
* the value returned should be the `String` argument passed to the parameter, for as many times as the length of the `String` passed to the parameter.

For example:

When the method `System.out.println(repeatMyself("Lovelace"));` is called in the `main(String[] args)` method, this should print to the screen:

```java
LovelaceLovelaceLovelaceLovelaceLovelaceLovelaceLovelaceLovelace
```

#### 01.06.04

Outside the `main(String[] args)` method, but inside the `Main` class, create a `public` and  `static` method called `reverseMe` that:

* accepts an input of type `String` from its parameter of type `String`
* returns a value of type `String`
* the value returned should be the `String` argument passed to the parameter, but with the characters in reverse order.

For example:

When the method `System.out.println(reverseMe("Hopper"));` is called in the `main(String[] args)` method, this should print to the screen:

```java
reppoH
```

#### 01.06.05

Outside the `main(String[] args)` method, but inside the `Main` class, create a `public` and  `static` method called `printReverseChars` that:

* accepts an input of type `String` from its parameter of type `String`
* returns nothing
* prints each character from the `String` argument passed to the first parameter, but with the characters in reverse order one-by-one.

For example:

When the method `printReverseChars("Fantastic");` is called in the `main(String[] args)` method, this should print to the screen:

```java
c
i
t
s
a
t
n
a
F
```

#### 01.06.06

Using IntelliJ IDEA, create a new file in the same package as `Main.java`. This file should be called `Soldier.java`, and should contain a class named `Soldier`.

This class should have 3 (three) `public` and `static` variables (fields, really - since they belong to the class):

*  the field `name` - of type `String`
*  the field `rank` - of type `String`
*  the field `serialNumber` - of type `int`

You should then be able to set and get the values of these fields from within the `Main` class's `main(String[] args)` method. 

For example:

```java
Soldier.name = "Roald Dahl";
Soldier.rank = "Flying Pilot";
Soldier.serialNumber = 8675309;

System.out.println(Soldier.name);
System.out.println(Soldier.rank);
System.out.println(Soldier.serialNumber);
```

#### 01.06.07

Using IntelliJ IDEA, create a new file in the same package as `Main.java`. This file should be called `Apartment.java`, and should contain a class named `Apartment`.

This class should have 3 (three) `private` fields:

*  the field `bedroomCount` - of type `int`
*  the field `restroomCount` - of type `int`
*  the field `squareFootage` - of type `int`

You should then be able to instantiate an instance of this class with a default constructor, and set and get the values of these fields from within the `Main` class's `main(String[] args)` method with setters and getters. 

For example:

```java
Apartment apartment = new Apartment();

apartment.setBedroomCount(3);
apartment.setBathroomCount(2);
apartment.setSquareFootage(750);

System.out.println(apartment.getBedroomCount());
System.out.println(apartment.getBathroomCount());
System.out.println(apartment.getSquareFootage());
```

#### 01.06.08

Using IntelliJ IDEA, create a new file in the same package as `Main.java`. This file should be called `House.java`, and should contain a class named `House`.

This class should have 3 (three) `private` fields:

*  the field `bedroomCount` - of type `int`
*  the field `restroomCount` - of type `int`
*  the field `squareFootage` - of type `int`

You should then be able to instantiate an instance of this class with a custom constructor that sets the values of the fields at the moment of instantiation, and get the values of these fields from within the `Main` class's `main(String[] args)` method with only getters. 

For example:

```java
House house = new House(3, 2, 10000);

System.out.println(house.getBedroomCount());
System.out.println(house.getBathroomCount());
System.out.println(house.getSquareFootage());
```

#### 01.06.09

Using IntelliJ IDEA, create a new file in the same package as `Main.java`. This file should be called `Fellow.java`, and should contain a class named `Fellow`.

This class should have 3 (three) `private` fields:

*  the field `name` - of type `String`
*  the field `grade` - of type `char`
*  the field `cohort` - of type `double`

You should then be able to instantiate an instance of this class with a default constructor that leaves the fields unassigned, a custom constructor that sets the values of the fields at the moment of instantiation, and get the values of these fields from within the `Main` class's `main(String[] args)` method with both setters and getters. 

For example:

```java
Fellow fellow01 = new Fellow();
Fellow fellow02 = new Fellow("Ines", 'A', 5.4);

fellow01.setName("Carlos");
fellow01.setGrade('B');
fellow01.setCohort(5.2);

System.out.println(fellow01.getName());
System.out.println(fellow01.getGrade());
System.out.println(fellow01.getCohort());

System.out.println(fellow02.getName());
System.out.println(fellow02.getGrade());
System.out.println(fellow02.getCohort());
```

#### 01.06.10

Using IntelliJ IDEA, create a new file in the same package as `Main.java`. This file should be called `GradeChecker.java`, and should contain a class named `GradeChecker`.

This class should have no fields.

This class should have one method called `printNameAndGrade`:

* it should return nothing
* it should have one parameter of type `Fellow`
* it should then check the fellow object for its `name`, `grade`, and `cohort`, and print all 3 (three) to the screen

You should then be able to instantiate an instance of this class with a default constructor, and call the `printNameAndGrade` method from within the `Main` class's `main(String[] args)` method. 

For example:

```java
Fellow fellow03 = new Fellow("Celeste", 'A', 5.1);

GradeChecker gradeChecker = new GradeChecker();
gradeChecker.printNameAndGrade(fellow03);
```

which should print this output to the screen:

```java
Celeste from 5.1 has earned an A in class!
```
