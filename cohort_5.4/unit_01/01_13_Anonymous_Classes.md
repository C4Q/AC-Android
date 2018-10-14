# Anonymous Classes

## Objectives

* Fellows will learn to create Anonymous class instances
* Fellows will learn to identify the differences between concrete and anonymous class instances

## Resources

* [Video - Anonymous Classes](https://www.youtube.com/watch?v=ihAzMaUFjgY)

# Lecture

Anonymous classes are an important part of development in Java - they are easily implemented, but are often difficult to explore.

Anonymous classes are actually quite simple - they are object instances with a declared static type, but a nameless dynamic or instance type.

Remember when we spoke about how an object variable assignment has both a static type known at compile time, and a dynamic type known at runtime? Let's break it down:

|static type known at compile time|variable|assignment|new keyword|constructor for dynamic instance type at runtime|
|:-:|:-:|:-:|:-:|:-:|
|Apple|apple|=|new|Apple();|

If you're trying to create an instance of a class with only non-static methods that have full method signatures, you'll be okay - because the constructor exists, and all the methods are defined. But what if you want to create an instance of a concrete class, but you want to override a method on-the-go? Or what if you have abstract methods, like with an `interface`, or an `abstract` class?

This can be a problem, and it's why we say that interfaces and abstract classes SHOULD NOT be instantiated. However...

There is another way to do this, and it is called creating anonymous classes!

Let's start my creating two files - one for an `interface` called `SomeInterface` in a file called `SomeInterface.java`, and a `class` called `Apple.java`:

```java
public interface SomeInterface {

    public void pleaseOverrideMe();
}
```

```java
public class Apple {

    public void iAmAnApple() {
        System.out.println("I am an apple.");
    }
}
```

Typically, when creating instances of classes we don't want to change, we can do something like this:

```java
Apple apple = new Apple();
apple.iAmAnApple();
```

However, up until now, the only way to `@Override` methods from classes (that we knew about) was by subclassing a parent class, and overriding its methods explicitly. With anonymous classes, you don't have to worry about that! Simply add opening `{` and closing `}` brackets for a code block  AFTER the parentheses `()`, but BEFORE the `;` semicolon:

```java
Apple apple = new Apple();
apple.iAmAnApple();
Apple apple02 = new Apple() {
            
};

```

That's it! Now you have an anonymous class instance! Not sure? Print out the class type of the `apple02` variable to the screen:

```java
Apple apple = new Apple();
apple.iAmAnApple();
Apple apple02 = new Apple() {
            
};
System.out.println(apple02.getClass());
```

should have the output:

```
class org.pursuit.Main$1
```

So, that's unusual. Since the variable `apple02` is of type `Apple`, we'd expect the output to be `class org.pursuit.Main$1`, but it's not. It has a class type of `Main$1`. This is because at runtime, since it is no longer the same as a typical instance of type `Apple`, and we're instantiating it in the `Main` class, it is now an unnamed class instance within the `Main` class - called `$1`. If we made other anonymous classes, they would be named `$2, $3, $4`, etc...

So, let's override the method `iAmAnApple` to print something else:

```java
Apple apple = new Apple();
Apple apple02 = new Apple() {
        @Override
        public void iAmAnApple() {
            System.out.println("I'm obviously an apple, this was clearly unnecessary...");
        }
    };

apple.iAmAnApple();
System.out.println(apple.getClass());
apple02.iAmAnApple();
System.out.println(apple02.getClass());
```

should print the output:

```
I am an apple.
class org.pursuit.Apple
I'm obviously an apple, this was clearly unnecessary...
class org.pursuit.Main$1
```

That's awesome! However, how would this work for abstract classes and interfaces?

This works exactly the same! Since abstract methods, and the method signatures of interfaces need to be overridden anyway, that's exactly what should be done:

```java
SomeInterface anon = new SomeInterface() {
    @Override
    public void pleaseOverrideMe() {
        System.out.println("I am anonymous! " + this.getClass().toString());
    }
};

anon.pleaseOverrideMe();
```

Wow, that was surprisingly painless! Since it's our own class now, let's add an additional method:

```java
SomeInterface anon = new SomeInterface() {
    @Override
    public void pleaseOverrideMe() {
        System.out.println("I am anonymous! " + this.getClass().toString());
    }
    
    public void thisIsWeird() {
        System.out.println("This is weird though, right? " + this.getClass().toString());
    }
};

anon.pleaseOverrideMe();
anon.thisIsWeird();
```

Hmm, that's strange - it looks like we get an error when we try to call our new method on the `anon` variable. But why is that?

Remember static types and dynamic types? The compiler only knows the methods in the `SomeInterface` interface at compile time - it has no idea whether or not the new method `thisIsWeird` even exists! The only thing that knows it exists is the anonymous class at runtime, and we can't cast it to the new anonymous class - because we don't know what it is to get access to it, BECAUSE IT DOES NOT HAVE A NAME!

![Dramatic Chipmunk](https://media.giphy.com/media/kKdgdeuO2M08M/giphy.gif)

So, all we can really do is call the new method FROM WITHIN the anonymous class:

```java
SomeInterface anon = new SomeInterface() {
    @Override
    public void pleaseOverrideMe() {
        System.out.println("I am anonymous! " + this.getClass().toString());
        thisIsWeird();
    }
    
    public void thisIsWeird() {
        System.out.println("This is weird though, right? " + this.getClass().toString());
    }
};

anon.pleaseOverrideMe();
```

which should have this output:

```
I am anonymous! class org.pursuit.Main$2
This is weird though, right? class org.pursuit.Main$2
```

And that's all you need to know about anonymous classes!

### For the Nerds Only (I was lying before, there's also this)

So, when I said we don't know what it is, because we don't know the name, well, that's true. It's just this anonymous class at runtime that we hold a reference to, but we just can't name. But, to call (or invoke) the method, we don't need to know the class, we just need to get it. And we can do this via something called **Reflection**.

**WARNING:** you don't really need to know this to use anonymous classes, but this is still good to know about in Java. Essentially, reflection lets you get access to the classes at runtime, rather than compile time - so you're kind of playing God here. Be warned.

First, we'll need to add an `import` to use the reflection library in our code:

```java
import java.lang.reflect.Method;
```

Next, we'll have to confirm what methods are actually present at runtime:

```java
Class c = anon.getClass();
System.out.println(c);
Method[] n = c.getDeclaredMethods();
for (int i = 0; i < n.length; i++) {
    System.out.println(n[i].toString());
}
```

should have the output:

```
class org.pursuit.Main$2
public void org.pursuit.Main$2.thisIsWeird()
public void org.pursuit.Main$2.pleaseOverrideMe()
```

Let's talk about what's happening here:

* first, we get the class type of the `anon` object at runtime: `org.pursuit.Main$2`
* next, we get all the methods associated with this anonymous type at runtime:
    ** public void org.pursuit.Main$2.thisIsWeird()
    ** public void org.pursuit.Main$2.pleaseOverrideMe()

Great! We can confirm that there is in fact a method called `thisIsWeird` for this anonymous class instance!

However, this is where it gets dangerous. When we use reflection, we need to be ABSOLUTELY SURE we know what we're doing, otherwise we can throw an exception. So, if we want to call the method `thisIsWeird` on the `anon` instance, we'll have to:
* make sure we know exactly what to expect at runtime (method name, field name, etc.)
* wrap everything in the right kind of try/catch block to catch all possible exceptions

For example:

```java
SomeInterface anon = new SomeInterface() {
    @Override
    public void pleaseOverrideMe() {
        System.out.println("I am anonymous! " + this.getClass().toString());
        thisIsWeird();
    }
    
    public void thisIsWeird() {
        System.out.println("This is weird though, right? " + this.getClass().toString());
    }
};

anon.pleaseOverrideMe();

Class c = anon.getClass();
try {
    Method m = c.getMethod("thisIsWeird");
    m.invoke(anon);
} catch (IllegalAccessException e) {
    e.printStackTrace();
} catch (InvocationTargetException e) {
    e.printStackTrace();
} catch (NoSuchMethodException e) {
    e.printStackTrace();
}
```

Which should have the following output:

```
I am anonymous! class org.pursuit.Main$2
This is weird though, right? class org.pursuit.Main$2
```

What are we doing here:
* getting the class type of the anonymous class at runtime (without knowing what it is)
* getting the method with the name `thisIsWeird`
* invoking the method on the anonymous instance `anon`
* wrapping everything in a try/catch block to account for THREE POSSIBLE EXCEPTIONS

So there we go - anonymous classes in Java: easy to use, dangerous to explore!

## Exercises

* TDB
