package airline.handlers;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Department extends JFrame implements ActionListener {
    
    Department(){
    setExtendedState(JFrame.MAXIMIZED_BOTH);
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/handlers/icons/aero3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
       
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
         JMenu head = new JMenu(" Department ");
         mb.add(head);
         
         JMenuItem login = new JMenuItem(" Employee Entry ");
        login.addActionListener(this);
        head.add(login);
        
         
         
         JMenuItem loginin = new JMenuItem(" Employee details ");
        loginin.addActionListener(this);
        head.add(loginin); 
        
         
          JMenu exists = new JMenu("Logout");
        mb.add(exists);
       
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        exists.add(exit);
        
          
        
     setLayout(new FlowLayout());
     setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        
        switch (text) {
            case " Employee Entry ":
                new Head();
                break;
            case " Employee details ":
                new EmployeeInfo();
                break;
                case "Exit":
                new Front();
                break;
            default:
                break;
        }
    }
    
    public static void main(String[] args) {
        new Department();
    }

}

