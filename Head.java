package airline.handlers;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class Head extends JFrame implements ActionListener{

    JButton create, back;
    
    JTextField username, name, password;
    Head(){
        
        setBounds(450, 150, 700, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 650, 300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(172, 216, 230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel);
        
        JLabel heading = new JLabel("Create Account For Employee");
        heading.setBounds(100 , 50, 300, 20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(heading);
        
        
          
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100, 170, 140, 20);
        lblname.setForeground(Color.GRAY);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblname);
        
        name = new JTextField();
        name.setBounds(260, 170, 150, 20);
        panel.add(name);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(100, 130, 140, 20);
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblusername);
        
        username = new JTextField();
        username.setBounds(260, 130, 150, 20);
        panel.add(username);
      
        
        
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(100, 210, 140, 20);
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblpassword);
        
        password = new JTextField();
        password.setBounds(260, 210, 150, 20);
        panel.add(password);
        
        
        
        create = new JButton("Create");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setBounds(140, 260, 120, 25);
        create.addActionListener(this);
        panel.add(create);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 260, 120, 25);
        back.addActionListener(this);
        panel.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/handlers/icon/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(415, 30, 250, 250);
        panel.add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
           String sname = name.getText();
            String susername = username.getText();
            String spassword = password.getText();
           
           
            try {
                Conn c = new Conn();
                
                String query ;
                
                    query = "insert into employee_login values( '"+sname+"', '"+susername+"', '"+spassword+"')";
                
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                
                setVisible(false);
               
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            
           
        }
    }

    public static void main(String[] args) {
        new Head();
    }
}