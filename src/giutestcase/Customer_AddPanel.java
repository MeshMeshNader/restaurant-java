/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giutestcase;

import Resturant.Customer;
import Resturant.Employee;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author meshm
 */
public class Customer_AddPanel extends JPanel implements ActionListener{

    
     JLabel jlAddCust, jLabelEmp1, jLabelEmp2, jLabelEmp3, jLabelEmp4, jLabelEmp5, jLabelEmp6, jLabelEmp7, jLabelEmp8;
    JTextField jtfEFname, jtfELname, jtfEId, jtfEAge, jtfEAddress, jtfEReward, jtfEGifts;
    //fname , lname , id , age , address , salary , username , password;
    JPasswordField jEPasswordField;
    JButton addEmpSubmit, ResetButton;
    
    
    
    public Customer_AddPanel() {
        jlAddCust = new JLabel("Add New Customer ... !");
        jlAddCust.setFont(new Font("Stencil", 0, 18));
        jlAddCust.setBounds(40, 30, 240, 19);

        jLabelEmp1 = new JLabel("First Name ");
        jLabelEmp1.setFont(new Font("Ravie", 0, 13));
        jLabelEmp1.setBounds(90, 80, 120, 30);

        jLabelEmp2 = new JLabel("Last Name ");
        jLabelEmp2.setFont(new Font("Ravie", 0, 13));
        jLabelEmp2.setBounds(90, 130, 120, 30);

        jLabelEmp3 = new JLabel("ID ");
        jLabelEmp3.setFont(new Font("Ravie", 0, 13));
        jLabelEmp3.setBounds(90, 180, 120, 30);

        jLabelEmp4 = new JLabel("Age ");
        jLabelEmp4.setFont(new Font("Ravie", 0, 13));
        jLabelEmp4.setBounds(90, 230, 120, 30);

        jLabelEmp5 = new JLabel("Address ");
        jLabelEmp5.setFont(new Font("Ravie", 0, 13));
        jLabelEmp5.setBounds(90, 280, 120, 30);

        jLabelEmp6 = new JLabel("Join RD ? (t)(f) ");
        jLabelEmp6.setFont(new Font("Ravie", 0, 13));
        jLabelEmp6.setBounds(90, 330, 140, 30);

        jLabelEmp7 = new JLabel("Has Gifts ? ");
        jLabelEmp7.setFont(new Font("Ravie", 0, 13));
        jLabelEmp7.setBounds(90, 380, 120, 30);

        
        jtfEFname = new JTextField();
        jtfEFname.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfEFname.setBounds(240, 80, 270, 22);

        jtfELname = new JTextField();
        jtfELname.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfELname.setBounds(240, 130, 270, 22);

        jtfEId = new JTextField();
        jtfEId.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfEId.setBounds(240, 180, 270, 22);

        jtfEAge = new JTextField();
        jtfEAge.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfEAge.setBounds(240, 230, 270, 22);

        jtfEAddress = new JTextField();
        jtfEAddress.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfEAddress.setBounds(240, 280, 270, 22);

        jtfEReward = new JTextField();
        jtfEReward.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfEReward.setBounds(240, 330, 270, 22);

        jtfEGifts = new JTextField();
        jtfEGifts.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfEGifts.setBounds(240, 380, 270, 22);

    
        
        
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
        add(jLabelEmp6);
        add(jLabelEmp7);
        add(jtfEFname);
        add(jtfELname);
        add(jtfEId);
        add(jtfEAge);
        add(jtfEAddress);
        add(jtfEReward);
        add(jtfEGifts);
        add(ResetButton);
        add(addEmpSubmit);
        setVisible(true);
    
    
    
    }

    
    
  
    @Override
    public void actionPerformed(ActionEvent e) {
        Customer newcust = new Customer();
         
        if (e.getSource() == ResetButton) {
           resetData();
        } else if (e.getSource() == addEmpSubmit) {

            if (!jtfEFname.getText().equals("") && !jtfELname.getText().equals("") && !jtfEId.getText().equals("") && !jtfEAge.getText().equals("")
                    && !jtfEAddress.getText().equals("") && !jtfEReward.getText().equals("") && !jtfEGifts.getText().equals("") ) {
               try{
               newcust.setGifts(jtfEGifts.getText());
                newcust.setAddress(jtfEAddress.getText());
                newcust.setAge(Integer.parseInt(jtfEAge.getText()));
                newcust.setfName(jtfEFname.getText());
                newcust.setlName(jtfELname.getText());
                newcust.setRewardProgram(Boolean.parseBoolean(jtfEReward.getText()));
                
                  if (newcust.addCustomer() && !jtfEAddress.getText().equals("") || !jtfEGifts.getText().equals("")
                        || !jtfEAge.getText().equals("") || !jtfEFname.getText().equals("") || !jtfELname.getText().equals("") || !jtfEReward.getText().equals("") || !jtfEId.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Customer Added Successfully!");
                    resetData();
            }
                }catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage() + "  Failed to add Customer!");
                }
                
               
            }else {
                JOptionPane.showMessageDialog(null, "Please Enter Data!");
        }
        
        }

    }

public void resetData(){
            jtfEFname.setText("");
            jtfELname.setText("");
            jtfEId.setText("");
            jtfEAge.setText("");
            jtfEAddress.setText("");
            jtfEReward.setText("");
            jtfEGifts.setText("");
            jEPasswordField.setText("");
        }
}