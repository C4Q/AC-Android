# Unit 05 Solo Project

## Summary

Unit 05 will culminate in the completion of a solo project based on your choice of the following requirements:

### Path A: Connecting to the internet using Retrofit2, and displaying data in a list page and detail page

* Discover an API you are interested in that contains a list of data (you can even use Github to create your own static json file)
* Display it to the screen within a Fragment, in the form of either a RecyclerView or ViewPager
* When an itemview (or displayed ViewPager Fragment) is clicked, it should move to a detail view (another Fragment)
* When a view in the detail Fragment is clicked it should move to another app on the device (phone, text, browser, etc.)

#### Possible Ideas

* Connecting to an API with a list of images to display in a ViewPager, when the ViewPager Fragment is clicked, it could move to display a detail fragment with a description and external links
* Connecting to an API with a list of addresses to display in a RecyclerView, when the itemview is clicked, it could move to a Fragment displaying a Map, and a detailed description with external links

### Path B: Collecting data from the user, persisting it locally using SQLite, and displaying that data on the screen

* Design a UI that accepts input from the user in a Fragment
* Save and query that data locally using SQLite
* Display it to the screen within a Fragment, in the form of either a RecyclerView or ViewPager
* When an itemview (or displayed ViewPager Fragment) is clicked, it should move to a detail view (another Fragment)
* The data within the app should be editable after it has been added

#### Possible Ideas

* A note-taking app that is searchable, and displays editable notes, with timestamps recorded for each entry
* A flashcard app where a user can add/delete words, and edit definitions - the app displays words which, when clicked, will display the definition(s) of a word selected

## Requirements for both paths

* the app and Github repo should have a name as if it were to be posted on the Google Play store, i.e. something like "Puppy Playdate Scheduler", NOT "Unit 05 Solo Project" 
* the app should contain a single Activity, and multiple Fragments
* all fragments should use static factory methods and interface callback methods to communicate with the Activity
* the app should have a "Splash Page"
* the app SHOULD NOT CRASH / PRODUCE AN ANR RESPONSE, and should account for orientation change
* you can only make an initial commit to master in your Github Repository - all subsequent commits should be made from a "feature" branch, and merged into master
* there should be commits and merges at regular intervals throughout the process
* there should be at least one JUnit Test for a non-view related class (testing a sorting algorithm, confirming input/output, etc)
* all hardcoded values should be stored in a values xml file (colors.xml, strings.xml, arrays.xml, dimens.xml, etc.)
* the project should include a README.md file describing your project
* the app should include a menu button with a link to your repo, and your linkedin page
* all requirements should be broken down into actionable tasks, and tracked using a public Trello Board, as per [this lesson](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_01/01_29_Project_Management.md), the link for which should be posted in your Github repo's README.md file
* a slide deck must be produced, for a 5 minute presentation on your App

### Due Date

This project will be due Wednesday, April 10th, 2019 at 11:59pm EST. Please submit your repository link here.
