# Binary Search and Θ(log(n))

## Objectives
* Fellows will explore Binary Search in Java

## Resources
* [Binary Search Algorithm](https://www.baeldung.com/java-binary-search)

## Warm-Up (5 Minutes) - Do This First!

You have two eggs, and access to a one-hundred story building. Both eggs are identical.

The aim is to find out the highest floor from which an egg will not break when dropped out of a window from that floor. If an egg is dropped and does not break, it is undamaged and can be dropped again. However, once an egg is broken, that’s it for that egg.

If an egg breaks when dropped from floor n, then it would also have broken from any floor above that. If an egg survives a fall, then it will survive any fall shorter than that.

**The question is: What strategy should you adopt to minimize the number egg drops it takes to find the highest floor?**

# Lecture

### Binary Search

Binary search is an efficient algorithm for finding an item from a sorted list of items. It works by repeatedly dividing in half the portion of the list that could contain the item, until you've narrowed down the possible locations to just one.

One of the most common ways to use binary search is to find an item in an array. A binary search algorithm finds an item in a sorted array in O(log n) time. An algorithm is said to run in logarithmic time if its time execution is proportional to the logarithm of the input size.

Pseudocode for binary search:

1. Let min = 0 and max = n-1.
1. If max < min, then stop: target is not present in array. Return -1.
1. Compute guess as the average of max and min, rounded down (so that it is an integer).
1. If array[guess] equals target, then stop. You found it! Return guess.
1. If the guess was too low, that is, array[guess] < target, then set min = guess + 1.
1. Otherwise, the guess was too high. Set max = guess - 1.
1. Go back to step 2.

Iterative Binary Search:

```java
public class Main {
    public static void main(String[] args) {
        int[] array = {0, 1, 5, 6, 10, 13, 22, 64, 75};
        int target = 5;

        System.out.println(iterativeBinarySearch(array, target));
    }

    // Iterative approach
    public static int iterativeBinarySearch(int[] array, int target) {
        int min = 0;
        int max = array.length - 1;

        while (min <= max) {
            int mid = min + (max - min) / 2;

            if (target < array[mid]) {
                max = mid - 1;
            } else if (target > array[mid]) {
                min = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
```

This search can also be performed with an approach called **Recursion**:

```java
public class Main {
    public static void main(String[] args) {
        int[] array = {0, 1, 5, 6, 10, 13, 22, 64, 75};
        int target = 5;
        
        System.out.println(recursiveBinarySearch(array, target));
    }

// Recursive approach

    public static int recursiveBinarySearch(int[] array, int target) {
        return recursiveBinarySearch(array, target, 0, array.length - 1);
    }

    public static int recursiveBinarySearch(int[] array, int target, int min, int max) {
        if (min > max) {
            return -1;
        }

        int mid = (min + max) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            return recursiveBinarySearch(array, target, mid + 1, max);
        } else {
            return recursiveBinarySearch(array, target, min, mid - 1);
        }
    }
}
```

If you are not interested in composing a Binary Search algorithm from scratch, there are Java libraries which already perform this operation:

```java
int index = Arrays.binarySearch(sortedArray, key);

//A sortedArray and an int key are passed to this method, where the key is searched for in the array of integers, are passed as arguments to the binarySearch method the Java Arrays class.

int index = Collections.binarySearch(sortedList, key);

//A sortedList & an Integer key, are passed to this method, where the key is searched for in the list of Integer objects, are passed as arguments to the binarySearch method in the Java Collections class.
```

Whether you copose your own methods, or use methods from other libraries, the divide-and-conquer approach of Binary search is a useful tool in any developers toolbox.

## Exercises

