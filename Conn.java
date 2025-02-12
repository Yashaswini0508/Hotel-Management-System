
package hotelmanagementsystem;

import java.sql.*;
import javax.swing.JOptionPane;  // Import JOptionPane

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            // Establish connection to the database
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "root");
            s = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error connecting to database: " + e.getMessage());
        }
    }
}
