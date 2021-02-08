/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giutestcase;

import Resturant.RewardProgram;
import Resturant.SpecialOffers;
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
public class RewardAdd extends JPanel implements ActionListener{

    
     JButton submitBtn , Delete;
    JLabel jlAddReward, jlOfferName, jlOfferDes;
    JTextField jtfOfferName;
    JTextArea jtfDes;
    JButton Reset;
    
    
    
    public RewardAdd() {
        
        setBackground(Color.GRAY);

        submitBtn = new JButton("Submit");
        submitBtn.setBounds(260, 440, 220, 30);
        submitBtn.addActionListener(this);
        
        Delete = new JButton("Delete");
        Delete.setBounds(260, 490, 220, 30);
        Delete.addActionListener(this);

        Reset = new JButton("Reset");
        Reset.setBounds(535, 530, 100, 23);
        Reset.addActionListener(this);

        jlAddReward = new JLabel("Add or Delete Reward ... !");
        jlAddReward.setFont(new Font("Stencil", 0, 18));
        jlAddReward.setBounds(40, 30, 350, 19);

        //******************** Labels **********************//
        

        jlOfferName = new JLabel("Cobon Name ");
        jlOfferName.setFont(new Font("Ravie", 0, 13));
        jlOfferName.setBounds(90, 130, 120, 30);

        jlOfferDes = new JLabel("The Desciption ");
        jlOfferDes.setFont(new Font("Ravie", 0, 13));
        jlOfferDes.setBounds(90, 180, 120, 30);

        //********************* TextField **********************//
       
        jtfOfferName = new JTextField();
        jtfOfferName.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfOfferName.setBounds(240, 130, 200, 22);

        jtfDes = new JTextArea();
        jtfDes.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfDes.setBounds(240, 180, 320, 250);

        
        
        add(Delete);
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
        RewardProgram rew = new RewardProgram();

        if (e.getSource() == Reset) {
            resetData();
        } else if (e.getSource() == submitBtn) {

            if (!jtfDes.getText().equals("") && !jtfOfferName.getText().equals("")) {
                try {
                    RewardProgram rew2 = new RewardProgram();
                    rew2.setCobon(jtfOfferName.getText());
                    rew2.setCobonDescription(jtfDes.getText());
                    if (rew.addReward(rew2)&& !jtfDes.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Reward Added Successfully!");
                    resetData();
                }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Failed to add Reward !");
                }
                
              
            } else {
                JOptionPane.showMessageDialog(null, "Please Enter Data!");
            }
        }else if (e.getSource()==Delete){
            rew.deleteReward();
            JOptionPane.showMessageDialog(null, "Reward Deleted Successfully!");
            resetData();
            
        }

}
public void resetData() {
        jtfOfferName.setText("");
        jtfDes.setText("");
    }

}
