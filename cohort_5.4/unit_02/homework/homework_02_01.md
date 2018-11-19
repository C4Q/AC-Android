# Pursuit Android 5.4 Homework 02.01

## Write a "Mad-Libs" App

### Project overview

Create an Android Application that accepts words from a user, then forms a unique story for the user based on their input. For example:

```
Enter Your Character's Name: Shannon
Enter Your Character's Profession: Warrior
Enter Your Character's Favorite Thing to Do: Fight
Enter Your Character's Favorite Tool: Battle Axe
Enter Something Delicious: Rice Crispie Treat
Enter a Type of Villain: Dragon
Enter a Type of Reward: Gold Bars
```

Should create a story like the one below:

```
One day, the Warrior Shannon was travelling through the countryside eating a Rice Crispie Treat when suddenly, a Dragon came out to attack the local farmers! Shannon jumped to the rescue to Fight with the Warrior's favorite weapon, the Battle Axe! Once the Dragon was defeated, it exploded into a giant pile of Gold Bars! The End!
```

This App should have the following functionality:

* Require that a user enter 7 (seven) different words/phrases to add to the story using EditText views
* Each input question should be in its own `Activity`
* Each input `Activity` should have a `Next` button moving it to the next `Activity`
* Once all inputs have been collected, the user should be directed to an `Activity` with the completed story displayed on the screen
* Each Activity Layout should have a different Background color, assigned randomly every time the app runs

### Requirements

This assignment is fairly open-ended, so be creative with your ideas and have fun! However, the completed submission should include each of the following requirements:
* All Input Activities should have a parent activity declared for it in the `AndroidManifest.XML` file
* All String values, View Dimensions, Color Values should be stored in their corresponding values XML files as necessary
* All Activity view values should account for Orientation changes (`onSavedInstanceState`, different layouts for Portrait/Landscape, or Locked Orienation)
* All Activity Layout Root Views should be a `ConstraintLayout`

### Additional Factors

- Your Story App should be able to run to completion without noticeable bugs or crashes.
- Code should be organized into methods and classes as appropriate to demonstrate good modularization and code reuse.
- All submitted code should be formatted as defined by the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).

This is an individual assignment, so each student will be responsible for submitting their own original Android Application.

### Fun Ideas 

* Can you make a "Splash Page" for your App
* Can you add local images to each input activity?
* Can you support stories in other Spoken Languages?
* Can your final Story `Activity` have a button that allows the user to send the story as an Email?

## Homework submission

1. Create a package called Story_App_HW_LASTNAME_FIRSTNAME (replace `LASTNAME` and `FIRSTNAME` with your own last and first name)

2. Commit and push all work and submit your repo link using the Canvas link on the calendar by **11:59pm on FRIDAY 11/30/2018**. Submitting this assignment in on time, and to completion, is expected of all participants.
