package airline.handlers;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    JButton reset, close, submit;
    JPasswordField tfpassword;
    JTextField tfusername;
    Login(){
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
      setBounds(500, 130, 420, 270);  
      
      JLabel heading = new JLabel("Login");
      heading.setBounds(160, 0, 200, 20);
      heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
      heading.setForeground(Color.BLUE);
      add(heading);
        
       
      JLabel lblusername = new JLabel("Username");
      lblusername.setBounds(20,40,200,30);
      add(lblusername);
      
      tfusername = new JTextField();
      tfusername.setBounds(120, 40, 200, 22);
      add(tfusername);
        
      JLabel lblpassword = new JLabel("Password");
      lblpassword.setBounds(20,90,200,30);
      add(lblpassword);
      
      tfpassword = new JPasswordField();
      tfpassword.setBounds(120, 90, 200, 22);
      add(tfpassword);
      
      
      
      reset = new JButton("Reset");
      reset.setBounds(30,140,100,20);
      reset.setBackground(Color.GREEN);
      reset.setForeground(Color.BLACK);
      reset.addActionListener(this);
      add(reset);
      
      submit = new JButton("Submit");
      submit.setBounds(180,140,100,20);
      submit.setBackground(Color.GREEN);
      submit.setForeground(Color.BLACK);
      submit.addActionListener(this);
      add(submit);
      
      
      close = new JButton("Close");
      close.setBounds(110,180,100,20);
      close.setBackground(Color.GREEN);
      close.setForeground(Color.BLACK);
      close.addActionListener(this);
      add(close);
      
        setVisible(true);
    } 
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String username = tfusername.getText();
            String password = tfpassword.getText();
            try{
                Conn c = new Conn();
                
                String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
              ResultSet rs = c.s.executeQuery(query);
              if(rs.next()){
                  new Department();
                  setVisible(false);
              }else {
                  JOptionPane.showMessageDialog(null, "Invalid Username and Password");
                  setVisible(false);
              }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == reset){
            tfpassword.setText("");
            tfusername.setText("");
            
        }else if(ae.getSource() == close){
            setVisible(false);
        }
    }
    
    public static void main(String [] args){
        new Login();
    }
    
}
