/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jeff Maxwell
 */
public class DBHelper {
    public static Connection connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentregistration",
                            "root",
                            "password");
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("DB Connection : " + ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.err.println("ERROR: " + ex.getMessage());
            return null;
        }
    }
}
