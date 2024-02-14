package controller;
import javax.swing.JOptionPane;

import data.DataStorage;
import data.Items;
import data.Orders;
import data.Records;
import data.User;
import data.User;

public class Controller {
	private DataStorage ds= new DataStorage();
	private String tt= "";

	/**
	 * 
	 */
	public DataStorage datastorage;

	/**
	 * Getter of datastorage
	 */
	public DataStorage getDatastorage() {
	 	 return datastorage; 
	}

	/**
	 * Setter of datastorage
	 */
	public void setDatastorage(DataStorage datastorage) { 
		 this.datastorage = datastorage; 
	}

	/**
	 * 
	 * @return 
	 */
	public void addUser(String n, String p, String t) { 
		User u = new User();
		u.setUName(n);
		u.setUPassword(p);
		u.setType(t);
		ds.storeUser(u);
		 }
		
		public boolean checkUser(String n, String p){
		String cc = "";

			User  t= ds.getPwd(n);
			if(t!=null){
				cc= t.getUPassword().toString();
				tt= t.getType().toString();
				System.out.println("Read from vector:"+tt);
			}
			else{
				cc="no object";
			}
			System.out.println("password is: "+cc);
			if(p.equals(cc) && tt.equals("Customer")){
				System.out.println("Right & type is:"+tt);
				String msg = "Successful"+"\n";
				JOptionPane.showMessageDialog(null, msg, "Login", JOptionPane.INFORMATION_MESSAGE);
				return true;
				}
			else if(p.equals(cc) && tt.equals("Staff")){
				System.out.println("Right & type is:"+tt);
				String msg = "Successful"+"\n";
				JOptionPane.showMessageDialog(null, msg, "Login", JOptionPane.INFORMATION_MESSAGE);
				return true;
				}
			else
			{
			System.out.println("Wrong");
			String msg = "Wrong user name or password"+"\n";
			JOptionPane.showMessageDialog(null, msg, "Login", JOptionPane.INFORMATION_MESSAGE);
			return false;}
		}
		public String getTypeName(){
			return tt;
		}

	public Items[] getAllItems() {
		// TODO Auto-generated method stub
		return this.ds.getAllItems();
	}

	public void storeItem(String music, String type) {
		Items item = new Items(music,type);
		item.setmusicType(music);
		item.setmovieType(type);
		this.ds.addItem(item);
		System.out.println("music:"+music);
		System.out.println("movie:"+type);
		
	}

	public void deleteItem(int index) {
		this.ds.deleteItem(index);
		// TODO Auto-generated method stub
		
	}
	public void EditItem(int index,Items bread) {
		this.ds.EditItem(index,bread);
		
	}

	public void editItem(int index,Items type) {
		this.ds.editItem(index,type);
		
	}

	public void storeOrders(String order) {
		Orders orders= new Orders(order);
		orders.setOrders(order);
		this.ds.addOrders(orders);
		System.out.println("orders:"+order);
		
	}

	public void addRecord(String n, String g, String c) {
		Records r = new Records(n, g, c);
		r.setName(n);
		r.setGender(g);
		r.setCountry(c);
		ds.storeRecord(r);
		
	}

	public void deleteCalculation(int numRows, Records s) {
		this.ds.deleteCalculation(numRows, s);
		
	}

	public Records[] getAllCalculations() {
		
		return this.ds.getAllCalculations();
	}

	public void editRecords(int index, Records newrec) {
		this.ds.editRecords(index, newrec);
		
	}
	} 

