/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ilacDAO;
import entity.Doktor;
import entity.Hasta;
import entity.ilac;
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

public class ilacController implements Serializable {

    private ilacDAO ilacdao;
    private ilac entity;

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
        Hasta h = hastaController.getDao().getById(selectedHasta);
        entity.setDoktor(d);
        entity.setHasta(h);
        this.getIlacdao().create(entity);
        this.entity = new ilac();
        return "/module/ilac/index";
    }

    public List<ilac> getRead() {
        return this.getIlacdao().read();
    }

    public String updateForm(ilac i) {
        this.selectedDoktor = i.getDoktor().getDoktor_id();
        this.selectedHasta = i.getHasta().getHasta_id();
        this.entity = i;
        return "/module/ilac/update";
    }

    public String update() {
        Doktor d = doktorController.getDao().getById(selectedDoktor);
        Hasta h = hastaController.getDao().getById(selectedHasta);
        entity.setDoktor(d);
        entity.setHasta(h);
        this.getIlacdao().update(entity);
        this.entity = new ilac();
        return "/module/ilac/index";
    }

    public String deleteConfirm(ilac i) {
        this.entity = i;
        return "/module/ilac/confirm_delete";
    }

    public String delete() {
        this.getIlacdao().delete(entity);
        this.entity = new ilac();
        return "/module/ilac/index";
    }

    public ilacController() {
    }

    public ilacDAO getIlacdao() {
        if (this.ilacdao == null) {
            this.ilacdao = new ilacDAO();
        }
        return ilacdao;
    }

    public void setIlacdao(ilacDAO ilacdao) {
        this.ilacdao = ilacdao;
    }

    public ilac getEntity() {
        if (this.entity == null) {
            this.entity = new ilac();
        }
        return entity;
    }

    public void setEntity(ilac entity) {
        this.entity = entity;
    }

}
