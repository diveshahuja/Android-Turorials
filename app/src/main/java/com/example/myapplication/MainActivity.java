package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private UserViewModel userViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initObservers();
        initListeners();
    }

    private void initListeners() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                userViewModel.updateUser();
            }
        }, 5000);
    }

    private void initObservers() {
        userViewModel.getUser().observe(this, user ->{
            if(user != null){
                textView.setText("My name is " + user.getUsername() + " and my id is " + user.getId());
            }
        });
    }

    private void initViews(){
        textView = findViewById(R.id.text);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
    }
}