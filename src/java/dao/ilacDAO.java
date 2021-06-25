/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Doktor;
import entity.Hasta;
import entity.ilac;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Sinem
 */
public class ilacDAO extends DBConnection {

    private DoktorDAO ddao;
    private Doktor d;
    private HastaDAO hdao;
    private Hasta h;

    public HastaDAO getHdao() {
        if (hdao == null) {
            this.hdao = new HastaDAO();
        }
        return hdao;
    }

    public void setHdao(HastaDAO hdao) {
        this.hdao = hdao;
    }

    public DoktorDAO getDdao() {
        if (ddao == null) {
            this.ddao = new DoktorDAO();
        }

        return ddao;
    }

    public void setDdao(DoktorDAO ddao) {
        this.ddao = ddao;
    }

    public void create(ilac i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into ilac (ilac_adi, doktor_id, hasta_id) values('" + i.getIlac_adi() + "' ,'" + i.getDoktor().getDoktor_id() + "' ,'" + i.getHasta().getHasta_id() + "') ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<ilac> read() {
        List<ilac> List = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ilac order by ilac_id asc ");

            while (rs.next()) {
                Doktor d = this.getDdao().getById(rs.getInt("doktor_id"));
                Hasta h = this.getHdao().getById(rs.getInt("hasta_id"));
                ilac tmp = new ilac(rs.getInt("ilac_id"), rs.getString("ilac_adi"), d, h);
                List.add(tmp);

            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return List;
    }

    public void update(ilac i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update ilac set ilac_adi='" + i.getIlac_adi() + "' where ilac_id=" + i.getIlac_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(ilac i) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from ilac where ilac_id= " + i.getIlac_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

 
}
