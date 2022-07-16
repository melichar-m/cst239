package app;

public class Health extends Product
{
	private int healthPower;
	
	public Health(int id, String name, String description, int price, int quantity, int healthPower)
	{
		super(id,name,description,price,quantity);
		this.healthPower = healthPower;
	}
	public String toString()
	{
		String out = super.toString();
		out += "Healing: " + this.healthPower + "\n";
		return out;
	}
}