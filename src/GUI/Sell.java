package GUI;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Sell extends AbstractGUI {
    private Double totalPrice;

    public Sell(JFrame frame, WindowManager windowManager) {
        super(frame, windowManager);
    }

    @Override
    protected void placeUIItems() {
        this.totalPrice = 0.0;

        // Set frame layout
        this.frame.setLayout(new GridLayout(1, 2));
        this.frame.setSize(800, 400);

        // Set Right Panel
        JPanel rightPanel = new JPanel(new BorderLayout());
        JLabel cartLabel = new JLabel("Cart");

        JButton goBackButton = new JButton("Go Back");

        // Right Panel Top
        JPanel rightPanelTop = new JPanel(new GridLayout(1, 2));

        // Right Panel Bottom
        JPanel rightPanelBottom = new JPanel(new GridLayout(1, 2));
        JLabel priceLabel = new JLabel("Cost: 0 Euro");

        // Set Inputs Panel
        JPanel inputsPanel = new JPanel(new GridLayout(11, 1));

        // Set Inputs
        JLabel customerNameLabel = new JLabel("Customer Name");
        JTextField customerName = new JTextField();

        JLabel customerAddressLabel = new JLabel("Customer Address");
        JTextField customerAddress = new JTextField();

        JLabel customerPhoneLabel = new JLabel("Customer Phone Number");
        JTextField customerPhone = new JTextField();

        // Select Flower
        JLabel flowerLabel = new JLabel("Select Flower");
        JComboBox flowerCombo = new JComboBox();
        Flower[] flowers = this.windowManager.flowerManager.getFlowers();
        for (int i = 0; i < flowers.length; i ++) {
            flowerCombo.addItem(flowers[i]);
        }

        // Select Flower Count
        JLabel flowerCountLabel = new JLabel("How Many?");
        JComboBox flowerCountCombo = new JComboBox();
        for (int i = 1; i <= 50; i ++) {
            flowerCountCombo.addItem(i);
        }

        DefaultListModel cartItems = new DefaultListModel();

        // Set Cart List
        JList cartList = new JList(cartItems);
        cartList.setSelectedIndex(0);

        JScrollPane cartPane = new JScrollPane(cartList);

        // Add To Cart Button
        JButton addToCart = new JButton("Add To Cart");
        addToCart.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Flower flower = (Flower) flowerCombo.getSelectedItem();
                Integer flowerCount = (Integer) flowerCountCombo.getSelectedItem();
                SelectedFlower selectedFlower = new SelectedFlower(flower);
                if (flower.getStock() >= flowerCount) {
                    flower.setCount(flowerCount);
                    cartItems.addElement(selectedFlower);
                    flower.decreaseStock(flowerCount);
                    Sell.this.totalPrice += flower.getPrice() * flowerCount;
                    priceLabel.setText("Cost: " + Sell.this.totalPrice.toString() + " Euro");
                } else {
                    JOptionPane.showMessageDialog(null, "We only have " + flower.getStock() + " of this flower.");
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

        goBackButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (cartItems.size() > 0) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Your cart is not empty. Do you still want to go back?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (confirm == 0) {
                        Sell.this.windowManager.openWindow("Home");
                    }
                } else {
                    Sell.this.windowManager.openWindow("Home");
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

        // Complete Order
        JButton completeOrderButton = new JButton("Complete Order");
        completeOrderButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (customerName.getText().equals("") || customerAddress.getText().equals("") || customerPhone.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the customer details!");
                } else {
                    if (cartItems.size() == 0) {
                        JOptionPane.showMessageDialog(null, "Please add at least 1 item to cart!");
                    } else {
                        Sale sale = new Sale();
                        // Set Customer
                        Customer customer = new Customer();
                        customer.setName(customerName.getText());
                        customer.setPhone(customerPhone.getText());
                        customer.setAddress(customerAddress.getText());

                        // Set Flowers
                        Flower[] flowers = new Flower[cartItems.size()];
                        for (int i = 0; i < cartItems.size(); i++) {
                            SelectedFlower currentFlower = (SelectedFlower) cartItems.get(i);
                            flowers[i] = currentFlower.getFlower();
                        }

                        sale.setCustomer(customer);
                        sale.setFlowers(flowers);
                        sale.setOrderId();

                        Sell.this.windowManager.salesManager.addSale(sale);
                        Sell.this.windowManager.reportTree.addNode(sale.getOrderId(), sale);

                        JOptionPane.showMessageDialog(null, "Checkout Completed.");
                        Sell.this.windowManager.openWindow("Home");
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

        // Add Inputs To Panel
        inputsPanel.add(customerNameLabel);
        inputsPanel.add(customerName);
        inputsPanel.add(customerAddressLabel);
        inputsPanel.add(customerAddress);
        inputsPanel.add(customerPhoneLabel);
        inputsPanel.add(customerPhone);
        inputsPanel.add(flowerLabel);
        inputsPanel.add(flowerCombo);
        inputsPanel.add(flowerCountLabel);
        inputsPanel.add(flowerCountCombo);
        inputsPanel.add(addToCart);

        // Set Right Panel Top
        rightPanelTop.add(cartLabel);
        rightPanelTop.add(goBackButton);

        // Set Right Panel Bottom
        rightPanelBottom.add(priceLabel);
        rightPanelBottom.add(completeOrderButton);

        // Set Right Panel
        rightPanel.add(rightPanelTop, BorderLayout.NORTH);
        rightPanel.add(cartPane, BorderLayout.CENTER);
        rightPanel.add(rightPanelBottom, BorderLayout.SOUTH);

        this.frame.add(inputsPanel);
        this.frame.add(rightPanel);

        this.frame.repaint();
    }
}
