# Classes

## Objectives
* Participants will describe what a class is
* Participants will describe what an object is
* Participants will write their own classes, and instantiate their own objects from classes

## Resources
* [Video: Classes and Objects](http://www.youtube.com/watch?v=OHw2t8BaIUg)
* [Video: Methods](http://www.youtube.com/watch?v=-eoNHtILOs4)
* [Video: Getters and Return Values](http://www.youtube.com/watch?v=foX28s2Qw0w)
* [Video: Method Parameters](http://www.youtube.com/watch?v=fXVI4xuvozg)
* [Video: Setters and 'this'](http://www.youtube.com/watch?v=x-gBJ6q3Ufc)
* [Video: Constructors](http://www.youtube.com/watch?v=oSiN1J_G01Q)
* [Video: Static and Final Keywords](http://www.youtube.com/watch?v=yImBET6EO8c)

# Lecture

In Java, it is not enough to use primitive variables to store values, and methods to do things and change the flow of a program. We must also make sure that our code is well-organized, and blocks of code are seperated based on the jobs they perform.

This form of programming is called Object-Oriented Programming - or OOP for short. This form of programming allows the developer to model blocks of code on things from the real-world. In Java, these things are referred to as objects.

Objects are created based on a blueprint for how they may store information, or perform operations. These blueprints are called Classes.

Think of it this way - imagine you are a baker, and you want to make a pie. It would be helpful to start with a recipe, so that your pies could be made just the way you like them. You can think of the recipe as a blueprint, or **Class**. 

```java
class Pie {

public static String crust = "filo dough";
public static String pieFilling = "cherry";
public static int diameter = 12;

public static void pieIsBaked() {
	System.out.println("I am a " + pieFilling + " pie!");
}
```

You can think of every pie you bake using that recipe as an object of the Class ```Pie```. It doesn't have a primitive type like ```int``` or ```boolean``` - it has a class type, the way ```String``` primitives are of class type ```String```. All eight primitive types use keywords written in all lowercase - but all class types are declared using proper case - meaning the first letter is capitalized, while the remainder of the letters are written in **camelCase** format.

As you can see, all of the variables inside class ```Pie``` are ```static``` - this means that they "belong" to the class. If you want to get a public static variable from a class, you could do something like this:

```java
class Main {
  public static void main(String[] args) {
    System.out.println(Pie.crust);
	System.out.println(Pie.pieFilling);
	System.out.println(Pie.diameter);
  }
}
```

Great! Now, let's run a method from this class, called ```pieIsBaked()```:

```java
class Main {
  public static void main(String[] args) {
    Pie.pieIsBaked();
  }
}
```

Excellent! We can see that our recipe is written just as expected!

When you get a static value directly from the class, you are essentially getting something from the "Recipe." What if you wanted to change the recipe?

```java
class Main {
  public static void main(String[] args) {
    System.out.println(Pie.crust);
	Pie.crust = "graham cracker";
	System.out.println(Pie.crust);
  }
}
```

Congrats - you've just changed the recipe! This means that from now on, anyone who uses your recipe to make your pies will no longer make a pie with "filo dough", but instead "graham cracker"!

So, let's make our first pie!

When we make an object from a class, we are said to **instantiate** it. This means that we are creating an object of type Pie, storing it in memory, and assigning it to a variable. With this class, you can now create a new pie in the ```public static void main(String[] args)``` method of the ```Main``` class:

```java
public class Main {
	public static void main(String[] args) {
		Pie myPie = new Pie();
	}
}
```

We can say that ```myPie``` is an instance of class ```Pie```. Instances and Objects are synonymous.

See that keyword ```new```? We've used it before when making ```Scanner``` objects, or objects of type ```Scanner```.  

```java
Scanner scanner = new Scanner(System.in);
```

All we are doing in that statement, is declaring a variable called ```scanner```, of type ```Scanner```, and assigning it a value of a new ```Scanner```, stored in memory, that can do everying a ```Scanner``` can do.

Okay, that was a lot. Here's a puppy:

<img src="https://lh6.ggpht.com/6ImJ_VXb8j__VcEYENFrNO-5dMPfUldZ4csUsCAuBRVZ9jfA2Xkel32MvWwRyWAmmbs=w300" alt="A fun puppy." style="width:300px;height:300px;">

Now, back to Classes and objects....

Let's revisit our pie analogy. When we instantiate an object from a class type, the object we create will have all the methods, variables, and their values, assigned to the class from which they are instantiated.

```java
public class Main {
	public static void main(String[] args) {
		Pie myPie = new Pie();
		System.out.println(Pie.pieFilling);
		System.out.println(myPie.pieFilling);
	}
}
```

We can see that the values are exactly the same!

However, as a baker, you don't want people having access to your recipe. What if they change a value, and do things you don't want?

This is why we should always make our class variables ```private```, and create ```public``` methods within the class to give them to us:

```java
class Pie {

private static String crust = "filo dough";
private static String pieFilling = "cherry";
private static int diameter = 12;

public static String getCrust() {
	return crust;
}

public static String getPieFilling() {
	return pieFilling;
}

public static int getDiameter() {
	return diameter;
}

public static void pieIsBaked() {
	System.out.println("I am a " + pieFilling + " pie!");
}
```

This is great! This allows us to keep variables private (we can keep our recipe secret), and prevents other cooks from changing our recipe! But as a baker, we might not want to make a cherry pie every time we make a pie. Also, when people come into our shop - we're not in the business of selling recipes, we're in the business of selling pies.

The first step is to get rid of all the static keywords from our variables/methods - we will keep them non-static, so that even though our pies are modeled after the recipe, we'll still be allowed to change our pies when we create them, without having to change the original recipe every time.

```java
class Pie {

private String crust = "filo dough";
private String pieFilling = "cherry";
private int diameter = 12;

public String getCrust() {
	return crust;
}

public String getPieFilling() {
	return pieFilling;
}

public int getDiameter() {
	return diameter;
}

public void pieIsBaked() {
	System.out.println("I am a " + pieFilling + " pie!");
}
```

Excellent! Other cooks can no longer read the original recipe, or change it! People can still find out what the ingredients are - but only from the pies themselves, and not the recipe that was used to create them.

This is great! But we still haven't solved the problem of creating a pie, on-the-fly, that's either the same or different from the recipe.

So, how do we do that? By using something called a constructor.

You've done well so far - here's a kitten:

<img src="https://50-best.com/images/cute_kitten_pictures/thumbs/1-3.jpg" alt="A fun kitten." style="width:300px;height:300px;">

Now, back to Constructors....

A constructor is a special kind of method that, when called, creates an object. All classes have them - whether you write them yourself or not.

We've already used a constructor before! We called a constructor method previously, when creating a pie:

```java
Pie pie = new Pie();
```

As you can recall, we never wrote a method called ```Pie()```. That's because Java wrote it for us! This is called the **default constructor** - this comes automatically, with every class we write. However, we can also write our own constructors ourselves, that let us set the values of our class's variables **during instantiation**.

So let's write our own constructor! We can write a constructor that, when called, not only creates a new object, but assigns values to its variables, with arguments passed through parameters!

```java
class Pie {

private String crust = "filo dough";
private String pieFilling = "cherry";
private int diameter = 12;

public Pie(String chefChoiceCrust, String chefChoicePieFilling, int chefChoiceDiameter) {
	crust = chefChoiceCrust;
	pieFilling = chefChoicePieFilling;
	diameter = chefChoiceDiameter;
}

public String getCrust() {
	return crust;
}

public String getPieFilling() {
	return pieFilling;
}

public int getDiameter() {
	return diameter;
}

public void pieIsBaked() {
	System.out.println("I am a " + pieFilling + " pie!");
}
```

We wrote a constructor, that's the exact name of the class, made sure it was public, then used it to reassign values of our field variables to whatever the baker passes into the parameters!

You'll notice that we placed the constructor between the variables, and the other methods in the class. Typically, the order is as follows:
* import statements (none in this example, but they would be at the top, above and outside classes)
* class name
* field variables (inside the class)
* contructors (below the variables, inside the class)
* methods (below the constructor, inside the class)

Okay, let's make a rhubarb pie this time:

```java
class Main {
  public static void main(String[] args) {
    
    Pie rhubarbPie = new Pie("sourdough", "rhubarb", 12);
    rhubarbPie.pieIsBaked();
		
  }
}
```

Success! We have created a new pie, and it is rhubarb this time and not a cherry, like the recipe says!

Just for old times sake, let's make a good old fashioned cherry pie like before as well:

```java
class Main {
  public static void main(String[] args) {
    
    Pie rhubarbPie = new Pie("sourdough", "rhubarb", 12);
    rhubarbPie.pieIsBaked();

	Pie cherryPie = new Pie();
		
  }
}
```

Oh no! We got an error! This is because once you create your own constructor, the one Java originally created for you disappears! But don't worry - we can make our own default constructor!

```java
class Pie {

private String crust = "filo dough";
private String pieFilling = "cherry";
private int diameter = 12;

public Pie() {

}

public Pie(String chefChoiceCrust, String chefChoicePieFilling, int chefChoiceDiameter) {
	crust = chefChoiceCrust;
	pieFilling = chefChoicePieFilling;
	diameter = chefChoiceDiameter;
}

public String getCrust() {
	return crust;
}

public String getPieFilling() {
	return pieFilling;
}

public int getDiameter() {
	return diameter;
}

public void pieIsBaked() {
	System.out.println("I am a " + pieFilling + " pie!");
}
```

We added a default empty constructor, so if anyone instantiates a pie, without passing in any arguments to parameters, they'll get a cherry pie, just like the original recipe stated it to be! And now we have the opportunity to instantiate different types of pies whenever we want, based on the recipe, but with little tweaks here-and-there, to add variety and flexibility - without ever having to change the original recipe!

So, there is one thing we can do to make our code better. It won't change the way things look on the screen, but it will make our code cleaner.

In the default constructor, we can actually call the other constructor, and fill it with the assignments we originally initialized our variables with:

```java
class Pie {

private String crust;
private String pieFilling;
private int diameter;

public Pie() {
	this("filo dough", "cherry", 12);
}

public Pie(String chefChoiceCrust, String chefChoicePieFilling, int chefChoiceDiameter) {
	crust = chefChoiceCrust;
	pieFilling = chefChoicePieFilling;
	diameter = chefChoiceDiameter;
}

public String getCrust() {
	return crust;
}

public String getPieFilling() {
	return pieFilling;
}

public int getDiameter() {
	return diameter;
}

public void pieIsBaked() {
	System.out.println("I am a " + pieFilling + " pie!");
}
```

By using the ```this``` keyword, we are essentially telling Java that when this constructor with no arguments is called, in this instance of the object, use the other constructor that has these parameters, of these types.

Alright. That was a ton. Here's a hamster eating a burrito:

<img src="http://media.npr.org/assets/img/2014/05/02/hamster2-2-_sq-d6aa1e96272a334e54fb3c29b6d9b90ac4e4862d-s300-c85.jpg" alt="A fun hamster." style="width:300px;height:300px;">

What we did was called **Overloading**, in that we had several different constructors, and Java was able to tell them apart - even though they had the same name, because their parameters are different. Programmers use method overloading all the time, to perform similar tasks, with different inputs.

Another thing we learned was the keyword ```this```. The ```this``` keyword is used to refer to the instance of the class being instantiated. In other words, we are saying that these rules only apply to the object we've just created, and nothing more.

#### Getters and Setters

So, we've seen **getter** methods before - we created public methods that return the values of our private field variables. And we set, or **initialized** our field variables with a **constructor** at **instantiation**. 

```java
class Pie {

private String crust;
private String pieFilling;
private int diameter;

public Pie() {
	this("filo dough", "cherry", 12);
}

public Pie(String chefChoiceCrust, String chefChoicePieFilling, int chefChoiceDiameter) {
	crust = chefChoiceCrust;
	pieFilling = chefChoicePieFilling;
	diameter = chefChoiceDiameter;
}

public String getCrust() {
	return crust;
}

public String getPieFilling() {
	return pieFilling;
}

public int getDiameter() {
	return diameter;
}

public void pieIsBaked() {
	System.out.println("I am a " + pieFilling + " pie!");
}
```

However, there may be times when you'll have to change the values of variables within an object, after it has been instantiated. In these cases, we can use **setter** methods:

```java
class Pie {

private String crust;
private String pieFilling;
private int diameter;

public Pie() {
	this("filo dough", "cherry", 12);
}

public Pie(String chefChoiceCrust, String chefChoicePieFilling, int chefChoiceDiameter) {
	crust = chefChoiceCrust;
	pieFilling = chefChoicePieFilling;
	diameter = chefChoiceDiameter;
}

public String getCrust() {
	return crust;
}

public String getPieFilling() {
	return pieFilling;
}

public int getDiameter() {
	return diameter;
}

public void setCrust(String newCrust) {
	crust = newCrust;
}

public void setPieFilling(String newPieFilling) {
	pieFilling = newPieFilling;
}

public void setDiameter(int newDiameter) {
	diameter = newDiameter;
}

public void pieIsBaked() {
	System.out.println("I am a " + pieFilling + " pie!");
}
```

As you can see, these methods are ```void```, because they do not return anything, but instead do things to our field variables. This is weird for this example, but we can use a **setter** method to essentially suck out the filling, and replace it with a new filling:

```java
class Main {
  public static void main(String[] args) {
    
    Pie cherryPie = new Pie();
	cherryPie.pieIsBaked();
	cherryPie.setPieFilling("Sour Cherry");
	cherryPie.pieIsBaked();
  }
}

Huzzah! We have just bizzarly sucked out the old filling, and replaced it with a new one! Congrats!
