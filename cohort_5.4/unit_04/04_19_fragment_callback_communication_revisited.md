# Fragment Callback Communication Revisited

## Objectives
* Fellows will review how to use interface callback methods to send data from a Fragment to its host Activity
* Fellows will review how to use static factory methods to send data from a host Activity to a Fragment

## Resources
* [Intro to Fragments](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_03_intro_to_fragments.md)
* [Fragments and Fragment Transactions](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_04_fragments_and_fragment_transactions.md)
* [Fragment Lifecycle and Communications](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_05_fragment_lifecycle_and_communications.md)
* [Fragments Review](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_06_fragments_review.md)
* [Creating Custom Listeners](https://guides.codepath.com/android/Creating-Custom-Listeners)

## Warm-Up - DO THIS FIRST!!! (10 Minutes)
Unzip the [project file here](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/projects/FragmentCallbacks.zip), and describe, in your own words, exactly how the fragments send and receive data between the activity that hosts them.

# Lecture

So far, we've discussed the Fragment Lifecycle, Fragment Management, Fragment Transactions, Bundle Arguments, and the Backstack. We've even discussed Fragment static factory methods, and the use of interface callback methods to communicate between a Fragment, and its hosting Activity. Today, we'll explicitly explore these last two topics together.

### What Is an Interface?

According to the Java docs:

*"In its most common form, an interface is a group of related methods with empty bodies... To implement this interface, the name of your class would change, and you'd use the implements keyword in the class declaration... Interfaces form a contract between the class and the outside world, and this contract is enforced at build time by the compiler. If your class claims to implement an interface, all methods defined by that interface must appear in its source code before the class will successfully compile."*

In other words, an `interface` is a promise of sorts - if you implement the interface, it is expected that you will have to fill each of those abstract methods' method bodies (the space within its `{` and `}` curly braces/brackets) with code that matches its expected behavior. For example, if there exists an interface called `NorseGod.java`:

``` java 
public interface NorseGod {

  void sayMyName();
  String weapon(String movie);

}
```

And a class that implements the interface called `Thor.java`:

``` java
public class Thor implements NorseGod {

  @Override
  public void sayMyName() {
    System.out.println("I am Thor, King of Asgard!");
  }
  
  @Override
  public String weapon(String movie) {
    String weapon = "";
    switch(movie){
      case "Iron Man 2":
      case "Thor":
      case "The Avengers":
      case "Thor: The Dark World":
      case "Avengers: Age of Ultron":
        weapon = "Mjölnir";
        break;
      case "Avengers: Infinity War":
      case "Avengers: Endgame":
        weapon = "Stormbreaker";
        break;
      default:
        weapon = "Unbridled Electricity";
        break;
    }
    return weapon;
  }
}
```

Then `Thor` would have to implement each of `NorseGod`'s methods.

### What are Listeners?

Listeners represent the interfaces responsible for handling events. Effectively, for fragment interface callbacks - interfaces are implemented by classes, the classes are instantiated, the methods are overridden, and their reference is then passed to other classes (fragments), which can then cast the references to the static type of the interface, and call the overridden methods as needed, triggering the code within the overridden methods to run.

That was a lot. Here's a Dalmation eating some ice cream:

![dalmation eating ice cream](http://pawedpets.org/wp/wp-content/uploads/dalmation-eating-ice-cream.jpg)

Okay, back to listeners.

For example, let's say we have a fragment subclass called `InputFragment.java`:

``` java
package org.pursuit.fragmentcallbacks.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.pursuit.fragmentcallbacks.R;

public class InputFragment extends Fragment {

    private OnInputFragmentInteractionListener mListener;
    private View rootView;
    private EditText inputEditText;
    private Button inputSubmitButton;

    public InputFragment() {}

    public static InputFragment newInstance() {
        InputFragment fragment = new InputFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_input, container, false);
        inputEditText = rootView.findViewById(R.id.input_fragment_editText);
        inputSubmitButton = rootView.findViewById(R.id.input_fragment_submit_button);
        inputSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputTextString = inputEditText.getText().toString();
                onButtonPressed(inputTextString);
            }
        });
        return rootView;
    }

    public void onButtonPressed(String input) {
        if (mListener != null) {
            mListener.onInputFragmentInteraction(input);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnInputFragmentInteractionListener) {
            mListener = (OnInputFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnInputFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnInputFragmentInteractionListener {
        void onInputFragmentInteraction(String input);
    }
}
```

In this fragment, we have a public interface called `OnInputFragmentInteractionListener`:

``` java
public interface OnInputFragmentInteractionListener {
    void onInputFragmentInteraction(String input);
}
```

This interface can then be "subclassed" by an Activity, and have its abstract method overridden by that activity. For example, in the `MainActivity.java` class:

``` java
package org.pursuit.fragmentcallbacks;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.pursuit.fragmentcallbacks.fragments.DisplayFragment;
import org.pursuit.fragmentcallbacks.fragments.InputFragment;

public class MainActivity extends AppCompatActivity implements InputFragment.OnInputFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputFragment inputFragment = InputFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_activity_container, inputFragment).commit();
    }

    @Override
    public void onInputFragmentInteraction(String input) {
        DisplayFragment displayFragment = DisplayFragment.newInstance(input);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_activity_container, displayFragment)
                .addToBackStack(DisplayFragment.KEY).commit();
    }
}
```

we can see that the interface method `onInputFragmentInteraction` is overridden and implemented by the activity:

``` java
@Override
public void onInputFragmentInteraction(String input) {
    DisplayFragment displayFragment = DisplayFragment.newInstance(input);
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.main_activity_container, displayFragment)
            .addToBackStack(DisplayFragment.KEY).commit();
}
```

This method, when called, starts the process of having the MainActivity replace one fragment with another one. This method is expected to be called in the `InputFragment`, triggered by an event from within that particular fragment - perhaps a button click. The actual triggering event doesn't matter - what matters is that when the event does occur, it calls that activity method from within the fragment, causing the activity to swap fragments. The `InputFragment` doesn't need to know that the `MainActivity` will call logic that will switch fragments - it just needs to tell the activity that something in the fragment happened. The fragment is ignorant to what the activity does, but the activity is aware of what the fragment does, because that particular listener method was called from that particular fragment. 

Alright - that was intense. Let's take a moment to appreciate this cat eating a sandwich:

![cat eating sandwich](https://pbs.twimg.com/media/CEVBfHmWIAAxDyi.png)

Everyone good? Great - let's talk more about how that listener is passed to the fragment in the first place.

Remember Fragment Lifecycle Callbacks? There are a lot of them, and you're forgiven for not knowing them all by heart. Here's a quick list of them:

1. onAttach()
1. onCreate()
1. onCreateView()
1. onViewCreated()
1. onActivityCreated()
1. onStart()
1. onPause()
1. onStop()
1. onDestroyView()
1. onDestroy()
1. onDetach()

The methods that concern us in relation to getting and cleaning up our listener in this case are `onAttach()` and `onDetach()`.

`onAttach()` is called first when a fragment is live, even before `onCreate()`, letting us know that our fragment has been attached to an activity. We are passed the context of the Activity that hosts our fragment. This means that we can take this context (essentially `MainActivity`), then cast it back to the static type of the `OnInputFragmentInteractionListener` interface (since it implements this interface), and store this object globally within our particular fragment:

``` java
@Override
public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof OnInputFragmentInteractionListener) {
        mListener = (OnInputFragmentInteractionListener) context;
    } else {
        throw new RuntimeException(context.toString()
                + " must implement OnInputFragmentInteractionListener");
    }
}
```

Now, when an event is triggered from within the fragment, it can call the overridden `onInputFragmentInteraction(input)` method in the activity, through the reference in the `OnInputFragmentInteractionListener mListener` object:

``` java
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    rootView = inflater.inflate(R.layout.fragment_input, container, false);
    inputEditText = rootView.findViewById(R.id.input_fragment_editText);
    inputSubmitButton = rootView.findViewById(R.id.input_fragment_submit_button);
    inputSubmitButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String inputTextString = inputEditText.getText().toString();
            
            // when the button is clicked, the overridden interface listener method is called:
            onButtonPressed(inputTextString);
            
        }
    });
    return rootView;
}

....

public void onButtonPressed(String input) {
    if (mListener != null) {
        mListener.onInputFragmentInteraction(input);
    }
}

```

Finally, to avoid holding a reference to the hosting activity for longer than we should, we override the `onDetach()` method, to make sure we've availed it to garbage collection, whenever the activity is finally destroyed:

``` java
@Override
public void onDetach() {
    super.onDetach();
    mListener = null;
}
```

The activity can now pass the data from the first fragment, pass that data to a second fragment, then swap the first fragment for the second one - all without either fragment being aware of the process:

``` java
@Override
public void onInputFragmentInteraction(String input) {
    DisplayFragment displayFragment = DisplayFragment.newInstance(input);
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.main_activity_container, displayFragment)
            .addToBackStack(DisplayFragment.KEY).commit();
}
```

And how does that other fragment get access to that data passed to it without explicitly setting bundle arguments? It does it internally using a static factory instance method:

``` java
public static DisplayFragment newInstance(String param1) {
    DisplayFragment fragment = new DisplayFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    fragment.setArguments(args);
    return fragment;
}

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
        mParam1 = getArguments().getString(ARG_PARAM1);
    }
}
```

This process of using implemented subclassed interfaces as listeners is foundational to a number of application architectural design patterns. By doing this, we are effectively "separating concerns" between the views (Fragments), and the classes that control them and/or respond to their events (Activities).

You've done well. Here are a couple of fun piglets swimming in the caribbean sea:

![fun piglets swimming in the caribbean sea](https://www.fb101.com/wp-content/uploads/2014/06/7875531868_9f9ec85b6b_o.jpg.CROP_.promo-large2.jpg)

## Exercises
Please visit the canvas calendar for today's date, to find today's exercises.
