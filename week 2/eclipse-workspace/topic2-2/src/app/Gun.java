package app;

public class Gun extends Weapon
{
	/**
	 * overridden fireWeapon(int) method from Weapon class
	 */
	@Override
	public void fireWeapon(int power)
	{
		System.out.println("In Gun.fireWeapon() with a power of " + power);
	}
	/**
	 * overloaded fireWeapon() method
	 */
	public void fireWeapon()
	{
		System.out.println("In overloaded Gun.fireWeapon()");
		super.fireWeapon(5);
	}
	/**
	 * activate
	 */
	public void activate(boolean enable) 
	{
		System.out.println("In the Gun.activate with an enable of " + enable);	
	}
}
