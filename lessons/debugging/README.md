- title: Debugging Workshop
- tags: android, debugging, stack traces, logcat

# Objectives
- Master interpreting a stack trace.
- Practice using Android Studio's debugger to set breakpoints in a program and examine the object tree of a variable.

# Resources
- [Debug Your App](https://developer.android.com/studio/debug/index.html)
- [Codepath: Debugging and Profiling Apps](https://guides.codepath.com/android/Debugging-and-Profiling-Apps)

# Lecture

### Interpreting a stack trace

Stack traces are a common starting point for debugging. A stack trace is typically produced when something goes wrong that the program was not prepared to handle. 

Like a stack, Java programs are executed in LIFO (last in, first out) order. Starting with the main method, as methods are called they are added to the top of the stack. The method at the top is what's currently running, and when a method completes it is removed from the stack, returning the program to the next method in line. 

When an exception occurs, a stack trace is printed, showing the methods in order with the **top of the stack** being the location of the exception  -- this is a good place to start looking for problems!

```
E/AndroidRuntime: FATAL EXCEPTION: main
                  Process: nyc.c4q.ramonaharrison.buggyapp, PID: 26286
                  java.lang.RuntimeException: Unable to start activity ComponentInfo{nyc.c4q.ramonaharrison.buggyapp/nyc.c4q.ramonaharrison.buggyapp.FirstActivity}: java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String java.lang.String.toUpperCase()' on a null object reference
                      at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2649)
                      at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2710)
                      at android.app.ActivityThread.handleRelaunchActivity(ActivityThread.java:4486)
                      at android.app.ActivityThread.-wrap19(ActivityThread.java)
                      at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1467)
                      at android.os.Handler.dispatchMessage(Handler.java:102)
                      at android.os.Looper.loop(Looper.java:154)
                      at android.app.ActivityThread.main(ActivityThread.java:6088)
                      at java.lang.reflect.Method.invoke(Native Method)
                      at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:886)
                      at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:776)
                   Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String java.lang.String.toUpperCase()' on a null object reference
                      at nyc.c4q.ramonaharrison.buggyapp.FirstActivity.onCreate(FirstActivity.java:38)
                      at android.app.Activity.performCreate(Activity.java:6679)
                      at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1118)
                      at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2602)
                      at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2710) 
                      at android.app.ActivityThread.handleRelaunchActivity(ActivityThread.java:4486) 
                      at android.app.ActivityThread.-wrap19(ActivityThread.java) 
                      at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1467) 
                      at android.os.Handler.dispatchMessage(Handler.java:102) 
                      at android.os.Looper.loop(Looper.java:154) 
                      at android.app.ActivityThread.main(ActivityThread.java:6088) 
                      at java.lang.reflect.Method.invoke(Native Method) 
                      at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:886) 
                      at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:776) 
```

- What type of exception is being thrown?
- What is the cause of this exception?
- At which line number of the activity's code did the exception occur?
- With which method invocation did the exception occur?

### Using the debugger

To investigate further, try to complete the following steps using Android Studio's debugger:

- Set a breakpoint in the `onCreate()` method, on the line where `myTextView.setText(welcome.toUpperCase())` is called.
- Debug the app (control + D).
- When the breakpoint is encountered, review the program's state in the Debugger panel.
- In the Variables window, look at the value of the String variable `welcome`. What is its current value?
- Press the resume button the move on from the breakpoint.
- Rotate your device. When the breakpoint is encountered again, review the program's state in the Debugger panel. In the Variables window, look at the value of the String variable `welcome`. What is its current value?
- Fix the Activity code so that `FirstActivity` will display the correct text and not crash when the device is rotated.

# Exercises

1) Clone the [Buggy App](https://github.com/ramonaharrison/BuggyApp) repo and open the project in Android Studio. Follow the instructions for each activity to track down and fix the bugs:

**FirstActivity**

On launch, this activity displays a string in the TextView, but it crashes when the device is rotated. Fix the activity so that the correct text is displayed without crashing.

**SecondActivity**

Have a look at the `WordAnalyzer` class. Right now, we only care about the first (buggy) method: `firstRepeatedCharacter()`. It returns the first repeated character in a word, such as 'o' in "roommate".

- Without actually running the program, predict its output for each of the following words. Assume that the `firstRepeatedCharacter()` method works correctly: **aardvark, roommate, word, test**.

- Now run the program. What output do you get?

- Have a look at the stack trace. The first complaint is about the method `charAt` of the `java.lang.String` class. That's a library class. It is extremely unlikely that a library class has a bug. It is far more common that one of its methods was called with bad parameters. The next complaint is about line 24 of the `firstRepeatedCharacter` method of the `WordAnalyzer` class.

- Exactly what source code do you find in line 24 of `WordAnalyzer`?

- In theory, there are two different exceptions that could be thrown in this line. What are they? 

- Explain the nature of the bug, and how to fix it.

- What output did you get after you fixed the bug?

**ThirdActivity**

In this activity, we care about the next buggy method: `firstMultipleCharacter()`. It returns the first multiple character in a word, such as 'i' in "Mississippi".

- Without actually running the program, predict its output for each of the following words. Assume that the `firstMultipleCharacter()` method works correctly: **mississippi, internet, word, test**.

- Now run the program. What output do you get?

- Insert logging statements and/or breakpoints in the `WordAnalyzer` code to determine where the logic error is occurring.

- You can fix the problem by modifying either the  `firstMultipleCharacter()` method or the `find()` method. Fix the problem. What fix did you make? 

- Run the program again to confirm that the logic error is resolved.

**FourthActivity**

In this activity, we care about the next buggy method: `countRepeatedCharacters()`. That method counts the substrings consisting of repeated character in a word. For example, the word "mississippi!!!" has a count of 4. 

- What output do you think the program will produce for: "hello", "test" and "aabbcdaaaabb"? Try it out. 

- Set breakpoints in the `countRepeatedCharacters()` method of `WordAnalyzer.java`, start the debugger, and test the string "aabbcdaaaabb". We want to find out why we get the wrong repetition count for this test case.

- While debugging, answer the following questions:
- Click on the triangle next to `this` in the Variables panel. What do you see?
- Why are there no triangles next to `c` and `i`?
- The value of `c` increases three times. What are the values for `i` at each increase? 
- Look at the `word` value. What is special about the three positions at which `c` increases?  
- Why doesn't the method find the start of the first "aa" group? 
- Why can't you simply fix the problem by letting `i` start at 0 in the `for` loop? 
- Go ahead and fix the bug. What is the code of your  `countRepeatedCharacters()` method now? What is the output now?

2) ***BONUS*** -- On your own, take 15 minutes to create your own buggy activity, `FifthActivity`, in the Buggy App project. Afterwards, share the activity code with your pairing partner and ask them to debug it.

3) Clone the Codepath [Android Debugging Challenges](https://github.com/codepath/android-debugging-challenges) repo. Run through [this tutorial](https://guides.codepath.com/android/Debugging-Exceptions-within-your-App) to debug the Flixster app in Android Studio.

4) Do some Google research to learn more about Java memory management, garbage collection, and `OutOfMemoryException`. 

- What are some common known causes for an `OutOfMemoryException` in an Android app? 

- Try to create an `OutOfMemoryException` in BuggyApp! (hint: try [loading a large bitmap](https://developer.android.com/training/displaying-bitmaps/index.html), or [leaking context](http://www.androiddesignpatterns.com/2013/01/inner-class-handler-memory-leak.html)) 

- Practice using Android Studio's [Memory Monitor](https://developer.android.com/studio/profile/am-memory.html) and [HPROF Viewer](https://developer.android.com/studio/profile/am-hprof.html) to monitor and inspect the app's memory allocation.
