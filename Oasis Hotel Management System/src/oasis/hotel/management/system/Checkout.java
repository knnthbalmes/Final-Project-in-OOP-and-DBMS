package oasis.hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class Checkout extends JFrame implements ActionListener{
  
    Choice ccustomer;
    JLabel lblroomnumber, lblcheckintime, lblcheckouttime;
    JButton checkout, back;
    Checkout() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Checkout");
        text.setBounds(100, 20, 100, 30);
        text.setForeground(Color.BLACK);
        text.setFont(new Font ("Tahoma", Font.PLAIN, 20));
        add(text);
        
        JLabel lblid = new JLabel("Customer Id");
        text.setBounds(30, 80, 100, 30);
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(150, 80, 150, 25 );
        add(ccustomer);
        
        ImageIcon updateCheckout = new ImageIcon (ClassLoader.getSystemResource("images/logo.png"));
        JLabel background = new JLabel(updateCheckout);
        background.setBounds(150, -80, 500, 500);
        add(background);
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 130, 100, 30);
        add(lblroom);
        
        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150, 130, 100, 30);
        add(lblroomnumber);
                
        JLabel lblcheckin = new JLabel("Check-in Time");
        lblcheckin.setBounds(30, 180, 100, 30);
        add(lblcheckin);
        
        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150, 180, 100, 30);
        add(lblcheckintime);
        
        JLabel lblcheckout = new JLabel("Checkout Time");
        lblcheckout.setBounds(30, 230, 100, 30);
        add(lblcheckout);
        
        Date date = new Date();
        
        lblcheckouttime = new JLabel("" + date);
        lblcheckouttime.setBounds(150, 230, 150, 30);
        add(lblcheckouttime);
                
        checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(30, 280, 120, 30);
        checkout.addActionListener(this);
        add(checkout);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(170, 280, 120, 30);
        back.addActionListener(this);
        add(back);
        
         try{
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from customer");
           while(rs.next()) {
               ccustomer.add(rs.getString("name"));
               lblroomnumber.setText(rs.getString("room"));
               lblcheckintime.setText(rs.getString("checkin_time"));
           }
        } catch (Exception e){
            e.printStackTrace();
        }     
        
        setBounds(400, 150, 550, 400);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        
        String checkouttime = lblcheckouttime.getText();
        
        if (ae.getSource() == checkout) {
            String query1 = "delete from customer where name = '"+ccustomer.getSelectedItem()+"'";
            String query2 = "update room set availability = 'Available' where roomnumber = '"+lblroomnumber.getText()+"'";
        
         try {
             Conn c = new Conn ();
             c.s.executeUpdate(query1);
             c.s.executeUpdate(query2);
             
             JOptionPane.showMessageDialog(null, "Checkout done");
             
            setVisible(false);
            new Reception();
         }   catch (Exception e) {
             e.printStackTrace();
         }                      
     } else {
            setVisible(false);
            new Reception();
        }
     }
    public static void main(String[] args) {
        new Checkout();
    }
}