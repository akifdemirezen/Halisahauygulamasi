package com.example.akif.halisaha_adam_bul;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.akif.halisaha_adam_bul.Entity.Ilan;
import com.example.akif.halisaha_adam_bul.Entity.IlanList;
import com.example.akif.halisaha_adam_bul.Entity.IlanLokId;
import com.example.akif.halisaha_adam_bul.Entity.IlaniVerenId;
import com.example.akif.halisaha_adam_bul.Remote.ApiService;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by akif on 13.2.2017.
 */

public class Mac_ilani_ver extends AppCompatActivity {


    EditText et_ilanver_halisaha,et_ilanver_saat,et_ekstraozellik;
    Button btn_ilanver_ilanver;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mac_ilaniverme_sayfasi);

        //Görsellerin tanımlanması


        btn_ilanver_ilanver = (Button) findViewById(R.id.btn_ilanverme_ilanver);

        et_ekstraozellik=(EditText)findViewById(R.id.et_ekstraozellik);
        et_ilanver_halisaha=(EditText)findViewById(R.id.et_ilanver_halisaha);
        et_ilanver_saat=(EditText)findViewById(R.id.et_ilanver_saat);



        btn_ilanver_ilanver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                macilaniver();



            }
        }); // İlan Ver Buton Kapanışı


    }

    public boolean macilaniver() {

        IlaniVerenId a=new IlaniVerenId(String.valueOf(AnaSayfa.Ana_kullanıcı.getId()));

        IlanLokId b=new IlanLokId(String.valueOf(AnaSayfa.Ana_kullanıcı.getLocationId().getId()));

        String ilan_aciklama = "Maç Saati : "+et_ilanver_saat.getText().toString()+" Halısaha Adı : "+et_ilanver_halisaha.getText().toString()+"  Maç Bilgileri : "+et_ekstraozellik.getText().toString();


        Ilan i = new Ilan(a,b, ilan_aciklama);

        if (ilan_aciklama.equals("")) {
            Toast.makeText(Mac_ilani_ver.this, "Lütfen Açıklama Bölümünü Boş Bırakmayınız", Toast.LENGTH_LONG).show();
            return false; //Açıklama boış bırakılırsa çalıştırma
        }

        Call<JSONObject> call = ApiService.Factory.getInstance().ilan_ekle(i);
        call.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {

                Toast.makeText(Mac_ilani_ver.this, "Maç İlanınız Başarıyla Oluşturuldu", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Mac_ilani_ver.this, AnaSayfa.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                Toast.makeText(Mac_ilani_ver.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });



        return true;


    }
}


