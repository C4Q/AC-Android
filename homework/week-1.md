# HW Week 1

## Exercises

<!-- @acxbank add-function -->
### Q1. add-function

Write a method named `add` that takes in two numbers as arguments. The function should return the sum of the two numbers.

Examples:
```java
add(1,2);  // returns 3
add(10,12);  // returns 22
```
<!-- end @acxbank -->

<!-- @acxbank age-calculator -->
### Q2. age-calculator

Write a method named `calculateAge` that takes two arguments: birth year and current year. The method should then calculate the two possible ages based on that year, and return the result in the following format: (replacing 'NN' with the possible years) : "You are either NN or NN."

Examples:

```java
calculateAge(1987, 2016);  // returns 'You are either 28 or 29.'
```
<!-- end @acxbank -->

<!-- @acxbank exes-and-ohs -->
### Q3. exes-and-ohs

Check to see if a string has the same amount of 'x's and 'o's. The method must return a boolean and be case insensitive. The string can contains any char.

Example outputs:
```java
XO("ooxx")    // returns true
XO("xooxx")   // returns false
XO("ooxXm")   // returns true
XO("zpzpzpp") // returns true because zero 'x's and 'o's are present
XO("zzoo")    // returns false
```
<!-- end @acxbank -->

<!-- @acxbank endsly -->
### Q4. endsly

Write a Java method that takes a string as a parameter and returns true if it ends in "ly".
<!-- end @acxbank -->

<!-- @acxbank chessboard -->
### Q5. chessboard

Write a program that creates a single string that represents an 8×8 grid, using newline characters to separate lines. At each position of the grid there is either a space or a “#” character. The characters should form a chess board. Printing the string should show something like this:

    ```
     # # # #
    # # # #
     # # # #
    # # # #
     # # # #
    # # # #
     # # # #
    # # # #
    ```

When you have a program that generates this pattern, define a variable ```size = 8``` and change the program so that it works for any size, outputting a grid of the given width and height.
<!-- end @acxbank -->

<!-- @acxbank scanner-hungry-hippos -->
### Q6. scanner-hungry-hippos

Hippos only like to eat foods that begin with the letter 'h'. In an effort to reduce food waste, the local zoo has hired you to write a Java program that can predict whether or not the hippos will eat a given food.

While running, your program should prompt the user to enter a food. If the food is one that hippos like to eat, the program should print "Yum!" -- otherwise, it should print "Yuck!".

For example:
```
Enter a food:
hot dogs
Yum!
Enter a food:
HAMBURGERS
Yum!
Enter a food:
frozen yogurt
Yuck!
```
<!-- end @acxbank -->

<!-- @acxbank string-elide -->
### Q7. string-elide

Write a method that takes a string parameter.  For longer strings, the method returns a new string constructed out of the first three letters of the argument, followed by three periods (`"..."`), followed by the last letter of the argument.

However, if the resulting string is not shorter than the argument, the method should return the argument instead.

For example,

```java
elide("Hello!")               // returns "Hello!"
elide("Hello, world!")        // returns "Hel...!"
elide("That's not my name.")  // returns "Tha...."
```

Remember that `String.substring()` can take two arguments: the start index and the end index.
<!-- end @acxbank -->

<!-- @acxbank triangle -->
### Q8. triangle

Write a loop that will print the following triangle to the console:

```
#
##
###
####
#####
######
#######
```

<!-- end @acxbank -->

<!-- @acxbank count-code -->
### Q9. count-code

Write a Java method that takes a string parameter and returns the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.

For example:

```
countCode("aaacodebbb") → 1
countCode("codexxcode") → 2
countCode("cozexxcope") → 2
```
<!-- end @acxbank -->

<!-- @acxbank count-the-vowels -->
### Q10. count-the-vowels

Write a function that accepts a string as a parameter and counts the number of vowels within the string (vowels include a, e, i, o , u - don't count 'y'). The function should return the number of vowels in the string.

Example output:
```javascript
vowelCount('test string'); // returns 2
vowelCount('longer string with more vowels'); // returns 8
```
<!-- end @acxbank -->

<!-- @acxbank cut-a-string-at-character -->
### Q11. cut-a-string-at-character

Write a function to return a part of string after a specified character. The function should take two arguments, the first being the string, and the second being the character. The function should return only the part of the string that comes AFTER the specified character. In other words, the function should chop the string into two parts and return only the part that comes after the specified character.

Examples:
```javascript
subStrAfterChars('this is a test string', 'a') // returns " test string"
subStrAfterChars('this is another test', 'o') // returns "ther test"
```
<!-- end @acxbank -->

<!-- @acxbank twelve-days -->
### Q12. twelve-days

Print "The Twelve Days of Christmas", an English carol with a lot of repetition!

You can find the structure of the lyrics here: (The Twelve Days of Christmas Lyrics)[http://en.wikipedia.org/wiki/The_Twelve_Days_of_Christmas_%28song%29#Lyrics].

Use variables to store bits of repeated data and print the full lyrics.
<!-- end @acxbank -->

<!-- @acxbank scanner-ice-cream-start-up -->
### Q13. scanner-ice-cream-start-up

Your friends just came up with a great new start-up idea: it's like Uber for ice cream! They've asked you to write a prototype Java program that will accept ice cream orders for delivery.  The program should use a Scanner object to read user input and should:

1. Greet the user and ask them for a **name**.
2. Ask the user what **flavor** of ice cream they would like.
3. One-by-one, offer three **toppings** of your choice which the user will select by inputting 'yes'.
4. Calculate the total **price** of the order: the base ice cream costs $2.33 and each topping is an additional $0.33 cents.
5. Calculate a **delivery wait time** estimate, which should be a random number of minutes between 1 and 60.
6. Print an **order confirmation** to the console that contains the following details: the user's name, ice cream flavor, number of toppings, total price, and delivery wait time.

Here is an example interaction:
```
Welcome to our ice cream service! What's your name?
> Jim
Okay Jim, which flavor of ice cream would you like?
> vanilla
Would you like chocolate chips?
> yes
Would you like bananas?
> No
Would you like gummy bears?
> YES
Okay! A vanilla ice cream with 2 toppings. Your total is $2.99 and your ice cream will arrive in 12 minutes.
```
<!-- end @acxbank -->


## Homework submission

You can use [repl.it](https://repl.it/languages/java) to complete and submit the exercises.

1. If you haven't already, create an account on repl.it ***using your github account***.

2. You may complete all of the exercises over the course of the week in a single session named "HW Week 1 - *(Your name)*". Remember to save your work as you go!

3. For each exercise, place a comment above the exercise with the question number and name, for example: `// Q1. letter-to-yourself`. Please make sure your exercises are in the correct order from top to bottom before submitting.

4. When you have completed all of the exercises, click the "Share" button then select Github to share the exercises to a Gist. 

5. Copy the Gist URL and [submit it using this form](//TODO add hw submission form link) by ***Saturday 8/21 at 8pm***.
