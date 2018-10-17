# Inheritance and Polymorphism

## Objectives

* Fellows will review the OOP Pillar of Inheritance in Java
* Fellows will review the OOP Pillar of Polymorphism in Java

## Resources

* [Video - Inheritance](https://www.youtube.com/watch?v=wzW-251bGgM)
* [Video - Polymorphism](https://www.youtube.com/watch?v=daXvUxhBtAQ)

# Lecture

* TODO - Post lesson after approval

For the last few weeks, we've explored Object-Oriented Programming concepts in Java:

* Encapsulation: keeping all fields and methods in a single class, so we can make unique instances
  * an extension of this concept is "Abstraction", where we keep important things hidden, and only make certain fields, methods, and constructors public, not all of them 
* Inheritance: where a parent class can have its funtionality (public and protected fields, methods, and contructors) passed on to the child classes that inherit from the parent class (`extends` and `implements`)
  * an extension of this "Composition", where although certain methods may be inherited, but it might make sense to `@Override` those methods, or just ignore them, and make different methods all together
* Polymorphism: meaning "many forms", from the ancient greek roots "poly" (many) and "morph" (shape, form, structure) - in other words, a child class, if it inherits from more than one class, can be assigned to a variable of that type statically, and can only have access to the public fields and methods associated with that static type

Polymorphism is usually where people hit their first wall in Java. And that's okay! It's a bit of an alien concept, kind of like the creature from the "Alien" movies, actually. Wait - I think I'm onto something.

The aliens in the "Alien" movies are called "Xenomorphs" - meaning they are "Aliens" that can take many "forms", based on where they spawn.

For example: an Alien that spawns from a Human can run upright, an Alien that spawns from a Dog can run on all fours and has a long tail, an Alien that spawns from a Predator creature has the Predator jaws and head, etc. However, they all have the same things in common - they are all Xenomorphs that eat people, have acid blood, and have those creepy inside mouths (eeeewwwwwww):

![Gross](https://cdn.images.express.co.uk/img/dynamic/36/590x/Sigourney-Weaver-Alien-5-559248.jpg)

Let's create a `AlienXenomorph` class:

```java
class AlienXenomorph {
  public void iAmAXenomorph() {
    System.out.println("I am a Xenomorph, I have a creepy inside murder jaw!");
  }
  public void acidBlood() {
    System.out.printlin("I have acid blood!");
  }
}
```

Now, let's make a few creepy subclasses that inherit from, or extend, the `AlienXenomorph` parent class:

```java
class HumanXenomorph extends AlienXenomorph {
  public void walkLikeAHuman() {
    System.out.println("I spawned from a human, so I can run upright!");
  }
}
```

```java
class DogXenomorph extends AlienXenomorph {
  public void walkLikeAHuman() {
    System.out.println("I spawned from a dog, so I can run on all four feet!");
  }
}
```

```java
class PredatorXenomorph extends AlienXenomorph {
  public void walkLikeAHuman() {
    System.out.println("I spawned from a Predator, so I can bite with crab mandibles!");
  }
}
```

We can see that inheritance is very useful, but it has some unique issues:

* Anything that inherits from a parent class can do whatever a parent class can do, as long as those methods are `public` or `protected` when the cild class extends it
* the opposite is not true - if an instance of the child class is assigned to a variable with a static type of a parent class, it can only do or use the `public` or `protected` things a parent can do, and that is all:

```java
class Main {
  public static void main(String[] args) {
    AlienXenomorph alienXenomorph = new AlienXenomorph();
    alienXenomorph.iAmAXenomorph();
    alienXenomorph.acidBlood();
  }
}

```
