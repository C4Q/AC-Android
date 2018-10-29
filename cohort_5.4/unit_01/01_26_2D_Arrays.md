# 2D Arrays and Θ(n²)

## Objectives

* Fellows will learn about Two-Dimensional Arrays
* Fellows will explore Quadradic Time

## Resources
* [2D Arrays](https://processing.org/tutorials/2darray/)
* [Algorithmic Complexity](https://www.cs.cmu.edu/~adamchik/15-121/lectures/Algorithmic%20Complexity/complexity.html)

# Lecture

### Constant Time: O(1)

An algorithm is said to run in constant time if it requires the same amount of time regardless of the input size:

* array: accessing any element by its index

### Linear Time: O(n)

An algorithm is said to run in linear time if its time execution is directly proportional to the input size, i.e. time grows linearly as input size increases:

* array: linear search, traversing, finding the minimum value of an unsorted array

### Logarithmic Time: O(log n)

An algorithm is said to run in logarithmic time if its time execution is proportional to the logarithm of the input size. Example:

* binary search: locate the element a in a sorted (in ascending order) array by first comparing a with the middle element and then (if they are not equal) dividing the array into two subarrays; if a is less than the middle element you repeat the whole procedure in the left subarray, otherwise - in the right subarray. The procedure repeats until a is found or subarray is a zero dimension.

### Quadratic Time: O(n²)

An algorithm is said to run in logarithmic time if its time execution is proportional to the square of the input size:

* bubble sort, selection sort, insertion sort 
