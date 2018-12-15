# Asynchronous Tasks

## Objective

Students will understand:

* what processes and threads are in general
* how processes and threads work on Android
* the role of the main (aka UI) thread and what to do and NOT do
* the different ways to work with threading on Android


## Resources
- [Concurrency](http://docs.oracle.com/javase/tutorial/essential/concurrency/)
- [Processes and Threads](https://docs.oracle.com/javase/tutorial/essential/concurrency/procthread.html)
- [AsyncTask](https://developer.android.com/reference/android/os/AsyncTask.html)
- [Processes and Threads, an Overview](https://www.youtube.com/watch?v=IcIFJ5V3Ibg)
- [Components and the UI Thread](https://www.youtube.com/watch?v=A0PAhoHzlsQ)
- [Android Multithreading Overview](https://www.youtube.com/watch?v=lznss-0gEHU)
- [AsyncTasks](https://www.youtube.com/watch?v=V4q0sTIntsk)

## Definitions

**Jank**: Any stuttering, flickering or just plain halting that users see when an app (or site) isn't keeping up with the refresh rate. Jank is the result of frames taking too long for a browser to make, and it negatively impacts your users and how they experience your site or app.

**Asynchronous** - When you execute something asynchronously, you can move on to another task before it finishes.

**Synchronous** - When you execute something synchronously, you wait for it to finish before moving on to another task. (Also referred to as blocking)

**Thread** - A thread of execution in a program. The Java Virtual Machine allows an application to have multiple threads of execution running concurrently.

**Process** - A running program; all the threads in a process have access to shared memory, and each process running has its own memory. The CPU of a machine handles running several processes at once.

**Thread** - represents one path of execution in a process. Threads can run concurrently, which makes them tricky to reason about.

Race Condition - Running more than one thread inside the same application does not by itself cause problems. The problems arise when multiple threads access the same resources. For instance the same memory (variables, arrays, or objects), systems (databases, web services etc.) or files.

# Lecture

* [AsyncTask and AsyncTaskLoader](https://docs.google.com/presentation/d/1A7anDTS8NQCunbxoJnqJqkSHNFCvRIn9moE7Zww-gds/edit#slide=id.p)

## The Android Main Thread

The UI thread is the main thread, and it is in charge of updating the UI. Other threads may interact with the main thread to update the UI or do other things such as run a service or running the onReceive method in a broadcast receiver. Because this thread updates the UI, actions that are performed on it should be quick and discrete.  If the UI thread were to be used to access the internet or download a file, for example, then the user would not be unable to interact with the application until that operation was completed. This is why background threads are used.

* Background threads are threads other than the main thread. They do not make changes to the UI.  
* While information from a background thread may be used to update the UI, the UI is updated by the UI thread. Anything that could block the UI thread, such as a database access, should go on a background thread.

#### Asynchronous Android Programming

There are a number of ways to facilitate asynchronous Android programming - i.e, Handlers, Threads, Runnables, Intent Services: We will start with learning about the AsyncTask because it abstracts away details of concurrency

- Executes code asynchronously

- Initiates background thread, runs operations, and syncs with main thread

- For short operations (< several seconds) that are used to publish some outcome to main thread

- Not an answer to every multi-threading matter*

The AsyncTask class allows to run instructions in the background and to synchronize again with the main thread. It also reporting progress of the running tasks. AsyncTasks should be used for short background operations which need to update the user interface.

In other words, AsyncTask is an object that defines a task to be executed in a background thread. The `doInBackground` method must be implemented, and the code runs in the background. The `onPostExecute` method runs on the UI thread, and can use the result of `doInBackground`, which it takes in as a parameter.

Some methods from AsyncTask run on the UI thread, while some run in a background thread - e.g. `publishProgress` posts an update from the background thread, while `onProgressUpdate` runs on the UI thread using the information from `publishProgress`.

An AsyncTask is started via the `execute()` method. This `execute()` method calls the `doInBackground()` and the `onPostExecute()` method.

To use AsyncTask you must subclass it. The parameters are the following AsyncTask <TypeOfVarArgParams, ProgressValue, ResultValue>

## The 4 steps / Lifecycle of an AsyncTask

When an asynchronous task is executed, the task goes through 4 steps:

1. **onPreExecute()**: invoked on the *UI thread* before the task is executed. This step is normally used to setup the task, for instance by showing a progress bar in the user interface.

2. **doInBackground(Params...)**: invoked on the *background thread* immediately after `onPreExecute()` finishes executing. This step is used to perform background computation that can take a long time. The parameters of the asynchronous task are passed to this step. The result of the computation must be returned by this step and will be passed back to the last step. This step can also use `publishProgress(Progress...)` to publish one or more units of progress. These values are published on the UI thread, in the `onProgressUpdate(Progress...)` step.

3. **onProgressUpdate(Progress...)**: invoked on the *UI thread* after a call to publishProgress(Progress...). The timing of the execution is undefined. This method is used to display any form of progress in the user interface while the background computation is still executing. For instance, it can be used to animate a progress bar or show logs in a text field.

4. **onPostExecute(Result)**: invoked on the *UI thread* after the background computation finishes. The result of the background computation is passed to this step as a parameter.

Try copying modifying the UI (let's say setting adapter of recyclerView) in the `doInBackground` method. What happened? Why?

## AsyncTask are great, but...

AsyncTask isn't for everything!

* Use them to perform long running tasks / computations.

* Use them to perform work that could take an indeterminate amount of time.

* Otherwise, don't. Like threads, they're expensive to create, manage and destroy.

### Exercises 

**Question 1** 
