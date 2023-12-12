package oasis.hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener{
    
    Department(){
        JTable table;
        JButton back;
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        /*ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("images/room.png"));
        JLabel image = new JLabel(background);
        image.setBounds(0, 0, 600, 600)
        add(image);*/
        
        JLabel department = new JLabel("Department");
        department.setBounds(180, 10, 100, 20);
        add(department);
        
        JLabel budget = new JLabel("Budget");
        budget.setBounds(420, 10, 100, 20);
        add(budget);
        
        table = new JTable();
        table.setBounds(0, 50, 700, 350);
        add(table);
        
        try{
            
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(300, 400, 120, 30);
        add(back);
        
        setBounds(300, 150, 700, 480);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args){
        new Department();
    }
    
}
