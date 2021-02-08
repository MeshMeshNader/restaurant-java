/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giutestcase;

import Resturant.Employee;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author meshm
 */
public class AdminDashBoardFrame extends JFrame implements ActionListener {

    public static JFrame adminDash;

    JPanel jpEmployees, jpMeals, jpReports, jpOffers, jpRewards, jpProfile, jpYourData;
    JTabbedPane taps;
    //Border Left 
    JPanel jpOptionsEmp, jpOptionsMeals, jpOptionsOffers, jpOptionsReports, jpOptionsRewards;
    JButton btEA, btEL, btEU, btMA, btML, btMU, btRepA, btRepU, btOffA, btOffU, btRL;

    //Border Center 
    JPanel jpCenterEmp, jpCenterMeals, jpCenterOff, jpCenterRep, jpCenterRewards;
    JPanel EmpAdd, MealAdd;
    JButton logout;
    //Panels
    Employee_AddPanel addEmployee;
    Employee_UpdateDelete UpdateDeleteEmployee;
    AddReport ReportAddPanel;
    SearchReports ReportSearchPanel;
    Meals_UpdateDelete MealsUpdateDelete;
    OffersAddPanel offAddPanel;
    OffersSearchPanel offSearchPanel;
    RewardAdd addReward;
    MealsAdd MealsAdding;
    Profile profile;
    ListEmp listEmp;
    YourProfile updateadmin;

    {
        // Frame 
        adminDash = new JFrame("Welcome to Admin Dash Board ");
        adminDash.setSize(900, 650);
        adminDash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminDash.setLayout(new BorderLayout());
        adminDash.setVisible(true);
        adminDash.setResizable(false);
        adminDash.setLocation(350, 130);

        //Buttons 
        //Employee Buttons 
        btEA = new JButton("Add Employee");
        btEL = new JButton("List Employees");
        btEU = new JButton("Update Or Delete");
        btEA.setBounds(15, 150, 140, 30);
        btEL.setBounds(15, 270, 140, 30);
        btEU.setBounds(15, 390, 140, 30);
        btEA.addActionListener(this);
        btEU.addActionListener(this);
        btEL.addActionListener(this);

        //Meals Buttons 
        btMA = new JButton("Add Meal");
        btMA.setBounds(15, 150, 140, 30);
        btMA.addActionListener(this);

        btML = new JButton("List Meals");
        btML.setBounds(15, 270, 140, 30);
        btML.addActionListener(this);

        btMU = new JButton("Update Or Delete");
        btMU.setBounds(15, 390, 140, 30);
        btMU.addActionListener(this);

        logout = new JButton("Logout");
        logout.setBounds(15, 500, 140, 30);
        logout.addActionListener(this);

        //Reports Buttons 
        btRepA = new JButton("Add Report");
        btRepA.setBounds(15, 150, 140, 30);
        btRepA.addActionListener(this);

        btRepU = new JButton("Search");
        btRepU.setBounds(15, 390, 140, 30);
        btRepU.addActionListener(this);

        //OFFers Buttons 
        btOffA = new JButton("Add Offer");
        btOffA.setBounds(15, 150, 140, 30);
        btOffA.addActionListener(this);

        btOffU = new JButton("Search");
        btOffU.setBounds(15, 390, 140, 30);
        btOffU.addActionListener(this);

        //Rewards Buttons
        btRL = new JButton("Manage Reward");
        btRL.setBounds(15, 270, 140, 30);
        btRL.addActionListener(this);

        //Panels 
        jpEmployees = new JPanel(new BorderLayout());
        jpMeals = new JPanel(new BorderLayout());
        jpReports = new JPanel(new BorderLayout());
        jpOffers = new JPanel(new BorderLayout());
        jpRewards = new JPanel(new BorderLayout());
        jpYourData = new JPanel(new BorderLayout());

        jpProfile = new JPanel(null);
        jpProfile.setBackground(Color.ORANGE);
        jpProfile.setLayout(new BorderLayout());

        profile = new Profile();
        profile.setLayout(null);
        jpProfile.add(profile, BorderLayout.CENTER);
        
        
        
        
        jpYourData = new JPanel(null);
        jpYourData.setBackground(Color.DARK_GRAY);
        jpYourData.setLayout(new BorderLayout());
        
        updateadmin = new YourProfile();
        updateadmin.setLayout(null);
        jpYourData.add(updateadmin , BorderLayout.CENTER);
        
        
        

        //Tabbed Pane 
        taps = new JTabbedPane();
        taps.addTab("Employees ", jpEmployees);
        taps.addTab("Meals ", jpMeals);
        taps.addTab("Reports ", jpReports);
        taps.addTab("Offers ", jpOffers);
        taps.addTab("Rewards ", jpRewards);
        taps.addTab("Profile ", jpProfile);
        taps.addTab("Your Data ", jpYourData);

        //Options Panel
        //Options Employees
        jpOptionsEmp = new JPanel();
        jpOptionsEmp.setPreferredSize(new Dimension(170, 599));
        jpOptionsEmp.setBackground(Color.CYAN);
        jpEmployees.add(jpOptionsEmp, BorderLayout.LINE_START);
        jpOptionsEmp.setLayout(null);
        jpOptionsEmp.add(btEA);
        jpOptionsEmp.add(btEL);
        jpOptionsEmp.add(btEU);
        jpOptionsEmp.add(logout);

        //Options Meals
        jpOptionsMeals = new JPanel();
        jpOptionsMeals.setPreferredSize(new Dimension(170, 599));
        jpOptionsMeals.setBackground(Color.red);
        jpMeals.add(jpOptionsMeals, BorderLayout.LINE_START);
        jpOptionsMeals.setLayout(null);
        jpOptionsMeals.add(btMA);
        jpOptionsMeals.add(btML);
        jpOptionsMeals.add(btMU);

        //Options Reports
        jpOptionsReports = new JPanel();
        jpOptionsReports.setPreferredSize(new Dimension(170, 599));
        jpOptionsReports.setBackground(Color.MAGENTA);
        jpReports.add(jpOptionsReports, BorderLayout.LINE_START);
        jpOptionsReports.setLayout(null);
        jpOptionsReports.add(btRepA);
        jpOptionsReports.add(btRepU);

        //Options Offers
        jpOptionsOffers = new JPanel();
        jpOptionsOffers.setPreferredSize(new Dimension(170, 599));
        jpOptionsOffers.setBackground(Color.blue);
        jpOffers.add(jpOptionsOffers, BorderLayout.LINE_START);
        jpOptionsOffers.setLayout(null);
        jpOptionsOffers.add(btOffA);
        jpOptionsOffers.add(btOffU);

        //Options Rewards
        jpOptionsRewards = new JPanel();
        jpOptionsRewards.setPreferredSize(new Dimension(170, 599));
        jpOptionsRewards.setBackground(Color.black);
        jpRewards.add(jpOptionsRewards, BorderLayout.LINE_START);
        jpOptionsRewards.setLayout(null);
        jpOptionsRewards.add(btRL);

        //Dynamic Panel
        /**
         * ***********************************************************************************
         */
        //Dynamic Employee
        jpCenterEmp = new JPanel();
        jpEmployees.add(jpCenterEmp, BorderLayout.CENTER);
        jpCenterEmp.setLayout(new BorderLayout());

        addEmployee = new Employee_AddPanel();
        addEmployee.setLayout(null);
        jpCenterEmp.add(addEmployee, BorderLayout.CENTER);
//****************** EMPLOYEE lIST *****************************//

//****************** EMPLYEE DELETE AND UPDATE ********* //
        /**
         * *************************** MEALS ********************************************************
         */
        //Dynamic Meals
        jpCenterMeals = new JPanel();
        jpMeals.add(jpCenterMeals, BorderLayout.CENTER);
        jpCenterMeals.setLayout(new BorderLayout());

        MealsAdding = new MealsAdd();
        MealsAdding.setLayout(null);
        jpCenterMeals.add(MealsAdding, BorderLayout.CENTER);

        /**
         * ***********************************************************************************
         */
        //Dynamic Reports
        jpCenterRep = new JPanel();
        jpCenterRep.setBackground(Color.red);
        jpReports.add(jpCenterRep, BorderLayout.CENTER);
        jpCenterRep.setLayout(new BorderLayout());

        ReportAddPanel = new AddReport();
        ReportAddPanel.setLayout(null);
        jpCenterRep.add(ReportAddPanel, BorderLayout.CENTER);

        //Dynamic Offers
        jpCenterOff = new JPanel();
        jpCenterOff.setBackground(Color.red);
        jpOffers.add(jpCenterOff, BorderLayout.CENTER);
        jpCenterOff.setLayout(new BorderLayout());

        offAddPanel = new OffersAddPanel();
        offAddPanel.setLayout(null);
        jpCenterOff.add(offAddPanel, BorderLayout.CENTER);

        //Dynamic Rewards
        jpCenterRewards = new JPanel();
        jpCenterRewards.setBackground(Color.red);
        jpRewards.add(jpCenterRewards, BorderLayout.CENTER);
        jpCenterRewards.setLayout(new BorderLayout());

        addReward = new RewardAdd();
        addReward.setLayout(null);
        jpCenterRewards.add(addReward, BorderLayout.CENTER);

        adminDash.add(taps);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btEA) {
            UpdateDeleteEmployee.setVisible(false);
            addEmployee.setVisible(true);
        } else if (e.getSource() == btEU) {
            addEmployee.setVisible(false);
            UpdateDeleteEmployee = new Employee_UpdateDelete();
            UpdateDeleteEmployee.setLayout(null);
            jpCenterEmp.add(UpdateDeleteEmployee, BorderLayout.CENTER);

        } else if (e.getSource() == btEL) {

            new ListEmp();

        } else if (e.getSource() == btRepA) {
            ReportSearchPanel.setVisible(false);
            ReportAddPanel.setVisible(true);

        } else if (e.getSource() == btRepU) {
            ReportAddPanel.setVisible(false);
            ReportSearchPanel = new SearchReports();
            ReportSearchPanel.setLayout(null);
            jpCenterRep.add(ReportSearchPanel, BorderLayout.CENTER);

        } else if (e.getSource() == btMA) {

            MealsAdding.setVisible(true);

        } else if (e.getSource() == btMU) {

            MealsAdding.setVisible(false);
            MealsUpdateDelete = new Meals_UpdateDelete();
            MealsUpdateDelete.setLayout(null);
            jpCenterMeals.add(MealsUpdateDelete, BorderLayout.CENTER);

        } else if (e.getSource() == btML) {

            new ListMeals();

        } else if (e.getSource() == btOffA) {
            offAddPanel.setVisible(true);

        } else if (e.getSource() == btOffU) {

            offAddPanel.setVisible(false);
            offSearchPanel = new OffersSearchPanel();
            offSearchPanel.setLayout(null);
            jpCenterOff.add(offSearchPanel, BorderLayout.CENTER);

        } else if (e.getSource() == logout) {

           new LoginUserChooseFrame();
    }
    }

}
