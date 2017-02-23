package com.example.akif.halisaha_adam_bul.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by akif on 21.2.2017.
 */

public class Ilan {




    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("ilaniveren_id")
    @Expose
    private IlaniVerenId ilaniverenId;
    @SerializedName("ilanlok_id")
    @Expose
    private IlanLokId ilanlokId;
    @SerializedName("aciklama")
    @Expose
    private String aciklama;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IlaniVerenId getIlaniverenId() {
        return ilaniverenId;
    }

    public void setIlaniverenId(IlaniVerenId ilaniverenId) {
        this.ilaniverenId = ilaniverenId;
    }

    public IlanLokId getIlanlokId() {
        return ilanlokId;
    }

    public void setIlanlokId(IlanLokId ilanlokId) {
        this.ilanlokId = ilanlokId;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public Ilan(IlaniVerenId a, IlanLokId b, String aciklama){

        this.ilaniverenId=a;
        this.ilanlokId=b;
        this.aciklama=aciklama;

    }


}
