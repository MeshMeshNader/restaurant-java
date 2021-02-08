/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giutestcase;

import Resturant.Billing;
import Resturant.RewardProgram;
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
public class PrintBilling extends JPanel implements ActionListener{

    JButton submitBtn ;
    JLabel jlAddReward, jlOfferName, jlOfferDes;
    JTextField jtfOfferName;
    JTextArea jtfDes;
    JButton Reset;
    
    public PrintBilling() {
    
     setBackground(Color.GRAY);

        submitBtn = new JButton("Submit");
        submitBtn.setBounds(260, 440, 220, 30);
        submitBtn.addActionListener(this);
        
        

        Reset = new JButton("Reset");
        Reset.setBounds(535, 530, 100, 23);
        Reset.addActionListener(this);

        jlAddReward = new JLabel("Print Billing ... !");
        jlAddReward.setFont(new Font("Stencil", 0, 18));
        jlAddReward.setBounds(40, 30, 350, 19);

        //******************** Labels **********************//
        

        jlOfferName = new JLabel("Order ID ");
        jlOfferName.setFont(new Font("Ravie", 0, 13));
        jlOfferName.setBounds(90, 130, 120, 30);

        jlOfferDes = new JLabel("The Billing ");
        jlOfferDes.setFont(new Font("Ravie", 0, 13));
        jlOfferDes.setBounds(90, 180, 120, 30);

        //********************* TextField **********************//
       
        jtfOfferName = new JTextField();
        jtfOfferName.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfOfferName.setBounds(240, 130, 200, 22);

        jtfDes = new JTextArea();
        jtfDes.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfDes.setBounds(240, 180, 320, 250);

        
        
        add(jlOfferDes);
        add(jlOfferName);
        add(jtfOfferName);
        add(Reset);
        add(jtfDes);
        add(jlOfferName);
        add(jlAddReward);
        add(submitBtn);
        
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        

        if (e.getSource() == Reset) {
            resetData();
        } else if (e.getSource() == submitBtn) {

            if (!jlOfferName.getText().equals("")) {
                
                    Billing x = new Billing();
                    jlOfferDes.setText(""+x.listBilling().toString()); ;
                    
                
              
            } else {
                JOptionPane.showMessageDialog(null, "Please Enter Data!");
            }
            
    }

}
public void resetData() {
        jtfOfferName.setText("");
        jtfDes.setText("");
    }

}
