# Practical Final Review

### `Comparable` and `Comparator`

Objects are not numbers, and so they cannot be sorted as such, but they may have fields with values that CAN be compared, using the right methods.

`Comparable` and `Comparator` are both interfaces, and can be used to sort a collection of elements. 

However, there are many differences between Comparable and Comparator interfaces, which are described below:

|Comparable|Comparator|
|:--|:--|
|Comparable provides a single sorting sequence. In other words, we can sort the collection on the basis of a single element such as id, name, and price|The Comparator provides multiple sorting sequences. In other words, we can sort the collection on the basis of multiple elements such as id, name, price, etc.|
|Comparable affects the original class, i.e., the actual class is modified|Comparator doesn't affect the original class, i.e., the actual class is not modified|
|Comparable provides compareTo() method to sort elements|Comparator provides compare() method to sort elements|
|Comparable is present in java.lang package|A Comparator is present in the java.util package|
|We can sort the list elements of Comparable type by `Collections.sort(List)` method|We can sort the list elements of Comparator type by `Collections.sort(List, Comparator)` method|

When your class implements `Comparable`, the `compareTo()` method of the class is defining the "natural" ordering of that object. That method is contractually obligated (though not demanded) to be in line with other methods on that object, such as a 0 should always be returned for objects when the .equals() comparisons return true.

A `Comparator` is its own definition of how to compare two objects, and can be used to compare objects in a way that might not align with the natural ordering.

For example, Strings are generally compared alphabetically. Thus the "a".compareTo("b") would use alphabetical comparisons. If you wanted to compare Strings on length, you would need to write a custom comparator.

`Comparable` is commonly used to define sorting expectations for classes which the developer can modify. `Comparator` is used to sort objects of classes which the developer **CANNOT** modify. In other words, if you have the ability to create or modify your own data model classes or POJO's, you should have those classes implement `Comparable` - otherwise, you'll have to subclass your own `Comparator` implementation.

In this review, we will explore `Comparable` with a data class of our own creation. For example:

```java
public class Avenger implements Comparable<Avenger>, Serializable {

    private final String name;
    private final String weapon;

    public Avenger(String name, String weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public String getWeapon() {
        return weapon;
    }

    @Override
    public int compareTo(Avenger o) {
        int avenger = this.getName().toLowerCase().compareTo(o.getName().toLowerCase());
        return avenger;
    }
}
```

will allow us to sort a list of Avengers alphabetically by the `name` field value, using the `Collections.sort()` method:

```java
List<Avenger> avengerList = new ArrayList<>();
avengerList.add(new Avenger("Thor", "Stormbreaker"));
avengerList.add(new Avenger("Captain America", "Shield"));
avengerList.add(new Avenger("Iron Man", "Nanosuit"));
avengerList.add(new Avenger("Captain Marvel", "Going Binary"));
Collections.sort(avengerList)
```

What is actually being compared here in the `compareTo(Avenger o)` method, and why does it return an `int` value?

Essentially, `this.compareTo(that)` returns

* a negative `int` if this < that, i.e. `-1`
* 0 if this == that, i.e. `0`
* a positive `int` if this > that, i.e. `1`

These strings are being compared alphabetically, so effectively, apple < applegate, fresh > damp, and tomato == tomato.

### Serializable

In computer science, in the context of data storage, serialization is the process of translating data structures or object state into a format that can be stored or transmitted and reconstructed later. When the resulting series of bits is reread according to the serialization format, it can be used to create an identical clone of the original object.

In Android, we can use the interfaces `Serializable` and `Parcelable` to perform similar functionality. However, we will quickly explore how to use the `Serializable` interface to modify our data classes, and use casting to change the type of the object back to its original form.

For example, let's say we wanted to pass an `Avenger` object from an `Activity` to a `Fragment`, because we've added a number of fields to the class, and we want to pass all of those values to the fragment, without having to add them all as arguments to the bundle. Because the class implements `Serializable`, we can use the `putSerializable()` method to add the entire object:

```java
Avenger thor = new Avenger("Thor", "Stormbreaker", "Blonde", "Eyepatch", 1500, "Asgard");
AvengerDetailFragment avengerDetailFragment = new AvengerDetailFragment();
Bundle args = new Bundle();
args.putSerializable("avenger", thor);
avengerDetailFragment.setArguments(args);
FragmentManager fragmentManager = getSupportFragmentManager();
FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
fragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
fragmentTransaction.replace(R.id.fragment_container_frameLayout, avengerDetailFragment);

fragmentTransaction.addToBackStack(getResources().getString(R.string.avenger_detail_fragment));

fragmentTransaction.commit();
```

and inside the fragment, you could then access that object from the bundle argument, and **CAST IT BACK** to an `Avenger` object:

```java
Avenger avenger = (Avenger) getArguments().getSerializable("avenger");
```

### MapFragments

Implementing a Map as a Fragment is actually pretty easy, but a few steps need to be implemented first before any code is actually written:

1. Add `implementation 'com.google.android.gms:play-services-maps:16.1.0'` to your app's `build.gradle` file
1. Add `google()` and `jcenter()` to the `buildscript` and `allprojects` repository sections of your project's `build.gradle` file
1. Add `<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>` and `<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>` permissions to your `AndroidManifest.xml` file
1. Apply for an API Key from the Google Maps API website
1. Add metadata to the manifest within the `<application>` tags: `<meta-data android:name="com.google.android.geo.API_KEY" android:value="ABcde456fGHijkL9854mnoPqRsTUV_wxyz" />`
1. Add the `<uses-feature>` tag **OUTSIDE** the `<application>` tags, but **INSIDE** the `<manifest>` tags: `<uses-feature android:glEsVersion="0x00020000" android:required="true" />`

Once these steps are completed, you can finally begin to implement your map fragment. First, simply generate a Fragment by going to the menu, and creating a new fragment (or compose the fragment from scratch). Next, add the view `<om.google.android.gms.maps.MapView>` to the fragments layout file, and have it fill the screen:

```java
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".fragments.LibraryFragment">

    <com.google.android.gms.maps.MapView
        android:id="@+id/library_mapView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</FrameLayout>
```

Next, have the fragment implement the callback `OnMapReadyCallback`:

```java
public class LibraryFragment extends Fragment implements OnMapReadyCallback
```

Then, set the map async on the MapView within the Fragment in `onViewCreated()`:

```java
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = view.findViewById(R.id.library_mapView);
        if(mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }
```

Finally, we'll have to override the `onMapReady(GoogleMap googleMap)` method:

```java
    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(lat, lon)).title(name));
        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(lat, lon)).zoom(10.0f).build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
        googleMap.moveCamera(cameraUpdate);
    }
```

In the end, your fragment class should look something like this:

```java
public class LibraryFragment extends Fragment implements OnMapReadyCallback {
    private static final double ARG_PARAM1 = "param1";
    private static final double ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    private MapView mapView;
    
    private double lat;
    private double lon;
    private String name;

    public LibraryFragment() {
    }

    public static LibraryFragment newInstance(double lat, double lon, String name) {
        LibraryFragment fragment = new LibraryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, lat);
        args.putString(ARG_PARAM2, lon);
        args.putString(ARG_PARAM3, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            lat = getArguments().getDouble(ARG_PARAM1);
            lon = getArguments().getDouble(ARG_PARAM2);
            name = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_library, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = view.findViewById(R.id.library_mapView);
        if(mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(lat, lon)).title(name));
        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(lat, lon)).zoom(10.0f).build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
        googleMap.moveCamera(cameraUpdate);
    }
}
```
