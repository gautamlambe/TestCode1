package lambegautam.gradecode1.pack1;

//this class store all product related information
//pojo class
//this class extend item class
public class Product extends Item {
	private int productId;
	private String productName;
	private double sellingPrice;
	private int availableQuantity;
	
	//constructor
	
	public Product(String itemName, String category, int buyingPrice, int productId, String productName,
			 int availableQuantity) {
		
		super(itemName, category, buyingPrice);
		this.productId = productId;
		this.productName = productName;
	    this.sellingPrice=(buyingPrice*0.5)+buyingPrice;
	    this.availableQuantity = availableQuantity;
	}

	//getters and setters of product class
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
	
	
	
	
	

}
