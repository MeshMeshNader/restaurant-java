/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giutestcase;

import Resturant.Reports;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
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
public class AddReport extends JPanel implements ActionListener {

    JButton jbEmployee, jbCustomer;
    JLabel jlAddReport, jLabelRepId, jLabelReport;
    JTextField jtfUserRepID;
    JTextArea jtfReport;
    JButton Reset;

    public AddReport() {
        setBackground(Color.GRAY);

        jbEmployee = new JButton("Employee");
        jbEmployee.setBounds(50, 450, 220, 30);
        jbEmployee.setFont(new java.awt.Font("Viner Hand ITC", 3, 24));
        jbEmployee.addActionListener(this);

        jbCustomer = new JButton("Customer");
        jbCustomer.setBounds(350, 450, 220, 30);
        jbCustomer.setFont(new java.awt.Font("Viner Hand ITC", 3, 24));
        jbCustomer.addActionListener(this);
        
        Reset = new JButton("Reset");
        Reset.setBounds(535, 530, 100, 23);
        Reset.addActionListener(this);

        jlAddReport = new JLabel("Add New Report ... !");
        jlAddReport.setFont(new Font("Stencil", 0, 18));
        jlAddReport.setBounds(40, 30, 350, 19);

        //******************** Labels **********************//
        jLabelRepId = new JLabel("ID ");
        jLabelRepId.setFont(new Font("Ravie", 0, 13));
        jLabelRepId.setBounds(90, 80, 120, 30);

        jLabelReport = new JLabel("The Report ");
        jLabelReport.setFont(new Font("Ravie", 0, 13));
        jLabelReport.setBounds(90, 130, 120, 30);

        //********************* TextField **********************//
        jtfUserRepID = new JTextField();
        jtfUserRepID.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfUserRepID.setBounds(240, 80, 200, 22);

        jtfReport = new JTextArea();
        jtfReport.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfReport.setBounds(240, 130, 320, 250);

        
        add(Reset);
        add(jtfReport);
        add(jLabelRepId);
        add(jLabelReport);
        add(jtfUserRepID);
        add(jlAddReport);
        add(jbCustomer);
        add(jbEmployee);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Reports repo = new Reports();

        if (e.getSource() == Reset) {
            resetData();
        } else if (e.getSource() == jbEmployee) {

            if (!jtfReport.getText().equals("") && !jtfUserRepID.getText().equals("")) {
                try {
                    repo.setId(Integer.parseInt(jtfUserRepID.getText()));
                    repo.setDescription(jtfReport.getText());
                    if (repo.addReportsEmp() && !jtfReport.getText().equals("") || !jtfUserRepID.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Report of Employee Added Successfully!");
                    resetData();
                }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Failed to add Report!");
                }
                
              
            } else {
                JOptionPane.showMessageDialog(null, "Please Enter Data!");
            }
        } else if (e.getSource () == jbCustomer ){
            if (!jtfReport.getText().equals("") && !jtfUserRepID.getText().equals("")) {
                try {
                    repo.setId(Integer.parseInt(jtfUserRepID.getText()));
                    repo.setDescription(jtfReport.getText());
                    if (repo.addReportsCust()&& !jtfReport.getText().equals("") || !jtfUserRepID.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Report of Customer Added Successfully!");
                    resetData();
                }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Failed to add Report!");
                }

                
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