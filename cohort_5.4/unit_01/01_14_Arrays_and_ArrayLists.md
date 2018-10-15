# Arrays and ArrayLists

## Objectives:
- Review Arrays in Java
- Explore ArrayLists and their Methods
- Explore HashMaps and their Methods

## Vocabulary

|Term|Definition|
|:--:|:---------|
|**Array**|a static data structure that holds a fixed number of values of a single type. The length of an array is established when the array is created. After creation, its length is fixed. This means that an Array's size is immutable.|
|**ArrayList**|a dynamic data structure, meaning items can be added and removed from the list. This means that an ArrayList's size is mutable. A normal array in java is a static data structure, because you are stuck with the initial size of your array at assignment. An ArrayList can change in size by adding or removing elements.|

## Resources

### Videos

- [Video: Arrays in Java](http://www.youtube.com/watch?v=Mfacb9T4biQ)
- [Video: ArrayLists](http://www.youtube.com/watch?v=mkCTxtLe7XU)
- [Video: HashMaps](http://www.youtube.com/watch?v=-JOSjIan2g0)
- [Video: Inheritance](http://www.youtube.com/watch?v=wzW-251bGgM)
- [Video: Abstract Classes](http://www.youtube.com/watch?v=CUC522qMGe8)
- [Video: Interfaces](http://www.youtube.com/watch?v=UumX4mQKQlA)

# Lecture

Data structures are an important part of any programming language, especially Java. The Java programming language has a great number of data structures used to store elements/data in a myriad number of ways. Some of the more popular data structures you may encounter are Arrays, ArrayLists, and HashMaps.

## Data Structures vs. Abstract Data Types

Data Structures are ways for developers to organize data in useful ways, but they are based on real-world concepts, like lists, dictionaries, and sets. These are called Abstract Data Types. An ordered list is a list numbered in order, like a chore list:

|Number|Task|
|:-:|:-:|
|1.|Brush Teeth|
|2.|Wash Hair|
|3.|Take out Trash|
|4.|Go Grocery Shopping|
|5.|Walk the Dog|

If you were following these tasks in order, you would have to complete task #1 before you completed task #5 - and if you wanted to know exactly what your third task was, you could search for that number on the list, and find out what that task might be! In Java, a list is an ordered collection of objects or values, while the data structures which operate like this are Arrays and ArrayLists.

### Arrays

Arrays are a data structure where elements of the same data type are assigned in order, by an index. An example of an array of int elements ( int[] ) can be seen in the code snippets below:

```java
// int elements directly assigned to an int array, setting its length to only 5 elements

int[] intArray = {7, 14, 21, 28, 35};
```

```java
// int array declared, and initialized with an array of exactly 5 int elements

int[] intArray = new int[5];
```

Arrays have numbers associated with each element stored within them, corresponding to the order in which they appear. This number is called an index. The plural of index is indices. The first element of any array with at least one element is said to be at index 0 - this is because in Java, lists start at 0, and not 1. 

A programmer who wants to know how many elements have been assigned to an array, or how many indices for elements have been allocated during initialization of this array, may use the ```.length``` property, which may be called on all array objects:

```java
// This will return the length, or the number of elements assigned to the array object

intArray.length;
```

Notice how the property ```.length``` does not have parentheses at the end of it - this is because calling a property is not the same as calling a method in Java.

All elements in an array have an index number. The first element has an index number of 0, and the index of the last element is equal to the length of the array, minus 1.

A programmer may also access or reassign elements within the array, by using the element's index:

```java
// This will allow a user to access the first element of the array, at index 0

intArray[0];

// This will allow the user to access the last element of the array, regardless of actual index number

intArray[intArray.length - 1];

// This will allow the user to access an element in the array, by its index, and assign it a value

intArray[2] = 99;

```

Arrays are great, but they are not terribly flexible. Java has a library called ```Collections```, and importing parts of that library can give us access to a number of robust data structures, such as Lists and Maps.

### Lists, and ArrayLists

An ArrayList behaves very much like an array, in that you may find out the number of elements in it, add elements only of a certain type, where each element has an index, and you can access/change the value of an element by calling it with its index. However, with an array, you cannot increase its size once you have initialized it, without replacing the entire array with a new one, containing both the old and new elements. You can, however, do this with an ArrayList.

```java
// First, you instantiate an ArrayList

ArrayList<Integer> integerArrayList = new ArrayList<>();
```

You might have seen the keyword ```Integer``` in angle brackets next to the static type **ArrayList**, as in ```ArrayList<Integer>``` - this is similar to how you might create an array of type ```int[]```:

```java
int[] intArray = new int[5];
```

You are essentially stating that the ArrayList you are instatiating will only accept elements of type ```Integer``` - this is called the ArrayList's **type parameter**. When we do this, under the hood, we are leveraging the power of something called **generics** (we will not cover this today, but soon).

You might be asking yourself why we used the keyword ```Integer``` instead of the keyword ```int``` - that's because **ArrayLists can only store objects**. Remember in a previous lesson, where we explored how everything is an object, and even primitive types have corresponding wrapper classes? Please see the chart below to explore each primitive type, and its corresponding wrapper class:

|Primitive Type|Wrapper Class|
|:-:|:-:|
|byte|Byte|
|short|Short|
|int|Integer|
|long|Long|
|float|Float|
|double|Double|
|char|Character|
|boolean|Boolean|

Because of the ```Integer``` wrapper class, we can now add int values to the ArrayList!

Now that we have this ArrayList object called ```integerArrayList```, let's add elements to it! We can do this with a method called ```.add()```, and we simply pass an argument of type ```Integer``` into the method's parameter:

```java
integerArrayList.add(25);
integerArrayList.add(50);
integerArrayList.add(75);
```

The method ```.add()``` will add a new element to the end of the ArrayList.

Now that we've added elements to our ArrayList, let's find out its length. The method we can call for that is ```.size()```:

```java
integerArrayList.size();
```

If we want to update a value at a certain index that already exists, you can use the method ```.set()```:

```java
integerArrayList.set(1, 256);
```

With that method call, we have just updated the value of the element at index 1 from 50, to 256!

If we want to add an element between two other elements, we can call the method ```.add()```, but with the specific index we want to add our element to:

```java
integerArrayList.add(1, 42);
```

This will shift all of the other elements to the next index, while adding the ```Integer``` 42, to index 1.

If we want to remove an element, we can call the method ```.remove()```, passing in an index to the parameter:

```java
integerArrayList.remove(1);
```

This will shift all of the other elements after the passed-in index, back by one index, effectively removing the element at that index.

ArrayLists also have a very handy method called ```.contains()```, which allows a user to check to see if an element is even in an ArrayList, before having to start a lengthy search with a loop, by returning ```true``` or ```false``` if the element exists somewhere in the ArrayList:

```java
// This will return true

integerArrayList.contains(42);

// This will return false

integerArrayList.contains(999);
```

**Note:** ArrayLists are a very flexible data structure when it comes to adding elements in a numbered order. However, unless you know the index of the element you wish to access, you will most likely have to check every single element to confirm that you are accessing the correct one. Also, the values stored at each index might change with use, and so calling an element by its index might bring unexpected results.

### Iterating Through Arrays and ArrayLists

When you work with a new data structure, you should always ask yourself these questions:

- How do I create it?
- How do I store values?
- How do I retrieve values?
- How do I iterate through it, or traverse it?

You can iterate through a  ```String``` object with something like this:

```java
String word = "awesomesauce";
for (int i = 0; i < word.length(); i++) {
    System.out.println(word.charAt(i));
}
```

Using a ```for``` loop, you may also iterate through an array object, by using its indices:

```java
int[] numbers = {1, 3, 5, 7, 9};
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

Not surprisingly, you may also use a ```for``` loop to iterate through an ArrayList object, using the ```.get()``` method:

```java
ArrayList<Character> characterList = new ArrayList<>();

for (int i = 0; i < characterList.size(); i++) {
    System.out.println(characterList.get(i));
}
```

## Exercises

Please see the canvas link for today's date to find the exercises for today's lecture.
