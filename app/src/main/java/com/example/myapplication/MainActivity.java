package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements UserViewInterface {
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

        userAdapter = new UserAdapter(this, userArrayList, this);
        userListRecyclerView.setAdapter(userAdapter);
    }

    @Override
    public void onNameClicked(String name) {
        Toast.makeText(this, "Now in activity: " + name, Toast.LENGTH_SHORT).show();
    }



}