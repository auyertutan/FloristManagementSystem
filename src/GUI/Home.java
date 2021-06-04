package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Home extends AbstractGUI {
    public Home(JFrame frame, WindowManager windowManager) {
        super(frame, windowManager);
    }

    @Override
    protected void placeUIItems() {
        // Set layout
        this.frame.setLayout(new GridLayout(2, 1));
        JPanel panel = new JPanel(new GridLayout(2, 2));

        // Set heading
        JLabel heading = new JLabel("Welcome Home: " + this.windowManager.authentication.getUsername(), JLabel.CENTER);

        // Set Buttons
        JButton sellButton = new JButton("Sell");
        JButton stockButton = new JButton("Stock");
        JButton reportButton = new JButton("Reports");
        JButton logoutButton = new JButton("Logout");

        // Add Button Actions
        logoutButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Home.this.windowManager.authentication.logout();
                Home.this.windowManager.openWindow("Login");
            }

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        sellButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Home.this.windowManager.openWindow("Sell");
            }

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        reportButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Home.this.windowManager.openWindow("Report");
            }

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        stockButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Home.this.windowManager.openWindow("Stock");
            }

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // Add components
        this.frame.add(heading);
        panel.add(sellButton);
        panel.add(stockButton);
        panel.add(reportButton);
        panel.add(logoutButton);
        frame.add(panel);
        frame.repaint();
    }
}
