- title: JSON
- tags: web apis, json, http

# Objectives

- Summarize how the internet works
- Review the HTTP request/response protocol and how web requests are made
- Define what web APIs are and practice interacting with them
- Understand what `JSON` is and how to manually parse it

# Lecture 

## Making web requests
![ Web requests ] ( https://github.com/accesscode-2-1/unit-0/blob/master/images/makeRequests.png?raw=true )

Whenever your web browser fetches a file (a page, a picture, etc) from a web server, it does so using HTTP - that's "Hypertext Transfer Protocol".  HTTP is a request/response protocol, which means your computer sends a request for some file (e.g. "Get me the file 'home.html'"), and 
the web server sends back a response ("Here's the file", followed by the file itself).

That request which your computer sends to the web server contains all sorts of (potentially) interesting information.  
We'll now examine the HTTP request your computer just sent to this web server, see what it contains, and find out what it tells me about you.

The raw information

```java
GET /dumprequest HTTP/1.1
Host: rve.org.uk
Connection: keep-alive
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/\*;q=0.8
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.104 Safari/537.36
Referer: https://www.google.com/
Accept-Language: en-US,en;q=0.8
```

## What are web APIs
- A server-side web API is a programmatic interface to a defined request-response message system, typically expressed in JSON or XML, which is exposed via the web—most commonly by means of an HTTP-based web server.
<br />
![ Overview of web APIs ] ( https://github.com/accesscode-2-1/unit-0/blob/master/images/APIs.jpg?raw=true )
![ Practical example ] ( https://github.com/accesscode-2-1/unit-0/blob/master/images/raspi-controls-lock.jpg?raw=true )
- [ REST API concepts and examples ] ( https://www.youtube.com/watch?v=7YcW25PHnAA )

## Combing various APIs -  Mashups

- A mashup, in web development, is a web page, or web application, that uses content from more than one source to create a single new service displayed in a single graphical interface. For example, you could combine the addresses and photographs of your library branches with a Google map to create a map mashup.[1] The term implies easy, fast integration, frequently using open application programming interfaces (open API) and data sources to produce enriched results that were not necessarily the original reason for producing the raw source data.
<br />
![ What is a mashup ] ( https://raw.githubusercontent.com/accesscode-2-1/unit-0/master/images/mashups.bmp ) 

<br />

## What is `JSON`
JSON stands for JavaScript Object Notation.  JSON is a lightweight data-interchange
format and it allows you to store and create data. It’s not a programming language. It’s not a markup language. 

So, what does that mean? To put it simply, it’s a file with data formatted to be readable by other programming languages.

While JSON isn’t really a language or can actually do anything on it’s own, it can be useful with data transportation. For example, 
let’s say you had a list of users and you wanted to send this data across various languages like PHP and JavaScript. Naturally, 
these are 2 different languages, but both languages understand JSON. By bridging this gap, you can make it easy to send data 
from one language to the other. 

### Advantages of using JSON:
- Human Readable
- Extremely lightweight, making it run faster than XML


## Helpful video
- [JavaScript and JSON tutorial: What is JSON? | lynda.com] ( https://www.youtube.com/watch?v=40aKlrL-2V8 )

### Simple Example
[ hosted version ] ( http://mercury.noip.us/json2.txt )
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

### Let's translate the example from early this morning into a json object

[ hosted version ] ( http://mercury.noip.us/json1.txt )

```json
{
    "judy-principal": {
        "teachers": [
            {
                "msDiaz": [
                    {
                        "kevin": {
                            "lunchbox": "red",
                            "numOfPencils": "2"
                        }
                    },
                    {
                        "Amanda": {
                            "lunchbox": "yellow",
                            "numOfPencils": "3"
                        }
                    },
                    {
                        "Billy": {
                            "lunchbox": "black",
                            "numOfPencils": "2"
                        }
                    }
                ]
            },
            {
                "msArcentales": [
                    {
                        "ray": {
                            "lunchbox": "black",
                            "numOfPencils": "3"
                        }
                    },
                    {
                        "mike": {
                            "lunchbox": "green",
                            "numOfPencils": "3"
                        }
                    },
                    {
                        "stacy": {
                            "lunchbox": "pink",
                            "numOfPencils": "3"
                        }
                    }
                ]
            },
            {
                "msLiu": [
                    {
                        "jackie": {
                            "lunchbox": "green",
                            "numOfPencils": "3"
                        }
                    },
                    {
                        "laura": {
                            "lunchbox": "yellow",
                            "numOfPencils": "2"
                        }
                    },
                    {
                        "tommy": {
                            "lunchbox": "blue",
                            "numOfPencils": "4"
                        }
                    }
                ]
            }
        ]
    }
}
```

### You think that was bad? If you minify the above block, you'll get: 

```json
{"judy-principal":{"teachers":[{"msDiaz":[{"kevin":{"lunchbox":"red","numOfPencils":"2"}},{"Amanda":{"lunchbox":"yellow","numOfPencils":"3"}},{"Billy":{"lunchbox":"black","numOfPencils":"2"}}]},{"msArcentales":[{"ray":{"lunchbox":"black","numOfPencils":"3"}},{"mike":{"lunchbox":"green","numOfPencils":"3"}},{"stacy":{"lunchbox":"pink","numOfPencils":"3"}}]},{"msLiu":[{"jackie":{"lunchbox":"green","numOfPencils":"3"}},{"laura":{"lunchbox":"yellow","numOfPencils":"2"}},{"tommy":{"lunchbox":"blue","numOfPencils":"4"}}]}]}}
```

### But have no fear, many awesome JSON viewers to choose from that will help make sense to of the madness:

- I like [code beautify](http://codebeautify.org/jsonviewer)




### Afternoon Hacking Assignment

A concordance lists every word that occurs in the document, and for each word it gives the line number of every line in the document where the word occurs. A concordance is like an index except that line numbers are used instead of page numbers.

Write a program that can create a concordance. The document should be read from an input file.

As you read the file, you want to take each word that you encounter and add it to the concordance along with the current line number.

Because it is so common, don't include the word "the" in your concordance. Also, do not include words that have length less than 3.  Feel free to add other “banned” words for testing purposes.

```java
public class Concordance {
   private HashSet<String> excludedWords;
   private Map<String, Set<Integer>> listing;

   public Concordance(String filename, Set<String> bannedWords)

   public Set<Integer> findLineNumbers(String word)
   public Set<Integer> getCommonLines(String word1, String word2)
   public void print()

}
```


[ moby dick - chapter 1 - loomings ] (https://github.com/accesscode-2-1/unit-0/blob/master/images/mobydick-chapter1-loomings.txt)


###Bonus: output as a json file
```java
   public void printJson()
```


## JSON Parsing

[ Parsing guide ](https://github.com/accesscode-2-1/unit-0/blob/master/lessons/week-4/2015-04-04-secret-kung-fu-masters-JSON-quick-start-guide.md)
