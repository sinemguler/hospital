/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entity.Doktor;
import util.DBConnection;
import entity.Hasta;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Sinem
 */
public class HastaDAO extends DBConnection {
    
    private DoktorDAO ddao;
    private Doktor d;

    public DoktorDAO getDdao(){
        if (ddao == null){
            this.ddao = new DoktorDAO();
        }
            
        return ddao;
    }

    public void setDdao(DoktorDAO ddao) {
        this.ddao = ddao;
    }
    
    public Hasta getById(int id) {
        Hasta h = null;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from hasta where hasta_id=" + id);
            rs.next();

            h = new Hasta(rs.getInt("hasta_id"), rs.getString("isim"), rs.getString("tc"), rs.getString("dog_tarihi"), rs.getInt("tel_numarasi"),d);
        } catch (Exception e) {

        }
        return h;
    }

    public void create(Hasta h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into hasta (isim , tc, dog_tarihi, tel_numarasi, doktor_id) values('" + h.getIsim() + "' , '" + h.getTc() + "', '" + h.getDog_tarihi()+ "', '" + h.getTel_numarasi()+ "','" + h.getDoktor().getDoktor_id()+ "' ) ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Hasta> read() {
        List<Hasta> List = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from hasta order by hasta_id asc ");

            while (rs.next()) {
                Doktor d = this.getDdao().getById( rs.getInt("doktor_id"));
                Hasta tmp = new Hasta(rs.getInt("hasta_id"), rs.getString("isim"), rs.getString("tc"), rs.getString("dog_tarihi"), rs.getInt("tel_numarasi"), d);
                List.add(tmp);

            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return List;
    }

    public void update(Hasta h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update hasta set isim='" + h.getIsim() + "' , tc='" + h.getTc() + "' , tel_numarasi='" +h.getTel_numarasi() + "' ,dog_tarihi='" + h.getDog_tarihi() +"'  where hasta_id=" + h.getHasta_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Hasta h) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from hasta where hasta_id= " + h.getHasta_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}