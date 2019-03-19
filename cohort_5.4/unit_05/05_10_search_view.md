# SearchView and RecyclerView

## Objectives
* Fellows will learn how to use a SearchView
* Fellows will respond to searches using a `SearchView.OnQueryTextListener` `onQueryTextChange(String s)` callback

## Resources
* [RecyclerView Review](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_02/02_20_recyclerview_review.md)
* [SearchView](https://developer.android.com/reference/android/widget/SearchView)

# Lecture

RecyclerViews truly are amazing. You can pass them a list of objects (with values), extract values from those objects, and display those values within recycled itemviews. However, previous implementations have forced us to display a fixed list - and if we ever updated the list, we'd have to call `notifyDataSetChanged()` to update the RecyclerView. This is still great! However, this is usually based on a change made in an external dataset (update from a Retrofit call, added new data), but not based on any user changes in realtime. What if we want to only show items in a list that matches a user's specific criteria, as they enter it?

## Exercises
