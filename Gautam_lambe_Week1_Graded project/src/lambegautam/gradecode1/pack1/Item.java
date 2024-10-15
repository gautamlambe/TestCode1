package lambegautam.gradecode1.pack1;

// this class sore all item related informatiom
//pojo class
public class Item {
	private String itemName;
	private String category;
	private int buyingPrice;
	
	//constructor
	public Item(String itemName, String category, int buyingPrice) {
		super();
		this.itemName = itemName;
		this.category = category;
		this.buyingPrice = buyingPrice;
	}

	//getters and setters
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(int buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	
	

}
