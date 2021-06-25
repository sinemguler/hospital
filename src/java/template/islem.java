/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * Soyut sinifi
 */
package template;

/**
 *
 * @author Sinem
 */

//soyut sınıf
public abstract class islem {

    final void template() {

        ekle();
        sil();
        guncelle();
        oku();
    }
    
    protected abstract void  ekle();

    protected abstract void sil();

    protected abstract void guncelle();

    protected abstract void oku();

}
