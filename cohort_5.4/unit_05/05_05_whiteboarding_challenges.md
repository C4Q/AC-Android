# Whiteboarding Challenges

## Objectives
* Fellows will explore how to practice whiteboarding questions with an interviewer
* Fellows will consider Object Oriented Design Questions for whiteboarding interviews

## Resources
* []()

# Lecture

Based on feedback fair responses from fellows, we will practice, as a class, completing coding questions on the whiteboard.

A fellow will be selected at random, to complete a question on the board, while remembering to communicate their thought process to their interviewer (instructor).

Each fellow will have a half-hour to complete a given question. If the fellow completes the question within the time alloted, they may be asked to optomize their algorithm. This is completely normal, and expected in the interview process. Be willing to first provide a brute-force solution, then be prepared to refactor the algorithm, to make it either more elegant, or efficient, if necessary.

Three (3) fellows will be randomly selected within a two (2) period. Please select from one of the following:

### Pairs:

Given an array of non-empty strings, create and return a Map<String, String> as follows: for each string add its first character as a key with its last character as the value.

``` java
pairs(["code", "bug"]) → {"b": "g", "c": "e"}
pairs(["man", "moon", "main"]) → {"m": "n"}
pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}
```

### prefixAgain:

Given a string, consider the prefix string made of the first N chars of the string. Does that prefix string appear somewhere else in the string? Assume that the string is not empty and that N is in the range 1..str.length().

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
