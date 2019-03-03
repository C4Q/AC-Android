# Retrofit Query and Path Parameters

## Objectives
* Fellows will explore how to receive data from multiple endpoints with the same base url
* Fellows will explore how to pass values for different url paths, and url queries

## Resources
* [Path Parameters](https://futurestud.io/tutorials/retrofit-optional-path-parameters)
* [Query Parameters](https://futurestud.io/tutorials/retrofit-optional-query-parameters)

# Lecture

Very often in class - we've encountered json endpoints that existed as a full url:

```
https://github.com/JDVila/storybook/blob/master/echinoderms.json
```

The url does not change based on what we need from it - it ismply is, and is call as-is.

This url consists of two parts...

The "Base Url":

```
https://github.com/
```

And the "Path":

```
JDVila/storybook/blob/master/echinoderms.json
```

We would create our simple `Retrofit` object using the base url:

``` java
Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
```

Then use the path in a service interface with a `@GET` annotated method:

```
public interface EchinodermService {
    @GET("JDVila/storybook/blob/master/echinoderms.json")
    Call<Echinoderms> getEchinoderms();
}
```

Our Url is pretty simple, and does not need any other modification. This is because it is a ***static***, or non-changing endpoint. However, this is not always the case, because most endpoints update when the database it pulls from updates. Also, an api endpoint might have too large of a dataset to send all at once, and will use **pagination**, or the technique of sending small sets of data every time you ask for more data (i.e. - sending 10 items at a time, rather than sending thousands, and expecting you to know what to do with it). Additionally, some endpoints might provide different sets of data, but all have the same endpoint, and how they vary can be based on a path name, or the values of query parameters passed in.

For example, you may want to connect to an endpoint like the ones from the [Star Wars API](https://www.swapi.co/), a free api that allows users to get information about the Star Wars saga. This endpoint also consists of the same url parts previously discussed, the base url and the path, as well a 3rd one - query parameters:

```
https://swapi.co/api/films/1/?format=json

// base url: https://swapi.co/
// path: api/films/1/
// query: format=json
```

With this url, we are asking the website server to provide us with data from a particular path, with a particular format value - in this case, JSON. Queries are sent as key/value pairs, and are denoted by the use of a `?` question mark immediately after the path. You can also pass multiple query parameters after the first key/value pair, as long as you use an `&` ampersand, rather than an additional `?` question mark.

For example, when making a simple Google search for the word "puppies", we end up at this url endpoint:

```
https://www.google.com/search?source=hp&ei=Mm97XN3WBufm5gK3vJGwCw&q=puppies&btnK=Google+Search&oq=puppies

// base url: https://www.google.com/
// path: search
// query #1: source=hp
// query #2: ei=Mm97XN3WBufm5gK3vJGwCw
// query #3: q=puppies
// query #4: btnK=Google+Search
// query #5: oq=puppies
```

As you can see, although the first query came immediately after a `?` character, all subsequent queries were preceded by an `&` character.


