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
public class Customer extends Person implements Serializable{

    private double Payments = 0  ;
    private boolean RewardProgram ;
    private int NumOfOrders ;
    private String Gifts ;
    private ArrayList<Order> orders = new ArrayList<Order>();
    
    private final String custFileName = "Customer.bin";
    public static ArrayList<Customer> Customers = new ArrayList<Customer>();


    public Customer() {
    }

    public Customer(int id, String fName, String lName, String address, int age , boolean RewardProgram, int NumOfOrders, String Gifts , Order O) {
        super(id, fName, lName, address, age);
        this.RewardProgram = RewardProgram;
        this.NumOfOrders = NumOfOrders;
        this.Gifts = Gifts;
        this.orders.add(O);
    }

    public Customer(int id, String fName, String lName, String address, int age) {
        super(id, fName, lName, address, age);
    }

    public Customer(boolean RewardProgram, String Gifts, int id, String fName, String lName, String address, int age) {
        super(id, fName, lName, address, age);
        this.RewardProgram = RewardProgram;
        this.Gifts = Gifts;
    }

    
    
    public double getPayments() {
        return Payments;
    }

    public void setPayments(double payments) {
        this.Payments += payments;
    }

    public boolean isRewardProgram() {
        return RewardProgram;
    }

    public void setRewardProgram(boolean RewardProgram) {
        this.RewardProgram = RewardProgram;
    }
    

    public int getNumOfOrders() {
        return NumOfOrders;
    }

    public void setNumOfOrders(int NumOfOrders) {
        this.NumOfOrders = NumOfOrders;
    }

    public String getGifts() {
        return Gifts;
    }

    public void setGifts(String Gifts) {
        this.Gifts = Gifts;
    }


    
    /////////////////////////////////////////////
    
    public boolean addCustomer() {
        loadFromFile();
        Customers.add(this);
        return commitToFile();
    }

    public boolean commitToFile() {
        return FManager.write(custFileName, Customers);
    }

    public void loadFromFile() {
        Customers = (ArrayList<Customer>) FManager.read(custFileName);
    }
    
    
    public ArrayList<Customer> loadFromFileArrcust() {
        Customers = (ArrayList<Customer>) FManager.read(custFileName);
        return Customers;
    }

    private int getCustomerIndex(int id) {
        for (int i = 0; i < Customers.size(); i++) {
            if (Customers.get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }

    public String displayAllCustomers() {
        loadFromFile();
        String S = "\nAll Customers Data:\n";
        for (Customer x : Customers) {
            S = S + x.toString();
        }
        return S;
    }

    public String searchCustomer(int id) {
        loadFromFile();
        int index = getCustomerIndex(id);
        if (index != -1) {
            return "\nFound ...!" + Customers.get(index).toString();
        } else {
            return "\nNot Found ...!";
        }
    }

    public boolean updateCustomer(int oldID, Customer x) {
        loadFromFile();
        int index = getCustomerIndex(oldID);

        if (index != -1) {
            Customers.set(index, x);

            return commitToFile();
        }

        return false;
    }

    public boolean deleteCustomer(int id) {
        loadFromFile();
        int index = getCustomerIndex(id);

        if (index != -1) {
            Customers.remove(index);

            return commitToFile();
        }

        return false;
    }
    
    
    
    
    
    
    public Customer searchCustomerOrder(int id) {
        loadFromFile();
        int index = getCustomerIndex(id);
        if (index != -1) {
           
            return Customers.get(index);
            
        } else {
            
            return new Customer();
        }
    }
    
    
    
    
    
    public String customerProfile(int id ){
        loadFromFile();
        Reports x = new Reports();
        Order l = new Order();
        RewardProgram r = new RewardProgram();
        int index = getCustomerIndex(id);
        if (index != -1) {
            if(Customers.get(index).getPayments() >= 500){
                Customers.get(index).setGifts("Yes" + r.toString());
            }
            return "\nFound ...!" + Customers.get(index).toString() + "\nCustomer Reports " + x.searchReportsCust(id) + "\nCustomer Orders \n" +l.searchorderCustomer(id).toString() ;
        } else {
            return "\nNot Found ...!";
        }
    }

    
    
    @Override
    public String toString() {
        return "\n\nCustomer ID : " + id + "\nFirst Name : " + fName + "\nLast Name : " + lName + "\nCustomer Adress :" + address + "\nCustomer Age :" + age 
               + "\nReward program : " + RewardProgram + "\nNumber of orders : " + NumOfOrders + "\nCustomer gifts : "+ Gifts + "\nCustomer Payments = " + Payments;
    }    
    
}

