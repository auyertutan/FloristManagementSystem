package GUI;

import javax.swing.*;

import GUI.*;
import Model.Authentication;
import Model.FlowerManager;
import Model.ReportTree;
import Model.SalesManager;

public class WindowManager {
    private JFrame mainWindow;
    private Login login;
    private Home home;
    private Sell sell;
    private Report report;
    private Stock stock;
    public Authentication authentication;
    public FlowerManager flowerManager;
    public SalesManager salesManager;
    public ReportTree reportTree;

    public WindowManager(JFrame mainWindow) {
        this.mainWindow = mainWindow;
        this.authentication = new Authentication();
        this.flowerManager = new FlowerManager();
        this.salesManager = new SalesManager();
        this.reportTree = new ReportTree();

        this.login = new Login(mainWindow, this);
        this.home = new Home(mainWindow, this);
        this.sell = new Sell(mainWindow, this);
        this.report = new Report(mainWindow, this);
        this.stock = new Stock(mainWindow, this);

        // Login is initial window
        this.openWindow("Login");
        mainWindow.setVisible(true);
    }

    public void clearPane() {
        this.mainWindow.getContentPane().removeAll();
        this.mainWindow.repaint();
    }

    public void openWindow(String windowName) {
        this.clearPane();
        this.mainWindow.setVisible(false);
        switch (windowName) {
            case "Login":
                this.login.placeUIItems();
                break;
            case "Home":
                if (this.authentication.getAuthenticated()) {
                    this.home.placeUIItems();
                } else {
                    this.login.placeUIItems();
                    JOptionPane.showMessageDialog(null, "You have to login to access this page!");
                }
                break;
            case "Sell":
                if (this.authentication.getAuthenticated()) {
                    this.sell.placeUIItems();
                } else {
                    this.login.placeUIItems();
                    JOptionPane.showMessageDialog(null, "You have to login to access this page!");
                }
                break;
            case "Report":
                if (this.authentication.getAuthenticated()) {
                    this.report.placeUIItems();
                } else {
                    this.login.placeUIItems();
                    JOptionPane.showMessageDialog(null, "You have to login to access this page!");
                }
                break;
            case "Stock":
                if (this.authentication.getAuthenticated()) {
                    this.stock.placeUIItems();
                } else {
                    this.login.placeUIItems();
                    JOptionPane.showMessageDialog(null, "You have to login to access this page!");
                }
                break;
        }
        this.mainWindow.setVisible(true);
        this.mainWindow.repaint();
    }
}
