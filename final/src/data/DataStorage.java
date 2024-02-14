package data;

import java.util.Vector;

public class DataStorage {
	Vector<User> storage= new Vector<User>();
	private Vector<Items>itemsList=new Vector<Items>();
	private Vector<Orders>orderList=new Vector<Orders>();
	Vector<Records> recordsStorage = new Vector<Records>();

	public void storeUser(User u) { 
		System.out.println("Name: "+u.getUName());
		System.out.println("Password: "+u.getUPassword());
		System.out.println("Type: "+u.getType());

		this.storage.add(u); 
		for(int i=0; i<storage.size(); i++)
		{
			User temp = storage.get(i);
			System.out.println("User Name :"+ temp.getUName()+"  Pw is: "+temp.getUPassword()+"Type is"+temp.getType());
		}
	 }
	public User getPwd(String n) {
		for(int i=0; i<storage.size(); i++)	{
			User temp = storage.get(i);
			if (temp.getUName().equals(n)){
			return temp;
			}
		}
		return null;
	} 

	public Items[] getAllItems() {
		Items[] opArr= new Items[this.itemsList.size()];
		this.itemsList.toArray(opArr);
		return opArr;
	}
	
	public Orders[] getAllOrders() {
		Orders[] opArr_1= new Orders[this.orderList.size()];
		this.orderList.toArray(opArr_1);
		return opArr_1;
	}

	public void addItem(Items item) {
		this.itemsList.add(item);
		// TODO Auto-generated method stub
		
	}

	public void deleteItem(int index) {
		this.itemsList.remove(index);
		// TODO Auto-generated method stub
		
	}

	public void editItem(int index, Items type) {
		this.itemsList.set(index,type);
		
	}

	public void EditItem(int index, Items bread) {
		this.itemsList.set(index,bread);
		
	}

	public void addOrders(Orders orders) {
		this.orderList.add(orders);
	}
	public void storeRecord(Records r) {
		recordsStorage.add(r);
        for (int i = 0; i < recordsStorage.size(); i++) {
            Records temp = recordsStorage.get(i);
            System.out.println("book: " + (i + 1) + " Name: " + temp.getName() + " and Type is: " + temp.getGender());
        }
    
		
	}
	public void deleteCalculation(int numRows, Records s) {
		recordsStorage.remove(numRows);
        recordsStorage.remove(s);
		
	}
	public Records[] getAllCalculations() {
        Records[] opArr = new Records[recordsStorage.size()];
        recordsStorage.toArray(opArr);
        return opArr;
	}
	public void editRecords(int index, Records newrec) {
		recordsStorage.setElementAt(newrec, index);
		
	}




		
		
	} 

