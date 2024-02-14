package gui;

import javax.swing.JPanel;

import controller.MainFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MenuScreen extends JPanel {
	private MainFrame main;
	private JComboBox cbPage;
	private String[] valArr={"go to item selection","go to cart"};

	public MenuScreen(MainFrame main) {
		setBackground(new Color(255, 222, 173));
		setForeground(Color.GRAY);
		this.main=main;
		setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblMenu.setBounds(186, 32, 56, 16);
		add(lblMenu);
		
		this.cbPage = new JComboBox(this.valArr);
		cbPage.setBounds(111, 104, 229, 35);
		add(cbPage);
		
		JButton btnGoToPage = new JButton("Go To Page");
		btnGoToPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				openPage();
			}
		});
		btnGoToPage.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnGoToPage.setBounds(163, 170, 124, 35);
		add(btnGoToPage);
		
		
		
		// TODO Auto-generated constructor stub
	}
	public void openPage(){
		int pageIndex=this.cbPage.getSelectedIndex();
		if(pageIndex==0){
			this.main.showSelectionScreen();
		}
		else if(pageIndex==1){
			this.main.showCartScreen();
		}

	}
 
}