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
public class Order implements Serializable {
    
    protected int customerID;
    protected int orderId; 
    protected String pay_date;
    protected int num_of_meals ; 
    protected double orderPrice ;  
    ArrayList<Meals> customerMeals = new ArrayList<>();

    
    
    FileManager FManager = new FileManager();

    private final String Order_filename = "Orders.bin";
    public static ArrayList<Order> Orders = new ArrayList<Order>();

    public Order() {
    }

    public Order(int customerID, int orderId, String pay_date, int num_of_meals, ArrayList<Integer> arr ) {
        this.customerID = customerID;
        this.orderId = orderId;
        this.pay_date = pay_date;
        this.num_of_meals = num_of_meals;
        
        for (Integer x : arr){
            this.customerMeals.add(new Meals().customerSearchMeals(x));
        }
        this.orderPrice = calculate_price(customerMeals);

        Customer z = new Customer();
        z.searchCustomerOrder(customerID).setPayments(calculate_price(customerMeals));
        z.commitToFile();
        
    }
    
    

    
    
    public static ArrayList<Order> getOrders() {
        return Orders;
    }

    public static void setOrders(ArrayList<Order> Orders) {
        Order.Orders = Orders;
    }

    
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public double getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    
    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public int getNum_of_meals() {
        return num_of_meals;
    }

    public void setNum_of_meals(int num_of_meals) {
        this.num_of_meals = num_of_meals;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public ArrayList<Meals> getCustomerMeals() {
        return customerMeals;
    }

    public void setCustomerMeals(ArrayList<Meals> customerMeals) {
        this.customerMeals = customerMeals;
    }
    
    
    
    
    
    public boolean commitToFile() {
        return FManager.write(Order_filename, Orders);
    }

    public void loadFromFile()
    {
        Orders = (ArrayList<Order>)FManager.read(Order_filename);
    }
    
    
    
    public boolean addorder()
    {
        loadFromFile();
        Orders.add(this);
        return commitToFile();
    }
    
    
    private int OrderIndex(int id) {
        for (int x = 0; x < Orders.size(); x++) {
            if (Orders.get(x).getOrderId() == id) {
                return x;
            }
        }
        return -1;
    }
    
    
    
    public Order searchorder(int id) {
        Order temp = new Order();
        loadFromFile();
        int index = OrderIndex(id);
        if (index != -1) {
            return Orders.get(index);
            //return true;
        } else {
            return temp;
            //return false
        }
    }
    
    
    public boolean deleteOrder(int code) {
        loadFromFile();
        int index = OrderIndex(code);
        
        if (index != -1) {
            Orders.remove(index);

            return commitToFile();
        }
        return false;
    }
    
    
     private ArrayList<Integer> OrderIndexCustomer(int id) {
         ArrayList<Integer> g = new ArrayList<>();
        for (int x = 0; x < Orders.size(); x++) {
            if (Orders.get(x).getCustomerID() == id) {
                g.add(x);
            }
        }
        return g;
    }
    
    
    
    
    
   public ArrayList<Order> searchorderCustomer(int id) {
         ArrayList<Order> g = new ArrayList<>();
        loadFromFile();
        for(Integer x : OrderIndexCustomer(id)){
            g.add(Orders.get(x));
        }
        
        return g ;
       
       /* if (index != -1) {
            return Orders.get(index);
            //return true;
        } else {
            return temp;
            //return false
        }*/
    }
    
    
    
   public double calculate_price(ArrayList<Meals> custMealses)
    {
        double total_price=0;
        for(Meals x : custMealses)
            total_price = x.getMealPrice()+total_price;
        return total_price;
    }

    @Override
    public String toString() {
        return "\n\nCustomerID = " + customerID + "\nOrderId = " + orderId + "\npay_date = " + pay_date + "\nnum_of_meals = " + num_of_meals + "\nOrderPrice = " + orderPrice + "\nCustomerMeals = " + customerMeals ;
    }
    
    
    
   
   
}
