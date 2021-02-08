/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giutestcase;

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
public class OffersAddPanel extends JPanel implements ActionListener {

    JButton submitBtn;
    JLabel jlAddOffer, jlOfferId, jlOfferName, jlOfferDes;
    JTextField jtfOfferId, jtfOfferName;
    JTextArea jtfDes;
    JButton Reset;

    public OffersAddPanel() {

        setBackground(Color.GRAY);

        submitBtn = new JButton("Submit");
        submitBtn.setBounds(260, 485, 220, 30);
        submitBtn.addActionListener(this);

        Reset = new JButton("Reset");
        Reset.setBounds(535, 530, 100, 23);
        Reset.addActionListener(this);

        jlAddOffer = new JLabel("Add New SpecialOffer ... !");
        jlAddOffer.setFont(new Font("Stencil", 0, 18));
        jlAddOffer.setBounds(40, 30, 350, 19);

        //******************** Labels **********************//
        jlOfferId = new JLabel("ID ");
        jlOfferId.setFont(new Font("Ravie", 0, 13));
        jlOfferId.setBounds(90, 80, 120, 30);

        jlOfferName = new JLabel("Name ");
        jlOfferName.setFont(new Font("Ravie", 0, 13));
        jlOfferName.setBounds(90, 130, 120, 30);

        jlOfferDes = new JLabel("The Report ");
        jlOfferDes.setFont(new Font("Ravie", 0, 13));
        jlOfferDes.setBounds(90, 180, 120, 30);

        //********************* TextField **********************//
        jtfOfferId = new JTextField();
        jtfOfferId.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfOfferId.setBounds(240, 80, 200, 22);

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
        add(jlOfferId);
        add(jlOfferName);
        add(jtfOfferId);
        add(jlAddOffer);
        add(submitBtn);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SpecialOffers offer = new SpecialOffers();

        if (e.getSource() == Reset) {
            resetData();
        } else if (e.getSource() == submitBtn) {

            if (!jtfDes.getText().equals("") && !jtfOfferId.getText().equals("")) {
                try {
                    offer.setOfferId(Integer.parseInt(jtfOfferId.getText()));
                    offer.setOfferName(jtfOfferName.getText());
                    offer.setOfferDescription(jtfDes.getText());
                    if (offer.addOffers()&& !jtfDes.getText().equals("") || !jtfOfferId.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Special Offer Added Successfully!");
                    resetData();
                }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Failed to add Special Offer !");
                }
                
              
            } else {
                JOptionPane.showMessageDialog(null, "Please Enter Data!");
            }
        } 

}
public void resetData() {
        jtfOfferName.setText("");
        jtfDes.setText("");
        jtfOfferId.setText("");
    }

}
