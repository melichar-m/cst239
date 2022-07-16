package app;

public class Weapon extends Product
{
	private int atkPower;
	
	public Weapon(int id, String name, String description, int price, int quantity, int atkPower)
	{
		super(id,name,description,price,quantity);
		this.atkPower = atkPower;
	}
	public String toString()
	{
		String out = super.toString();
		out += "Attack Power: " + this.atkPower + "\n";
		return out;
	}
}