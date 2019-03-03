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

The url does not change based on what we need from it - it simply is, and is called as-is.

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

Now, if you wanted to get the data for an individual film in the saga, you could hit the following endpoint:

```
https://swapi.co/api/films/?format=json
```

Then search through every single entry returned from the `@GET` annotated method:

```
public interface StarWarsService {
    @GET("api/films/?format=json")
    Call<StarWarsData> getStarWarsData();
}
```

This is... fine. However, it involves a lot of iterative searching to find the right film. You could, if you wanted to, make multiple methods to connect to multiple paths, but this would involve writing a lot of individual methods specific to each film:

```
public interface StarWarsService {

    @GET("api/films/1/?format=json")
    Call<StarWarsMovie> getANewHopeData();
    
    @GET("api/films/2/?format=json")
    Call<StarWarsMovie> getTheEmpireStrikesBack();
    
    @GET("api/films/3/?format=json")
    Call<StarWarsMovie> getReturnOfTheJedi();
    
    // This is a terrible movie
    @GET("api/films/4/?format=json")
    Call<StarWarsMovie> getThePhantomMenace();
    
    // This is also a bad film
    @GET("api/films/5/?format=json")
    Call<StarWarsMovie> getAttackOfTheClones();
    
    // This is the least horrible of all the prequels
    @GET("api/films/6/?format=json")
    Call<StarWarsMovie> getRevengeOfTheSith();
    
    @GET("api/films/7/?format=json")
    Call<StarWarsMovie> getTheForceAwakens();
    
}
```

This is a pretty good solution, but these methods are not DRY, in the sense that we end up calling an almost identical endpoint every single time, but only with a minor change to the chronological number path value - yet we have 7 distinct methods. We can instead create one method signature, that accepts a single parameter from where the actual retrofit call is being made - that way we can leave the business logic to another class to determine which film's data you actually want. For example, we could change our interface to look like this:

```
public interface StarWarsService {

    @GET("api/films/{filmOrder}/?format=json")
    Call<StarWarsMovie> getMovieData(@Path("filmOrder") String filmOrder);
}
```

And make a call that looks like this:

```
String filmNumber = "-1";
switch(movieChoice) {
  case "The Phantom Menace":
    filmNumber = "4";
    break;
  case "Attack of the Clones":
    filmNumber = "5";
    break;
  case "Revenge of the Sith":
    filmNumber = "6";
    break;
  case "A New Hope":
    filmNumber = "1";
    break;
  case "The Empire Strikes Back":
    filmNumber = "2";
    break;
  case "Return of the Jedi":
    filmNumber = "3";
    break;
  case "The Force Awakens":
    filmNumber = "7";
    break;
  default:
    filmNumber = "1";
    break;
}

starWarsService = retrofit.create(StarWarsService.class);

Call<StarWarsMovie> movie = starWarsService.getMovieData(filmNumber);
```

Queries work in a similar way, except you don't have to worry about adding a placeholder to the path - you can simply add the path, ignore adding the queries directly to the path, then pass in each query to the method. For example, for the url:

```
https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1&api_key=DEMO_KEY
```

We could create a `Retrofit` object like this:

```
Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
```

With an interface like this:

```
public interface NasaPhotoService {
    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    Call<NasaPhotos> getPhotos(@Query("sol") String sol, @Query("api_key") String api_key);
}
```

Then assign the actual call:

```
NasaPhotoService = retrofit.create(NasaPhotoService.class);

Call<NasaPhotos> movie = NasaPhotoService.getPhotos("1", "DEMO_KEY");
```

Queries can be used to pass API keys, however this isn't always the best way to do this, since API keys should be kept private, and passing an API key as a query can expose this data directly in the Url. We will discuss this further in another lesson. However, these techniques will get you pretty far when querying data or when attempting to reach multiple endpoint paths, with the same base url, without having to rewrite too much code.

## Exercises

Please see the canvas calendar for today's date for the exercises associated with today's lesson.
