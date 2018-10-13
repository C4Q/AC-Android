# Interfaces

## Objective
* Fellows will explore the difference between an intefaces and concrete classes
* Fellows will learn about abstract method signatures
* Fellows will learn how to inherit from interfaces and implement interface methods

## Resources
* [Video - Interfaces in Java](https://www.youtube.com/watch?v=UumX4mQKQlA)

# Lecture

Interfaces are class-like constructs which should not be directly instantiated, but instead be inherited by concrete child classes. They contain only method signatures, (access modifier, return type, method name, parameters with types, etc.), and these method signatures should be an incomplete method definition - i.e.: not have a code block in curly braces (opening `{` and closing `}` brackets) with code already written inside. They must be implemented by concrete subclasses, which should then be instantiated.

A good analogy to invision is that of inheriting a vintage, non-working car from an elder relative. The car is supposed to have an engine that can run, brakes that can stop the car, and windshield wipers that work, but the actual parts need "sprucing up", so to speak (it has a pedal, but the engine won't turn, etc). The elder relative says if you can get the engine working, and replace the broken parts, the car is yours - but you can't do anything with the car unless you keep your promise, and get things up-and-running.

We can think of the interface as a LIST OF THINGS a working vehicle can do, and the concrete class that implements that list is a car that actually CAN DO those things.

Let's create an ```interface``` in a file called Vehicle.java:

```java
public interface Vehicle {

    void drive(int speed);

    void brake();

    void wipeWindShield(boolean isRaining);

}
```
We can see three method signatures WITHOUT a method body (no curly brackets):

* a method signature called `drive`, that returns nothing
* a method signature called `brake`, that returns nothing
* a method signature called `wipeWindShield`, that returns nothing, but has a boolean parameter called `isRaining`

This is intentional - this means that for every subclass that extends `Vehicle`, it must OVERRIDE THESE METHODS, AND FILL IT WITH ITS OWN CODE.

Now, let's create a concrete subclass which will implement the `Vehicle` interface:

```java
public class UncleMannysChevy implements Vehicle {

    private int gas;
    private int milesDriven;
    private int milesToGo;
    private int speed;
    private boolean areWipersOn;

    public UncleMannysChevy(int milesToGo) {
        this.milesToGo = milesToGo;
    }

    @Override
    public void drive(int speed) {
        this.speed = speed;
        if (this.speed > 0) {
            while (milesToGo > 0) {
                if (gas > 0) {
                    System.out.println("I'm driving - whoooohooooo!!!");
                    System.out.println("Miles Driven: " + (++milesDriven));
                    gas--;
                    milesToGo--;
                } else {
                    System.out.println("Out of gas :\\");
                    return;
                }
            }
            System.out.println("We have arrived at our destination!");
        }
    }

    @Override
    public void brake() {
        speed = 0;
        System.out.println("Whoah! I almost hit that deer!");
    }

    @Override
    public void wipeWindShield(boolean isRaining) {
        if (isRaining && !areWipersOn) {
            System.out.println("Wipe away those Angel Tears!");
        } else if (!areWipersOn) {
            System.out.println("Spraying on wiper fluid and wiping!");
        } else {
            System.out.println("Wipers off!");
        }
        areWipersOn = !areWipersOn;
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }
}
```

IntelliJ forces you to override the methods from all the method signatures inherited from the `Vehicle` interface, and add your own method bodies (code blocks with opening `{` and closing `}` tags) with your own code. 

Interfaces may seem like something you'd rarely use in the future, but that's far from the truth. Interfaces are useful for several reasons, but the main three are:

* to keep method names, return types, and parameter types the same for all child classes, but guarantee that all methods will be unique - because you'll have to override them and make them the way you want to
* to leverage the power of Polymorphism: different classes having the same "parent", so they can be used in the same data structure
* to ensure your code is "scaleable" - the implementations of class types might change over time, but the method names might need to stay the same, so that other classes can use them without having to change much, as long as their parameter types and return types are of the classes' parent types

## Exercises

* TBD
