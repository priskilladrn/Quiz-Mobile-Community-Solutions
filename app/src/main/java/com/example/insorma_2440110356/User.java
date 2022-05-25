package com.example.insorma_2440110356;

public class User {
    String userEmailAddress, userUsername, userPhoneNumber, userPassword;
    Integer userId;

    public User(Integer _userId,String _email, String _username, String _phone, String _password){
        userId = _userId;
        userEmailAddress = _email;
        userUsername = _username;
        userPhoneNumber = _phone;
        userPassword = _password;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }


    public String getUserPassword() {
        return userPassword;
    }

}
