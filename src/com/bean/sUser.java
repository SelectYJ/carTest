package com.bean;

import java.io.UnsupportedEncodingException;

public class sUser {
    private String us_id;
    private String us_username;
    private String us_pass;
    private String us_email;
    private String us_photo;
    private String us_img;

    public String getUs_id() {
        return us_id;
    }

    public void setUs_id(String us_id){
        this.us_id = us_id;
    }

    public String getUs_username() {
        return us_username;
    }

    public void setUs_username(String us_username) {
        this.us_username = us_username;
    }

    public String getUs_pass() {
        return us_pass;
    }

    public void setUs_pass(String us_pass) {
        this.us_pass = us_pass;
    }

    public String getUs_email() {
        return us_email;
    }

    public void setUs_email(String us_email) {
        this.us_email = us_email;
    }

    public String getUs_photo() {
        return us_photo;
    }

    public void setUs_photo(String us_photo) {
        this.us_photo = us_photo;
    }

    public String getUs_img() {
        return us_img;
    }

    public void setUs_img(String us_img) {
        this.us_img = us_img;
    }

    @Override
    public String toString() {
        return "sUser{" +
                "us_id=" + us_id +
                ", us_username='" + us_username + '\'' +
                ", us_pass='" + us_pass + '\'' +
                ", us_email='" + us_email + '\'' +
                ", us_photo='" + us_photo + '\'' +
                ", us_img='" + us_img + '\'' +
                '}';
    }
}
