/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giutestcase;

import Resturant.Customer;
import Resturant.Employee;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author meshm
 */
public class CustumerUpdateDelete extends JPanel implements ActionListener {

    JLabel jLabelEmp1, jLabelEmp2, jLabelEmp3, jLabelEmp4, jLabelEmp5, jLabelEmp6, jLabelEmp7, jLabelEmp8 ,jLabelEmp9 ,jlUpdateDeletEmp;
    JTextField jtfEFname, jtfELname, jtfEAge, jtfEAddress, jtfERward, jtfEGifts , jtfEOldId;
    //fname , lname , id , age , address , salary , username , password;
    JButton addEmpSubmit, ResetButton , Searchbtn , Deletebtn;
    
    
    public CustumerUpdateDelete() {
         setBackground(Color.BLUE);
        
        
        jlUpdateDeletEmp = new JLabel("Update and Delete Customer ... !");
        jlUpdateDeletEmp.setFont(new Font("Stencil", 0, 18));
        jlUpdateDeletEmp.setBounds(40, 30, 350, 19);
        
        

        jLabelEmp9 = new JLabel("Customer old ID ");
        jLabelEmp9.setFont(new Font("Ravie", 0, 13));
        jLabelEmp9.setBounds(90, 80, 120, 30);
        
        
        jLabelEmp1 = new JLabel("First Name ");
        jLabelEmp1.setFont(new Font("Ravie", 0, 13));
        jLabelEmp1.setBounds(90, 130, 120, 30);

        jLabelEmp2 = new JLabel("Last Name ");
        jLabelEmp2.setFont(new Font("Ravie", 0, 13));
        jLabelEmp2.setBounds(90, 180, 120, 30);


        jLabelEmp4 = new JLabel("Age ");
        jLabelEmp4.setFont(new Font("Ravie", 0, 13));
        jLabelEmp4.setBounds(90, 230, 120, 30);

        jLabelEmp5 = new JLabel("Address ");
        jLabelEmp5.setFont(new Font("Ravie", 0, 13));
        jLabelEmp5.setBounds(90, 280, 120, 30);

        jLabelEmp6 = new JLabel("Join RD ? (t)(f)  ");
        jLabelEmp6.setFont(new Font("Ravie", 0, 13));
        jLabelEmp6.setBounds(90, 330, 120, 30);

        jLabelEmp7 = new JLabel("Has Gifts ? ");
        jLabelEmp7.setFont(new Font("Ravie", 0, 13));
        jLabelEmp7.setBounds(90, 380, 120, 30);

        

        //Fields
        
        jtfEOldId = new JTextField();
        jtfEOldId.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfEOldId.setBounds(240, 80, 120, 22);
        
        jtfEFname = new JTextField();
        jtfEFname.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfEFname.setBounds(240, 130, 270, 22);
       

        jtfELname = new JTextField();
        jtfELname.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfELname.setBounds(240, 180, 270, 22);

       
        jtfEAge = new JTextField();
        jtfEAge.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfEAge.setBounds(240, 230, 270, 22);

        jtfEAddress = new JTextField();
        jtfEAddress.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfEAddress.setBounds(240, 280, 270, 22);

        jtfERward = new JTextField();
        jtfERward.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfERward.setBounds(240, 330, 270, 22);

        jtfEGifts = new JTextField();
        jtfEGifts.setFont(new java.awt.Font("Rockwell", 0, 14));
        jtfEGifts.setBounds(240, 380, 270, 22);

        

        //Buttons
        addEmpSubmit = new JButton("Submit Update");
        addEmpSubmit.setBounds(260, 480, 220, 30);
        addEmpSubmit.addActionListener(this);

        ResetButton = new JButton("Reset");
        ResetButton.setBounds(535, 550, 100, 23);
        ResetButton.addActionListener(this);
        
        Searchbtn = new JButton("Search");
        Searchbtn.setBounds(480, 80, 80, 23);
        Searchbtn.addActionListener(this);
        
        Deletebtn = new JButton("Delete");
        Deletebtn.setBounds(380, 80, 80, 23);
        Deletebtn.addActionListener(this);

        
        
        
        add(Searchbtn);
        add(Deletebtn);
        add(jtfEOldId);
        add(jLabelEmp9);
        add(jlUpdateDeletEmp);
        add(jLabelEmp1);
        add(jLabelEmp2);
        add(jLabelEmp4);
        add(jLabelEmp5);
        add(jLabelEmp6);
        add(jLabelEmp7);
        add(jtfEFname);
        add(jtfELname);
        add(jtfEAge);
        add(jtfEAddress);
        add(jtfERward);
        add(jtfEGifts);
        add(ResetButton);
        add(addEmpSubmit);
        setVisible(true);
        
        
    }

   @Override
    public void actionPerformed(ActionEvent e) {
        Customer oldCust = new Customer();
         
        if (e.getSource() == ResetButton) {
           resetData();
        } else if (e.getSource() == addEmpSubmit) {

            if (!jtfEFname.getText().equals("") && !jtfELname.getText().equals("") && !jtfEOldId.getText().equals("") && !jtfEAge.getText().equals("")
                    && !jtfEAddress.getText().equals("") && !jtfERward.getText().equals("") && !jtfEGifts.getText().equals("") ) {
               try{
                oldCust.setGifts(jtfEGifts.getText());
                oldCust.setAddress(jtfEAddress.getText());
                oldCust.setAge(Integer.parseInt(jtfEAge.getText()));
                oldCust.setfName(jtfEFname.getText());
                oldCust.setlName(jtfELname.getText());
                oldCust.setRewardProgram(Boolean.parseBoolean(jtfERward.getText()));
                
                
                  if (oldCust.updateCustomer(Integer.parseInt(jtfEOldId.getText()), oldCust) && !jtfEAddress.getText().equals("") || !jtfEGifts.getText().equals("")
                        || !jtfEAge.getText().equals("") || !jtfEFname.getText().equals("") || !jtfELname.getText().equals("") || !jtfERward.getText().equals("") || !jtfEOldId.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Custmer Added Successfully!");
                    resetData();
            }
                }catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, "Failed to Update Custmer!");
                }
                
               
            }else {
                JOptionPane.showMessageDialog(null, "Please Enter Data!");
        }
        
        }else if(e.getSource()== Deletebtn){
            
            if(!jtfEOldId.getText().equals(""))
        {   
            Customer cust2 = new Customer();
            if (cust2.deleteCustomer(Integer.parseInt(jtfEOldId.getText())))     
            {
                JOptionPane.showMessageDialog(null, "Customer Deleted Successfully!");
                resetData();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Failed to Delete Customer!");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null ,"Missing required Fields ... !  Please, Search By ID ...");
        }
         
         }else if(e.getSource()==Searchbtn){
             
             if(!jtfEOldId.getText().equals(""))
        {   
            Customer cust3 = new Customer();
            Customer returned = cust3.searchCustomerOrder(Integer.parseInt(jtfEOldId.getText()));
            if (returned.getId()>0)
            {
                JOptionPane.showMessageDialog(null, "Found .. !");
                setPanelData(returned);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Not Found .. !");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null ,"Missing required Fields ... !  Please, Search By ID ...");
        }
             
         }
            
        

    }

public void resetData(){
            jtfEFname.setText("");
            jtfELname.setText("");
            jtfEOldId.setText("");
            jtfEAge.setText("");
            jtfEAddress.setText("");
            jtfERward.setText("");
            jtfEGifts.setText("");
        }
    public void setPanelData(Customer emp)
    {
        jtfEFname.setText(""+emp.getfName());
        jtfELname.setText(""+emp.getlName());
        jtfEOldId.setText(""+emp.getId());
        jtfEAge.setText(""+emp.getAge());
        jtfEGifts.setText(""+emp.getGifts());
        jtfEAddress.setText(""+emp.getAddress());
        jtfERward.setText(""+emp.isRewardProgram());
        
    }
    
}
