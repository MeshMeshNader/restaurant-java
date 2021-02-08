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
public class Meals implements Serializable{

    protected String mealName;
    protected int mealId;
    protected double mealPrice;
    private final String mealsFileName = "Meals.bin";
    FileManager FManager = new FileManager();
    public static ArrayList<Meals> Mealss = new ArrayList<Meals>();
    
    public Meals() {
    }

    public Meals(String mealName, int mealId, double mealPrice) {
        this.mealName = mealName;
        this.mealId = mealId;
        this.mealPrice = mealPrice;
    }

    
    
    
    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public double getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(double mealPrice) {
        this.mealPrice = mealPrice;
    }

    
    public boolean addMeal() {
        loadFromFile();
        Mealss.add(this);
        return commitToFile();
    }

    public boolean commitToFile() {
        return FManager.write(mealsFileName, Mealss);
    }
    
    public ArrayList<Meals> loadFromFileArr() {
        Mealss = (ArrayList<Meals>) FManager.read(mealsFileName);
        return Mealss;
    }

    public void loadFromFile() {
        Mealss = (ArrayList<Meals>) FManager.read(mealsFileName);
    }

    private int getMealIndex(int id) {
        for (int i = 0; i < Mealss.size(); i++) {
            if (Mealss.get(i).getMealId() == id) {
                return i;
            }
        }

        return -1;
    }

    public String displayAllMeals() {
        loadFromFile();
        String S = "\nAll Meals Data:\n";
        for (Meals x : Mealss) {
            S = S + x.toString();
        }
        return S;
    }

    public String searchMeal(int id) {
        loadFromFile();
        int index = getMealIndex(id);
        if (index != -1) {
            return "\nFound ...!" + Mealss.get(index).toString();
        } else {
            return "\nNot Found ...!";
        }
    }
    
    public Meals customerSearchMeals(int id) {
        Meals temp = new Meals();
        loadFromFile();
        int index = getMealIndex(id);
        if (index != -1) {
            return Mealss.get(index);
        } 
        else {
            return temp;
        }
    }
    
    
    public boolean updateMeal(int oldID, Meals x) {
        loadFromFile();
        int index = getMealIndex(oldID);

        if (index != -1) {
            Mealss.set(index, x);

            return commitToFile();
        }

        return false;
    }

    public boolean deleteMeal(int id) {
        loadFromFile();
        int index = getMealIndex(id);

        if (index != -1) {
            Mealss.remove(index);

            return commitToFile();
        }

        return false;
    }

    @Override
    public String toString() {
        return "\n\nMeal ID : "  + mealId +  "\nMeal Name :" + mealName + "\nMeal Price = " + mealPrice ;
    }

   
    
    

}
