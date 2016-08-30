##### Feeling stuck? Try reading the [Problem Solving](explanation/w1_q13.md) guide or referencing the [toolkit](../lessons/tools).

# IntelliJ project submission

1. Create a new IntelliJ project in your `~/Desktop/accesscode` directory using the naming convention `XX_MM-DD` for the project name. For in-class exercises, the **XX** characters should be substituted with **EX** and **MM-DD** should be substituted with the current date. For homework assignments, the **XX** characters should be substituted with **HW** and **MM-DD** should be substituted with the homework due date. Use `nyc.c4q.yourname` (all lowercase) for the package name.

2. Using the Terminal app, initialize git in the project home directory (in `~/Desktop/accesscode/XX_MM-DD` run `git init`).

3. Add a `.gitignore` file to the project home directory. For Java projects, it should contain at least:

    ```
.DS_Store
out/
*.class
```

3. Add and make an initial commit. From the project home directory:

    ```
git add .
git commit -m "Initial commit"
```

4. Create a [new GitHub repository](https://github.com/new). Name your Git repository the *same name* (`XX_MM-DD`) as you gave your IntelliJ project above. Don't check "Initialize this repository with a README". 

5. From the "Quick setup" screen that follows, copy the **SSH URL** to your clipboard, which looks like:

    ```
git@github.com:<YOUR USERNAME>/XX_MM_DD.git
```

6. Add remote and push. Return to Terminal and type:

    ```
git remote add origin <PASTE GITHUB URL>
git push origin master
```

    Refresh the page in your browser and see that GitHub has received your project.

7. When the assignment is complete and all commits are pushed, share the **GitHub repository URL** (begins with https://github.com...) along with your **name** and **ID** through the relevant Google Form -- check the **\#forms** channel on Slack!

# repl.it submission

1. Go to https://repl.it/languages/java. Make sure you have signed in using your GitHub account (click on the octocat icon :octocat:!).

2. Create a new session using the naming convention `MM-DD-YYYY - XX - Your Name`. The **XX** characters should be substituted with **HW** for homework assignments, **MC** for morning challenges or **EX** for in-class exercises.

    > IMPORTANT: There cannot be forward slashes (/) in your Session name!

3. When you are finished, click the 'Share' button at the top of the session, then click the octocat icon (:octocat:) to share your work to a [GitHub Gist](https://gist.github.com). 

4. Submit the **Gist URL** (begins with https://gist.github.com...) along with your **name** and **ID** through the relevant Google Form -- check the **\#forms** channel on Slack!
