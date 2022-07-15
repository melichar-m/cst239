package app;

import java.util.Random;

/**
 * SuperHero class, example of inheritance for CST239: Programming with Java II
 * @author michael melichar
 *
 */
public class SuperHero
{
	private String name;
	private int health;
	private boolean isDead;
	
	/**
	 * SuperHero constructor assigns a String name for the superhero's name,
	 * and an int health for how much health they start with
	 * @param name
	 * @param health
	 */
	public SuperHero(String name, int health)
	{
		this.name = name;
		this.health = health;
	}
	
	/**
	 * makes an attack of random strength 
	 * against the opponent provided as a parameter
	 * @param opponent
	 */
	public void attack(SuperHero opponent)
	{
		Random rand = new Random();
		int damage = rand.ints(1, (10 + 1)).findFirst().getAsInt();
		
		opponent.determineHealth(damage);
		System.out.println(String.format("%s has damage of %d and health of %d", opponent.name, damage, opponent.health));		
	}
	
	/**
	 * gets if the SuperHero is dead
	 * @return isDead
	 */
	public boolean isDead()
	{
		return this.isDead;
	}
	
	/**
	 * subtract damage from health, and if damage is greater than 
	 * or equal to remaining health, set SuperHero to dead
	 * @param damage
	 */
	private void determineHealth(int damage)
	{
		if(this.health - damage <= 0)
		{
			this.health = 0;
			this.isDead = true;
		}
		else
		{
			this.health = this.health - damage;
		}
	}
	
	public int getHealth()
	{
		return this.health;
	}
	
	public String getName()
	{
		return this.name;
	}
	
}