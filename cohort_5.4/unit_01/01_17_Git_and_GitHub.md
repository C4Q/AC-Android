# Git and GitHub

## Objectives

* Fellows will learn how to make local repositories on the command line
* Fellows will learn how to initialize repos within their working directories
* Fellows will learn how to add new or modified files from their working directory to their staging index
* Fellows will learn how to commit files from their staging index to thir local repository
* Fellows will learn how to push their local repository to their remote repository on Github

## Resources

* [CodeCademy Git Tutorial](https://www.codecademy.com/learn/learn-git)
* [Reasons to Learn Git: try.github.io](https://try.github.io/)
* [Book - Pro Git](https://git-scm.com/book/en/v2)
* [Video - Git for Beginners Video Playlist](https://www.youtube.com/watch?v=_Jmkvv_nKTE&list=PLwrxhoDq6Kivqmc3jbqZhQnTuuv8odAdy)

## Warm Up - Do This First! (60 minutes)

Visit the [CodeCademy Git Tutorial here](https://www.codecademy.com/courses/learn-git/lessons/git-workflow/exercises/hello-git), and complete ONLY the interactive tutorial entitled "Basic Git Workflow". It should have only 9 (nine) sections.

# Lecture

Whenever we create something from scratch using our computer, like writing an essay, it rarely ever starts out exactly the way we want it. We are more concerned with putting finger to keyboard in order to record the most important thoughts first, save it, then come back at a later date to edit it, or add more content.

Whenever we save a file, we usually save just a copy on our own computer. In the past, if we wanted to keep a copy of our original essay, and write a new one based on the old one - we could always copy the file, and paste a new version with a new name. Now, with the advent of Google Docs, we can still do this, but share it with others as well. The other people who share access to the document might want to add their own revisions of your document, and unless they let you know beforehand, they might change something important before you can have a chance to make an additional copy. This means you have a version control problem.

### What is Version Control?

In a nutshell, version control is a framework for making sure you're able to add or modify files with new content, while also keeping copies of old documents, in case the new ones are so different, that the old versions are effectively erased. We would have to do this manually, by warning people to make backups before making any big changes to shared documents. A framework that does this with code is called a Version Control System, or VCS for short.

The VCS we will use in this program is called `Git`.

### What is Git?

Git is a linux-based command-line program that keeps track of the state of any file within a folder where git is initialized. We can use git to preserve our changes, and roll those changes back as we see fit. We can also use git to store our files to a remote website for sharing with others. This website is a remote repository. **Github** is just one of many websites that can hold remote repositories for its users.

### How do we set up Git on our Computers?

If you are using a Linux or MacOS device, git should already be installed. You can check if git is installed, and which version is currently installed, by running the following command in Bash:

```bash
git --version
```

If you are using a Windows device, you should instead install Git Bash, and use that as a way to run git from the command line.

One of the first things you'll need to do is set up your git environment - meaning you'll have to tell git what your git email address is, and your name. For your email address, you should use the same email address you used to open up your Github account. For example:

```bash
git config --global user.email johndoe@example.com
```

and for your name:

```bash
git config --global user.name "John Doe"
```

Once this is completed, you can confirm that the information was added correctly by calling the commands `git config --global user.email` and `git config --global user.name` resepectively, and confirming that their output on the screen is expected.

### How do we maintain Version Control with Git?

First, let's open up Bash, and type in this command:

```bash
cd ~
```

This will ensure that we are in our computer's home directory. Next, let's move to our `Desktop`:

```bash
cd Desktop
```

Once there, let's create a folder called `text_files`, and change into this directory:

```bash
mkdir text_files
cd text_files
```

Now that we are currently in the `text_files` directory, let's make a few new files, and add text to them:

```bash
echo "Chapter 01: It was a dark and stormy night." >> chapter_01.txt
echo "Chapter 02: It was the best of times, it was the worst of times." >> chapter_02.txt
echo "Chapter 01: Call me Ishmael." >> chapter_03.txt
```

Now, if we were to call the `ls -top` command in the `text_files` directory, we'd see the following output:

```bash
chapter_01.txt
chapter_02.txt
chapter_03.txt
```

and if we were to run the command `cat chapter_01.txt`, we'd see the text inside the file printed to the screen:

```
Chapter 01: It was a dark and stormy night.
```

Now that the files are created, let's explore how git works in greater detail.

### How do we create a Git Repository?

In the `text_files` directory, we must let git know that we want to track the contents of the directory by running the following command:

```bash
git init
```

which should in turn print the following message to the screen:

```
Initialized empty Git repository in /home/eutherian/Desktop/text_files/.git/
```

Now, whenever we add to this directory, or modify any of the files within this directory, git will know, and complain that these files are `untracked`, meaning these changes haven't been saved to our local repository.

Git sees this repository has having 3 (three) main states:

* Working Directory: where changed files reside, but have not been added to the staging index
* Staging Index: a holding place where changed files are added, to confirm that they will be "commited" to the local repository
* Local Repository: where changed files are saved based on a certain commit hash, with a specific commit message

Please see the illustrated example below:

![git workflow](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_01/images/basic_local_git_workflow.png)

To see the state of our current repository, run the following command:

```bash
git status
```

Which should provide the following output:

```
On branch master

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)

	chapter_01.txt
	chapter_02.txt
	chapter_03.txt

nothing added to commit but untracked files present (use "git add" to track)
```

As we can see, we have files in this directory that we should track. These files are in the color **red**:


Let's add our files from the **Working Directory**, to the **Staging Index**:

```bash
git add chapter_01.txt
git add chapter_02.txt
git add chapter_03.txt
```

If we run the `git status` command again, we'll see that the files have now changed color from **red** to **green**, as they have shifted from being untracked in the working directory, to being tracked in the staging index:

```
On branch master

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)

	new file:   chapter_01.txt
	new file:   chapter_02.txt
	new file:   chapter_03.txt
```

Before we can save these files officially in our local repository, we'll have to call the following command:

```
git commit
```

This command should not be called without adding a human-readable message associated with this commit. If you run the command `git commit` alone, it will open up a text editor like `vim`, which we actually don't need to do. We can simply run the `git commit` command with the `-m` flag, and add a simple message in double quotes:

```bash
git commit -m "initial commit"
```

Now, if we run the `git status` command again, we'll see the following output:

```
[master (root-commit) ddf0b4d] initial commit
 3 files changed, 3 insertions(+)
 create mode 100644 chapter_01.txt
 create mode 100644 chapter_02.txt
 create mode 100644 chapter_03.txt
```

To confirm that everything was commited as expected, that everything has been commited from the **Staging Index** to the **Local Repository**, run the `git status` command:

```
On branch master
nothing to commit, working tree clean
```

If we wanted to see a list of all the commits made to this repository, we could run the `git log` command, which would provide the following output:

```
commit ddf0b4da37981f655d9b4d085806785ebbf77683 (HEAD -> master)
Author: John Doe <johndoe@example.com>
Date:   Fri Oct 19 23:33:37 2018 -0400

    initial commit
```

Great! Things have worked as expected!

### How do we post our Local Repository to Github?

First, we should clarify that we are making a **Public Repository**, meaning anyone on Github will be able to see it. For now, this is a good thing - since we are not creating proprietary software. However, since it is public, we should probably create an introduction, to give those who stumble upon our repository on Github some context.

This means we will have to create a `README.md` file at the root directory level of our repository - in this case the root directory for our repository is `text_files`. Let's make this file now:

```bash
touch README.md
```

You'll notice that the extension of this file is `.md`, indicating that this is a **Markdown** file. This means that it is readable as a static website page on Github, which uses the Markdown format to display text to the screen. Let's open up this file in `nano`:

```bash
nano README.md
```

and add the following text:

```
# The Text Files Project

This is a README.md file for the repository `text_files`, containing the following files (using a bulleted list):
* chapter_01.txt
* chapter_02.txt
* chapter_03.txt

This is the same content, but in the form of a numbered list:
1. chapter_01.txt
1. chapter_02.txt
1. chapter_03.txt

### Random Code Section

This is an example of a code block:

	```java
	class Main {
	    public static void main(String[] args) {
		System.out.println("This is a block of valid Java code.");
	    }
	}
	```

Here's an image:

![puppy image](https://puppyspot-photos-prod.s3.us-west-2.amazonaws.com/breeds/219/card/500000282_medium.jpg)

Here's the clickable link to that image:

[Click this link for the puppy image!](https://puppyspot-photos-prod.s3.us-west-2.amazonaws.com/breeds/219/card/500000282_medium.jpg)

And here's an indented text block:
> "'You miss 100% of the shots you don't take. - Wayne Gretzky' - Michael Scott"
```

If you'd like more info on Markdown formatting, [click this link for a great resource!](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)

Once you've added the text to the README.md file in `nano`, save the file. Then run `git status`, to see the file in the working directory:

```
On branch master
Untracked files:
  (use "git add <file>..." to include in what will be committed)

	README.md

nothing added to commit but untracked files present (use "git add" to track)
```

Run this command to add the new file to the staging index:

```bash
git add README.md
```
then commit that file to your local repository:

```bash
git commit -m "add README.md file to repository"
```

Now, let's set up a remote repository on Github. First, login to your Github account on the Github website, then select the `profile` tab, followed by the `repositories` tab.

Next, click on the green `New` button on the right-hand side of the screen.

A new page will appear. In the `repository name` box, enter the following name:

```
The_Text_Files_Project
```

Under description, add this text:

```
This is a README.md file for the repository "text_files"
```

Once this is done, click on the green `Create repository` button. Once pressed, the remote repository will have been created. It will redirect to a new page, which will have 4 (four) different command blocks it will ask you to choose from:

* `Quick setup — if you’ve done this kind of thing before`
* `…or create a new repository on the command line`
* `…or push an existing repository from the command line`
* `…or import code from another repository`

Since we already have an existing repository, we will copy and paste the following commands into the command line:

```
git remote add origin https://github.com/JohnDoe/The_Text_Files_Project.git
git push -u origin master
```

**Note:** The first command will be different when you do it, since it will be from your Github account's repository.

Once this is done, you'll be prompted to enter your Github email address and password, then it will push the files commited to your local repository, up to your remote repository:

```
Username for 'https://github.com': johndoe@example.com
Password for 'https://johndoe@example.com@github.com': 
Counting objects: 8, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (6/6), done.
Writing objects: 100% (8/8), 1.13 KiB | 1.13 MiB/s, done.
Total 8 (delta 1), reused 0 (delta 0)
remote: Resolving deltas: 100% (1/1), done.
remote: 
remote: Create a pull request for 'master' on GitHub by visiting:
remote:      https://github.com/JohnDoe/The_Text_Files_Project/pull/new/master
remote: 
To https://github.com/JohnDoe/The_Text_Files_Project.git
 * [new branch]      master -> master
Branch 'master' set up to track remote branch 'master' from 'origin'.
```

Refresh the page on Github, and you should [see something like this if you click on this link](https://github.com/JDVila/The_Text_Files_Project)

## Exercises

Today's exercises will be different, in that they involve you creating local and remote repositories FOR EVERY INTELLIJ IDEA PROJECT YOU'VE WORKED ON IN CLASS.

* Look into adding `.gitignore` files to your repo for `.dstore` and `.idea` files and folders
* be creative with your `README.md` files, by adding fun images, headings, and text
* `clone` the projects of other fellows in the class, to see if you can save them to your computer - start by cloning [this repository](https://github.com/JDVila/Pathfinder_text_based_game_pursuit_5_4)
* complete [this codecademy code lab](https://www.codecademy.com/courses/learn-git/lessons/git-backtracking/exercises/backtracking-intro) to explore rolling back commits
* complete [this codecademy code lab](https://www.codecademy.com/courses/learn-git/lessons/git-branching/exercises/why-branch) to explore making branches OTHER THAN MASTER
