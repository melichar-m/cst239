package app;

public class Bomb extends Weapon
{
	public void fireWeapon(int power)
	{
		System.out.println("In Bomb.fireWeapon() with a power of " + power);
	}
	public void fireWeapon()
	{
		System.out.println("In overloaded Bomb.fireWeapon()");
		super.fireWeapon(10);
	}
	
	public void activate(boolean enable) 
	{
		System.out.println("In the Bomb.activate with an enable of " + enable);
	}
}
