# DSA Data Structures: Queues

## Objectives

* Review queues and implementations of their common methods.
* Identify the run-time complexity of each implemented method
* Fellows will learn how Queues are used irl
* Fellows will see how Queues and Stacks differ

## Resources

## Warm-up

[Baseball](https://leetcode.com/problems/baseball-game/)

# Lecture

Queues and Stacks are often taught together because they are very similar even though their uses and implementations can be very different. A queue queues things in a queue. and this can be illustrated by a line customers in a store. New people join the back of the queue and the next person to be served will be first in line

![Line](https://3.bp.blogspot.com/_w9XO9zBePXE/SKFjlee6K-I/AAAAAAAAAdk/iRjNgU62cmM/s1600/royston_queue.jpg)

A queue is a linear data structure that will contain a long list of elements a that can grow through a process called enqueuing and shrinks through a process called dequeuing.

A queue is also like an array but comes with additional rules:

* You can't access values randomly using an index
* You can only add values in one end and retrieve them from the other
* It has two explicit methods

## FIFO

This behavior is described as First in First Out. Where an item is inserted at one end (called the rear of the queue) and deleted from the other end (the front)

![FIFO](https://foodsafetyblog.statefoodsafety.com/wp-content/uploads/2017/03/SFS_2015_First_In_First_Out.jpg)

Similar to how we would handle food safety, lines at a bodega or any other store, elements of a queue take a number and wait their turn. The element up front is the first one to be processed or run by whatever program or algorithim is running.

This is the most important difference between stacks and queues stacks are considered Last in, First Out structures LIFO and Queues are First in First Out structures or FIFO

![FIFOLIFO](https://i.ytimg.com/vi/tbUlRMER_9w/hqdefault.jpg)

## Implementation

Queues and Stacks come up together often as a single topic because they end up using similar functions and implement the same data type.

1) A stack push function will be similar to the Enqueue function
2) A Stacks pop function will be the same as a queues dequeue function
3) size and isEmpty are helper functions they generally share

Remember how stacks can be implemented as an array and can result in messy stack overflows if we go out of bounds of the allocated memory. Well it turns out its an even worse idea to implement this using queues.

Arrays are useful when we know the size of the structure we need ahead of time. But if we dont then we meed to go through a expensive process of copying over contents of one array to another once we've run out of allocated memeory. and then enqueue a new element onto the new end. And if the size of the array grows accessing the end of the queue will cause the space time complexity to grow

So using a linked list implementation of a queue will help us avoid this problem since memory will be evenly distributed and our structure can now grow dynamically. (as long as we dont use the entire machines memory). Enqueueing and dequeueing gets alot easier if we use Nodes and have each node point to the next neighbor its important to recognize the differences between these implementations and decide what is more useful for the current situation.

## Enqueue

```java
  public void enqueue(int val) {
    QueueNode tempNode = new QueueNode(val);
    if (last != null) {
      last.next = tempNode;
    }
    last = tempNode;
    if (first == null) {
      first = last;
    }
  }
```

## Dequeue

```java
  public QueueNode dequeue() {
    if (first == null) {
      throw new NoSuchElementException();
    }
    QueueNode data = first;
    first = first.next;
    if (first == null) {
      last = null;
    }
    return data;
  }
```

## Peek

```java
  public int peek() {
    if (first == null) {
      throw new NoSuchElementException();
    }
    return first.data;
  }
```

## isEmpty()

```java
 public boolean isEmpty() {
    return first == null;
  }
```

## Print

```java
  public void print() {
    while (first != null) {
      System.out.print(first.data + " ==> ");
      first = first.next;
    }
    System.out.print("NIL\n");
  }
```

## Exercises

1) Show how to implement a queue using two stacks. Analyze the running time of the queue operations.

2) Show how to implement a stack using two queues. Analyze the running time of the stack operations.

3) Problem: You are given an array A consisting of n integers. Array A represents a scenario in a grocery store, and contains only 0s and/or 1s:

• 0 represents the action of a new person joining the line in the grocery store,
• 1 represents the action of the person at the front of the queue being served and leaving
the line.

The goal is to count the minimum number of people who should have been in the line before
the above scenario, so that the scenario is possible (it is not possible to serve a person if the
line is empty).