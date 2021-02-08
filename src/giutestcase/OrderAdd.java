/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giutestcase;

import Resturant.Order;
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
public class OrderAdd extends JPanel implements ActionListener {

    
    
    
    
    
    
    
    
    

  
    
     JLabel jlAddCust, jLabelEmp1, jLabelEmp2, jLabelEmp3, jLabelEmp4, jLabelEmp5, jLabelEmp6, jLabelEmp7, jLabelEmp8;
    JTextField jtfECustId, jtfEOrderId, jtfEPayDate, jtfENOM, jtfEOrdrerPrice;
    //fname , lname , id , age , address , salary , username , password;
  
    JButton addEmpSubmit, ResetButton;
    
    
    
    public OrderAdd() {
        
        setBackground(Color.YELLOW);
        
        jlAddCust = new JLabel("Add New Ordre ... !");
        jlAddCust.setFont(new Font("Stencil", 0, 18));
        jlAddCust.setBounds(40, 30, 240, 19);

        jLabelEmp1 = new JLabel("Customer ID ");
        jLabelEmp1.setFont(new Font("Ravie", 0, 13));
        jLabelEmp1.setBounds(90, 80, 120, 30);

        jLabelEmp2 = new JLabel("Order ID ");
        jLabelEmp2.setFont(new Font("Ravie", 0, 13));
        jLabelEmp2.setBounds(90, 130, 120, 30);

        jLabelEmp3 = new JLabel("pay_date ");
        jLabelEmp3.setFont(new Font("Ravie", 0, 13));
        jLabelEmp3.setBounds(90, 180, 120, 30);

        jLabelEmp4 = new JLabel("Meals ");
        jLabelEmp4.setFont(new Font("Ravie", 0, 13));
        jLabelEmp4.setBounds(90, 230, 120, 30);

        jLabelEmp5 = new JLabel("Order Price ");
        jLabelEmp5.setFont(new Font("Ravie", 0, 13));
        jLabelEmp5.setBounds(90, 280, 120, 30);

       

        
        jtfECustId = new JTextField();
        jtfECustId.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfECustId.setBounds(240, 80, 270, 22);

        jtfEOrderId = new JTextField();
        jtfEOrderId.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfEOrderId.setBounds(240, 130, 270, 22);

        jtfEPayDate = new JTextField();
        jtfEPayDate.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfEPayDate.setBounds(240, 180, 270, 22);

        jtfENOM = new JTextField();
        jtfENOM.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfENOM.setBounds(240, 230, 270, 22);

        jtfEOrdrerPrice = new JTextField();
        jtfEOrdrerPrice.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfEOrdrerPrice.setBounds(240, 280, 270, 22);

        
        
        addEmpSubmit = new JButton("Submit");
        addEmpSubmit.setBounds(260, 485, 220, 30);
        addEmpSubmit.addActionListener(this);

        ResetButton = new JButton("Reset");
        ResetButton.setBounds(535, 530, 100, 23);
        ResetButton.addActionListener(this);

        add(jlAddCust);
        add(jLabelEmp1);
        add(jLabelEmp2);
        add(jLabelEmp3);
        add(jLabelEmp4);
        add(jLabelEmp5);
        add(jtfECustId);
        add(jtfEOrderId);
        add(jtfEPayDate);
        add(jtfENOM);
        add(jtfEOrdrerPrice);
        add(ResetButton);
        add(addEmpSubmit);
        setVisible(true);
    
    
    
    }

    
    
  
    @Override
    public void actionPerformed(ActionEvent e) {
        Order neworder = new Order();
         
        if (e.getSource() == ResetButton) {
           resetData();
        } else if (e.getSource() == addEmpSubmit) {

            if (!jtfECustId.getText().equals("") && !jtfEOrderId.getText().equals("") && !jtfEPayDate.getText().equals("") && !jtfENOM.getText().equals("")
                    && !jtfEOrdrerPrice.getText().equals("") ) {
               try{
                
                neworder.setOrderPrice(Double.parseDouble(jtfEOrdrerPrice.getText()));
                neworder.setNum_of_meals(Integer.parseInt(jtfENOM.getText()));
                neworder.setCustomerID(Integer.parseInt(jtfECustId.getText()));
                neworder.setOrderId(Integer.parseInt(jtfEOrderId.getText()));
                neworder.setPay_date(jtfEPayDate.getText());
               
                  if (neworder.addorder()&& !jtfEOrdrerPrice.getText().equals("") 
                        || !jtfENOM.getText().equals("") || !jtfECustId.getText().equals("") || !jtfEOrderId.getText().equals("") || !jtfEPayDate.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Order Added Successfully!");
                    resetData();
            }
                }catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, "Failed to add Order !");
                }
                
               
            }else {
                JOptionPane.showMessageDialog(null, "Please Enter Data!");
        }
        
        }

    }

public void resetData(){
            jtfECustId.setText("");
            jtfEOrderId.setText("");
            jtfEPayDate.setText("");
            jtfENOM.setText("");
            jtfEOrdrerPrice.setText("");
           
            
        }
}