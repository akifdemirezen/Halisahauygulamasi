package com.example.akif.halisaha_adam_bul;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import javax.crypto.Mac;

/**
 * Created by akif on 14.2.2017.
 */

public class Mac_Bul extends AppCompatActivity {

    Spinner spn_macbul_il,spn_macbul_ilce;
    Button btn_macbul_ilangoster,btn_macbulma_anasayfayadon;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mac_bulma_sayfasi);

    // Görsellerin Tanımlanması
    spn_macbul_il=(Spinner)findViewById(R.id.spn_macbul_il);
    spn_macbul_ilce=(Spinner)findViewById(R.id.spn_macbul_ilce);
    btn_macbul_ilangoster=(Button)findViewById(R.id.btn_macbul_ilangoster);
    btn_macbulma_anasayfayadon=(Button)findViewById(R.id.btn_macbulma_anasayfadon);

         btn_macbul_ilangoster.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


                //Şehirleri filtreledikten sonra maç ilanları sayfasına götür
                 Intent intent=new Intent(Mac_Bul.this,Mac_ilanlari.class);
                 startActivity(intent);
             }
         });

        btn_macbulma_anasayfayadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Şehirleri filtreledikten sonra maç ilanları sayfasına götür
                Intent intent=new Intent(Mac_Bul.this,AnaSayfa.class);
                startActivity(intent);
            }
        });


    }

}
