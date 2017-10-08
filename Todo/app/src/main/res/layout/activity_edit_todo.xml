<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <android.support.design.widget.AppBarLayout
            android:id="@+id/app_bar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:theme="@style/AppTheme.AppBarOverlay"
            app:elevation="0dp">

            <android.support.v7.widget.Toolbar
                android:id="@+id/toolbar"
                style="@style/ToolbarStyle"
                android:layout_width="match_parent"
                android:layout_height="?attr/actionBarSize"
                app:title="@string/app_name" />

        </android.support.design.widget.AppBarLayout>

        <FrameLayout
            android:id="@+id/content"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_below="@+id/app_bar">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:gravity="center"
                android:orientation="vertical"
                android:padding="16dp">

            </LinearLayout>

            <TextView
                android:id="@+id/error_text"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:gravity="center"
                tools:text="ERROR MESSAGE" />

            <ProgressBar
                android:id="@+id/progress_bar"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:visibility="gone"
                tools:visibility="visible" />
        </FrameLayout>
    </RelativeLayout>
</layout>
