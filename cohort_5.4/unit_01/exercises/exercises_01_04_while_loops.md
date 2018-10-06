# Exercises - Lesson 01.04

|Question|
|:-:|
|[01.04.01](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_04_while_loops.md#010401)|
|[01.04.02](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_04_while_loops.md#010402)|
|[01.04.03](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_04_while_loops.md#010403)|
|[01.04.04](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_04_while_loops.md#010404)|
|[01.04.05](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_01/exercises/exercises_01_04_while_loops.md#010405)|

#### 01.04.01

Declare a variable of the type `int` in the `main(String[] args)` method. Name the variable `count`. Assign it a value of `0`.

Next, compose a `while` loop that first prints the value of the variable `count` to the screen, then increases the value of the `count` variable by `1`. Have the loop continue printing the value of `count` to the screen until the value of `count` reaches `100`. Stop the loop, and do not print the value of `100`. 

Copy and paste the code you wrote below.

#### 01.04.02

Declare a variable of the type `int` in the `main(String[] args)` method. Name the variable `count`. Assign it a value of `0`.

Next, compose a `while` loop that prints whether the current number of the `count` variable is an odd or even number - for example:

```java
35 is an odd number
36 is an even number
37 is an odd number
```

Have the loop continue printing the sentence to the screen until the value of `count` reaches `100`. Stop the loop, and do not print the value of `100`. 
 
#### 01.04.03

Declare a variable of the type `int` in the `main(String[] args)` method. Name the variable `count`. Assign it a value of `0`.

Next, compose a `while` loop that:

* prints `Yay` if the number is divisible by `3`
* prints `Ney` if the number is divisible by `5`
* prints `Hey Hey Hey` if the number is divisible by both `3` and `5`
* otherwise, just print the number

For example:

```java
0
1
2
Yay
4
Ney
....
```

Have the loop continue printing the phrase or number to the screen until the value of `count` reaches `100`. Stop the loop, and do not print the value of `100`. 

#### 01.04.04 

Declare a variable of the type `int` in the `main(String[] args)` method. Name the variable `count`. Assign it a value of `5`.

Next, compose a `while` loop that prints the value of `counter` until the value of `counter` reaches `0`. When the value of `counter` reaches `0`,  instead of printing the number, print the phrase `Blastoff!` to the screen. 

For example:

```java
5
4
3
2
1
Blastoff!
```

#### 01.04.05

Using a `Scanner` object and a `do-while` loop, make a guessing game!

This guessing game should have:

* a `Scanner` object: `Scanner scanner = new Scanner(System.in);`
* a variable of type `String` called `secretWord`, assigned a word of your choosing
* a `do-while` loop that asks for input, then checks if the word from `nextLine()` on the `scanner` object is equal to the value in `secretWord` - if it is, prints to the screen "You have guessed the secret word!", then breaks out of the loop
* if the word from `nextLine()` on the `scanner` object is NOT equal to the value in `secretWord`, keep the loop running again, and again, and again....

For example:
```java
Enter the secret word: 
 hello
Enter the secret word: 
 goodbye
Enter the secret word: 
 party
You have guessed the secret word!
>
```
