package com.example.toddlerteacher;

public class User {

    private String name, email, pass, profile, country, childName;
    private String age;
    private String childAge;
    private String phone;
    private long coins = 25;
    private String strength ;
    private String weakness ;
    private String repeated ;


    public User() {
    }

    public User(String name, String email, String pass, String phone, String age, String country, String childName, String childAge) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
        this.age=age;
        this.country=country;
        this.childName = childName;
        this.childAge = childAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildAge() {
        return childAge;
    }

    public void setChildAge(String childAge) {
        this.childAge= childAge;
    }


    public long getCoins() {
        return coins;
    }

    public void setCoins(long coins) {
        this.coins = coins;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength() {
        this.strength = strength;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness() {
        this.weakness = weakness;
    }

    public String getRepeated() {
        return repeated;
    }

    public void setRepeated() {
        this.repeated = repeated;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
