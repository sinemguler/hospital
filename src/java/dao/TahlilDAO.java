/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entity.Doktor;
import entity.Hasta;
import entity.Tahlil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Sinem
 */
public class TahlilDAO extends DBConnection {

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

    public void create(Tahlil t) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into tahlil (tipi , hasta_id, doktor_id) values('" + t.getTipi() + "' , '" + t.getHasta().getHasta_id() + "' ,'" + t.getDoktor().getDoktor_id() + "' ) ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Tahlil> read() throws SQLException {
        List<Tahlil> List = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from hasta order by tahlil_id asc ");

            while (rs.next()) {
                Hasta h = this.getHdao().getById(rs.getInt("hasta_id"));
                Doktor d = this.getDdao().getById(rs.getInt("doktor_id"));

                Tahlil tmp = new Tahlil(rs.getInt("tahlil_id"), rs.getString("tipi"), h, d);
                List.add(tmp);

            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return List;
    }

    public void update(Tahlil t) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update tahlil set tipi='" + t.getTipi() + "'   where hasta_id=" + t.getTahlil_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Tahlil t) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from tahlil where hasta_id= " + t.getTahlil_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
