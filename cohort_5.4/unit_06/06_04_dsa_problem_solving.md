# DSA Problem Solving

## Objectives

Fellows will be able to talk through DSA coding challenges and identify the runtime complexity and space time complexity of their solutions

## Lecture

### Arrays

|Term|Definition|
|:--:|:---------|
|**Array**|a static data structure that holds a fixed number of values of a single type. The length of an array is established when the array is created. After creation, its length is fixed. This means that an Array's size is immutable.|
|**ArrayList**|a dynamic data structure, meaning items can be added and removed from the list. This means that an ArrayList's size is mutable. A normal array in java is a static data structure, because you are stuck with the initial size of your array at assignment. An ArrayList can change in size by adding or removing elements.|

```java
// int array declared, and initialized with an array of exactly 5 int elements
// Array
int[] intArray = new int[5];
// ArrayList
ArrayList<Integer> integerArrayList = new ArrayList<>();
```

* Iterating through an array vs iterating through an ArrayList

```java
String word = "awesomesauce";
for (int i = 0; i < word.length(); i++) {
    System.out.println(word.charAt(i));
}

ArrayList<Character> characterList = new ArrayList<>();
for (int i = 0; i < characterList.size(); i++) {
    System.out.println(characterList.get(i));
}
```

|  Array's |
| |  Average Case | Worst Case |
|:-------------|:-------------:|:-------------|
| Access | O( 1 ) | O( n ) |
| Search |  O( n ) | O( n )|
| Insert |  O( n ) | O( n ) |  
| Delete |  O( n ) | O( n ) |  

|  ArrayList |
| |  Average Case | Worst Case |
|:-------------|:-------------:|:-------------|
| Access | O( 1 ) | O( n ) |
| Search |  O( n ) | O( n )|
| Insert | Ammortized O( 1 ) | O( n ) |  
| Delete |  O( n ) | O( n ) |  

Problem.

Given an array of positive integers a, Your task is to calculate how many of its elements have an even number of digits

Example:
for a = [12, 134, 111, 1111, 10] the output should be evenDigitsNumber(a) = 3

since:
 a[0] = 2 digits
 a[1] = 3 digits
 a[2] = 3 digits
 a[4] = 4 digits
 a[5] = 2 digits

### Tree's

This is a non linear data structure that starts at some root node and then splits off into multiple branches which ends at the leaves. And as this tree continues to grow the branches get longer or branch into different paths. Tree's are usually implemented using nodes that will contain pointers to the child nodes in the tree.

Tree Node Class

```java
class Tree {
    public int x;
    public Tree left;
    public Tree right;
}
```

Tree nodes will have descriptions depending on where there position is in the tree.

* Root: The top most node, the beginning of the tree.
* Child: Nodes that have a parent node linked to it
* Parent: A node that has a link to another node
* Sibling: Group of nodes that are children of the same node
* Leaf: Nodes that does not have children. These nodes are at the end of the tree

A Binary Tree is when a tree is limited to having just two child nodes and we say the nodes nodes are either on the left or the right side

However one of the most common implementations will be the Binary Search Tree. BST's are data structures that follow a set of rules. We should be familiar with term binary (1s and 0s), in the context of trees our tree will start out with a single root but it becomes binary because there can only every be two links so a parent node can only ever have two children.

* Traversing through a tree

Depth First Search: "In Order"

```java
  public static void DFS(TreeNode current) {
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

Breadth First Search

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

Tree nodes will have descriptions depending on where there position is in the tree.

* Root: The top most node, the beginning of the tree.
* Child: Nodes that have a parent node linked to it
* Parent: A node that has a link to another node
* Sibling: Group of nodes that are children of the same node
* Leaf: Nodes that does not have children. These nodes are at the end of the tree

Problem 1)

Write a function that when given a binary tree T like the example below, We would like to return the number of nodes on the longest distinct path

Example's:

1. Given the tree:

                1
            /        \
           2           2
        /    \       /   \
      1       2     4     1

The function should return 3 because the Longest path of distinct nodes is [1 , 2 . 4]

2. Given the tree:

                1
                   \
                     2
                    /  \
                   1    1
                       /
                      4
The function should return 2 since the longest path is [1, 2]

### Object Oriented Design

The approach to OOD interview questions:
In Object Oriented Design questions, interviewers are looking for your understanding of complex problems and your ability to transform requirements/constraints given to you into Classes.

In fact, OOD questions generally will all follow a very similar pattern. You will be provided with a vague problem and a set of constraints for a system to design, and very little else. It is then up to you to figure out the “level” of solution that the interviewer is looking for, what kind of functionality will be needed, and come up with a solution.

Interviewers are looking for one main thing: finding the right balance between a solution that works immediately and is able to change in the future.

Problem 3:

        - Don't worry about persistence. It would make sense here, but for this

         exercise only use in-memory data structures.

        - Just focus on writing clean maintainable code.


Specification:

Create a class LeaderBoard whose interface includes the following methods:


Method Name: add_score

    - Add a new score to the player's average. If a player doesn't exist in the

    LeaderBoard, they will be automatically added.


    Args:


            player_id (Integer): The player's ID.

            score (Integer): The score to record for the player


    Returns:


            Double: The new average score for the given player

Method Name: top

    - Get the top player_ids on the leaderboard ordered by their average scores

    from highest to lowest


    Args:


            num_players (Integer): The maximum number of player_ids to return


    Returns:


            List<Integer>: a list of player_ids

Method Name: reset

    - Removes any scoring information for a player, effectively

    resetting them to 0


    Args:


            player_id (Integer): The player's ID.

Example Usage:

// Create a new LeaderBoard Instance

LeaderBoard leader_board = new LeaderBoard();

// Add scores for players to the LeaderBoard

leader_board.add_score(1, 50); // 50.0

leader_board.add_score(2, 80); // 80.0

leader_board.add_score(2, 70); // 75.0

leader_board.add_score(2, 60); // 70.0

leader_board.add_score(3, 90); // 90.0

leader_board.add_score(3, 85); // 87.5

// Get top positions for the leaderboard

leader_board.top(3); // [3, 2, 1]

leader_board.top(2); // [3, 2]

leader_board.top(1); // [3]

// Reset a player 3's scores

leader_board.reset(3); // void

// Player 3 is now at the bottom of the leaderboard

leader_board.top(3); // [2, 1, 3]

Expected values

- Player IDs will always be positive integers, Scores are integers ranging from 0-100