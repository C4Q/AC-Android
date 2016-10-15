# Write a text-based game

### Project overview

Write a command line tool that leads the user through a text-based adventure.

The way text-based games work usually goes something like this:

1. Program begins by printing some text that provides the user with a little context and a starting point for the adventure. Prompts user to input first move and waits for user to input text. 
2. Program accepts input text and prints more text that tells the user what happened based on their action. 
3. Repeat.

Example:

```
You wake up and find yourself in a room so dark that you can't see anything. You hear a strange noise on the other side. Do you want to investigate it? (Y or N)
> Y

You walk closer to the sound. As you approach it, you feel something drip from the ceiling on your shoulder. Keep going?
> Y

You keep walking. Suddenly the floor disappears in front of you and you fall into a pit and perish. GAME OVER!!!
```

### Requirements

This assignment is fairly open-ended, so be creative with your game ideas and have fun! However, the completed submission should include each of the following requirements:

- Accept input from the user with a `Scanner` object.
- At least one `if`/`else-if`/`else` type control structure and one `switch` statement.
- At least one `while` loop and one `for` loop.

### Additional factors

- Your game should be able to run to completion without noticeable bugs or crashes.
- Code should be organized into methods as appropriate to demonstrate good modularization and code reuse.
- All submitted code should be formatted as defined by the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).

This is an individual assignment, so each student will be responsible for submitting their own original game.

### Some examples

- [Internet Archive: Supernova (1987)](https://archive.org/details/msdos_Supernova_1987)
- [Internet Archive: Hamurabi (1996)](https://archive.org/details/msdos_Hamurabi_1996)
- [Internet Archive: The Hobbit (1983)](https://archive.org/details/msdos_Hobbit_The_1983)
- [Internet Archive: The Treasury of Zan (1989)](https://archive.org/details/treasury-of-zan)

### Fun ideas 

- Try using some ASCII art in your prompts (there are lots of image to ASCII converters online)
- Try making a map of the area and have the user navigate through it. Maybe there are hidden surprises along the way...

Example:

```
     [ ]--[ ]
      |
[X]--[ ]--[ ]
```

- Can you make an entire story [using just emoticons](http://hexascii.com/japanese-emoticons/)?

## Homework submission

1. Create a package in your ~/Desktop/accesscode directory (like we did today) called HW_09-03. Run through the Git workflow like we did earlier today: [Git + IntelliJ workflow](../resources/git-intellij-workflow.md). Create the GitHub repo but DON'T DELETE IT AND RE-CLONE IT. That was just an exercise.

2. Commit and push all work and submit your repo link using [this Google Form](https://docs.google.com/forms/d/e/1FAIpQLSfIjF1z3R9A1_5eAt0ctMsI_jlLtWV1CTHHljqI7A4Xr_juEA/viewform) by **8pm on Saturday 9/3**.
