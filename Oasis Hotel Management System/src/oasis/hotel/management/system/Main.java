package oasis.hotel.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener{
    Main(){
        setSize(800, 565);
        setLocation(250, 100);
        
        ImageIcon homepage = new ImageIcon(ClassLoader.getSystemResource("images/homepage.png"));
        JLabel image = new JLabel(homepage);
        add(image);
        
        JButton proceed = new JButton("Proceed to Login");
        proceed.setBounds(300, 400, 150, 50);
        proceed.setBackground(Color.WHITE);
        proceed.addActionListener(this);
        image.add(proceed);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args) {
        new Main();
        
    }
    
}
