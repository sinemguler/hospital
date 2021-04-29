/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Sinem
 */
public class Hasta {
    private int hasta_id;
    private String isim;
    private String tc;
    private String dog_tarihi;
    private String tel_numarasi;
    private int doktor_id;

    public Hasta() {
    }

    public Hasta(int hasta_id, String isim, String tc, String dog_tarihi, String tel_numarasi, int doktor_id) {
        this.hasta_id = hasta_id;
        this.isim = isim;
        this.tc = tc;
        this.dog_tarihi = dog_tarihi;
        this.tel_numarasi = tel_numarasi;
        this.doktor_id = doktor_id;
    }

    public int getHasta_id() {
        return hasta_id;
    }

    public void setHasta_id(int hasta_id) {
        this.hasta_id = hasta_id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getDog_tarihi() {
        return dog_tarihi;
    }

    public void setDog_tarihi(String dog_tarihi) {
        this.dog_tarihi = dog_tarihi;
    }

    public String getTel_numarasi() {
        return tel_numarasi;
    }

    public void setTel_numarasi(String tel_numrasi) {
        this.tel_numarasi = tel_numarasi;
    }

    public int getDoktor_id() {
        return doktor_id;
    }

    public void setDoktor_id(int doktor_id) {
        this.doktor_id = doktor_id;
    }

    
}
