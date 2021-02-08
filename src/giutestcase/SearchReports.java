/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giutestcase;

import Resturant.Employee;
import Resturant.Reports;
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
public class SearchReports extends JPanel implements ActionListener{

    JButton jbEmployee, jbCustomer ;
    JLabel jlAddReport, jLabelRepId, jLabelReport;
    JTextField jtfUserRepID;
    JTextArea jtfReport;
    JButton Reset;
    
    
    public SearchReports() {
    
    
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

        jlAddReport = new JLabel("Search Report ... !");
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
        

        if (e.getSource() == Reset) {
            resetData();
        } else if (e.getSource() == jbEmployee) {

            if (!jtfUserRepID.getText().equals("")) {
                
                Reports rep2 = new Reports();
                  
            if (Integer.parseInt(jtfUserRepID.getText())>0)
            {
                
                
                jtfReport.setText(""+rep2.searchReportsEmp(Integer.parseInt(jtfUserRepID.getText())));
                
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(null ,"Missing required Fields ... !  Please, Search By ID ...");
        }
        } else if (e.getSource () == jbCustomer ){
            if (!jtfUserRepID.getText().equals("")) {
                
                Reports rep2 = new Reports();
                  
            if (Integer.parseInt(jtfUserRepID.getText())>0)
            {
                
                
                jtfReport.setText(""+rep2.searchReportsCust(Integer.parseInt(jtfUserRepID.getText())));
                
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(null ,"Missing required Fields ... !  Please, Search By ID ...");
        }
            
        }
    }   
    public void resetData() {
        jtfReport.setText("");
        jtfUserRepID.setText("");
    }
     public void setPanelData(Employee emp)
    {
        
        jtfReport.setText(""+emp.getAddress());
        jtfUserRepID.setText(""+emp.getSalary());
        
    }
    
}
