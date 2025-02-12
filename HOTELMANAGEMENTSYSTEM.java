
package hotelmanagementsystem;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HOTELMANAGEMENTSYSTEM extends JFrame implements ActionListener{

    HOTELMANAGEMENTSYSTEM() {
       // setSize(1366, 565);
       // setLocation(100, 100);
        setBounds(100,100,1366,565);
        setLayout(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application closes properly

        // Correct the file extension from .jp to .jpg
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        add(image);
        JLabel text =new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 430, 1000, 90);
        text.setForeground(Color.white);
        text.setFont(new Font("serif",Font.PLAIN,50));
        
        image.add(text);
        
        image.setBounds(0,0,1366,565);
        
        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        image.add(next);
        next.setBackground(Color.WHITE);
        
        next.addActionListener(this);
        
        next.setForeground(Color.MAGENTA);
        text.setFont(new Font("serif", Font.PLAIN, 24));
        
        
        setVisible(true);
        
        while(true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);
                
            } catch (Exception e) {
                e.printStackTrace();
               }
            text.setVisible(true);
            
            try {
                Thread.sleep(500);

            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
        
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
        
    }
    public static void main(String[] args) {
        new HOTELMANAGEMENTSYSTEM();
    }
}
