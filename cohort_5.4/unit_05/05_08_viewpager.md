# ViewPager

## Objectives
* Fellows will learn about additional list-like views
* Fellows will learn how to implement a ViewPager within an Android Application

## Resources
* [Android ViewPager](https://developer.android.com/reference/android/support/v4/view/ViewPager)

# Lecture

In class, we have explored a number of list-like views in Android:
* ListView
* Menus
* Pickers
* Spinners
* Navigation Bar Menu
* RecyclerView

All of these views display lists of items on the screen, and in some cases, as in the itemview of a RecyclerView, can be quite complex. You can even display these views either horizontal, or vertical. However, individual itemviews do not fill the entire screen, and if they do, they do not stay in place. This is where `ViewPager` implementations can become handy.

![viewpager](https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fi.imgur.com%2FUXpVigQ.gif)

### What is a ViewPager?

A ViewPager is the widget that allows the user to swipe left or right to see an entirely new screen. It also has the ability to dynamically add and remove pages at anytime. Consider the idea of grouping search results by certain categories, and showing each category in a separate list. With the ViewPager, the user could then swipe left or right to see other categorized lists.

### Fragments and ViewPagers

Fragments are used to display layouts, while a ViewPager is used to iterate through a list of Fragments, and display each one when swiped. If you are familiar with RecyclerView implementations (as you should all be by now), implementing a ViewPager should be fairly elementary.

Things required for a ViewPager implementation:
* an Activity that extends `FragmentActivity`
* an Adapter that extends `FragmentPagerAdapter`
* a ViewPager widget, i.e. `android.support.v4.view.ViewPager`
* a list of fragment instances

First, let's create our Activity:

``` java
package org.pursuit.viewpagerexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```

Next, let's add the appropriate ViewPager widget to the Activity's layout:

``` xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <android.support.v4.view.ViewPager
        android:id="@+id/mainActivity_viewPager"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>
```

Now, let's make a Fragment to display text, and an image. In the XML:

``` xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ViewPagerFragment">

    <TextView
        android:id="@+id/viewpager_textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:textSize="40sp"
        app:layout_constraintBottom_toTopOf="@+id/viewpager_imageview"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <ImageView
        android:id="@+id/viewpager_imageview"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/viewpager_textView" />

</android.support.constraint.ConstraintLayout>
```

And in the actual Fragment class:

``` java
package org.pursuit.viewpagerexample;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewPagerFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private TextView textView;
    private ImageView imageView;

    public ViewPagerFragment() {
    }

    public static ViewPagerFragment newInstance(String param1, String param2) {
        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_pager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.viewpager_textView);
        imageView = view.findViewById(R.id.viewpager_imageview);
        textView.setText(mParam1);
        Picasso.get().load(mParam2).into(imageView);
    }
}
```

Next, we'll have to create an adapter to return a fragment based on where we are when we swipe:

``` java
package org.pursuit.viewpagerexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
```

Finally, let's create a list of individually unique fragement instances:

``` java
List<Fragment> fragmentList = new ArrayList<>();

fragmentList.add(ViewPagerFragment.newInstance("Apple", "https://www.dialfredo.com/wp-content/uploads/2015/05/redapplepic.jpg"));
fragmentList.add(ViewPagerFragment.newInstance("Orange", "https://colourchroma.files.wordpress.com/2011/08/orange.jpg"));
fragmentList.add(ViewPagerFragment.newInstance("Banana", "https://target.scene7.com/is/image/Target/GUEST_f5d0cfc3-9d02-4ee0-a6c6-ed5dc09971d1?wid=488&hei=488&fmt=pjpeg"));

```

And add the list to an adapter, and set that adapter to the ViewPager:

``` java
ViewPager viewPager = findViewById(R.id.mainActivity_viewPager);
viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragmentList));
```

The finished Activity should look something like this:
``` java
package org.pursuit.viewpagerexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Fragment> fragmentList = new ArrayList<>();

        fragmentList.add(ViewPagerFragment.newInstance("Apple", "https://www.dialfredo.com/wp-content/uploads/2015/05/redapplepic.jpg"));
        fragmentList.add(ViewPagerFragment.newInstance("Orange", "https://colourchroma.files.wordpress.com/2011/08/orange.jpg"));
        fragmentList.add(ViewPagerFragment.newInstance("Banana", "https://target.scene7.com/is/image/Target/GUEST_f5d0cfc3-9d02-4ee0-a6c6-ed5dc09971d1?wid=488&hei=488&fmt=pjpeg"));

        ViewPager viewPager = findViewById(R.id.mainActivity_viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragmentList));
    }
}
```

## Exercises
Visit the canvas calendar for today's date to find today's exercises.
