
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
public class Employee extends Validation implements Serializable {

    private double Salary;
    private final String empFileName = "Employee.bin";

    public static ArrayList<Employee> Employees = new ArrayList<Employee>();

    public Employee(String userName, String passWord, int id, String fName, String lName, String address, int age, double salary) {
        super(userName, passWord, id, fName, lName, address, age);
        this.Salary = salary;
    }

    public Employee(String userName, String passWord, int id, String fName, String lName, String address, int age) {
        super(userName, passWord, id, fName, lName, address, age);
    }

    
    
    public Employee() {
    }

    /////////////Getters And Setters
    
    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    
    //////////Employee Operations 
    
    public boolean addEmployee() {
        loadFromFile();
        Employees.add(this);
        return commitToFile();
    }

    public boolean commitToFile() {
        return FManager.write(empFileName, Employees);
    }

    
    
    public boolean commitToFileFirst(Employee x) {
        Employees.add(x);
        return FManager.write(empFileName,Employees);
    }
    
    
    
    
    
    public void loadFromFile() {
        Employees = (ArrayList<Employee>) FManager.read(empFileName);
    }

    public ArrayList<Employee> loadFromFileArr() {
        Employees = (ArrayList<Employee>) FManager.read(empFileName);
        return Employees;
    }

    private int getEmployeeIndex(int id) {
        for (int i = 0; i < Employees.size(); i++) {
            if (Employees.get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }

    public String displayAllEmployees() {
        loadFromFile();
        String S = "\nAll Employees Data:\n";
        for (Employee x : Employees) {
            S = S + x.toString();
        }
        return S;
    }

    public String searchEmployee(int id) {
        loadFromFile();
        int index = getEmployeeIndex(id);
        if (index != -1) {
            return "\nFound ...!" + Employees.get(index).toString();
        } else {
            return "\nNot Found ...!";
        }
    }
    
    
    
    
    
    private int getEmployeeIndexLogIN(String User) {
        for (int i = 0; i < Employees.size(); i++) {
            if (Employees.get(i).getUserName().equals(User)) {
                return i;
            }    
        }
        return -1;
    }
    
     public Employee searchEmployeeLogIN(String User) {
        loadFromFile();
        int index = getEmployeeIndexLogIN(User);
        if (index != -1) {
            return Employees.get(index);
        } else {
            Employee temp =new Employee();
            return temp;
        }
    }
    
    
    
     public Employee searchEmployeeForAlter(int id) {
        loadFromFile();
        int index = getEmployeeIndex(id);
        if (index != -1) {
            return Employees.get(index);
        } else {
         return new Employee() ;   
        }
    }
    

    public boolean updateEmployee(int oldID, Employee x) {
        loadFromFile();
        int index = getEmployeeIndex(oldID);

        if (index != -1) {
            Employees.set(index, x);
            return commitToFile();
        }

        return false;
    }

    public boolean deleteEmployee(int id) {
        loadFromFile();
        
        int index = getEmployeeIndex(id);

        if (index != -1) {
            Employees.remove(index);

            return commitToFile();
        }

        return false;
    }
    
    
    
     
    public String employeeProfile(int id ){
        loadFromFile();
        Reports x = new Reports();
        int index = getEmployeeIndex(id);
        if (index != -1) {
            return "\nFound ...!" + Employees.get(index).toString() + x.searchReportsEmp(id);
        } else {
            return "\nNot Found ...!";
        }
    }
    
    
    
    
    
    
    
    
    public void addNewCustomer(int id, String fName, String lName, String address, int age,  boolean RewardProgram, String Gifts , Order O) {
          Customer x = new Customer(id, fName, lName, address , age , RewardProgram , 0 , Gifts , O);
        if (x.addCustomer()) {
            System.out.println(x.toString() + "\nAdded Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }

    public void displayCustomer() {
        Customer x = new Customer();
        System.out.println(x.displayAllCustomers());
    }

    public void searchForCustomer(int id) {
        Customer x = new Customer();
        System.out.println(x.searchCustomer(id));
    }

    public void updateCustomer(int oldID, Customer newCustomerValues) {
        Customer x = new Customer();
        if (x.updateCustomer(oldID, newCustomerValues)) {
            System.out.println(newCustomerValues.toString() + "\nUpdated Successfully ... !");
        } else {
            System.out.println("Failed to Updated ... !");
        }
    }

    public void deleteCustomer(int Id) {
        Customer x = new Customer();
        if (x.deleteCustomer(Id)) {
           System.out.println("Customer : "+ Id + "\nDeleted Successfully ... !");
        } else {
            System.out.println("Failed to Deleted ... !");
        }
    }
    
    
    public void customerProfileLoader(int id){
        Customer x = new Customer();
        System.out.println(x.customerProfile(id));
    }
    
    
    public void addNewOrder(int custmerID, int orderID, String  pay_date , int num_of_meals ,ArrayList<Integer> mealsIDs) {  
        
        Order x = new Order(custmerID, orderID, pay_date , num_of_meals , mealsIDs );
          
        if (x.addorder()) {
            System.out.println(x.toString() + "\nAdded Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
        mealsIDs.clear();
    }


    public void deleteCustomerOrder(int Id) {
        Order x = new Order();
        if (x.deleteOrder(Id)) {
           System.out.println("Order : "+ Id + "\nDeleted Successfully ... !");
        } else {
            System.out.println("Failed to Deleted ... !");
        }
    }
    
    
   
    public void PrintBill(int OrderID){
        Billing x = new Billing();
        Order z = new Order();
        x.setBillDate(z.searchorder(OrderID).getPay_date());
        x.setBillId(OrderID);
        x.setBillprice(z.searchorder(OrderID).getOrderPrice());
        x.setMmeals(z.searchorder(OrderID).getCustomerMeals());
        if (x.addBilling()) {
           System.out.println(x.toString() + "\nAdded Successfully ... !");
        } else {
           System.out.println("Failed to insert ... !");
        }
    }
    
    
    
    
    
    
    
    
    

    @Override
    public String toString() {
        return "\nEmployee ID : " + id + "\nFirst Name : " + fName + "\nLast Name : " + lName + "\nEmployee Adress : " + address + "\nEmployee Age :" + age
               + "\nSalary : " + Salary + "\nUserName: " + userName + "\nPassword: " + password + "\n";
    }
}
