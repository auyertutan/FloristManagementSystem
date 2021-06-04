import GUI.WindowManager;
import Model.Authentication;

import javax.swing.*;

public class InitApplication {
    private JFrame frame;
    private Authentication authentication;
    private WindowManager windowManager;

    InitApplication() {
        this.frame = new JFrame("FlowerBucket");
        this.frame.setSize(800, 400);
        this.windowManager = new WindowManager(this.frame);
    }
}
