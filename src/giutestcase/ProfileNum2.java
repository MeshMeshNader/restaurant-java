/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giutestcase;

import Resturant.Customer;
import Resturant.Employee;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author meshm
 */
public class ProfileNum2 extends JPanel implements ActionListener{
     JButton jbEmployee;
    JLabel jlProfile, jlUserId, jlUserProfile;
    JTextField jtfUserRepID;
    JTextArea jtfReport;
    JButton Reset;

    public ProfileNum2() {
        
        setBackground(Color.GRAY);

        jbEmployee = new JButton("Employee");
        jbEmployee.setBounds(270, 450, 220, 30);
        jbEmployee.setFont(new java.awt.Font("Viner Hand ITC", 3, 24));
        jbEmployee.addActionListener(this);

        
        Reset = new JButton("Reset");
        Reset.setBounds(535, 530, 100, 23);
        Reset.addActionListener(this);

        jlProfile = new JLabel("Profiles ... !");
        jlProfile.setFont(new Font("Stencil", 0, 18));
        jlProfile.setBounds(40, 30, 350, 19);

        //******************** Labels **********************//
        jlUserId = new JLabel("ID ");
        jlUserId.setFont(new Font("Ravie", 0, 13));
        jlUserId.setBounds(90, 80, 120, 30);

        jlUserProfile = new JLabel("The Profile ");
        jlUserProfile.setFont(new Font("Ravie", 0, 13));
        jlUserProfile.setBounds(90, 130, 120, 30);

        //********************* TextField **********************//
        jtfUserRepID = new JTextField();
        jtfUserRepID.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfUserRepID.setBounds(240, 80, 200, 22);

        jtfReport = new JTextArea();
        jtfReport.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfReport.setBounds(240, 130, 320, 250);

        
        add(Reset);
        add(jtfReport);
        add(jlUserId);
        add(jlUserProfile);
        add(jtfUserRepID);
        add(jlProfile);

        add(jbEmployee);

        
        
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
       

        if (e.getSource() == Reset) {
            resetData();
        } else if (e.getSource() == jbEmployee) {

            if (!jtfUserRepID.getText().equals("")) {
                
                    Customer x = new Customer();
                    jtfReport.setText(""+x.customerProfile(Integer.parseInt(jtfUserRepID.getText()))); ;
                    
                
              
            } else {
                JOptionPane.showMessageDialog(null, "Please Enter Data!");
            }
            
    }

    
    

}
public void resetData() {
        jtfReport.setText("");
        jtfUserRepID.setText("");
    }

}