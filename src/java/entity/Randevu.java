/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.sql.Date;
/**
 *
 * @author Sinem
 */
public class Randevu {
     private int r_id;
    private Date tarih;
    private String tc;
     private Hasta hasta;
    private Doktor doktor;
    private Bolum bolum;
   
    

    public Randevu() {
    }

    public Randevu(int r_id, Date tarih, String tc, int hasta_id, int doktor_id, int bolum_id,Hasta hasta,Doktor doktor,Bolum bolum) {
        this.r_id = r_id;
        this.tarih = tarih;
        this.tc = tc;
        this.hasta = hasta;
        this.doktor= doktor;
        this.bolum= bolum;
    }

    public Randevu(int aInt, Date date, Hasta h, Doktor d, Bolum b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public Hasta getHasta() {
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public Bolum getBolum() {
        return bolum;
    }

    public void setBolum(Bolum bolum) {
        this.bolum = bolum;
    }

    @Override
    public String toString() {
        return "Randevu{" + "r_id=" + r_id + ", tarih=" + tarih + ", tc=" + tc + ", hasta=" + hasta + ", doktor=" + doktor + ", bolum=" + bolum + '}';
    }

}
