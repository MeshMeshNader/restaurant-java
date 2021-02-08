/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giutestcase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author meshm
 */
public class LoginUserChooseFrame implements ActionListener {

    JFrame f;
    JButton jbAdmin, jbEmployee;
    JLabel jlWelcome;

    public LoginUserChooseFrame() {
        ///Main Frame
        f = new JFrame("Welcome User");
        f.setSize(900, 650);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setLocation(350, 130);

        /// Buttons 
        jbAdmin = new JButton("Admin");
        jbAdmin.setBounds(130, 270, 190, 110);
        jbAdmin.setFont(new java.awt.Font("Viner Hand ITC", 3, 24));
        jbAdmin.addActionListener(this);

        jbEmployee = new JButton("Employee");
        jbEmployee.setBounds(570, 270, 190, 110);
        jbEmployee.setFont(new java.awt.Font("Viner Hand ITC", 3, 24));
        jbEmployee.addActionListener(this);

        //// Lable
        jlWelcome = new JLabel("Welcome ... !");
        jlWelcome.setFont(new java.awt.Font("Wide Latin", 3, 48));
        jlWelcome.setBounds(190, 60, 550, 130);

        ///adding to frame
        f.add(jbAdmin);
        f.add(jbEmployee);
        f.add(jlWelcome);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbAdmin) {
            f.setVisible(false);
            new LoginAdminFrame();
        } else if (e.getSource() == jbEmployee) {
            f.setVisible(false);
            new LoginEmployeeFrame();
        }
    }
}
