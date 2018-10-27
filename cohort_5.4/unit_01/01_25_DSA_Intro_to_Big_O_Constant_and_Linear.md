# DS&A - Intro to Big Θ: Θ(1) vs Θ(n)

## Objectives

* Fellows will learn about the Time Complexity of Algorithms
* Fellows will learn to interpret the framework of "Big O" Notation

## Resources

* [Interview Cake - Big O Notation](https://www.interviewcake.com/article/java/big-o-notation-time-and-space-complexity)
* [HackerRack - Java Questions](https://www.hackerrank.com/domains/java)
* [CodingBat - Map 2](https://codingbat.com/java/Map-2)
* [Big O Cheat Sheet](http://bigocheatsheet.com/)
* [HackerRank's Interview Preparation Kit](https://www.hackerrank.com/interview/interview-preparation-kit)

# Lecture

Big Θ Notation is, in short, a framework used for discussing how optimal an Algorithm may be.

As a primer, we will first explore [Interview Cake's article "The idea behind big O notation" here](https://www.interviewcake.com/article/java/big-o-notation-time-and-space-complexity).

## Key Take-aways

### Constant Time

The `get()` method for an `ArrayList` or `HashMap` is an example of Constant Time, where as long as we know the key or index of the value or element we want to search for, we can obtain the value immediately, without having to search through the entire data set. 

### Linear Search

A linear search sequentially moves through a list of items, from first to last, looking for a matching item.

The worst case performance scenario for a linear search is that it needs to loop through the entire list of items -- either because the item is the last one, or because the item isn't found. If you have n items in your collection, the worst case scenario to find an item is n iterations, meaning the runtime of linear search is O(n).

### Binary Search

Binary search is an efficient algorithm for finding an item from a sorted list of items. It works by repeatedly dividing in half the portion of the list that could contain the item, until you've narrowed down the possible locations to just one.

One of the most common ways to use binary search is to find an item in an array. A binary search algorithm finds an item in a sorted array in O(log n) time.
Pseudocode for binary search

1. Let min = 0 and max = n-1.
2. If max < min, then stop: target is not present in array. Return -1.
3. Compute guess as the average of max and min, rounded down (so that it is an integer).
4. If array[guess] equals target, then stop. You found it! Return guess.
5. If the guess was too low, that is, array[guess] < target, then set min = guess + 1.
6. Otherwise, the guess was too high. Set max = guess - 1.
7. Go back to step 2.

## Exercises

Please see the calendar on Canvas for today's date, to see the exercises for today's lecture.
