# Setting up Git

We'll be using Git and GitHub in this class to save and share our code. It will be an **INTEGRAL** part of everything we do.

* You should already have Git installed on your computer.
* You already have a GitHub username!

[Let's set up Git!](https://help.github.com/articles/set-up-git/)

## Setting up SSH Keys

SSH keys are a way to identify trusted computers, without involving passwords. The steps below will walk you through generating an SSH key and then adding the public key to your GitHub account. Doing this will make the process of using Github more seamless and more secure.

__Note:__ The dollar sign (`$`) is commonly used to represent the command line. Anything to the right of it is what you enter (ex. `$ ls` means you enter `ls`). The tilde (`~` not Swinton) is used to represent the home directory. If your system username is Felix for example, `~` will translate to `/Users/Felix`.

_This guide was taken in huge part from [Github's SSH key guide](https://help.github.com/articles/generating-ssh-keys/). Feel free to refer to that guide directly, but be aware that there are differences._

### Step 1: Open your Terminal

The terminal is an application provides text-based access to the operating system.


### Step 2: Check for SSH keys

Since we will be using new Macbooks, there shouldn't be any pre-existing SSH keys. Let's continue and generate one!

### Step 3: Generate a new SSH key

To generate a new SSH key, copy and paste the text below, making sure to substitute in your email address. The default settings are preferred, so when you're prompted to "Enter a file in which to save the key", just press __Enter__ to continue.

```
$ ssh-keygen -t rsa -C "your_email@example.com"
# Creates a new ssh key, using the provided email as a label
Generating public/private rsa key pair.
Enter file in which to save the key (/Users/you/.ssh/id_rsa): [Press enter]
```

Next, you'll be asked to enter a passphrase.

```
Enter passphrase (empty for no passphrase): [Type a passphrase]
Enter same passphrase again: [Type passphrase again]
```

A passphrase makes your SSH key more secure, but if you use one make sure you don't forget it. We recommend you let your Mac remember your passphrase when prompted. Feel free to not use any passphrase.

Which should give you something like this:

```
Your identification has been saved in /Users/you/.ssh/id_rsa.
Your public key has been saved in /Users/you/.ssh/id_rsa.pub.
The key fingerprint is:
01:0f:f4:3b:ca:85:d6:17:a1:7d:f0:68:9d:f0:a2:db your_email@example.com
```

Then add your new key to the ssh-agent:

```
# start the ssh-agent in the background
$ eval "$(ssh-agent -s)"
Agent pid 59566
$ ssh-add ~/.ssh/id_rsa
```

## Step 4: Add your SSH key to your account

Run the following command to copy the key to your clipboard.

```
$ pbcopy < ~/.ssh/id_rsa.pub
# Copies the contents of the id_rsa.pub file to your clipboard
```

1. In the top right corner of any page, click the settings icon (looks like a gear).

2. In the user settings sidebar, click __SSH keys__.

3. Click Add SSH key.

4. In the Title field, add a descriptive label for the new key. For example, if you're using a personal Mac, you might call this key "Personal MacBook Air".

5. Paste your key into the "Key" field.

6. Click __Add key__.

7. Confirm the action by entering your GitHub password.

### Step 5: Test everything out

To make sure everything is working, you'll now try SSHing to GitHub. When you do this, you will be asked to authenticate this action using your password, which was the passphrase you created earlier.

Open up your Terminal and type:

```
$ ssh -T git@github.com
# Attempts to ssh to GitHub
```

You may see this warning:

```
The authenticity of host 'github.com (207.97.227.239)' can't be established.
RSA key fingerprint is 16:27:ac:a5:76:28:2d:36:63:1b:56:4d:eb:df:a6:48.
Are you sure you want to continue connecting (yes/no)?
```

Don't worry! This is supposed to happen. Verify that the fingerprint in your terminal matches the one we've provided up above, and then type "yes."

```
Hi username! You've successfully authenticated, but GitHub does not provide shell access.
```

If that username is yours, you've successfully set up your SSH key! Don't worry about the "shell access" thing, you don't want that anyway.

If you receive a message about "access denied," you can [read these instructions for diagnosing the issue](https://help.github.com/articles/error-permission-denied-publickey).

### Congrats, you generated your SSH key!
