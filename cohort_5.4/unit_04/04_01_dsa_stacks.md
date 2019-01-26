# DSA Data Structures: Stacks

## Objectives

* Review stacks and implementations of their common methods.
* Identify the runtime complexity of each implemented operation.
* Fellows will learn how to avoid stack overflows and underflows

## Resources

* [Call Stack Youtube](https://www.youtube.com/watch?v=UcPuWY0wn3w)
* [Stack Theory Youtube](https://www.youtube.com/watch?v=anp7ovRVhTY)
* [Java Stacks Princeton](https://introcs.cs.princeton.edu/java/43stack/)
* [Jenkov Java Stacks](http://tutorials.jenkov.com/java-collections/stack.html)

# Lecture

Stacks are dynamic sets of data which is made up of a bunch of elements. Stacks are similar to Arrays and Linked Lists because it is an linear structure. Meaning that there is an order to how they are built or how the structure is traversed.

![Plates](https://imgur.com/DC6k7b5)

Similar to how we would handle a stack of plates, there is only one direction to the stack (if we don't want to deal with a mess). If we want to add an element or take something from it we have to do it from the "top". This is because if we had a large stack say 100 plates it be difficult to add this to the first position in the stack or the bottom

## LIFO

This type of behavior has a name “Last In, First Out” or LIFO. The first item you add to the list will end up being the last one that goes out if you continue to push items into the stack. The least element that was added to the stack will be the first element to go out.

You push an item onto a stack, peek to see the value that’s currently on top of the stack and then pop that item off of the stack.

A stack is just like an array/list but it has certain restrictions

* You can't access items randomly using an index
* You can only add and retrieve items in the stack from the top
* It has three methods: Push, Pop, and Peek


## Push

```java
 public void push(int item) {
    StackNode t = new StackNode(item);
    t.next = top;
    top = t;
  }
```

Insert operations on a stack is often called a PUSH operation since no traversal takes place during this process the runtime will be O(1)

## Pop

```java
  public int pop() {
    if (top == null) {
      throw new EmptyStackException();
    }
    int item = top.data;
    top = top.next;
    return item;
  }
```

Removal operations on a stack is often called a POP operation since only the top element is accessible we would be popping elements in the reverse order in which they were pushed. However if we tried to pop an empty stack we would say we have a stack underflow which is an error that needs to be thrown.

## Peek

```java
 public int peek() {
    if (top == null) {
      throw new NoSuchElementException();
    }
    return top.data;
  }
```

If we wanted to know what value was currently at the top of the stack but we didn't want to actually start removing items from the data structure we would need to peek the top elements data

## isEmpty

```java
  public boolean isEmpty(){
    return top == null;
  }
```

We should be doing our best to avoid stack underflows and stack overflows. If attempting to pop an element of an empty stack will cause an underflow we will need a method to check if a stack is empty or not. The isEmpty method will check if the top is null and return a true or false.

## Print

```java
  public void print() {
    if (top == null) {
      throw new EmptyStackException();
    }
    StackNode current = top;
    System.out.println("______");
    while (current != null) {
      System.out.println("|  " + current.data + "  |");
      if(current.next != null){
        System.out.println("______");
      }
      current = current.next;
    }
  }
```

Print will just display the contents of our stack

## Stack OverFlows

It appears that stacks and linked lists have a lot of similarities we can see that this example is implemented by using a Linked List since we only want to grow the stack in one direction and the top of the stack would essentially be the head of our list. That being said linked lists are not the only option we have. 

![Array](https://imgur.com/iGSidci)

A Stack can also be implemented using an array but there would be drawbacks to doing this.



The problem with stacks is that there is no upper-limit to their size they can grow infinitely. Our stack won't prevent us from adding elements to it but arrays are static data structures. So if our array does not have enough memory to allocate a new element we'll get a stack overflow.

Here's an example of code that would cause a stack overflow to occur

```java
    public static void recursivePrint(int num) {
        System.out.println("Number: " + num);
        if(num == 0)
            return;
        else
            recursivePrint(++num);
    }
```

A recursive method that has no base case and will overflow space in our programs memory which is referred to as the call stack. The call stack is memory that is used to save the return address of methods and local variables.

![Overflow](https://www.itcsolutions.eu/wp-content/uploads/2011/02/CallStack.gif)

This would be the error thrown by the jvm when a stack overflow takes place

```
Exception in thread "main" java.lang.StackOverflowError
	at java.base/java.nio.Buffer.<init>(Buffer.java:217)
	at java.base/java.nio.CharBuffer.<init>(CharBuffer.java:279)
	at java.base/java.nio.HeapCharBuffer.<init>(HeapCharBuffer.java:84)
	at java.base/java.nio.CharBuffer.wrap(CharBuffer.java:386)
	at java.base/sun.nio.cs.StreamEncoder.implWrite(StreamEncoder.java:280)
	at java.base/sun.nio.cs.StreamEncoder.write(StreamEncoder.java:125)
	at java.base/java.io.OutputStreamWriter.write(OutputStreamWriter.java:211)
	at java.base/java.io.BufferedWriter.flushBuffer(BufferedWriter.java:120)
	at java.base/java.io.PrintStream.write(PrintStream.java:605)
	at java.base/java.io.PrintStream.print(PrintStream.java:745)
	at java.base/java.io.PrintStream.println(PrintStream.java:882)
```

We can avoid a situation like this by implementing a stack as a linked list they rarely causes a stack overflow since lists can grow infinitely. But a problem would occur if the list happens to use all possible memory of in the machine we'd have a much bigger problem to deal with.

## Why Choose A Stack

Stacks are useful in a number of surprising ways. They are
useful when you need to know the very last value that was seen in
a loop or when.

* Reversing a string
* Checking an opening/closing structure's like parentheses
* Traversing a graph or a tree

Another real world example of stacks would be how a web browser history would be implemented

![Browser](https://i.stack.imgur.com/bOga5.png)

## Exercises

1) Illustrate the result of each operation in the sequence PUSH(4), PUSH(1), PUSH(3), POP(), PUSH(8) and POP() on an initially empty stack implemented with an array with length = 6, use the image from earlier as a reference.

2) Create an undo method which pushes the last element that was popped back into the stack. Account for the case when no element has been popped off the stack yet

3) [Baseball Game leetcode](https://leetcode.com/problems/baseball-game/)

4) What does the following code fragment print when n is 50?

```java
Stack stack = new Stack();
while (n > 0) {
    stack.push(n % 2);
    n /= 2;
}
while (!stack.isEmpty()){
  System.out.println(stack.pop());
}
System.out.println();
```

5) [Min-Stack](https://leetcode.com/problems/min-stack/)
