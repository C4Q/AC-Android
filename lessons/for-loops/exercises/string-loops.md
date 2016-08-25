## Exercise



1) The following function takes a String as a parameter, and is supposed to return the number of vowels (a, e, i, o, u) within the string. It's implementation is missing some details. Fix its logic using a for loop.

```java
public int countVowels(String input){
  String vowels = "aeiouAEIOU";
  int vowelCount = 0;


  return vowelCount;
}
```

2) Visit the following link: [ASCII Code for Letters](http://sticksandstones.kstrom.com/appen.html)

The method below takes an ASCII value and returns a char variable with the letter equivalent of the given ASCII code.

```java
public char getChar(int asciiCode){
    return (char) asciiCode;
}
//ex: getChar(97) -> 'a'
```

Use a for loop to create and print a String containing every uppercase letter of the English alphabet. Do not manually type the letters.



3) The method below takes a char as an input and returns an int variable with the ASCII code value of the input letter.


```java
public int getAsciiValue(char c){
  return (int) c;
}
//ex: getAsciiValue('a') -> 97
```

Write a Java program that takes a String from a user,and returns the sum of the ASCII value of each character. For example, calling getAsciiSum("Java") should return 386.
