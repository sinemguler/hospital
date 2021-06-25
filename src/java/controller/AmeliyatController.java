/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AmeliyatDAO;
import entity.Ameliyat;
import entity.Doktor;
import entity.Hasta;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Sinem
 */
@Named
@SessionScoped

public class AmeliyatController implements Serializable {

    private AmeliyatDAO ameliyatdao;
    private Ameliyat entity;

    @Inject
    private DoktorController doktorController;
    private HastaController hastaController;

    private int selectedDoktor;
    private int selectedHasta;

    public int getSelectedDoktor() {
        return selectedDoktor;
    }

    public void setSelectedDoktor(int selectedDoktor) {
        this.selectedDoktor = selectedDoktor;
    }

    public int getSelectedHasta() {
        return selectedHasta;
    }

    public void setSelectedHasta(int selectedHasta) {
        this.selectedHasta = selectedHasta;
    }

    public String create() {
        Doktor d = doktorController.getDao().getById(selectedDoktor);
        entity.setDoktor(d);
        Hasta h = hastaController.getDao().getById(selectedHasta);
        entity.setHasta(h);
        this.getAmeliyatdao().create(entity);
        this.entity = new Ameliyat();
        return "/module/ameliyat/index";
    }

    public List<Ameliyat> getRead() {
        return this.getAmeliyatdao().read();
    }

    public String updateForm(Ameliyat a) {
        this.selectedDoktor = a.getDoktor().getDoktor_id();
        this.selectedHasta = a.getHasta().getHasta_id();
        this.entity = a;
        return "/module/ameliyat/update";
    }

    public String update() {
        Doktor d = doktorController.getDao().getById(selectedDoktor);
        entity.setDoktor(d);
        Hasta h = hastaController.getDao().getById(selectedHasta);
        entity.setHasta(h);
        this.getAmeliyatdao().update(entity);
        this.entity = new Ameliyat();
        return "/module/ameliyat/index";
    }

    public String deleteConfirm(Ameliyat a) {
        this.entity = a;
        return "/module/ameliyat/confirm_delete";
    }

    public String delete() {
        this.getAmeliyatdao().delete(entity);
        this.entity = new Ameliyat();
        return "/module/ameliyat/index";
    }

    public AmeliyatController() {
    }

    public AmeliyatDAO getAmeliyatdao() {
        if (this.ameliyatdao == null) {
            this.ameliyatdao = new AmeliyatDAO();
        }
        return ameliyatdao;
    }

    public void setAmeliyatdao(AmeliyatDAO ameliyatdao) {
        this.ameliyatdao = ameliyatdao;
    }

    public Ameliyat getEntity() {
        if (this.entity == null) {
            this.entity = new Ameliyat();
        }
        return entity;
    }

    public void setEntity(Ameliyat entity) {
        this.entity = entity;
    }

   
}
