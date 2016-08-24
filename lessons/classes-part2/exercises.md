### In-class exercises

### Q1.

##### Create two classes: BankAccount and Patron
- A BankAccount has a balance.
- A Patron has a name, an account, and his/her “pocket”.

##### Create a program that creates objects of these types and defines some interactions. For now, our constraints will be:
- A patron can only interact with one account ( 1 <=> 1 ).
- An account can interact with many patrons ( 1 <=> many ).
- We will deal with dollars only, no cents.

##### Some suggested “interactions”:
- An account should allow withdrawals and deposits.
- A patron can get from and put money in the account.
- Both should be able to show their current balance.

##### Extra credit:
- Make it so a patron can interact with multiple accounts.
- Prevent the possibility of a Patron performing an over-withdrawal.
- Prevent the possibility of depositing more than the patron currently has in their pocket.

### Q2.
Is the following code legal?

```java
try {
    
} finally {
    
}
```

### Q3.

What exception types can be caught by the following handler?

```java
catch (Exception e) {
     
}
```

What is wrong with using this type of exception handler?

### Q4.

Is there anything wrong with the following exception handler as written? Will this code compile?

```java
try {

} catch (Exception e) {
    
} catch (ArithmeticException a) {
    
}
```

### Q5.

Who is more verbose: Dickens or Melville? Fork the [VerbosityCalculator](https://github.com/accesscode-2-1/VerbosityCalculator) repo and follow the instructions in the repo to complete the exercise.

You completed VerbosityCalculator exercise will be submitted with this week's HW, due 9/03.
