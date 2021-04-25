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

    public List<Doktor> getRead(){
        return this.getDao().read();  
    }
    
    public String create(){
        this.getDao().create(entity);
        return "/doktor/create";
    }
    
    public void delete(Doktor d){
        this.getDao().delete(d);
        
    }
    
    public String updateForm(Doktor d){
        this.entity = d;
        return "/doktor/update";
    }
    
    public String update(){
        this.getDao().update(entity);
        return "/doktor/index";
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
        this.doktordao= doktordao;
    }

    public Doktor getEntity() {
        return entity;
    }

    public void setEntity(Doktor entity) {
        if (this.entity == null) {
            this.entity = new Doktor();
        }
        this.entity = entity;
    }
    
    
    
    
    
    
    
    
    
    
}
