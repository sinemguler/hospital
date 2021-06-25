/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Hasta;
import entity.Oda;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Sinem
 */
public class OdaDAO extends DBConnection {

    private HastaDAO hastadao;
    private Hasta h;

    public HastaDAO getHastadao() {
        if (hastadao == null) {
            this.hastadao = new HastaDAO();
        }

        return hastadao;
    }

    public void setHastadao(HastaDAO hastadao) {
        this.hastadao = hastadao;
    }

    public void create(Oda o) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into oda (kat , oda_numarasi, hasta_id) values('" + o.getKat() + "' , '" + o.getOda_numarasi() + "' , '" + o.getHasta().getHasta_id() + "' ) ");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public List<Oda> read() {
        List<Oda> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from oda order by oda_id asc");

            while (rs.next()) {
                Hasta h = this.getHastadao().getById(rs.getInt("hasta_id"));
                Oda tmp = new Oda(rs.getInt("oda_id"), rs.getString("kat"), rs.getInt("oda_numarasi"), h);
                list.add(tmp);
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void update(Oda o) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update oda set kat='" + o.getKat() + "' , oda_numarasi='" + o.getOda_numarasi() + "'  where oda_id=" + o.getOda_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void delete(Oda o) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from oda where oda_id=" + o.getOda_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

}
