package lambegautam.gradecode1.pack1;
import java.util.Scanner;
import java.util.*;
public class StoreInformation {
	public static int count=6;
	//crating map data structure to hold product information 
	Map<Integer,Product > mp = new HashMap<Integer,Product>();
	//creating list data structure to hold list of user/customer
	List<User> l = new ArrayList<User>();
	Scanner sc= new Scanner(System.in);
	
	//this method add some product to hashmap 
	public void addProduct() {
		Product p = new Product("apple","vegetables",10,001,"apple",10);
		
		mp.put(1, p);
		Product p1 = new Product("book","stationary",60,002,"book",5);
		
		mp.put(2, p1);
		Product p2 = new Product("sugar","grocery",40,003,"sugar",10);
		
		mp.put(3, p2);
		Product p3 = new Product("bucket","toiletry",50,004,"bucket",3);
		
		mp.put(4, p3);
		
		Product p4 = new Product("brush","toiletry",20,005,"brush",3);
		mp.put(5, p4);
		
		Product p5 = new Product("orange","vegetables",70,006,"orange",15);
		mp.put(6, p5);
		
		
	}
	//this method add two customer to customer list
	
	public void addUser() {
		User u1 = new User("gautam","gautam@123","pass123",1000);
		User u2 = new User("raj","raj@123","pass123",1000);
		l.add(u1);
		l.add(u2);
	}
	
	//this method is used to add new customer to shop
	//here we take username ,password and emailid from customer and provide them 1000 free coin
	public void addNewUser() {
		String userName,password,emailId;
		System.out.println("---------Welcome New User---------");
		System.out.println("------Registration--------");
		System.out.println("Enter Details Carefully...");
		System.out.println("Enter UserName:");
		userName=sc.next();
		System.out.println("Enter Password:");
		password=sc.next();
		System.out.println("Enter EmailId:");
		emailId=sc.next();
		
		User u= new User(userName,password,emailId,1000);
		
		l.add(u);
		System.out.println("-------Registration sucessful....-----");
		System.out.println("to view product login yourself.");
		
		
	}
	
	//listProduct() method is used to list all product of shop
	
	public void listProduct() {
		if( count>0 ) {
			for(int i=1;i<=mp.size();i++) {
				
				Product p= mp.get(i);
				System.out.println(i);
				System.out.println("product name:"+p.getProductName());
				System.out.println("category:"+p.getCategory());
				System.out.println("Quantity:"+p.getAvailableQuantity());
				System.out.println("buying price:"+p.getBuyingPrice());
				System.out.println("selling price:"+p.getSellingPrice());
				System.out.println("--------------------------------");
			}
		}
		else {
			System.out.println("No Product in Department");
		}
		
	}
	
	//listProductByCategory shows product according to category
	
	public void listProductByCategory() {
		System.out.println("list by categorywise:");
		
		if(count<=0) {
			System.out.println("No Product in any category");
		}
		else {
			System.out.println("Grocery:");
			for(int i=1;i<=mp.size();i++) {
				Product p=mp.get(i);
				if(p.getCategory().equalsIgnoreCase("grocery")) {
				 System.out.println(p.getProductName());	
				}
				
			}
			System.out.println("Stationary:");
			for(int i=1;i<=mp.size();i++) {
				Product p= mp.get(i);
				if(p.getCategory().equalsIgnoreCase("Stationary")) {
				 System.out.println(p.getProductName());	
				}
				
			}
			System.out.println("Toiletry:");
			for(int i=1;i<=mp.size();i++) {
				Product p= mp.get(i);
				if(p.getCategory().equalsIgnoreCase("toiletry")) {
				 System.out.println(p.getProductName());	
				}
				
			}
			System.out.println("Vegetables:");
			for(int i=1;i<=mp.size();i++) {
				Product p= mp.get(i);
				if(p.getCategory().equalsIgnoreCase("Vegetables")) {
				 System.out.println(p.getProductName());	
				}
				
			}
		}
		
	}
	// searchProductWithId() shows  product whose id is provided by user
	
	public void searchProductWithId(Integer pId) {
		if(count<=0) {
			System.out.println("No Product in Department");
		}
		else {
			int flag=0;
			for(int i=1;i<=mp.size();i++) {
				Product p= mp.get(i);
				if(pId.equals(p.getProductId())) {
					System.out.println("product Find");
					flag=1;
					break;
					
				}
			}
			if(flag==0) {
				System.out.println("Prduct not found...");
			}
			}
		
		
	}
	//searchProductWithName() method shows product is present in shope based on userinput
	
	public void searchProductWithName(String productName) {
		if(count<=0) {
			System.out.println("No Product in Department");
		}
		else {
			int flag=0;
			for(int i=1;i<=mp.size();i++) {
				Product p= mp.get(i);
				if(productName.equalsIgnoreCase(p.getProductName())) {
					System.out.println("product Find");
					flag=1;
					break;
					
				}
			}
			if(flag==0) {
				System.out.println("Prduct not found...");
			}
			}
	}
	
	//this method shows total amount spend by product owner
	
	public void totalProductAmount() {
		System.out.println("Total Amount Spend:");
		if(count<=0) {
			System.out.println("No Amount Spend..");
		}
		else {
			int totalAmount=0;
			for(int i=1;i<=mp.size();i++) {
				Product p= mp.get(i);
				totalAmount= totalAmount+p.getBuyingPrice();
			}
			System.out.println(totalAmount);
		}
		
	}
	// getProfitCategorywise() method list profit amount categorywise
	
	public void getProfitCategorywise() {
		if(count<=0) {
			System.out.println("No Profit");
		}
		else {
			double groceryProfit=0;
			double stationaryProfit=0;
			double toiletryProfit=0;
		    double vegetableProfit=0;
			for(int i=0;i<mp.size();i++) {
				Product p= mp.get(i);
				if(p.getCategory().equalsIgnoreCase("grocery")) {
				  
				  double sellingPrice =((p.getBuyingPrice() * 0.5)+p.getBuyingPrice());
				  p.setSellingPrice(sellingPrice);
				  
				  groceryProfit=groceryProfit+(p.getSellingPrice()-p.getBuyingPrice());
				}
				else if(p.getCategory().equalsIgnoreCase("stationary")) {
					  
					  double sellingPrice=((p.getBuyingPrice() * 0.5)+p.getBuyingPrice());
					  p.setSellingPrice(sellingPrice); 
					  
					  stationaryProfit=stationaryProfit+(p.getSellingPrice()-p.getBuyingPrice());
					}
				else if(p.getCategory().equalsIgnoreCase("toiletry")) {
					
					double sellingPrice=((p.getBuyingPrice() * 0.5)+p.getBuyingPrice());
					  p.setSellingPrice(sellingPrice); 
					  
					  toiletryProfit=stationaryProfit+(p.getSellingPrice()-p.getBuyingPrice());
					}
				else {
					
					double sellingPrice=((p.getBuyingPrice() * 0.5)+p.getBuyingPrice());
					  p.setSellingPrice(sellingPrice); 
					  
					  vegetableProfit=stationaryProfit+(p.getSellingPrice()-p.getBuyingPrice());
				}
				
			}
			
			System.out.println(" Grocery Profit:"+ groceryProfit+"\n Stationary Profit:"+stationaryProfit+"\n toiletry Profit:"+toiletryProfit+"\n vegetable Profit:"
					+vegetableProfit);
		}
		
	}
	//Userlogin() method return ture is user is existing and provide correct username and password
	
	public boolean userLogin(String username,String password) {
		int flag=0;
		for(int i=0;i<l.size();i++) {
			User u=l.get(i);
			if(u.getUserName().equals(username)&& u.getPassword().equals(password)) {
				flag=1;
			}
		}
		if(flag==1) {
			return true;
		}else {
			return false;
		}
		
	}
	//extra feature for future
	//return current user/customer object
	
	public User getCurrentUserObject(String username,String password) {
		User currentUserObject=null;
		for(int i=0;i<l.size();i++) {
			User u=l.get(i);
			if(u.getUserName().equals(username)&& u.getPassword().equals(password)) {
				currentUserObject=l.get(i);
			   break;
			    
			}
			
		}
		return currentUserObject;
	}
	
	//filterBasedOnPrice() method filter product according low to high order of price
	public void filterBasedOnPrice() {
		ArrayList<Double> al = new ArrayList<Double>();
		Product p;
		for(int i=1;i<=mp.size();i++) {
			 p= mp.get(i);
			
			al.add(p.getSellingPrice());
				
		}
		
		Collections.sort(al);
		
		
		Map<Integer,Product> ms =new HashMap<Integer,Product>();
		
		for(int i=0;i<al.size();i++) {
			
			for(int j=1;j<=al.size();j++) {
				Product p1=mp.get(j);
				if(p1.getSellingPrice()== al.get(i)) {
					ms.put(i+1, p1);
					
					break;
					
				}
			}
		}
		System.out.println("Filtering Based on Price");
		System.out.println("--------------------------");
		
		for(int i=1;i<=ms.size();i++) {
			Product p1= ms.get(i);
			System.out.println("ID-"+p1.getProductId());
			System.out.println("Name-"+p1.getItemName());
			System.out.println("category-"+p1.getCategory());
			System.out.println("Price-"+p1.getSellingPrice());
			System.out.println("----------------------");
		
		}
		
		
	}
	//filterbasedOnCategory() method shows only type category product that user want
	
	public void filterBasedOnCategory(String catagory) {
		
		for(int i=1;i<mp.size();i++) {
			Product p=mp.get(i);
			if(catagory.equalsIgnoreCase(p.getCategory())) {
				System.out.println(p.getProductId());
				System.out.println(p.getItemName());
				System.out.println(p.getCategory());
				System.out.println(p.getSellingPrice());
				System.out.println("----------------------");
				
			}
		}
	}
	

}
