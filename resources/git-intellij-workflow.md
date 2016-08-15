# Practicing with IntelliJ and Git

 > For the things we have to learn before we can do them,  
 > we learn by doing them. ― Aristotle

This exercise is a straightforward recipe for starting a new IntelliJ project, adding a code file, and marrying a local Git repository to a remote GitHub repository. Even if you are comfortable with your Git workflow, you should go through this and understand what is happening - and more specifically, where on your computer's hard drive and on GitHub it is happening. 

Repeat this exercise a few times, until you're comfortable. You don't have to memorize each command - that's what cheat sheets are for! - but rather, focus on understanding their relationships to the files on your computer, your development environment (IntelliJ), and GitHub.

### Create the accesscode directory in your Desktop
We will put all of our work in this directory. 

    mkdir ~/Desktop/accesscode


### Create a new IntelliJ project.
First, open IntelliJ and create a new project in your `accesscode` directory. We'll delete it after the exercise. Name it `AC_08-28` (we will keep this naming convention for all of our in class projects. The "root" folder of this project will therefore be `/Users/yourname/Desktop/accesscode/AC_08-28`, or using the `~` "home" shortcut, `~/Desktop/accesscode/AC_08-28`.

### Make a new Java class file.
In the Project Structure panel, right-click on the `src` folder and [create a new Java Class](http://i.imgur.com/FC546oQ.png).

The contents of this file aren't important, but we want to practice adding files to your repository. Just copy and paste the contents of one of your Java exercises into the new file. You can run your code if you like, to ensure that it compiles. Git doesn't care if your code works, but it's good practice to only commit functional code.

Save the file and close IntelliJ.

### Initialize Git within your project folder.
Open your Terminal. Use `cd` to navigate into the IntelliJ project your just created:

    cd ~/Desktop/accesscode/AC_08-28

Then, initialize Git in this folder.

    git init

Let's make sure that worked.

    git status

You should see a list of "untracked files", including IntelliJ's project structure, and your code files. If you ran your code, you will also see an `out/` directory and a `.class` file. *Don't add or commit anything yet!*

### Add a .gitignore.
A `.gitignore` is a file that Git understands. It is "hidden" (files beginning with a period are not shown in Finder windows, but you can list them from Terminal using `ls -a`). It is important for keeping your repository organized. Any files or directories you name in `.gitignore`, Git will avoid adding to your repository and won't show as untracked files. Create this file in the root of your new project folder:

    touch .gitignore
    open .gitignore

Type the following lines into it.

    .DS_Store
    out/
    *.class

Why these? `.DS_Store` is a hidden Mac file that contains settings for each folder, like how icons are positioned. This is irrelevant to IntelliJ or your Java code, so it has no place in your repository. `out/` and `.class` files are compiled binaries, which are generated freshly every time you Run your code, so there's no reason to store them, either.

Another hidden folder you may have noticed is `.idea`. This contains IntelliJ settings for your project. These files DO belong in version control, especially as your projects grow and become more complex, so we aren't ignoring them.

Save your new `.gitignore`. Now, do `git status` again. You'll still see untracked files, but the ignored ones aren't listed anymore.

### Add and commit.
Now we're going to make the first commit to this repository. Add all the files in this folder with the following command:

    git add .

Do `git status` again. (Seeing a pattern? `git status` is our eyes, letting us visualize what's currently going on in the repository.) All the untracked files now show up under "Changes to be committed". You haven't committed yet - this step is called "staging" and lets you review before completing the commit.

    git commit -m "Initial commit"

Git requires that you type a message to describe each commit. It is good practice to be descriptive. If you need to go back to a previous commit, these descriptions will be very valuable for telling your commits apart.

Let's make a change to the Java code file. Reopen your IntelliJ project and open your Java file.

Add a comment to the file: `// This is a test comment. I'm practicing with Git!`

Save and go back to your Terminal. `git status` again. The file you changed is now listed under "Changes not staged for commit". Let's stage it with `git add`:

    git add MyFile.java

Then make your second commit.

    git commit -m "This is my second commit, just a simple comment."

Git will respond with, `1 file changed, 1 insertion(+)`. Git can see the difference between your updated file and its previous version, and gives you a summary of the change.

You've made two commits to your local repository. Now it's time to get GitHub in on the action.

### Create a new GitHub repository.
Open a browser and go to your GitHub profile. Click on the "Repositories" tab, and then the green "New" button in the upper right.

Name your Git repository the *same name* (`AC_08-28`) as you gave your IntelliJ project above. In your real work, projects and repositories may not always have the same name, but they usually do to minimize confusion.

For the purposes of this tutorial, don't check "Initialize this repository with a README". Create the repository. From the "Quick setup" screen that follows, copy the "SSH" URL to your clipboard, which looks like:

    git@github.com:<YOUR USERNAME>/AC_08-28.git

### Add remote and push
Return to Terminal and type:

    git remote add origin <PASTE GITHUB URL>

Your local Git repository is now connected to GitHub. Time to push your commits.

    git push origin master

Refresh the page in your browser and see that GitHub has received your project.

Who's awesome? You're awesome!

### Delete your working directory
Let's play with your new superpower of having all your code mirrored online. Delete your project directory, the `Practice01` folder, from your desktop. Yup, just drag to the Trash and empty that bad boy. Your code is safe in GitHub.

### Clone from GitHub
In Terminal, `cd ~/Desktop/accesscode`.

Don't create a new folder, Git will do that for you. Just clone using the same URL you copied earlier:

    git clone <PASTE CLONE URL>

GitHub will create `AC_08-28` and copy your repository over. Use `ls` and `git status` to see that your files are present and the repository is active. Git will respond:

    On branch master
    nothing to commit, working directory clean

You don't have to `git init` again - cloning re-initializes everything just as it was since your last push.

That's it! Reopen your project in IntelliJ and see your code file intact.

*Thanks [bgun](https://gist.github.com/bgun/c7447ab0906517221b6b) for this tutorial!*
