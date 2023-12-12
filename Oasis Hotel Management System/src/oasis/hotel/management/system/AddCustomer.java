package oasis.hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox comboid;
    JTextField tfnumber, tfname, tfcountry, tfroom, tfdeposit;
    JRadioButton rmale, rfemale;
    Choice croom;
    JLabel lbltimein, checkin_time;
    JButton add, back;
    
    AddCustomer(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        /* JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100, 20, 300, 30);
        text.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(text); */
        
        
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35, 120, 100, 20);
        lblname.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 120, 150, 25);
        add(tfname);
        
        JLabel lblnumber = new JLabel("Number        +63");
        lblnumber.setBounds(35, 160, 150, 20);
        lblnumber.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblnumber); 
        
        tfnumber = new JTextField();
        tfnumber.setBounds(200, 160, 150, 25);
        add(tfnumber);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(35, 200, 100, 20);
        lblgender.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblgender); 
        
        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200, 200, 60, 25);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270, 200, 100, 25);
        add(rfemale);
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(35, 240, 100, 20);
        lblcountry.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(200, 240, 150, 25);
        add(tfcountry);
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(35, 280, 150, 20);
        lblroom.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblroom);
        
        croom = new Choice();
        
        try{
            
            Conn conn = new Conn();
            String query = "select * from room where availability <> 'Occupied'";
            conn.s.executeQuery(query);
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomNumber"));
            }
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        
        croom.setBounds(200, 280, 150, 25);
        add(croom);
        
        lbltimein = new JLabel("Check-in Time");
        lbltimein.setBounds(35, 320, 150, 18);
        lbltimein.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lbltimein);
        
        Date date = new Date();
        
        checkin_time = new JLabel("" + date);
        checkin_time.setBounds(200, 320, 120, 25);
        checkin_time.setFont(new Font("Raleway", Font.PLAIN, 10));
        add(checkin_time);
        
        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(35, 360, 100, 20);
        lbldeposit.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lbldeposit);
        
        tfdeposit = new JTextField();
        tfdeposit.setBounds(200, 360, 150, 25);
        add(tfdeposit);
        
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50, 410, 120, 30);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(260, 410, 120, 30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("images/add_customer.png"));
        JLabel image = new JLabel(background);
        image.setBounds(0, 0, 800, 550);
        add(image);
        
        setBounds(250, 100, 800, 550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == add){
            String name = tfname.getText();
            String number = tfnumber.getText();
            String gender = null;
            
            if(rmale.isSelected()){
                gender = "Male";
            } else{
                gender = "Female";
            }
            
            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkin_time.getText();
            String deposit = tfdeposit.getText();
            
            try{
                
                String query = "insert into customer values('" + name + "', '" + number + "', '" + gender + "', '" + country + "', '" + room + "', '" + time + "', '" + deposit + "')";
                String query2 = "insert into history values('" + name + "', '" + number + "', '" + gender + "', '" + country + "', '" + room + "', '" + time + "')";
                String query3 = "update room set availability = 'Occupied' where roomNumber = '" + room + "'";
                
                Conn conn = new Conn();
                
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "New Customer Added Successfully!");
                
                setVisible(false);
                new Reception();
                
            } catch (Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
        
    }
    
    public static void main(String[] args){
        new AddCustomer();
    }
}
