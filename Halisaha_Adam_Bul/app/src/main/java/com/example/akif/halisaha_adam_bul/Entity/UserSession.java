package com.example.akif.halisaha_adam_bul.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akif on 20.2.2017.
 */

public class UserSession {


    @SerializedName("USERS")
    @Expose
    private List<User> dataList = new ArrayList<>();

    public List<User> getDataList() {
        return dataList;
    }
}
