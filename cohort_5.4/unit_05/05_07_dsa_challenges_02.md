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

### Linked List Quick reference

|  | Worst Case |
|:-------------:|:-------------|
| space | O( n ) |
| prepend | O( 1 )|
| append | O( 1 ) |  
| lookup | O( n ) |  
| insert | O( n ) |  
| delete | O( n ) |  

A linked list organizes items in a sequence each element points to the next

An element of a linked list is called a node the first node is the head the last node is called the tail

Strengths:

* Fast operations at Head and Tail
* Flexible Size

Weaknesses:

* Costly lookup

### Contains a cycle

You have a singly-linked list and want to check if it contains a cycle.

A singly-linked list is built with nodes where each node has

* node.next - the next node in the list
* node.value - the data held in the node.

```java
public class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }
}
```

A cycle occurs when a node.next points back to the previous node in our list. The linked list is no longer linear with a beginning and end it is now a loop.

Write a method containsCycle() that takes the first node in a singly-linked list and returns a boolean indicating whether the list contains a cycle

### Check permutation

Write an efficient method that checks whether any permutation of an input string is a palindrome

You can assume that input string only contains lower case letters

Examples

* "civic" should return true
* "ivicc" should return true
* "civil" should return false
* "livci" should return false

### Greedy Algorithm Review

A greedy algorithm builds up a solution by choosing the option that looks the best at every step.

Say you're a cashier and need to give someone 67 cents (US) using as few coins as possible. How would you do it?

Whenever picking which coin to use, you'd take the highest-value coin you could. A quarter, another quarter, then a dime, a nickel, and finally two pennies. That's a greedy algorithm, because you're always greedily choosing the coin that covers the biggest portion of the remaining amount.

### Stock Price

Writing programming interview questions hasn't made me rich yet ... so I might give up and start trading Apple stocks all day instead.

I want to know how much money I could have made yesterday If I had been trading stock all day 

So I grab the prices from yesterday put them in an array where

* The indices are the time in minutes past trade open time

* The values are the price in dollars of one share at that time

Write an efficient method that takes stockPrices and returns the best profit I could have made from one purchase and one sale of one share of stock yesterday.

```java
int[] stockPrices = new int[] {10, 7, 5, 8, 11, 9};

getMaxProfit(stockPrices);
// returns 6 (buying for $5 and selling for $11)
```

No "shorting"—you need to buy before you can sell, you can't buy and sell in the same time step—at least 1 minute has to pass.

### Design Question

Design a Movie Ticket Booking System

![Movies](https://cdn-images-1.medium.com/max/832/1*fCJWmC0Sq2vsYEbbZu2h_A.png)