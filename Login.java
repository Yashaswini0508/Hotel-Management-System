
package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password; // Use JPasswordField for password input
    JButton login, cancel;

    Login() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel user = new JLabel("Username:");
        user.setBounds(40, 20, 100, 30);
        add(user);

        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);

        JLabel pass = new JLabel("Password:");
        pass.setBounds(40, 70, 100, 30);
        add(pass);

        password = new JPasswordField(); // Use JPasswordField for password
        password.setBounds(150, 70, 150, 30);
        add(password);

        login = new JButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        add(login);
        login.addActionListener(this);

        cancel = new JButton("Cancel");
        cancel.setBounds(180, 150, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);

        setBounds(500, 200, 600, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Close operation
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String user = username.getText();
            String pass = new String(password.getPassword()); // Get password as String

            try {
                Conn c = new Conn(); // Create a new Conn object
                // Use PreparedStatement to avoid SQL injection
                String query = "SELECT * FROM login WHERE username = ? AND password = ?";
                PreparedStatement stmt = c.c.prepareStatement(query);
                stmt.setString(1, user); // Set username
                stmt.setString(2, pass); // Set password

                ResultSet rs = stmt.executeQuery(); // Execute query

                if (rs.next()) {
                    setVisible(false);
                    new Dashboard(); // Ensure Dashboard class is correctly defined
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
