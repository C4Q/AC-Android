# Whiteboarding Challenges

## Objectives
* Fellows will explore how to practice whiteboarding questions with an interviewer
* Fellows will consider Object Oriented Design Questions for whiteboarding interviews

## Resources
* [Class Whiteboarding Practice](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_23_class_whiteboarding_practice.md)
* [Interview Prep](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_05/05_01_dsa_challenges_01.md)

# Lecture

Based on feedback fair responses from fellows, we will practice, as a class, completing coding questions on the whiteboard.

A fellow will be selected at random, to complete a question on the board, while remembering to communicate their thought process to their interviewer (instructor).

Each fellow will have a half-hour to complete a given question. If the fellow completes the question within the time alloted, they may be asked to optomize their algorithm. This is completely normal, and expected in the interview process. Be willing to first provide a brute-force solution, then be prepared to refactor the algorithm, to make it either more elegant, or efficient, if necessary.

Three (3) fellows will be randomly selected within a two (2) hour period. Please select from one of the following:

### Pairs:

Given an `Array` of non-empty strings, create and return a `Map<String, String>` as follows: for each string add its first character as a key with its last character as the value.

``` java
pairs(["code", "bug"]) → {"b": "g", "c": "e"}
pairs(["man", "moon", "main"]) → {"m": "n"}
pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}
```

### prefixAgain:

Given a `String`, consider the prefix string made of the first N chars of the string. Does that prefix string appear somewhere else in the string? Assume that the string is not empty and that N is in the range 1..`str.length()`.

``` java
prefixAgain("abXYabc", 1) → true
prefixAgain("abXYabc", 2) → true
prefixAgain("abXYabc", 3) → false
```

### linearIn:

Given two arrays of ints sorted in increasing order, outer and inner, return true if all of the numbers in inner appear in outer. The best solution makes only a single "linear" pass of both arrays, taking advantage of the fact that both arrays are already in sorted order.

``` java
linearIn([1, 2, 4, 6], [2, 4]) → true
linearIn([1, 2, 4, 6], [2, 3, 4]) → false
linearIn([1, 2, 4, 4, 6], [2, 4]) → true
```

## Object Oriented Design

Object Oriented Design questions tend to be less about logic (although there will be logic), and more about your understanding of Object-Oriented design principles, and how effectively a candidate can "seperate the concerns" of a project.

Things to remember include:
* Single-Responsibility Principle - does your method complete several tasks, or a single task? Does your class represent multiple objects, or a single object?
* D.R.Y., or "Don't Repeat Yourself" - do you write distinct methods to produce similar results? Or do you create reusable methods and objects?
* Y.A.G.N.I - or "You Ain't Gonna Need It" - are you pre-optimizing your code for advanced features? Or are you focused on the minimum viable product, knowing you can iterate on features later?
* Scalability - are you writing your program to solve an immediate problem, or are you writing it in such a way that it could not only solve the problem at hand, but eventually be used in a more extensible way (view-agnostic / platform-agnostic)?

For this challenge, a fellow will be asked to create a "Tic Tac Toe" game using only Java code. Make a game that can allow for two (2) human players.

Issues to Consider:
* How would you input or track the moves of each player?
* How would you store the status of each turn?
* How would you determine a winner/loser/draw?
* How would you display the game on the screen for each turn?

The fellow selected would have one hour (1) to complete this challenge on the whiteboard.
