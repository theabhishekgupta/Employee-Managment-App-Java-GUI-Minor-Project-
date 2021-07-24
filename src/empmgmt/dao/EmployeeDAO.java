/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dao;

import empmgmt.dbutil.DBConnection;
import empmgmt.pojo.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Abhishek Live
 */
public class EmployeeDAO {
    
    public static boolean addEmployee(Employee e)throws SQLException{
        Connection conn= DBConnection.getConnection();
        
        PreparedStatement ps =conn.prepareStatement("insert into guiemp values(?,?,?)");
        
        ps.setInt(1,e.getEmpId());
        ps.setString(2,e.getEmpName());
        ps.setDouble(3, e.getEmpSal());
        
        int result =ps.executeUpdate();
        return result == 1 ;
    }
    
    public static Employee findEmployeeById(int empId)throws SQLException{
        Connection conn= DBConnection.getConnection();
        PreparedStatement ps =conn.prepareStatement("Select * from GUIEMP where EMPID = ?");
        
        ps.setInt(1, empId);
        
        ResultSet rs = ps.executeQuery();
        Employee e1=null;
        
        if(rs.next()){
            e1 =new Employee();
            e1.setEmpId(rs.getInt(1));
            e1.setEmpName(rs.getString(2));
            e1.setEmpSal(rs.getDouble(3));
            
        }
        return e1;
        
    }
    
    public static ArrayList<Employee> getAllEmployee()throws SQLException{
        Connection conn= DBConnection.getConnection();
        
        Statement st =conn.createStatement();
        ResultSet rs= st.executeQuery("select * from GUIEMP");
        
        ArrayList<Employee> empList = new ArrayList<>();
        while(rs.next()){
            Employee e1 =new Employee();
            e1.setEmpId(rs.getInt(1));
            e1.setEmpName(rs.getString(2));
            e1.setEmpSal(rs.getDouble(3));
            empList.add(e1);
        }
        return empList;
        
    }
      
}
