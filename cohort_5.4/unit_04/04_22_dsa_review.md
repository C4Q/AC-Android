# DSA Review Trees & More

## Objectives

* Revisit the cost and benefits of binary search trees
* Implement Depth First Search
* Implement Breadth First Search
* Introduce Object Oriented Design

## Resources

* [Object Oriented Design](https://leetcode.com/discuss/interview-question/object-oriented-design/?currentPage=1&orderBy=recent_activity&query=)

* [OOP Interview Questions](https://www.careercup.com/page?pid=object-oriented-design-interview-questions)

* [OOP Concepts](https://medium.freecodecamp.org/object-oriented-programming-concepts-21bb035f7260)

* [Pizza and OOP](https://itnext.io/what-pizzas-can-teach-you-about-object-oriented-programming-3570143aef3f)

## Lecture

### Trees

A Tree is a data structure composed of nodes

* Each tree has a root node
* The root node has zero or more child nodes
* Each child has zero or more child nodes and so on
* A node is called a "leaf" node if it has no children

### Binary Tree

Binary Trees get their name from the way they are structured

* Each node has up to two children
* The root node can only point to two sub-trees
* Every binary tree consists of a left subtree and a right subtree
* Binary trees will be recursive

### Binary Search Tree

A Binary Search Tree is a binary tree where every node fits a specific order.

* All left nodes will be < than or = to the root nodes value
* All right nodes will be > than or = to the root nodes value
* This needs to hold for every node in the tree

When given a tree question dont assume that your given a binary search tree be sure to ask

### Tree Traversal

Tree traversal (also called tree search) is when we go through the process of walking through the nodes of a tree. Checking/Visiting each node only once. The order in which we traverse the nodes is how we classify the different traversal algorithms

There are 2 ways to traverse a tree

* Breadth-first
* Depth-first

![Compare Traversal](https://cdn-images-1.medium.com/max/1040/1*VM84VPcCQe0gSy44l9S5yA.jpeg)

### Breadth First Search

Breadth First Search will involve searching through the tree one level at a time, Traversing all the child nodes at one level first before moving on and traversing the grandchildren levels nodes before repeating the process on the great grandchildren nodes

But how do we solve the problem of traversing a tree in level order, we need to be able to keep a reference to all children that we visit otherwise we will never be able to go back and visit all the nodes in the tree.

BFS will lean on the queue data structure because we will be able to add nodes that we have discovered and not visited yet to our queue and then come back to them later

![Queue](https://i.imgur.com/aClaJ0z.jpg)

while we traverse the tree we are discovering nodes. A discovered node is one that we will add to our queue but we have not personally visited yet so we can store it in our queue until we are ready to move on.

When we start the root node will be the first discovered node once this node is in our queue we can start visiting the nodes and adding their children to the queue we can describe this process with the next couple of steps

Steps to BFS:

While our queue is not empty

1) Visit the node f (print)
2) Enqueue left child
3) Enqueue right child

### Depth First Search

In this traversal we will go through all the children and grand children of a certain path before we move on to a new direction. Basically once the algorithm starts on a path we wont stop until a leaf node is reached then the next subtree is visited.

#### In-Order Traversal

In order traversal means we visit/print the left branch of a tree then the current node and then the right branch. This will print out a binary search tree in sorted order.

```java
public void inOrderTraversal(TreeNode node){
    if(node != null){
        inOrderTraversal(node.left);
        System.out.println(node.data);
        inOrderTraversal(node.right);
    }
}
```

#### Pre-Order Traversal

Pre-order traversal will visit the current node first instead and then visit the left and right children. When run on a binary search tree the root node will be the first one visited

```java
public void preOrderTraversal(TreeNode node){
    if(node != null){
        System.out.println(node.data);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
}
```

#### Post-Order Traversal

Post-order traversal visits the current node after the children are visited. The root node will be the last node visited

```java
public void postOrderTraversal(TreeNode node){
    if(node != null){
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.data);
    }
}
```

### AMA

### Object Oriented Design

When you walk into a whiteboarding interview there are two types of questions you'll likely see. The first of the two will focus on Algorithm design where will use our knowledge of data structures and runtime complexity to solve some problem. 

The next type of question would be an Object Oriented Design question which will be more interesting. We have learned textbook knowledge of how interfaces and interfaces work OOD challenges the programmer to apply these concepts into practice.

OOD questions will generally start the same there will be an intentionally vague set of constraints. Unlike a programming challenge where code either works or it doesn't. There isn't a right answer, these problems are meant to allow the interview a chance to explain and handle design trade offs and how systems are impacted by these decisions.

### Approach

* Find the right level
* Talk through use cases
* Set your objects
* Wire relationships

A typical OOD questions would be "Lets design a program to play a game of cards like blackjack"

### Finding the right level

The very first thing to do is ask questions. Don't be afraid to ask for clarification. For example if it wasn't made clear you should ask if the interview wants you to implement the design or is only looking for how the class should be structured. Don't get lost in the details ask questions to determine what level of complexity you should be working on.

### Talk through use cases

Do you know how to play blackjack? Now is the time to ask for details because this is where use cases will be hashed out. You'll need to describe the game of blackjack lets break it down into two things.

* What you need
* How to play

### Set your objects

Lets look back at the sentence we wrote above and take note of each noun and property and try to represent them as objects and use to verbs to model a behavior that interacts with these objects

For example heres a noun we should model

* Deck

and heres a behavior we will need to model

* Dealing cards

### Wire the relationships

Its best to solve these types of problems bottom up where we describe the smallest set of behaviors before you work your way up to larger pieces. Working top down will be much more difficult if you end up having to do things with objects or behaviors that haven't been defined yet.

For example a Deck should be composed of cards and you should be able to drawCards and shuffleCards

We started with some vague questions added in our use cases and came up with a design that should model these behaviors. We should always keep in mind that our design should be flexible and reflect real life.

### Exercises

Parking Lot Design Using OO Design

Parking can be single-level or multilevel.

1 Types of vehicles that can be parked, separate spaces for each type of vehicle.
  
2 Constraints
  Number of vehicles that can be accommodated of any type.

3 Basic Design/High-Level Components
  Vehicle/Type of vehicle.
  Different spots for vehicles.
