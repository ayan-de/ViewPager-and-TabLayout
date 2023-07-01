package com.example.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = (ViewPager2) findViewById(R.id.view_pager2);

        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(),getLifecycle());
        viewPager2.setAdapter(myAdapter);
    }
}