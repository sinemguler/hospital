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
public class Doktor {
    private int doktor_id;
    private String isim;
    private String tc;
    private String tel_numarasi;

    public Doktor() {
    }

    public Doktor(int doktor_id, String isim, String tc, String tel_numarasi) {
        this.doktor_id = doktor_id;
        this.isim = isim;
        this.tc = tc;
        this.tel_numarasi = tel_numarasi;
    }

    public int getDoktor_id() {
        return doktor_id;
    }

    public void setDoktor_id(int doktor_id) {
        this.doktor_id = doktor_id;
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

    public String getTel_numarasi() {
        return tel_numarasi;
    }

    public void setTel_numarasi(String tel_numarasi) {
        this.tel_numarasi = tel_numarasi;
    }
    
    
    
    
    
    
}
