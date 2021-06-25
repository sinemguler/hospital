/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BolumDAO;
import entity.Bolum;
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
public class BolumController implements Serializable {
    
    private BolumDAO bolumdao;
    private Bolum entity;
    
    public String create() {
        this.getBolumdao().create(entity);
        this.entity = new Bolum();
        return "/module/bolum/index";
    }

    public List <Bolum> getRead() {
        return this.getBolumdao().read();
    }

    public String updateForm(Bolum b) {
        this.entity = b;
        return "/module/bolum/update";
    }

    public String update() {
        this.getBolumdao().update(entity);
        this.entity = new Bolum();
        return "/module/bolum/index";
    }

    public String deleteConfirm(Bolum b) {
        this.entity = b;
        return "/module/bolum/confirm_delete";
    }

    public String delete() {
        this.getBolumdao().delete(entity);
        this.entity = new Bolum();
        return "/module/bolum/index";
    }
    

    public BolumController() {
    }

    public BolumDAO getBolumdao() {
        if (this.bolumdao == null){
            this.bolumdao = new BolumDAO();
        }
        return bolumdao;
    }

    public void setBolumdao(BolumDAO bolumdao) {
        this.bolumdao = bolumdao;
    }

    public Bolum getEntity() {
        if (this.entity == null){
            this.entity = new Bolum();
        }
        return entity;
    }

    public void setEntity(Bolum entity) {
        this.entity = entity;
    }

  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
