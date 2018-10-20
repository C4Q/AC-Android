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

Visit the [CodeCademy Git Tutorial here](https://www.codecademy.com/learn/learn-git), and complete ONLY the interactive tutorial entitled "Basic Git Workflow". It should have only 9 (nine) sections.

# Lecture

Whenever we create something from scratch using our computer, like writing an essay, it rarely ever starts out exactly the way we want it. We are more concerned with putting finger to keyboard in order to record the most important thoughts first, save it, then come back at a later date to edit it, or add more content.

Whenever we save a file, we usually save just a copy on our own computer. In the past, if we wanted to keep a copy of our original essay, wirte a new one based on the old one - we could always copy the file, and paste a new version with a new name. Now, with the advent of Google Docs, we can still do this, but share it with others as well. The other people who share access to the document might want to add their own revisions of your document, and unless they let you know beforehand, they might change something important before you can have a chance to make an additional copy. This means you have a version control problem.

### What is Version Control?

In a nutshell, version control is a framework for making sure you're able to add or modify files with new content, while also keeping copies of old documents, in case the new ones are so different, that the old versions are effectively erased. We would ahve to do this manually, by warning people to make backups before making any big changes to shared documents. A framework that does this with code is called a Version Control System, or VCS for short.

The VCS we will use in this program is called `Git`.

### What is Git?

Git is a linux-based command-line program that keeps track of the state of any file within a folder where git is initialized. We can use git to preserve our changes, and roll those changes back as we see fit. We can also use git to store our files to a remote website for sharing with others. This website is a remote repository. **Github** is just one of many websites that holds remote repositories for its users.

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

which should in tern print the following message to the screen:

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

This command should not be called without adding a human readable message associated with this commit. If you run the command `git commit` alone, it will open up a text editor like `vim`, which we actually don't need to do. We can simply run the `git commit` command with the `-m` flag, and add a simple message in double quotes:

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

To confirm that everything was commited as expected, run the `git status` command:

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

