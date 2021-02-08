/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giutestcase;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author meshm
 */
public class checkprofileEmp extends JPanel implements ActionListener{

    
    JLabel jLabelEmp4 , jLabelEmp5 , jLabelEmp6 , jlAddCust;
    JTextField jtfEAddresss , jtfEUserName;
    JPasswordField jEPasswordField;
    JButton addEmpSubmit;
        
        

    public checkprofileEmp() {
    
        
        jlAddCust = new JLabel("Update Your Data ... !");
        jlAddCust.setFont(new Font("Stencil", 0, 18));
        jlAddCust.setBounds(40, 30, 240, 19);
        
        
        jLabelEmp4 = new JLabel("Address ");
        jLabelEmp4.setFont(new Font("Ravie", 0, 13));
        jLabelEmp4.setBounds(90, 230, 120, 30);

        jLabelEmp5 = new JLabel("UserName  ");
        jLabelEmp5.setFont(new Font("Ravie", 0, 13));
        jLabelEmp5.setBounds(90, 280, 120, 30);

        jLabelEmp6 = new JLabel("Password ");
        jLabelEmp6.setFont(new Font("Ravie", 0, 13));
        jLabelEmp6.setBounds(90, 330, 140, 30);
    
    
    
        jtfEAddresss = new JTextField();
        jtfEAddresss.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfEAddresss.setBounds(240, 230, 270, 22);

        jtfEUserName = new JTextField();
        jtfEUserName.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfEUserName.setBounds(240, 280, 270, 22);

        jEPasswordField = new JPasswordField();
        jEPasswordField.setBounds(240, 330, 270, 22);
        
        
        
        addEmpSubmit = new JButton("Submit");
        addEmpSubmit.setBounds(260, 485, 220, 30);
        addEmpSubmit.addActionListener(this);
        
        
        
        
        
    
    
    }

    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
    
    
    
    
    }
    
    
    
    
    
    
}
