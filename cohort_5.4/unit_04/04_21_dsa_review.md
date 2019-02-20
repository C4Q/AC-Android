# DSA Review Trees & More

## Objectives

* Revisit the cost and benefits of binary search trees
* Implement Depth First Search
* Implement Breadth First Search
* Introduce Object Oriented Design

## Resources

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

### Breadth First Search

Tree traversal (also called tree search) is when we go through the process of walking through the nodes of a tree. Checking/Visiting each node only once. The order in which we traverse the nodes is how we classify the different traversal algorithms

There are 2 ways to traverse a tree
* Breadth-first
* Depth-first

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

### Object Oriented

