/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
    
    public void create(Oda o){
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into oda (kat , oda_numarasi) values('" + o.getKat() + "' , '" + o.getOda_numarasi()+ "' ) ");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
    
     public List<Oda> read(){
         List<Oda> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from oda order by oda_id asc");

            while(rs.next ()){
            Oda tmp = new Oda(rs.getInt("oda_id"), rs.getString("kat"), rs.getInt("oda_numarasi"));
            list.add(tmp);
        }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
     
      public void update(Oda o){
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update oda set isim='" + o.getKat() + "' , oda_numarasi='" + o.getOda_numarasi() + "'  where oda_id=" + o.getOda_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
      
       public void delete(Oda o){
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from oda where oda_id="+o.getOda_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
