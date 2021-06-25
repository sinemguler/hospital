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
public class ilac {

    private int ilac_id;
    private String ilac_adi;
    private Doktor doktor;
    private Hasta hasta;

    public ilac() {
    }

    public ilac(int ilac_id, String ilac_adi, Doktor doktor, Hasta hasta) {
        this.ilac_id = ilac_id;
        this.ilac_adi = ilac_adi;
        this.doktor = doktor;
        this.hasta = hasta;
    }

    public int getIlac_id() {
        return ilac_id;
    }

    public void setIlac_id(int ilac_id) {
        this.ilac_id = ilac_id;
    }

    public String getIlac_adi() {
        return ilac_adi;
    }

    public void setIlac_adi(String ilac_adi) {
        this.ilac_adi = ilac_adi;
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
        return "ilac{" + "ilac_id=" + ilac_id + ", ilac_adi=" + ilac_adi + ", doktor=" + doktor + ", hasta=" + hasta + '}';
    }

}
