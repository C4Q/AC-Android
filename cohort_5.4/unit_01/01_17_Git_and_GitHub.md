# Git and GitHub

## Objectives

* Fellows will learn how to make local repositories on the command line
* Fellows will learn how to initialize repos within their working directories
* Fellows will learn how to add new or modified files from their working directory to their staging index
* Fellows will learn how to commit files from their staging index to thir local repository
* Fellows will learn how to push their local repositoy to their remote repository on Github

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

