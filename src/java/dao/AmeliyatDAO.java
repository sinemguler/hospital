/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Ameliyat;
import entity.Doktor;
import entity.Hasta;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Sinem
 */
public class AmeliyatDAO extends DBConnection {
     private DoktorDAO ddao;
    private Doktor d;
    private HastaDAO hdao;
    private Hasta h;

    public HastaDAO getHdao() {
        if (hdao == null){
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

    public void create(Ameliyat a) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into ameliyat (ameliyat_ismi, ameliyat_tarihi, doktor_id, hasta_id) values('" + a.getAmeliyat_ismi() + "', " + a.getAmeliyat_tarihi() + "' ,'" + a.getDoktor().getDoktor_id() + "' ,'" + a.getHasta().getHasta_id() + "') ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List <Ameliyat> read() {
        List<Ameliyat> List = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ameliyat order by ameliyat_id asc ");

            while (rs.next()) {
                Doktor d = this.getDdao().getById(rs.getInt("doktor_id"));
                Hasta h = this.getHdao().getById(rs.getInt("hasta_id"));
                Ameliyat tmp = new Ameliyat(rs.getInt("ameliyat_id"), rs.getString("ameliyat_ismi"), rs.getString("ameliyat_tarihi"), d, h);
                List.add(tmp);

            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return List;
    }

    public void update(Ameliyat a) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update ameliyat set ameliyat_ismi='" + a.getAmeliyat_ismi() + "' , ameliyat_tarihi='" + a.getAmeliyat_tarihi() + "' where ameliyat_id=" + a.getAmeliyat_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Ameliyat a) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from ameliyat where ameliyat_id= " + a.getAmeliyat_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
