# State of the Solo Project

## Objectives
* Fellows will self-assess how close they are to reaching MVP for their projects
* Fellows will share a working MVP form of their project

## Resources
* [Unit 05 Solo Project Requirements](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_05/projects/05_01_unit_05_solo_project.md)
* [Introduction to Ideation](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_05/05_04_introduction_to_ideation.md)
* [Wireframing for Solo Projects](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_05/05_07_wireframing_for_solo_projects.md)
* [Project Management](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_01/01_29_Project_Management.md)

## Warmup - DO THIS NOW :fire::fire::fire: (10 MINUTES)
Look through the current state of your Unit 05 Solo Project, and confirm that you have hit the minimum viable product for your chosen path.

# Lecture

For the last week, we have worked towards the completion of our individual Unit 05 Solo Projects. Let's go over some of our accomplishments so far:

* Brainstorming and Ideation
* Learning to Wireframe
* Creating a Trello Board to track our progress
* Creating a Git and Github Project
* Choosing a Path (Primarily connect to endpoint vs. Primarily perist data with SQLite)
* Refactoring our idea based on the actual Unit 05 Solo Project Requirements
* Defining MVP for our particular projects based on our specific ideas
* Reaching MVP (hopefully)

Most of you, by this point, should have reached the first 7 benchmarks for your projects. Likely, the hardest benchmarks were likely the following:

* Refactoring our idea based on the actual Unit 05 Solo Project Requirements
* Defining MVP for our particular projects based on our specific ideas

as "scope-creep" is always a concern. MVP, or "Minimum Viable Product", might not seem like enough, especially if your final goal is to create something you'd be proud to show off to others, or post in the Google Play store. However, MVP, at this stage, should be the following:

#### Path A: Connecting to the internet using Retrofit2, and displaying data in a list page and detail page

1. Discover an API you are interested in that contains a list of data (you can even use Github to create your own static json file)
1. Display it to the screen within a Fragment, in the form of either a RecyclerView or ViewPager
1. When an itemview (or displayed ViewPager Fragment) is clicked, it should move to a detail view (another Fragment)
1. When a view in the detail Fragment is clicked it should move to another app on the device (phone, text, browser, etc.)

#### Path B: Collecting data from the user, persisting it locally using SQLite, and displaying that data on the screen

1. Design a UI that accepts input from the user in a Fragment
1. Save and query that data locally using SQLite
1. Display it to the screen within a Fragment, in the form of either a RecyclerView or ViewPager
1. When an itemview (or displayed ViewPager Fragment) is clicked, it should move to a detail view (another Fragment)
1. The data within the app should be editable after it has been added

Guess what? If you were able to complete the features specific to your particular chosen path, then you have reached MVP for your project! Although the final version of the Unit 05 Solo Project that you are expected to submit should also include the additional requirements described in the assignment (splash page, single activity/multiple fragments, unit tests, demo deck, etc.), those aren't really MVP, those are your production requirements. MVP should be thought of as **THE BARE MINIMUM TO QUALIFY AS MEETING THE SPECIFICATIONS.**

