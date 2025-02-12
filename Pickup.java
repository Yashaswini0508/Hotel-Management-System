package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils; // Ensure you have this import
import java.awt.event.*;

public class Pickup extends JFrame implements ActionListener {
    
    JTable table;
    JButton back, submit;
    Choice typeofcar;
    JCheckBox available;

    Pickup() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Pickup Service");
        text.setBounds(400, 30, 200, 30);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);
        
        JLabel lblbed = new JLabel("Type of Car");
        lblbed.setBounds(50, 100, 100, 20);
        add(lblbed);
        
        typeofcar = new Choice();
        typeofcar.setBounds(150, 100, 200, 25);
        add(typeofcar);
        
        // Load car brands into choice
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM driver");
            while (rs.next()) {
                typeofcar.add(rs.getString("brand"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Initialize and set bounds for the availability checkbox
        available = new JCheckBox("Available");
        available.setBounds(150, 130, 100, 25);
        add(available);
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(30, 160, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(150, 160, 100, 20); // Fixed position
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(330, 160, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Company");
        l4.setBounds(460, 160, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel("Brand");
        l5.setBounds(630, 160, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Availability");
        l6.setBounds(740, 160, 100, 20); // Fixed position
        add(l6);
        
        JLabel l7 = new JLabel("Location");
        l7.setBounds(890, 160, 100, 20); // Fixed position
        add(l7);
        
        // Create JTable and set it inside a JScrollPane
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 200, 1000, 300);
        add(scrollPane);
        
        // Load data into the table
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
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
        
        // Frame settings
        setBounds(300, 200, 1000, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submit) {
        try {
            String query = "SELECT * FROM driver WHERE brand = '" + typeofcar.getSelectedItem() + "'";

            // Add availability check if the checkbox is selected
            if (available.isSelected()) {
                query += " AND available = 'Yes'"; // Assuming 'Yes' is how you denote availability
            }

            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        setVisible(false);
        new Reception(); // Assuming Reception is another JFrame
    }
}

    public static void main(String[] args) {
        new Pickup();
    }
}
