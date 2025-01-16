
package airline.handlers;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread t;
    Splash() {
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/handlers/icons/aero2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        setVisible(true);
        
        int x = 1;
        for (int i = 2; i < 550; i+=4, x+=1) {
            setSize(i + x, i);
            setLocation(700 - ((i + x)/2), 400 - (i/2));
            try {
                Thread.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        t = new Thread(this);
        t.start();
        
        setVisible(true);
    }
    
    public void run() {
        try {
            Thread.sleep(4000);
            setVisible(false);
            
            // login frame
           new Front();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Splash();
    }
}

    

