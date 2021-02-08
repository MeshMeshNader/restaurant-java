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
        
    public abstract class Person implements Serializable {
    protected int id ;
    protected String fName ;
    protected String lName ;
    protected String address ;
    protected int age ;
    
    FileManager FManager = new FileManager();

    

    public Person(int id, String fName, String lName, String address, int age) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.age = age;
    }



    public Person() {
    }
    
    
////////////////////////////////// Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", fName=" + fName + ", lName=" + lName + ", address=" + address + ", age=" + age + '}';
    }
    
    
    
    
    }
    

