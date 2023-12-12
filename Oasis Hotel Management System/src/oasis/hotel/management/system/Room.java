package oasis.hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener{
    
    Room(){
        JTable table;
        JButton back;
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Rooms");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(250, 20, 200, 30);
        text.setForeground(Color.BLACK);
        add(text);
        
        JLabel roomNumber = new JLabel("Room Number");
        roomNumber.setBounds(40, 55, 100, 20);
        add(roomNumber);
        
        JLabel roomAvailability = new JLabel("Availability");
        roomAvailability.setBounds(160, 55, 100, 20);
        add(roomAvailability);
        
        JLabel status = new JLabel("Status");
        status.setBounds(270, 55, 100, 20);
        add(status);
        
        JLabel price = new JLabel("Price");
        price.setBounds(370, 55, 100, 20);
        add(price);
        
        JLabel bedType = new JLabel("Room Type");
        bedType.setBounds(450, 55, 100, 20);
        add(bedType);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(200, 500, 120, 30);
        add(back);
        
        table = new JTable();
        table.setBounds(40, 90, 500, 400);
        add(table);
        
        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("images/rooms.png"));
        JLabel image = new JLabel(background);
        image.setBounds(0, 0, 1050, 600);
        add(image);
        
        try{
            
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }
        
        setBounds(150, 50, 1050, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args){
        new Room();
    }
    
}
