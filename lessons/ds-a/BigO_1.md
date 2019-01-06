# DS & A: Runtime Complexity

### Overview: Intro

When programming, it's important to keep in mind the efficiency of what you build. Part of writing elegant and efficitent code is choosing the right data-structure to represent your information and using the proper algorithms so that your code runs efficiently and is maintanable.

A data-structure in itself is a way to organize information to be used at a later time. An example of this and probably the structure you have used the most up to this point is the `List`: A collection of elements. 

There are different data structures and each have their own attributes which mean they treat data differently. You have experienced this with the `stack` and the `queue`. It is important to know which structure to use for which situation. For example: Android uses a kind of `map` ( key-value pair ) to store information in shared preferences. Your choice of structure might make things easier or more difficult for you, so it is important to think about how you'll organize your data. Generally you'll find that the simplest way is the best.

### Big-O notation: Time and space! (Cue the space orchestra!)

Big O notation is a way to measure the performance of your code, and performance is measured along resource consumption. In computing, there are two main resources consumed, these are `time` and `space`. Beyond a certain point improving the performance of a computation involves tradeoffs between consuming more of one to consume less of the other. 

Big O itself allows us to classify the runtime complexity of an operation. The O stands for `order of the function`, in other words a block of code is classified by the amount of time or space necessary for a computer to produce an output as its input grows. Basically it measures how well your code scales depending on the size of input. This may be hard to grasp and so at the end of this lesson we will follow through with some examples to demonstrate. First lets learn about our resources.

#### Time: 
In computing, we measure the amount of processing or the number of operations a program needs to perform to accomplish its objective. A data structure is a part of a program and the main purpose of a Data Structure is to help you achieve some type of operation `fast`. That's what the underlying `algorithms` behind their operations seek. A data-structure and an algorithm share a symbiotic relationship. You want to be able to produce the output of your program in as small a time frame as possible, which means as few computational steps as you can muster. In android, this equates to using less resources and a smooth user-experience, in overall software engineering, this as well equates to system stability.

#### Space:
Processing information by nature takes up `resources`, computers, although relatively powerful these days, still have limits in the amount of information they can process. The resources that you have to keep in mind while programming are generally `RAM` for processing power and `Hard disk space` for data storage. When creating certain data structures or working with certain algorithms you'll often notice that you might have to use a combination of structures to process your data. The more structures you use the more space you will be taking up in terms of processing power which might equate to a longer computation. So generally you want to use the least amount of space possible.

#### Complexity
In general, complexity is a measure of performance. The more complex an operation, the more expensive it will be. However, there are some computations that can only be done through complexity, in those cases, although it may be expensive, the fact that certain structures even make them possible, and depending on the urgency and practicality of the solution, the complexity involved might make the trade off worthwhile.

The amount of data that you process can greatly affect the speed at which you process that information, depending on how it is being processed. You can mix and match different data structures to achieve optimal performance. Efficiency is about finding a balance between both. 

We can measure `space` by the amount of information held in memory, (bytes, kilobytes, megabytes, gigabytes, etc.) But how do we measure such a thing as `speed` when it comes to the excecution of our code? Especially if the code is being run on machines with varying architectures which may mean different resources available for computation?

That's where the notion of [Big O](https://en.wikipedia.org/wiki/Big_O_notation) comes in. A measurement of algorithm performance would look something like `O(nlog(n))`. Don't worry about the mathematics of it, what this essentially means is how does this algorithm scale in relation to its input. Which you will see examples of. What we want to grasp is how the notation applies to the essence of an algorithm and so we will focus mainly on its use in computer science and how to analyze your code with it.

`tldr; Complexity is a measure of how resource requirements change as the size of the problem gets larger, the higher the complexity the worse the performance`

### Measurement 
There is a way to calculate all of the points that affect performance in a block of code, but the main idea is that as we grow in input size, some of our measurements become meaningless because they have less influence on the number of calculations performed. Which means that what we really want is to focus on the factors that have the most influence on our performance: What makes the number of calculations grow the most. 

Utimately, because we may have different speeds depending on how many calculations we are doing we measure the efficiency of a program based on what is called a lower bound or it's worst performance.

An example that might help illustrate this idea is an algorithm in other words a sequence of steps that sorts playing cards. Specifically [Bogo sort](https://en.wikipedia.org/wiki/Bogosort). Lets say you have three playing cards and you throw them up in the air, what are the chances that they will land in order on the first try? The best case would be that they do, the worst case is that they don't for many tries. If you switched out your algorithm you might get a better performance because you might be able to determine the at the very worst case, how many operations it would take you to sort these. 

Because we have to sort three playing cards and they have to land one by one in order we say that the runtime complexity of such an algorithm is `O(n)` also called `linear time complexity`. The n is based on the number of elements we have to acount for. This is the best case scenario for bogo sort, although probable, its probablity is impractical to the point that you might as well not count on it.

On the other hand the worst case complexity for this is unbounded. Or infinite.
From the wiki: "In the worst case, the number of comparisons and swaps are both unbounded, for the same reason that a tossed coin might turn up heads any number of times in a row."

It would be impractical to expect bogosort to behave in it's best performance for every permutation of its execution unless I deliberately toss the cards in order 1 by 1, in computer terms: if I pass in an already sorted list. this is why counting the worst case gives us an accurate picture of how an algorithm might perform. 

`tldr; Our measure of performance is based on the` [worst case](https://en.wikipedia.org/wiki/Best,_worst_and_average_case) `scenario of how performance changes based on input size. If the input size doubles, does the number of operations double, what if input triples?, or is the relationship between input size and operations different? Worst case: what is the maximum number of basic operations that might have to be performed on the input?`

### Examples:

Big O expresses the complexity of an algorithm:

* `Constant`: An Algorithm whose complexity does NOT change with the input size is: `O(1)` also called `constant time complexity` (there are very few of these, where no matter the input size the execution time will be the same)
* `Linear`: Whenever you see `n` in a complexity analysis it stands for the size of the input. When an algorithm is `O(n)` that means it grows `linearly` with the size of the input. In other words, If you make 5 calculations at 5 milliseconds total, and it takes 10 milliseconds to do 10 calculations you have an `O(n)` algorithm. This is called `linear time complexity`
* `Quadratic`: The complexity of an algorithm is `O(n2)` if the time taken by the algorithm increases `quadratically` when `n` increases. In other words if it takes you 100 seconds to sort 100 elements and 200 elements will take you 400 seconds then 300 elements will take you 900 seconds then the time taken by your algorthim increases quadratically based on the input size.
 

Here is a good place to show that lower order terms and constants do not matter in expressing complexity. An example of this is that `O(n2+1000) == O(n2)`. If n were millions of elements the 1000 is a constant that does not really make a difference in the complexity or the time taken by an algorithm. The same follows for lower order terms: ie. `O(n2+n) == O(n2)` because if you have billions of items the lower term `n` does not make a difference, and so it becomes insignificant.

The fastest algorithms are `constant: O(1)`,  with the slowest carrying higher orders of `n: O(n), O(n2), etc..`

#### Example 1: 
What is the runtime of the following method?

```
public static void simpleFunction(int n) {
    int a = 9;
    int b = 3;
    
    int sum = a + b + n;
    int product = a * b * n;
    int quotient = a * n/b;
    
    System.out.Print("sum: " + sum + " product: " + product + " quotient: " + quotient);
}
```
Take notice of how we used the input `n` in this method. Note that we don't care about the actual number of operations, complexity is based on the size of the input. If we change the input size you need to understand whether it's running time will change.

The excecution of this method is a constant time operation `O(1)`, because the method takes the same amount of time to execute regardless of the number passed in. This is because the number is being used as a value and not a number of operations or size of input.

#### Example 2: 
Here `n` is used as the size of the method's input

```
public static void singleForLoop(int n){
    for(int i = 0; i < n; i++){
        System.out.println(String.format("Square of %s is %s", i, Math.pow(i,2.0)));
    }
}
```

Note that we are simply printing to screen, but the number of operations obviously changes with the size of the input.
The complexity of this operation is `O(n)` since the number of operations change linearly with the size of input.
If we were to use a while loop declaring an `int i = 0` and `i < n` as the conditional instead the runtime complexity would be the same since a while loop is conceptually similar to a for-loop. If the value of `n` doubles the code will take twice as long.

#### example 3: 
conditionals

```
public static void ifStatement(int n){
    if(n % 2 == 0){
        System.out.println("even");
    } else {
        for(int i = 0; i < n; i++){
            System.out.println("printing: " + i);
        }
    }
}
```
Since Complexity analysis is based on the worst case scenario, the complexity of this operation is `O(n)`, the worst case being that the input is odd and we enter the for-loop. It is true that if the input is even the method will run in constant time but that is not what the overall runtime for the method is.

#### Example 4: 
nested loops

```
public static void nestedForLoop(int n){
    for(int i = 0; i < n; i++;) {
        for(int j = 0; j < n; j++){
            System.out.println(String.format("product of %s and %s is %s, i, j, i * j));
        }
    }
}
```
Here we have two loops that iterate from 0 to n creating a nested loop. If a single loop is `O(n)`, a nested loop is be composed of two of these therefore containing a higher complexity. The complexity of this operation is `O(n2)`. As `n` changes, the number of operations change quadratically.

This means that for every iteration of the outer loop the inner loop iterates `n` times so that the statement is called `n*n` times, which equals to `n2`.

There are other runtimes complexities but this is a good place to stop. For now if you understand up to this point you are in a good place.




