### Branching and merging with conflicts

1) Create a new directory and init a git repository:

```
$ mkdir website
$ cd website
$ git init
```

2) Add and commit the file, index.html:

```html
<html>
  <body>
    <p>This web page has moved to: http://achme.com/retail/ </p>
  </body>
</html>
```

```
$ nano index.html         // Use control+o then enter to save and control+x to exit
$ git add index.html
$ git commit –m ‘initial checkin’
```


3) Imaging you have been asked to add a new feature. The client wants the address on the home page to be a hyperlink. Create a branch for this new feature. You can create and switch to a branch with one command by using the –b option with checkout:

```
$ git checkout -b hyperlink
```

4) Now, edit the file to make the link a hyperlink:

```
$ nano index.html
```

```html
<html>
  <body>
    <p>This web page has moved to: <a href=”http://achme.com/retail/”>http://achme.com/retail/ </a> </p>
  </body>
</html>
```

```
$ git add index.html
$ git commit –m ‘make hyperlink’
```

5) Now, imagine a terrible and urgent bug report comes in. The URL should be `https` not `http` (secure not insecure). To make the fix, we switch back to the master branch, create a branch for the fix and merge it with master:

*(Note, before you can switch back to master you need to commit or stash current changes. We committed above.)*

```
$ git checkout master
$ git checkout -b hotfix123
$ nano index.html
```

6) Change http to https:

```html
<html>
  <body>
    <p>This web page has moved to: https://achme.com/retail/ </p>
  </body>
</html>
```

```
$ git add index.html
$ git commit –m ‘Use secure protocol https’
```

7) We are done making the changes for the hot fix, so we can merge it back in with master:

```
$ git checkout master
$ git merge hotfix123
Updating 7aecabd..3a982aa
Fast-forward
 index.html | 2 +-
 1 file changed, 1 insertion(+), 1 deletion(-)
Notice because there were no changes on master, we get a fast-forward merge.
You can view the commit tree with:
$ git log --oneline --decorate --graph --all
* 3a982aa (HEAD, master, hotfix123) use secure protocol https
| * c1f80ba (hyperlink) make hyperlink
|/
* 7aecabd initial checkin
```

Notice, by default with a fast-forward merge you don’t get a commit for the merge. Many developers find it useful to have a commit for all merges. You can force a commit with a merge by using:

```
$ git merge --no-ff <branch>
```

The --no-ff option is useful because it documents the merge. Someday you might want to know that a merge was performed at this point in the project.

8) We are done with the hotfix branch, so we can delete it:

```
$ git branch –d hotfix123
```

9) At this point we can switch back to the hyperlink branch and finish our changes. To simplify the example, we will assume the changes are complete and ready to be merged back in with master. We are on master, so we only need to merge:

```
$ git merge hyperlink
Auto-merging index.html
CONFLICT (content): Merge conflict in index.html
Automatic merge failed; fix conflicts and then commit the result.
```

We get a merge conflict. Changes can’t be merged automatically. What was changed on master after we created the hyperlink branch overlaps with changes made on the hyperlink branch.

10) `git status` indicates which files have conflicts and must be manually edited and tells us how (add / commit):

```
$ git status
# On branch master
# Unmerged paths:
#   (use "git add/rm <file>..." as appropriate to mark resolution)
#
#       both modified:      index.html
#
no changes added to commit (use "git add" and/or "git commit -a")
```

11) Files that need changing will be annotated. Use `cat` to view the annotations on index.html:

```
$ cat index.html
<html>
  <body>
<<<<<<< HEAD
    <p>This web page has moved to: https://achme.com/retail/ </p>
=======
   <p>This web page has moved to: <a href=”http://achme.com/retail/”>http://ac
hme.com/retail/ </a> </p>
>>>>>>> hyperlink
  </body>
</html>
```

12) The standard diff shows the file on master (HEAD) uses https and the file we’re trying to merge from has an anchor tag around the address. In this situation the right thing to do is to combine the two and remove the diff tags:

```
$ nano index.html
<html>
  <body>
   <p>This web page has moved to: <a href=”https://achme.com/retail/”>https://achme.com/retail/ </a> </p>
  </body>
</html>
```

13) To manually resolve a merge conflict, you make the changes, add and commit the results:

```
$ git add index.html
$ git commit –m ‘make link clickable and https’
```

14) Run git log to see the results of the merge:

```
$ git log --oneline --decorate --graph --all 
```

15) We are done with the hyperlink branch, so we can delete it:

```
$ git branch –d hyperlink
```
