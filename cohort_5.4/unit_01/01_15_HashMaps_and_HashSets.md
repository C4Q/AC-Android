# HashMaps and HashSets

## Objectives:
- Review Arrays in Java
- Review ArrayLists and their Methods
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

## Maps, and HashMaps

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

### Iterating Through HashMaps

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

favoriteShows.add("Game of Thrones");
favoriteShows.add("The Walking Dead");
favoriteShows.add("Last Week Tonight");
favoriteShows.add("Stranger Things");
favoriteShows.add("The Haunting of Hill House");
favoriteShows.add("WestWorld");
favoriteShows.add("The Golden Girls");
favoriteShows.add("Stranger Things");
favoriteShows.add("The Walking Dead");
favoriteShows.add("WestWorld");

for (String s : favoriteShows) {
    System.out.println(s);
}
```

After running the `for-each` loop, we can expect to see the following output printed to the screen:

```
Last Week Tonight
The Golden Girls
Stranger Things
The Haunting of Hill House
WestWorld
The Walking Dead
Game of Thrones
```

Several things are worth noting here:

* even though duplicate values were added to the `HashSet`, only unique values were saved to the data structure
* the elements of the `HashSet` were not actually printed in any order

This is because `HashSets` are very much like the keys of a `HashMap` - they must all be unique, and are by nature unordered.

There are a number of useful methods to consider when working with `HashSets`:

|Method|Use Case|
|:-:|---|
|add(Object o)|Adds the specified element to this set if it is not already present|
|clear()|Removes all of the elements from this set|
|contains(Object o)|Returns true if this set contains the specified element|
|isEmpty()|Returns true if this set contains no elements|	
|remove(Object o)|Removes the specified element from this set if it is present|
|size()|Returns the number of elements in this set (its cardinality)|
