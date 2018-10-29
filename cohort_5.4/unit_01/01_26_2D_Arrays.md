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

An algorithm is said to run in quadratic time if its time execution is proportional to the square of the input size:

* bubble sort, selection sort, insertion sort 

### Two-Dimensional Arrays (2D Arrays)

2D Arrays are useful in Java because they add an extra dimension to what an array can store. In a sense, it is like storing an additional array at every index of an array.

You can create a Two-Dimensional Array in the same ways you could create a regular array: via either direct assignment, or by size first, then element assignment later:

```java
int[][] array = {{3, 6, 9}, {12, 15, 18}, {21, 24, 27}};

int[][] array02 = new int[3][3];
```

Let's say we wanted to create an 8x8 checkerboard pattern, using the hash symbol - "#". We could assign spaces and hash symbols as required, using a modulo to interweave the characters:

```java
    int col = 8;
    int row = 8;
    String[][] array = new String[col][row];
    for(int i = 0; i < col; i++) {
      for(int j = 0; j < row; j++) {
        if((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
          array[i][j] = " ";
        } else {
          array[i][j] = "#";
        }
      }
    }
    for(int i = 0; i < col; i++) {
      for(int j = 0; j < row; j++) {
        System.out.print(array[i][j]);
      }
      System.out.println();
    }
```

We would get an output like this:

```
 # # # #
# # # # 
 # # # #
# # # # 
 # # # #
# # # # 
 # # # #
# # # # 
```

Because of the way 2D arrays organize data, they are often used to assign x/y coordinates on a cartesian plane - i.e: a game of Battleship, or Tic Tac Toe. They can also be used for tracking pixels on an image or screen.

As seen above, a useful way to traverse a 2D Array is by using nested for loops. Although this might seem like an inefficient use of time complexity (quadradic time) - as long as the number is low, or constant (8x8 checkerboard, tic-tac-toe board), nested loops may be the obvious choice for solving a task.


