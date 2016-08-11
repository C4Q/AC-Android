## Command-line Java

The command line is an environment that expects you to type commands, and that executes these one by one and prints out the result.  For example, the `Terminal` app on OSX.

Terminal shows you a `$` prompt and waits for your commands.

* prompt = An indication that the computer is waiting for you to type something.

To use your Java7 JDK:

```
export PATH=/Library/Java/JavaVirtualMachines/jdk1.7.0_75.jdk/Contents/Home/bin:$PATH
```
    
This tells your command line to find the `java` and related programs in your JDK.

```
$ cd
$ mkdir java
$ cd java
```

Open `TextEdit`.  Select `Format > Make Plain Text`. _(Important!)_  Enter some Java code.

```
public class Hello {
    public static void main(String[] argv) {
        System.out.println("Hello, world!");
    }
}
```
    
Save the file as `Hello.java` in your java directory.  _(Important! The file name **must** match the class name in the program.)_ Back in the terminal:

```
$ ls
Hello.java
$ javac Hello.java
$ ls
Hello.class    Hello.java
```

You should see a new file named `Hello.class`.  That contains the Java bytecode.

If you're curious, you can use `javap -c` to disassemble the bytecode and take a peek at the instructions:

```
$ javap -c Hello.class
Compiled from "Hello.java"
public class Hello {
  public Hello();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #3                  // String Hello, world!
       5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return
}
```

Finally, you can use `java` to execute your program:

```
$ java Hello
Hello, world!
```
