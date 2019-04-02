# Interview Prep

## Objectives

* To give fellows experience with technical interviews
* Apply Data structures in an efficient way
* Analyze runtime complexity and design efficient algorithms

## Resources

* [Tech Interview Handbook (github)](https://github.com/yangshun/tech-interview-handbook)
* [Interview Prep Kit (hackerrank)](https://www.hackerrank.com/interview/interview-preparation-kit)
* [Whiteboarding tips (blog post)](https://codewithoutrules.com/2016/04/04/interview-puzzles/)

## DSA Challenges

### Total Sum

Given 2 Lists of integer values compute how many pairs i and j there are such that the sum of these integers is 0

Example input:

```java
A = [1, 2, 3]
B = [-2, 0, -3]
```

Expected Output: 2

The pairs are A[1] + B[0] 2 + -2 and A[2] + B[2] 3 + -3

### Next Greatest Node

We are given a linked list with head as the first node

Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, If such a j does not exist, the next larger value is 0.

Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).

```java
Example 1:

Input: [2,7,4,3,5]
Output: [7,0,5,5,0]
```

```java
Example 2:

Input: [1,7,5,1,9,2,5,1]
Output: [7,9,9,9,0,5,0,0]
```

### House Robber

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

```java
Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
```

### Design Question

Design an ATM

![ATM](https://cdn-images-1.medium.com/max/832/1*9eN453T9BuRUycszcWvnrg.png)