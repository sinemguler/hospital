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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.doktor_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Doktor other = (Doktor) obj;
        if (this.doktor_id != other.doktor_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Doktor{" + "doktor_id=" + doktor_id + ", isim=" + isim + ", tc=" + tc + ", tel_numarasi=" + tel_numarasi + '}';
    }
    
    
    
    
    
    
}