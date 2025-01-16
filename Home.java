package airline.handlers;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Home extends JFrame implements ActionListener {

    Home() {
        setLayout(null);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/handlers/icons/aaa.jpg"));
        
        Image image = i1.getImage();
        Image scaledImage = image.getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(0, 0, screenSize.width, screenSize.height);
        
        add(imageLabel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel heading = new JLabel("AIR INDIA WELCOMES YOU");
        heading.setBounds(500, 40, 1000, 40);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 36));
        imageLabel.add(heading);

        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);

        JMenu customer = new JMenu("Customer");
        menubar.add(customer);

        JMenuItem customerdetails = new JMenuItem("Add Customer Details");
        customerdetails.addActionListener(this);
        customer.add(customerdetails);

        JMenu flight = new JMenu("Flight");
        menubar.add(flight);

        JMenuItem flightdetails = new JMenuItem("Flight Details");
        flightdetails.addActionListener(this);
        flight.add(flightdetails);

        JMenuItem bookflight = new JMenuItem("Book Flight");
        bookflight.addActionListener(this);
        flight.add(bookflight);

        JMenu details = new JMenu("Details");
        menubar.add(details);

        JMenuItem journeydetails = new JMenuItem("Journey Details");
        journeydetails.addActionListener(this);
        details.add(journeydetails);

        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);

        JMenuItem boardingpass = new JMenuItem("Borading Pass");
        boardingpass.addActionListener(this);
        ticket.add(boardingpass);

        JMenuItem ticketcancelation = new JMenuItem("Cancel Ticket");
        ticketcancelation.addActionListener(this);
        ticket.add(ticketcancelation);

        JMenu exits = new JMenu("Logout");
        exits.setForeground(Color.RED);
        menubar.add(exits);

        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(new Font("monospaced", Font.PLAIN, 12));
        exit.addActionListener(this);
        exit.setBackground(Color.WHITE);
        exits.add(exit);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        if (text.equals("Add Customer Details")) {
            new AddCustomer();
        } else if (text.equals("Flight Details")) {
            new FlightInfo();
        } else if (text.equals("Book Flight")) {
            new BookFlight();
        } else if (text.equals("Journey Details")) {
            new JourneyDetails();
        } else if (text.equals("Cancel Ticket")) {
            new Cancel();
        } else if (text.equals("Borading Pass")) {
            new BoardingPass();
        } else if (text.equals("Exit")) {
            setVisible(false);
            new Front();
        }
    }

    public static void main(String[] args) {
        new Home();
    }

}
