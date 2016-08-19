### In-class exercises

### Q1.

##### Create two classes: BankAccount and Patron
- A BankAccount has a balance
- A Patron has a name, an account, and his/her “pocket”.

##### Create a program that creates objects of these types and defines some interactions. For now, our constraints will be:
- A patron can only interact with one account ( 1 <=> 1   )
- An account can interact with many patrons   ( 1 <=> many)
- We will deal with dollars only, no cents

##### Some suggested “interactions”:
- An account should allow withdrawals and deposits
- A patron can get from and put money in the account
- Both should be able to show their current balance

##### Extra Credit:
- Make it so a patron can interact with multiple accounts
- Prevent the possibility of a Patron performing an over-withdrawal
- Prevent the possibility of depositing more than you currently have in your pocket

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

Add a readList method to `ListOfNumbers.java`. This method should read in int values from a file, print each value, and append them to the end of the vector. You should catch all appropriate errors. You will also need a text file containing numbers to read in.

```java
public class ListOfNumbers {
    private List<Integer> list;
    private static final int SIZE = 10;
 
    public ListOfNumbers () {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++)
            list.add(new Integer(i));
    }
    public void writeList() {
        PrintWriter out = null;
 
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("OutFile.txt"));
         
            for (int i = 0; i < SIZE; i++)
                out.println("Value at: " + i + " = " + list.get(i));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
}
```

### Q6.

Modify the following `cat` method so that it will compile.

```java
public static void cat(File file) {
    RandomAccessFile input = null;
    String line = null;

    try {
        input = new RandomAccessFile(file, "r");
        while ((line = input.readLine()) != null) {
            System.out.println(line);
        }
        return;
    } finally {
        if (input != null) {
            input.close();
        }
    }
}
```

### Q7.

Write a class that uses a Scanner object to count the number of individual words in [my_text_file.txt](my_text_file.txt) and prints the result.
