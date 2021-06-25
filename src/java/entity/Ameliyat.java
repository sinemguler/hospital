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
public class Ameliyat {
    private int ameliyat_id;
    private String ameliyat_ismi;
    private String ameliyat_tarihi;
    private Doktor doktor;
    private Hasta hasta;

    public Ameliyat() {
    }

    public Ameliyat(int ameliyat_id, String ameliyat_ismi, String ameliyat_tarihi, Doktor doktor, Hasta hasta) {
        this.ameliyat_id = ameliyat_id;
        this.ameliyat_ismi = ameliyat_ismi;
        this.ameliyat_tarihi = ameliyat_tarihi;
        this.doktor = doktor;
        this.hasta = hasta;
    }

    public int getAmeliyat_id() {
        return ameliyat_id;
    }

    public void setAmeliyat_id(int ameliyat_id) {
        this.ameliyat_id = ameliyat_id;
    }

    public String getAmeliyat_ismi() {
        return ameliyat_ismi;
    }

    public void setAmeliyat_ismi(String ameliyat_ismi) {
        this.ameliyat_ismi = ameliyat_ismi;
    }

    public String getAmeliyat_tarihi() {
        return ameliyat_tarihi;
    }

    public void setAmeliyat_tarihi(String ameliyat_tarihi) {
        this.ameliyat_tarihi = ameliyat_tarihi;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public Hasta getHasta() {
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
    }

    @Override
    public String toString() {
        return "Ameliyat{" + "ameliyat_id=" + ameliyat_id + ", ameliyat_ismi=" + ameliyat_ismi + ", ameliyat_tarihi=" + ameliyat_tarihi + ", doktor=" + doktor + ", hasta=" + hasta + '}';
    }
    
    
}
