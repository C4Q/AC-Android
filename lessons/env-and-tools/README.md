- title: Environment Setup
- tags: setup

#Standards:

#Objectives
* Install Intelli J
* Install Android Studio
* Run Java programs on repl.it
* Setup Github account
* The Command Line
* Setup StackOverflow Account
* Setup Slack Account
* The App Design Process
* Intro to Pair Programming

#Resources
* [Java coding in browser](https://repl.it/languages/java)
* [Android Studio IDE](https://developer.android.com/studio/install.html)
* [Udacity Android Class](https://www.udacity.com/course/developing-android-apps--ud853)
* [Google Android Tutorials](https://developer.android.com/training/basics/firstapp/index.html)
* [Android Source Code](https://source.android.com/)
* [Github](https://www.github.com)
* [Git Manual](https://git-scm.com/docs/user-manual.html)
* [Git Install](Git.md)
* [StackOverflow] (https://stackoverflow.com/)
* [Slack] (https://slack.com/downloads)
* [IntelliJ Install](IntelliJ.md)

# Lecture

## IDE setup
* Install Intelli J [Tutorial](IntelliJ.md)
* Install Android Studio IDE

Navigate to repl.it and run your first Java program. By convention, the first
program outputs Hello World! on the screen.

```java
class Main {
  public static void main(String[] args) {
    System.out.println("hello world");
  }
}
```

Programming languages are very nuanced. All characters in the program are
passed through a compiler, converted into machine code, and then executed by
the computer. To add human readable text, we can add comments to the code.

```java
class Main { // Define the class name
  public static void main(String[] args) { // The start of all Java programs
    System.out.println("hello world"); // Writes hello world to System.out
  }
}
```

It is always a good idea to add comments to code that is unclear. And in the
beginning of your programming career, all code will look this way. However, as
you master a language, you should strive to write less comments and code that
is simple to read. Remember programs only have to be written once, but read
many times.

## Setup Github account
Github is used for sharing code. It is a website that saves code, and displays
changes in files across time.
Git is a version control program. It runs  locally on your machine, and tracks
changes in files across time.

## The Command Line
Today most operating systems have a graphical user interface, abbreviated GUI.
A GUI is the windows, buttons and interaction that can be done with a mouse.
There are many interactions that can be done on a GUI, but there are far more
that can be accomplished in a terminal. Terminals preceded GUIs for human
computer interaction, and are a powerful tool for the programmer. It is
prudent to learn how to replace most of your interaction with a computer by
using the command line.

## Setup StackOverflow Account
StackOverflow is an online forum for programming questions. It is likely that
any problem you encounter has an answer on this site. However you must never
copy and paste code from an unknown source without first understanding how it
is implemented. If you do so, it could easily introduce a new error in your
code.

## Setup Slack Account
Slack is a chat messaging app, with many more features than sending text. People
program chat bots and run them in Slack, which can do anything from downloading
an animated file to recommending where to eat for lunch. Chat bots are poised to
be the newest form of digital interaction in 2016, similar to SnapChat and Vine
of the past. [Slack Bot Examples](http://www.wired.com/2015/08/slack-overrun-bots-friendly-wonderful-bots/)

## The App Design Process
Building an app, whether its for a mobile phone or website, typically follows a
process.

1. Conception
2. Design User Interaction
3. Design interface
4. Architect and implement
5. Test
6. Deploy

Whenever you are programming, you should also follow a process. Everyone
develops their own pattern of thinking about code, and what is most comfortable
to them. But when code, you should try to understand how the author framed the
problem. When writing code, be sure to follow a similar process as App design.

1. Understand the problem
2. List the inputs
3. List the outputs
4. List the dependencies
5. Architect several solutions
6. Choose one solution to implement
7. Test
8. Deploy

## Intro to Pair Programming
Pair programming is a term for two people working together on a single computer.
Although one person is typing, both are actively solving the problem at hand.
There should be a dialog between the participants, and both programmers should
have a complete understanding of the architecture, algorithms, and state in
the product. Pair programming produces less errors, helps to spread
knowledge of the code base and teaches you how others think about code along
with the tools they utilize.
