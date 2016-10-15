# Memory Game

### Project Overview

In this project, you'll be building a memory game for Android similar to <a href="https://en.wikipedia.org/wiki/Simon_(game)">Simon</a>, a popular electronic game from the 70s and 80s.

![memory game](http://www.neatstuff.net/games/Simon.JPG)

The memory game has four colored buttons, each flashing or "lighting up" when it is pressed or activated by the app. Each round in the game consists of the app lighting up one or more buttons in order, after which the player must press the buttons in the same order to advance to the next round. 

For each new round, the app will light up the buttons in the same order as in the previous rounds, then add a new randomly selected button to the end of the sequence. The number of buttons that light up and then must be pressed is always equal to the current round number.

Download [CopyCat - Simon Says Game (Android)](https://play.google.com/store/apps/details?id=com.jgames.shapegame&hl=en) or [Simon - iOS](https://itunes.apple.com/us/app/simon-vintage-electronic-game/id909886468?mt=8) for an example of a memory game app.

##### Wireframe

The app will feature four colored Buttons and a TextView indicating the current round. The color, position, style and design of the UI elements are up to your team to decide.

<img src="image/memory_game.png" width="250">

##### Text example of gameplay flow:

```
Y = Yellow Button  
R = Red Button  
G = Green Button  
B = Blue Button  

Game starts...

Round 1:
App lights up : Y
Player presses: Y

Round 2:
App lights up : Y R
Player presses: Y R

Round 3:
App lights up : Y R B
Player presses: Y R B

Round 4:
App lights up : Y R B Y
Player presses: Y R B Y

Round 5:
App lights up : Y R B Y G
Player presses: Y R B Y Y

Player loses because they pressed Y instead of G!
```

### Basic Requirements
- Must not crash during demo.
- Save and restore instance state (e.g. if the app goes into the background).
- Handle configuration changes and activity lifecycle.

### Feature Requirements
- A single activity with a layout that includes four Buttons, one in each corner of the screen (colored red, green, blue and yellow), and a TextView that displays the current round number.
- Show a Toast at the beginning of the game that instructs the Player to watch the button pattern and repeat.
- For each round, activate the buttons in order (try changing the button color for a short amount of time using a Timer to simulate the button "lighting up").
- For each round, record the order that the player presses the buttons and compare it to the correct order. If the orders do not match, the player loses the game.
- Show a Toast when the player loses the game and start over with a new game.

### Bonus Feature Ideas
- Create a [splash screen](https://www.bignerdranch.com/blog/splash-screens-the-right-way/) welcoming users to the game.
- Create a [settings screen](https://developer.android.com/guide/topics/ui/settings.html) where the user can customize button colors or jump to a higher level.
- Add sound and/or a creative button animation.
- Add the ability for a player to save games.
- Add a fun <a href="https://en.wikipedia.org/wiki/Easter_egg_(media)">easter egg</a> that can be unlocked by tapping a special button pattern.

### Feeling stuck? Here are some ideas to get started...
- Start by building the activity's layout XML with the four Buttons and TextView round number display. Run the app to confirm that the layout looks right. When you're ready, start wiring it to your Java code with `findViewById()`.
- Consider how you will choose which random button to light up during each new round. How will you "remember" the order of buttons from previous rounds so that the same pattern will be repeated for each new round? Think about what data structure (e.g. Array, ArrayList, HashMap, etc...) would be best to hold this information. 
- Try building out the logic of the game first as a Java app (similar to the gameplay example above). For each round, use `System.out.println()` to print the button pattern and Scanner to accept an input pattern from the player. If the patterns don't match, the player loses! Once your Java app is complete, copy the code over and modify it to work in an Android project.

### Submission

Students will work in **teams of two** to complete this project over the next week. All code should be completed, pushed and merged by **10/1 at 9pm**. Check Slack for the submission form link.
