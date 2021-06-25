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
public class Tahlil {

    private int tahlil_id;
    private String tipi;
    private Hasta hasta;
    private Doktor doktor;

    public Tahlil() {
    }

    public Tahlil(int tahlil_id, String tipi, Hasta hasta, Doktor doktor) {
        this.tahlil_id = tahlil_id;
        this.tipi = tipi;
        this.hasta = hasta;
        this.doktor = doktor;
    }

    public int getTahlil_id() {
        return tahlil_id;
    }

    public void setTahlil_id(int tahlil_id) {
        this.tahlil_id = tahlil_id;
    }

    public String getTipi() {
        return tipi;
    }

    public void setTipi(String tipi) {
        this.tipi = tipi;
    }

    public Hasta getHasta() {
        return hasta;
    }

    public void setHastar(Hasta hasta) {
        this.hasta = hasta;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    @Override
    public String toString() {
        return "Tahlil{" + "tahlil_id=" + tahlil_id + ", tipi=" + tipi + ", hasta=" + hasta + ", doktor=" + doktor + '}';
    }

    public void setHasta(Hasta h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
