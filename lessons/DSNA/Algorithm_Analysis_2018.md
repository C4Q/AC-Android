# Algorithm analysis:

We measure both time and space complexity. It's important to understand that these are two different units of measurement. 

In runtime:
* N is the time it takes for an algorithm to complete as the size of input grows.
* There are various names for certain runtimes. Below are the most commonly talked about runtime analysis terms, they are listed in ascending order in terms of time it takes for complete program excecution. 
  * O(1): `"Constant"`: A static value or single operation.
  * O(log n): `"Log N"`: An algorithm that halves the time it takes for a full operation to complete as its input grows.
  * O(n): `"Linear"`: The time it takes for an operation to complete will grow proportionally to the amount of computation cycles it needs to complete. 
  * O(n log n) `n log n`: The time it takes to complete a full operation is halved and then multiplied by the number of operations it needs to complete.

There are others like O(n!) a `"Factorial"` runtime in which we say an algorithm exhibits "exponential growth". This is good for sales but not runtime of an algorithm. 

When measuring the runtime of an algorithm, each operation in the algorithm will have its own runtime, the runtime of the entire algorithm will be simplified taking into account each of the algorithms operations. When we simplify a runtime we always follow the slowest operation which is the one that affects runtime the most. 

For example when you're sorting through a thousand element array and your algorithm performs faster when it is partially sorted (log n) but slower the less it is sorted (n) then the final runtime is the worst case scenario: O(n).

We must also keep in mind the fact that there is a difference between Time and Space complexity. Time is the number of operations your algorithm performs where as space is the amount of memory an algorithm might take up as it computes its calculations. We use the same terms but by specifying a space complexity we are then speaking of resources available to the computer.

For more information on runtimes and what they mean click [here](https://stackoverflow.com/questions/2307283/what-does-olog-n-mean-exactly).

### Case study: Fibbonacci 

 A great example of runtime analysis is working through the different ways to calculate the [fibbonacci sequence](https://en.wikipedia.org/wiki/Fibonacci_number) up to input n. 
 
This [article](https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/) demonstrates different ways that the fibbonacci sequence can be calculated using Java. Notice how we can calculate the runtime of each approach and how each approach can be optimized using different techniques that each either affect the space or runtime complexity of the algorithm. 

Feel free to read through and understand each approach. We will go through these in class.

### Case study: Data Structures

Data structures are a way to work with data in a computer. You can think of a structure as a set of algorithms that collectively give the strucuture its attributes. All data structures have a common set of operations that might have different runtimes based on the attributes of their parent structure. 

For example: Common behaviors among structures is `Access`, `Search`, `Insertion`, and `Deletion`

These operations might have different runtimes based on their parent structures attributes. 

It's important to get a feel for how these things are measured, a good reasource where we can compare and contrast the difference between algorithms, data structures and their runtime analysis is http://bigocheatsheet.com/ 

That's a link that's been shared a lot but we will work through it during class.

There are [many](https://en.wikipedia.org/wiki/List_of_data_structures) data structures, for a list of advantages and disadvantages of some of the most common ones click [here](http://www.idevelopment.info/data/Programming/data_structures/overview/Data_Structures_Algorithms_Introduction.shtml)

### Resources:

The structures talked about in the Big O cheatsheet link are important to understand, at least as much as we can. Although we can gain a lot from reading the wiki pages linked there, we can also visualize these structures and interactively study them using: https://visualgo.net/en

Further reading: This is  an excellent [article](http://discrete.gr/complexity/) on algorithm analysis. I `highly` suggest you take the time to read this. 
