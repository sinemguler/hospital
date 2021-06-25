/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package template;

/**
 *
 * @author Sinem
 */

//somut sınıf
public class Doktor extends islem {

    @Override
    protected void ekle() {
        System.out.println("doktor sınıfına veri eklendi");
    }

    @Override
    protected void sil() {
        System.out.println("doktor sınıfında veri silindi");
    }

    @Override
    protected void guncelle() {
         System.out.println("doktor sınıfında veri güncellendi");
    }

    @Override
    protected void oku() {
        System.out.println("doktor sınıfından veri okundu");
    }
    
   

}
