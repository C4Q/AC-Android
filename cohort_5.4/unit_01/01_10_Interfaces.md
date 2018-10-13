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

IntelliJ forces you to override this method, and add your own method body. This class has not only inherited the LEG\_COUNT field and method, but it created its own version of the ```textileType()``` method, which was previously only a method signature in the parent class.

Abstract classes can implement interfaces as well by using the ```implement``` keyword. However, because they are abstract, they don't need to implement all methods. The AbstractList interface implements common methods, which allows concrete implementations like ArrayList to be free from the burden of implementing all methods, rather than if they implemented the List interface directly.

Because abstract classes need to be subclassed, they cannot be declared as final. They are also opposites of each other - the ```abstract``` keyword forces a user to extend a class. On the other hand, the ```final``` keyword prevents a class from being extended. In human language terms, abstract signifies incompleteness, while final is used to demonstrate completeness. In short - you cannot make your class ```abstract``` AND ```final``` in Java, as it will result in a compile time error.

## Exercises

* TBD
