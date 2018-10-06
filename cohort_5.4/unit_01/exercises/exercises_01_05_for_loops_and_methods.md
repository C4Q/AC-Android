# Exercises - Lesson 01.05

|Question|
|:-:|
|[01.05.01](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_03_intro_to_java.md#010401)|
|[01.05.02](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_03_intro_to_java.md#010402)|
|[01.05.03](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_03_intro_to_java.md#010403)|
|[01.05.04](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_03_intro_to_java.md#010404)|
|[01.05.05](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_03_intro_to_java.md#010405)|
|[01.05.06](https://github.com/joinpursuit/AC-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_03_intro_to_java.md#010405)|

#### 01.05.01

In the `main(String[] args)` method, create a `for` loop that:

* has a counter variable called `i`, and assign it a value of `0`
* will repeat a loop as long as `i` is less than `100`
* increases the value of `i` by `1`, at the end of every loop

Within the loop, print the value of `i` to the screen.

Copy and paste the code you wrote below.

#### 01.05.02

In the `main(String[] args)` method, create a `for` loop that:

* has a counter variable called `i`, and assign it a value of `100`
* will repeat a loop as long as `i` is greater than or equal to `0`
* decreases the value of `i` by `1`, at the end of every loop

Within the loop, print the value of `i` to the screen, and if the number is either odd or even.

For example:

```java
100 is even
99 is odd
98 is even
97 is odd
....
```

Copy and paste the code you wrote below.
 
#### 01.05.03

Outside the `main(String[] args)` method, but inside the `Main` class, create a `public` and  `static` method called `printMe` that:

* accepts an input of type `String` from its parameter of type `String`
* returns nothing
* prints the value in the parameter to the screen

For example:

When the method `printMe("My name is Hector");` is called in the `main(String[] args)` method, this should print to the screen:

```java
My name is Hector
```

#### 01.05.04 

Outside the `main(String[] args)` method, but inside the `Main` class, create a `public` and  `static` method called `timesFive` that:

* accepts an input of type `int` from its parameter of type `int`
* multiplies the value of the parameter by 5 (five)
* returns the result

Once the result is returned, print it to the screen.

For example:

When the method `System.out.println(timesFive(6));` is called in the `main(String[] args)` method, this should print to the screen:

```java
30
```

#### 01.05.05

Outside the `main(String[] args)` method, but inside the `Main` class, create a `public` and  `static` method called `printLetters` that:

* accepts an input of type `String` from its parameter of type `String`
* returns nothing
* using the `charAt()` method on the parameter for every iteration of a `for` loop, prints the letter contained at that particular index, for example:

When the method `printLetters("Samson);` is called in the `main(String[] args)` method, this should print to the screen:

```java
S
a
m
s
o
n
```

#### 01.05.06

Outside the `main(String[] args)` method, but inside the `Main` class, create a `public` and  `static` method called `printCapsAlphabet` that:

* prints every capital letter from A-to-Z
* returns nothing
* if the letter is either `'A'`, `'E'`, `'I'`, `'O'`, or `'U'` - print the word "VOWEL" in all caps instead.

For example:

When the method `printCapsAlphabet();` is called in the `main(String[] args)` method, this should print to the screen:

```java
VOWEL
B
C
D
VOWEL
F
G
H
VOWEL
J
K
L
....
```
