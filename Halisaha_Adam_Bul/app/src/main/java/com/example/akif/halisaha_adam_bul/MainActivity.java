package com.example.akif.halisaha_adam_bul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.akif.halisaha_adam_bul.Entity.User;
import com.example.akif.halisaha_adam_bul.Entity.UserSession;
import com.example.akif.halisaha_adam_bul.Remote.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {


    public static String giris_kullaniciadi;
    EditText et_sifre, et_kullaniciadi;
    Button btn_girisyap, btn_sifremiunuttum, btn_kayıtol;
    public static String kullanicinin_idsi;

    public static String getKullanicinin_idsi() {
        return kullanicinin_idsi;
    }

    public static void setKullanicinin_idsi(String kullanicinin_idsi) {
        MainActivity.kullanicinin_idsi = kullanicinin_idsi;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_kullaniciadi = (EditText) findViewById(R.id.et_Kullaniciadi);
        et_sifre = (EditText) findViewById(R.id.et_sifre);
        btn_girisyap = (Button) findViewById(R.id.btn_girisyap);
        btn_kayıtol = (Button) findViewById(R.id.btn_kayitol);
        btn_sifremiunuttum = (Button) findViewById(R.id.btn_sifremiunuttum);


        btn_kayıtol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, KayitOl_Sayfasi.class);
                startActivity(intent);

            } //Kayıt ol OnClick


        });//Kayıt ol butonu kapanış


        btn_girisyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               giris_yapilsinmi();

            }
        }); //Giriş Yap Buton kapanış


        btn_sifremiunuttum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }); //Şifremi unuttum butonu kapanış


    }

    public boolean giris_yapilsinmi(){

        giris_kullaniciadi=et_kullaniciadi.getText().toString();
        String giris_sifre=et_sifre.getText().toString();

        User u_login = new User(giris_kullaniciadi,giris_sifre);

        Call<User> call=ApiService.Factory.getInstance().giris_onay(u_login);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                 String sonuc=response.body().getType();


                if(sonuc.equals("true")){
                    //Anasayfaya gir
                    kullanicinin_idsi=response.body().getData();
                    //setKullanicinin_idsi(response.body().getData());

                    Intent intent = new Intent(MainActivity.this, AnaSayfa.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(MainActivity.this, "Kullanıcı adı veya şifreniz yanlış lütfen tekrar girin", Toast.LENGTH_LONG).show();

                }



            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });


        return true;
    }




}





