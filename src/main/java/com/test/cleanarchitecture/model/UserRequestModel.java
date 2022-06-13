package com.test.cleanarchitecture.model;

public class UserRequestModel {

    private String name;
    private String password;
    private String birthDay;
    private String birthMonth;

    public UserRequestModel() {
        super();
    }

    public UserRequestModel(String name, String password) {
        super();
        this.name = name;
        this.password = password;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }
}
