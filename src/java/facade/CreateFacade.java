/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnection;


public class CreateFacade {

    private executeQuery exeQ;
    private executeupdate exeU;

    public CreateFacade() {
        exeQ = new executeQuery();
        exeU = new executeupdate();

    }

    public void executeQuery(String sorgu) {
        exeQ.executeSorgu(sorgu);
    }

    public void executeUpdate(String sorgu) {
        exeU.executeSorgu(sorgu);
    }

}