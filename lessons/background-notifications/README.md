- title: Notifications & Background Services
- tags: notification, intent, pending intent, intent service, broadcast receiver, alarm manager

# Objectives
- Learn how to display notifications to the user.
- Define what a PendingIntent is and include one in a notification.

# Resources
- [Notifications](https://developer.android.com/guide/topics/ui/notifiers/notifications.html)
- [Notifications - Design Patterns](https://material.google.com/patterns/notifications.html)
- [PendingIntent](https://developer.android.com/reference/android/app/PendingIntent.html)
- [IntentService](https://developer.android.com/reference/android/app/IntentService.html)
- [BroadcastReceiver](https://developer.android.com/reference/android/content/BroadcastReceiver.html)
- [Starting Background Services](https://guides.codepath.com/android/Starting-Background-Services)

# Lecture

## Notifications

A **notification** is a message you can display to the user outside of your application's normal UI. Notifications appear in the phone's notification area and then can be expanded to see more information. They're typically used to keep the user informed about events such as new email messages, new text messages or upcoming events.

The following code snippet displays a basic notification to the user:

```java
int NOTIFICATION_ID = 555;

NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("My notification")
                .setContentText("Hello World!");

// Get the notification manager system service
NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

 // Setting a notification ID allows you to update the notification later on.
notificationManager.notify(NOTIFICATION_ID, builder.build());
```

## PendingIntents

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

> **Exercise:** If you haven't already, complete the [Morning Challange](morning-challange.md) to display a Notification with a PendingIntent.
>
> **Exercise:** What is the difference between:
>    - A PendingIntent
>    - An implicit Intent
>    - An explicit Intent

## Background Services

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

> **Exercise:** Create an IntentService, `MyNotificationService.java` that displays a notification to the user in its `onHandleIntent()`. Register the service in your manifest and launch it from your `MainActivity.java` `onCreate()`.

## BroadcastReceiver

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
<receiver android:name="com.codepath.example.BootBroadcastReceiver">  
    <intent-filter>  
        <action android:name="android.intent.action.BOOT_COMPLETED" />  
    </intent-filter>  
</receiver>
```

> **Exercise:**  Extend `WakefulBroadcastReceiver` to start your `MyNotificationService` and display a notification to the user when your device boots. Reboot your device to confirm that your solution works.

## AlarmManager

Suppose we wanted to periodically execute a background task, such as show a notification to the user with `MyNotificationService` every 15 minutes. In this case, we don't necessarily want a long running task that runs forever and could drain battery life significantly. Using `AlarmManager`, we can setup a scheduler that triggers our `IntentService` to run at a chosen interval.

```java
public class MyAlarmReceiver extends BroadcastReceiver {
  public static final int REQUEST_CODE = 12345;
  public static final String ACTION = "nyc.c4q.notificationdemo.alarm";

  // Triggered by the Alarm periodically (starts the notification service)
  @Override
  public void onReceive(Context context, Intent intent) {
    Intent i = new Intent(context, MyNotificationService.class);
    context.startService(i);
  }
}
```
Register `MyAlarmReceiver` as a receiver in `AndroidManifest.xml`:

```xml
<receiver
    android:name=".MyAlarmReceiver"
    android:process=":remote" >
</receiver>
```

We can setup the recurring alarm in our `Activity` `onCreate()`:

```java
public class MainActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    scheduleAlarm();
  }
  
  // Setup a recurring alarm every half hour
  public void scheduleAlarm() {
      
    // Construct an intent that will execute the AlarmReceiver
    Intent intent = new Intent(getApplicationContext(), MyAlarmReceiver.class);
    
    // Create a PendingIntent to be triggered when the alarm goes off
    final PendingIntent pendingIntent = PendingIntent.getBroadcast(this, MyAlarmReceiver.REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);

    long firstMillis = System.currentTimeMillis(); // alarm is set right away
    
    AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
    
    // First parameter is the type: ELAPSED_REALTIME, ELAPSED_REALTIME_WAKEUP, RTC_WAKEUP
    // Interval can be INTERVAL_FIFTEEN_MINUTES, INTERVAL_HALF_HOUR, INTERVAL_HOUR, INTERVAL_DAY
    alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis, AlarmManager.INTERVAL_HALF_HOUR, pendingIntent);
  }
}
```

> **Exercise:** Extend `BroadcastReceiver` to start your `MyNotificationService` and display a notification to the user every 15 minutes using the `AlarmManager`.

## [Exit Ticket](https://goo.gl/forms/u4gaaMU4m7q6nTBo2)
