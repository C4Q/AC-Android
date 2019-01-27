# Pursuit Android 5.4 Homework 03.02

## Create a "Notification List" App

### Project Overview

Create an Android Application that allows users to explore a scrolling list of Notifications, then send one when the choice is clicked.

This App should have the following functionality:

* a Main Activity page with a Scrolling List (`RecyclerView`) of 20 (twenty) different Notifications
* each tile should have a fun photo of your choosing, and a unique message
* a Second Activity page displaying the information from the Scrolling list contained in the tile selected (photo, message), and a button to send a Notification (`notificationManager.notify(NOTIFICATION_ID, notification)`)
* a Notification that, when clicked, brings the user back to the `MainActivity`
* if that particular Notification has already been sent, fire off a toast when the button is pressed that a notification was sent previously, and won't be sent again (`SharedPreferences`)!

### App Requirements

This assignment is fairly open-ended, so be creative with your ideas and have fun! However, the completed submission should include each of the following requirements:
* `SecondActivity` should have a parent activity declared for it in the `AndroidManifest.XML` file
* All String values, View Dimensions, and Color Values should be stored in their corresponding values XML files as necessary
* All Activity view values should account for Orientation changes (`onSavedInstanceState`, and different layouts for Portrait/Landscape)
* All Activity Layout Root Views should be a `ConstraintLayout`

### Additional Factors

- Your Notification App should be able to run to completion without noticeable bugs or crashes.
- Code should be organized into methods and classes as appropriate to demonstrate good modularization and code reuse.
- All submitted code should be formatted as defined by the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).

### Fun Ideas 

* Can you "Grey Out" the Scrolling List tile to let users know it has already been clicked?
* Can you support Notifications in other Spoken Languages?
* Can you make your Scrolling List vertical in Portrait mode, and Horizontal in Landscape mode?

## Homework submission

1. Create a package called Notification_App_HW_LASTNAME_FIRSTNAME (replace LASTNAME and FIRSTNAME with your own last and first name)

2. Commit and push all work and submit your repo link using the Canvas link on the calendar by **11:59pm on FRIDAY 01/18/2019**. Submitting this assignment on time, and to completion, is expected of all participants.
