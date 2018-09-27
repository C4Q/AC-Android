# Exercises - Lesson 01.01

#### 01.01.01

Open up terminal. Enter the command `whoami`. Copy the output, and paste it into the box below.

#### 01.01.02
 
Enter the command `pwd`.  Copy the output, and paste it into the box below.
 
#### 01.01.03
 
Enter the command `cd ~`, then enter the command `pwd`. Copy the output, and paste it into the box below.

#### 01.01.04 

Enter the command `ls -top`. Look for the directory `Desktop`. If it exists, move to that directory, enter the commands  `pwd` and `ls -top` on seperate lines. Copy the output, and paste it into the box below.

#### 01.01.05

If you are in the `Desktop` directory, make a new directory called `MyRecipeDirectory`. List all of the contents of the `Desktop` directory to see if it exists. Change from the `Desktop` directory to the `MyRecipeDirectory`. Use the correct command to print the current path, then copy the output, and paste it in the box below.

#### 01.01.06

If you are in the `MyRecipeDirectory` directory, create three new files using the `touch` command:

* `recipe_01.txt`
* `recipe_02.txt`
* `recipe_03.txt`

List all of the contents of the `MyRecipeDirectory` directory, then copy the output, and paste it in the box below.

#### 01.01.07

Use the `nano` command to open up the file `recipe_01.txt`, find a short recipe from the internet, copy the recipe, paste it into `nano`, then save the file.

Call the command `cat` on the file `recipe_01.txt`. Copy the output, and paste it into the box below.

#### 01.01.07

It looks like we've made too many files! Remove the file `recipe_03.txt` from the `MyRecipeDirectory` directory. List all of the files in the current directory, then copy the output, and paste it in the box below.

#### 01.01.08

If you are in the `MyRecipeDirectory` directory, make a new directory called `SecretRecipe`. Move the file `recipe_02.txt` to this new directory. Change to the directory `SecretRecipe`, and list the contents of the directory. Confirm that the file `recipe_02.txt` is no longer in the `MyRecipeDirectory` directory. Copy both lists, and paste them into the box below.

#### 01.01.09

Looks like the recipe theives want our secret recipes! Let's remove the `SecretRecipe` directory, and all of its contents, from the `MyRecipeDirectory` directory. List the current contents of the `MyRecipeDirectory` directory, copy the output, and paste it in the box below.

#### 01.01.10

Let's make a hidden version of the `SecretRecipe` directory, by using a `.` at the front of the name. Make the directory `.NewSecretDirectory` in the `MyRecipeDirectory` directory. Use the `ls -top` command to confirm that the folder is not visible. Use the `ls -al` command to list both hidden and non-hidden files. Copy the output of both lists, and paste it in the box below.
