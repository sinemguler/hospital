/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Fatura;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Sinem
 */
public class FaturaDAO extends DBConnection{
    
    public void create(Fatura f){
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into fatura (fatura_tarihi , miktar) values('" + f.getFatura_id() + "' , '" + f.getMiktar() + "') ");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
    public List<Fatura> read(){
         List<Fatura> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from fatura order by fatura_id asc");

            while(rs.next ()){
            Fatura tmp = new Fatura(rs.getInt("fatura_id"), rs.getString("fatura_tarihi"), rs.getInt("miktar"));
            list.add(tmp);
        }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public void update(Fatura f){
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update fatura set fatura_tarihi='" + f.getFatura_tarihi() + "' , miktar='" + f.getMiktar() + "'  where doktor_id=" + f.getFatura_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
    
     public void delete(Fatura f){
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from fatura where fatura_id="+f.getFatura_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
