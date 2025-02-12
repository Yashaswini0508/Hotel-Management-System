package hotelmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddDriver extends JFrame implements ActionListener {
    
    JButton add, cancel;
    JTextField tfname, tfage, tfcompany, tfmodel, tflocation;
    JComboBox<String> availablecombo, gendercombo;
    
    AddDriver() {
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 10, 200, 20);
        add(heading);
        
        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblName.setBounds(60, 60, 120, 30);
        add(lblName);
        
        tfname = new JTextField();
        tfname.setBounds(200, 60, 150, 30);
        add(tfname);
        
        JLabel lblAge = new JLabel("Age");
        lblAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAge.setBounds(60, 100, 120, 30);
        add(lblAge);
        
        tfage = new JTextField();
        tfage.setBounds(200, 100, 120, 30);
        add(tfage);
        
        JLabel lblGender = new JLabel("Gender");
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblGender.setBounds(60, 150, 120, 30);
        add(lblGender);
        
        String[] genderOptions = {"Male", "Female"};
        gendercombo = new JComboBox<>(genderOptions);
        gendercombo.setBounds(200, 150, 150, 30);
        add(gendercombo);
        
        JLabel lblCompany = new JLabel("Car Company");
        lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCompany.setBounds(60, 190, 120, 30);
        add(lblCompany);
        
        tfcompany = new JTextField();
        tfcompany.setBounds(200, 190, 150, 30);
        add(tfcompany);
        
        JLabel lblModel = new JLabel("Car Model");
        lblModel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblModel.setBounds(60, 230, 120, 30);
        add(lblModel);
        
        tfmodel = new JTextField();
        tfmodel.setBounds(200, 230, 150, 30);
        add(tfmodel);
        
        JLabel lblAvailable = new JLabel("Available");
        lblAvailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAvailable.setBounds(60, 270, 120, 30);
        add(lblAvailable);
        
        String[] availabilityOptions = {"Available", "Busy"};
        availablecombo = new JComboBox<>(availabilityOptions);
        availablecombo.setBounds(200, 270, 150, 30);
        add(availablecombo);
        
        JLabel lblLocation = new JLabel("Location");
        lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblLocation.setBounds(60, 310, 120, 30);
        add(lblLocation);
        
        tflocation = new JTextField();
        tflocation.setBounds(200, 310, 150, 30);
        add(tflocation);
        
        add = new JButton("Add Driver");
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.setBounds(60, 370, 130, 30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setBounds(220, 370, 130, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        // Add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
        setBounds(300, 200, 980, 470);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) gendercombo.getSelectedItem();
            String company = tfcompany.getText();
            String brand = tfmodel.getText();
            String available = (String) availablecombo.getSelectedItem();
            String location = tflocation.getText();
            
            try {
                Conn conn = new Conn();
                String str = "INSERT INTO driver (name, age, gender, company, brand, available, location) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = conn.c.prepareStatement(str);
                pst.setString(1, name);
                pst.setString(2, age);
                pst.setString(3, gender);
                pst.setString(4, company);
                pst.setString(5, brand);
                pst.setString(6, available);
                pst.setString(7, location);
                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddDriver();
    }
}

class Conn {
    Connection c;

    public Conn() {
        try {
            // Update these credentials according to your setup
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOTELMANAGEMENTSYSTEM", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
