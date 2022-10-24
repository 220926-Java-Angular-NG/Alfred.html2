package org.example.controllers;

import org.example.models.User;

public class CurrentUser {

    public static User currentUser;

    private CurrentUser(){
    }

    public CurrentUser(User user){
        this.currentUser = user;
    }
}
