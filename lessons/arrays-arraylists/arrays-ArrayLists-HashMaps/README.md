# ArrayLists, HashMaps, and HashSets

## Objectives:
- Review Arrays in Java
- Explore ArrayLists and their Methods
- Explore HashMaps and their Methods

## Vocabulary

|Term|Definition|
|:--:|:---------|
|**Array**|a static data structure that holds a fixed number of values of a single type. The length of an array is established when the array is created. After creation, its length is fixed. This means that an Array's size is immutable.|
|**ArrayList**|a dynamic data structure, meaning items can be added and removed from the list. This means that an ArrayList's size is mutable. A normal array in java is a static data structure, because you are stuck with the initial size of your array at assignment. An ArrayList can change in size by adding or removing elements.|
|**HashMap**|a dynamic data structure, meaning items can be added and removed from the map. Comparable to a dictionary, allowing users to store key/value pairs (like names/phone numbers, or words/definitions).|

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

#### You may begin working on exercises 1, 2, and 3

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

#### You may begin working on exercises 4, 5, and 6

ArrayLists are a very flexible data structure when it comes to adding elements in a numbered order. However, unless you know the index of the element you wish to access, you will most likely have to check every single element to confirm that you are accessing the correct one. Also, the values stored at each index might change with use, and so calling an element by its index might bring unexpected results.

### Maps, and HashMaps

Maps are different from ArrayLists, in that entries in this data structure are stored as key/value pairs. Maps like HashMaps are often called dictionaries in other languages, because they are similar to how one can search for the definition (value) of a word (key) by simply finding the word (key) in the dictionary. 

|Word|Definition|
|:-:|:-:|
|Apple|a round fruit that grows on a tree in temperate climates|
|Tomato|a round fruit that grows on a vine|
|Coconut|a round fuzzy fruit that grows on a tree in tropical climates|

In this case, the Map would be the Abstract Data Type, while a HashMap would be the implementation of this Abstract Data type as a Data Structure.

Let's create a HashMap:

```java
HashMap<Integer, String> importantBirthdays = new HashMap<>();
```

This is very similar to how we created an ArrayList object earlier, except that this time, there are two **type parameters** - one for the **key** (the key you will use to get the value you wish to store), and one for the **value** (the actual value you wish to recall when using the key).

Now that we have our HashMap, let's add some values to it, by using the method ```.put()```, and passing in an ```Integer``` for the key, and a ```String``` for the value:

```java
importantBirthdays.put(18, "you can now vote");
importantBirthdays.put(21, "you can now drink");
importantBirthdays.put(65, "you can now retire");
```

There are several obvious differences between an ArrayList and a HashMap, from what we can already see - there are no indices, meaning you do not add them to a certain location, or a certain order, within the data structure. Also, instead of assigning an element to a particular index, we have made an association between a birthday, and a milestone.

Let's say, after putting a birthday and its milestone into a HashMap, we also want to get a milestone (value) out of a HashMap, by using your birthday age (key). We can simply use the method ```.get()``` on the HashMap object:

```java
// This will retreive the milestone "you can now drink"

importantBirthdays.get(21);
```

If you call the method `get()` on a HashMap object with a key that doesn't exist yet in the collection of keys (called a keySet), the method will return a `null` value:

```java
// This will return "null", because this key does not exist for this HashMap instance

importantBirthdays.get(25);
```

There is a catch to using a HashMap - although each value may be different, all of the keys you put into this data structure must be unique. This means that if you use the key ```21``` more than once to enter a milestone, you won't be adding a second milestone, you will instead effectively replace the previous one:

```java
// Original entry
importantBirthdays.put(21, "you can now drink");

// Replaced entry
importantBirthdays.put(21, "you may also graduate from college");
```

If you wish to remove an entry, you may call the ```.remove()``` method on the HashMap:

```java
importantBirthdays.remove(65);
```

As with ArrayLists and the method ```.contains()```, HashMaps have a similar method to check if a key already exists within the HashMap, called ```.containsKey()```:

```java
// This will return true

importantBirthdays.containsKey(18);

// This will return false

importantBirthdays.containsKey(99);
```

### Iterating Through ArrayLists and HashMaps

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

However, HashMaps are an unordered collection - this means that because values are stored with an associated key, there is no need to utilize an index! Although this is great if you know the key you are looking for, it is not very useful if you do not. This is why Java provides us with an extremely useful loop - the **for-each**, or **enhanced for** loop!

The for-each loop allows us to search for a certain object within a collection, using a parameter of a certain type. Let's see how this works with ArrayLists first:

```java
ArrayList<String> hairBands = new ArrayList<>();
hairBands.add("Poison");
hairBands.add("Ratt");
hairBands.add("Quiet Riot");
hairBands.add("Van Halen");

for (String band : hairBands) {
  System.out.println(band);
}
```

We can see here that because we know that every element in the ArrayList is of type ```String```, we can do whatever we like with any element that is of that type. We are essentially saying "While there are ```Strings``` in ```hairBands``` - for each ```String``` in ```hairBands```, print whatever that ```String``` is. When we iterate this way, we don't have to worry about the length of the ArrayList or avoiding index out of bounds exceptions, since it doesn't need to know how many loops to make - it only needs to loop through the elements that exist in it.

Let's do the same thing with a HashMap:

```java
HashMap<String, String> animalFoods = new HashMap<>();
animalFoods.put("chipmunks", "seeds");
animalFoods.put("squirrels", "acorns");
animalFoods.put("bats", "mosquitoes");
animalFoods.put("park pigeons", "human souls");

for (String animal : animalFoods.keySet()){
    System.out.println(animalFoods.get(animal));
}
```

A HashMap entry doesn't just have one type parameter, it has two - one for its key, and one for its value. So we can't simply look through the HashMap directly, like we did with the ArrayList. We have to call a method on the HashMap object called ```.keySet()```, which is exactly what the method name implies - it returns the set containing all the keys for each entry in the HashMap. A ```Set``` is another data structure we will go into later - a ```Set``` can only contain unique values - since HashMaps can only have unique keys, a list of all the keys is also technically a set.

#### You may begin working on exercises 7, 8, and 9

### Sets, and HashSets

The Abstract Data Type of a Set is a collection of elements that are completely unique. The days of the week, for example, would be a unique set:

|Days|
|:-:|
|Monday|
|Tuesday|
|Wednesday|
|Thursday|
|Friday|
|Saturday|
|Sunday|

It would not make sense to add `Tuesday` multiple times, since it is already there, and having more than one would be redundant. Another way to think about it would be to imagine everyone in the class voting for the same TV show, then writing it on the board - it's highly likely that many students might like the same shows, so writing the name of the same show multiple times wouldn't make much sense.

In Java we can implement a Set by using a `HashSet` Data Structure:

Let's create a HashSet:

```java
HashSet<String> favoriteShows = new HashSet<>();
```
