package com.example.akif.halisaha_adam_bul.Remote;


import com.example.akif.halisaha_adam_bul.Entity.Ilan;
import com.example.akif.halisaha_adam_bul.Entity.IlanList;
import com.example.akif.halisaha_adam_bul.Entity.User;
import com.example.akif.halisaha_adam_bul.Entity.UserSession;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by akif on 14.2.2017.
 */

public interface ApiService {

    String Base_Url="http:/10.10.5.40:8000/";  //192.168.1.23:8000/ ev

    //Kullanıcı kayıt etme
    @POST("createUser")
    Call<JSONObject> user_ekle(@Body User u);

   //Login olup olmama
    @POST("login")
    Call<User> giris_onay(@Body User u);

    //Kullanıcı özelliklerini getir
    @GET("getUser") Call<UserSession> getalluser() ;

    //İlan Ekle
    @POST("createIlan") Call<JSONObject> ilan_ekle(@Body Ilan i);

    //İlanları getir
    @GET("getIlan") Call<IlanList> ilan_getir();


    class Factory{
        private static ApiService service;

        public static ApiService getInstance(){
            if (service==null){

                Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(Base_Url).build();

                service=retrofit.create(ApiService.class);
                return service;


            }else{
                return service;
            }


        }

    }

}
