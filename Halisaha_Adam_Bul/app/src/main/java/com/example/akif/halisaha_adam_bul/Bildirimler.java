package com.example.akif.halisaha_adam_bul;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by akif on 14.2.2017.
 */

public class Bildirimler extends AppCompatActivity{

    ListView lst_bildirim;
    Button btn_anasayfayadon;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bildirimler);

       lst_bildirim=(ListView)findViewById(R.id.lst_bildirim);
       btn_anasayfayadon=(Button)findViewById(R.id.btn_bildirim_anasayfadon);

        btn_anasayfayadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Bildirimler.this,AnaSayfa.class);
                startActivity(intent);
            }
        }); // Anasayfa dön butonu



    }

}
