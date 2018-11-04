# Bash and GitHub Review

## Objectives
* Fellows will learn how to make different branches
* Fellows will learn how to avoid merge conflicts

## Resources
* [Pro Git Online Book](https://git-scm.com/book/en/v2)

# Lecture

When working on a shared codebase, it's important to be mindful of the work of other contributors. The first concern you should have is if code on the `master` branch compiles, and works as expected at that point in development. After that, you should then think about **your** code, and how what you've written can affect the `master` branch. Lastly, consider how other team-member's code can affect the codebase on master as well.

One way to effectively separate concerns between what code exists on master, and your local or remote changes can be to make a separate branch FROM master, that incorporates your changes - just in case what you done might break the working code in the master branch.

#### git branch

When running the `git branch` command, a list of all available local branches will appear on the screen. If you do not have any local branches other than master, only master will be listed. The current branch will be identified by an asterisk (`*`) directly to the left of the branch name:

```
user:pathfinder$ git branch
* master
user:pathfinder$ 
```

To make a new branch, simply call the cammand `git branch`, followed by the name of the branch you want to create:

```
user:pathfinder$ git branch josevila/new_feature
user:pathfinder$ git branch
  josevila/new_feature
* master
user:pathfinder$ 
```

#### git checkout

To switch branches from your current branch, to another branch, you can use the `git checkout` command:

```
user:pathfinder$ git branch
  josevila/new_feature
* master
user:pathfinder$ git checkout josevila/new_feature
Switched to branch 'josevila/new_feature'
user:pathfinder$ git branch
* josevila/new_feature
  master
user:pathfinder$ 
```

If you want to both create a new branch, then immediately switch to that newly-craeted branch, you can use the `git checkout` command, followed by the `-b` flag:

```
user:pathfinder$ git branch
* josevila/new_feature
  master
user:pathfinder$ git checkout -b josevila/second_feature
Switched to a new branch 'josevila/second_feature'
user:pathfinder$ git branch
  josevila/new_feature
* josevila/second_feature
  master
user:pathfinder$ 
```

#### git stash

If you do not have a clean tree, git won't let you change branches until you commit your local changes. If you do not want to commit your local changes, you can use the command `git stash` to save your changes for later. When you decide to bring your changes back, you can use the command `git stash pop`, to bring back your most recent changes from the stash stack.

#### git fetch

If you want to get changes from a repository (either remote or local), you can use `git fetch` to get the recent changes to objects and references, and give your repo access to them.

#### git merge

If you want to fetch the changes, then combine those changes into your current branch, you can call `git fetch`, then `git merge FETCH_HEAD`. 

#### git pull

If you want to fetch the changes, then combine those changes into your current branch, all in one step, you can call the command `git pull`:

```
user:pathfinder$ git pull
There is no tracking information for the current branch.
Please specify which branch you want to merge with.
See git-pull(1) for details.

    git pull <remote> <branch>

If you wish to set tracking information for this branch you can do so with:

    git branch --set-upstream-to=origin/<branch> josevila/second_feature

user:pathfinder$
```

You can see that if you have not already set up tracking for this branch, or do not explicitly declare which branch you are pulling from, you'll have to set the upstream for that particular branch - in other words, set the remote branch you wish to pull from now, and in the future.

#### Merge Conflicts

Occasionally, you will encounter merge conflicts, where the changes between your branch, and the branch you want to merge into are so different, that git will be unable to do the merge until this is resolved. This means you'll have to manually change the file(s) so that the changes in both branchs match up either locally or on the remote branch. One way to avoid this is to pull in the changes from the branch you want to merge your local branch into, into your LOCAL BRANCH FIRST, THEN MERGE YOUR BRANCH INTO THE OTHER BRANCH. This is a best practice when working with a shared codebase.
