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

### Find Rectangles

Given an matrix filled with 1's representing blank space and 0's representing a filled cell. write a method called findCoordinates() that returns the X and Y coordinate of the left most 0 of a rectangle in the matrix and the length and height of the rectangle

Example input:

```java
int[][] matrix = {
  {1, 1, 1, 1, 1, 1, 1},
  {1, 1, 1, 1, 1, 1, 1},
  {1, 1, 1, 0, 0, 0, 1},
  {1, 1, 1, 0, 0, 0, 1},
  {1, 1, 1, 1, 1, 1, 1}
}
```

Expected output: [2,3,3,2]

### Total Sum

Given 2 Lists of integer values compute how many pairs i and j there are such that the sum of these integers is 0

Example input:

```java
A = [1, 2, 3]
B = [-2, 0, -3]
```

Expected Output: 2

The pairs are A[1] + B[0] 2 + -2 and A[2] + B[2] 3 + -3

### Design Question

Design a Movie Ticket Booking System

![Movies](https://cdn-images-1.medium.com/max/832/1*fCJWmC0Sq2vsYEbbZu2h_A.png)