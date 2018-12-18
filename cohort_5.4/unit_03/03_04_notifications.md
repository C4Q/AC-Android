# Notifications

## Objectives
* Fellows will explore how Notifications are used in the Android Framework

## Resources
* [Core Concepts - Notifications](https://google-developer-training.github.io/android-developer-fundamentals-course-concepts-v2/unit-3-working-in-the-background/lesson-8-alarms-and-schedulers/8-1-c-notifications/8-1-c-notifications.html)
* [Notifications](https://developer.android.com/guide/topics/ui/notifiers/notifications.html)
* [Notification Channels](https://medium.com/exploring-android/exploring-android-o-notification-channels-94cd274f604c)
* [Notifications - Design Patterns](https://material.google.com/patterns/notifications.html)
* [PendingIntent](https://developer.android.com/reference/android/app/PendingIntent.html)
* [IntentService](https://developer.android.com/reference/android/app/IntentService.html)
* [BroadcastReceiver](https://developer.android.com/reference/android/content/BroadcastReceiver.html)
* [Starting Background Services](https://guides.codepath.com/android/Starting-Background-Services)

## Vocabulary

|Term|Definition|
|:-:|:-|
|**Notification**|message you can display to the user outside of your application's normal UI|
|**PendingIntent**|a description of an Intent and a target action to perform with it|
|**Service**|a component which runs in the background without direct user interaction|
|**IntentService**|a straightforward structure for running an operation on a single background thread|
|**Broadcast Receiver**|a component that responds to system-wide broadcast announcements|

# Lecture

## Warm Up - DO THIS FIRST! 👈👈👈

**1)** Create a new Android Studio project for today's exercises.

**2)** The following code snippet displays a basic notification to the user:

```java
// Setting a notification ID allows you to update the notification later on.
private static final int NOTIFICATION_ID = 555;

// Setting a notification channel allows the user to make choices about groups of notifications in later Android versions
private static final String NOTIFICATION_CHANNEL = "Pursuit Notifications";

NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("My notification")
                .setContentText("Hello World!");

NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

notificationManager.notify(NOTIFICATION_ID, builder.build());
```

Try displaying a new notification to the user in your MainActivity's `onCreate()`. 

*Hint: You'll need to add a notification_icon drawable resource to use as the notification icon.*

**3)** Create a new activity, `SecondActivity.java`. Add a pending intent to your notification that launches SecondActivity when the user clicks the notification.

*Hint: see ["Notification actions"](https://developer.android.com/guide/topics/ui/notifiers/notifications.html#CreateNotification)*.

# Lecture
* [Notifications](https://docs.google.com/presentation/d/1Ch8DeXY5D2xpZ5248x_X-_2eycRW7emzdSHMur32Dg0/edit#slide=id.p)

## Notifications

A **notification** is a message you can display to the user outside of your application's normal UI. Notifications appear in the phone's notification area and then can be expanded to see more information. They're typically used to keep the user informed about events such as new email messages, new text messages or upcoming events.

The following code snippet displays a basic notification to the user:

```java
int NOTIFICATION_ID = 555;
String NOTIFICATION_CHANNEL = "Pursuit Notifications";

NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("My notification")
                .setContentText("Hello World!");

// Get the notification manager system service
NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

 // Setting a notification ID allows you to update the notification later on.
notificationManager.notify(NOTIFICATION_ID, builder.build());
```

## Pending Intents

Notifications can also have actions attached that the user can perform by clicking, in the form of a `PendingIntent` which will fire when the user presses on the notification item.

```java
int NOTIFICATION_ID = 555;

// Define an intent to trigger when notification is selected (in this case to open an activity)
Intent intent = new Intent(this, SecondActivity.class);

// Turn this into a PendingIntent
int requestID = (int) System.currentTimeMillis(); // Unique requestID to differentiate between various notification with same notification ID
int flags = PendingIntent.FLAG_CANCEL_CURRENT; // Cancel old intent and create new one
PendingIntent pendingIntent = PendingIntent.getActivity(this, requestID, intent, flags);

// Attach the pendingIntent to a new notification using setContentIntent
Notification notification = new NotificationCompat.Builder(this)
        .setSmallIcon(R.drawable.notification_icon)
        .setContentTitle("My notification")
        .setContentText("Hello World!")
        .setContentIntent(pendingIntent)
        .setAutoCancel(true) // Hides the notification after its been selected
        .build();
        
// Get the notification manager system service
NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    
// Setting a notification ID allows you to update the notification later on.
notificationManager.notify(NOTIFICATION_ID, notification);
```

A `PendingIntent` is *a description of an Intent and a target action to perform with it.* A `PendingIntent` can be handed to other applications so that they can perform the action you described on your behalf at a later time. By giving a PendingIntent to another application, you are granting it the right to perform the actions you've specified as if the other application was yourself (with the same permissions and identity).

## Background Services with IntentService

A **service** is a component which runs in the background without direct user interaction. Since a service doesn't have a visible UI, it is not bound to the lifecycle of an activity and is able to run in the background even while the user is not viewing or interacting with your app. 

Services are often used for repetitive and potentially long running operations such as checking for and downloading updates from a server or processing data in a database.

An **IntentService** provides a straightforward structure for running an operation on a single background thread. For longer running tasks that are independent of a particular Activity, use IntentService. 

All requests are handled on a single worker thread -- they may take as long as necessary (and will not block the application's main loop), but only one request will be processed at a time.

To use an IntentService, define a class within your application that `extends IntentService`. Define the `onHandleIntent()` method to describe the work to do when this intent is executed:

```java
public class MyNotificationService extends IntentService {
    
    // Used to name the worker thread, important only for debugging.
    private static final String SERVICE_NAME = "notification-service";
    
    // Must create a default constructor
    public MyNotificationService() {
        super(SERVICE_NAME);
    }

    @Override
    public void onCreate() {
        super.onCreate(); // if you override onCreate(), make sure to call super().
        // If a Context object is needed, call getApplicationContext() here.
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // This describes what will happen when service is triggered, i.e. show a notification
    }
}
```

Each service needs to be registered in your `AndroidManifest.xml`:

```xml
<application
        android:icon="@drawable/icon"
        android:label="@string/app_name">

        <service
          android:name=".MyNotificationService"
          android:exported="false"/>
<application/>
```

Once the service is defined, we can trigger it from an `Activity` within our app:

```java
public class MainActivity extends Activity {
    
    // ... call launchTestService() in the Activity onCreate()
    
    public void launchTestService() {
        Intent i = new Intent(this, MyNotificationService.class);
        startService(i);
    }
}
```
You can start your `IntentService` from any `Activity` or `Fragment`. Once you call `startService()`, the `IntentService` does the work defined in its `onHandleIntent()` method, and then stops itself.

## Broadcast Receiver

A **broadcast receiver** is a component that responds to system-wide broadcast announcements. Many broadcasts originate from the system (e.g broadcast announce that the device has booted, the screen has turned off, the battery is low, or a picture was captured). Add permissions to `AndroidManifest.xml` in order to intercept system broadcasts:

```xml
<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
<uses-permission android:name="android.permission.WAKE_LOCK" />
```

If we wanted to start our service right after the device boots up, we could use a BroadcastReceiver to listen in for the system's `BOOT_COMPLETED` broadcast. When the system sends out the boot broadcast our `onReceive()` method would be called, from which we could start our service.

```java
// WakefulBroadcastReceiver ensures the device does not go back to sleep during the startup of the service
public class BootBroadcastReceiver extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent startServiceIntent = new Intent(context, MyNotificationService.class);
        startWakefulService(context, startServiceIntent);
    }
}
```

Register your receiver in `AndroidManifest.xml`:

```xml
<receiver android:name=".BootBroadcastReceiver">  
    <intent-filter>  
        <action android:name="android.intent.action.BOOT_COMPLETED" />  
    </intent-filter>  
</receiver>
```

## Exercises

* [Codelab - Notifications](https://codelabs.developers.google.com/codelabs/android-training-notifications/index.html?index=..%2F..%2Fandroid-training#0)

You will have until 11:00pm EST to complete this codelab. Please push all code for the "Coding Challenge" section to a remote repository on your Github account, then post it on the exercises link for today's lesson on Canvas.
