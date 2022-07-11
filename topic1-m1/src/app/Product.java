package app;

public class Product
{
	private int id;
	private String name;
	private String description;
	private int price;
	private int quantity;
	private boolean purchasable;
	
	public Product(int id, String name, String description, int price, int quantity, boolean purchasable) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.purchasable = purchasable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isPurchasable() {
		return purchasable;
	}

	public void setPurchasable(boolean purchasable) {
		this.purchasable = purchasable;
	}
	
	public String toString()
	{
		String out = "Item ID: " + this.id + "\n" + 
					"__________________" + "\n" + 
					"Item name: " + this.name + "\n" + 
					"Description: " + this.description + "\n" + 
					"Price: " + this.price + "\n" +
					"Quantity: " + this.quantity + "\n";
		return out;
	}
}