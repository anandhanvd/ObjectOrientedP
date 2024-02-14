package gui;

import javax.swing.JPanel;

import controller.MainFrame;

import data.Items;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class CartScreen extends JPanel{
	private MainFrame main;
	private Items[] item;
	private String aa="";
	private int index;
	private JList list;
	
	
	public CartScreen(MainFrame main){
		this.main=main;
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 13, 397, 126);
		add(scrollPane);
		
		this.list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()){
					index=list.getSelectedIndex();
					if(index==-1)
						return;
					Items items=item[index];
				}
			}
		});
		scrollPane.setViewportView(list);
		this.populateJlist();
		
		JButton btnEdit = new JButton("Edit ");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index=list.getSelectedIndex();
				if(index==-1)
					return;
				Items newitem=item[index];
				main.showEditScreen(index,newitem);
				
			}
		});
		btnEdit.setBounds(92, 152, 97, 25);
		add(btnEdit);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index=list.getSelectedIndex();
				if(index==-1)
					return;
				Items items=item[index];
				main.getController().deleteItem(index);
				populateJlist();
			}
		});
		btnDelete.setBounds(223, 152, 97, 25);
		add(btnDelete);
		
		JButton btnCheckout = new JButton("confirm&checkout");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message=" Congrats!!your order is confirmed!!";
				JOptionPane.showMessageDialog(null, message,"selection",JOptionPane.PLAIN_MESSAGE);
				String orders=list.getModel().toString();
				main.getController().storeOrders(orders);
			}
		});
		btnCheckout.setBounds(137, 286, 148, 76);
		add(btnCheckout);
		
		JButton btnBackToSelection = new JButton("back to selection screen");
		btnBackToSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showSelectionScreen();
			}
		});
		btnBackToSelection.setBounds(103, 221, 206, 25);
		add(btnBackToSelection);
				
		}
	private void populateJlist(){
		this.item=this.main.getController().getAllItems();
		DefaultListModel model= new DefaultListModel();
		for(int i=0;i<item.length;i++){
			Items items= item[i];
			model.addElement("Music: "+items.getmusicType()+" ; "+"Movie:" +items.getmovieType());
		}
		this.list.setModel(model);
		
	}
	}	
	
	

