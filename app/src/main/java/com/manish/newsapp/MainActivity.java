package com.manish.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mhome, mhealth, mscience, mtechnology, mentertainment,msports;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;

    String api = "65d3e1b75528411283d2f8624498ee11";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar = findViewById(R.id.toolBar);
        setSupportActionBar(mtoolbar);

        mhome = findViewById(R.id.home);
        mhealth = findViewById(R.id.health);
        mscience = findViewById(R.id.science);
        mtechnology = findViewById(R.id.technology);
        mentertainment = findViewById(R.id.entertainment);
        msports = findViewById(R.id.sports);

        ViewPager viewPager = findViewById(R.id.fragmentcontainer);
        tabLayout = findViewById(R.id.incudes);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 6);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()== 0 || tab.getPosition()== 1 || tab.getPosition()== 2 || tab.getPosition()== 3 || tab.getPosition()== 4 || tab.getPosition()== 5)
                {
                    pagerAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}