package lambegautam.gradecode1.pack1;
import java.util.Scanner;
//driver class
public class MainClass {

	//main driver method 
	
	public static void main(String[] args) {
		String username,password,choise;                      //these are local variables
		Scanner sc = new Scanner(System.in);                   // creating Scanner class object to get inputs from user
		System.out.println("if you are admin press (yes/no)");
		choise = sc.next();
		StoreInformation si = new StoreInformation();         //storeinformation class include all operation related to project
		si.addProduct();                                       //method is called to create products for store
		
		//if you are admin then press yes otherwise you go to customer section
		
		if(choise.equalsIgnoreCase("yes")) {
			Admin u= new Admin();                       //here creating admin object which consist of admin passward and username
			
			//we take inputs from admin to validate admin
			//for admin username=princy and password=1234
			System.out.println("princy please enter Admin username & password");
			System.out.println("Username:");           //princy
			username=sc.next();
			System.out.println("Password:");           //1234
			password= sc.next();
			
			//this block is for validation if admin valid successfully then it shows various options otherwise shows 
			//message of invalid password/username
			
			if(username.equals(u.adminUserName) && password.equals(u.adminPassword) ) {
				String doAgain="";
				
				//following block contain menu for admin
				
				do {
					System.out.println("Options");
					System.out.println(" 1.List the products in the store \n 2.Search the product by using productid "
							+ "\n 3.List the products by category \n 4.Search the product by using the name \n 5.To check the total amount, spend on her products"
							+ "\n 6.Display the Profit amount that she gets on category wise");
					System.out.println("Enter your choise:");
					int ch=sc.nextInt();
					//custom Exception for invalid choice
					try {
				    	if(ch>6) {
				    	throw new CustomException();
				    }
				    }catch(CustomException e) {
				    	System.out.println(e.getMessage());
				    }
					//according to admin choice we goto the selected block execution using switch case
					switch(ch) {
					
					case 1:
						si.listProduct();       //it shows all product with all details
						break;
					case 2:
						System.out.println("Enter product id to be searched:");  //this block take input from user and find whether input product is there
						Integer pId= sc.nextInt();
						si.searchProductWithId(pId);         
						break;
					case 3:
						si.listProductByCategory();      //this method list all the product according to category
						break;
					case 4:
						System.out.println("Enter Product name to be searched:");
						String pName=sc.next();            //this block take input as product name from user and searched                
						si.searchProductWithName(pName); 
						break;
					case 5:
						si.totalProductAmount();           //this method calculate total product amount which spend by princy
						break;
					case 6:
						si.getProfitCategorywise();        //it calculate profit according to category
						break;
						
					
					}
					System.out.println("if you want to do more operation type (yes) otherwise(no)");  //to do task repeatedly we ask admin for repeatation
					doAgain=sc.next();
				}while(doAgain.equalsIgnoreCase("yes"));
			}
			else {
				System.out.println("invalid credientials...");
				
				
			}
			
		//this else block is for customer related operation
		
		}else {
			int customerChoise;
			String doAgain;
			si.addUser();
			System.out.println("welcome you are customer");
			do {
				System.out.println("Options");
				System.out.println("1.Existing Customer login and product view \n"+"2.New customer  registration & Login & product view   \n"
				+"3.Filter product based on price \n"+"4.filter product based on category \n");
				customerChoise=sc.nextInt();
				//custom exception for invalid choice by customer
				try {
			    	if(customerChoise>4) {
			    	throw new CustomException();
			    }
			    }catch(CustomException e) {
			    	System.out.println(e.getMessage());
			    }
				switch(customerChoise){
					case 1:
						String eUserName,ePassword;                         //there we customer users are created
						System.out.println("--------Login---------");
						System.out.println("Enter UserName:");              //gautam     raj
						eUserName=sc.next();
						System.out.println("Enter Password:");              //pass123     pass123
                        ePassword=sc.next();
						if(si.userLogin(eUserName,ePassword)) {
							System.out.println("login sucessful...");
							User u=si.getCurrentUserObject(eUserName, ePassword);
							si.listProduct();
						}else {
							System.out.println("Invalid UserName or Password");
						}
						break;
					case 2:
						si.addNewUser();
						String nUserName,nPassword;
						System.out.println("--------Login---------");
						System.out.println("Enter UserName:");
						nUserName=sc.next();
						System.out.println("Enter Password:");
                        nPassword=sc.next();
                        
						if(si.userLogin(nUserName,nPassword)) {
							System.out.println("login sucessful...");
							User u=si.getCurrentUserObject(nUserName, nPassword);
							si.listProduct();
						}else {
							System.out.println("Invalid UserName or Password");
						}
						
						break;
					case 3:
						si.filterBasedOnPrice();                  //method is used to filter product based on price
						break;
					case 4:
						System.out.println("Enter Category name:");
						String categoryFilter=sc.next();
						si.filterBasedOnCategory(categoryFilter);          //method for filter product based on category
						break;
						
				}
				System.out.println("if you want to do more operation press (yes/no)");
				doAgain=sc.next();
			
			}while(doAgain.equalsIgnoreCase("yes"));
			
		}
	
		sc.close();                  //closing scanner resource

	}

}
