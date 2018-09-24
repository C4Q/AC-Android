# Introduction to Bash

## Objectives
* Fellows will understand the benefit of Command Line Interfaces
* Fellows will learn the history of Bash Shell Scripting
* Fellows will learn the most useful Bash Commands for Software Development

## Resources

* [BaSH Cheat Sheet](https://courses.cs.washington.edu/courses/cse391/16sp/bash.html)
* [Video - Beginner's Guide to the Bash Terminal](https://www.youtube.com/watch?v=oxuRxtrO2Ag)

# Lecture

For the average computer user, interacting with the device via either a mouse or touchscreen is the primary way to interact with its software and hardware. Although a keyboard may be used, it's mostly used to enter information they can't already add with a button click. However, there is another way create, open, download, update, search, or delete files from a computer - it is know as the **Comand Line Interpreter**, or **CLI** for short.

When we typically use a mouse or trackpad to interact with a computer, we are using the Operating system's **Graphical User Interface**, or **GUI** - like Mac OS, or Windows 10. When you want to interact with the Operating System *without* the GUI, we can use a **Console User Interface**, or **CUI**. On Mac OS computers, the application **Terminal** is our CUI, and the Command Line Interpreter we use is called ***BaSH*** - or Bourne Again Shell.

### What is BaSH?

In computing, a shell is a user interface for access to an operating system's services. In general, operating system shells use either a command-line interface (CLI) or graphical user interface (GUI), depending on a computer's role and particular operation. It is named a shell because it is the outermost layer around the operating system kernel. BaSH is just one of many types of shells available for computers, and is considered a member of the POSIX family of shells (used primarily on Linux/Mac OS based operating systems), and different from Microsoft's DOS or Windows Powershell shells.

BaSH gets its name from the older shell it was based on, called the Bourne Shell, developed by Stephen Bourne at Bell Labs. Since it is an updated version of the shell, Computer Scientists decided to jokingly called it Bourne-again Shell, because reasons.

### Why use BaSH instead of a GUI?

As programmers, we use BaSH to do things that would either be too hard, too slow, or too boring to do with a mouse and a GUI. You'll find that with a few BaSH commands, you'll be able to create, manipulate, and share files over the internet in a matter of seconds, rather than drag-and-drop everything over, and over, and over, and over....

## Crash Course in BaSH

### Open the Terminal

On Mac OS computers, you can simply search for "Terminal" in the search bar followed by pressing the enter key, and the Terminal application should open immediatly.

Once opened, BaSH should run automatically. It should open up in your home directory, the one named after the user (you!). Sometimes it's named after a number, but it's still the user's home directory.

### How do I know which user I am?

In the console, simply enter this command:

`whoami`

and on the next line, the name of the user should appear.

### How do I know which directory I am in?

In the console, enter this command:

`pwd`

and on the next line, the current directory should be listed.

A directory in POSIX shells is effectively a file folder in a GUI.

### How can I see the files and folders in a directory?

If you'd like to see what files and folders are in the current directory, you can enter this command:

`ls`

This command will list all of the non-hidden files and folders in a directory. If you would like to see both hidden AND non-hidden files, you can enter this command:

`ls -a`

and on subsequent lines, you'll see a possible mix of files and folders, some of which start with a period or dot at the front. The files and folders that begin with a period or dot are considered "hidden", and would not normally be visible to users of a GUI interface without changing your folder permissions.

You might have noticed that to see the hidden files, we used an additional command, `-a`. This extra command is called a **flag**, and tells the program that is run when you call the command `ls` to show **all** the files and folders in the current directory, not just the visible ones.

The `ls` command has a number of additional flags:

* `ls -l` - show the files and folders as a list with permissions, dates, and time of creation
* `ls -r` - show files and folders in reverse alphabetical order
* `ls -t` - show files and folders in the order they were created
* `ls -p` - show which listings are directories within the directory by adding a `\` character at the end
* and so on...

If you want to know all the flags available for the `ls` command, check out [this link here](http://man.openbsd.org/ls).

### What if I want to know more about the flags, but I want to stay in BaSH?

Good question. You can enter the `man` command, followed by the command you want to know more about:

`man ls`

which will open up the **manual**  file for the command you'd like to run. It will tell you everything you need to know to get the most out of your commands. To get out of the manual page, just type the letter `q`, and you'll return to the command line.

### How to we go into another directory?
 
 When you called the `ls` command, you probably noticed a number of **Directories**. Let's move to the `Desktop` directory by using the `cd` command:
 
 `cd Desktop`
 
 which should bring you to the Desktop folder. If you enter the `pwd` command, you'll see that the directory has changed to a deeper folder. To jump back out of the current directory to the directory the current folder is in, you can use this command:
 
 `cd ..`
 
 which will bring you from the current directory, to it's parent directory - in this case, because the current directory is `Desktop`, the parent directory would be the home directory, or the directory of the user we fould when we ran the `whoami` command. If we were in another directory that was very deep in many other directories, and we wanted to jump back to our home directory without re-typing `cd ..` over and over, we could use this command:
 
 `cd ~`
 
 which would bring us back to home. If we wanted to go to our `root` directory, or the lowest directory in our file system, we could use this command:
 
 `cd /`
 
 but don't do that yet, as we might do something we'll regret in the future. Let's jump back to the home directory with the `cd  ~ command again to stay out of trouble for now.
 
 `cd` effectively stands for "change directory".
 
## What if we want to create a directory?

Let's move back into the Desktop directory:

`cd Desktop`

actually, we don't have to type the name of the whole directory, we only need to type in the first few letters of the directory's name, then press the `tab` key, and it should auto-complete the name for you. Pretty cool! Actually, if you've already typed that exact command before, you can just use the `up` and `down` directional arrows on your keyboard, and find the one you typed previously!

## What if you typed the command like 100 commands ago?

Good news! You can simply use the shortcut `control+r` or `command+r` (depending which computer you are using), then type the first few letters of the command you wrote previously! Like magic!

## Weren't we trying to make a directory?

Yes, you're right - sorry. As you can see, BaSH has tons of fun tricks that can actually speed up the development process faster than could have been done with a mouse and a GUI.

 Let's move back into the Desktop directory from the home directory:

`cd Desktop`

Once there, enter the `pwd` command to confirm your current directory. Let's check the contents of the directory by calling the `ls -top` command.

Now that we know what's actually there - let's create a new folder called text_files using the `mkdir` command:

`mkdir text_files`

now let's call the `ls -top` command again, to see if anything changed - you should see a new folder called `text_files` added to the directory. If you don't believe me, go take a look at your Desktop outside of the terminal right now, to see the new folder! No right-clicking necessary!

If we wanted to remove the directory (or any file we have the permission to delete), we could use the `rm` command with the `-rf` flags:

`rm -rf text_files`

which would remove the directory, and any files inside of it - but we actually want the directory, so we won't do that.

Let's go into the directory by calling the `cd` command, then call the `ls -top` command to see it's contents. You'll notice two items - a `.` and a `..`, which is, weird. But wait! BaSH is essentially showing you that the only things present are the current directory, represented by the `.` character, and the parent directory, represented by the `..` character. Remember when we used the command `cd ..` to change to the parent directory? That's what it used as a reference. Still looks a little lonely though - if only we had some text files to add to the `text_files` directory...

### How do we create and delete new files?

Of course! Let's just make some text files from scratch! To do that, let's use the `touch` command:

`touch text_file_01.txt`

and if we call the `ls -top` command again (or scroll to it using the arrow keys) we'll see that the new file `text_file_01.txt` has just been created!

### How do we change the contents of the new text file?

Good question. If we wanted to see the contents of the file printed to the screen, we could use the `cat` command to do this. The command runs a program that joins the contents of more than one file then prints the contents to the console. Since we are only checking one file, it will only print the contents of one file, which is pretty convenient:

`cat text_file_01.txt`

If the file is very long, you might want to use the `more` command instead of simply `cat`, as `cat` will display everything on the screen all at once, while `more` will allow you to page through the file at your own pace.

However, we want to add to the file, which means if we want to do this effectively, we should use a text editor. POSIX-type shells have a variety of command line text editors to choose from: emacs, vim, etc. - but those tend to have a high learning curve for beginners. There is a simpler choice for making quick editions to files though, and it's called  `nano`:

`nano text_file_01.txt`

After calling this command, the program "nano" will open up, allowing you to add text. Let's add the text "Hello, World!" to the file.

After adding the text, you'll have to save the file to make the change permanent. To do this, type `control+x` (or `command+x`), then select `y` for yes to save the changes, followed by the enter key to save the changes to the particular file we are working with - in this case, the file is `text_file_01.txt`. This should bring you back to the command line.

Now, call the command `cat text_file_01.txt` again, and you should see the text "Hello, World!` displayed on the next line!

### How do we copy or move files?

We can copy files by using the `cp` command:

`cp text_file_01.txt text_file_02.txt`

where the first file is the one being copied, and the second file is the name of the new file that will be created when the command is executed. If you then run the `cat` command on the file `text_file_02.txt`, you'll see that the same contents printed to the screen as the previous file.

If you want to move the file from the current directory to another directory, you can run the 'mv' command:

`mv text_file_02.txt ~/Desktop/text_file_02.txt`

where the original version of `text_file_01.txt` is removed from the current directory, and copied to the `~/Desktop/` directory, effectively moving the file.

If you call the command `cd ..`, then use `ls -top` to display the contents of the directory, you'll see that the file has been moved as expected. Since we no longer need the file, we can delete it, by using the `rm` command:

`rm text_file_02.txt`

and if we call `ls -top` again, we'll see that the file is no longer present.

**WARNING:** What happens in BaSH, *does not stay* in BaSH - if you delete a file, there is no "recycle bin" you can go to, to get the file back if you deleted it by mistake - all changes are permanent. Make sure you always check for typos before executing, and that you are using the right letter cases (uppercase, lowercase, etc.), since BaSH is case-sensitive. 

### How do we see if a certain file exists?

You can use either the `find` command, followed by the file name, like this:

`find text_file_01.txt`

or you could use the `ls` command as well - which may be the preferred method if you also want to know more specific details about a file:

`ls -top text_file_01.txt`

If the file exists in the directory, the same file name will be printed to the console on the next line. If it does not exist, it will display an error - this is a great way to check if the file already exists before running any commands on it accidentally, which may cause errors, and delete content.

### How do we search files for certain content?

Let's say we wanted to search directories for files with certain content, like that "Hello, World!" phrase we wrote earlier - we could use the `grep` command to do this:

`grep -rn "Hello, World!" *`

with the `r` flag used to check every file and folder in the current directory, the `n` flag used to identify the exactly line in the file where the text exists, the text we are searching for in double quotes, and the directory where we want to search - in this case we used the `*`, because we want to search everything in the current directory.

### The console is now really crowded with text - how can I clear the screen?

Easily! Simply use the `clear` command:

`clear`

And like magic, the screen is cleared!

### Is there more to learn?

ABSOLUTELY. However, we've reached a point where we can successfully navigate the BaSH shell to start creating Java programs! We'll learn more about BaSH commands in the next 6 weeks, such as searching for and closing programs (Processes), and keeping multiple versions of our apps intact (Git) - but right now, let's take the time to explore some of the new commands we learned today!

## Exercises

* TBD
