/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Abhishek Live
 */
public class DBConnection {
    
    private static Connection conn;
    
    static{
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            conn =DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-HTE0KBN:1521/xe","abhishekDb","root");
            JOptionPane.showMessageDialog(null, "successfully Connect to the database ","Success",JOptionPane.INFORMATION_MESSAGE);     
        }
        
        catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Driver can not loaded","Driver Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "can not Connect to the database","DB Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
        }
    }
    
    public static Connection getConnection(){
        return conn;
    }
    
    public static void closeConnection(){
        try{
            conn.close();
            JOptionPane.showMessageDialog(null, "Connection Successfully Close ","Success",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error in Close Connect ","DB Error !",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
            
    }
    
    
  
    
}
