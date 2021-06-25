/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Doktor;
import facade.CreateFacade;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Sinem
 */
public class DoktorDAO extends DBConnection {

        CreateFacade Facade = new CreateFacade();

    public Doktor getById(int id) {
        Doktor d = null;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from doktor where doktor_id=" + id);

            rs.next();

            d = new Doktor(rs.getInt("doktor_id"), rs.getString("isim"), rs.getString("tc"), rs.getString("tel_numarasi"));
        } catch (Exception e) {

        }
        return d;
    }

    public List<Doktor> read() {
        List<Doktor> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from doktor order by doktor_id asc");//doktorid göre artan sıralama 

            while (rs.next()) {
                Doktor tmp = new Doktor(rs.getInt("doktor_id"), rs.getString("isim"), rs.getString("tc"), rs.getString("tel_numarasi"));
                list.add(tmp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void create(Doktor d) {
        String sorgu = "insert into doktor (isim , tc, tel_numarasi) values('" + d.getIsim() + "' , '" + d.getTc() + "', '" + d.getTel_numarasi() + "' ) ";
        Facade.executeUpdate(sorgu);
        read();
    }

    public void update(Doktor d) {
        String Sorgu = "update doktor set isim='" + d.getIsim() + "' , tc='" + d.getTc() + "' , tel_numarasi='" + d.getTel_numarasi() + "' where doktor_id=" + d.getDoktor_id() + "";
        Facade.executeUpdate(Sorgu);
    }

    public void delete(Doktor d) {
        String sorgu = "delete from doktor where doktor_id = "+d.getDoktor_id()+"";
        Facade.executeUpdate(sorgu);

    }
}