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

- At least one `if`/`else-if`/`else` type control structure.
- At least one `switch` statement.
- At least one `while` loop and one `for` loop.
- At least one `ArrayList`.
- Accept input from the user with a `Scanner` object.

This is an individual assignment, so each student will be responsible for submitting their own original game.

### Some examples

- http://play.textadventures.co.uk/Play.aspx?id=ztdzhocsh0itfnutvx06pq
- http://play.textadventures.co.uk/Play.aspx?id=khgzt68_i0cjbwogpueqdg
- http://play.textadventures.co.uk/Play.aspx?id=fjhtsi-mhuuowhhm8jluaq
- http://play.textadventures.co.uk/Play.aspx?id=gq7hi7sgpe_gldqy0xb_mq

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

2. Submit a link to the repo as a comment on [this issue](//TODO issue link pending) issue by **Saturday 9/03 at 8pm**. See the issue for more precise formatting instructions.
