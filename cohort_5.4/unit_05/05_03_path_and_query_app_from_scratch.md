# Weather API "App From Scratch"

## Objectives
* Fellows will work with an unfamiliar API to build an Android App
* Fellows will build an app based on an **ACTUAL CODING CHALLENGE FOR A PROFESSIONAL CODING JOB**

## Resources
* []()
* []()
* []()

# Lecture

## Weather app

There are a number of free APIs available with weather forecasts. Your goal is to use one to create an app that shows the weather forecast for New York.

You will have three hours to work on the assignment.  At the end of this time, please submit all code, project files, etc. that you have created.

## The API

The Aeris weather API is documented [here](http://www.aerisweather.com/support/docs/api/).

You will have to sign up for a (free) account to access this API. Sign up for an account, click on _Apps_, then _New Application_, and create a new app. You will then be given a client ID and a client secret, which you can include in the URL below.

You will use this URL to access the current weather forecast:

```
http://api.aerisapi.com/forecasts/11101?client_id=CLIENT_ID&client_secret=CLIENT_SECRET
```

If you have trouble signing up or registering an app, you can use [this](http://api.aerisapi.com/forecasts/11101?client_id=i5pHKBD39KOmHRkLoHcSi&client_secret=zjEUHJhnSKZR7yxrfXOU5QtFo3XGiyDjErG59s9M) URL.

## Guidelines

If you have experience with mobile (iOS or Android) or web development, select one of these platforms for your app.  

If you have used some other GUI framework or toolkit in the past, you may use that.  

You may use any programming language you wish.

## Assignment

Please work through these tasks, completing as many as you can in the allotted three hours. You are not expected to complete all of them, but do as many as you can. Try to do the tasks in order, but if you don't know how to complete a particular task, you may skip it and move to the next.

1. Verify that you are able to obtain a JSON response from the API, and familiarize yourself with the JSON results.  You will need the `minTempF` and `maxTempF` fields for low and high temperatures, and `dateTimeISO` field for the forecast date.

1. Write code to retrieve the weather forecast with an HTTP GET request, and parse the JSON response it returns.

1. Write an app that shows forecasted low and high temperatures for each day in the forecast. Note the a single API call will retrieve all of this information.

1. Create a GitHub repo and commit your app to it.

1. A set of weather icons is available as zip file in this repo. Each forecast includes an `icon` field, which names an icon from this collection.  For each day, show the icon corresponding to the forecast weather.

1. Add an interactive control to toggle between Farenheit and Celcius temperatures.

Use your best judgement in designing the user interface. [Here's](./example.png) a sample of what it might look like.


Your submission will be evaluated on functionality, code quality, and style.
