package controller;
import java.awt.CardLayout;

import javax.swing.JFrame;

import data.Items;
import data.Records;
import gui.AddRecordPanel;
import gui.CartScreen;
import gui.DisplayRecordsPanel;
import gui.EditPanel;
import gui.EditScreen;

import gui.LoginPanel;
import gui.MenuScreen;

import gui.RegisterPanel;
import gui.SelectionScreen;



public class MainFrame extends JFrame{
	private CardLayout card;
	private Controller cont;
	
	public MainFrame(){
		this.setTitle("Megaplus DVD");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.card= new CardLayout();
		this.setLayout(this.card);
		this.cont=new Controller();
		this.showRegScreen();
		this.setVisible(true);
	}


	/**
	 * 
	 */
	public Controller controller;
	
	/**
	 * Getter of reguserscreen
	 */

	/**
	 * 
	 * @return 
	 */
	public Controller getController() {
	 	 return this.cont;
	}
	/**
	 * Setter of controller
	 */
	public void setController(Controller controller) { 
		 this.controller = controller; 
	}
	/**
	 * 
	 * @param args[] 
	 */
	public static void main(String args[]) { 
		MainFrame gui = new MainFrame();
		// TODO Auto-generated method
	 }
	/**
	 * 
	 */
	public void showRegScreen() { 
		RegisterPanel p1 = new RegisterPanel(this);
		this.add(p1,"panel1");
		this.card.show(this.getContentPane(),"panel1");
	
	 } 
	public void showLogin(){
		LoginPanel p2= new LoginPanel(this);
		this.add(p2,"panel2");
		this.card.show(this.getContentPane(),"panel2");
	}
	public void showMenu(){
		MenuScreen c1= new MenuScreen(this);
		this.add(c1,"Menu");
		this.card.show(this.getContentPane(),"Menu");
		
	}

	public void showSelectionScreen(){
		SelectionScreen p4= new SelectionScreen(this);
		this.add(p4,"panel4");
		this.card.show(this.getContentPane(),"panel4");
	}
	public void showCartScreen(){
		CartScreen p5= new CartScreen(this);
		this.add(p5,"panel5");
		this.card.show(this.getContentPane(),"panel5");
	}
	public void showEditScreen(int index, Items items){
		EditScreen p6= new EditScreen(this,index,items);
		this.add(p6,"panel6");
		this.card.show(this.getContentPane(),"panel6");
	}
	public void showRecordsPanel(){
		DisplayRecordsPanel p7= new DisplayRecordsPanel(this);
		this.add(p7,"panel7");
		this.card.show(this.getContentPane(),"panel7");
	}
	public void showAddRecord(){
		AddRecordPanel p8= new AddRecordPanel(this);
		this.add(p8,"panel8");
		this.card.show(this.getContentPane(),"panel8");
	}
	public void showEditPanel(int ind, Records rec)
	{   EditPanel p3 = new EditPanel(this, ind, rec);
		this.add(p3, "editRecord");
		this.card.show(this.getContentPane(), "editRecord"); 
	}
	




}