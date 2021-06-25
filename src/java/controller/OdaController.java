/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OdaDAO;
import entity.Hasta;
import entity.Oda;
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
public class OdaController implements Serializable {

    private OdaDAO odadao;
    private Oda entity;

    @Inject
    private HastaController hastaController;

    private int selectedHasta;

    public int getSelectedHasta() {
        return selectedHasta;
    }

    public void setSelectedHasta(int selectedHasta) {
        this.selectedHasta = selectedHasta;
    }

    public String create() {
        Hasta h = hastaController.getDao().getById(selectedHasta);
        entity.setHasta(h);
        this.getOdadao().create(entity);
        this.entity = new Oda();
        return "/module/oda/index";
    }

    public List<Oda> getRead() {
        return this.getOdadao().read();
    }

    public String updateForm(Oda o) {
        this.selectedHasta = o.getHasta().getHasta_id();
        this.entity = o;
        return "/module/oda/update";
    }

    public String update() {
        Hasta h = hastaController.getDao().getById(selectedHasta);
        entity.setHasta(h);
        this.getOdadao().update(entity);
        this.entity = new Oda();
        return "/module/oda/index";
    }

    public String deleteConfirm(Oda o) {
        this.entity = o;
        return "/module/oda/confirm_delete";
    }

    public String delete() {
        this.getOdadao().delete(entity);
        this.entity = new Oda();
        return "/module/oda/index";
    }

    public OdaController() {
    }

    public OdaDAO getOdadao() {
        if (this.odadao == null) {
            this.odadao = new OdaDAO();
        }
        return odadao;
    }

    public void setOdadao(OdaDAO odadao) {
        this.odadao = odadao;
    }

    public Oda getEntity() {
        if (this.entity == null) {
            this.entity = new Oda();
        }
        return entity;
    }

    public void setEntity(Oda entity) {
        this.entity = entity;
    }

}
