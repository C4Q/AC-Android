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
    private NameAdapter nameAdapter;
    
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

Let's say we have a list of objects containing the names of clients. However, we also want the users of our app to filter the names based on certain criteria. We can accept user information, then filter that information through our list - and only display names that start with the right letters:

``` java
    @Override
    public boolean onQueryTextChange(String s) {
        List<City> newNamesList = new ArrayList<>();
        for(Name name : namesList) {
            if(name.getFullName().contains(s)) {
                newNamesList.add(name);
            }
        }
        return false;
    }
```

However, `.contains()` might not be sufficient, as the name could contain those numbers anywhere in its String. We would be better off using the String method `.startsWith()` instead:

``` java
    @Override
    public boolean onQueryTextChange(String s) {
        List<City> newNamesList = new ArrayList<>();
        for(Name name : namesList) {
            if(name.getFullName().startsWith(s)) {
                newNamesList.add(name);
            }
        }
        return false;
    }
```

We're on the right path, but this will only give us the results that match the beginning of the string EXACTLY, i.e. if a user searches for "Lan", it will ignore names that have case variations, like "lAn", "LaN", "LAN", or "lan". Let's modify our search to be more inclusive, by only comparing their lowercase versions:


``` java
    @Override
    public boolean onQueryTextChange(String s) {
        List<City> newNamesList = new ArrayList<>();
        for(Name name : namesList) {
            if(name.getFullName().toLowerCase().startsWith(s.toLowerCase())) {
                newNamesList.add(name);
            }
        }
        return false;
    }
```

Great! Now that we've made a list specific to whatever the user searches for, we can update our RecyclerView data! The easiest way would simply be to add the list to a new RecyclerView Adapter instance, then set a new adapter for the RecyclerView:


``` java
    @Override
    public boolean onQueryTextChange(String s) {
        List<City> newNamesList = new ArrayList<>();
        for(Name name : namesList) {
            if(name.getFullName().toLowerCase().startsWith(s.toLowerCase())) {
                newNamesList.add(name);
            }
        }
        namesRecyclerView.setAdapter(new NameAdapter(newNamesList));
        return false;
    }
```

Although this works, it involves creating a number of new adapter instances in memory whenever a user searches for something. A way to avoid this would be to add a method to the RecyclerView Adapter class that updates the actual list the adapter uses to display data on the screen:

``` java
public class NameAdapter extends RecyclerView.Adapter<NameViewHolder> {

    private List<City> nameList;

    public NameAdapter(List<Name> nameList) {
        this.nameList = nameList;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.name_itemview, viewGroup, false);
        return new NameViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder nameViewHolder, int i) {
        Name name = nameList.get(i);
        nameViewHolder.onBind(name);
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }
    
    // update list method
    
    public void setData(List<Name> newNameList) {
        this.nameList = newNameList;
        notifyDataSetChanged();
    }
}
```

Now, we can simply update the data contained in the adapter:

``` java
    @Override
    public boolean onQueryTextChange(String s) {
        List<City> newNamesList = new ArrayList<>();
        for(Name name : namesList) {
            if(name.getFullName().toLowerCase().startsWith(s.toLowerCase())) {
                newNamesList.add(name);
            }
        }
        nameAdapter.setData(newNamesList);
        return false;
    }
```

And Voila! You have an updated RecyclerView list, updated in real-time!

## Exercises

Please visit the canvas calendar for today's date to find today's exercises.
