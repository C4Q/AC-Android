# Fragment Callback Communication Revisited

## Objectives
* Fellows will review how to use interface callback methods to send data from a Fragment to its host Activity
* Fellows will review how to use static factory methods to send data from a host Activity to a Fragment

# Resources
* [Intro to Fragments](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_03_intro_to_fragments.md)
* [Fragments and Fragment Transactions](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_04_fragments_and_fragment_transactions.md)
* [Fragment Lifecycle and Communications](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_05_fragment_lifecycle_and_communications.md)
* [Fragments Review](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_06_fragments_review.md)

# Lecture

So far, we've discussed the Fragment Lifecycle, Fragment Management, Fragment Transactions, Bundle Arguments, and the Backstack. We've even discussed Fragment static factory methods, and the use of interface callback methods to communicate between a Fragment, and its hosting Activity. Today, we'll explicitly explore these last two topics together.

### What Is an Interface?

According to the Java docs:

*"In its most common form, an interface is a group of related methods with empty bodies... To implement this interface, the name of your class would change, and you'd use the implements keyword in the class declaration... Interfaces form a contract between the class and the outside world, and this contract is enforced at build time by the compiler. If your class claims to implement an interface, all methods defined by that interface must appear in its source code before the class will successfully compile."*


In other words, an `interface` is a promise of sorts - if you implement the interface, it is expected that you will have to fill each of those abstract methods' method bodies (the space within its `{` and `}` curly braces/brackets) with code that matches its expected behavior. For example, if there exists an interface called `NorseGod.java`:

``` java 
public interface NorseGod {

  void sayMyName();
  String weapon(String name);

}
```

And a class that implements the interface called `Thor.java`:

``` java
public class Thor implements NorseGod {

  @Override
  public void sayMyName() {
    System.out.println("I am Thor, King of Asgard!");
  }
  
  @Override
  public String weapon(String name) {
    if (name.equals("Thor")) {
      return "Stormbreaker";
    }
  }
}
```

Then `Thor` would have to implement each of `NorseGod`'s methods.

### What are Listeners?

Listeners represent the interfaces responsible for handling events. Effectively, interfaces are implemented by classes, the classes are instantiated, the methods are overridden, and their reference is then passed to other classes, which can then call the overridden methods as needed, triggering the code within the overridden methods to run. 

That was a lot. Here's a Dalmation eating some ice cream:

![dalmation eating ice cream](http://pawedpets.org/wp/wp-content/uploads/dalmation-eating-ice-cream.jpg)

Okay, back to listeners.



## Exercises
