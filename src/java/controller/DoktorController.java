/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DoktorDAO;
import entity.Doktor;
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
public class DoktorController implements Serializable {

    private DoktorDAO doktordao;
    private Doktor entity;

    public String create() {
        this.getDao().create(entity);
        this.entity = new Doktor();
        return "/module/doktor/index";
    }

    public Doktor getById(int id){
        return this.getDao().getById(id);
    }
    
    
    public List<Doktor> getRead() {
        return this.getDao().read();
    }

    public String updateForm(Doktor d) {
        this.entity = d;
        return "/module/doktor/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity = new Doktor();
        return "/module/doktor/index";
    }

    public String deleteConfirm(Doktor d) {
        this.entity = d;
        return "/module/doktor/confirm_delete";
    }

    public String delete() {
        this.getDao().delete(entity);
        this.entity = new Doktor();
        return "/module/doktor/index";
    }

    public DoktorController() {
    }

    public DoktorDAO getDao() {
        if (this.doktordao == null) {
            this.doktordao = new DoktorDAO();
        }

        return doktordao;
    }

    public void setDao(DoktorDAO dao) {
        this.doktordao = doktordao;
    }

    public Doktor getEntity() {
        if (this.entity == null) {
            this.entity = new Doktor();
        }
        return entity;
    }

    public void setEntity(Doktor entity) {
        this.entity = entity;
    }

}
