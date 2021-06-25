/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oda;

/**
 *
 * @author Sinem
 */
public class Oda {

    private final int oda_id;
    private final String kat;
    private final int oda_numarasi;
    private final String firstName;
    private final String surname;

    public Oda(OdaBuilder odaBuilder) {  //oda constructor’ına baktığımız zaman bir odaBuilder nesnesini parametre aldığını görüyoruz
        this.oda_id = odaBuilder.oda_id;
        this.kat = odaBuilder.kat;
        this.oda_numarasi = odaBuilder.oda_numarasi;
        this.firstName = odaBuilder.firstName;
        this.surname = odaBuilder.surname;
    }

    public int getOda_id() {
        return oda_id;
    }

    public String getKat() {
        return kat;
    }

    public int getOda_numarasi() {
        return oda_numarasi;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Oda:  " + this.firstName + ", " + this.surname + " , " + this.oda_id + " " + this.kat + "," + this.oda_numarasi + "";
    }

    public static class OdaBuilder {

        private int oda_id;
        private String kat;
        private int oda_numarasi;
        private final String firstName;
        private final String surname;

        public OdaBuilder(String firstName, String surname) {
            this.firstName = firstName;
            this.surname = surname;
        }

        public OdaBuilder oda_id(int oda_id) {
            this.oda_id = oda_id;
            return this;
        }

        public OdaBuilder kat(String kat) {
            this.kat = kat;
            return this;
        }

        public OdaBuilder oda_numarasi(int oda_numarasi) {
            this.oda_numarasi = oda_numarasi;
            return this;
        }

      
        public Oda build() {
            Oda oda = new Oda(this);
            return oda;
        }
    }
}
