# DSA Sorting: Quick Sort

## Objectives

* Fellows will learn how to apply divide and conquer techniques to algorithms
* Fellows will learn how to partitioning can enhance an algorithm

## Resources

* [Youtube](https://www.youtube.com/watch?v=SLauY6PpjW4)
* [Stanford](https://www.youtube.com/watch?v=ETo1cpLN7kk)
* [San Diego](https://www.youtube.com/watch?v=ZHVk2blR45Q)

# Lecture

## Quick Sort

Quicksort like mergesort, applies the divide-and-conquer technique for sorting an typical array.

Quick is popular because it's one of the easiest sorting algorithm to implement and is faster than most sorting techniques because the basic idea is to partition an array into two parts then sorting these smaller parts independently.

## Divide and Conquer

The quicksort algorithm uses a pivot point in a list of elements. It partitions the list around the pivot so that elements smaller than the pivot are moved before it and elements larger than the pivot are moved after it.

Divide: Partition (rearrange) the array into two sub arrays (left and right) where every value on the left is less than or equal to a midpoint, and everything on the right is greater than or equal to the midpoint

Conquer: Sort the two sub arrays L and R by recursively calling quicksort

Combine: The subarrays are already sorted so no extra work is needed to combine them the entire array is now sorted

![QuickSort](https://i2.wp.com/www.techiedelight.com/wp-content/uploads/Quicksort.png?zoom=1.2999999523162842&w=1100&ssl=1)

So we can breakdown our sorting work into two operations

1) First Quicksort needs to determine a pivot point, Which can be a (kinda) random element in the collection

2) Using the pivot point create partitions, The large unsorted collection gets divided into smaller lists. So we move all the elements larger than the pivot value to right and all the elements smaller than the pivot value to the left

## Pivoting

![Pivot](https://cdn-images-1.medium.com/max/780/1*cHKEM0Ni1YaU8WeEgepq3g.jpeg)

For most implementations the last element in the array is chosen as the pivot element. There are many ways to choose a pivot element and your choice of pivot element.

Since quicksort is a divide and conquer algorithm we know that it's going to reuse the exact same logic that we just ran through. This is where our recursion kicks in, We're going to be choosing an element to use as a pivot point and create two partition sublists. Once we have these sublists, pivots will be chosen again.and this repeats until we have one element in each list.

Choosing a proper pivot point is important. Standard quicksort implementations will choose the 1st or the last element as the pivot point. Ideally quicksort would choose the middle element so when we partition the list they would be of equal size

Lets implement this recursive step.

```java
    public static void quickSort(int[] arr, int start, int end) {
      //If the array contains more than one element
      if (start < end) {
        //The pivot element will be returned by our partition method 
        int pivot = partition(arr, start, end);
        System.out.println("Pivot is: " + pivot);
        //Sort the left sub array
        quickSort(arr, start, pivot - 1);
        //Sort the right sub array
        quickSort(arr, pivot + 1, end);
      }
    }
```

## Partitioning

![Partition](https://cdn-images-1.medium.com/max/780/1*md0dT0BAlkRiWlWnbH61GQ.jpeg)

Why do we need to create partitions. Because its powerful, if we take a look at the partitions that are created we notice that even though the lists are not completely sorted the items inside are ordered by the pivot. Since we know the numbers are in the correct spots there's no need to compare elements on the left of the pivot to the right

## Swapping

How does quicksort actually do the work of sorting elements into the left and right portions?

Quicksort is an algorithm that sorts elements in-place. Remember in-place means that the sort will run directly on input data and only needs a constant amount of extra space. There is a pointer to an element on the left of the pivot and there's a pointer to an element on the right of the pivot. If they're not in the right order the left and right elements swap places. Once this loop finishes running the pivot is then swapped into its proper position.

Lets finish off our quicksort method by implementing our partition and swap methods

```java
 private static int partition(int[] arr, int left, int right) {
    int pivot = arr[right];
    int index = left - 1;

    System.out.println("Array is: " + Arrays.toString(arr));
    System.out.println("Pivot is: " + pivot);
    System.out.println("Left Index is: " + left);
    System.out.println("Right Index is: " + right);
    System.out.println("Index is: " + index);

    for (int j = left; j < right; j++) {
      System.out.println("Is element at index: " + j + " less than or equal to pivot: " + pivot);
      if (arr[j] <= pivot) {
        index++;
        System.out.println("Now swapping " + arr[index] + " and " + arr[j]);
        swap(arr, index, j);
        System.out.println("Array is now " + Arrays.toString(arr));
      }
    }
    System.out.println("Now swapping " + arr[index + 1] + " and " + arr[right]);
    swap(arr, index + 1, right);
    return index + 1;
  }


  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
```

## Runtime

The time complexity of quicksort is dependent upon a) what element we choose to be our partition and b) how sorted the list is

The average runtime for an unsorted list and a good partition value is O(n log n) why is that?

![Runtime](https://i.stack.imgur.com/2baWv.png)

Now why exactly do we want a "better" partition. When choosing a pivot we are aiming to choose a random value because we want to choose the median value of our list. We want this because our partitions should be equal in size

![WorstCase](https://i.imgur.com/KVrs6qq.png)

The runtime for a sorted or nearly sorted list that uses a pivot value that is not the median will be O(n<sup>2<sup>)

## The Stats

| type | comparison | 
|:-------------:|:-------------|
| time complexity | O(n log n) |
| space complexity | O(log n) in-place |
| internal/external | external |  
| sort-type | comparison |  
| function-type | recursion |
| stability? | unstable |

### Exercises

1. Show how quicksort sorts the array {E A S Y Q U E S T I O N}.

2. How would you modify QUICKSORT to sort into nonincreasing order?

3. Illustrate the operation of partition on the array A = {13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11}

4. Given the following list of numbers [1, 20, 11, 5, 2, 9, 16, 14, 13, 19] what would be the third pivot value
