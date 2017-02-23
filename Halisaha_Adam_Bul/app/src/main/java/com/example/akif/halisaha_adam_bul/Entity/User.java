package com.example.akif.halisaha_adam_bul.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akif on 14.2.2017.
 */

public class User {



    @SerializedName("USERS")
    @Expose
    public User user;

    public User getUser() {
        return user;
    }

    public void setUSERS(User user) {
        this.user = user;
    }



    @SerializedName("type")
    @Expose
    private String type;
    //data return _id
    @SerializedName("data")
    @Expose
    private String data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }




    @SerializedName("il")
    @Expose
    private String post_il;
    @SerializedName("ilce")
    @Expose
    private String post_ilce;

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("tel")
    @Expose
    private String tel;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("location_id")
    @Expose
    private LocationId locationId;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getPost_il() {
        return post_il;
    }

    public void setPost_il(String post_il) {
        this.post_il = post_il;
    }

    public String getPost_ilce() {
        return post_ilce;
    }

    public void setPost_ilce(String post_ilce) {
        this.post_ilce = post_ilce;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public LocationId getLocationId() {
        return locationId;
    }

    public void setLocationId(LocationId locationId) {
        this.locationId = locationId;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public User(String username,String password,String name, String surname, String tel, String age,String uil,String uilce) {


        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.tel = tel;
        this.age = age;
        this.post_il =uil;
        this.post_ilce =uilce;


    }



    public User() {
        this.name = "";
        this.username = "";
        this.password = "";
        this.surname = "";
        this.tel = "";
        this.age = "";
        this.locationId=new LocationId();
    }

    //Login için User olustur


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
