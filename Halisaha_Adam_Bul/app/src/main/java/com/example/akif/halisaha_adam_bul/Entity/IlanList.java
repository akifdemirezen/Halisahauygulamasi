package com.example.akif.halisaha_adam_bul.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akif on 22.2.2017.
 */

public class IlanList {

    @SerializedName("Ilanlar")
    @Expose
    private List<Ilan> ilanlarlistesi = null;

    public List<Ilan> getIlanlar() {
        return ilanlarlistesi;
    }

    public void setIlanlar(List<Ilan> ilanlar) {
        this.ilanlarlistesi = ilanlar;
    }

}




