# Builder Pattern

## Objectives
* Fellows will discover why design patterns are useful in programs
* Fellows will instantiate flexibly with the Builder Pattern

## Resources
* [Sourcemaking: Design Patterns](https://sourcemaking.com/design_patterns)
* [Design Patterns Book](https://en.wikipedia.org/wiki/Design_Patterns)
* [Software Design Patterns](https://en.wikipedia.org/wiki/Software_design_pattern)
* [GrepCode: Java Source Code search](http://grepcode.com)
* [Nested Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html)

## Warm-Up (5 minutes) - Do This First!

Create a class with a private default constructor, called `Party` in a file called `Party.java`. It should have a private `static` field of type `Party` called `privateParty`. Create a public static method called `getInstance`, that checks that the value of `privateParty` is not null. If it is, assign it the value of a `new Party()`, using the private constructor. If it already has a value, return that value.

# Lecture

According to the educational website [Sourcemaking.com](Sourcemaking.com):

*"In software engineering, a design pattern is a general repeatable solution to a commonly occurring problem in software design. A design pattern isn't a finished design that can be transformed directly into code. It is a description or template for how to solve a problem that can be used in many different situations."*

**In short**: Design patterns help developers make their code abstract, concise, and more reusable. 

## Builder Pattern

This is a pattern you might have seen on StackOverflow, in relation to making objects:

```java
TunaSalad tunaSalad = new TunaSalad.Builder()
    .addPasta("Elbow Macaroni")
    .addCondiment("Mayonaise")
    .addSeasoning("Old Bay")
    .build();
```

You might have seen that code and wondered what magic was happening when that `.build()` method was finally called. Welp, nothing magical here - Santa Claus isn't real, and builders are just static nested classes that call an enclosing class's private constructor.

![wat](http://i0.kym-cdn.com/photos/images/newsfeed/000/173/580/Wat.jpg?1315930588)

So that's a lot of jargon. Let's break it down.

### Nested Classes

You can place classes inside other classes. There are two forms of this:

* Inner Classes, which can only be instantiated when an instance of the outer class already exists:

```java
public class Outer {
    	public class Inner{
	}
}
```

Instantiation of inner class:

```java
Outer outer = new Outer();
Outer.Inner inner = outer.new Inner();
```

* Nested Classes, which belong to the class (static), and so can be called on the actual class, and not instance objects:

```java
public class Outer {
    	public static class StaticInner{
	}
}
```

Instantiation of static nested class:

```java
Outer.StaticInner staticInner = new Outer.StaticInner();
```

So, that's great. But the question remains: Why, though?

### Constructors can become unweildy

![hard to weild](https://thabto.files.wordpress.com/2013/07/baby-tire.jpg)

Remember when we were bakers, who used Object-Oriented Programming techniques to bake pies? This time, imagine we've moved on to a Pizza shop - and we want to make pizza pies with a variety of toppings:

```java
public class PizzaClassWithConstructors {

    private boolean tomatoSauce;
    private boolean cheese;
    private int diameter;
    private boolean pepperoni;
    private boolean onions;
    private boolean olives;
    private boolean arugula;
    private boolean artichokes;
    private boolean anchovies;
}
```

If we used a default constructor, we'd make pizzas without any toppings (Bleeeeeccchhhh!!!), so we'll have to make unique constructors:

```java
public class PizzaClassWithConstructors {

    private boolean tomatoSauce;
    private boolean cheese;
    private int diameter;
    private boolean pepperoni;
    private boolean onions;
    private boolean olives;
    private boolean arugula;
    private boolean artichokes;
    private boolean anchovies;

    public PizzaClassWithConstructors(boolean tomatoSauce) {
        this.tomatoSauce = tomatoSauce;
    }

    public PizzaClassWithConstructors(boolean tomatoSauce, boolean cheese) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
    }

    public PizzaClassWithConstructors(boolean tomatoSauce, boolean cheese, int diameter) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.diameter = diameter;
    }

    public PizzaClassWithConstructors(boolean tomatoSauce, boolean cheese, int diameter, boolean pepperoni) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.diameter = diameter;
        this.pepperoni = pepperoni;
    }

    public PizzaClassWithConstructors(boolean tomatoSauce, boolean cheese, int diameter, boolean pepperoni, boolean onions) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.diameter = diameter;
        this.pepperoni = pepperoni;
        this.onions = onions;
    }

    public PizzaClassWithConstructors(boolean tomatoSauce, boolean cheese, int diameter, boolean pepperoni, boolean onions, boolean olives) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.diameter = diameter;
        this.pepperoni = pepperoni;
        this.onions = onions;
        this.olives = olives;
    }

    public PizzaClassWithConstructors(boolean tomatoSauce, boolean cheese, int diameter, boolean pepperoni, boolean onions, boolean olives, boolean arugula) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.diameter = diameter;
        this.pepperoni = pepperoni;
        this.onions = onions;
        this.olives = olives;
        this.arugula = arugula;
    }

    public PizzaClassWithConstructors(boolean tomatoSauce, boolean cheese, int diameter, boolean pepperoni, boolean onions, boolean olives, boolean arugula, boolean artichokes) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.diameter = diameter;
        this.pepperoni = pepperoni;
        this.onions = onions;
        this.olives = olives;
        this.arugula = arugula;
        this.artichokes = artichokes;
    }

    public PizzaClassWithConstructors(boolean tomatoSauce, boolean cheese, int diameter, boolean pepperoni, boolean onions, boolean olives, boolean arugula, boolean artichokes, boolean anchovies) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.diameter = diameter;
        this.pepperoni = pepperoni;
        this.onions = onions;
        this.olives = olives;
        this.arugula = arugula;
        this.artichokes = artichokes;
        this.anchovies = anchovies;
    }
}
```

That's... a lot. And we haven't even added getters/setters yet:

```java
public class PizzaClassWithConstructors {

    private boolean tomatoSauce;
    private boolean cheese;
    private int diameter;
    private boolean pepperoni;
    private boolean onions;
    private boolean olives;
    private boolean arugula;
    private boolean artichokes;
    private boolean anchovies;

    public PizzaClassWithConstructors(boolean tomatoSauce) {
        this.tomatoSauce = tomatoSauce;
    }

    public PizzaClassWithConstructors(boolean tomatoSauce, boolean cheese) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
    }

    public PizzaClassWithConstructors(boolean tomatoSauce, boolean cheese, int diameter) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.diameter = diameter;
    }

    public PizzaClassWithConstructors(boolean tomatoSauce, boolean cheese, int diameter, boolean pepperoni) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.diameter = diameter;
        this.pepperoni = pepperoni;
    }

    public PizzaClassWithConstructors(boolean tomatoSauce, boolean cheese, int diameter, boolean pepperoni, boolean onions) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.diameter = diameter;
        this.pepperoni = pepperoni;
        this.onions = onions;
    }

    public PizzaClassWithConstructors(boolean tomatoSauce, boolean cheese, int diameter, boolean pepperoni, boolean onions, boolean olives) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.diameter = diameter;
        this.pepperoni = pepperoni;
        this.onions = onions;
        this.olives = olives;
    }

    public PizzaClassWithConstructors(boolean tomatoSauce, boolean cheese, int diameter, boolean pepperoni, boolean onions, boolean olives, boolean arugula) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.diameter = diameter;
        this.pepperoni = pepperoni;
        this.onions = onions;
        this.olives = olives;
        this.arugula = arugula;
    }

    public PizzaClassWithConstructors(boolean tomatoSauce, boolean cheese, int diameter, boolean pepperoni, boolean onions, boolean olives, boolean arugula, boolean artichokes) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.diameter = diameter;
        this.pepperoni = pepperoni;
        this.onions = onions;
        this.olives = olives;
        this.arugula = arugula;
        this.artichokes = artichokes;
    }

    public PizzaClassWithConstructors(boolean tomatoSauce, boolean cheese, int diameter, boolean pepperoni, boolean onions, boolean olives, boolean arugula, boolean artichokes, boolean anchovies) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.diameter = diameter;
        this.pepperoni = pepperoni;
        this.onions = onions;
        this.olives = olives;
        this.arugula = arugula;
        this.artichokes = artichokes;
        this.anchovies = anchovies;
    }

    public boolean isTomatoSauce() {
        return tomatoSauce;
    }

    public void setTomatoSauce(boolean tomatoSauce) {
        this.tomatoSauce = tomatoSauce;
    }

    public boolean isCheese() {
        return cheese;
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public boolean isPepperoni() {
        return pepperoni;
    }

    public void setPepperoni(boolean pepperoni) {
        this.pepperoni = pepperoni;
    }

    public boolean isOnions() {
        return onions;
    }

    public void setOnions(boolean onions) {
        this.onions = onions;
    }

    public boolean isOlives() {
        return olives;
    }

    public void setOlives(boolean olives) {
        this.olives = olives;
    }

    public boolean isArugula() {
        return arugula;
    }

    public void setArugula(boolean arugula) {
        this.arugula = arugula;
    }

    public boolean isArtichokes() {
        return artichokes;
    }

    public void setArtichokes(boolean artichokes) {
        this.artichokes = artichokes;
    }

    public boolean isAnchovies() {
        return anchovies;
    }

    public void setAnchovies(boolean anchovies) {
        this.anchovies = anchovies;
    }
}
```

Plus, these pizzas aren't really made-to-order - yeah, you can get a pepperoni pizza with sauce and cheese, but if you want one with anchovies (🙄🙄🙄), you'd either have to order a pizza with a bunch of unwanted toppings, and pass in "false" for each one you didn't want - or use a setter to effectively throw cold fish on a hot pizza (😨🤢🤮)....

So, what can we do if we want a pizza made just the way we like it, and not have to add to it after it's been made?

![we can build it](http://i0.kym-cdn.com/photos/images/original/000/908/557/8d6.jpg)

### Creating the Builder

First, create the enclosing class, and add a single constructor setting all the fields, and make sure the constructor is *PRIVATE*:

```java
public class PizzaClassWithABuilder {

    private boolean tomatoSauce;
    private boolean cheese;
    private int diameter;
    private boolean pepperoni;
    private boolean onions;
    private boolean olives;
    private boolean arugula;
    private boolean artichokes;
    private boolean anchoves;

    private PizzaClassWithABuilder(boolean tomatoSauce, boolean cheese, int diameter, boolean pepperoni, boolean onions, boolean olives, boolean arugula, boolean artichokes, boolean anchoves) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.diameter = diameter;
        this.pepperoni = pepperoni;
        this.onions = onions;
        this.olives = olives;
        this.arugula = arugula;
        this.artichokes = artichokes;
        this.anchoves = anchoves;
    }
}
```

Next, create the inner static builder class, adding a parameter for every parameter in the enclosing class, and a constructor setting the `tomatoSauce`, `cheese`, and `diameter` builder fields:

```java
public class PizzaClassWithABuilder {

    private boolean tomatoSauce;
    private boolean cheese;
    private int diameter;
    private boolean pepperoni;
    private boolean onions;
    private boolean olives;
    private boolean arugula;
    private boolean artichokes;
    private boolean anchoves;

    private PizzaClassWithABuilder(boolean tomatoSauce, boolean cheese, int diameter, boolean pepperoni, boolean onions, boolean olives, boolean arugula, boolean artichokes, boolean anchoves) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.diameter = diameter;
        this.pepperoni = pepperoni;
        this.onions = onions;
        this.olives = olives;
        this.arugula = arugula;
        this.artichokes = artichokes;
        this.anchoves = anchoves;
    }

    // PizzaBuilder inner static class:
    public static class PizzaBuilder {

        private boolean tomatoSauce;
        private boolean cheese;
        private int diameter;
        private boolean pepperoni;
        private boolean onions;
        private boolean olives;
        private boolean arugula;
        private boolean artichokes;
        private boolean anchoves;

        public PizzaBuilder(boolean tomatoSauce, boolean cheese, int diameter) {
            this.tomatoSauce = tomatoSauce;
            this.cheese = cheese;
            this.diameter = diameter;
        }
    }
}
````

Now add setters for each of these inner fields:

```java
public class PizzaClassWithABuilder {

    private boolean tomatoSauce;
    private boolean cheese;
    private int diameter;
    private boolean pepperoni;
    private boolean onions;
    private boolean olives;
    private boolean arugula;
    private boolean artichokes;
    private boolean anchoves;

    private PizzaClassWithABuilder(boolean tomatoSauce, boolean cheese, int diameter, boolean pepperoni, boolean onions, boolean olives, boolean arugula, boolean artichokes, boolean anchoves) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.diameter = diameter;
        this.pepperoni = pepperoni;
        this.onions = onions;
        this.olives = olives;
        this.arugula = arugula;
        this.artichokes = artichokes;
        this.anchoves = anchoves;
    }

    public static class PizzaBuilder {

        private boolean tomatoSauce;
        private boolean cheese;
        private int diameter;
        private boolean pepperoni;
        private boolean onions;
        private boolean olives;
        private boolean arugula;
        private boolean artichokes;
        private boolean anchoves;

        public PizzaBuilder(boolean tomatoSauce, boolean cheese, int diameter) {
            this.tomatoSauce = tomatoSauce;
            this.cheese = cheese;
            this.diameter = diameter;
        }

        public PizzaBuilder setTomatoSauce(boolean tomatoSauce) {
            this.tomatoSauce = tomatoSauce;
            return this;
        }

        public PizzaBuilder setCheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public PizzaBuilder setDiameter(int diameter) {
            this.diameter = diameter;
            return this;
        }

        public PizzaBuilder setPepperoni(boolean pepperoni) {
            this.pepperoni = pepperoni;
            return this;
        }

        public PizzaBuilder setOnions(boolean onions) {
            this.onions = onions;
            return this;
        }

        public PizzaBuilder setOlives(boolean olives) {
            this.olives = olives;
            return this;
        }

        public PizzaBuilder setArugula(boolean arugula) {
            this.arugula = arugula;
            return this;
        }

        public PizzaBuilder setArtichokes(boolean artichokes) {
            this.artichokes = artichokes;
            return this;
        }

        public PizzaBuilder setAnchoves(boolean anchoves) {
            this.anchoves = anchoves;
            return this;
        }
    }
}
```

Finally, in order to actually get a Pizza back, we need to create a method that will actually return a pizza, by creating one using all of the arguments passed into the builder, and passing them all into the private constructor:

```java
public class PizzaClassWithABuilder {

    private boolean tomatoSauce;
    private boolean cheese;
    private int diameter;
    private boolean pepperoni;
    private boolean onions;
    private boolean olives;
    private boolean arugula;
    private boolean artichokes;
    private boolean anchoves;

    private PizzaClassWithABuilder(boolean tomatoSauce, boolean cheese, int diameter, boolean pepperoni, boolean onions, boolean olives, boolean arugula, boolean artichokes, boolean anchoves) {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.diameter = diameter;
        this.pepperoni = pepperoni;
        this.onions = onions;
        this.olives = olives;
        this.arugula = arugula;
        this.artichokes = artichokes;
        this.anchoves = anchoves;
    }

    public static class PizzaBuilder {

        private boolean tomatoSauce;
        private boolean cheese;
        private int diameter;
        private boolean pepperoni;
        private boolean onions;
        private boolean olives;
        private boolean arugula;
        private boolean artichokes;
        private boolean anchoves;

        public PizzaBuilder(boolean tomatoSauce, boolean cheese, int diameter) {
            this.tomatoSauce = tomatoSauce;
            this.cheese = cheese;
            this.diameter = diameter;
        }

        public PizzaBuilder setTomatoSauce(boolean tomatoSauce) {
            this.tomatoSauce = tomatoSauce;
            return this;
        }

        public PizzaBuilder setCheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public PizzaBuilder setDiameter(int diameter) {
            this.diameter = diameter;
            return this;
        }

        public PizzaBuilder setPepperoni(boolean pepperoni) {
            this.pepperoni = pepperoni;
            return this;
        }

        public PizzaBuilder setOnions(boolean onions) {
            this.onions = onions;
            return this;
        }

        public PizzaBuilder setOlives(boolean olives) {
            this.olives = olives;
            return this;
        }

        public PizzaBuilder setArugula(boolean arugula) {
            this.arugula = arugula;
            return this;
        }

        public PizzaBuilder setArtichokes(boolean artichokes) {
            this.artichokes = artichokes;
            return this;
        }

        public PizzaBuilder setAnchoves(boolean anchoves) {
            this.anchoves = anchoves;
            return this;
        }

	// Method that returns the actual Pizza object:
        public PizzaClassWithABuilder build() {
            return new PizzaClassWithABuilder(
                    tomatoSauce,
                    cheese,
                    diameter,
                    pepperoni,
                    onions,
                    olives,
                    arugula,
                    artichokes,
                    anchoves);
        }
    }
}
```

Now, we can create a very unique, made-to-order pizza:

```java
PizzaClassWithABuilder pizza = new PizzaClassWithABuilder
                .PizzaBuilder(true, true, 12)
                .setPepperoni(true)
                .setArugula(true)
                .build();
```

![pizza](https://s3-media1.fl.yelpcdn.com/bphoto/oacYHuSvtp_Z2gKIH0etUg/o.jpg)
