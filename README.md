android-simple-app
==================

Android app created during Android workshop in Youth center Kotlovnica Kamnik. I hope everyone learned a lot.

Activity
--------

Represents single window that shows UI to user. Activity class takes care of creating a window for us in which we can place our UI defined in XML file with setContentView(View). Every activity contains at least one callback method called onCreate() inside of which we load our UI.

```java
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```

Intent 
------

Is an abstract description of an operation to be performed. It glues together different parts of Android system. Most commonly it is used with startActivity to launch an Activity.

**There are two primary forms of intens we will use:**
* **explicit intents** (we specify exact class/activity to be run)
```java
Intent glue = new Intent(MainActivity.this, SubActivity.class);
startActivity(glue);
```
* **implicit intents** (we include enough information for the system to determine which of the available components is best to run for that intent)
```java
Intent glue = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + url));
startActivity(glue);
```

