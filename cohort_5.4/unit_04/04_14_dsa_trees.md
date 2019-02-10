# DSA Trees

## Objectives

* Define what a binary search tree is
* Explain why binary search trees are useful
* Write psuedo code to traverse a binary search tree
* Explain the Big O of Binary Search Tree methods
* Implement Binary Search Tree methods

## Resources

* https://stackoverflow.com/questions/2130416/what-are-the-applications-of-binary-trees
* https://visualgo.net/bn/bst
* https://www.cs.usfca.edu/~galles/visualization/BST.html

# Lecture

There are tons of data structures that we can use to store data and we can use different categories to differentiate these structures. One of these categories would be whether our data structure is linear or not. In linear data structures there is a specific sequence or order to how data is built and how the structure is traversed. Every data structure we've worked with so far has been a linear data structure

* Arrays

![Array](https://1.bp.blogspot.com/-wpNbM3dso9g/T1_wRFf79VI/AAAAAAAACrg/V1QB3Qxp_cU/s1600/eggs+real+world+array.jpg)

* Linked Lists

![List](https://i.imgur.com/dHcQH9u.png)

* Queues

![Queue](https://2lz8iu19k09n13d61e3d2mb0-wpengine.netdna-ssl.com/wp-content/uploads/2016/12/queue-1000x520.jpg)

* Stacks

![Stack](https://i.imgur.com/DC6k7b5.png)

But there are also non linear data structure. This means that there isn't a strict order to follow when building or traversing. There is no specific sequence to contents of these types of data structures.

One of the most important non-linear data structure's is the Tree

![Tree](https://i.imgur.com/NyyJmDa.png)

And just like trees our data structure starts at the root and then splits off into multiple branches which ends at the leaves. And as this tree continues to grow the branches get longer or branch into different paths

However trees aren't that different from what we've been working with so far. Trees are made up of Nodes that are similar to the one we used for linked lists. Trees are made up of nodes and links that connect but instead of having a single link each node can  have multiple links

### TreeNode

```java
public class TreeNode{
    TreeNode left;
    TreeNode right;
    int data;

    public TreeNode(int data){
        left = null;
        right = null;
        this.data = data;
    }
}
```

Tree nodes will have descriptions depending on where there position is in the tree.

* Root: The top most node, the beginning of the tree.
* Child: Nodes that have a parent node linked to it
* Parent: A node that has a link to another node
* Sibling: Group of nodes that are children of the same node
* Leaf: Nodes that does not have children. These nodes are at the end of the tree

# Implementation

## Insert

## Breadth First Search

## Depth First Search

### Pre Order

### InOrder

### PostOrder

## Find

## Size

1
You work with tree data structures every day: Think about your computers file system:

![Mac-File](https://cdn.macpaw.com/uploads/images/Screen%20Shot%202015-04-06%20at%208_52_24%20PM.png)

## Exercises

* Diagram the following set of numbers as a binary search tree:

* 1, 3, 4
* 3, 1, 4
* 5, 3, 8, 4, 0, 6, 7