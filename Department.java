package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils; // Ensure you have this import
import java.awt.event.*;

public class Department extends JFrame implements ActionListener {
    
    JTable table;
    JButton back;

    Department() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        
        JLabel l1 = new JLabel("Department");
        l1.setBounds(180, 10, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Budget");
        l2.setBounds(420, 10, 100, 20);
        add(l2);
        
        
        
       
        
        // Create JTable and set it inside a JScrollPane
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table); // Add table to JScrollPane
        scrollPane.setBounds(0, 40, 700, 350); // Set bounds for JScrollPane
        add(scrollPane); // Add JScrollPane to the JFrame
        
        // Load data into the table
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Create back button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(280, 400, 120, 30);
        add(back);
        
        // Frame settings
        setBounds(400, 200, 700, 480);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Optional: to close the application properly
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception(); // Assuming Reception is another JFrame
    }
    
    public static void main(String[] args) {
        new Department();
    }
}
