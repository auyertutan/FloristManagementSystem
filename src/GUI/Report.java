package GUI;

import Model.Customer;
import Model.Flower;
import Model.ReportNode;
import Model.Sale;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Report extends AbstractGUI {
    private Double totalPrice;

    public Report(JFrame frame, WindowManager windowManager) {
        super(frame, windowManager);
    }

    @Override
    protected void placeUIItems() {
        // Set frame layout
        this.frame.setLayout(new BorderLayout());
        this.frame.setSize(800, 400);

        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        JButton goBackButton = new JButton("Go Back");
        JLabel heading = new JLabel("Sales Reports");
        topPanel.add(heading);
        topPanel.add(goBackButton);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        JButton searchButton = new JButton("Search");
        JTextField searchInput = new JTextField();
        bottomPanel.add(searchInput);
        bottomPanel.add(searchButton);

        DefaultListModel saleItems = new DefaultListModel();

        // Set Cart List
        JList saleList = new JList(saleItems);
        saleList.setSelectedIndex(0);

        ArrayList<Sale> sales = this.windowManager.salesManager.getSales();
        for (int i = 0; i < sales.size(); i ++) {
            saleItems.addElement(sales.get(i));
            System.out.println(sales.get(i));
        }

        JScrollPane cartPane = new JScrollPane(saleList);

        goBackButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Report.this.windowManager.openWindow("Home");
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

        searchButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                saleItems.clear();
                if (searchInput.getText().equals("")) {
                    for (int i = 0; i < sales.size(); i ++) {
                        saleItems.addElement(sales.get(i));
                    }
                } else {
                    ReportNode report = Report.this.windowManager.reportTree.findNode(Integer.parseInt(searchInput.getText()));
                    if (report == null) {
                        JOptionPane.showMessageDialog(null, "Couldn't Find!");
                        for (int i = 0; i < sales.size(); i ++) {
                            saleItems.addElement(sales.get(i));
                        }
                    } else {
                        saleItems.addElement(report.getSale());
                    }
                }
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

        this.frame.add(topPanel, BorderLayout.NORTH);
        this.frame.add(cartPane, BorderLayout.CENTER);
        this.frame.add(bottomPanel, BorderLayout.SOUTH);

        this.frame.repaint();
    }
}
