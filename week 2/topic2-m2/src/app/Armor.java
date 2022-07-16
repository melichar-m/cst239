package app;

public class Armor extends Product
{
	private int defPower;
	
	public Armor(int id, String name, String description, int price, int quantity, int defPower)
	{
		super(id,name,description,price,quantity);
		this.defPower = defPower;
	}
	public String toString()
	{
		String out = super.toString();
		out += "Defense: " + this.defPower + "\n";
		return out;
	}
}