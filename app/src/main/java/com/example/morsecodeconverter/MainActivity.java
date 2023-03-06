package com.example.morsecodeconverter;

import androidx.annotation.ContentView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tl_primary;
    private ViewPager2 vp2_primary;
    private PrimaryFragmentAdapter primary_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign primary TabLayout and ViewPager2
        tl_primary = findViewById(R.id.tl_primary);
        vp2_primary = findViewById(R.id.vp2_primary);

        //Add necessary tabs to tl_primary
        tl_primary.addTab(tl_primary.newTab().setText("Morse to Plain"));
        tl_primary.addTab(tl_primary.newTab().setText("Plain to Morse"));

        //Create the fragment manager for tl_primary, and set adapter
        FragmentManager fm = getSupportFragmentManager();
        primary_adapter = new PrimaryFragmentAdapter(fm, getLifecycle());
        vp2_primary.setAdapter(primary_adapter);

        vp2_primary.setUserInputEnabled(false);

        //create tl_primary tab selected listener
        tl_primary.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp2_primary.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //create vp2_primary page change callback listener
        vp2_primary.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tl_primary.selectTab(tl_primary.getTabAt(position));
            }
        });

    }
}