/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.HastaDAO;
import entity.Hasta;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Sinem
 */
@Named
@SessionScoped
public class HastaController implements Serializable {

    private HastaDAO hastadao;
    private Hasta entity;

    public String create() {
        this.getDao().create(entity);
        this.entity = new Hasta();
        return "/module/hasta/index";
    }

    public List<Hasta> getRead() {
        return this.getDao().read();
    }

    public String updateForm(Hasta h) {
        this.entity = h;
        return "/module/hasta/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new Hasta();
        return "/module/hasta/index";
    }

    public String deleteConfirm(Hasta h) {
        this.entity = h;
        return "/module/hasta/confirm_delete";
    }

    public String delete() {
        this.getDao().delete(entity);
        this.entity = new Hasta();
        return "/module/hasta/index";
    }

    public HastaController() {
    }

    public HastaDAO getDao() {
        if (this.hastadao == null) {
            this.hastadao = new HastaDAO();
        }

        return hastadao;
    }

    public void setDao(HastaDAO dao) {
        this.hastadao = hastadao;
    }

    public Hasta getEntity() {
        if (this.entity == null) {
            this.entity = new Hasta();
        }
        return entity;
    }

    public void setEntity(Hasta entity) {
        this.entity = entity;
    }

}
