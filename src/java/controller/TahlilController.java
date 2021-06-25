/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TahlilDAO;
import entity.Doktor;
import entity.Hasta;
import entity.Tahlil;
import java.io.Serializable;
import java.sql.SQLException;
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
public class TahlilController implements Serializable {

    private TahlilDAO tahlildao;
    private Tahlil entity;

    @Inject
    private HastaController hastaController;

    private int selectedHasta;

    public int getSelectedHasta() {
        return selectedHasta;
    }

    public void setSelectedHasta(int selectedHasta) {
        this.selectedHasta = selectedHasta;
    }

    @Inject
    private DoktorController doktorController;

    private int selectedDoktor;

    public int getSelectedDoktor() {
        return selectedDoktor;
    }

    public void setSelectedDoktor(int selectedDoktor) {
        this.selectedDoktor = selectedDoktor;
    }

    public String create() {
        Hasta h = hastaController.getDao().getById(selectedHasta);
        entity.setHasta(h);
        Doktor d = doktorController.getDao().getById(selectedDoktor);
        entity.setDoktor(d);

        this.getDao().create(entity);
        this.entity = new Tahlil();
        return "/module/tahlil/index";
    }

    public List<Tahlil> getRead() throws SQLException {

        return this.getDao().read();
    }

    public String updateForm(Tahlil t) {
        this.selectedHasta = t.getHasta().getHasta_id();
        this.selectedDoktor = t.getDoktor().getDoktor_id();

        this.entity = t;
        return "/module/tahlil/update";
    }

    public String update() {
        Hasta h = hastaController.getDao().getById(selectedHasta);
        Doktor d = doktorController.getDao().getById(selectedDoktor);
        entity.setHasta(h);
        entity.setDoktor(d);

        this.getDao().update(entity);
        this.entity = new Tahlil();
        return "/module/tahlil/index";
    }

    public String deleteConfirm(Tahlil t) {
        this.entity = t;
        return "/module/tahlil/confirm_delete";
    }

    public String delete() {
        this.getDao().delete(entity);
        this.entity = new Tahlil();
        return "/module/tahlil/index";
    }

    public TahlilController() {
    }

    public TahlilDAO getDao() {
        if (this.tahlildao == null) {
            this.tahlildao = new TahlilDAO();
        }

        return tahlildao;
    }

    public void setDao(TahlilDAO dao) {
        this.tahlildao = tahlildao;
    }

    public Tahlil getEntity() {
        if (this.entity == null) {
            this.entity = new Tahlil();
        }
        return entity;
    }

    public void setEntity(Tahlil entity) {
        this.entity = entity;
    }

}
