- title: Intro to Project Management
- tags: project management, agile, scrum, trello

# Objectives

- Identify common software project pitfalls.
- Gain exposure to common software project management methodologies.
- Discuss strategies to facilitate communication and collaboration on team software projects. 
- Practice using a Trello board to organize and track a project sprint. 

# Resources

- [Beginner's Guide to Scrum and Agile Project Management](http://blog.trello.com/beginners-guide-scrum-and-agile-project-management)
- [Using Trello for Agile Software Development](http://buildbettersoftware.com/trello-for-software-development)
- [Quora: What is a minimum viable product?](https://www.quora.com/What-is-a-minimum-viable-product)
- [User Stories](https://www.mountaingoatsoftware.com/agile/user-stories)
- [The Easy Way to Writing Good User Stories](http://codesqueeze.com/the-easy-way-to-writing-good-user-stories/)
- [Daily Scrum Meeting](https://www.mountaingoatsoftware.com/agile/scrum/daily-scrum)

# Lecture

## What is Agile? 

Agile is a time boxed, iterative approach to software delivery that aims to build software incrementally from the start of the project, instead of trying to deliver it all at once near the end.

The principles behind Agile came out of a meeting in the early 2000's by a group of software developers who were looking for a better way to manage software projects. They collectively devised [The Agile Manifesto](https://www.agilealliance.org/agile101/the-agile-manifesto/), a methodology for developing software which is based on twelve principles:

1. Customer satisfaction by early and continuous delivery of valuable software.

2. Welcome changing requirements, even in late development.

3. Working software is delivered frequently (weeks rather than months).

4. Close, daily cooperation between business people and developers.

5. Projects are built around motivated individuals, who should be trusted.

6. Face-to-face conversation is the best form of communication (co-location).

7. Working software is the principal measure of progress.

8. Sustainable development, able to maintain a constant pace.

9. Continuous attention to technical excellence and good design.

10. Simplicity —- the art of maximizing the amount of work not done —- is essential.

11. Best architectures, requirements, and designs emerge from self-organizing teams.

12. Regularly, the team reflects on how to become more effective, and adjusts accordingly.

## What is Scrum?

While The Agile Manifesto describes a better vision for building software, it doesn’t provide concrete steps to actually implement a software development process. **Scrum** is one of the most popular frameworks for implementing agile.

#### Sprints

A **sprint** is the basic unit of development in Scrum - the duration is fixed in advance for each Sprint and is normally between one week and one month.

Each sprint starts with a Sprint Planning event that aims to define a **feature backlog**, identify the features for the sprint, and make estimates on each feature.

Scrum emphasizes having a complete, working product at the end of every sprint.

#### Minimum Viable Product

A minimum viable product (MVP) has just those core features sufficient to deploy the product, and no more.

![minimum viable product](https://qph.ec.quoracdn.net/main-qimg-c316ff7442fe977e2a555dcb37ee9653-c?convert_to_webp=true)

Determining an MVP for your product during initial planning and working towards it as a first goal helps you to:

- Be able to test a product idea with minimal resources.
- Accelerate your team's learning.
- Reduce wasted engineering hours building superfluous or unnecessary features (see [YAGNI](https://en.wikipedia.org/wiki/You_aren%27t_gonna_need_it)).
- Get the app to early users as soon as possible for testing.

#### User stories

User stories are short and simple descriptions of a feature told from the point of view of the person who desires the feature, usually a user or customer of the app. They typically follow a simple pattern:

> *As a (type of user), I want (some goal) so that (some reason).*

During initial project or sprint planning meetings, user stories are written on index cards or sticky notes and arranged on walls or tables to facilitate planning and discussion.

> **Exercise:** Work in groups to discuss and decide on at least 5 user stories for the [scientific calculator](/homework/unit-2/week-3+4.md) project. Remember to keep them short, specific, and to follow the *"As a (type of user), I want (some goal) so that (some reason)."* pattern. Write each user story down on the front of a new index card. Arrange the user story cards in a column, with the higher priority stories towards the top of the column.

#### Features

A feature is a small, client-valued function of your product. Features are very small and typically can be implemented within a few hours.

For example:
- Show four differently colored buttons, one in each corner of the screen.
- Display the current round number in a TextView.
- Show a Toast at the beginning of the game with instructions.
- For each round, activate the buttons in the same order.
- For each round, record the order that the player presses the buttons.
- If the activated order and the pressed order do not match, end the game.
- Show a Toast when the game ends telling the player they've lost.
- When the game ends, start over with a new game.

###### Estimate

Each feature should include an **estimate** in points, not in units of time. Using points allows you to estimate features according to their relative difficulty, rather than a time-based estimate which is harder to intuit precisely in advance.

Popular scales for feature estimates include **powers of two** (2, 4, 8, 16...) or **fibonacci numbers** (1, 2, 3, 5, 8, 13, 21...)

###### Priority

Each feature should include a priority. You can use a numeric scale, for example from 1 (low) to 5 (high).

Think about your MVP as well as any feature dependencies or "blockers" (does Feature A need to be completed before work on Feature B can start?) when assigning priority.

> **Exercise:** Work in groups to discuss and decide on at least 10 features for the [scientific calculator](/homework/unit-2/week-3+4.md) project, based on your user stories. Write each feature down on the front of a new index card. Give each feature an **estimate** and a **priority**, keeping dependencies in mind. If Feature A is "blocked" from being started until Feature B is implemented, write a reference to the Feature B on the back of the Feature A card and give Feature B a higher priority.

#### Retros

At the end of a sprint, the team holds a sprint retrospective where they:

- Review the work that was completed and the planned work that was not completed.
- Present the completed work to the stakeholders (a.k.a. the demo).
- Identify and agree on continuous process improvement actions.
- Reflect on the past sprint. Each team member answers: What went well during the sprint? What could be improved in the next sprint?


> **Exercise:** Work in groups to evaluate the user story and feature cards you've created. Arrange the feature cards in a "backlog" column with the highest priority cards at the top of the column. Discuss how you would divide feature implementation across your group members. Refer to the estimation values to balance features equally across the team, keeping priorities, blockers and related tasks in mind. Assign each feature to a group member (write their initials on the card). 

> **Exercise:** Nominate a Tech Lead in your group. The Tech Lead should copy the [AC 3.3 Sprint Template](https://trello.com/b/pz8oJNK2/ac-3-3-template) Trello board, rename the board "Scientific Calculator", and add the other group members as collaborators to the new board. 

> **Exercise:** For each user story index card that your group has created, create a new card in the *User Stories* list. Each group member should practice adding at least one user story to the board. Arrange the cards in the list by priority. 

> **Exercise:** For each feature index card that your group has created, create a new Trello card in the *Backlog* list. Each group member should practice adding at least two features to the board. Add a comment to each card with its priority and estimate. Add a label to each card. Arrange the cards in the list by priority. Assign each card to the group member who is responsible for completing the feature. 

## Best practices for software project teams

#### Daily stand-up

Each day, hold a daily stand-up meeting either in-person or on Slack. All team members are required to attend and the meeting should be time-boxed to 15 minutes to keep the discussion brisk but relevant.

During the daily stand-up, each team member answers the following three questions:

1. What did you do yesterday?
2. What will you do today?
3. Is there anything blocking you right now?

By focusing on what each person accomplished yesterday and will accomplish today, the team gains an understanding of what work has been completed and what work remains.

Decide on a time and format for the daily stand-up during your first planning meeting and stick to it.

#### Slack

Create a Slack channel for your project team and use it! On days when your project team cannot meet in person, hold the daily stand-up at a predetermined time in the Slack channel. At any time, use the channel to ask your team for help if you're feeling stuck or have questions about a feature requirement.

#### In-person working sessions / pair programming

Schedule time throughout the week to meet in-person for working sessions - ideally at least twice during the week. This is separate from the daily stand-up meeting and is an opportunity for team members to discuss technical aspects of the project, pair program or merge and validate completed features together.

Decide on a time and place during your first planning meeting and stick to it.

#### Merge often

Work towards having a Minimum Viable Product on your master branch as early as possible in the sprint, then merge small, incremental feature improvements as they are completed. At any time in the sprint, code pulled from your master branch should always run and should represent a demo-able version of your app.

Merging small code changes frequently will also help your team better avoid last-minute, complex merge conflicts.

#### Tech lead

Nominate a tech lead at your first project meeting. The tech lead will be responsible for hosting the Trello board and Github repository, facilitating daily stand-up and checking in with team members to ensure features are pushed, reviewed and merged into the master branch as they are completed.

#### Project planning / Sprint planning

Start off each project or sprint with a planning meeting (like we've practiced today). Planning meeting items should include:

- Review **project requirements** as a team.
- If the project has open-ended requirements (i.e. freedom to choose a topic or theme for the app), decide on these together as a team.
- Nominate a **tech lead** - preference goes to members who haven't served yet as leads on their previous teams.
- Create a project **Trello board** and add all team members as collaborators.
- Discuss and decide on **user stories** for the project, add them to the Trello board and rank them by priority.
- Discuss and decide on **features** for the project and add them to the Trello board backlog. Give each feature a priority and an estimate and rank them by priority in the backlog.
- **Assign each feature** to a team member. Refer to the estimation values to balance features equally across the team, keeping priorities, blockers and related tasks in mind.
- Decide when and where your team will meet throughout the week for **in-person working sessions** and pair programming.
- Decide on a time for a **daily stand-up**, and decide whether the stand-up will be held in person or on Slack.
- Create a team **Slack channel**.
- Complete any **project setup or initialization** (e.g. create a Github repo and add all team members as collaborators, create a new Android Studio project and push it to the repo).

#### Stay flexible

Keep in mind that software projects are never perfect. Even with adequate project planning, unexpected technical complications will arise, feature requirements may change, estimates might prove misguided and team members could become blocked by unforeseen dependencies. 

Stay flexible, open-minded and in frequent communication with your team (agile!) to think through problems as they arise, revise your plans as needed and stay on track to complete your project.
