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
public class MainClass {

    public static void main(String[] args) {
        Oda eyyup = new Oda.OdaBuilder("Eyyüp", "Bağdaş")
                .oda_id(1)
                .kat("1.kat")
                .oda_numarasi(2)
                .build();

        Oda kevser = new Oda.OdaBuilder("Kevser", "Köse")
                .oda_id(2)
                .kat("12.kat")
                .build();

        Oda merve = new Oda.OdaBuilder("Merve", "Topal")
                .oda_id(3)
                .oda_numarasi(5)
                .build();

        System.out.println(eyyup);
        System.out.println(kevser);
        System.out.println(merve);
    }
}
//oda nesnelerini bu şekilde alanların bir kısmı zorunlu bir kısmı isteğe bağlı dolduralacak şekilde oluşturabiliriz.
//odabuilderin yapılandırıcısına istediği bilgileri verdikten sonra doldurmak istediğimiz diğer alanları dolduruyoruz
//Birincisi bir oda nesnesi oluşturulacağı zaman yapılandırıcıya beklediği sayı kadar parametre geçirilmesi gerekiyor.
// oda nesnesi oluşturulurken nalanların bir kısmı zorunlu bir kısmı isteğe bağlı dolduralacak şekilde oluşturmak isteyebiliriz