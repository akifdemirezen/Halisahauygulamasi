package com.example.akif.halisaha_adam_bul;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akif.halisaha_adam_bul.Entity.IlanList;
import com.example.akif.halisaha_adam_bul.Remote.ApiService;

import javax.crypto.Mac;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by akif on 14.2.2017.
 */

public class Mac_ilanlari extends AppCompatActivity {

     Button btn_macilanlari_anasayfa,btn_macilanlari_ilanver;
     ListView lst_macilanlari;
     TextView txt_ilanisim,txt_ilansoyisim,txt_ilantel,txt_ilanil,txt_ilanilce,txt_ilanaciklama;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mac_ilanlari);

        // Görsellerin tanımlanması
        btn_macilanlari_anasayfa=(Button)findViewById(R.id.btn_macilanlari_anasayfa);
        btn_macilanlari_ilanver=(Button)findViewById(R.id.btn_macilanlari_ilanver);
        //lst_macilanlari=(ListView)findViewById(R.id.lst_macilanlari);
        txt_ilanisim=(TextView)findViewById(R.id.txt_ilan_isim);
        txt_ilansoyisim=(TextView)findViewById(R.id.txt_ilan_soyisim);
        txt_ilanil=(TextView)findViewById(R.id.txt_ilan_il);
        txt_ilanilce=(TextView)findViewById(R.id.txt_ilan_ilce);
        txt_ilanaciklama=(TextView)findViewById(R.id.txt_ilan_aciklama);
        txt_ilantel=(TextView)findViewById(R.id.txt_ilan_tel);


         ilan_goster();

        btn_macilanlari_anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Anasayfaya dön
                Intent intent=new Intent(Mac_ilanlari.this,AnaSayfa.class);
                startActivity(intent);
            }
        }); // Anasayfaya dön butonu kapanışı


        btn_macilanlari_ilanver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Maç ilanı verme sayfasına git
                Intent intent=new Intent(Mac_ilanlari.this,Mac_ilani_ver.class);
                startActivity(intent);
            }
        });  //  İlan Verme sayfasına geri dönme butonu


    }

    public boolean ilan_goster() {


       Call<IlanList> ca = ApiService.Factory.getInstance().ilan_getir();
        ca.enqueue(new Callback<IlanList>() {
            @Override
            public void onResponse(Call<IlanList> call, Response<IlanList> response) {
                txt_ilanisim.setText(response.body().getIlanlar().get(0).getIlaniverenId().getName());
                txt_ilansoyisim.setText(response.body().getIlanlar().get(0).getIlaniverenId().getSurname());
                txt_ilanil.setText(response.body().getIlanlar().get(0).getIlanlokId().getIl()+"  ");
                txt_ilanilce.setText(response.body().getIlanlar().get(0).getIlanlokId().getIlce());
                txt_ilantel.setText(response.body().getIlanlar().get(0).getIlaniverenId().getTel());
                txt_ilanaciklama.setText(response.body().getIlanlar().get(0).getAciklama());
            }


            @Override
            public void onFailure(Call<IlanList> call, Throwable t) {

            }
        });
        return true;
    }


}
