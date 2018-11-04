# DS&A - Recursion

## Objectives
* Identify recursion as a solution to problems
* Identify when recursion is and is not appropriate

## Resources
* https://www.youtube.com/watch?v=i-eQjzQtNU4

# Lecture

![recusion](http://www.eccentricclub.cz/wp-content/uploads/2015/03/mirror.jpg)

**Recursion** is when a method calls itself. You need two things to avoid a situation where the method keeps calling itself forever (or until you run out of allocated memory and get a `StackOverflowException`):
1. A _base case_, which returns a value without any further recursive calls (you can have more than one base case sometimes)
1. A _reduction step_, which changes the input before making the next recursive call, so as to make progress toward the base case

Each time a recursive function calls itself, some space in the program's stack in memory is allocated for that function to store its local variables while it runs. 

A program that has infinite recursive function calls (no base) will eventually crash with a StackOverFlow exception, because there is no more space on the stack left for the next function call.

#### Using Recursion vs. Iteration

Here is an example of a problem that can be solved iteratively, and an alternative recursive solution.

> `sum(int n)` is a function that returns the sum of the `n` integers

```
public int sum(int n){
  int result = 0;
  for (int i = 0; i < n; i++) {
    result += i;
  }
  return result;
}
```

Now inspect the same function written recursively.

```
public int sum(int n){
    if (n == 0) {
      return 0;
    }
    return n + sum(n-1);
}
```

#### Factorial Example

The factorial of a non-negative integer n, denoted by n!, is the product of all positive integers less than or equal to n. For example,

> 5! = 5 * 4 * 3 * 2 * 1 = 120

As a function:
> factorial(5) = 120

The solution of (5!) can be computed easily if we already know (4!).
This is because:
> 4! = 4 * 3 * 2 * 1 = 24;
> 5! = 5 * 4! = 5 * 24 = 120

And (4!) factorial can be computed easily if we already know (3!).

Why? The factorial problem can be solved easily by solving smaller sub-problems of the same type until we get to the smallest problem `factorial(1) = 1`. This strategy of solving a problem by solving similar smaller problems is called `recursion`. 

Here is a recursive solution to the factorial problem.
```java
// factorial(n), a.k.a. n!
public static int factorial(int n) {
    if (n <= 1) {
        // this is the base case, when n is 1 (or less than 1)
        return 1;
    } else {
        // otherwise, reduce the input by 1 and make a recursive call
        return n * factorial(n - 1);
    }
}
```
Sketch of the recursive calls on the memory stack for `factorial(4)`:
![factorial](https://github.com/joinpursuit/Pursuit-Core-Android/blob/v2/DSA/recursion/images/factorial.png)

### Reversing a string

Write a recursive function called `reverse` that accepts a string and returns a reversed string. For example:
  - `reverse("abc")` -> "cba"
  - `reverse("ab")` -> "ba"
  - `reverse("a")` -> "a"
  - `reverse("")` -> ""

Sample solution:
```java
public static String reverse(String str) {
    if (str.length() <= 1) {
        return str; // base case
    } else {
        char lastLetter = str.charAt(str.length() - 1);
        // reduction step: reduce the size of the input for the next call
        String restOfString = str.substring(0, str.length() - 1);
        return lastLetter + reverse(restOfString);
    }
}
```
Sketch of the recursive calls on the stack for `reverse("abcd")`:
![reverse](https://github.com/joinpursuit/Pursuit-Core-Android/blob/v2/DSA/recursion/images/reverse.png)

### The Fibonacci sequence

The fibonacci sequence is 1, 1, 2, 3, 5, 8, etc. where the sequence starts with two 1s, then each following entry is the sum of the previous two entries. 

Write a recursive function called `fib` that accepts a number `n`, greater than zero, and returns the Nth fibonacci number. For example:

  - `fib(1)` -> 1
  - `fib(2)` -> 1
  - `fib(3)` -> 2
  - `fib(4)` -> 3
  - `fib(5)` -> 5
  - `fib(-1)` and `fib(0)` -> 1 (input shoud be >= 1)
  
Sample solution:
```java
public static int fib(int n) {
    if (n <= 0) {
        return 0; // base case A
    } else if (n <= 2) {
        return 1; // base case B
    } else {
        return fib(n - 1) + fib(n - 2); // reduction step
    }
}
```

Sketch of the recursive calls on the stack for `fib(4)`:
![fibonacci](https://github.com/joinpursuit/Pursuit-Core-Android/blob/v2/DSA/recursion/images/fibonacci.png)

### Palindrome

A _palindrome_ is a string that is spelled the same backwards and forwards. Put another way, a palindrome is a string where the first letter is equal to the last letter, and the second letter is equal to the second to last letter and so on and so forth. An empty string is considered a palindrome. A one letter string is considered a palindrome.


Write a function called `isPalindrome` that accepts a string and returns `true` if the string is a palindrome, and returns `false` if the string is not. For example:
  - `isPalindrome("")` -> true
  - `isPalindrome("a")` -> true
  - `isPalindrome("ab")` -> false
  - `isPalindrome("abba")` -> true
  - `isPalindrome("catdog")` -> false
  - `isPalindrome("tacocat")` -> true


Sample solution...
  
```java
public static boolean isPalindrome(String str) {
    if (str.length() <= 1) {
        return true; // base case: empty and single-character strings
    } else {
        char first = str.charAt(0)
        char last = str.charAt(str.length() - 1);
        if (first != last) {
            return false; // cannot be a palindrome if these don't match
        } else {
            // reduction step: continue w/ middle of str excl. first and last chars
            String middle = str.substring(1, str.length() - 1);
            return isPalindrome(middle);
        }
    }
}
```

Sketch of the recursive calls on the stack for `isPalindrome("civic")`:
![palindrome](https://github.com/joinpursuit/Pursuit-Core-Android/blob/v2/DSA/recursion/images/palindrome.png)

## Exercises

Using whiteboard tablets and dry-erase markers, work with a partner to discuss strategies for solving the following questions on CodingBat, then complete them on your own:

1. [Factorial](https://codingbat.com/prob/p154669)
1. [Bunny Ears](https://codingbat.com/prob/p183649)
1. [Fibonacci](https://codingbat.com/prob/p120015)
1. [Bunny Ears 2](https://codingbat.com/prob/p107330)
1. [Triangle](https://codingbat.com/prob/p194781)
