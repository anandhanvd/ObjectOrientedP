package gui;

import javax.swing.JPanel;

import controller.MainFrame;
import data.Items;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditScreen extends JPanel{
	private MainFrame main;
	private int index;
	private Items items;
	private JComboBox comboBox; 
	private JComboBox comboBox_1;
	private Items[] item;
	private String aa="";
	private JList list;
	
	
	private String[] music={"the Beatles","The Blues","Yellow Submarine","neversay never"};
	private String[] movies={"transformers","insidious","barbie","oppenheimer","wonka","superman","batman","spiderman"};
	public EditScreen(MainFrame main, int ind, Items item) {
		this.index=ind;
		this.items=item;
		this.main=main;
		setLayout(null);
		
		this.comboBox = new JComboBox(this.music);
		comboBox.setBounds(12, 111, 107, 22);
		add(comboBox);
		this.comboBox.addItem(items.getmusicType());
		
		this.comboBox_1 = new JComboBox(this.movies);
		comboBox_1.setBounds(272, 111, 150, 22);
		add(comboBox_1);
		this.comboBox_1.addItem(items.getmovieType());
		
		JLabel lblBreadType = new JLabel("Music:");
		lblBreadType.setBounds(12, 82, 93, 16);
		add(lblBreadType);
		
		JLabel lblIngredients = new JLabel("Movies:");
		lblIngredients.setBounds(284, 82, 99, 16);
		add(lblIngredients);
		
		JButton btnReturnToCart = new JButton("return to cart");
		btnReturnToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showCartScreen();
			}
		});
		btnReturnToCart.setBounds(142, 242, 119, 25);
		add(btnReturnToCart);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String message="press ok to confirm edit";
				JOptionPane.showMessageDialog(null, message,"selection",JOptionPane.PLAIN_MESSAGE);
				String bread=comboBox.getSelectedItem().toString();
				String type= comboBox_1.getSelectedItem().toString();
				Items newitem= new Items(bread,type);
				main.getController().editItem(index,newitem);
			
			}
		});
		btnUpdate.setBounds(142, 189, 97, 25);
		add(btnUpdate);
	}
}
