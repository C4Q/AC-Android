# DSA Sorting: Merge Sort

## Objectives

* Fellows will learn how to design divide and conquer algorithms
* Fellows will explore how to implement Merge Sort and will learn about its runtime complexity

## Resources

* [Youtube](https://www.youtube.com/watch?v=EeQ8pwjQxTM)
* [Java](https://www.baeldung.com/java-merge-sort)
* [Harvard](https://www.youtube.com/watch?v=sWtYJv_YXbo)

# Lecture

## Merge Sort

Definition
A merge sort algorithm will split an unsorted list of n-elements into two halves. It then sorts these two halves and merges them together into one sorted list using recursion.

![merge sort theory](https://cdn-images-1.medium.com/max/780/1*ZFpPwH6_ssRu5p8tM9T-vQ.jpeg)

The basic idea being that it tends to be much easier to sort two smaller sorted lists than sorting a large unsorted one.

But how do we magically split up the two halves of our list? By designing our algorithm to implement the divide and conquer technique

## Designing Algorithms

There are a wide range of techniques we can choose to apply when we're designing an algorithm. For bubble sort we took an incremental/iterative approach: Walking through a list of elements we compared two elements at a time and swapped the out of order elmenents and continued to do this operation until we the entire list is sorted.
The problem with this is that the running time is pretty inefficient because it has a quadratic runtime complexity in Big O notation this will be O(n<sup>2</sup>)

Now we will examine an alternate design approach known as the "divide-and-conquer" strategy, Using this approach we'll write a sorting algorithm whose worst-case run-time will be much less than bubble sort.

## The divide-and-conquer strategy

We already know that a recursive algorithm is one that can essentially use the same solution to solve a problem. A method will call itself one or more times and solve sub problems. A divide-and-conquer approach will break a large problem down into subproblems that are smaller than the original using recursion then combine the results into the solution for the original problem

The basic steps d&c algorithm's boil down to are,

* Divide: Break up the problem into the smallest possible instances of the exact same problem

* Conquer: Tackle the smallest problems first using recursion. Then repeat the process for the larger subproblems 

* Combine: Build up the answers for the smaller problems into the solution for the original problem

Merge sort closely follow this design by breaking down into the following steps

* Divide: Divide the n-element list to be sorted into two halves

* Conquer: Sort the two halves recursively using merge sort

* Combine: Merge the two sorted lists to produce final sorted answer

But how does this algorithm really work in practice?

## Divide

![divide](https://imgur.com/a/lMsxbcR)

In the example above we took our list of six elements and split this into two unsorted lists then break that into four unsorted lists until finally we get six lists in total each containing only one item. Since we can't divide this any further we've reached our smallest subproblem. Our recursive base case will be a list with a single item in it because it is always going to be considered sorted.

```java
/**
	 * Merge two sorted sublists into a single list
	 * @param arr a list containing unsorted elements
	 * @param left start index of the list
	 * @param right end index of the list
	 */
public static void mergeSort(int left, int right, int[] arr) {
    //if the array contains more than one element
    if (left < right) {
    //find the middle index
      int mid = (left + right)/ 2
      //split into two parts by recursively calling mergeSort() on the left and right subarrays
      mergeSort(left, mid, arr);
      mergeSort(mid + 1, right, arr);
      //after we're finished  dividing merge left and right arrays
      merge(left, mid, right, arr);
    }
  }
```
## Conquer and Combine

![combine](https://imgur.com/a/gHqqjKQ)

Now we'll take our six lists and start merging them together into four lists by checking the first item in each list and combining while maintaining sorted order. We continue until there are two sorted lists and finish merging resulting in a final sorted list.

When it comes to merging these sub lists we use the same method over and over again until theres nothing to sort anymore. This is why the divide and conquer method works once we've figured out our logic we can keep reusing it and build our solution this way

So let's see how this is implemented in Java

```java
/**
	 * Merge two sorted sublists into a single list
	 * @param arr a list
	 * @param left start index of left list
	 * @param mid end index of left list
	 * @param right end index of right list
	 */
 private static void merge(int left, int mid, int right, int[] arr) {
    //determine the size of our left and right sub arrays
    int leftArrSize = mid - left + 1;
    int rightArrSize = right - mid;
    
    //left and right array are initialized adding one more space for a Sentinel value
    int[] leftArr = new int[leftArrSize + 1];
    int[] rightArr = new int[rightArrSize + 1];

    //Copy the elements into the left sub array starting from the left index
    for (int i = 0; i < leftArrSize; i++) {
      leftArr[i] = arr[left + i];
    }

    //copy elements into the right sub array starting from the middle index
    for (int j = 0; j < rightArrSize; j++) {
      rightArr[j] = arr[mid + 1 + j];
    }

    //add sentinel values to signal when a subarray has been completely merged first
    leftArr[leftArrSize] = Integer.MAX_VALUE;
    rightArr[rightArrSize] = Integer.MAX_VALUE;

    // leftarray index and rightarray index
    int i = 0;
    int j = 0;

    /*merge subarrays into larger array sentinel values allow use to skip checks after one array has been exhausted*/
    for (int k = left; k <= right; k++) {
     //if the index on the left is inorder
      if (leftArr[i] <= rightArr[j]) {
        //combine and increment left index
        arr[k] = leftArr[i];
        i++;
      } else {
        //combiner and increment right index
        arr[k] = rightArr[j];
        j++;
      }
    }
  }
```

Now in order to understand the speed and efficiency of merge sort we need to look at how much time it takes for merge sort to 1) Divide the list, 2) Sort the list, 3) Combine

Dividing shouldnt be too expensive to run since we're only splitting our list and we use recursion to do this work.

Sorting shouldnt be too difficult either since our base case means when our list has a size of one it is sorted and when we sort we're sorting two items at a time giving us an essentially constant runtime

![sort runtime](https://imgur.com/a/R9mTMkB)

The operation that ends up taking the most time will be the during the merging process when we append elements and our append operation breaks down to

1) comparing the items that we want to combine together

2) inserteing them in our array in sorted order

And this operation will need to be preformed on every single element in the list

![combine](https://imgur.com/a/gHqqjKQ)

In our previous example we merged lists 3 times and since with have 6 total we have to perform 6 * 3 = (18) append operations

if we have n = 8 total elements again we perform our merge step 3 time so n * 3 = (24) append operations

if we have n = 4 then we'd have n * 2 = (8)

Lets use some math to try to abstract a pattern out of this

| n is the number of elements | number of merge operations |    
|-------------|:-------------:|
| n = 8 | log<sub>2</sub>8 = 3 |
| n = 16 | log<sub>2</sub>16 = 4 |   
| n = 4 | log<sub>2</sub>4 = 8 |  
| n = 2 | log<sub>2</sub>2 = 2 |  

the number of merge operations can be abstracted to be log<sub>2</sub>n or just

now if we multiply our log of n by the number of elements in our list (n) the total will be the total number of append operations performed for the sort so our run time complexity will be O (n * log n) since this is a combination of linear and logarithmic time we can refer to this as being in linearithmic time (quasilinear loglinear etc)

### Stats 
| type | comparison | 
|:-------------:|:-------------|
| time complexity | O(n log n) |
| space complexity | O( n ) aka out-of-place|   
| internal/external | external |  
| type | comparison |  

### Exercises

1) Given the following list of numbers: [21, 1, 26, 45, 29, 28, 2, 9, 16, 49, 39, 27, 43, 34, 46, 40] what list will be sorted after 3 recursive calls to mergesort?

2) Given the following list of numbers: [21, 1, 26, 45, 29, 28, 2, 9, 16, 49, 39, 27, 43, 34, 46, 40] which two lists will be the first to be merged?

3) [Leetcode](https://leetcode.com/problems/merge-sorted-array/)
