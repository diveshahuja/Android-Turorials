package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setData();
    }

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
    }
}