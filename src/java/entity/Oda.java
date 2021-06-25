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
public class Oda {
    private int oda_id;
    private String kat;
    private int oda_numarasi;
    private Hasta hasta ;

    public Oda() {
    }

    public Oda(int oda_id, String kat, int oda_numarasi, Hasta hasta) {
        this.oda_id = oda_id;
        this.kat = kat;
        this.oda_numarasi = oda_numarasi;
        this.hasta = hasta;
    }

    public int getOda_id() {
        return oda_id;
    }

    public void setOda_id(int oda_id) {
        this.oda_id = oda_id;
    }

    public String getKat() {
        return kat;
    }

    public void setKat(String kat) {
        this.kat = kat;
    }

    public int getOda_numarasi() {
        return oda_numarasi;
    }

    public void setOda_numarasi(int oda_numarasi) {
        this.oda_numarasi = oda_numarasi;
    }

    public Hasta getHasta() {
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
    }

    @Override
    public String toString() {
        return "Oda{" + "oda_id=" + oda_id + ", kat=" + kat + ", oda_numarasi=" + oda_numarasi + ", hasta=" + hasta + '}';
    }
    
    
   
    
}
