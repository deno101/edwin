package com.example.campusvotingsystemcvs;


import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    private String username;
    private String email;
    private String phone;
    private boolean isVoted;

    // Default constructor required for calls to DataSnapshot.getValue(User.class)
    public User() {

    }

    public User(String username, String email, String phone, boolean isVoted) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.isVoted = isVoted;
    }

}
