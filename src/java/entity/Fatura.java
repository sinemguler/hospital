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
public class Fatura {

    private int fatura_id;
    private String fatura_tarihi;
    private int miktar;

    public Fatura() {
    }

    public Fatura(int fatura_id, String fatura_tarihi, int miktar) {
        this.fatura_id = fatura_id;
        this.fatura_tarihi = fatura_tarihi;
        this.miktar = miktar;
    }

    public int getFatura_id() {
        return fatura_id;
    }

    public void setFatura_id(int fatura_id) {
        this.fatura_id = fatura_id;
    }

    public String getFatura_tarihi() {
        return fatura_tarihi;
    }

    public void setFatura_tarihi(String fatura_tarihi) {
        this.fatura_tarihi = fatura_tarihi;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }
    
    
}
