# DSA Linked List

## Objectives

* Review Linked lists and implementations of methods
* Identify the runtime complexity of each implemented operation

## Resources

# Lecture

## Data Structures

A data structure is a way to store and organize data so that we are able to easily access and modify content. No single data structure works well for all purposes so it's important for us to know a structures strengths and limitations

## Array Review

Arrays are the most common data structures used to store collections of elements. In most programming languages arrays are convenient to declare and use [ ] syntax to access elements by their index.

```java
public class ArrayDemo {
    public static void main(String[] args) {
        //declares an array of integers
        int[] scores;

        // allocates memory for 5 integers
        scores = new int[5];
        
        // initializes elements
        scores[0] = 50;
        scores[1] = 60;
        scores[2] = 70;
        scores[3] = 80;
        scores[4] = 90;
        
        System.out.println(Arrays.toString(scores));
    }
}
```

The key point here is that an entire array is allocated as one block of memory. Each element in the array gets its own space and once set up elements can be accessed directly. But there are disadvantages

1) The size of the array is fixed once memory is allocated and the code has compiled

2) Waste's memory if we try to allocate arrays to be "big enough"

3) Inserting or deleting elements can be expensive if we need to shift elements around

## Linked Lists

Linked Lists approach this memory management problem with a different strategy. It allocates memory for each element separately and only when needed.

![array](https://algorithmsandme.com/wp-content/uploads/2018/08/difference-between-array-and-linkedlist.png)

![linkedlist](https://algorithmsandme.com/wp-content/uploads/2018/08/difference-between-array-and-linkedlist-1.png)

This is why linked lists are dynamic data structures. Arrays aka static data structure's needs all of its resources to be allocated when it is created, size is needed upfront. Dynamic data structures can shrink or grow because of how the elements are scattered in memory.

Each element will be its own separate block of memory called a "node" the list gets its structure by using pointers to connect all its nodes together like "links" in a chain creating a linear structure. There is a sequence and an order to how the list is built.

```java
public class LinkedListNode {

  int data;
  LinkedListNode next;

  LinkedListNode(int data) {
    this.data = data;
    next = null;
  }
}
```

Each node contains two field, a data field to store whatever element type the list will hold and the next field which is the pointer to link one node to the next node. Each node will be allocated in memory so it will continue to exist. The starting point of the list will be the pointer to the first node which we call the "head". All lists must have a head we use this as our starting point because this will be our only entry point to the elements stored in the list. To mark the end of the list the last node or the tail will point to null (an empty value).

This is why linked list's won't need to be in the same block of memory. Each node has an address so when we iterate through the list we use pointers to get to each element. Adding and removing elements are made easier by these pointers because we would have to rearrange these pointers instead of copying elements. However operations will be fast until we have to work with a node that might be further away from the front.

## List-Search

```java
 public LinkedListNode search(int key) {
    LinkedListNode current = head;
    while (current != null && current.data != key) {
      current = current.next;
    }
    return current;
  }
```

For example if we want to search for an element in our list we'll use a variable to reference our heads current position in the list. We'll then use the nodes pointers to move on to the next node in the list this will run until we find the first node with the value we're looking or a null will be returned if this does not exist in the list. This will be quick if the head is the
element we are looking for. But if our list were to continue grow and our element is at the end of our list this operation will take longer to process. the runtime complexity will be O(n) where n is the number of elements in our list.

## List-Insert

```java
public void add(int data) {
    LinkedListNode current = head;
    LinkedListNode temp = new LinkedListNode(data);
    if (head == null) {
      head = temp;
      return;
    }
    while (current.next != null) {
      current = current.next;
    }
    current.next = temp;
    size++;
  }
```

Inserting an element at the end of a list will be a 3 step process

1. We'll find the node we want to change the pointer of(The last node (tail))

2. Create a new Node we want to insert and set its pointer to null

3. Modify the old node to point to the new node instead of null

There's an increase in complexity because we're not adding something to the list at the beginning which would be easy due to our reference to the list's head, we have to find the last node instead which means we would have to loop through the entire list which will take time specifically O(n).

However if we were to insert a node at a known position like the head of our linked list we would only have to run a swap operation and avoid having to iterate through the entire list.

```java
  public void push(int data) {
    LinkedListNode temp = new LinkedListNode(data);
    if (head == null) {
      head = temp;
      return;
    }

    temp.next = head;
    head = temp;
    size++;
  }
```

## List-Print

Heres a method that will print our list

```java
  public void print() {
    LinkedListNode current = head;

    while (current != null) {
      System.out.print(current.data + "---> ");
      current = current.next;
    }
    System.out.println("NIL\n");
  }
```

## List-Delete

```java
public void delete(int key) {
    LinkedListNode current = head;
    LinkedListNode prev = current;

    while (current != null && current.data != key) {
      prev = current;
      current = current.next;
    }

    if (current != null) {
      prev.next = current.next;
    }
    size--;
  }
```

if we want to remove an element from the linked list we will need a pointer to both the current node and the previous node once we find the node that we want to remove we'll modify the pointer of our previous node and have it point to null instead.

## List-Size

```java
public class LinkedList {

  private LinkedListNode head;
  private int size;

  public LinkedList(LinkedListNode head) {
    this.head = head;
    size = 1;
  }

  public int getSize() {
    return size;
  }
   ...
```

To keep track of the list size or length insert and delete operations should either increment or decrement the size field.


## Review

|        |  Linked List  |    Array   | Dynamic Array |
|:------:|:--------------|------------|---------------|
| Search | O(n) | O(n) can be O(log n) |  O(n) can be O(log n) |
| Insert/delete (at beginning) | O(1) | n/a | O(1) |
| Insert/delete (at end) | O(n) can be O(1) | n/a | O(1) amortized |
| Insert/delete (at middle) | Search + O(1) | n/a | O(n) |

## Exercises

1. Write a Count() function that counts the number of times a given int occurs in a list.

2. Write a Pop() function that is the inverse of Push(). Pop() takes a non-empty list, deletes the head node, and returns the head node's data

3. Write a RemoveDuplicates() function which takes a list sorted in increasing order and deletes any duplicate nodes from the list

4. Write an iterative Reverse() function that reverses a list by rearranging all the .next pointers and the head pointer. Ideally, Reverse() should only need to make one pass of the list
