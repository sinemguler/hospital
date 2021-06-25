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
public class Hasta extends islem {

    @Override
    protected void ekle() {
        System.out.println("hasta sınıfına veri eklendi");
    }

    @Override
    protected void guncelle() {
        System.out.println("doktor sınıfında veri güncellendi");
    }

    @Override
    protected void oku() {
         System.out.println("hasta sınıfından veri okundu");
    }

    @Override
    protected void sil() {
       System.out.println("hasta sınıfından veri silindi");
    }
    
}
