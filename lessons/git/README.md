# Exercises

### I want to review from the start.

1) Read [What is Version Control?](https://www.atlassian.com/git/tutorials/what-is-version-control)

2) If you haven't already, complete [Git in 15 Minutes](https://try.github.io/levels/1/challenges/1).

3) Complete Codecademy's [Learn Git](https://www.codecademy.com/learn/learn-git) track *(you'll need to sign up for a free account)*. 

### I want to learn more about branching + committing.

1) Read [Learn Git: Using Branches](https://www.atlassian.com/git/tutorials/using-branches).

2) Complete the exercises at [Learn Git Branching](http://learngitbranching.js.org/).

### I want to improve my git workflow.

1) Read [Learn Git: Comparing Workflows](https://www.atlassian.com/git/tutorials/comparing-workflows).

2) Read about [git stash](https://www.atlassian.com/git/tutorials/git-stash). 
- Practice making some changes to a repository, stashing them and recovering them from the stash. How might stashing changes be useful in your workflow?

- You can view the contents of your stashes in Android Studio. Look up how to enable VCS tools on Android Studio. Make some changes, stash them and use Android Studio's VCS tools to inspect the line-by-line changes in the stash.

3) Read about [viewing old commits](https://www.atlassian.com/git/tutorials/viewing-old-commits). 

4) Read about [undoing changes](https://www.atlassian.com/git/tutorials/undoing-changes/git-checkout). Make some changes and add a new commit to the master branch on your old repository, then revert it.

5) Read about [using VCS tools in Android Studio](https://medium.com/@akbarsha03/version-control-system-using-git-on-android-studio-a632eb00bea9#.2jfoe083a).


### I want to get better at resolving merge conflicts.

1) Read [Dealing with Merge Conflicts](https://www.git-tower.com/learn/git/ebook/en/command-line/advanced-topics/merge-conflicts).

2) Run through two exercises to resolve a merge conflict on the command line: [this one](https://help.github.com/articles/resolving-a-merge-conflict-from-the-command-line/), then [this one](merge-conflict.md).

3) Read about [resolving merge conflicts in IntelliJ / Android Studio](https://www.jetbrains.com/help/idea/2016.2/resolving-conflicts.html). 
- Create a new Android Studio project with an empty activity.
- Initialize a git repository locally and make an initial commit (you don't need to push the repository to GitHub).
- Create and checkout a new branch called `add_button`. 
- In your new branch, make some changes to `activity_main.xml`: Change the layout to a `LinearLayout`. Delete the `TextView` and add a button to the layout with `android:id="@+id/clicky_button"` and `android:text="Click Me"`.
- Make some changes to `MainActivity.java`. In `onCreate()`, obtain a reference to `clicky_button`. Add a click listener. When the button is clicked, show a toast that displays the text "You clicked it".
- After you've tested your program and confirmed that everything is working, use Android Studio's VCS tools to add your changes and commit them with the message "Added a clicky button".
- Checkout the `master` branch. From the `master` branch, create and checkout a new branch called `add_text`.
- In your new branch, make some changes to `activity_main.xml`: delete the `TextView` and add an `EditText` to the layout with `android:id="@+id/edit_me"` and `android:hint="Edit Me"`.
- Make some changes to `MainActivity.java`. In `onCreate()`, obtain a reference to `edit_me`. Set the text to read "Write whatever you want here".
- After you've tested your program and confirmed that everything is working, use Android Studio's VCS tools to add your changes and commit them with the message "Added a place to write stuff".
- Checkout the `master` branch. Use Android Studio's VCS tools to merge the `add_button` branch into `master`. There should be no merge conflict at this point.
- Once `add_button` is merged, use Android Studio's VCS tools to merge the `add_text` branch into `master`. At this point you should be informed of a merge conflict.
- Use Android Studio's VCS tools, including the visual diff tool, to resolve the merge conflict and commit the result. The final result should display both the `Button` and `EditText` in `MainActivity.java`. Make a note of which files and lines merged automatically without conflict, and which files and lines required conflict resolution.

4) Read [some tips](https://stackoverflow.com/questions/16490873/how-to-avoid-git-conflicts-in-a-team) on avoiding [merge conflicts](http://team-coder.com/avoid-merge-conflicts/).


### I feel comfortable using git, I want to learn more about its internals.

1) Read and follow along with [Git from the inside out](https://codewords.recurse.com/issues/two/git-from-the-inside-out). Afterwards, take a look at [git implemented in one-thousand lines of JavaScript](http://gitlet.maryrosecook.com/docs/gitlet.html).

2) Check out some [Advanced Git Tutorials](https://www.atlassian.com/git/tutorials/advanced-overview).
