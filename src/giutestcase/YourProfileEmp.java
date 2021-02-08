/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giutestcase;

import Resturant.Admin;
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
public class YourProfileEmp extends JPanel implements ActionListener{

    
    JLabel jlAddCust, jLabelEmp1, jLabelEmp2, jLabelEmp3, jLabelEmp4, jLabelEmp5 ,jLabelEmp6;
    JTextField jtfEFname, jtfELname, jtfEAgee, jtfEAddresss , jtfEUserName;
    JPasswordField jEPasswordField;
    JButton updateAdminSubmit, ResetButton , ShowData , LogOut;
  
    public YourProfileEmp() {
    
        jlAddCust = new JLabel("Update Your Data ... !");
        jlAddCust.setFont(new Font("Stencil", 0, 18));
        jlAddCust.setBounds(40, 30, 240, 19);

        jLabelEmp1 = new JLabel("First Name ");
        jLabelEmp1.setFont(new Font("Ravie", 0, 13));
        jLabelEmp1.setBounds(90, 80, 120, 30);

        jLabelEmp2 = new JLabel("Last Name ");
        jLabelEmp2.setFont(new Font("Ravie", 0, 13));
        jLabelEmp2.setBounds(90, 130, 120, 30);

        jLabelEmp3 = new JLabel("Age ");
        jLabelEmp3.setFont(new Font("Ravie", 0, 13));
        jLabelEmp3.setBounds(90, 180, 120, 30);

        jLabelEmp4 = new JLabel("Address ");
        jLabelEmp4.setFont(new Font("Ravie", 0, 13));
        jLabelEmp4.setBounds(90, 230, 120, 30);

        jLabelEmp5 = new JLabel("UserName  ");
        jLabelEmp5.setFont(new Font("Ravie", 0, 13));
        jLabelEmp5.setBounds(90, 280, 120, 30);

        jLabelEmp6 = new JLabel("Password ");
        jLabelEmp6.setFont(new Font("Ravie", 0, 13));
        jLabelEmp6.setBounds(90, 330, 140, 30);
        
        
        jtfEFname = new JTextField();
        jtfEFname.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfEFname.setBounds(240, 80, 270, 22);

        jtfELname = new JTextField();
        jtfELname.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfELname.setBounds(240, 130, 270, 22);

        jtfEAgee = new JTextField();
        jtfEAgee.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfEAgee.setBounds(240, 180, 270, 22);

        jtfEAddresss = new JTextField();
        jtfEAddresss.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfEAddresss.setBounds(240, 230, 270, 22);

        jtfEUserName = new JTextField();
        jtfEUserName.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfEUserName.setBounds(240, 280, 270, 22);

        jEPasswordField = new JPasswordField();
        jEPasswordField.setBounds(240, 330, 270, 22);

        
         updateAdminSubmit = new JButton("Update");
        updateAdminSubmit.setBounds(260, 485, 220, 30);
        updateAdminSubmit.addActionListener(this);

        ResetButton = new JButton("Reset");
        ResetButton.setBounds(535, 530, 100, 23);
        ResetButton.addActionListener(this);
        
        ShowData = new JButton("Show Data");
        ShowData.setBounds(650, 530, 100, 23);
        ShowData.addActionListener(this);
        
        LogOut = new JButton("LogOut");
        LogOut.setBounds(15, 530, 100, 23);
        LogOut.addActionListener(this);
        
        
        add(ShowData);
        add(LogOut);
        add(jlAddCust);
        add(jLabelEmp1);
        add(jLabelEmp2);
        add(jLabelEmp3);
        add(jLabelEmp4);
        add(jLabelEmp5);
        add(jLabelEmp6);
        add(jtfEFname);
        add(jtfELname);
        add(jtfEAgee);
        add(jtfEAddresss);
        add(jtfEUserName);
        add(ResetButton);
        add(updateAdminSubmit);
        add(jEPasswordField);
        setVisible(true);
    
    
    }

    
    
    
    
 
    @Override
    public void actionPerformed(ActionEvent e) {
        Admin upadmin = new Admin();
         
        if (e.getSource() == ResetButton) {
           resetData();
        } else if (e.getSource() == updateAdminSubmit) {

            if (!jtfEFname.getText().equals("") && !jtfELname.getText().equals("") && !jtfEAgee.getText().equals("") && !jtfEAddresss.getText().equals("")
                    && !jtfEUserName.getText().equals("") && !jEPasswordField.getText().equals("")) {
                Admin x = new Admin();
               try{
                upadmin.setUserName(jtfEUserName.getText());
                upadmin.setAddress(jtfEAddresss.getText());
                upadmin.setAge(Integer.parseInt(jtfEAgee.getText()));
                upadmin.setfName(jtfEFname.getText());
                upadmin.setlName(jtfELname.getText());
                upadmin.setPassWord(jEPasswordField.getText());
                
                  if (x.commetToFile(upadmin)&& !jtfEUserName.getText().equals("")
                        || !jtfEAddresss.getText().equals("") || !jtfEFname.getText().equals("") || !jtfELname.getText().equals("") || !jtfEAgee.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
                    resetData();
            }
                }catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, "Failed to Update Your !");
                }
                
               
            }else {
                JOptionPane.showMessageDialog(null, "Please Enter Data!");
        }
        
        }else if (e.getSource() == ShowData){
            
            Admin o = new Admin();
            Admin returned = new Admin();
            returned = o.loadFromFile() ;
            jtfEFname.setText(returned.getfName());
            jtfELname.setText(returned.getlName());
            jtfEAgee.setText(Integer.toString(returned.getAge()));
            jtfEAddresss.setText(returned.getAddress());
            jtfEUserName.setText(returned.getUserName());
            jEPasswordField.setText(returned.getPassWord());
            
            
        }else if (e.getSource() == LogOut){
            AdminDashBoardFrame.adminDash.setVisible(false);
            new LoginUserChooseFrame();
        }

    }

public void resetData(){
            jtfEFname.setText("");
            jtfELname.setText("");
            jtfEAgee.setText("");
            jtfEAddresss.setText("");
            jtfEUserName.setText("");
            jEPasswordField.setText("");
        }
}