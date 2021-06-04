package GUI;

import javax.swing.*;

public abstract class AbstractGUI {
    protected WindowManager windowManager;
    protected JFrame frame;

    public AbstractGUI(JFrame frame, WindowManager windowManager) {
        this.frame = frame;
        this.windowManager = windowManager;
    }

    protected void setWindowManager(WindowManager windowManager) {
        this.windowManager = windowManager;
    }

    protected abstract void placeUIItems();
}
