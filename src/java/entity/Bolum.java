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
public class Bolum {
    private int bolum_id;
    private String bolum_ismi;

    public Bolum() {
    }

    public Bolum(int bolum_id, String bolum_ismi) {
        this.bolum_id = bolum_id;
        this.bolum_ismi = bolum_ismi;
    }

    public int getBolum_id() {
        return bolum_id;
    }

    public void setBolum_id(int bolum_id) {
        this.bolum_id = bolum_id;
    }

    public String getBolum_ismi() {
        return bolum_ismi;
    }

    public void setBolum_ismi(String bolum_ismi) {
        this.bolum_ismi = bolum_ismi;
    }

  
}
