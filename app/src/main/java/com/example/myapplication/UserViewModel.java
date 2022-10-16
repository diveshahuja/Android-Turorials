package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserViewModel  extends ViewModel {
    private MutableLiveData<User> user;
    public LiveData<User> getUser() {
        if (user == null) {
            user = new MutableLiveData<>();
            loadUsers();
        }
        return user;
    }

    private void loadUsers() {
        new User("Jhon",1);
    }

    public void updateUser(){
        user.postValue(new User("Divesh", 2));
    }
}
