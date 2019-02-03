# DS&A Data Structures: Queues

## Objectives

* Review queues and implementations of their common methods.
* Identify the run-time complexity of each implemented method
* Fellows will learn how Queues are used irl
* Fellows will see how Queues and Stacks differ

## Resources

## Warm-up

[Baseball](https://leetcode.com/problems/baseball-game/)

# Lecture

Queues and Stacks are often taught together because they are very similar even though their implementations can be very different. A Queue is an linear data structure just like a stack but instead elements are inserted from one end called the REAR or TAIL and removed from the other end called the FRONT or HEAD. This can be illustrated by a line customers in a store, new people join the back of the queue/line and the next person to be served will be first in the queue/line.

![Line](https://3.bp.blogspot.com/_w9XO9zBePXE/SKFjlee6K-I/AAAAAAAAAdk/iRjNgU62cmM/s1600/royston_queue.jpg)

The queue is a long list of elements that can grow through a process called enqueuing and shrinks through a process called dequeuing.

A queue is also like an array but it comes with additional rules:

* You can't access values randomly using an index
* You can only add values in one end and retrieve them from the other
* It has two explicit methods

## FIFO

This behavior is described as First in First Out. Where an item is inserted at one end (called the rear of the queue) and deleted from the other end (the front)

![FIFO](https://foodsafetyblog.statefoodsafety.com/wp-content/uploads/2017/03/SFS_2015_First_In_First_Out.jpg)

Similar to how we would handle food safety, lines at a bodega or any other store, elements inside of a queue basically take a number and wait their turn. The element at the front of the line is the first one to be processed by the program/algorithm that created it.

This is one of the most important difference's between stacks and queues. Stacks are considered Last in First Out data structures (LIFO) and Queues are First in First Out data structures (FIFO)

![FIFOLIFO](https://i.ytimg.com/vi/tbUlRMER_9w/hqdefault.jpg)

## Implementation

Queues and Stacks come up together often as a single topic because they end up using similar functions

1) A stack push function will be similar to the Enqueue function
2) A Stacks pop function will be the same as a queues dequeue function
3) size and isEmpty are helper functions they generally share

Remember how stacks can be implemented as an array, unfortunately this can result in messy stack overflows if we go out of bounds of the allocated memory. Turns out it can be just as bad of an idea to implement queues using arrays.

Arrays are useful when we know the size of the structure we need ahead of time. But if we don't then we need to go through a expensive process of copying over contents of one array to another once we've run out of allocated memory. and then enqueue a new element onto the new end. And if the size of the array grows accessing the end of the queue will cause the space time complexity to grow.

![implementation](https://i.imgur.com/jE26dDr.png)

So using a linked list implementation of a queue will help us avoid this problem since memory will be evenly distributed and our structure can now grow dynamically. (as long as we dont use the entire machines memory). Enqueuing and dequeuing gets a lot easier if we use Nodes and have each node point to the next neighbor it's important to recognize the differences between these implementations and decide what is more useful for the current situation.

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

Inserting into a queue can only happen at the back of the queue, similar to someone getting in line for a delicious Burger at In 'n Out. Assuming an efficient queue implementation, queue insertion is O(1).

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

Deleting from a queue happens at the front of the queue. Assuming an efficient queue implementation, queue deletion is O(1).

## Peek

```java
  public int peek() {
    if (first == null) {
      throw new NoSuchElementException();
    }
    return first.data;
  }
```

Returns the top of the queue. Since this position happens to be at the front of the queue we will just the return the data stored there. Runtime for this will be O(1)

## isEmpty()

```java
 public boolean isEmpty() {
    return first == null;
  }
```

This method returns true if and only if the queue is empty

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

## Queues in the wild

![Imgur](https://i.imgur.com/zB9Qz7U.png)

An example of real world applications of queues would be request queueing. When multiple devices send requests for data to some api or web application a server has to work to process these requests. Generally when we want to handle data requests on the internet like an Amazon web server handling sales on black friday. The incoming request will be stored in a queue. The requests are then processed one by one and the responses will be loaded into an outgoing response queue in the order that they have been processed. These responses are then returned back into the world

## Exercises

1) Show how to implement a queue using two stacks. Analyze the running time of the queue operations.

2) Show how to implement a stack using two queues. Analyze the running time of the stack operations.

3) Handle the case where the queue is empty and you try to dequeue or if the stack is full and you try to enqueue i.e handling under-flows and overflows

4) Problem: You are given an array A consisting of n integers. Array A represents a scenario in a grocery store, and contains only 0s and/or 1s:

• 0 represents the action of a new person joining the line in the grocery store,
• 1 represents the action of the person at the front of the queue being served and leaving
the line.

The goal is to count the minimum number of people who should have been in the line before
the above scenario, so that the scenario is possible (it is not possible to serve a person if the
line is empty).
