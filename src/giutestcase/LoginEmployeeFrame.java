/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giutestcase;

import Resturant.Admin;
import Resturant.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author meshm
 */
public class LoginEmployeeFrame extends JFrame implements ActionListener {

    JFrame e;
    JLabel EmployeeWelcome, jlEusername, jlEpassword;
    JTextField jtfUsername;
    JPasswordField jpfPassWord;
    JButton jbLogin, jbBack, jbReset;

    public LoginEmployeeFrame() {

        e = new JFrame("Welcome Employee");
        e.setSize(900, 650);
        e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        e.setLayout(null);
        e.setVisible(true);
        e.setResizable(false);
        e.setLocation(350, 130);

        // Employee Lable
        EmployeeWelcome = new JLabel("Welcome Employee... !");
        EmployeeWelcome.setFont(new java.awt.Font("Wide Latin", 3, 38));
        EmployeeWelcome.setBounds(100, 60, 750, 130);

        jlEusername = new JLabel("UserName");
        jlEusername.setFont(new java.awt.Font("Vivaldi", 3, 24));
        jlEusername.setBounds(210, 220, 120, 30);

        jlEpassword = new JLabel("PassWord");
        jlEpassword.setFont(new java.awt.Font("Vivaldi", 3, 24));
        jlEpassword.setBounds(580, 220, 120, 30);

        // Employee text and password feiled 
        jtfUsername = new JTextField();
        jtfUsername.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfUsername.setBounds(130, 260, 270, 30);

        jpfPassWord = new JPasswordField();
        jpfPassWord.setBounds(490, 260, 270, 30);

        //Buttons 
        jbLogin = new JButton("Login");
        jbLogin.setFont(new java.awt.Font("Viner Hand ITC", 1, 18));
        jbLogin.setBounds(370, 380, 160, 40);
        jbLogin.addActionListener(this);
        

        jbReset = new JButton("Reset");
        jbReset.setFont(new java.awt.Font("Viner Hand ITC", 1, 18));
        jbReset.setBounds(710, 450, 160, 40);
        jbReset.addActionListener(this);
        

        jbBack = new JButton("Back");
        jbBack.setFont(new java.awt.Font("Viner Hand ITC", 1, 18));
        jbBack.setBounds(710, 520, 160, 40);
        jbBack.addActionListener(this);
        
        

        e.add(EmployeeWelcome);
        e.add(jlEusername);
        e.add(jlEpassword);
        e.add(jtfUsername);
        e.add(jpfPassWord);
        e.add(jbLogin);
        e.add(jbBack);
        e.add(jbReset);

    }

    @Override
    public void actionPerformed(ActionEvent evn) {
        if (evn.getSource() == jbBack) {
            e.setVisible(false);
            new LoginUserChooseFrame();
        } else if (evn.getSource() == jbLogin) {
            
            Employee employee = new Employee();

            if (employee.loginAsEmployee(jtfUsername.getText(), jpfPassWord.getText())) {
                // y5osh 3ala el Employee dashbord
                JOptionPane.showMessageDialog(null, "Welcome Employee ... !",
                        "Welcome !.. ", JOptionPane.PLAIN_MESSAGE);
                e.setVisible(false);
                new EmployeeDashBoard();
            } else {
                JOptionPane.showMessageDialog(null, "Your UserName Or Password Is Incorrect ",
                        "Error !.. ", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

}
