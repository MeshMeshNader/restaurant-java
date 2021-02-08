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
public class CancelOrder extends JPanel implements ActionListener{

       JLabel jlAddCust, jLabelEmp1, jLabelEmp2, jLabelEmp3, jLabelEmp4, jLabelEmp5, jLabelEmp6, jLabelEmp7, jLabelEmp8;
    JTextField jtfECustId, jtfEOrderId, jtfEPayDate, jtfENOM, jtfEOrdrerPrice;
    //fname , lname , id , age , address , salary , username , password;
  
    JButton addEmpSubmit, ResetButton;
    
    
    
    
    public CancelOrder() {
     setBackground(Color.GREEN);
        
        jlAddCust = new JLabel("Delete Ordre ... !");
        jlAddCust.setFont(new Font("Stencil", 0, 18));
        jlAddCust.setBounds(40, 30, 240, 19);

        jLabelEmp1 = new JLabel("Order ID ");
        jLabelEmp1.setFont(new Font("Ravie", 0, 13));
        jLabelEmp1.setBounds(90, 80, 120, 30);

       

       

        
        jtfECustId = new JTextField();
        jtfECustId.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfECustId.setBounds(240, 80, 270, 22);

        
        
        
        addEmpSubmit = new JButton("Delete");
        addEmpSubmit.setBounds(260, 485, 220, 30);
        addEmpSubmit.addActionListener(this);

        ResetButton = new JButton("Reset");
        ResetButton.setBounds(535, 530, 100, 23);
        ResetButton.addActionListener(this);

        add(jlAddCust);
       
        add(jtfECustId);
        
        add(ResetButton);
        add(addEmpSubmit);
        setVisible(true);
    
    
    
    }

    
    
  
    @Override
    public void actionPerformed(ActionEvent e) {
        
         
        if (e.getSource() == ResetButton) {
           resetData();
        } else if(e.getSource()== addEmpSubmit){
            
            if(!jtfECustId.getText().equals(""))
        {   
            Order neworder = new Order();
            if (neworder.deleteOrder(Integer.parseInt(jtfECustId.getText())))     
            {
                JOptionPane.showMessageDialog(null, "Order Deleted Successfully!");
                resetData();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Failed to Delete Order!");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null ,"Missing required Fields ... !  Please, Search By ID ...");
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