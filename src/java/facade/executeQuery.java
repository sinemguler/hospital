/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

/**
 *
 * @author Sinem
 */
import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnection;

public class executeQuery extends DBConnection implements dbinterface {

    @Override
    public void executeSorgu(String sorgu) {
        Statement st = null;

        try {
            st = this.connect().createStatement();
            st.executeQuery(sorgu);

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

}
