/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giutestcase;

import Resturant.Employee;
import Resturant.Meals;
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
public class ListMeals {

    public ListMeals() {
   
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
            String column[]={"Meal Name","Meal Price","Meal ID"};         
            final JTable jt=new JTable(data,column);                  
            JScrollPane sp=new JScrollPane(jt);    
            sp.setBounds(80,100 ,690,555 );
            jt.setBackground(Color.decode("#9dc3be")); 
            jt.setBorder(BorderFactory.createLineBorder(Color.decode("#2c655d")));
            
             Meals e = new Meals();
           ArrayList<Meals> mel = new ArrayList<Meals>();
           mel = e.loadFromFileArr();
           int i = 0 ;
        for (Meals x : mel) {
            data[i][0] = x.getMealName();
            data[i][1] =Double.toString(x.getMealPrice());                               
            data[i][2] = Integer.toString(x.getMealId());
            
          
          
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