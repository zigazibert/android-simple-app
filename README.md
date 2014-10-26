android-simple-app
==================

Android app created during Android workshop in Youth center Kotlovnica Kamnik. I hope everyone learned a lot.

Activity
--------

Represents single window that shows UI to user. Activity class takes care of creating a window for us in which we can place our UI defined in XML file with setContentView(View) method.

```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
}
```
