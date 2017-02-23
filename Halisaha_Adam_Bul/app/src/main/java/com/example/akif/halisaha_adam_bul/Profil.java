package com.example.akif.halisaha_adam_bul;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akif.halisaha_adam_bul.Entity.User;
import com.example.akif.halisaha_adam_bul.Entity.UserSession;
import com.example.akif.halisaha_adam_bul.Remote.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.akif.halisaha_adam_bul.AnaSayfa.Ana_kullanıcı;

import static com.example.akif.halisaha_adam_bul.MainActivity.kullanicinin_idsi;


/**
 * Created by akif on 14.2.2017.
 */

public class Profil extends AppCompatActivity {



     TextView txt_kullaniciadi,txt_isim,txt_soyisim,txt_telefon,txt_il,txt_ilce,txt_;
     Button btn_profil_anasayfayadon;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);



        txt_kullaniciadi=(TextView)findViewById(R.id.txt_kullaniciadi);
        txt_isim=(TextView)findViewById(R.id.txt_isim);
        txt_soyisim=(TextView)findViewById(R.id.txt_soyisim);
        txt_telefon=(TextView)findViewById(R.id.txt_telefon);
        txt_il=(TextView)findViewById(R.id.txt_il);
        txt_ilce=(TextView)findViewById(R.id.txt_ilce);
        btn_profil_anasayfayadon=(Button) findViewById(R.id.btn_profil_anasayfayageridon);

        kullanici_ozellikleri_goster();



        btn_profil_anasayfayadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Profil.this,AnaSayfa.class);
                startActivity(intent);


            }
        }); // Anasayfa dön butonu


    }

    public void kullanici_ozellikleri_goster(){



                String kullanıcının_id = kullanicinin_idsi;

          if(Ana_kullanıcı.getId().equals(kullanıcının_id)){

              txt_kullaniciadi.setText(Ana_kullanıcı.getUsername());
              txt_isim.setText(Ana_kullanıcı.getName());
              txt_soyisim.setText(Ana_kullanıcı.getSurname());
              txt_telefon.setText(Ana_kullanıcı.getTel());
              txt_il.setText(Ana_kullanıcı.getLocationId().getIl());
              txt_ilce.setText(Ana_kullanıcı.getLocationId().getIlce());


          }



    }

}
