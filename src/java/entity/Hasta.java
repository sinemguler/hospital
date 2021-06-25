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
    private int tel_numarasi;
    private Doktor doktor;

    public Hasta() {
    }

    public Hasta(int hasta_id, String isim, String tc, String dog_tarihi, int tel_numarasi, Doktor doktor) {
        this.hasta_id = hasta_id;
        this.isim = isim;
        this.tc = tc;
        this.dog_tarihi = dog_tarihi;
        this.tel_numarasi = tel_numarasi;
        this.doktor = doktor;
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

    public int getTel_numarasi() {
        return tel_numarasi;
    }

    public void setTel_numarasi(int tel_numrasi) {
        this.tel_numarasi = tel_numarasi;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    @Override
    public String toString() {
        return "Hasta{" + "hasta_id=" + hasta_id + ", isim=" + isim + ", tc=" + tc + ", dog_tarihi=" + dog_tarihi + ", tel_numarasi=" + tel_numarasi + ", doktor=" + doktor + '}';
    }

   

    
}

    

