- author: abass@c4q.nyc
- language: java
- topics: conditional
- difficulty: 1
- format: coding
- attribution: original

### Question
1) Create variables for each of the following:
 - username
 - password

 2) Use the scanner object to prompt the user to enter a new username and new password Your program should accept only passwords that have both alphabetical and numerical characters.

 3) With a partner, test that the code works for the correct username and password by displaying a different message for successful and unsuccessful login attempts.

 3) Modify your program so that it has two additional variables: security question, and security answer. The program should be modified so that when you enter an incorrect password, the program prompts with the security question.

 ## Additional challenge: try modifying your logic to ensure that the security question contains a question mark, and that the security answer is not case-sensitive?


 Example:
 Security Question: "What is the make and model of your first car?"
 Answer: "Mercedes Benz"
 Answer2: "mercedes benz"


## Resources: [Scanner](https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html)
[String API](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html)

```java
  
  public static String readInput(){
 	   Scanner scanner = new Scanner(System.in);
    	String out = "";
     return scanner.next();
  }
```
