# DS&A - OOP Practice

## Objectives

* Review Object Oriented Priniciples
* Introduce the concept of Pair/Peer Programming
* Simulate an actual live coding challenge
* Use your coding skills to create something fun

# Lecture

Up until now, you've mostly been working on either simple, seemingly pointless things, or complicated, abstract things which seem to have no real-world use. That makes sense. You're not a bad programmer for feeling like apps shouldn't just be variables, logic, loops, methods, parameters, data storage, classes, Strings, numbers, reading input values, displaying output values, and interfaces. But....

### Surprise! That's all coding in Java is though!!!

![Surprise Keanu](https://i.kym-cdn.com/entries/icons/mobile/000/007/630/conspiracykeanu.jpg)

Everything else we'll be learning from now on, will either be ways to make our jobs easier, make our code shorter, manipulate different forms of input, or make our output faster or prettier! That's it!

When interviewing for jobs, you'll eventually reach a point when you'll be asked to participate in a coding challenge. There are three forms of coding challenges:

* Project Submission, where you'll be required to make an actual program from scratch
* Whiteboarding, where you'll be asked to answer a coding question either on a whiteboard, or online
* or some combination of the two

Today we will perform the first one in class - Project Submission!

We will - as a class, create a game from scratch, using all the skills we've learned since launch. This game will be called `PathFinder`.

Fellows will come up, one-by-one, to pair/peer program with the instructor. This means that we will be working together, as a team, to reach our goals. The goal of this game is to create output and user interaction similar to the output below:

```
######                      #######
#     #   ##   ##### #    # #       # #    # #####  ###### #####
#     #  #  #    #   #    # #       # ##   # #    # #      #    #
######  #    #   #   ###### #####   # # #  # #    # #####  #    #
#       ######   #   #    # #       # #  # # #    # #      #####
#       #    #   #   #    # #       # #   ## #    # #      #   #
#       #    #   #   #    # #       # #    # #####  ###### #    #

Instructions:

This game is called 'PathFinder'. The goal of this game is to reach the end of the path, 100 tiles.
You start at the first tile, then press enter to roll.
You can roll any number from 1 to 10 - then move that number of tiles forward.
If you roll a 7, you get to move 7 tiles, plus a random roll between 1 an 10.
If you roll a 10, you move back a random roll from between 1 and 10.
If the random roll is greater than your current tile, you move back to the first tile.
Good luck!

Current tile: 1
Tiles to go: 99

Press 'enter' to roll...

You've rolled a 1!
Current tile: 2
Tiles to go: 98

Press 'enter' to roll...

You've rolled a 9!
Current tile: 11
Tiles to go: 89

Press 'enter' to roll...

Great luck! You've rolled a 7! Move forward your roll, plus 9 extra spaces!
Current tile: 27
Tiles to go: 73

Press 'enter' to roll...

You've rolled a 8!
Current tile: 35
Tiles to go: 65

Press 'enter' to roll...

Great luck! You've rolled a 7! Move forward your roll, plus 2 extra spaces!
Current tile: 44
Tiles to go: 56

Press 'enter' to roll...

You've rolled a 1!
Current tile: 45
Tiles to go: 55

Press 'enter' to roll...

Great luck! You've rolled a 7! Move forward your roll, plus 7 extra spaces!
Current tile: 59
Tiles to go: 41

Press 'enter' to roll...

You've rolled a 9!
Current tile: 68
Tiles to go: 32

Press 'enter' to roll...

You've rolled a 4!
Current tile: 72
Tiles to go: 28

Press 'enter' to roll...

You've rolled a 2!
Current tile: 74
Tiles to go: 26

Press 'enter' to roll...

You've rolled a 2!
Current tile: 76
Tiles to go: 24

Press 'enter' to roll...

You've rolled a 9!
Current tile: 85
Tiles to go: 15

Press 'enter' to roll...

Oh no! You've rolled a 10! Move back 1 spaces!
Current tile: 84
Tiles to go: 16

Press 'enter' to roll...

Great luck! You've rolled a 7! Move forward your roll, plus 4 extra spaces!
Current tile: 95
Tiles to go: 5

Press 'enter' to roll...

You've rolled a 3!
Current tile: 98
Tiles to go: 2

Press 'enter' to roll...

You've rolled a 9!
Congrats! You've reached the end of the path!

Play Again? [Y/n]: n

Goodbye! Thanks for playing 'PathFinder'!

Process finished with exit code 0
```

We will try to complete this game in under 3 (three) hours. Code challenges are often time-boxed, meaning you will have a limited amount of time to complete your project, and submit it by a deadline.

So, what are we waiting for? Let's do this!

![Engage!](https://percolatorconsulting.com/wp-content/uploads/2018/06/2c0zzs.jpg)
