package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private UserViewModel model;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initObservers();
        initListeners();
    }

    private void initViews(){
         model = new ViewModelProvider(this).get(UserViewModel.class);
         textView = findViewById(R.id.text);
    }

    private void initObservers() {
        model.getUser().observe(this, user -> {
            if(user != null){
                textView.setText("My name is " + user.getUsername() + " And my id is " + user.getId());
            }
        });
    }

    private void initListeners(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                model.updateUser();
            }
        }, 5000);
    }
}