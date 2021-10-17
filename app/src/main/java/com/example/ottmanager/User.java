package com.example.ottmanager;

public class User {
    String Name, email, phone, password;

    public User(String name, String email, String phone, String password) {
        Name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
