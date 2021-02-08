/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resturant;

import javax.swing.text.html.HTMLDocument;


/**
 *
 * @author meshm
 */
public class Admin extends Validation {

        private final String adminFileName = "Admin.bin";

    public Admin() {
    }

    public Admin(String userName, String passWord, int id, String fName, String lName, String address, int age) {
        super(userName, passWord, id, fName, lName, address, age);
    }

    
    
    public boolean commetToFile(Admin   x){
        return FManager.write(adminFileName, x);
    }
    
    public Admin loadFromFile(){
        return (Admin) FManager.read(adminFileName);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public void addNewEmployee(String userName, String password, int id, String fName, String lName, String address, int age, double salary) {
        Employee x = new Employee(userName, password, id, fName, lName, address , age , salary);
        if (x.addEmployee()) {
            System.out.println(x.toString() + "\nAdded Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }

    public void displayEmployees() {
        Employee x = new Employee();
        System.out.println(x.displayAllEmployees());
    }

    public void searchForEmployee(int id) {
        Employee x = new Employee();
        System.out.println(x.searchEmployee(id));
    }

    public void updateEmployee(int oldID, Employee newEmployeeValues) {
        Employee x = new Employee();
        if (x.updateEmployee(oldID, newEmployeeValues)) {
            System.out.println(newEmployeeValues.toString() + "\nUpdated Successfully ... !");
        } else {
            System.out.println("Failed to Updated ... !");
        }
    }

    public void deleteEmployee(int Id) {
        Employee x = new Employee();
        if (x.deleteEmployee(Id)) {
           System.out.println("Employee : "+ Id + "\nDeleted Successfully ... !");
        } else {
            System.out.println("Failed to Deleted ... !");
        }
    }
    
    
    
    public void profileForEmployee(int id) {
        Employee x = new Employee();
        System.out.println(x.employeeProfile(id));
    }
    
    
    public void addNewMeal(String mealName, int mealId, double mealPrice) {
        Meals x = new Meals(mealName,mealId,mealPrice );
        if (x.addMeal()) {
            System.out.println(x.toString() + "\nAdded Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }

    public void displayMeal() {
        Meals x = new Meals();
        System.out.println(x.displayAllMeals());
    }

    public void searchForMeal(int id) {
        Meals x = new Meals();
        System.out.println(x.searchMeal(id));
    }

    public void updateMeal(int oldID, Meals newMealValues) {
        Meals x = new Meals();
        if (x.updateMeal(oldID, newMealValues)) {
            System.out.println(newMealValues.toString() + "\nUpdated Successfully ... !");
        } else {
            System.out.println("Failed to Updated ... !");
        }
    }

    public void deleteMeal(int Id) {
        Meals x = new Meals();
        if (x.deleteMeal(Id)) {
           System.out.println("Meal : "+ Id + "\nDeleted Successfully ... !");
        } else {
            System.out.println("Failed to Deleted ... !");
        }
    }
    
    
    public void addCustReport(int id , String description){
        Reports x = new Reports(id, description);
        if (x.addReportsCust()) {
            System.out.println(x.toString() + "\nAdded Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }
    
    public void addEmpReport(int id , String description){
        Reports x = new Reports(id, description);
        if (x.addReportsEmp()) {
            System.out.println(x.toString() + "\nAdded Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }
    
    public void searchforEmpReport(int id)
    {
        Reports x = new Reports();
        System.out.println(x.searchReportsEmp(id));
    }
    
    public void searchforCustReport(int id)
    {
        Reports x = new Reports();
        System.out.println(x.searchReportsCust(id));
    }
    
    public void displayEmpsReports()
    {
        Reports x = new Reports();
        System.out.println(x.listReportsEmp());
    }
    
    public void displayCustsReports()
    {
        Reports x = new Reports();
        System.out.println(x.listReportsCust());
    }
    
    
    
    public void addNewOffer(int OfferId, String OfferName, String OfferDescription) {
        SpecialOffers x = new SpecialOffers(OfferId, OfferName, OfferDescription);
        if (x.addOffers()) {
            System.out.println(x.toString() + "\nAdded Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }

    public void displayOffers() {
        SpecialOffers x = new SpecialOffers();
        System.out.println(x.displayAllOffers());
    }

    public void searchFofOffer(int id) {
        SpecialOffers x = new SpecialOffers();
        System.out.println(x.searchOffers(id));
    }

    public void updateOffers(int oldID, SpecialOffers newOfferValues) {
        SpecialOffers x = new SpecialOffers();
        if (x.updateOffer(oldID, newOfferValues)) {
            System.out.println(newOfferValues.toString() + "\nUpdated Successfully ... !");
        } else {
            System.out.println("Failed to Updated ... !");
        }
    }

    public void deleteOffer(int Id) {
        SpecialOffers x = new SpecialOffers();
        if (x.deleteOffer(Id)) {
           System.out.println("Offer : "+ Id + "\nDeleted Successfully ... !");
        } else {
            System.out.println("Failed to Deleted ... !");
        }
    }
    
    
    
    
    
   
    public void addRewardProgram(String cobon , String description ){
        RewardProgram x = new RewardProgram(cobon, description);
        if (x.addReward(x)) {
            System.out.println(x.toString() + "\nAdded Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }
    
    
    public void deleteRewardProgram()
    {
        RewardProgram x = new RewardProgram();
        if (x.deleteReward()) {
           System.out.println("Reward \nDeleted Successfully ... !");
           
        } else {
            System.out.println("Failed to Deleted ... !");
        }
    }
    
    
    
    public void showcobon(){
        RewardProgram x = new RewardProgram();
        x = x.loadFromFile();
        System.out.println(x.toString());
    }
    
    
    @Override
    public String toString() {
        return "Admin{" + '}';
    }
    
}