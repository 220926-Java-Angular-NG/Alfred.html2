package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.javalin.Javalin;
import org.example.controllers.UserController;
//import org.example.repos.FlashCardRepo;
import org.example.repos.UserRepo;
import org.example.models.User;
import org.example.services.UserService;


public class Driver {
    public static void main(String[] args) {

//        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=flashcard-demo";
//        String username = "postgres";
//        String password = "ABC132:";


        //Note: certain methods throw errors because there are different instances of what can go wrong
        //in order to handle those errors in a way that saves the application from crashing
        //we wrap those methods or blocks of code in a "try{}catch(){}"block
//        try{
//            Connection conn = DriverManager.getConnection(url, username,password);
//
//            System.out.println(conn.toString());

//        }catch(SQLException sqlException){
//            sqlException.printStackTrace();
//            System.out.println(sqlException.getMessage());
//        }


      //  Javalin app = Javalin.create().start(8080);
        Javalin app = Javalin.create( config -> {
            config.enableCorsForAllOrigins();
        }).start(8080);


        UserService userService = new UserService();
       UserController userController = new UserController(userService);

       app.post("/user", userController.createNewUser);
        //users uris
        app.get("/users",userController.loginUser);
        app.get("/user/{id}",userController.getUserById);
        //app.post("/user",userController.createNewUser);
        app.put("/user",userController.updateUser);
        app.delete("/user", userController.deleteUser);
       // app.delete("/user/{id}", userController.deleteUserById);
        app.post("/login", userController.loginUser);



       // FlashCardRepo flashCardRepo = new FlashCardRepo();




//       User user1 = new User();
//
//       int user1Id = userRepo.create(user1);
//        System.out.println("user1Id");




}}