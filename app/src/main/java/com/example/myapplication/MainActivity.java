package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MainActivity extends AppCompatActivity {
    private String[] listOfTitles = new String[]{"Favorites", "Playlist", "Recent"};
    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
    }

    private void initListeners() {
        MainViewPagerAdapter pagerAdapter = new MainViewPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(0);
        addTabLayoutMediator();
    }

    private void addTabLayoutMediator() {
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText("Tab: " + position)).attach();
    }
}