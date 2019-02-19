# Fragment Callback Communication Revisited

## Objectives
* Fellows will review how to use interface callback methods to send data from a Fragment to its host Activity
* Fellows will review how to use static factory methods to send data from a host Activity to a Fragment

# Resources
* [Intro to Fragments](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_03_intro_to_fragments.md)
* [Fragments and Fragment Transactions](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_04_fragments_and_fragment_transactions.md)
* [Fragment Lifecycle and Communications](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_05_fragment_lifecycle_and_communications.md)
* [Fragments Review](https://github.com/joinpursuit/Pursuit-Core-Android/blob/master/cohort_5.4/unit_04/04_06_fragments_review.md)
* [Creating Custom Listeners](https://guides.codepath.com/android/Creating-Custom-Listeners)

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
        weapon: "Unbridled Electricity";
        break;
    }
    return weapon;
  }
}
```

Then `Thor` would have to implement each of `NorseGod`'s methods.

### What are Listeners?

Listeners represent the interfaces responsible for handling events. Effectively, for fragment interface callbacks - interfaces are implemented by classes, the classes are instantiated, the methods are overridden, and their reference is then passed to other classes, which can then cast the references to the static type of the interface, and call the overridden methods as needed, triggering the code within the overridden methods to run.

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



## Exercises
