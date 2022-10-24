package org.example.repos;

import org.example.models.User;
import org.example.utils.CRUDDaoInterface;
import org.example.utils.ConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepo implements CRUDDaoInterface<User> {
    public Connection conn;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepo.class);

    public UserRepo() {


     //   String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=";
        // String username = "postgres";
      //  String password = "ABC132";

        // Certain methods throw errors because there are different instances of what can go wrong
        // In order to handle those errors in a way that saves the application from crashing
        // We wrap those methods or blocks of code in a "try{}catch(){}" block
        try {

            //this is the code that can throw an error
            conn = ConnectionManager.getConnection();



        } catch (SQLException sqlException) {
            //System.out.println(sqlException.getMessage());
            LOGGER.error(sqlException.getMessage());
        }


    }

    @Override
    public int create(User user) {

        //Although it says create we are inserting into a table that is already created
        //However we are still creating a new row...
        try {
            String sql = "INSERT INTO users (id,first_name,last_name, user_name, pass_word, zodiac, mood) VALUES (default,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, user.getFirstname());
            pstmt.setString(2, user.getLastname());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getZodiac());
            pstmt.setString(6, user.getMood());

            //This executes the sql statement above
            pstmt.executeUpdate();

            //This gives us a result set of the row that was just created
            ResultSet rs = pstmt.getGeneratedKeys();

            //The cursor is right in front of the first (or only) element in our result set
            //Calling rs.next() iterates us into the first row
            rs.next();

            return rs.getInt("id");
        } catch (SQLException sqlException) {
            //System.out.printf(sqlException.getMessage());
            LOGGER.error(sqlException.getMessage());
        }

        return 0;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<User>();

        try {

            String sql = "SELECT * FROM users";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstname(rs.getString("first_name"));
                user.setLastname(rs.getString("last_name"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword(rs.getString("pass_word"));
                user.setMood(rs.getString("mood"));
                users.add(user);

                return users;

            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

    @Override
    public User getById(int id) {

        try {

            String sql = "SELECT * FROM users WHERE id = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            //We are returning a user
            //Therefore we have to create a new instance of a user from the database

            User user = new User();

            while (rs.next()) {

                user.setId(rs.getInt("id"));
                user.setFirstname(rs.getString("first_name"));
                user.setLastname(rs.getString("last_name"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword(rs.getString("pass_word"));
                user.setMood(rs.getString("mood"));
            }
            return user;


        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

    @Override
    public User update(User user) {

        try {

            String sql = "UPDATE users SET mood = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getMood());
            pstmt.setInt(2, user.getId());
            pstmt.execute();
            return user;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());

        }

        return null;
}

    @Override
    public boolean delete(User user) {
     // Delete from table
        try{

            String sql = " DELETE FROM users WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,user.getId());

            //pstmt.execute() returns boolean
            //It returns false if the executed statement returns void

            return pstmt.execute();
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return true;
    }
    public User loginUser(User user){

        try {

            String sql = "SELECT * FROM users WHERE user_name = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());

            ResultSet rs = pstmt.executeQuery();

            if(rs.next() && rs.getString("pass_word").equals(user.getPassword())){

                return new User(rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("user_name"),
                        rs.getString("pass_word"),
                        rs.getString("zodiac"),
                        rs.getString("mood"));
            }


        }catch(Exception e){
            System.out.println("This is the userDAO: " + e.getMessage());
        }

        return null;
    }
}
