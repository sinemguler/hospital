/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RandevuDAO;
import entity.Bolum;
import entity.Doktor;
import entity.Hasta;
import entity.Randevu;
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
public class RandevuController implements Serializable {

    private RandevuDAO randevudao;
    private Randevu entity;

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

    @Inject
    private BolumController bolumController;

    private int selectedBolum;

    public int getSelectedBolum() {
        return selectedBolum;
    }

    public void setSelectedBolum(int selectedBolum) {
        this.selectedBolum = selectedBolum;
    }

    public String create() {

        Hasta h = hastaController.getDao().getById(selectedHasta);
        Doktor d = doktorController.getDao().getById(selectedDoktor);
        Bolum b = bolumController.getBolumdao().getById(selectedBolum);

        entity.setHasta(h);
        entity.setDoktor(d);
        entity.setBolum(b);

        this.getRandevudao().create(entity);
        this.entity = new Randevu();
        return "/module/randevu/index";
    }

    public List<Randevu> getRead() {
        return this.getRandevudao().read();
    }

    public String updateForm(Randevu r) {
        this.selectedHasta = r.getHasta().getHasta_id();

        this.selectedDoktor = r.getDoktor().getDoktor_id();

        this.selectedBolum = r.getBolum().getBolum_id();
        this.entity = r;
        return "/module/randevu/update";
    }

    public String update() {
        Hasta h = hastaController.getDao().getById(selectedHasta);

        Doktor d = doktorController.getDao().getById(selectedDoktor);

        Bolum b = bolumController.getBolumdao().getById(selectedBolum);
        entity.setHasta(h);
        entity.setDoktor(d);
        entity.setBolum(b);

        this.getRandevudao().update(entity);
        this.entity = new Randevu();
        return "/module/randevu/index";
    }

    public String deleteConfirm(Randevu r) {
        this.entity = r;
        return "/module/randevu/confirm_delete";
    }

    public String delete() {
        this.getRandevudao().delete(entity);
        this.entity = new Randevu();
        return "/module/randevu/index";
    }

    public RandevuController() {
    }

    public RandevuDAO getRandevudao() {
        if (this.randevudao == null) {
            this.randevudao = new RandevuDAO();
        }
        return randevudao;
    }

    public void setRandevudao(RandevuDAO randevudao) {
        this.randevudao = randevudao;
    }

    public Randevu getEntity() {
        if (this.entity == null) {
            this.entity = new Randevu();
        }
        return entity;
    }

    public void setEntity(Randevu entity) {
        this.entity = entity;
    }

}
