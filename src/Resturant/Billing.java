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
public class Billing implements Serializable {
    private String billDate;
    private int billId;
    private double billprice;
    FileManager FManager = new FileManager();
    private final String BillingFileName = "Biling.bin";
    public static ArrayList<Billing> Billings = new ArrayList<Billing>();
    
    public  ArrayList<Meals> mmeals = new ArrayList<Meals>();
    

   

    public Billing() {
    }
    
    

    public Billing(String billDate, int billId, double billprice) {
        this.billDate = billDate;
        this.billId = billId;
        this.billprice = billprice;
    }

    public Billing(String billDate, int billId) {
        this.billDate = billDate;
        this.billId = billId;
    }

    public  ArrayList<Meals> getMmeals() {
        return mmeals;
    }

    public void setMmeals(ArrayList<Meals> mmeals) {
        this.mmeals = mmeals;
    }

    
    
    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public double getBillprice() {
        return billprice;
    }

    public void setBillprice(double billprice) {
        this.billprice = billprice;
    }
    
    
    
    
    
    ////////////////////////////////////
    
    
    
    public boolean addBilling()
    {
        Billings.add(this);
        return commitToFile();
    }
    
    public boolean commitToFile() {
        return FManager.write(BillingFileName, Billings);
    }

    public void loadFromFile()
    {
        Billings = (ArrayList<Billing>)FManager.read(BillingFileName);
    }
    //-------------------------------------------------------//
    //index of billing
    
    

    
    
    
    
    
    public ArrayList<Billing> listBilling()
    {
        loadFromFile();
        return Billings;
    }
    //---------------------------------
    //-------------------------------------------------------//
    
    @Override
    public String toString() //override 
    {
        return  "\nBill ID : " + billId + "\nDate : " + billDate + "\nBill Price = " + billprice +"\nOrder's Meals " + mmeals ;
    }
    
    
    
}

