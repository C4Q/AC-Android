# Classes Review

## Objectives
* Review and gain a basic understanding of Classes and Objects
* Create simple classes
* Define fields (variables for state) and methods (functions for behavior) in classes  
* Instantiate objects (instances of classes) from classes, using constructors
* Call methods on objects from classes

## Resources
* [Video: Classes and Objects](http://www.youtube.com/watch?v=OHw2t8BaIUg)
* [Video: Methods](http://www.youtube.com/watch?v=-eoNHtILOs4)
* [Video: Getters and Return Values](http://www.youtube.com/watch?v=foX28s2Qw0w)
* [Video: Method Parameters](http://www.youtube.com/watch?v=fXVI4xuvozg)
* [Video: Setters and 'this'](http://www.youtube.com/watch?v=x-gBJ6q3Ufc)
* [Video: Constructors](http://www.youtube.com/watch?v=oSiN1J_G01Q)
* [Video: Static and Final Keywords](http://www.youtube.com/watch?v=yImBET6EO8c)

# Lecture

Ealier in this course, we covered the concept of Object-Oriented Programming. In Java, **objects** are blocks of code, with their own variables and methods, which are created, or **instantiated**, based on a blueprint called a **class**.

Let's look at this class as an example:

```java
public class Apple {
  private boolean isRipe;
  private int seedCount;

}
```

The ```class``` ```Apple``` is a blueprint of sorts - and an object of class Apple is simply an ```instance``` of an Apple. Let's **instantiate** an object of the class ```Apple```:

```java
class Main {
  public static void main(String[] args) {
    Apple apple = new Apple();
  }

}
```

Great! The variable ```apple``` is of the type ```Apple```, and at runtime, will hold a reference to the object in memory of type ```Apple```. We created an object of the class ```Apple``` by calling its **default constructor**.

However, we can't really do much with this object. We have no access to its fields (they are set to **private**), and we haven't assigned any values to these fields. We've created an object, but it is a poorly constructed one.

First, let's write a constructor which will allow a user to assign values to each field, every time an object is instantiated:

```java
public class Apple {
  private boolean isRipe;
  private int seedCount;
  
  public Apple(boolean isRipe, int seedCount) {
    this.isRipe = isRipe;
    this.seedCount = seedCount;
  }

}
```

We used the keyword ```this```, because the parameter names in the constructor are spelled exactly as the fields of that class are spelled - and during assignment, we want Java to tell the difference between the two. We are stating explicitly, for this instance of class ```Apple```, we are assigning the argument passed into the constructor's parameter ```isRipe```, to the class field ```isRipe```, and the same for ```seedCount```.

Excellent! Now, a user can instantiate an object of type ```Apple```, and assign values to that instance's fields:

```java
class Main {
  public static void main(String[] args) {
    Apple apple = new Apple(true, 6);
  }
}
```

So, we've created our object, we've improved our constructor so that it may accept arguments (input values) into parameters, and we've assigned values to the fields of this particular instance of the class ```Apple```.

This object is much more robust, but at this point, we can only create an object with values - we cannot **get** any values from this object's fields (variables).

We can get the values from these private fields by adding public **getter** methods to our class, and calling these methods on our instantiated objects. First, let's add them:

```java
public class Apple {
  private boolean isRipe;
  private int seedCount;
  
  public Apple(boolean isRipe, int seedCount) {
    this.isRipe = isRipe;
    this.seedCount = seedCount;
  }
  
  public boolean getIsRipe() {
    return isRipe;
  }

  public int getSeedCount() {
    return seedCount;
  }

}
```

Now that we've created **getter** methods, let's use them on our object:

```java
class Main {
  public static void main(String[] args) {
    Apple apple = new Apple(true, 6);
    apple.getIsRipe();
    apple.getSeedCount();
  }

}
```

After creation, we cannot modify our `Apple` objects because the fields are private with no `setter` methods.
Todo: Add `setter` methods to update the value of `seedCount` and `isRipe` in the `Apple` class. The new `Apple` class with `setters` should look like:

```java
public class Apple {
  private boolean isRipe;
  private int seedCount;
  
  public Apple(boolean isRipe, int seedCount) {
    this.isRipe = isRipe;
    this.seedCount = seedCount;
  }
  
  public boolean getIsRipe() {
    return isRipe;
  }

  public int getSeedCount() {
    return seedCount;
  }

  public void setIsRipe(boolean isRipe) {
    this.isRipe = isRipe;
  }

  public void setSeedCount(int seedCount) {
    this.seedCount = seedCount;
  }

}
```
