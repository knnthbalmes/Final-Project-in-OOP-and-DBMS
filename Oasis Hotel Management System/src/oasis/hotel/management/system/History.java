package oasis.hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class History extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    History(){
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        /*ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("images/room.png"));
        JLabel image = new JLabel(background);
        image.setBounds(0, 0, 600, 600)
        add(image);*/
        
        JLabel name = new JLabel("Name");
        name.setBounds(10, 10, 100, 20);
        add(name);
        
        JLabel number = new JLabel("Number");
        number.setBounds(200, 10, 100, 20);
        add(number);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(360, 10, 100, 20);
        add(gender);
        
        JLabel country = new JLabel("Country");
        country.setBounds(530, 10, 100, 20);
        add(country);
        
        JLabel roomNumber = new JLabel("Room Number");
        roomNumber.setBounds(680, 10, 100, 20);
        add(roomNumber);
        
        JLabel checkin = new JLabel("Check-in");
        checkin.setBounds(855, 10, 100, 20);
        add(checkin);
        
        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);
        
        try{
            
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from history");
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
        
        setBounds(150, 70, 990, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args){
        new History();
    }
    
}