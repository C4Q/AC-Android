# DS&A Sorting: Bubble Sort

## Objectives
* Fellows will learn how to implement a basic sorting algorithm
* Fellows will explore how to implement Bubble Sort, and its runtime complexity

## Resources
* [Link to External Resources](https://www.google.com)

# Lecture

## What we know so far
![sort java](https://i.imgur.com/knwdR9e.png )

* Now lets see how these methods work

## Analysis of Algorithms
* We're studying computer program performance and resource usage
* What can be more important than performance?

    |               |               |       |
    | ------------- |:-------------:| -----:|
    | modularity    | reliability | robustness |
    | correctness   | simplicity      |   extensibility |
    | maintainability | user-friendliness      |  programmer time |

* When we study performance we want to understand the scalability of an algorithm
* Performance will draw the line between what is feasible and what is impossible

## The Sorting Problem
* Input: Sequence {a<sub>1</sub>, a<sub>2</sub>, a<sub>3</sub>, a<sub>4</sub>...  a<sub>n</sub>} of numbers
* Output: Permutation {a'<sub>1</sub>, a'<sub>2</sub>, a'<sub>3</sub>, a'<sub>4</sub>...  a'<sub>n</sub>} of numbers
    * Example:<br />
        Input: {8, 2, 4, 9, 3, 6}<br />
        Output: {2, 3, 4, 6, 8, 9}

## Bubble Sort Definition   
*  A bubble sort algorithm walks through (iterates) through some collection and compares two elements at a time
* If the elements are out of order it swaps them
* It will continue to swap out of order elements until the entire collection is sorted
* Lets sort the int[] arr = {9, 7, 4, 1, 2}

<img align= "left" hspace="20" src="https://i.imgur.com/v4rSd0Z.png">

* We start by comparing the first two elements 9 and 7 and since they're out of order swap
* Next compare the second and third elements 9 and 4. Since 9 is bigger than 4 it should come after, So we swap the two elements as well
* The next two elements are 9 and 1. Again 9 should come after 1, another swap will take place
* Finally 9 and 2 are the last two elements of the first iteration. The number 2 should come before 9 so swap these two elements.
* Great We've Completed the first iteration of our bubble sort but out list isn't sorted yet!
* We will need to continue to repeat this process for each of the remaining elements until our collection is confirmed to be sorted
* Question is now, How many times will we have to iterate through the collection in order to sort the entire thing?
* Let's see if we can notice a pattern

   |       2 Elements        |    3 Elements           |  4 Elements     |
    | ------------- |:-------------:| -----:|
    | [9 , 7]    | [9, 7, 4] |  [9, 7, 4, 1] |
    | [7 , 9]   |[7, 4, 9]     |    [7, 4, 1, 9] |
    | Ordered! | [4, 7, 9]        |  [4, 1, 7, 9] |
    |  | Ordered!       |  [1, 4, 7, 9] |
    |  |      |  Ordered! |

* Generalization
    * Given a collection of n unsorted elements it takes (n - 1) iterations through the list in order to sort using the bubble sort algorithm

## Optimization

* Lets try to catch another pattern in the bubble sort

<br />
<img src="https://i.imgur.com/wHgKpB6.png">
<br />

* Note we didn't need to compare or check the last element because we already know that it already has the correct number 9
* For the next iteration we wouldn't have to check 7 or the number 9 since they are already in their correct positions so
    * After 2 iterations of bubble sort checking the last two spots in the array is unnecessary
    * This can keep going if After 3 iterations through the array we don't need to check the last 3 elements
* Generalization
    * After X iterations checking the last x elements in a collection is unnecessary

* Optimizing like this allows us to save time and memory if we can break out of some action early

* Bubble sort
    * A single iteration through a collection puts one element in the correct location.
    * It will take n-1 passes through a collection (n is the number of elements) to sort the collection

```java
private static void bubbleSort(int[] inputArr) {

    boolean isSorted = false;

    while (!isSorted) {
      isSorted = true;
      for (int index = 1; index < inputArr.length; index++) {
        System.out.println("Comparing: " + inputArr[index] + " and " + inputArr[index - 1]);

        if (inputArr[index - 1] > inputArr[index]) {
          isSorted = false;
          System.out.println("SWAP: " + inputArr[index] + " and " + inputArr[index - 1]);
          int temp = inputArr[index - 1];
          inputArr[index - 1] = inputArr[index];
          inputArr[index] = temp;
        }
        System.out.println("Array is now " + Arrays.toString(inputArr));
      }
      System.out.println("One full pass through the array complete");
      System.out.println("Is the array sorted? " + isSorted);
    }
  }
```
* OUTPUT
```
[9, 7, 4, 1, 2]
Comparing: 7 and 9
SWAP: 7 and 9
Array is now [7, 9, 4, 1, 2]
Comparing: 4 and 9
SWAP: 4 and 9
Array is now [7, 4, 9, 1, 2]
Comparing: 1 and 9
SWAP: 1 and 9
Array is now [7, 4, 1, 9, 2]
Comparing: 2 and 9
SWAP: 2 and 9
Array is now [7, 4, 1, 2, 9]
One full pass through the array complete
Is the array sorted? false
Comparing: 4 and 7
SWAP: 4 and 7
Array is now [4, 7, 1, 2, 9]
Comparing: 1 and 7
SWAP: 1 and 7
Array is now [4, 1, 7, 2, 9]
Comparing: 2 and 7
SWAP: 2 and 7
Array is now [4, 1, 2, 7, 9]
Comparing: 9 and 7
Array is now [4, 1, 2, 7, 9]
One full pass through the array complete
Is the array sorted? false
Comparing: 1 and 4
SWAP: 1 and 4
Array is now [1, 4, 2, 7, 9]
Comparing: 2 and 4
SWAP: 2 and 4
Array is now [1, 2, 4, 7, 9]
Comparing: 7 and 4
Array is now [1, 2, 4, 7, 9]
Comparing: 9 and 7
Array is now [1, 2, 4, 7, 9]
One full pass through the array complete
Is the array sorted? false
Comparing: 2 and 1
Array is now [1, 2, 4, 7, 9]
Comparing: 4 and 2
Array is now [1, 2, 4, 7, 9]
Comparing: 7 and 4
Array is now [1, 2, 4, 7, 9]
Comparing: 9 and 7
Array is now [1, 2, 4, 7, 9]
One full pass through the array complete
Is the array sorted? true
[1, 2, 4, 7, 9]
```

* Even though the code has been optimized we can tell that its still a repetitive process
* If the bubble sort is bad, then just how bad is it?
    * If we have to n number of iterations through our array
    * And if each iteration has to check all n elements in the array
    Multiplication gives us n * n = n<sup>2</sup>  Quadratic runtime or O(n<sup>2</sup>)
    * If our collection doubled in size the amount of time it would take would quadruple
    * But it doesn't take more than O(1) memory so its useful in sorting small collections

### Some Final Stats
|               |               |       
|-------------|:-------------:|
|Time-Complexity    | O( n<sup>2</sup> ) |
|Space-Complexity   | O( 1 )      |   
|Internal or External | Internal        |  
|Recursive or Non-recursive | non-recursive         |  
|Comparison or Non Comparison | non-comparison         |  

## Exercises

Please complete the exercises found on the Canvas Calendar for Today's date.

1) Suppose you have the following list of numbers to sort: [19, 1, 9, 7, 3, 10, 13, 15, 8, 12] what will the partially sorted list look like after three complete passes of bubble sort?

2) Implement the simple swapping operation as a function swap(int[] t, int i, int j) which swaps the elements at indices i and j in the array t.

3) Consider an array A of n elements example a[0]...a[n − 1] and the pseudocode for bubbleSort discussed in class:
       for k = 1 to n-1 do
         for i = 0 to n-1-j
            if (A[i] > A[i+1]) swap A[i] and A[i+1]
    (a) Describe what happens when you bubble sort an array A that is already sorted. How many swaps are performed by the inner loop each time? How many times is the outer loop executed?

4) Implement bubble sort where you float the smallest number up instead of the largest (order elements largest to smallest)
