/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Bolum;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Sinem
 */
public class BolumDAO extends DBConnection {

    public Bolum getById(int id) {
        Bolum b = null;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from bolum where bolum_id=" + id);
            rs.next();

            b = new Bolum(rs.getInt("bolum_id"), rs.getString("bolum_ismi"));
        } catch (Exception e) {

        }
        return b;
    }

    public void create(Bolum b) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into bolum (bolum_ismi) values('" + b.getBolum_ismi() + "') ");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public List<Bolum> read() {
        List<Bolum> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from bolum order by bolum_id asc");

            while (rs.next()) {
                Bolum tmp = new Bolum(rs.getInt("bolum_id"), rs.getString("bolum_ismi"));
                list.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void update(Bolum b) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update bolum set bolum_ismi='" + b.getBolum_ismi() + "' where bolum_id=" + b.getBolum_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void delete(Bolum d) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from bolum where bolum_id=" + d.getBolum_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

}
