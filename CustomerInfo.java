package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils; // Ensure you have this import
import java.awt.event.*;

public class CustomerInfo extends JFrame implements ActionListener {
    
    JTable table;
    JButton back;

    CustomerInfo() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

       
        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(10, 10, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Number");
        l2.setBounds(160, 10, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(290, 10, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(410, 10, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel("Country");
        l5.setBounds(540, 10, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Room Number");
        l6.setBounds(640, 10, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel("Checkin time");
        l7.setBounds(760, 10, 100, 20);
        add(l7);
        
        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(900, 10, 100, 20);
        add(l8);
        
        
        
        
        // Create JTable and set it inside a JScrollPane
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table); // Add table to JScrollPane
        scrollPane.setBounds(0, 40, 1000, 400); // Set bounds for JScrollPane
        add(scrollPane); // Add JScrollPane to the JFrame
        
        // Load data into the table
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM  customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Create back button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(420, 500, 120, 30);
        add(back);
        
        // Frame settings
        setBounds(300, 200, 1000, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Optional: to close the application properly
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception(); // Assuming Reception is another JFrame
    }
    
    public static void main(String[] args) {
        new CustomerInfo();
    }
}

