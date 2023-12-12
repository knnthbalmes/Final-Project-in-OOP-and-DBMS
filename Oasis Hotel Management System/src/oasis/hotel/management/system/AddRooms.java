package oasis.hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddRooms extends JFrame implements ActionListener{
    
    JButton add, cancel;
    JTextField tfroom, tfprice;
    JComboBox availablecombo, cleancombo, roomcombo;
    
    
    AddRooms(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        JLabel roomNum = new JLabel("Room Number");
        roomNum.setFont(new Font("Tahoma", Font.PLAIN, 18));
        roomNum.setBounds(60, 80, 120, 30);
        add(roomNum);
        
        JLabel roomAvailability = new JLabel("Available");
        roomAvailability.setFont(new Font("Tahoma", Font.PLAIN, 18));
        roomAvailability.setBounds(60, 130, 120, 30);
        add(roomAvailability);
        
        String availableOptions[] = {"Available", "Occupied"};
        availablecombo = new JComboBox(availableOptions);
        availablecombo.setBounds(200, 130, 150, 30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        JLabel roomClean = new JLabel("Status");
        roomClean.setFont(new Font("Tahoma", Font.PLAIN, 18));
        roomClean.setBounds(60, 180, 120, 30);
        add(roomClean);
        
        String cleanOptions[] = {"Clean", "Dirty"};
        cleancombo = new JComboBox(cleanOptions);
        cleancombo.setBounds(200, 180, 150, 30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);
        
        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 150, 30);
        add(tfroom);
        
        JLabel roomType = new JLabel("Room Type");
        roomType.setFont(new Font("Tahoma", Font.PLAIN, 18));
        roomType.setBounds(60, 230, 120, 30);
        add(roomType);
        
        String roomOptions[] = {"Standard Room", "Deluxe Room", "Family Room", "Suite"};
        roomcombo = new JComboBox(roomOptions);
        roomcombo.setBounds(200, 230, 150, 30);
        roomcombo.setBackground(Color.WHITE);
        add(roomcombo);
        
        JLabel roomPrice = new JLabel("Price");
        roomPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
        roomPrice.setBounds(60, 280, 120, 30);
        add(roomPrice);
        
        tfprice = new JTextField();
        tfprice.setBounds(200, 280, 150, 30);
        tfprice.setEditable(false);
        
        add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 350, 130, 30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 350, 130, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon add_rooms = new ImageIcon(ClassLoader.getSystemResource("images/add_rooms.png"));
        JLabel image = new JLabel(add_rooms);
        image.setBounds(0, 0, 940, 470);
        add(image);
        
        setBounds(180, 130, 940, 470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String room_Type = (String) roomcombo.getSelectedItem();
           
            switch (room_Type) {
                case "Standard Room":
                    tfprice.setText("2500");
                    add(tfprice);
                    break;
                case "Deluxe Room":
                    tfprice.setText("3000");
                    add(tfprice);
                    break;
                case "Family Room":
                    tfprice.setText("4000");
                    add(tfprice);
                    break;
                case "Suite":
                    tfprice.setText("5500");
                    add(tfprice);
                    break;
                default:
                    break;
            }
        
        if(ae.getSource() == add){
           String roomNum = tfroom.getText();
           String roomAvailability = (String) availablecombo.getSelectedItem();
           String roomClean = (String) cleancombo.getSelectedItem();
           String roomPrice = tfprice.getText();
           
           
           try{
               Conn conn = new Conn();
               
               String duplication = "select * from room where roomNumber ='" + roomNum +"'";
               ResultSet rs = conn.s.executeQuery(duplication);
               
               if(rs.next()){
                   JOptionPane.showMessageDialog(this, "Room: '" + roomNum + "' Already Exists!");
                   tfroom.setText("");
               } else {
                   
                   String query = "insert into room values('" + roomNum +"', '" + roomAvailability + "', '" + roomClean + "', '" + roomPrice + "', '" + room_Type + "')";
                   conn.s.executeUpdate(query);
               
                    JOptionPane.showMessageDialog(null, "Room Added Successfully!");
               
                    setVisible(false);
                   
               }
           } catch (Exception e){
               
               e.printStackTrace();
           }
           
        } else {
            setVisible(false);
        }
        
    }
    
    public static void main(String[] args){
        new AddRooms();
    }
}
