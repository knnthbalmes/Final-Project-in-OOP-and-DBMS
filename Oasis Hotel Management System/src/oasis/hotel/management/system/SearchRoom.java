package oasis.hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener{
    
    JTable table;
    JButton back, submit;
    JComboBox roomType;
    JCheckBox available;
    SearchRoom(){
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        /*ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("images/room.png"));
        JLabel image = new JLabel(background);
        image.setBounds(0, 0, 600, 600)
        add(image);*/
        
        JLabel text = new JLabel ("Search for Rooms");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds (400,30,200,30);
        add(text);
        
        JLabel room = new JLabel ("Room Type");
        room.setBounds (50, 100, 100, 20);
        add(room); 
        
        roomType = new JComboBox(new String []{"Standard Room", "Deluxe Room", "Family Room", "Suite"});
        roomType.setBounds(150, 100,150, 25);
        roomType.setBackground(Color.WHITE);
        add(roomType);
        
        available = new JCheckBox("Only Display Available");
        available.setBounds(650,100,150,25);
        available.setBackground (Color.WHITE);
        add(available);
        
        
        
        JLabel roomNumber = new JLabel("Room Number");
        roomNumber.setBounds(10, 160, 100, 20);
        add(roomNumber);
        
        JLabel roomAvailability = new JLabel("Availability");
        roomAvailability.setBounds(270, 160, 100, 20);
        add(roomAvailability);
        
        JLabel status = new JLabel("Room Number");
        status.setBounds(450, 160, 100, 20);
        add(status);
        
        JLabel price = new JLabel("Price");
        price.setBounds(670, 160, 100, 20);
        add(price);
        
        JLabel roomType = new JLabel("Room Type");
        roomType.setBounds(870, 160, 100, 20);
        add(roomType);
        
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
        try{
            
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(300, 520, 120, 30);
        add(submit);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(500, 520, 120, 30);
        add(back);
        
        setBounds(150, 50, 1000, 600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== submit) {
            try {
                String query1 = "select * from room where roomType = '"+roomType.getSelectedItem()+"'";
                String query2 = "select * from room where availability = 'Available' AND roomType = '"+roomType.getSelectedItem()+"'";
                
                
                Conn conn = new Conn ();
                ResultSet rs;
                if (available.isSelected()) {
                    rs = conn.s.executeQuery(query2);
                
                } else {
                    rs = conn.s.executeQuery(query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new SearchRoom();
    }
    
}
