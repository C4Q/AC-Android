# Abstract Classes

## Objectives
* Fellows will explore the differences between concrete and abstract classes
* Fellows will learn to create abstract method signatures
* Fellows will learn to create concrete classes which inherit from abstract classes

## Resources
* [Video - Abstract Classes in Java](https://www.youtube.com/watch?v=CUC522qMGe8)

# Lecture

Abstract classes are classes which should not be directly instantiated, but still encapsulate important funtionality. They must be extended by concrete subclasses, which should then be instantiated.

A good analogy to invision is that of Furniture. A chair is a form of furniture, and a couch is a form of furniture, but although it makes sense to make a chair, since a chair is something very concrete, a "furniture" is not concrete, it is abstract, it's a concept.

Let's create an ```abstract``` class in a file called Furniture.java:

```java
public abstract class Furniture {
  private static final int LEG_COUNT = 4;
  
  public static int getLegCount() {
    return LEG_COUNT;
  }
  
  public abstract void textileType();
  
}
```
We can see two methods - a static method, which returns a final constant named LEG\_COUNT, and ```public abstract void textileType();```, a method signature, WITHOUT a method body (no curly brackets). This is intentional - this means that for every subclass that extends furniture, it must OVERRIDE THIS METHOD, AND FILL IT WITH ITS OWN CODE.

Now, let's create a concrete subclass which will extend the Furniture abstract class:

```java
public class Chair extends Furniture {
  
  @Override
    public void textileType() {
        System.out.println("Wood");
    }
}
```

IntelliJ forces you to override this method, and add your own method body. This class has not only inherited the LEG\_COUNT field and method, but it created its own version of the ```textileType()``` method, which was previously only a method signature in the parent class.

Abstract classes can implement interfaces as well by using the ```implement``` keyword. However, because they are abstract, they don't need to implement all methods. The AbstractList interface implements common methods, which allows concrete implementations like ArrayList to be free from the burden of implementing all methods, rather than if they implemented the List interface directly.

Because abstract classes need to be subclassed, they cannot be declared as final. They are also opposites of each other - the ```abstract``` keyword forces a user to extend a class. On the other hand, the ```final``` keyword prevents a class from being extended. In human language terms, abstract signifies incompleteness, while final is used to demonstrate completeness. In short - you cannot make your class ```abstract``` AND ```final``` in Java, as it will result in a compile time error.

## Exercises

* TBD
