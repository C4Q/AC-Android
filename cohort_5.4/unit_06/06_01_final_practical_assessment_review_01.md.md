# Final Practical Assessment Review 01

## Objectives
* Fellows will explore the topics which will be covered in the Final Practical Assessment for Android

## Resources
* All lessons from Units 01 through 05

# Lecture

### Activities
**Expectations:** Fellows are expected to be able to make their own activity classes that inherit from AppCompatActivity, and add a corresponding XML Layout File. Fellows are expected to override Activity Lifecycle callback methods as necessary.

### Intents
**Expectations:** Fellows are expected to create explicit intents to move between their own app's activities. Fellows are expected to be able to pass intent extras between activities, and access this data in new activities. Fellows are expected to be able to sent implicit intents to open other external applications, and share data using intent extras between applications.

### Resources
**Expectations:** Fellows are expected to add all hardcoded values to resources files within the values folder. Fellows are expected to be able to reference String resouces directly in Java classes, and access them as necessary.

### Android Manifest
**Expectations:** Fellows are expected to be able to add internet, fine location, and course location permissions to the Android Manifest, as well as parent activity names to child activities to aid in effective activity backstack navigation.

### Gradle Dependencies
**Expectations:** Fellows are expected to be able to add library dependencies in gradle, by adding them directly to `build.gradle` files, or by utilizing the `Project Structure` menu option in the Android Studio IDE.

### Data Model POJO's and JSON
**Expectations:** Fellows are expected to interpret human-readable JSON text, and create data model classes based on the objects represented by the JSON data. 

### RetroFit and JSON
**Expectations:** Fellows are expected to be able to connect to a JSON endpoint using the Retrofit API and GSON, and use the data returned in the `onResponse()` callback method.

### RecyclerView
**Expectations:** Fellows are expected to utilize the RecyclerView API implement their own Adapter and ViewHolder classes, pass a list of data to the adapter, and manage the layout of the RecyclerView implementation. Fellows are also expected to handle click events for each RecyclerView itemview.

### Fragments
**Expectations:** Fellows are expected to subclass the Fragment class, and make their own fragments. Fellows are expected to inflate and swap fragments using a container layout within a host activity's layout. Fellows are expected to create static factory methods for their subclassed fragments to pass data from the activity to the fragments. Fellows are expected to communicate events and send data from fragments to their hosting activity using the listener pattern. Fellows are expected to add Fragments to the backstack as needed.

### SearchView
**Expectations:** Fellows are expected to implement SearchViews within their apps that change the data listed within their RecyclerViews, in such a way that only values which match particular search criteria are listed. Fellows should be able to update their RecyclerViews whenever characters are added or removed from the SearchView field.

### Sorting Algorithms and Sorting Helper Classes
**Expectations:** Fellows are expected to either implement their own sorting algorithms, or utilize sorting classes like `Collections`, `Comparator`, and/or `Comparable` to sort one or more values stored within one or more fields of an object within a data structure.

### Maps and MapFragments
**Expectations:** Fellows are expected to sublclass or utilize existing MapFragment classes, to display pin markers on a Google map within their own applications. Fellows should be able to display pin markers for specific lat/long coordinates, center their pins within a certain region, and add labels to their pins describing the names associated with their locations. Fellows should also be able to obtain required api keys from the Google Maps API.
