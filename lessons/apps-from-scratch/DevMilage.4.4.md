## Increasing your Mileage (Application development practice)
 
#### Objectives:

* Pactice ticket-based task management, branching, and pull-requests in an application development context to simulate real-world working conditions.
* Develop an android application that applies various framework components taught throughout the program, and challenges you to learn new ones to increase your mastery of the subject.
* Apply clean coding principles such as the DRY principle, Seperation of Concerns and identify, then correct known code smells (Demonstrating the ability to write neat and legible code is highly sought-after by employers).


#### Vocabulary:

* Tickets: Most organizations use some kind of task management software. This software implements the idea of breaking down features into manageble chunks. Sites like Gitlab, and Jira use the idea of tickets that are assigned to each developer so that for any given sprint, the developer knows what to work on and in what order. You might have seen this demonstrated with Trello, where cards are assigned instead of tickets. The idea is the same: A ticket is created and put into a group of tickets labeled: `Todo`, for the sprint. Once you start working on a ticket, your ticket moves to the `In Progress` group while you work on it. Once you are done and you make a pull request to merge your codebase into the project, it moves into the  `In Review` group. Once your teamates review your pull rquest, you make any necessary changes and the branch is merged into the codebase your ticket moves to the `done` group. There are variations but this is the general flow. For this project the ticketing flow will be as such:
  * `Todo`: these are specified in the requirements section. Each student will attempt to complete ALL tickets.
  * `In Progess`: Once you create a branch you can consider that ticket to be in progress. Try to complete a ticket before moving on to the next one.
  * `In review`: Once you make and push the final commit for a ticket, you can open up a pull request to merge your branch to the master branch. Remember: This is a good opportunity to review all your changes and seek feedback from your peers before you actually merge the code. If a peer asks for your feedback it's a good opportunity to ask questions and have a fruitful converstaion around architecture. 
  * `Done`: A ticket is considered "done" when you are confident that you can move on to the next portion of the application and then merge to the master branch. 

* DRY: A software design principle meant to minimize the amount of code you write therby minimizing the probability of error. Stands for: Don't Repeat Yourself. ie. avoid writing duplicate code. See resources for more info. 
* Separation of Concerns: Another important and relevant design principle aimed at creating better software. Basically means that you should encapsulate your logic so that each method/component does not do anything it doesn't need to. See resources for more info.
* Code Smell: A code smell is some kind of development pattern that indicates that a developer should rethink their logic to avoid problems that might arise as a result of their current approach. See resources for more info. 
* MOBAN(ticket #): A common practice in the field is to name your branches based on the ticket that you are working on. In this context MOBAN stands for "Mobile:Android" followed by the ticket you are working on ie. `MOBAN76`. A branch name for such a ticket can be followed by a short name and might look something like this: MOBAN76-ui-login-fix

#### Resources: 

Tickets: [link](https://en.wikipedia.org/wiki/Issue_tracking_system)
Dry: [link](https://en.wikipedia.org/wiki/SOLID_(object-oriented_design))
Separation of concerns: [link](https://en.wikipedia.org/wiki/Separation_of_concerns)
Code smells: [link1](https://en.wikipedia.org/wiki/Code_smell), [link2](https://sourcemaking.com/refactoring/smells)

#### Lesson:

In a typical app development role, your product manager will get a list of requirements that the application should meet, it is their job then to work with the business side to prioritize these requirements, they are then to work with your team lead to break these requirements down into small manageable technical chunks (tickets) that can then be distributed to your team.

While looking for a role it is common to receive `coding challenges` or `take-home assignments` used by prospective employers to gauge the coding habits of an applicant, being able to break down a feature into manageble tasks is helpful for any developer to mantain an organized work ethic.

This project is meant to be a hybrid of both approaches, which can help you build up the skills necessary to break down features and tasks into tickets that you can then create branches for so that you can incrementally implement through commits.

##### Project Description: 

In order to give you some creative freedom, you are to build an application that implements an api of your choice. You can find a list of free apis [here](https://github.com/toddmotto/public-apis). Having chosen your API you are to use the android framework to complete the minimum of 5 tickets as described below. Each ticket implies a task to be completed that can then be guaged by prospective employers through github. Remember that you have 6 hours to complete the application so take care to implement things well. Feel free to complete MOBAN04 before you do MOBAN02, for some people development is easier after you have your network stack and your Object Models. 

The format for the following tickets is as such: 
    `MOBAN[Number]`/ `ticket name`/ ` short ticket description`:
* Requirements this ticket should meet.
 
A branch name for such a ticket could be: `MOBAN01-ticket-name`

#### Developer Mileage Project: Requirements

* `MOBAN01`/ `environment setup`/ `The application should have a relevant name and a well formated .gitignore file.` 
  * After you have chosen an API to use, create a repository for your application, give it a relevant name (It should NOT be: Developer Mileage Project) 
  * Upload an android project that contains a .gitignore file that will make sure you don't upload any uncecessary config files like .vcs, .idea, .iml and such. 
  * Add a README that introduces your application and what it will do/does
  * Once you have a clean project uploaded in your master branch you can consider this initial ticket `done`.
* `MOBAN02`/`design`/`Implement initial component` 
  * Because we are working with varying API's, each student's application will look different. Use your creativity to create something interesting. You can create the networkin stack first if you'd like, that is MOBAN04. For this ticket, you are to choose at least 2 of the following 3 components and implement one:
    * Recyclerview
    * Fragments
    * ViewPager
   * Remember that the ViewPager is essentially a container for fragments and even though we haven't explicitly taught it, you should have the skills necessary to implement it at this point.
   * In the application you are not limited to implementing just two of these three components either, you can do all three, mix and match or use a component more than once as your deem necessary, The entire framework is available to you, Images, scrollviews, card views, collapsing toolbars etc. Feel free to use any library you'd like (picasso, etc), also Consider using Patterns such as singletons, factories, listeners and packaging your code into features to keep your codebase organized.
   * You can consider this ticket done once you implement only one component, The other components can be implemented in future tickets, think about the features you are trying to build and how you will be breaking them down into manageble chunks. Remember to try and keep your pull requests as small as you can. 
* `MOBAN03`/`design 2`/`Implement second component`
    * This one is straight forward, implement a second component.
* `MOBAN04`/`networking`/`Implement the chosen API`
    * You should create a networking package that will contain any relevant networking code, it's important to think about architecture here in terms of how you will be building your model objects and how you will be accessing them.
    * You can complete the networking stack before you do any UI/Component implementation. That is one of the advantages of modularity and separating concerns. 
* `MOBAN05`/`supplemental components`/`Implement any other component necessary`
    * You are not limited to just 5 tickets, think about the features you'd like to incorporate, and feel free to create a ticket for each, the idea is to break down the process into manageble commits and go through with it. Use any component you'd like and keep in mind having clean code and good architecture. That is a skill developed over time with practice. Use this project as your practice. 
    * Once you are happy with what you have build. A final ticket called `MOBANPROD` will finalize your README with any thoughts on the development process like what you have learned, or any questions you may still have in terms of how something was/could have been implemented. Remember that prospective employers might find this repo when looking through your github and that they want to get a feel for the kind of developer you are so this is a great opportunity to show them that.

Things to consider: 
* Do not commit dead code, that is a terrible practice, it make looking through commits on github challenging and clutters up your workspace. Same with unused imports. If you are not using it it shouldn't be there when you commit. 
* Command:control:L Make sure you format your code. It'll help everyone that looks at it read it.
* Docs: documment a method or a class where necessary, this shows that you are thinking about the developer that has to read your code and your teammates will be thankful to you for it. It doesn't have to be excessive, just enough for someone to know what's going on in your codebase. 
* Method/Variable naming: These things are super important. Thinking about what a variable is or what a method is doing as well as what a class represents can help you in your architecture design and can help you understand your code better months from now when you want to update a library or talk through your application with a prospective employer.
* Try to strike a balance in simplicity and elegance when writing code, some things might get complicated, think of how you can make them simpler, it's not always easy or attainable but it is a noble goal to have.


##### This project can be a great addition to your portfolio, so try your best. Good luck!!
