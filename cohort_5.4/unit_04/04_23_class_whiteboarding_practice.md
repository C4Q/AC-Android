# Class Whiteboarding Practice

## Objectives
* Fellows will review the process of breaking down a problem into smaller pieces
* Fellows will practice communication their thought-process with interviewers

## Resources
* [Whiteboarding PREP](https://medium.freecodecamp.org/before-you-code-remember-to-prep-for-your-coding-interview-2ccfb58147db)

# Lecture

Whiteboarding... is a thing. Many companies hate them - some hiring managers love them. Max Howell, the creator of the Mac library installer "Homebrew", has some NSFW thoughts on the issue (Google it).

However, whiteboarding method functions forces a developer to consider how best to approach a problem before ever writing a single line of code. 

During a technical interview, outside of the coding challenge (completing an Android project on your own), you may be asked to either solve a problem on a whiteboard during an on-site, or share your screen remotely with an interviewer to solve a coding problem together. The latter tends to be the more frequent technique as of 2019.

Whenever approaching a new problem, it's good to consider these steps:

1. What kinds of parameters wil this method use to accept arguments?
1. What value and type is this method expected to return?
1. Identify useful variables which might be useful for storing code, or for handling edge cases
1. Write pseudocode, before writing any real code - to talk through your thought process, and explore possible solutions with your interviewer

Today, we will pick four fellows for four half-hour long whiteboarding sessions. We will randomly select four of the following questions:

### subArray

Given start and end numbers, return a new array containing the sequence of integers from start up to but not including end, so start=5 and end=10 yields {5, 6, 7, 8, 9}. The end number will be greater or equal to the start number. Note that a length-0 array is valid.

```
subArray(5, 10) → [5, 6, 7, 8, 9]
subArray(11, 18) → [11, 12, 13, 14, 15, 16, 17]
subArray(1, 3) → [1, 2]
```

### zipperString

Given two strings, a and b, create a bigger string made of the first char of a, the first char of b, the second char of a, the second char of b, and so on. Any leftover chars go at the end of the result.

```
zipperString("abc", "xyz") → "axbycz"
zipperString("Hi", "There") → "HTihere"
zipperString("xxxx", "There") → "xTxhxexre"
```

### bobThere

Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.

```
bobThere("abcbob") → true
bobThere("b9b") → true
bobThere("bac") → false
```

### repeatSeparator 

Given two strings, word and a separator sep, return a big string made of count occurrences of the word, separated by the separator string.

```
repeatSeparator("Word", "X", 3) → "WordXWordXWord"
repeatSeparator("This", "And", 2) → "ThisAndThis"
repeatSeparator("This", "And", 1) → "This"
```

### sameStarChar

Returns true if for every '*' (star) in the string, if there are chars both immediately before and after the star, they are the same.

```
sameStarChar("xy*yzz") → true
sameStarChar("xy*zzz") → false
sameStarChar("*xa*az") → true
```
