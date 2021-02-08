/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resturant;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author meshm
 */
public class Reports implements Serializable {
    int id;
    String Description;
    FileManager FManger = new FileManager();
    private final String reportsEmployeesFileName = "ReportsEmployee.bin";
    private final String reportsCustomersFileName = "ReportsCustomers.bin";
    public static ArrayList<Reports> Reportss = new ArrayList<Reports>();

    public Reports() {
    }

    public Reports(int id , String Description) {
        this.Description = Description;
        this.id = id;
    }
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
    
    
    
    

   
    public boolean addReportsEmp()
    {
        loadFromFileEmp();
        Reportss.add(this);
        return commitToFileEmp();
    }
    
    
    public boolean commitToFileEmp() {
        return FManger.write(reportsEmployeesFileName, Reportss);
    }

    
    public void loadFromFileEmp()
    {
        Reportss = (ArrayList<Reports>)FManger.read(reportsEmployeesFileName);
    }
    
    
    
    
    
    //-------------------------------------------------------//
    //index of employee report
    private int ReportsIndexEmp(int id) {
        for (int x = 0; x < Reportss.size(); x++) {
            if (Reportss.get(x).getId()== id) {
                return x;
            }
        }
        return -1;
    }
    // report employee of index #
    public String searchReportsEmp(int id) {
        loadFromFileEmp();
        int index = ReportsIndexEmp(id);
        if (index != -1) {
            return "\nFound ...!" + Reportss.get(index).toString();
        } else {
            return "\nNot Found Reports For This Employee...!";
        }
    }
    
    
    public String listReportsEmp() {
        loadFromFileEmp(); 
        String S = "\nAll Reports Employees Data:\n";
        for (Reports m : Reportss) {
            S = S + m.toString();
        }
        return S;
    } 
    
     public String listReportsCust() {
        loadFromFilecust();
        String S = "\nAll Reports Customers Data:\n";
        for (Reports m : Reportss) {
            S = S + m.toString();
        }
        return S;
    }
    
    /////////////add Repotr to customer
     
     
    public boolean addReportsCust()
    {
        loadFromFilecust();
        Reportss.add(this);
        return commitToFilecust();
    }
    
    
    public boolean commitToFilecust() {
        return FManger.write(reportsCustomersFileName, Reportss);
    }
    
    
    
     public void loadFromFilecust()
    {
        Reportss = (ArrayList<Reports>)FManger.read(reportsCustomersFileName);
    }

    
    //-------------------------------------------------------//
    //index of customer report
    public int ReportsIndexCust(int id) {
        for (int x = 0; x < Reportss.size(); x++) {
            if (Reportss.get(x).getId() == id) {
                return x;
            }
        }
        return -1;
    }
    // customer report of index #
    public String searchReportsCust(int id) {
        loadFromFilecust();
        int index = ReportsIndexCust(id);
        if (index != -1) {
            return "\nFound ...!" + Reportss.get(index).toString();
        } else {
            return "\nNot Found ... Reports For This Customer !";
        }
    }
    
    

    @Override
    public String toString() {
        return "\n\nReport ID : " + id + " \nDescription = " + Description ;
    }
    
    
    
   
    
}
