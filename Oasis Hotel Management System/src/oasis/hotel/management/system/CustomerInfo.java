package oasis.hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    CustomerInfo(){
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        /*ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("images/room.png"));
        JLabel image = new JLabel(background);
        image.setBounds(0, 0, 600, 600)
        add(image);*/
        
        JLabel document = new JLabel("Name");
        document.setBounds(10, 10, 100, 20);
        add(document);
        
        JLabel number = new JLabel("Number");
        number.setBounds(160, 10, 100, 20);
        add(number);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(320, 10, 100, 20);
        add(gender);
        
        JLabel country = new JLabel("Country");
        country.setBounds(450, 10, 100, 20);
        add(country);
        
        JLabel roomNumber = new JLabel("Room Number");
        roomNumber.setBounds(590, 10, 100, 20);
        add(roomNumber);
        
        JLabel checkin = new JLabel("Check-in Time");
        checkin.setBounds(735, 10, 100, 20);
        add(checkin);
        
        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(875, 10, 100, 20);
        add(deposit);
        
        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);
        
        try{
            
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(420, 500, 120, 30);
        add(back);
        
        setBounds(150, 50, 1000, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args){
        new CustomerInfo();
    }
    
}
 