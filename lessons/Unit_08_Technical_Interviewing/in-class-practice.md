# Technical Interview Practice Problems

### Instructions
We'll break out into randomly selected pairs.
Take turns interviewing each other.
The interviewer should view the provided solution code and offer hints to the interviewee if they're off track.
But please don't offer hints too quickly - it's important for us all to practice coping with the tense feeling of not knowing what to do next.
Only give hints if someone has been stuck for more than a couple minutes.

The interviewer should also consider the [rubric](https://docs.google.com/document/d/1LfwKyCY2K6VI7fuiFyz7FIDAJdDtuBuYTGlYZtzl_q0/edit?usp=sharing)
and use it to guide the feedback you provide to the interviewee.
Both parties need to remember that feedback is necessary for growth, and it's NOT personal.
Giving the feedback "good job" won't actually help anyone get a job!

### Problems
Spend a maximum of 30 minutes on each problem.
Some may be much quicker, some may be ony partly finished in that time.
This means you will not do _all_ of these problems in one session.
That's fine!
The goal is to get comfortable solving problems out loud, not to get through problems as fast as you can.
In fact, for this type of practice slower is probably better!

1. **Lucky Sum:** Given 3 int values, a b c, return their sum. However, if one of the values is 13 then it does not count towards the sum and values to its right do not count. So for example, if b is 13, then both b and c do not count.
  - `luckySum(1, 2, 3)` -> 6
  - `luckySum(1, 2, 13)` -> 3
  - `luckySum(1, 13, 3)` -> 1

	<details><summary>A few possible solutions...</summary>

	```java
	public int luckySum(int a, int b, int c) {
		if (a == 13) {
			return 0;
		} else if (b == 13) {
			return a;
		} else if (c == 13) {
			return a + b;
		} else {
			return a + b + c;
		}
	}

    // A loopy version...
	public int luckySum2(int a, int b, int c) {
        int sum = 0;
        for (int x : new int[]{a, b, c}) {
            if (x == 13) break;
            sum += x;
        }
        return sum;
    }

    // This is terribly hard to read, but one-liners are fun!
	public int luckySum3(int a, int b, int c) {
        return (a == 13) ? 0 : ((b == 13) ? a : (c == 13) ? a + b : a + b + c);
	}
	```
    </details>

2. **Repeat Front:** Given a string and an int n, return a string made of the first n characters of the string, followed by the first n-1 characters of the string, and so on. You may assume that n is between 0 and the length of the string, inclusive (i.e. n >= 0 and n <= str.length()).
  - `repeatFront("Chocolate", 4)` -> "ChocChoChC"
  - `repeatFront("Chocolate", 3)` -> "ChoChC"
  - `repeatFront("Ice Cream", 2)` -> "IcI"

	<details><summary>Two possible solutions...</summary>

	```java
    // StringBuilder append version...
	public String repeatFront(String str, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = n; i >= 1; i--) {
			sb.append(str.substring(0, i));
		}
		return sb.toString();
	}

    // String concatenation version (less memory efficient)...
	public String repeatFront2(String str, int n) {
        String output = "";
        for (int i = n; i >= 1; i--) {
            output += str.substring(0, i);
        }
        return output;
	}
	```
    </details>

3. **Sum Digits:** Given a non-negative int n, return the sum of its digits _**recursively**_ (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).

  - `sumDigits(126)` -> 9
  - `sumDigits(49)` -> 13
  - `sumDigits(12)` -> 3

	<details><summary>Two possible solutions...</summary>

	```java
	public int sumDigits(int n) {
		int rightmostDigit = n % 10;
		int leftDigits = n / 10;
		if (leftDigits == 0) {
			return rightmostDigit; // base case
		} else {
			return rightmostDigit + sumDigits(leftDigits);
		}
	}

    // And an obnoxious one-line version...
	public int sumDigits2(int n) {
        return (n / 10 == 0) ? n % 10 : n % 10 + sumDigits(n / 10);
	}
	```
    </details>

4. **Big Diff:** Given an array length 1 or more of ints, return the difference between the largest and smallest values in the array. Note: the built-in Math.min(v1, v2) and Math.max(v1, v2) methods return the smaller or larger of two values.
  - `bigDiff([10, 3, 5, 6])` -> 7
  - `bigDiff([7, 2, 10, 9])` -> 8
  - `bigDiff([2, 10, 7, 2])` -> 8

	<details><summary>Two possible solutions...</summary>

	```java
    public int bigDiff(int[] nums) {
        int largest = nums[0];
        int smallest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            largest = Math.max(largest, nums[i]);
            smallest = Math.min(smallest, nums[i]);
        }
        return largest - smallest;
    }

    // Alternate version...
	public int bigDiff2(int[] nums) {
		int largest = Integer.MIN_VALUE;
		int smallest = Integer.MAX_VALUE;
		for (int num : nums) {
			largest = Math.max(largest, num);
			smallest = Math.min(smallest, num);
		}
		return largest - smallest;
	}

	```
    </details>
    
5. We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows.
  - `triangle(0)` -> 0
  - `triangle(1)` -> 1
  - `triangle(2)` -> 3

	<details><summary>Possible solution(s)...</summary>

    ```java
    public int triangle(int rows) {
        if (rows <= 1) {
            return rows; // base case
        } else {
            // get the # of blocks before the current row with a recursive call
            // then add "rows" b/c that's how many blocks are in the current row
            return triangle(rows - 1) + rows;
        }
    }

    public int triangle2(int rows) {
        return (rows <= 1) ? rows : rows + triangle(rows - 1);
    }

    // Iterative (non-recursive) version
    public int triangle3(int rows) {
        int blocks = 0;
        while (rows > 0) {
            blocks += rows;
            rows--;
        }
        return blocks;
    }
    ```
  </details>

6. Modify and return the given map as follows: if the key "a" has a value, set the key "b" to have that value, and set the key "a" to have the value "". Basically "b" is a bully, taking the value of "a". *(hint: https://docs.oracle.com/javase/7/docs/api/java/util/Map.html#method_summary)*
  - `mapBully({"b": "dirt", "a": "candy"})` -> `{"b": "candy", "a": ""}`
  - `mapBully({"a": "candy"})` -> `{"b": "candy", "a": ""}`
  - `mapBully({"b": "carrot", "c": "meh", "a": "candy"})` -> `{"b": "candy", "c": "meh", "a": ""}`

	<details><summary>Possible solution(s)...</summary>

	```java
	public Map<String, String> mapBully(Map<String, String> map) {
		if (map.containsKey("a")) {
			map.put("b", map.get("a")); // put a's value in b
			map.put("a", "");			// put "" in a
		}
		return map;
	}
	```
  </details>

7. We have an array of heights, representing the altitude along a walking trail. Given start/end indexes into the array, return the sum of the changes for a walk beginning at the start index and ending at the end index. For example, with the heights {5, 3, 6, 7, 2} and start=2, end=4 yields a sum of 1 + 5 = 6. The start end end index will both be valid indexes into the array with start <= end.
  - `sumHeights([5, 3, 6, 7, 2], 2, 4)` -> 6
  - `sumHeights([5, 3, 6, 7, 2], 0, 1)` -> 2
  - `sumHeights([5, 3, 6, 7, 2], 0, 4)` -> 11

	<details><summary>Possible solution(s)...</summary>

	```java
	public int sumHeights(int[] heights, int start, int end) {
		int sum = 0;
		for (int i = start + 1; i <= end; i++) {
			// compare each height to the previous height
			// use abs() because we only care about magnitude, not direction
			sum += Math.abs(heights[i] - heights[i - 1]);
		}
		return sum;
	}
	```
  </details>

8. We'll say that a positive int divides itself if every digit in the number divides into the number evenly. So for example 128 divides itself since 1, 2, and 8 all divide into 128 evenly. We'll say that 0 does not divide into anything evenly, so no number with a 0 digit divides itself. Note: use % to get the rightmost digit, and / to discard the rightmost digit.
  - `dividesSelf(128)` -> true
  - `dividesSelf(12)` -> true
  - `dividesSelf(120)` -> false

	<details><summary>Possible solution(s)...</summary>

	```java
	public boolean dividesSelf(int n) {
		int temp = n;
		while (temp > 0) {
			int rightmostDigit = temp % 10;
			if (rightmostDigit == 0 || n % rightmostDigit != 0) {
				// if the rightmost digit is zero,
				// or if the rightmost digit doesn't divide evenly into n
				return false;
			}
			// reduce the temp variable for the next loop iteration
			temp /= 10;
		}
		// if we made it here w/o returning false, then the result is true
		return true;
	}
	```
  </details>
  
9. Write a function to reverse a string. Do not use `StringBuilder`'s `reverse()` method.

   <details><summary>Possible solution(s)...</summary>

	    ```java
	    public String reverse(String str) {

		char[] strChars = str.toCharArray();

		int startIndex = 0;
		int endIndex = strChars.length - 1;

		while (startIndex < endIndex) {
		    // swap characters
		    char temp = strChars[startIndex];
		    strChars[startIndex] = strChars[endIndex];
		    strChars[endIndex] = temp;

		    // move towards middle
		    startIndex++;
		    endIndex--;
		}

		return new String(strChars);
	    }
	    ```
   </details>

10. Write a function that takes a string and reverses the order of words but not the characters within the words. E.g. "The eagle has landed" becomes "landed has eagle The".

    <details><summary>Possible solution(s)...</summary>

    ```java
    public String reverseWords(String message) {

        char[] messageChars = message.toCharArray();

        // first we reverse all the characters in the entire messageChars array
        reverseCharacters(messageChars, 0, messageChars.length - 1);
        // this gives us the right word order
        // but with each word backwards

        // now we'll make the words forward again
        // by reversing each word's characters

        // we hold the index of the /start/ of the current word
        // as we look for the /end/ of the current word
        int currentWordStartIndex = 0;
        for (int i = 0; i <= messageChars.length; i++) {

            // found the end of the current word!
            if (i == messageChars.length || messageChars[i] == ' ') {

                // if we haven't exhausted the string our
                // next word's start is one character ahead
                reverseCharacters(messageChars, currentWordStartIndex, i - 1);
                currentWordStartIndex = i + 1;
            }
        }

        return new String(messageChars);
    }

    public void reverseCharacters(char[] messageChars, int startIndex, int endIndex) {

        // walk towards the middle, from both sides
        while (startIndex < endIndex) {

            // swap the front char and back char
            char temp = messageChars[startIndex];
            messageChars[startIndex] = messageChars[endIndex];
            messageChars[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
    ```
    </details>
