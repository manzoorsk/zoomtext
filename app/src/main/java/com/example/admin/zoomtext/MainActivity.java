package com.example.admin.zoomtext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static TextView text;
    ScaleGestureDetector scaleGestureDetector,scaleGestureDetector1;

    String name = "How to make zoom in / out scrollview in android?\n" +
            "\n" +
            "up vote\n" +
            "0\n" +
            "down vote\n" +
            "favorite\n" +
            "In my android application I need to create activities zoom able.nut in my application couple of activities start with scrollview and this code does not recognize scrollview. How can I make pinch zoom for scrollable activity? This is one of my layout.\n" +
            "\n" +
            "also tried also ScaleGestureDetector and How to make zoomable scrollview?\n" +
            "\n" +
            "want to do zoom in/out scrollview. thanx your help will be appriciated\n" +
            "\n" +
            "thanks in advance\n" +
            "\n" +
            "This Is My Layout\n" +
            "\n" +
            "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<ScrollView\n" +
            "        xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
            "        xmlns:tools=\"http://schemas.android.com/tools\"\n" +
            "        android:layout_width=\"fill_parent\"\n" +
            "        android:layout_height=\"fill_parent\"\n" +
            "        android:id=\"@+id/horizontalScrollView\"\n" +
            "android:layout_gravity=\"center\"\n" +
            "        android:fillViewport=\"false\">";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView)findViewById(R.id.text_zoom);
        text.setText(name);
        scaleGestureDetector=new ScaleGestureDetector(this,new SimpleOnScaleGestureListener());
        text.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getPointerCount() == 1) {
                    //stuff for 1 pointer
                } else { //when 2 pointers are present
                    switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            // Disallow ScrollView to intercept touch events.
                            view.getParent().requestDisallowInterceptTouchEvent(true);
                            scaleGestureDetector.onTouchEvent(motionEvent);
                            break;

                        case MotionEvent.ACTION_MOVE:
                            // Disallow ScrollView to intercept touch events.
                            view.getParent().requestDisallowInterceptTouchEvent(true);
                            scaleGestureDetector.onTouchEvent(motionEvent);
                            break;

                        case MotionEvent.ACTION_UP:
                            // Allow ScrollView to intercept touch events.
                            view.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }

                }
                return true;
            }
        });
    }
}
