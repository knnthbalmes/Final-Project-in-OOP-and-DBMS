package oasis.hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    EmployeeInfo(){
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        
        JLabel name = new JLabel("Name");
        name.setBounds(40, 10, 100, 20);
        add(name);
        
        JLabel age = new JLabel("Age");
        age.setBounds(170, 10, 100, 20);
        add(age);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(290, 10, 100, 20);
        add(gender);
        
        JLabel job = new JLabel("Job");
        job.setBounds(400, 10, 100, 20);
        add(job);
        
        JLabel salary = new JLabel("Salary");
        salary.setBounds(540, 10, 100, 20);
        add(salary);
        
        JLabel phone = new JLabel("Phone");
        phone.setBounds(670, 10, 100, 20);
        add(phone);
        
        JLabel email = new JLabel("Email");
        email.setBounds(790, 10, 100, 20);
        add(email);
        
        JLabel employeeID = new JLabel("Employee ID");
        employeeID.setBounds(910, 10, 100, 20);
        add(employeeID);
        
        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);
        
        try{
            
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from employee");
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
        new EmployeeInfo();
    }
    
}
