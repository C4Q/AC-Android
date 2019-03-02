# Interview Prep

## Objectives

* To give fellows experience with technical interviews
* Apply Data structures in an efficient way
* Analyze runtime complexity and design efficient algorithms

## Resources

* [Tech Interview Handbook (github)](https://github.com/yangshun/tech-interview-handbook)
* [Interview Prep Kit (hackerrank)](https://www.hackerrank.com/interview/interview-preparation-kit)
* [Whiteboarding tips (blog post)](https://codewithoutrules.com/2016/04/04/interview-puzzles/)

## DSA Challenges

### Array's Quick reference

|  | Worst Case |
|:-------------:|:-------------|
| space | O( n ) |
| lookup | O( n )|
| append | O( 1 ) |  
| insert | O( n ) |  
| delete | O( n ) |  

Strengths:

* Fast lookups
* Fast appends

Weaknesses:

* Fixed size:
* Expensive inserts and deletes:

Sorting:

We can use algorithms like merge sort or quick sort to sort an array but we have methods like Arrays.sort() that implement merge sort for us.

However if we want to sort a List we would use Collections.sort() instead where the input parameters will be the List and a custom Comparator.

A Comparator will take two objects in the list and compare them, it asks “Which is greater?” the compare method will then returns -1, 0 or 1 to say if it is less than, equal, or greater to the other. It uses this result to then determine if they should be swapped for its sort.

```java
new Comparator<Meeting>() {
        @Override
        public int compare(Meeting m1, Meeting m2) {
            return m1.getStartTime() - m2.getStartTime();
        }
    });
```

If we need to sort two meetings time we would implement this Comparator and would return the result of subtracting the meeting start times. If the result is negative we know that the first meeting is starts before our second meeting. If the result is 0 we know that our meetings start at the same time, if the result is positive we know that the second meeting starts earlier than the first

### Merging Meeting Times

Your company has built an in house calender tool, You need to add a feature to see the times in a day when everyone is available.

You'll need to know when any team is having a meeting. A meeting is stored as an object of a Meeting class with integer variables startTime and endTime. The integers represent the number of 30-minute blocks past 9:00am.

```java
public class Meeting {

    private int startTime;
    private int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
```

Sample Meetings

```java
Meeting earlyMorning = new Meeting(2,3); // meeting from 10:00 - 10:30 am
Meeting lunchMeeting = new Meeting(6,9); // meeting from 12:00 - 1:30
```

Write a method mergeRanges()
that takes a list of multiple meeting time ranges and returns a list of condensed ranges

Input:

```java
[Meeting(0,1), Meeting(3,5), Meeting(4,8), Meeting(10,12), Meeting(9,10)]
```

Return:

```java
[Meeting(0,1), Meeting(3,8), Meeting(9,12)]
```

### Hash Maps Quick Reference

A Hash Map (aka Hash Table) organizes data for quick lock up using key value pairs.

|  | Average |    Worst Case |
|:-----:|:----:|:----|
| space | O(n  | O( n )   |
| lookup | O( n )|  O ( n )    |
| insert | O( 1 ) | O ( n )     |
| delete | O( 1 ) | O ( n )     |

Strengths:

* Fast lookups: Lookups take O( 1 ) on average
* Flexible Keys: Various data types can be used for keys

Weaknesses:

* Slow worst-case lookup
* Unordered
* Single-direction

### Inflight Entertainment

You've built an inflight entertainment system with on-demand movie streaming

Users on long flights like to start a new movie right after the one they are currently watching ends. But they'll complain that the plane lands before they can finish. Your task is build a feature for choosing two movies whose runtimes will equal the exact flight time.

Write a method that takes an integer flightLength("in minutes") and an array of integers movieLengths("in minutes"). This will return a boolean which indicates that there are two numbers in the array whose sum is equal to flightLength

### Design Challenge

![jukebox](https://cdn.cnn.com/cnnnext/dam/assets/170109125128-sound-leisure-jukeboxes-3-super-169.jpeg)

Design a musical jukebox.

* Assume that its free