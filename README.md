# RecyclerView Tutorial

## What is a RecyclerView?
A pretty common use-case in apps is displaying a list of the same type of item on the screen. For example, displaying restaurants, location options, or songs. Now, what you could do to display a list of items of to just create a View for each of these items and add them to a ScrollView and you'd be done. The problem with this is that it doesn't scale very well. As soon as there are a lot of Views, a lot of memory is eaten up and the app becomes much slower. What a RecyclerView does is binds a dataset to a list of Views, but it will "recycle" the same set of Views so that there are just enough to display what is currently on the screen.

## Getting Started
Open up Android Studio and create a new project. Make sure you check the "Use AndroidX artifacts" button when you are starting up. Here's a screenshot of what it should look like:

![alt tag](img/androidx.png)

Make sure you start with an Empty Activity.

## Gradle Imports
RecyclerView does not come packaged with the Android SDK by default, so we need to add it to our module's `build.gradle` file. You can find it on the left-hand side of Android Studio like in this picture:

![alt tag](img/build.png)

Make sure you select the one that says "Module" not the one that says "Project". Then, inside the `dependencies` scope, put this line:

```
implementation 'androidx.recyclerview:recyclerview:1.0.0'
```

It doesn't matter where in the `dependencies` scope, but just try to group it with the other `implementation` commands.

What we're doing by putting this command here is telling Gradle, an Android build system, that we want to include this library in our app. Putting the command here allows Gradle to automatically download and include this library in our app when we run it.

Once you've pasted the command here, make sure to press the Sync button that pops up in the top bar, so that Android Studio knows that we've included the RecyclerView library in our app.

## MainActivity UI
Now that we've included the RecyclerView library, we need to create our UI. Navigate to `activity_main.xml`, which is in the `res/layout/` folder and replace the context with the following:

```XML
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    </androidx.recyclerview.widget.RecyclerView>

</FrameLayout>
```
Basically, what we're doing here is just creating a screen that holds a RecyclerView. That's all we need to do for the MainActivity UI code.

## RecyclerView List Item UI
Now, we need to also define what each of the items in the list will look like. To do this, create a new file in the `res/layout` folder called `person_list_item.xml` and put the following contents into it:

```XML
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical" android:layout_width="wrap_content"
    android:layout_height="wrap_content">

    <TextView
        android:id="@+id/nameTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textStyle="bold"
        android:textSize="20sp"
        tools:text="Name" />

    <TextView
        android:id="@+id/ageTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="20sp"
        tools:text="Age: 21" />

</LinearLayout>
```

What we're doing here is just creating a layout of just two TextViews, one displaying a name and the other displaying an age. Each item in our list will just be the name and age of a Person, for simplicity sake.