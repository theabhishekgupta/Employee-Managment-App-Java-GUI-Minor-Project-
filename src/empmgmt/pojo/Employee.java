/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.pojo;

/**
 *
 * @author Abhishek Live
 */
public class Employee {
    
    
    
    public void setEmpName(String EmpName) {
        this.EmpName = EmpName;
    }

    public void setEmpId(int EmpId) {
        this.EmpId = EmpId;
    }

    public void setEmpSal(double EmpSal) {
        this.EmpSal = EmpSal;
    }

    public String getEmpName() {
        return EmpName;
    }

    public int getEmpId() {
        return EmpId;
    }

    public double getEmpSal() {
        return EmpSal;
    }

    public Employee(String EmpName, int EmpId, double EmpSal) {
        this.EmpName = EmpName;
        this.EmpId = EmpId;
        this.EmpSal = EmpSal;
    }

    public Employee() {
        
    }
    
    private String EmpName;
    private int EmpId;
    private double EmpSal;
    
    
    
}
