package oasis.hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    Dashboard() {
    
        setBounds(-8 ,0,1550, 1000);
        ImageIcon dashboard = new ImageIcon(ClassLoader.getSystemResource("images/dashboard.png"));
        Image dashboard_img = dashboard.getImage().getScaledInstance(1550,1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(dashboard_img);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);
        
        JMenuBar menu1 = new JMenuBar();
        menu1.setBounds(0, 0, 2550, 30);
        image.add(menu1);
        
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        menu1.add(hotel);
        
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
         
        JMenu admin = new JMenu("ADMIN");
        menu1.add(admin);
        
        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);

        setVisible(true);
    
    }
    
    
    
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        }
        else if (ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
        }
        else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }
    
   public static void main(String[] args) {
        new Dashboard();      
    }
    
}
