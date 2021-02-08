/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giutestcase;

import Resturant.Employee;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

/**
 *
 * @author meshm
 */
public class ListEmp extends JFrame {

    public ListEmp() {
        JFrame f= new JFrame("List Employees");
        f.setBounds(200,10,900,650);
        f.setLayout(null);  
        f.setVisible(true);
        f.setResizable(false);
        
        
        
        
    JPanel Dynamic_panel_LisEmployee=new JPanel();
         Dynamic_panel_LisEmployee.setBounds(0,0,900,650);
         Dynamic_panel_LisEmployee.setBackground(Color.LIGHT_GRAY);       
    
/***********************************************************************/ 
    //Panel2_Table
    String data[][]={ {"","","","",""},{"","","","",""},{"","","","",""},
                      {"","","","",""},{"","","","",""},{"","","","",""},
                      {"","","","",""},{"","","","",""},{"","","","",""},
                      {"","","","",""},{"","","","",""},{"","","","",""},
                      {"","","","",""},{"","","","",""},{"","","","",""},
                      {"","","","",""},{"","","","",""},{"","","","",""},
                      {"","","","",""},{"","","","",""},{"","","","",""},
                      {"","","","",""},{"","","","",""},{"","","","",""},
                      {"","","","",""},{"","","","",""},{"","","","",""},
                      {"","","","",""},{"","","","",""},{"","","","",""},{"","","","",""}};    
            String column[]={"First Name","Last Name","User Name","ID","Age"};         
            final JTable jt=new JTable(data,column);                  
            JScrollPane sp=new JScrollPane(jt);    
            sp.setBounds(80,100 ,690,555 );
            jt.setBackground(Color.decode("#9dc3be")); 
            jt.setBorder(BorderFactory.createLineBorder(Color.decode("#2c655d")));
            
             Employee e = new Employee();
           ArrayList<Employee> employees = new ArrayList<Employee>();
           employees = e.loadFromFileArr();
           int i = 0 ;
        for (Employee x : employees) {
            data[i][0] = x.getfName();
            data[i][1] =x.getlName();                               
            data[i][2] = x.getUserName();
            data[i][3] = Integer.toString(x.getId());
          data[i][4] = Integer.toString(x.getAge());
          
          
             i++; } 
/***********************************************************************/
   //Panel2_Separator
   JSeparator S;
   S=new JSeparator();
   S.setBounds(360,70 , 150,30 );
/***********************************************************************/
   //Panel2_Labels
   JLabel P2_Lb;
   P2_Lb=new JLabel("**Employee Data**");
   P2_Lb.setBounds(370,30,200,30);
/***********************************************************************/

        //Panel2_Adds
        f.add(P2_Lb);
        f.add(S);
        f.add(sp);
        f.add(Dynamic_panel_LisEmployee);
       
/***********************************************************************/
    }
    
}