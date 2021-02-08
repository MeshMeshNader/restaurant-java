/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giutestcase;

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
public class MealsAdd extends JPanel implements ActionListener {
    JButton addMealSubmit  , ResetButton;
    JLabel jlAddMeal,jLabelMeal1 ,jLabelMeal2 , jLabelMeal3;
    JTextField jtfMName , jtfMId ,jtfMPrice;
    
    public MealsAdd(){
        setBackground(Color.GRAY);
        //Labels 
        jlAddMeal = new JLabel("Add New Meal ... !");
        jlAddMeal.setFont(new Font("Stencil", 0, 18));
        jlAddMeal.setBounds(40, 30, 240, 19);

        
        jLabelMeal1 = new JLabel("Name ");
        jLabelMeal1.setFont(new Font("Ravie", 0, 13));
        jLabelMeal1.setBounds(90, 180, 120, 30);

        jLabelMeal2 = new JLabel("ID");
        jLabelMeal2.setFont(new Font("Ravie", 0, 13));
        jLabelMeal2.setBounds(90, 230, 120, 30);

        jLabelMeal3 = new JLabel("Price ");
        jLabelMeal3.setFont(new Font("Ravie", 0, 13));
        jLabelMeal3.setBounds(90, 280, 120, 30);

        
        //Fields
        
        
        jtfMName = new JTextField();
        jtfMName.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfMName.setBounds(240, 180, 270, 22);

        jtfMId = new JTextField();
        jtfMId.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfMId.setBounds(240, 230, 270, 22);

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
        }else if(e.getSource() == addMealSubmit){
     
        if(!jtfMId.getText().equals("")&&!jtfMName.getText().equals("")&&!jtfMPrice.getText().equals(""))
            {
                meal.setMealName(jtfMName.getText());
                meal.setMealId(Integer.parseInt(jtfMId.getText()));
                meal.setMealPrice(Double.parseDouble(jtfMPrice.getText()));
                if(meal.addMeal() && jtfMName.getText().equals("")||!jtfMId.getText().equals("")||!jtfMPrice.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Meal Added Successfully!");
                    resetData();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Failed to add Meal!");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Failed to add Meal!.....Please Enter Data!");
            }
        }
        
   
    }
public void resetData(){
        jtfMName.setText("");
        jtfMId.setText("");
        jtfMPrice.setText("");
    }
}

