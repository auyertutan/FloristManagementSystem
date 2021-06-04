package GUI;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Stock extends AbstractGUI {
	private Double totalPrice;

	public Stock(JFrame frame, WindowManager windowManager) {
		super(frame, windowManager);
	}

	@Override
	protected void placeUIItems() {
		// Set frame layout
		this.frame.setLayout(new BorderLayout());
		this.frame.setSize(800, 400);

		JPanel topPanel = new JPanel(new GridLayout(1, 2));

		JButton goBackButton = new JButton("Go Back");
		JLabel heading = new JLabel("Stock");
		topPanel.add(heading);
		topPanel.add(goBackButton);

		JPanel cartPane = new JPanel(new GridLayout(1, 2));
		JComboBox flowers = new JComboBox();
		JComboBox flowerCount = new JComboBox();
		for (int i = 0; i < 100; i ++) {
			flowerCount.addItem(i);
		}

		JButton addButton = new JButton("Order");

		DefaultListModel waitingStockValues = new DefaultListModel();

		// Set Cart List
		JList waitingStockList = new JList(waitingStockValues);
		waitingStockList.setSelectedIndex(0);


		Flower[] allFlowers = this.windowManager.flowerManager.getFlowers();
		for (int i = 0; i < allFlowers.length; i ++) {
			flowers.addItem(allFlowers[i].getName());
		}

		JScrollPane waitingStock = new JScrollPane(waitingStockList);

		StockList list = new StockList();

		addButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				list.addItem((String) flowers.getSelectedItem(), (int) flowerCount.getSelectedItem());
				waitingStockValues.clear();
				StockNode[] nodes = list.getAll();
				for (int i = 0; i < nodes.length; i ++) {
					if (nodes[i] != null) {
						waitingStockValues.addElement(nodes[i].getName() + " (" + nodes[i].getCount() + ")");
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



	//	JButton discardButton = new JButton("Delete");
	//	JButton discardAllButton = new JButton("Delete All");
		JPanel formWrapper = new JPanel(new GridLayout(5, 1));
		formWrapper.add(new JLabel("Select Flower"));
		formWrapper.add(flowers);
		formWrapper.add(new JLabel("How Many?"));
		formWrapper.add(flowerCount);
		formWrapper.add(addButton);

		JPanel rightWrapper = new JPanel(new GridLayout(5, 1));
		rightWrapper.add(new JLabel("Waiting Orders"));
		rightWrapper.add(waitingStock);
		cartPane.add(formWrapper);
		cartPane.add(rightWrapper);

		
		goBackButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Stock.this.windowManager.openWindow("Home");
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

		this.frame.repaint();
	}
}
