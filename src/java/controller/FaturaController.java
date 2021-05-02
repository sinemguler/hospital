/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FaturaDAO;
import entity.Fatura;
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
public class FaturaController implements Serializable {
    private FaturaDAO dao;
    private Fatura entity;

     public String create() {
        this.getDao().create(entity);
        this.entity = new Fatura();
        return "/module/fatura/index";
    }

    public List<Fatura> getRead() {
        return this.getDao().read();
    }

    public String updateForm(Fatura f) {
        this.entity = f;
        return "/module/fatura/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new Fatura();
        return "/module/fatura/index";
    }

    public String deleteConfirm(Fatura f) {
        this.entity = f;
        return "/module/fatura/confirm_delete";
    }

    public String delete() {
        this.getDao().delete(entity);
        this.entity = new Fatura();
        return "/module/fatura/index";
    }

    
    
    public FaturaController() {
    }

    public Fatura getEntity() {
         if (this.entity == null) {
            this.entity = new Fatura();
        }
        return entity;
    }

    public void setEntity(Fatura entity) {
        this.entity = entity;
    }

    public FaturaDAO getDao() {
         if (this.dao == null) {
            this.dao = new FaturaDAO();
        }
        return dao;
    }

    public void setDao(FaturaDAO dao) {
        this.dao = dao;
    }
    
    
}
