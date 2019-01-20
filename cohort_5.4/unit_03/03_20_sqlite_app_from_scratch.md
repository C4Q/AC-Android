# SQLite "App From Scratch"

## Objectives
* Fellows will attempt to follow steps within a mock coding challenge
* Fellows will demonstrate this step in front of the class with the instructor

## Resources
* [RecyclerView Review](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_02/02_20_recyclerview_review.md) 
* [SQLite and SQLiteOpenHelper](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_03/03_16_sqlite_%20and_sqliteopenhelper.md)
* [Retrofit and SQLiteOpenHelper Project](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_03/projects/DogBreedsSQLite.zip)

# Lecture

Today we will build an "App From Scratch", for time. The goal of today's lesson is to get you used to completing code challenges within a certain amount of time, so that:
* you may be able to complete assessments within the time allotted
* you may be able to complete coding challenges within the time allotted

For our previous "App from Scratch" challenge, we worked with receiving data from a JSON Endpoint, then passing it into a RecyclerView. This challenge will involve creating an app that will accept data from a user, save it to a database, then display that data in a RecyclerView.

The tasks are as follows:

### Open a new Android Studio Project (10 Minutes)
Open up a new Android Studio Project, using an Empty Activity.

### Make data model class(es) based on how we want our Rows to store Data (10 Minutes)
Consider a note, which is meant to be unique, then structure a class to contain the note's contents.

### Create Singleton Class for Subclassed SQLiteOpenHelper Instance (10 Minutes)
Create a Singleton class using the Static Factory Method design pattern, to contain a unique single instance of the Subclassed SQLiteOpenHelper class.

### Create Methods for adding and getting Data from the Database Table (10 Minutes)
Create methods which allow a user to add a note, and allow a user to get all the notes saved in the database table.

### Create a Main Activity (20 Minutes)
Create an Activity with two buttons: one that moves to a Note Submission Activity, and another that moves to a Note Display RecyclerView Activity.

### Create a Note Submission Activity (20 Minutes)
Create an Activity with an EditText to enter a note, and a button which will add the note to the database table. It should fire off a toast letting the user know that the note was added.

### Create a Note Display Activity (20 Minutes)
Create an Activity with a RecyclerView, which is intended to display the data from all the rows in the database table.

### Subclass a RecyclerView ViewHolder Class, with corresponding ItemView XML Layout (20 Minutes)
Create a ViewHolder class, which references the views declared in an ItemView XML Layout.

### Subclass a RecyclerView Adapter Class (20 Minutes)
Create an Adapter class, which overrides all inherited methods, and binds the list data passed to it to the appropriate views as needed.

### Add a RecyclerView that fills the screen, and populate it with data from the Database Table (20 Minutes)
Add a RecyclerView to your activity, then pass a list of data to it, the list received from the Database Table.

## Exercises
Push this project to Github, then submit the link to the exercises page on the canvas calendar for today's date.
