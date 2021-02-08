/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giutestcase;

import Resturant.Admin;
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
public class LoginAdminFrame extends JFrame implements ActionListener{

        JFrame a;
        JLabel adminWelcome , jlAusername , jlApassword ;
        JTextField jtfUsername ;
        JPasswordField jpfPassWord ;
        JButton jbLogin , jbReset , jbBack;
    public LoginAdminFrame() {
        a= new JFrame("Welcome Admin");
        a.setSize(900, 650);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setLayout(null);
        a.setVisible(true);
        a.setResizable(false);
        a.setLocation(350, 130);
            
        // Admin Lable
        adminWelcome = new JLabel("Welcome Admin... !");
        adminWelcome.setFont(new java.awt.Font("Wide Latin", 3, 38));
        adminWelcome.setBounds(155, 60, 650, 130);

        jlAusername = new JLabel("UserName");
        jlAusername.setFont(new java.awt.Font("Vivaldi", 3, 24));
        jlAusername.setBounds(210, 220, 120, 30);

        jlApassword = new JLabel("PassWord");
        jlApassword.setFont(new java.awt.Font("Vivaldi", 3, 24));
        jlApassword.setBounds(580, 220, 120, 30);

        // Admin text and password feiled 
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
        

        a.add(adminWelcome);
        a.add(jlAusername);
        a.add(jlApassword);
        a.add(jtfUsername);
        a.add(jpfPassWord);
        a.add(jbLogin);
        a.add(jbBack);
        a.add(jbReset);
        
        
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
            
        if(e.getSource()==jbBack){
               a.setVisible(false);
               new LoginUserChooseFrame();
            }
        
        else if(e.getSource()==jbReset){
            jtfUsername.setText("");
            jpfPassWord.setText("");
        }
        else if(e.getSource()==jbLogin){
            Admin admin = new Admin();
            
            if (admin.loginAsadmin(jtfUsername.getText(), jpfPassWord.getText())) {
                JOptionPane.showMessageDialog(null, "Welcome Admin ... !",
                        "Welcome !.. ", JOptionPane.PLAIN_MESSAGE);   
                
                a.setVisible(false);
                    new AdminDashBoardFrame();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Your UserName Or Password Is Incorrect ",
                             "Error !.. ", JOptionPane.PLAIN_MESSAGE);
                }
            
        }
    
    
    }

   

}
