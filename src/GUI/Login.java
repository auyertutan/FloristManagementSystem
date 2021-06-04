package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Login extends AbstractGUI {
    private JLabel heading;
    private JButton loginButton;

    public Login(JFrame frame, WindowManager windowManager) {
        super(frame, windowManager);
    }

    public void placeUIItems() {
        // Set Frame
        this.frame.setLayout(new GridLayout(3, 1));

        // Set Heading
        this.heading = new JLabel("Please Login", JLabel.CENTER);
        this.frame.add(this.heading);

        // Set Login Button
        this.loginButton = new JButton("Login");
        this.frame.add(this.loginButton);
        this.loginButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Login.this.windowManager.authentication.login("Merve Ö.");
                Login.this.windowManager.openWindow("Home");
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
        this.frame.repaint();
    }
}
