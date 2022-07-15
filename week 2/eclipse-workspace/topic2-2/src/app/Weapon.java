package app;
/**
 * Abstract class Weapon includes two methods,
 * activate, which takes in a boolean parameter,
 * and fireWeapon which takes in an int as a parameter
 * @author michael melichar
 *
 */
public abstract class Weapon
{
	public abstract void activate(boolean enable);
	public void fireWeapon(int power)
	{
		System.out.println("In Weapon.fireWeapon() with a power of " + power);
	}
}