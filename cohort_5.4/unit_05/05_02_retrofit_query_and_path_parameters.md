# Retrofit Query and Path Parameters

# Objectives
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

The use the path in a service interface with a `@GET` annotated method:

```
public interface PuppyService {
    @GET("JDVila/storybook/blob/master/echinoderms.json")
    Call<Echinoderms> getEchinoderms();
}
```

Our url is pretty simple, and does not need any other modification. This is because it is a *static*, or non-changing endpoint.
