package org.example.models;

public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    private String zodiac;
    private String mood;

    public User() {

    }

    public User(int id, String firstname, String lastname, String username, String password, String zodiac,String mood) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.zodiac = zodiac;
        this.mood = mood;
    }

    public User(String firstname, String lastname, String username, String password, String zodiac,String mood) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.zodiac = zodiac;
        this.mood = mood;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getZodiac() {
        return zodiac;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", zodiac='" + zodiac + '\'' +
                ", mood='" + mood + '\'' +
                '}';
    }
}


  /*  "User{" +
        "\nid " + id +
                "\nFirst Name: " + firstname +
                "\nLast Mane: " + lastname +
                "\nEmail: " + email +
                "\nPassword: " + password +
                "\n}"; */