package com.example.travelopedia;

public class user_profile {

    String name;
        String country;
        String email;
        String password;

        user_profile(String name,String country,String email,String password){

            this.name=name;
            this.country=country;
            this.email=email;
            this.password=password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
