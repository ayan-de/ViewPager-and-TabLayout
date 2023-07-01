package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.viewpager.FragmentOne;
import com.example.viewpager.FragmentThree;
import com.example.viewpager.FragmentTwo;
import com.example.viewpager.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivityTwo extends AppCompatActivity {

    TabLayout tablayout_two;
    FrameLayout frameLayout_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);

        tablayout_two = (TabLayout) findViewById(R.id.tablayout_two);
        frameLayout_two = (FrameLayout) findViewById(R.id.frameLayout_two);

        TabLayout.Tab firstTab = tablayout_two.newTab();
        firstTab.setText("chat");
        firstTab.setIcon(R.drawable.chat);
        tablayout_two.addTab(firstTab);

        TabLayout.Tab secondTab = tablayout_two.newTab();
        secondTab.setText("status");
        secondTab.setIcon(R.drawable.status);
        tablayout_two.addTab(secondTab);

        TabLayout.Tab thirdTab = tablayout_two.newTab();
        thirdTab.setText("call");
        thirdTab.setIcon(R.drawable.call);
        tablayout_two.addTab(thirdTab);

        //setting the fragment one as staring fragment
        FragmentOne fragment = new FragmentOne();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout_two, fragment);
        fragmentTransaction.commit();


        tablayout_two.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new FragmentOne();
                        break;
                    case 1:
                        fragment = new FragmentTwo();
                        break;
                    case 2:
                        fragment = new FragmentThree();
                        break;
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout_two, fragment);
                fragmentTransaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}