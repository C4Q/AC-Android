# SearchView and RecyclerView

## Objectives
* Fellows will learn how to use a SearchView
* Fellows will respond to searches using a `SearchView.OnQueryTextListener` `onQueryTextChange(String s)` callback

## Resources
* [RecyclerView Review](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_02/02_20_recyclerview_review.md)
* [SearchView](https://developer.android.com/reference/android/widget/SearchView)

# Lecture

RecyclerViews truly are amazing. You can pass them a list of objects (with values), extract values from those objects, and display those values within recycled itemviews. However, previous implementations have forced us to display a fixed list - and if we ever updated the list, we'd have to call `notifyDataSetChanged()` to update the RecyclerView. This is still great! However, this is usually based on a change made in an external dataset (update from a Retrofit call, added new data), but not based on any user changes in realtime. What if we want to only show items in a list that match a user's specific criteria, as they enter it?

### What is a SearchView?

A SearchView is a widget that allows users to enter in search parameters, which can allow them to filter results within other views. It is effectively an EditText, with callbacks specific to searching and entering data. To display a SearchView in your XML, you could add something like this:

``` xml
<android.support.v7.widget.SearchView
    android:id="@+id/city_searchview"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:iconifiedByDefault="false">

    <requestFocus />
</android.support.v7.widget.SearchView>
```

### What is an `OnQueryTextListener`?

An `OnQueryTextListener`, specifically `SearchView.OnQueryTextListener`, when implemented by a class, allows it access to two methods which must be overridden:

* `public boolean onQueryTextSubmit(String s)`
* `public boolean onQueryTextChange(String s)`

We will not focus on the first method today, though it is useful for submitting String values. We will concentrate on the method `onQueryTextChange(String s)`, as we want to be notified whenever a value is entered or modified within our SearchView. For example:

``` java
public class SearchFragment extends Fragment implements SearchView.OnQueryTextListener{

    // member fields...
    
    private List<Names> namesList;
    private RecyclerView namesRecyclerView;
    
    ....
    
    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        // TODO - add filtering logic here
        return false;
        
    ....
}
```

### Filtering Data and Updating the RecyclerView

## Exercises
