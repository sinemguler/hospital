/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sinem
 */
public abstract class DBConnection {
    private Connection connection;
    
    public Connection connect() throws SQLException{
        if(this.connection == null || this.connection.isClosed())
         try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Hospital", "postgres", "1999");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return this.connection;

    }
    }

