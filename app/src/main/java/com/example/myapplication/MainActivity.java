package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
<<<<<<< Updated upstream
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView userListRecyclerView;
    private ArrayList<User> userArrayList = new ArrayList<>();
    private UserAdapter userAdapter;
=======

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MainActivity extends AppCompatActivity {
    private String[] listOfTitles = new String[]{"Favorites", "Playlist", "Recent"};
    private ViewPager2 viewPager;
    private TabLayout tabLayout;

>>>>>>> Stashed changes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setData();
    }

<<<<<<< Updated upstream
    private void initView(){
        userListRecyclerView = findViewById(R.id.userListRecyclerview);
        userListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setData(){
        userArrayList.add(new User("Divesh Ahuja", true));
        userArrayList.add(new User("Divesh Ahuja", true));
        userArrayList.add(new User("Divesh Ahuja", true));
        userArrayList.add(new User("Divesh Ahuja", false));
        userArrayList.add(new User("Mohit Singh", false));
        userArrayList.add(new User("Johnny Baba", true));
        userArrayList.add(new User("Burj Khalifa", false));
        userArrayList.add(new User("Divesh Ahuja", true));
        userArrayList.add(new User("Divesh Ahuja", true));

        userAdapter = new UserAdapter(this, userArrayList);
        userListRecyclerView.setAdapter(userAdapter);
=======
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
>>>>>>> Stashed changes
    }
}