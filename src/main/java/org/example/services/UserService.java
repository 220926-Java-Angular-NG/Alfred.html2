package org.example.services;

import org.example.models.User;
import org.example.repos.UserRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;



public class UserService {


    private UserRepo userRepo;
// We are creating a new instance of our UserRepo
    public UserService() {
        userRepo = new UserRepo();
    }
// Here we are passing in an existing UserRepo
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    //Create

    public int createUser(User user) {
        return userRepo.create(user);
    }
    //Read all
    public List<User> getAllUsers(){
        return userRepo.getAll();
    }
    //readById
    public User getUserById(int id){
        return userRepo.getById (id);
    }
    //Update
    public User updateUser(User user) {
        ;
        return userRepo.update(user);
    }
    //Delete
    public boolean deleteUser(User user){
        return true;

    }
    public User loggedIn(User user){
        return userRepo.loginUser(user);
    }
}