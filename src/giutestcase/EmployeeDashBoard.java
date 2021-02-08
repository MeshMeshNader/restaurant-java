/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giutestcase;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author meshm
 */
public class EmployeeDashBoard extends JFrame implements ActionListener {

    
    JFrame adminDash;
    JButton btEA, btEL, btEU , btRepA , btRepU ,btOffA ;
    JPanel jpEmployees, jpMeals, jpReports, jpOffers, jpRewards;
    JTabbedPane taps;
    JPanel jpOptionsEmp, jpProfile, jpOptionsOffers, jpOptionsReports , jpProfile2;
    JPanel jpCenterEmp, jpCenterMeals, jpCenterOff, jpCenterRep, jpCenterRewards , jpBilling;
    Customer_AddPanel addcustomer;
    CustumerUpdateDelete cud ;
    OrderAdd orderAdd ;
    CancelOrder cancelOrder;
    PrintBilling billing ;
    ProfileNum2 profile;
    
    public EmployeeDashBoard() {
        
        adminDash = new JFrame("Welcome to Employee Dash Board ");
        adminDash.setSize(900, 650);
        adminDash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminDash.setLayout(new BorderLayout());
        adminDash.setVisible(true);
        adminDash.setResizable(false);
        adminDash.setLocation(350, 130);

        
        //Buttons 
        //Employee Buttons 
        btEA = new JButton("Add Customer");
        btEL = new JButton("List Customer");
        btEU = new JButton("Update Or Delete");
        btEA.setBounds(15, 150, 140, 30);
        btEL.setBounds(15, 270, 140, 30);
        btEU.setBounds(15, 390, 140, 30);
        btEA.addActionListener(this);
        btEU.addActionListener(this);
        btEL.addActionListener(this);
        
        
        btRepA = new JButton("Add Order");
        btRepA.setBounds(15, 150, 140, 30);
        btRepA.addActionListener(this);


        btRepU = new JButton("Cancel Order");
        btRepU.setBounds(15, 390, 140, 30);
        btRepU.addActionListener(this);
        
        
        
        btOffA = new JButton("Billing");
        btOffA.setBounds(15, 270, 140, 30);
        btOffA.addActionListener(this);
        
        
        
        
        jpEmployees = new JPanel(new BorderLayout());
        jpReports = new JPanel(new BorderLayout());
        jpOffers = new JPanel(new BorderLayout());
        jpRewards = new JPanel(new BorderLayout());
        
        
        taps = new JTabbedPane();
        taps.addTab("Customers ", jpEmployees);
        taps.addTab("Order ", jpReports);
        taps.addTab("Billing ", jpOffers);
        taps.addTab("Profile ", jpRewards);
        
        
        
        
        
        jpOptionsEmp = new JPanel();
        jpOptionsEmp.setPreferredSize(new Dimension(170, 599));
        jpOptionsEmp.setBackground(Color.CYAN);
        jpEmployees.add(jpOptionsEmp, BorderLayout.LINE_START);
        jpOptionsEmp.setLayout(null);
        jpOptionsEmp.add(btEA);
        jpOptionsEmp.add(btEL);
        jpOptionsEmp.add(btEU);
        
        
        jpOptionsReports = new JPanel();
        jpOptionsReports.setPreferredSize(new Dimension(170, 599));
        jpOptionsReports.setBackground(Color.MAGENTA);
        jpReports.add(jpOptionsReports, BorderLayout.LINE_START);
        jpOptionsReports.setLayout(null);
        jpOptionsReports.add(btRepA);
        jpOptionsReports.add(btRepU);
        
        
        jpOptionsOffers = new JPanel();
        jpOptionsOffers.setPreferredSize(new Dimension(170, 599));
        jpOptionsOffers.setBackground(Color.blue);
        jpOffers.add(jpOptionsOffers, BorderLayout.LINE_START);
        jpOptionsOffers.setLayout(null);
        jpOptionsOffers.add(btOffA);
        

        
       



        jpProfile2 = new JPanel(null);
        jpRewards.add(jpProfile2 , BorderLayout.CENTER);
        jpProfile2.setBackground(Color.ORANGE);
        jpProfile2.setLayout(new BorderLayout());
        
        profile = new ProfileNum2();
        profile.setLayout(null);
        jpProfile2.add(profile , BorderLayout.CENTER);




        jpBilling = new JPanel(null);
        jpOffers.add(jpBilling , BorderLayout.CENTER);
        jpBilling.setBackground(Color.ORANGE);
        jpBilling.setLayout(new BorderLayout());
        
        billing = new PrintBilling();
        billing.setLayout(null);
        jpBilling.add(billing , BorderLayout.CENTER);



        jpCenterEmp = new JPanel();
        jpEmployees.add(jpCenterEmp, BorderLayout.CENTER);
        jpCenterEmp.setLayout(new BorderLayout());

        addcustomer = new Customer_AddPanel();
        addcustomer.setLayout(null);
        jpCenterEmp.add(addcustomer  , BorderLayout.CENTER);
        
        
        
        
        
        jpCenterRep = new JPanel();
        jpReports.add(jpCenterRep, BorderLayout.CENTER);
        jpCenterRep.setLayout(new BorderLayout());
        

        orderAdd = new OrderAdd();
        orderAdd.setLayout(null);
        jpCenterRep.add(orderAdd , BorderLayout.CENTER);
        
        



        adminDash.add(taps);



        
        
    }

    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == btEA){
            cud.setVisible(false);
            addcustomer.setVisible(true);
        }
        else if(e.getSource() == btEU){
        addcustomer.setVisible(false);
        cud = new CustumerUpdateDelete();
        cud.setLayout(null);
        jpCenterEmp.add(cud  , BorderLayout.CENTER);
            
        }else if (e.getSource() == btEL){
            
            new ListCustomer();
            
        }else if(e.getSource()==btRepA){
            cancelOrder.setVisible(false);
            orderAdd.setVisible(true);
            
        }else if(e.getSource() == btRepU){
        orderAdd.setVisible(false);
        cancelOrder = new CancelOrder();
        cancelOrder.setLayout(null);
        jpCenterRep.add(cancelOrder , BorderLayout.CENTER);
            
        }
         
    }
    
}
