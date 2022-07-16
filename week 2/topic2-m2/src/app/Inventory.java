package app;

import java.util.*;

public class Inventory
{
	private int gold;
	private ArrayList<Product> items;
	
	/**
	 * check if gold > item cost
	 * @param storeItem
	 * @return boolean
	 */
	public boolean canPurchase(Product storeItem)
	{
		if(this.gold < storeItem.getPrice())
		{
			System.out.println("Not enough gold.");
			return false;
		}
		return true;
	}
	
	/**
	 * default constructor sets gold to 0 and has an empty arraylist of products(empty inventory)
	 */
	public Inventory()
	{
		this.gold = 0;
		ArrayList<Product> items = new ArrayList<Product>();
		this.items = items;
	}
	
	/**
	 * returns the arraylist's size
	 * @return int size
	 */
	public int size()
	{
		return this.items.size();
	}
	
	/**
	 * gets the object at a given index
	 * @param index
	 * @return Product
	 */
	public Product get(int index)
	{
		return this.items.get(index);
	}
	
	/**
	 * adds a given Product to the inventory ArrayList
	 * @param item
	 */
	public void addToInventory(Product item)
	{
		this.items.add(item);
		System.out.println(this.items);
	}
	/**
	 * removes an item from the inventory ArrayList,
	 * does not remove all instances of the item
	 * @param item
	 */
	public void removeFromInventory(Product item)
	{
		int index = this.items.indexOf(item);
		this.items.remove(index);
	}
	
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public ArrayList<Product> getItems() {
		return items;
	}
	public void setItems(ArrayList<Product> items) {
		this.items = items;
	}
	
	/**
	 * custom toString to output inventory
	 * in the same format as product
	 * ITEM ID\n
	 * _______\n
	 * NAME\n
	 * DESCRIPTION\n
	 * PRICE\n
	 * QUANTITY\n
	 * @return out
	 */
	public String toString()
	{
		String out = "\nINVENTORY\n";
		for(int i = 0; i < items.size(); i++)
		{
			out += items.get(i).toString() + "\n";
		}
		
		return out;
	}
}