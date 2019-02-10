# DSA Trees

## Objectives

* Define what a binary search tree is
* Explain why binary search trees are useful
* Write pseudo code to traverse a binary search tree
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

An array is similar to a carton of eggs where there can be rows and columns but we have a static size the carton can't magically get bigger or smaller and traversing the entire array will begin at index 0 and end at array length - 1

* Linked Lists

![List](https://i.imgur.com/dHcQH9u.png)

Lists can be visualized as songs in a Spotify playlist where each song belongs to a different album but will point to the next song because they belong to the same playlist.

* Queues

![Queue](https://2lz8iu19k09n13d61e3d2mb0-wpengine.netdna-ssl.com/wp-content/uploads/2016/12/queue-1000x520.jpg)

Queues are similar to a line of people waiting to check in. First customer In First customer Out (FIFO)

* Stacks

![Stack](https://i.imgur.com/DC6k7b5.png)

Stacks can be visualized as a stack of plates where the first plate on top will be the first plat to be used (Last In First Out)

But there are also non linear data structure. This means that there isn't a strict order to follow when building or traversing. There is no specific sequence to contents of these types of data structures.

One of the most important non-linear data structure is the Tree

![Tree](https://i.imgur.com/NyyJmDa.png)

And just like trees our data structure starts at the root and then splits off into multiple branches which ends at the leaves. And as this tree continues to grow the branches get longer or branch into different paths

However trees aren't that different from what we've been working with so far. Trees are made up of Nodes that are similar to the one we used for linked lists. Trees are made up of nodes and links that connect but instead of having a single link each node can  have multiple links

### TreeNode

```java
public class TreeNode{
    List<TreeNode> children;
    int data;

    public TreeNode(int data){
        children = null;
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

Trees will work the same way that a hierarchy does like a family tree a corporate ladder or a royalties line of succession. The Queen will be the root node at the top. The Queen will delegate to other parent nodes which may or may not have children of their own. And as the family continues to grow layers will get added to the tree and these parents and children will all be ancestors of the root node.

You work with tree data structures every day: Think about your computer's file system:

![Mac-File](https://cdn.macpaw.com/uploads/images/Screen%20Shot%202015-04-06%20at%208_52_24%20PM.png)

However one of the most common implementations will be the Binary Search Tree. BST's are data structures that follow a set of rules. We should be familiar with term binary (1s and 0s), in the context of trees our tree will start out with a single root but it becomes binary because there can only every be two links so a parent node can only ever have two children.

![Binary](https://cdn-images-1.medium.com/max/1040/1*UjSfPoMwCEkke1_iuNZ1EQ.jpeg)

Being able to handly split up and evenly divide our big tree into mini trees makes it easier to traverse down the tree.

The next rule we apply sort the contents of the tree in a specific way that will make the tree searchable. In order for the tree to be searchable all the nodes to the left must be less than the value of the root, then all the values on the right of the root need to be greater than the root.

![BST](https://cdn-images-1.medium.com/max/1040/1*rJa-Z60bKE0-MOFrAuXttQ.jpeg)

This should remind you of Binary Search on an Array. This becomes incredibly useful when we have tons of nodes in the tree and we can skip searching through all the nodes one by one this will be much more efficient. By dividing our search space in half we can conquer a huge dataset.

# Implementation

## TreeNode

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

## Insert

```java
  public void insert(int val) {
    if(root == null){
      root = new TreeNode(val);
      return;
    }
    insertNode(val, root);
  }

  private void insertNode(int val, TreeNode current) {
    if (val <= current.data) {
      if (current.left == null) {
        current.left = new TreeNode(val);
      } else {
        insertNode(val, current.left);
      }
    } else {
      if (current.right == null) {
        current.right = new TreeNode(val);
      } else {
        insertNode(val, current.right);
      }
    }
  }
```

## Contains

```java
public boolean contains(int val) {
    if (root == null) {
      throw new RuntimeException("Tree is empty");
    }
    return containsNode(val, root);
  }

  private boolean containsNode(int val, TreeNode current) {
    if (val == current.data) {
      return true;
    } else if (val < current.data) {
      if (current.left == null) {
        return false;
      } else {
        return containsNode(val, current.left);
      }
    } else {
      if (current.right == null) {
        return false;
      } else {
        return containsNode(val, current.right);
      }
    }
  }
```

## Breadth First Search

```java
  public static void BFS(TreeNode root) {
    Queue<TreeNode> treeNodes = new LinkedList<>();
    treeNodes.add(root);
    while (!treeNodes.isEmpty()) {
      TreeNode current = treeNodes.remove();
      if (current.left != null) {
        treeNodes.add(current.left);
      }
      if (current.right != null) {
        treeNodes.add(current.right);
      }
      System.out.println(current.data);
    }
```

## Depth First Search

### Pre Order

```java
  public static void preOrderDFS(TreeNode current) {
    if (current != null) {
      System.out.println(current.data);

      if (current.left != null) {
        preOrderDFS(current.left);
      }
      if (current.right != null) {
        preOrderDFS(current.right);
      }
    }
  }
```

### InOrder

```java
  public static void inOrderDFS(TreeNode current) {
    if (current != null) {
      if (current.left != null) {
        inOrderDFS(current.left);
      }
      System.out.println(current.data);
      if (current.right != null) {
        inOrderDFS(current.right);
      }
    }
  }
```

### PostOrder

```java
  public static void postOrderDFS(TreeNode current) {
    if (current != null) {
      if (current.left != null) {
        postOrderDFS(current.left);
      }
      if (current.right != null) {
        postOrderDFS(current.right);
      }
      System.out.println(current.data);
    }
  }
```

### Runtime

* Searching: When searching for an element if our element is the last node in the tree then we will have a worse case complexity of O(n) on average on a balanced tree there will be a runtime of O(H) where h is the height of the tree
* Insertion: When we insert an element worse case complexity will be O(n) On average the time complexity is O(h) where H is the height of the BST
* Printing: Printing the contents of the tree with BFS or DFS will have a worst case time complexity of O(n) where n is the number of nodes in the tree

## Exercises

* Diagram the following set of numbers as a binary search tree:

* 1, 3, 4
* 3, 1, 4
* 5, 3, 8, 4, 0, 6, 7
