/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entity.Bolum;
import entity.Doktor;
import util.DBConnection;
import entity.Hasta;
import entity.Randevu;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Sinem
 */
public class RandevuDAO extends DBConnection {

    private HastaDAO hastadao;
    private Hasta h;

    public HastaDAO getHastadao() {
        if (hastadao == null) {
            this.hastadao = new HastaDAO();
        }

        return hastadao;
    }

    private DoktorDAO doktordao;
    private Doktor d;

    public DoktorDAO getDoktordao() {
        if (doktordao == null) {
            this.doktordao = new DoktorDAO();
        }

        return doktordao;
    }

    public void setDoktordao(DoktorDAO doktordao) {
        this.doktordao = doktordao;
    }

    private BolumDAO bolumdao;
    private Bolum b;

    public BolumDAO getBolumdao() {
        if (bolumdao == null) {
            this.bolumdao = new BolumDAO();
        }

        return bolumdao;
    }

    public void setBolumdao(BolumDAO bolumdao) {
        this.bolumdao = bolumdao;
    }
    

    public void create(Randevu r) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate( "insert into randevu (tarih ,hasta_id,doktor_id,bolum_id) values('" + r.getTarih() + "' , '" + r.getHasta().getHasta_id() + "', '" +r.getDoktor().getDoktor_id()  + "', '" + r.getBolum().getBolum_id()+ "' ) ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Randevu> read() {
        List<Randevu> List = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from randevu order by randevu_id asc ");

            while (rs.next()) {
                Hasta h = this.getHastadao().getById(rs.getInt("hasta_id"));
                Doktor d = this.getDoktordao().getById(rs.getInt("doktor_id"));
                Bolum b = this.getBolumdao().getById(rs.getInt("bolum_id"));

                Randevu tmp = new Randevu(rs.getInt("r_id"), rs.getDate("tarih"), h, d, b);
                List.add(tmp);

            }
            st.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return List;
    }

    public void update(Randevu r) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update randevu set tarih='" + r.getTarih() + "' where r_id='" + r.getR_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Randevu r) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from randevu where hasta_id= " + r.getR_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

