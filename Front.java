
package airline.handlers;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Front extends JFrame implements ActionListener {
    
    Front(){
    setExtendedState(JFrame.MAXIMIZED_BOTH);
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/handlers/icons/aero4.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
       
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
        JMenu head = new JMenu(" Head Department ");
        mb.add(head);
         
        JMenuItem login = new JMenuItem(" Head Login ");
        login.addActionListener(this);
        head.add(login);
        
         
        JMenu employee = new JMenu(" Employee Login ");
        mb.add(employee);
         
         JMenuItem loginin = new JMenuItem(" Login ");
        loginin.addActionListener(this);
        employee.add(loginin); 
        
         JMenu status = new JMenu(" Check Ticket Status ");
         mb.add(status); 
         
          
        
        JMenuItem cancel = new JMenuItem(" Cancel Ticket ");
        cancel.addActionListener(this);
        status.add(cancel);  
         
        JMenuItem bp = new JMenuItem(" Boarding Pass ");
        bp.addActionListener(this);
        status.add(bp); 
        
        JMenu logout = new JMenu("Logout");
        mb.add(logout);
         
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        logout.add(exit);
        
        
     setLayout(new FlowLayout());
     setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        switch (text) {
            case " Head Login ":
                new Login();
                break;
            case " Login ":
                new employee();
                break;
            case " Cancel Ticket ":
                new Cancel();
                break;
            case " Boarding Pass ":
                new BoardingPass();
                break;
            case "Exit":
                setVisible(false); 
            default:
                break;
        }
    }
    
    public static void main(String[] args) {
        new Front();
    }

}
