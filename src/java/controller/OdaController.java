/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OdaDAO;
import entity.Oda;
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
public class OdaController implements Serializable {
    
     private OdaDAO dao;
    private Oda entity;

     public String create() {
        this.getDao().create(entity);
        this.entity = new Oda();
        return "/module/oda/index";
    }

    public List<Oda> getRead() {
        return this.getDao().read();
    }

    public String updateForm(Oda o) {
        this.entity = o;
        return "/module/oda/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new Oda();
        return "/module/oda/index";
    }

    public String deleteConfirm(Oda o) {
        this.entity = o;
        return "/module/oda/confirm_delete";
    }

    public String delete() {
        this.getDao().delete(entity);
        this.entity = new Oda();
        return "/module/oda/index";
    }

    public OdaController() {
    }

    public OdaDAO getDao() {
        if (this.dao == null) {
            this.dao = new OdaDAO();
        }
        return dao;
    }

    public void setDao(OdaDAO dao) {
        this.dao = dao;
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
