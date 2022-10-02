package com.example.myapplication;

public class User {
    String name;
    Boolean isOnline;

    public User(String name, Boolean isOnline){
        this.isOnline = isOnline;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }
}
