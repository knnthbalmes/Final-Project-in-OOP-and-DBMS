package oasis.hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField username;
    JPasswordField password;
    JButton login, cancel;
    
    Login(){
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        JLabel user = new JLabel("Enter Admin Username:");
        user.setBounds(40, 20, 200, 30);
        add(user);
        
        username = new JTextField();
        username.setBounds(40, 50, 150, 30);
        add(username);
        
        JLabel pass = new JLabel("Enter Password:");
        pass.setBounds(40, 80, 200, 30);
        add(pass);
        
        password = new JPasswordField();
        password.setBounds(40, 111, 150, 30);
        add(password);
        
        login = new JButton("Login");
        login.setBounds(50, 160, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(50, 195, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("images/logo.png"));
        JLabel img_logo = new JLabel(logo);
        img_logo.setBounds(200, 10, 250, 250);
        add(img_logo);
        
        setBounds(420, 200, 450, 300);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            String user = username.getText();
            String pass = password.getText();
            
            try{
                Conn c = new Conn();
                
                String query = "select * from login where username = '" + user + "'and password = '" + pass + "'";
                
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new Dashboard();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                    setVisible(false);
                    new Login();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
}
