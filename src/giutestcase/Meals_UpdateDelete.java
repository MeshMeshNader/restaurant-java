/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giutestcase;

import Resturant.Employee;
import Resturant.Meals;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author meshm
 */
public class Meals_UpdateDelete extends JPanel implements ActionListener{
     JButton addMealSubmit  , ResetButton , Searchbtn ,Deletebtn;
    JLabel jlAddMeal,jLabelMeal1 ,jLabelMeal2 , jLabelMeal3;
    JTextField jtfMName , jtfMId ,jtfMPrice;

    public Meals_UpdateDelete() {
        setBackground(Color.GREEN);
        setLayout(null);
        //Labels 
        jlAddMeal = new JLabel("Update and Delete Meal ... !");
        jlAddMeal.setFont(new Font("Stencil", 0, 18));
        jlAddMeal.setBounds(40, 30, 350, 19);

        
        jLabelMeal1 = new JLabel("Name ");
        jLabelMeal1.setFont(new Font("Ravie", 0, 13));
        jLabelMeal1.setBounds(90, 230, 120, 30);

        jLabelMeal2 = new JLabel("ID");
        jLabelMeal2.setFont(new Font("Ravie", 0, 13));
        jLabelMeal2.setBounds(90, 180, 120, 30);

        jLabelMeal3 = new JLabel("Price ");
        jLabelMeal3.setFont(new Font("Ravie", 0, 13));
        jLabelMeal3.setBounds(90, 280, 120, 30);

        
        //Fields
        
        
        jtfMName = new JTextField();
        jtfMName.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfMName.setBounds(240, 230, 270, 22);

        jtfMId = new JTextField();
        jtfMId.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfMId.setBounds(240, 180, 120, 22);

        jtfMPrice = new JTextField();
        jtfMPrice.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfMPrice.setBounds(240, 280, 270, 22);

        
        //Buttons
        addMealSubmit = new JButton("Submit");
        addMealSubmit.setBounds(260, 485, 220, 30);
        addMealSubmit.addActionListener(this);
        
        ResetButton = new JButton("Reset");
        ResetButton.setBounds(535, 530, 100, 23);
        ResetButton.addActionListener(this);
        
        
        Searchbtn = new JButton("Search");
        Searchbtn.setBounds(480, 180, 80, 23);
        Searchbtn.addActionListener(this);
        
        Deletebtn = new JButton("Delete");
        Deletebtn.setBounds(380, 180, 80, 23);
        Deletebtn.addActionListener(this);

        
        add(Deletebtn);
        add(Searchbtn);
        add(jlAddMeal);
        add(jLabelMeal1);
        add(jLabelMeal2);
        add(jLabelMeal3);
        add(jtfMId);
        add(jtfMName);
        add(jtfMPrice);
        add(ResetButton);
        add(addMealSubmit);
        
    }

    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Meals meal = new Meals();
        if (e.getSource() == ResetButton) {
           resetData();
        }else if (e.getSource() == addMealSubmit) {

            if (!jtfMId.getText().equals("") && !jtfMName.getText().equals("") && !jtfMPrice.getText().equals("")) {
               try{
                meal.setMealId(Integer.parseInt(jtfMId.getText()));
                meal.setMealName(jtfMName.getText());
                meal.setMealPrice(Double.parseDouble(jtfMPrice.getText()));
                
                
                  if (meal.updateMeal(Integer.parseInt(jtfMId.getText()), meal) && !jtfMId.getText().equals("") || !jtfMName.getText().equals("") || !jtfMPrice.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Meal Added Successfully!");
                    resetData();
            }
                }catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, "Failed to Update Meal!");
                }
                
               
            }else {
                JOptionPane.showMessageDialog(null, "Please Enter Data!");
        }
        
        }else if(e.getSource()== Deletebtn){
            
            if(!jtfMId.getText().equals(""))
        {   
            Meals meal2 = new Meals();
            if (meal2.deleteMeal(Integer.parseInt(jtfMId.getText())))     
            {
                JOptionPane.showMessageDialog(null, "Meal Deleted Successfully!");
                resetData();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Failed to Delete Meal!");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null ,"Missing required Fields ... !  Please, Search By ID ...");
        }
         
         }else if(e.getSource()==Searchbtn){
             
             if(!jtfMId.getText().equals(""))
        {   
             Meals meal3 = new Meals();
            Meals returned = meal3.customerSearchMeals(Integer.parseInt(jtfMId.getText()));
            if (Integer.parseInt(jtfMId.getText())>0)
            {
                JOptionPane.showMessageDialog(null, "Found .. !");
                setPanelData(returned);
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(null ,"Missing required Fields ... !  Please, Search By ID ...");
        }
             
         }
        
        
    }
    
    
    public void resetData(){
        jtfMName.setText("");
        jtfMId.setText("");
        jtfMPrice.setText("");
    }
         public void setPanelData(Meals mm)
    {
        jtfMId.setText(""+mm.getMealId());
        jtfMName.setText(""+mm.getMealName());
        jtfMPrice.setText(""+mm.getMealPrice());
        
    }
    
    
}
