- title: Interfaces and Abstract Classes
- tags: java inheritance

#Objectives

- Understand inheritance
- Understand Subclasses
- Understand Method Overriding
- Introduction to Scope
- Learn object object-oriented vocabulary
#Resources

-[Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/IandI/index.html)

# Lecture
# Terminology

- super class
- base class
- upcast
- downcast
- typecast
- method overriding
- method stubs
- overloading
- extends
- implements
- method signature
- instanceof
- super
- public,protected,package-private,private
- implicit vs explicit
- polymorphism
- abstract
- override

#Inheritance
Classes can be derived from other classes, thereby inheriting fields and methods from those classes.

> Definition: A class that is derived from another class is called a `subclass` (also a derived class, extended class, or child class). The class from which the subclass is derived is called a `superclass` (also a base class or a parent class).

When you want to create a new class and there is already a class that includes some of the code that you want, you can derive your new class from the existing class. In doing this, you can reuse the fields and methods of the existing class without having to write (and debug!) them yourself in order to adapt your new class to new situations

![ Animal Hierarchy ] (img/animalHiearchy3.jpg)
![ upcasting downcasting ] ( img/updown_upcasting.png )


Other than `Object` ( shown above ), which has no superclass, every class has one and only one direct superclass.

> This is referred to as `single inheritance`. Java does not support `multiple inheritance` although we can achieve similiar functionality via `interfaces`

In the absence of any other explicit superclass, every class is implicitly a subclass of Object.

Classes can be derived from classes that are derived from classes that are derived from classes, and so on, and ultimately derived from the topmost class,`Object`. Such a class is said to be descended from all the classes in the inheritance chain stretching back to `Object`.




A subclass inherits all the public methods and fields from its superclass.

>Constructors are not members, so they are not inherited by subclasses, but the constructor of the superclass can be invoked from the subclass using the keyword `super`

#### The Java Platform Class Hierarchy

The Object class, defined in the java.lang package, defines and implements behavior common to all classes—including the ones that you write. In the Java platform, many classes derive directly from Object, other classes derive from some of those classes, and so on, forming a hierarchy of classes.

All Classes in the Java Platform are Descendants of Object
![classes-object] (img/classes-object.gif)

At the top of the hierarchy, Object is the most general of all classes. Classes near the bottom of the hierarchy provide more specialized behavior.

####An Example of Inheritance

Here is the sample code for a possible implementation of a Bicycle class.

```java
public class Bicycle {

    // the Bicycle class has three fields
    public int cadence;
    public int gear;
    public int speed;

    // the Bicycle class has one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }

    // the Bicycle class has four methods
    public void setCadence(int newValue) {
        cadence = newValue;
    }

    public void setGear(int newValue) {
        gear = newValue;
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }

}
```

A class declaration for a MountainBike class that is a subclass of Bicycle might look like this:

```java
public class MountainBike extends Bicycle {

    // the MountainBike subclass adds one field
    public int seatHeight;

    // the MountainBike subclass has one constructor
    public MountainBike(int startHeight,
                        int startCadence,
                        int startSpeed,
                        int startGear) {
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }

    // the MountainBike subclass adds one method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
}
```
MountainBike inherits all the fields and methods of Bicycle and adds the field `seatHeight` and a method, `setHeight`, to set it. Except for the constructor, it is as if you had written a new MountainBike class entirely from scratch, with four fields and five methods. However, you didn't have to do all the work! This would be especially valuable if the methods in the Bicycle class were complex and had taken substantial time to debug.

###What You Can Do in a Subclass

A subclass inherits all of the public and protected members of its parent, no matter what package the subclass is in.

>####Side Note: Don't remember the difference between public, protected and package-private?
>[java access modifiers ] (img/java_accessmodifiers.jpg)
<br />
>[java access modifiers (graphic ) ] (img/java_accessmodifiers_graphic.jpg)

If the subclass is in the same package as its parent, it also inherits the package-private members of the parent. You can use the inherited members as is, replace them, hide them, or supplement them with new members:

* The inherited fields can be used directly, just like any other fields.
* You can declare a field in the subclass with the same name as the one in the superclass, thus hiding it (not recommended).
* You can declare new fields in the subclass that are not in the superclass.
* The inherited methods can be used directly as they are.
* You can write a new instance method in the subclass that has the same signature as the one in the superclass, thus overriding it. ( You remember what a method signature is right? [ method signature ] (img/static-method.png) )
* You can write a new static method in the subclass that has the same signature as the one in the superclass, thus hiding it.
* You can declare new methods in the subclass that are not in the superclass.
* You can write a subclass constructor that invokes the constructor of the superclass, either implicitly or by using the keyword super.

### Private Members in a Superclass

A subclass does not inherit the private members of its parent class. However, if the superclass has public or protected methods for accessing its private fields, these can also be used by the subclass.

### Casting Objects

We have seen that an object is of the data type of the class from which it was instantiated. For example, if we write
```java
MountainBike myBike = new MountainBike();
```
then `myBike` is of type `MountainBike`.


`MountainBike` is descended from `Bicycle` and `Object`. Therefore, a `MountainBike` is a `Bicycle` and is also an `Object`, and it can be used wherever `Bicycle` or `Object` objects are called for.

####The reverse is not necessarily true: a Bicycle may be a MountainBike, but it isn't necessarily. Similarly, an Object may be a Bicycle or a MountainBike, but it isn't necessarily.

Casting shows the use of an object of one type in place of another type, among the objects permitted by inheritance and implementations. For example, if we write

```java
Object obj = new MountainBike();
```
then obj is both an Object and a MountainBike (until such time as obj is assigned another object that is not a MountainBike). This is called implicit casting.

If, on the other hand, we write
```java
MountainBike myBike = obj;
```
we would get a compile-time error because obj is not known to the compiler to be a MountainBike. However, we can tell the compiler that we promise to assign a MountainBike to obj by explicit casting:

```java
MountainBike myBike = (MountainBike)obj;
```

This cast inserts a runtime check that obj is assigned a MountainBike so that the compiler can safely assume that obj is a MountainBike. If obj is not a MountainBike at runtime, `an exception will be thrown`!!

Note: You can make a logical test as to the type of a particular object using the instanceof operator. This can save you from a runtime error owing to an improper cast. For example:
```java
if (obj instanceof MountainBike) {
    MountainBike myBike = (MountainBike)obj;
}
```
Here the instanceof operator verifies that obj refers to a MountainBike so that we can make the cast with knowledge that there will be no runtime exception thrown.

##Overriding and Hiding Methods

![ method overriding ] (img/methodOverriding.gif)


###Instance Methods

An instance method in a subclass with the same signature and return type as an instance method in the superclass overrides the superclass's method.

The ability of a subclass to override a method allows a class to inherit from a superclass whose behavior is "close enough" and then to modify behavior as needed. The overriding method has the same name, number and type of parameters, and return type as the method that it overrides. An overriding method can also return a subtype of the type returned by the overridden method. This subtype is called a covariant return type.

*IMPORTANT* - When overriding a method, you should use the @Override annotation that instructs the compiler that you intend to override a method in the superclass. If, for some reason, the compiler detects that the method does not exist in one of the superclasses, then it will generate an error.

![overrides](img/overrides.png)

###Static Methods

If a subclass defines a static method with the same signature as a static method in the superclass, then the method in the subclass hides the one in the superclass.

The distinction between hiding a static method and overriding an instance method has important implications:

The version of the overridden instance method that gets invoked is the one in the subclass.
The version of the hidden static method that gets invoked depends on whether it is invoked from the superclass or the subclass.
Consider an example that contains two classes. The first is Animal, which contains one instance method and one static method:
```java
public class Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Animal");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Animal");
    }
}
```
The second class, a subclass of Animal, is called Cat:
```java
public class Cat extends Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

    public static void main(String[] args) {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        Animal.testClassMethod();
        myAnimal.testInstanceMethod();
    }
}
```
The Cat class overrides the instance method in Animal and hides the static method in Animal. The main method in this class creates an instance of Cat and invokes testClassMethod() on the class and testInstanceMethod() on the instance.

The output from this program is as follows:
```
The static method in Animal
The instance method in Cat
```
As promised, the version of the hidden static method that gets invoked is the one in the superclass, and the version of the overridden instance method that gets invoked is the one in the subclass.

The following table summarizes what happens when you define a method with the same signature as a method in a superclass.

|  | Superclass Instance Method | Superclass Static Method |
|---|---|---|
| `Subclass Instance Method` | `Overrides` | Generates a compile-time error |
| `Subclass Static Method` | `Generates a compile-time error` | Hides |

###Modifiers

The access specifier for an overriding method can allow more, but not less, access than the overridden method. For example, a protected instance method in the superclass can be made public, but not private, in the subclass.

You will get a compile-time error if you attempt to change an instance method in the superclass to a static method in the subclass, and vice versa.

Note: In a subclass, you can overload the methods inherited from the superclass. Such overloaded methods neither hide nor override the superclass instance methods—they are new methods, unique to the subclass.

###Object as a Superclass

The Object class, in the java.lang package, sits at the top of the class hierarchy tree. Every class is a descendant of the Object class. Every class you use or write inherits the instance methods of Object. You need not use any of these methods, but, if you choose to do so, you may need to override them with code that is specific to your class. The methods inherited from Object are below:

```java
protected Object clone() throws CloneNotSupportedException
      Creates and returns a copy of this object.
public boolean equals(Object obj)
      Indicates whether some other object is "equal to" this one.
protected void finalize() throws Throwable
      Called by the garbage collector on an object when garbage
      collection determines that there are no more references to the object
public final Class getClass()
      Returns the runtime class of an object.
public int hashCode()
      Returns a hash code value for the object.
public String toString()
      Returns a string representation of the object.
```

Overriding these methods is an advanced topic and will not be discussed further.
However, you should explore overriding toString() to make debugging your code
easier.

> **Exercise:**  Write a class named Calculator. Give it four abstract methods,
add, subtract, multiply, and divide.

> **Exercise:**  Write a class named BasicCalculator that extends Calculator.
Implement the methods, add, substract, multiply, and divide.

> **Exercise:**  Write an abstract class named ScientificCalculator that extends
Calculator. Give it three abstract methods, sin, cos, tan.

> **Exercise:**  In two sentences, describe what methods any class that extends
ScientificCalculator would have to implement, and why.
