/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resturant;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author meshm
 */
public class Resutrant_Final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String projectPath = System.getProperty("user.dir");
        System.out.println("Project Path: " + projectPath);
        File currentDir = new File(projectPath); // current directory				
        checkDirectoryContents(currentDir);

        Scanner input = new Scanner(System.in);

        Admin admin = new Admin();

        Employee employee = new Employee();

        int ch = 1;

        
        String userName, Pass, Fname, Lname, address, mealName, Gifts, offerName, offerDescription;
        String description = new String();
        int id, age, oldID, numOfOrder, Payments, custmerID, flag, logout = 0;
        boolean rewardProgram;
        double salary, mealPrice;
        int orderID, num_of_meals;
        ArrayList<Integer> mealsIDs = new ArrayList<Integer>();
        String pay_date;
        
        

        do {
            
            logout = 0;
            System.out.println("Choose [1] for Admin [2] For Employees [0] to Exit");
            flag = input.nextInt();

            if (flag == 1) {

                System.out.print("\n\nWelecome Admin ... !\n\nUser Name : ");

                userName = input.next();

                System.out.print("Password  : ");

                Pass = input.next();
                if (admin.loginAsadmin(userName, Pass)) {
                    ch = 1;
                    while (ch != 0) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("\n\t ________________________________\n\t"
                                + "| Enter 1: Add New Emplyee.     \n\t| Enter 2: Add New Meal.   \n\t| Enter 3: Display All Employee.   \n\t| Enter 4: Display All Meals.    \n\t| Enter 5: Search Employees.  "
                                + "\n\t| Enter 6: Search Meals .|\n\t| Enter 7: Update Employee .  \n\t| Enter 8: Update Meal.  \n\t| Enter 9: Delete Employee. \n\t| Enter 10: Delete Meal. "
                                + "\n\t| Enter 11: Make Report about Customer.     \n\t| Enter 12: Make Report About Employee.   \n\t| Enter 13: Display All Customers Reports.  \n\t| Enter 14: Display All Employees Reports.  "
                                + "\n\t| Enter 15: Search For Cutomer Report. \n\t| Enter 16: Search For Employee Report.  \n\t| Enter 17: Add Special Offer.  \n\t| Enter 18: Display All Special Offers.  \n\t| Enter 19: Delete Special Offer.  "
                                + "\n\t| Enter 20: Update Special Offer. \n\t| Enter 21: Add Reward . \n\t| Enter 22: Remove Reward. \n\t| Enter 23: Display Reward. \n\t| Enter 24: Employee Profile.  \n\t| Enter 25: Alter Your Data. \n\t| Enter 0: To LogOut.  "
                                + "\n\t -------------------------------\n\t");
                        ch = input.nextInt();

                        switch (ch) {
                            case 1:

                                //String userName, String passWord, int id, String fName, String lName, String address, int age, double salary
                                System.out.println("Enter Emp Info ... ");
                                System.out.print("Emp First Name : ");
                                Fname = input.next();
                                System.out.print("Emp Last Name : ");
                                Lname = input.next();
                                System.out.print("Emp ID : ");
                                id = input.nextInt();
                                System.out.print("Emp Age : ");
                                age = input.nextInt();
                                System.out.print("Emp Address : ");
                                address = input.next();
                                System.out.print("Emp Salary : ");
                                salary = input.nextDouble();
                                System.out.print("Username : ");
                                userName = input.next();
                                System.out.print("Password : ");
                                Pass = input.next();

                                admin.addNewEmployee(userName, Pass, id, Fname, Lname, address, age, salary);

                                break;

                            case 2:

                                //String mealName, int mealId, double mealPrice
                                System.out.println("Enter Meal Info ... ");
                                System.out.print("Meal Name : ");
                                mealName = input.next();
                                System.out.print("Meal ID : ");
                                id = input.nextInt();
                                System.out.print("Meal Price : ");
                                mealPrice = input.nextDouble();

                                admin.addNewMeal(mealName, id, mealPrice);

                                break;

                            case 3:

                                admin.displayEmployees();

                                break;

                            case 4:

                                admin.displayMeal();

                                break;
                            case 5:

                                System.out.print("\nSearch for Emp ...!\nEnter Emp ID : ");
                                id = input.nextInt();
                                admin.searchForEmployee(id);

                                break;
                            case 6:

                                System.out.print("\nSearch for Meal ...!\nEnter Meal ID : ");
                                id = input.nextInt();
                                admin.searchForMeal(id);

                                break;

                            case 7:

                                System.out.print("\nUpdate Emp info ...!\nEnter Emp OldID : ");
                                oldID = input.nextInt();
                                System.out.println("Enter Emp Info ... ");
                                System.out.print("Emp First Name : ");
                                Fname = input.next();
                                System.out.print("Emp Last Name : ");
                                Lname = input.next();
                                System.out.print("Emp Age : ");
                                age = input.nextInt();
                                System.out.print("Emp Address : ");
                                address = input.next();
                                System.out.print("Emp Salary : ");
                                salary = input.nextDouble();
                                System.out.print("Username : ");
                                userName = input.next();
                                System.out.print("Password : ");
                                Pass = input.next();

                                Employee w = new Employee(userName, Pass, oldID, Fname, Lname, address, age, salary);
                                admin.updateEmployee(oldID, w);

                                break;

                            case 8:

                                System.out.print("\nUpdate Meal info ...!\nEnter Meal OldID : ");
                                oldID = input.nextInt();
                                System.out.println("Enter Meal Info ... ");
                                System.out.print("Meal Name : ");
                                mealName = input.next();
                                System.out.print("Meal ID : ");
                                id = input.nextInt();
                                System.out.print("Meal Price : ");
                                mealPrice = input.nextDouble();

                                Meals x = new Meals(mealName, id, mealPrice);

                                admin.updateMeal(oldID, x);

                                break;

                            case 9:

                                System.out.print("\nDelete Emp info ...!\nEnter Emp ID : ");
                                id = input.nextInt();
                                admin.deleteEmployee(id);

                                break;

                            case 10:

                                System.out.print("\nDelete Meal info ...!\nEnter Meal ID : ");
                                id = input.nextInt();
                                admin.deleteMeal(id);

                                break;
                            case 11:

                                System.out.print("\nMake Report about Customer ...!\nEnter Customer ID : ");
                                id = input.nextInt();
                                System.out.println("Write The Report : ");
                                description = input.next();

                                admin.addCustReport(id, description);

                                break;
                            case 12:

                                
                                System.out.print("\nMake Report about Employee ...!\nEnter Employee ID : ");
                                id = input.nextInt();
                                System.out.println("Write The Report : ");
                                description = input.next();
                                
                                

                                admin.addEmpReport(id, description);

                                break;
                            case 13:

                                admin.displayCustsReports();

                                break;

                            case 14:

                                admin.displayEmpsReports();

                                break;

                            case 15:

                                System.out.print("\nSearch for Customer Report  ...!\nEnter Customer ID : ");
                                id = input.nextInt();
                                admin.searchforCustReport(id);

                                break;
                            case 16:

                                System.out.print("\nSearch for Employee Report  ...!\nEnter Employee ID : ");
                                id = input.nextInt();
                                admin.searchforEmpReport(id);

                                break;

                            case 17:
                                //int OfferId, String OfferName, String OfferDescription
                                System.out.println("Enter Offer Info ... ");
                                System.out.print("Offer Name : ");
                                offerName = input.next();
                                System.out.print("Offer ID : ");
                                id = input.nextInt();
                                System.out.print("Offer OfferDescription : ");
                                offerDescription = input.next();

                                admin.addNewOffer(id, offerName, offerDescription);

                                break;
                            case 18:

                                admin.displayOffers();

                                break;

                            case 19:

                                System.out.print("\nDelete Offer info ...!\nEnter Offer ID : ");
                                id = input.nextInt();
                                admin.deleteOffer(id);

                                break;
                            case 20:

                                System.out.print("\nUpdate Offer info ...!\nEnter Offer OldID : ");
                                oldID = input.nextInt();
                                System.out.println("Enter Offer Info ... ");
                                System.out.print("Offer Name : ");
                                offerName = input.next();
                                System.out.print("Offer ID : ");
                                id = input.nextInt();
                                System.out.print("Offer OfferDescription : ");
                                offerDescription = input.next();

                                SpecialOffers l = new SpecialOffers(id, offerName, offerDescription);

                                admin.updateOffers(oldID, l);

                                break;
                                
                                
                                
                            case 21 :
                                
                                System.out.println("Enter Cobon Name : ");
                                offerName = input.next();
                                System.out.println("Enter The Description : ");
                                description = input.next();
                                
                                admin.addRewardProgram(offerName, description);
                                
                                break ;
                                
                            case 22 :
                                
                                
                                admin.deleteRewardProgram();
                                System.out.println("Reward Program in Deleted.. !");
                               
                                break;
                                
                                
                            case 23:
                                
                                admin.showcobon();
                                
                                break;

                            case 24:
                                System.out.println("Enter the Employee id to get Profile");
                                id = input.nextInt();
                                admin.profileForEmployee(id);

                                break;

                            case 25:

                                //String userName, String passWord, int id, String fName, String lName, String address, int age
                                System.out.println("Welcome Admin .. Enter Your New Data");
                                System.out.print("Admin First Name : ");
                                Fname = input.next();
                                System.out.print("Admin Last Name : ");
                                Lname = input.next();
                                System.out.print("Admin Age : ");
                                age = input.nextInt();
                                System.out.print("Admin Address : ");
                                address = input.next();
                                System.out.print("Username : ");
                                userName = input.next();
                                System.out.print("Password : ");
                                Pass = input.next();

                                Admin o = new Admin(userName, Pass, 1, Fname, Lname, address, age);
                                o.commetToFile(o);

                                break;

                            case 0:
                                logout = 1;
                                break;

                            default:
                                System.out.println("Enter vaild Option :(");

                        }
                    }

                } else {
                    System.out.println("Your UserNAme or Password or both are incorrect");
                }

                ch = 1;
            } else if (flag == 2) {

                System.out.print("\n\nWelecome Emplyee ... !\n\nUser Name : ");
                userName = input.next();
                System.out.print("Password  : ");
                Pass = input.next();

                if (employee.loginAsEmployee(userName, Pass)) {
                     ch = 1 ;
                    while (ch != 0) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("\n\t ________________________________\n\t"
                                + "| Enter 1: Add New Customer.     \n\t| Enter 2: Delete Customer.   \n\t| Enter 3: Update Customer.   \n\t| Enter 4: Search Customer.    \n\t| Enter 5: Display All Customers.  "
                                + "\n\t| Enter 6: Make Order. \n\t| Enter 7: Cancel Order.  \n\t| Enter 8: Print Billing.  \n\t| Enter 9: Customer Profile. \n\t| Enter 10: Update Your Data. \n\t| Enter 0: To LogOut. "
                                + "\n\t -------------------------------\n\t");
                        ch = input.nextInt();

                        switch (ch) {
                            case 1:

                                System.out.println("Enter Cust Info ... ");
                                System.out.print("Cust First Name : ");
                                Fname = input.next();
                                System.out.print("Cust Last Name : ");
                                Lname = input.next();
                                System.out.print("Cust ID : ");
                                id = input.nextInt();
                                System.out.print("Cust Age : ");
                                age = input.nextInt();
                                System.out.print("Cust Address : ");
                                address = input.next();
                                System.out.println("Join To Reward Program (true) or (false) : ");
                                rewardProgram = input.nextBoolean();
                                System.out.println("Has Gifts ? : ");
                                Gifts = input.next();

                                Order O = new Order();
                                employee.addNewCustomer(id, Fname, Lname, address, age, rewardProgram, Gifts, O);

                                break;

                            case 2:

                                System.out.print("\nDelete Customer info ...!\nEnter Customer ID : ");
                                id = input.nextInt();
                                employee.deleteCustomer(id);

                                break;

                            case 3:

                                System.out.print("\nUpdate Customer info ...!\nEnter Customer OldID : ");
                                oldID = input.nextInt();
                                System.out.println("Enter Customer Info ... ");
                                System.out.print("Cust First Name : ");
                                Fname = input.next();
                                System.out.print("Cust Last Name : ");
                                Lname = input.next();
                                System.out.print("Cust ID : ");
                                id = input.nextInt();
                                System.out.print("Cust Age : ");
                                age = input.nextInt();
                                System.out.print("Cust Address : ");
                                address = input.next();
                                System.out.println("Join To Reward Program (true) or (false) : ");
                                rewardProgram = input.nextBoolean();
                                System.out.println("Has Gifts ? : ");
                                Gifts = input.next();

                                Order R = new Order();
                                Customer z = new Customer(rewardProgram, Gifts, id, Fname, Lname, address, age);
                                employee.updateCustomer(oldID, z);

                                break;

                            case 4:

                                System.out.print("\nSearch for Customer ...!\nEnter Customer ID : ");
                                id = input.nextInt();
                                employee.searchForCustomer(id);

                                break;
                            case 5:

                                employee.displayCustomer();

                                break;
                            case 6:

                                // add Order int custmerID, int orderID, String  pay_date , int num_of_meals ,ArrayList<Integer> mealsIDs
                                System.out.println("Enter Order Info ...  : ");
                                System.out.println("Customer ID");
                                custmerID = input.nextInt();
                                System.out.print("Order ID : ");
                                orderID = input.nextInt();
                                System.out.print("Pay Date : ");
                                pay_date = input.next();
                                System.out.print("Number Of Meals : ");
                                num_of_meals = input.nextInt();
                                System.out.print("Meals IDs : ");
                                for (int i = 0; i < num_of_meals; i++) {
                                    mealsIDs.add(input.nextInt());
                                }

                                employee.addNewOrder(custmerID, orderID, pay_date, num_of_meals, mealsIDs);

                                break;

                            case 7:

                                System.out.print("\nDelete Order  ...!\nEnter ID ID : ");
                                id = input.nextInt();
                                employee.deleteCustomerOrder(id);

                                break;

                            case 8:

                                //String billDate, double billId
                                System.out.println("Enter Billing Info ...  : ");
                                System.out.println("Order ID");
                                orderID = input.nextInt();

                                employee.PrintBill(orderID);

                                break;

                            case 9:

                                System.out.println("Show Customer Profile .. \nEnter Customer ID : ");
                                id = input.nextInt();
                                employee.customerProfileLoader(id);

                                break;

                            case 10:

                                Employee o = new Employee();
                                System.out.println("Enter Your ID : ");
                                id = input.nextInt();
                                System.out.print("Old Username : ");
                                userName = input.next();
                                System.out.print("Old Password : ");
                                Pass = input.next();

                                if (o.checkEmpAlter(userName, Pass, id)) {
                                    System.out.println("Welcome Employee .. Enter Your New Data");
                                    System.out.print("First Name : ");
                                    Fname = input.next();
                                    System.out.print("Last Name : ");
                                    Lname = input.next();
                                    System.out.print("Age : ");
                                    age = input.nextInt();
                                    System.out.print("Address : ");
                                    address = input.next();
                                    System.out.print("New Username : ");
                                    userName = input.next();
                                    System.out.print("New Password : ");
                                    Pass = input.next();

                                    Employee n = new Employee(userName, Pass, id, Fname, Lname, address, age);
                                    o.updateEmployee(id, n);

                                } else {
                                    System.out.println("This is not your id");
                                }

                                break;

                            case 0:
                                logout = 1;
                                break;

                            default:
                                System.out.println("Enter vaild Option :(");

                        }
                    }
                } else {
                    System.out.println("Your UserNAme or Password or both are incorrect");
                }

            }else 
                break;

        } while (logout == 1);

    }

    public static void checkDirectoryContents(File dir) {
        File[] files = dir.listFiles();
        boolean mealFile = true;
        boolean reportEmpFile = true;
        boolean reportCustFile = true;
        boolean EmpFile = true;
        boolean CustFile = true;
        boolean AdminFile = true;
        boolean orderFile = true;
        boolean billingFile = true;
        boolean offersFile = true;
        boolean rewardprgram = true ;

        for (File file : files) {

            if (file.getName().contains("Meals.bin")) {
                mealFile = false;
            } else if (file.getName().contains("ReportsEmployee.bin")) {
                reportEmpFile = false;
            } else if (file.getName().contains("ReportsCustomers.bin")) {
                reportCustFile = false;
            } else if (file.getName().contains("Employee.bin")) {
                EmpFile = false;
            } else if (file.getName().contains("Customer.bin")) {
                CustFile = false;
            } else if (file.getName().contains("Admin.bin")) {
                AdminFile = false;
            } else if (file.getName().contains("Orders.bin")) {
                orderFile = false;
            } else if (file.getName().contains("Biling.bin")) {
                billingFile = false;
            } else if (file.getName().contains("SpecialOffers.bin")) {
                offersFile = false;
            } else if (file.getName().contains("Rewards.bin")) {
                rewardprgram = false;
            }
        }
        if (mealFile) {
            Meals x = new Meals();
            x.commitToFile();
        }

        if (offersFile) {
            SpecialOffers x = new SpecialOffers();
            x.commitToFile();
        }

        if (AdminFile) {
            Admin x = new Admin("Admin@yahoo.com", "12345678", 1, "admin", "admin", "haha", 20);
            x.commetToFile(x);
        }

        if (reportCustFile) {
            Reports x = new Reports();
            x.commitToFilecust();
        }

        if (orderFile) {
            Order x = new Order();
            x.commitToFile();
        }

        if (reportEmpFile) {
            Reports x = new Reports();
            x.commitToFileEmp();
        }

        if (rewardprgram) {
            RewardProgram x = new RewardProgram();
            x.commitToFile(x);
        }
        
        if (billingFile) {
            Billing x = new Billing();
            x.commitToFile();
        }

        if (EmpFile) {
            Employee x = new Employee("Employee@yahoo.com", "12345678", 1, "employee", "employee", "haha", 20);
            x.commitToFileFirst(x);
        }

        if (CustFile) {
            Customer x = new Customer();
            x.commitToFile();
        }
    }

}
