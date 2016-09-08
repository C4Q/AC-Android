- title: JSON
- tags: web apis, json, http

# Objectives

- Summarize how the internet works
- Review the HTTP request/response protocol and how web requests are made
- Define what web APIs are and practice interacting with them
- Understand what `JSON` is and how to manually parse it

# Lecture 

# Resources
- [Code Beautify JSON Viewer](http://codebeautify.org/jsonviewer)
- [Code Newbie: An Intro to APIs](http://www.codenewbie.org/blogs/an-intro-to-apis)
- [w3resource: JSON](http://www.w3resource.com/JSON/introduction.php)

# Lecture 

## Making web requests
![Web requests]( https://github.com/accesscode-2-1/unit-0/blob/master/images/makeRequests.png?raw=true )

Whenever your web browser fetches a file (a page, a picture, etc) from a web server, it does so using HTTP - that's "Hypertext Transfer Protocol".  HTTP is a request/response protocol, which means your computer sends a request for some file (e.g. "Get me the file 'home.html'"), and 
the web server sends back a response ("Here's the file", followed by the file itself).

That request which your computer sends to the web server contains all sorts of (potentially) interesting information.  
We'll now examine the HTTP request your computer just sent to this web server, see what it contains, and find out what it tells me about you.

The raw information:

```java
GET /dumprequest HTTP/1.1
Host: rve.org.uk
Connection: keep-alive
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/\*;q=0.8
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.104 Safari/537.36
Referer: https://www.google.com/
Accept-Language: en-US,en;q=0.8
```

## What is a web API?

A web API is a programmatic interface to a defined request-response message system, typically expressed in JSON or XML, which is exposed via the web — most commonly by means of an HTTP-based web server.

Web API's allow app developers to integrate external products and services into their projects. Some examples: [Google Maps API](https://developers.google.com/maps/), [Slack Web API](https://api.slack.com/web), [Dark Sky Forecast API](https://developer.forecast.io/).

## What is JSON?
JSON stands for JavaScript Object Notation.  JSON is a lightweight data-interchange
format that allows you to store and create data. It’s not a programming language. It’s not a markup language. 

So, what does that mean? To put it simply, it’s a file with data formatted to be readable by other programming languages.

While JSON isn’t really a language and can't actually do anything on it’s own, it can be useful with data transportation. For example, 
let’s say you had a list of users and you wanted to send this data across various languages like Java, PHP and JavaScript. Naturally, 
these are different languages, but they all understand JSON. By bridging this gap, you can make it easy to send data 
from one language to the other. 

### Advantages of using JSON:
- Human readable
- Portable between different languages
- Extremely lightweight, making it run faster than XML

### Simple Example

```json
{
    "car1": {
        "mustang": {
            "transmission": "good"
        }
    },
    "car2": {
        "mazda": [
            {
                "transmission": "good"
            },
            {
                "engine": "good"
            }
        ]
    },
    "car3": "corvette"
}
```

### Minified JSON

Minifying JSON takes nice, readable, "Pretty-Print" JSON and removes the spacing, indentation, newlines, and comments to compress it to a smaller size. This is the format that JSON is likely to appear in from a web API.

```json
{"judy-principal":{"teachers":[{"msDiaz":[{"kevin":{"lunchbox":"red","numOfPencils":"2"}},{"Amanda":{"lunchbox":"yellow","numOfPencils":"3"}},{"Billy":{"lunchbox":"black","numOfPencils":"2"}}]},{"msArcentales":[{"ray":{"lunchbox":"black","numOfPencils":"3"}},{"mike":{"lunchbox":"green","numOfPencils":"3"}},{"stacy":{"lunchbox":"pink","numOfPencils":"3"}}]},{"msLiu":[{"jackie":{"lunchbox":"green","numOfPencils":"3"}},{"laura":{"lunchbox":"yellow","numOfPencils":"2"}},{"tommy":{"lunchbox":"blue","numOfPencils":"4"}}]}]}}
```

But have no fear, there are many awesome JSON viewers to choose from that will help make sense to of the madness: [Code Beautify JSON Viewer](http://codebeautify.org/jsonviewer).

## JSON Parsing

[Parsing guide](https://github.com/accesscode-2-1/unit-0/blob/master/lessons/week-4/2015-04-04-secret-kung-fu-masters-JSON-quick-start-guide.md)
