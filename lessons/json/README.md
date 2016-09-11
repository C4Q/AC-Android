- title: JSON
- tags: web apis, json, http

# Objectives

- Summarize how the internet works
- Review the HTTP request/response protocol and how web requests are made
- Define what web APIs are and practice interacting with them
- Understand what `JSON` is and how to manually parse it

# Resources
- [Code Beautify JSON Viewer](http://codebeautify.org/jsonviewer)
- [Code Newbie: An Intro to APIs](http://www.codenewbie.org/blogs/an-intro-to-apis)
- [w3resource: JSON](http://www.w3resource.com/JSON/introduction.php)

# Lecture 

## Making web requests
![Web requests]( https://github.com/accesscode-2-1/unit-0/blob/master/images/makeRequests.png?raw=true )

Whenever your web browser fetches a file (a webpage, a picture, some JSON, etc...) from a web server, it does so using **HTTP** - that's 'Hypertext Transfer Protocol'.  

HTTP is a request/response protocol, which means your computer sends a **request** for some file (e.g. "Get me the file 'home.html'"), and the web server sends back a **response** ("Here's the file", followed by the file itself).


## What is a web API?

A web API is a programmatic interface to a defined request-response message system, typically expressed in JSON or XML, which is exposed via the web — most commonly by means of an HTTP-based web server.

Public facing web APIs allow app developers to integrate external products and services into their projects. Some examples: [Google Maps API](https://developers.google.com/maps/), [Slack Web API](https://api.slack.com/web), [Dark Sky Forecast API](https://developer.forecast.io/).

## What is JSON?
JSON stands for JavaScript Object Notation.  JSON is a lightweight data-interchange format that allows you to store and create data. It’s not a programming language. It’s not a markup language. 

So, what does that mean? To put it simply, it’s a file with data formatted to be readable by other programming languages.

While JSON isn’t really a language and can't actually do anything on it’s own, it can be useful with data transportation. For example, 
let’s say you had a list of users and you wanted to send this data across various languages like Java, PHP and JavaScript. These are different languages, but they all understand JSON.

JSON is made up of unordered **key-value pairs** -- kind of like a HashMap! JSON **keys** are always strings. JSON **values** can be any of the following:

- A **number** (integer or floating point)
- A **string** (in double quotes)
- A **boolean** (true or false)
- An **array** (in square brackets)
- Another JSON **object** (in curly braces)

### Simple Example

```json
{
    "text": "Would you like to play a game?",
    "attachments": [
        {
            "text": "Choose a game to play",
            "fallback": "You are unable to choose a game",
            "callback_id": "wopr_game",
            "color": "#3AA3E3",
            "attachment_type": "default",
            "actions": [
                {
                    "name": "chess",
                    "text": "Chess",
                    "type": "button",
                    "value": "chess"
                },
                {
                    "name": "maze",
                    "text": "Falken's Maze",
                    "type": "button",
                    "value": "maze"
                },
                {
                    "name": "war",
                    "text": "Thermonuclear War",
                    "style": "danger",
                    "type": "button",
                    "value": "war",
                    "confirm": {
                        "title": "Are you sure?",
                        "text": "Wouldn't you prefer a good game of chess?",
                        "ok_text": "Yes",
                        "dismiss_text": "No"
                    }
                }
            ]
        }
    ]
}
```

### Minified JSON

Minifying JSON takes nice, readable, 'Pretty-Print' JSON and removes the spacing, indentation, newlines, and comments to compress it to a smaller size. This is the format that JSON is likely to appear in from a web API.

```json
{"text":"Would you like to play a game?","attachments":[{"text":"Choose a game to play","fallback":"You are unable to choose a game","callback_id":"wopr_game","color":"#3AA3E3","attachment_type":"default","actions":[{"name":"chess","text":"Chess","type":"button","value":"chess"},{"name":"maze","text":"Falken's Maze","type":"button","value":"maze"},{"name":"war","text":"Thermonuclear War","style":"danger","type":"button","value":"war","confirm":{"title":"Are you sure?","text":"Wouldn't you prefer a good game of chess?","ok_text":"Yes","dismiss_text":"No"}}]}]}
```

But have no fear -- there are many awesome JSON viewers to choose from that will help make sense to of the madness: try [Code Beautify JSON Viewer](http://codebeautify.org/jsonviewer).

## JSON Parsing

If we want our Java program to interact with external web APIs that serve JSON, we need a way to **parse** these JSON objects into Java. There are a number of popular Java libraries to do this (see [Gson](https://github.com/google/gson), [Jackson](https://github.com/FasterXML/jackson)), but today we're going to get started with JSON.simple.

We'll need to start with downloading the [JSON.simple](https://json-simple.googlecode.com/files/json-simple-1.1.1.jar) library and [importing it into our intellij project](importing.md).

[JSON Parsing exercises](exercises.md)
