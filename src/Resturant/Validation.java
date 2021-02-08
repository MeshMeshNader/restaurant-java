/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resturant;

import java.io.Serializable;

/**
 *
 * @author meshm
 */
public abstract class Validation extends Person implements Serializable {
    protected String userName ;
    protected  String password ;

    
    
    
    public Validation(String userName, String passWord, int id, String fName, String lName, String address, int age) {
        super(id, fName, lName, address, age);
        this.userName = userName;
        this.password = passWord;
    }

    public Validation(String userName, String passWord) {
        this.userName = userName;
        this.password = passWord;
    }

    public Validation() {
    }
    
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return password;
    }

    public void setPassWord(String passWord) {
        this.password = passWord;
    }
    
    @Override
    public abstract String toString();
    
    
    public boolean loginAsadmin(String userName, String Pass) {
        Admin x = new Admin();
        return userName.equals(x.loadFromFile().getUserName()) && Pass.equals(x.loadFromFile().getPassWord());
    }
    
    public boolean checkEmpAlter(String userName, String Pass ,int id){
        Employee x = new Employee();
        return userName.equals(x.searchEmployeeForAlter(id).getUserName()) && Pass.equals(x.searchEmployeeForAlter(id).getPassWord());
    }
    
    public boolean loginAsEmployee(String userName, String Pass) {
        Employee c = new Employee();
        return userName.equals(c.searchEmployeeLogIN(userName).getUserName()) && Pass.equals(c.searchEmployeeLogIN(userName).getPassWord());
    }
    
}