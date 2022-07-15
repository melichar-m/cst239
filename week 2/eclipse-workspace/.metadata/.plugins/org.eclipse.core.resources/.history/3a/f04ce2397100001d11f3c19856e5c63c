package app;

import java.util.*;

public class Inventory
{
	private int gold;
	private ArrayList<Product> items;
	
	public boolean canPurchase(Product storeItem)
	{
		if(this.gold < storeItem.getPrice())
		{
			System.out.println("Not enough gold.");
			return false;
		}
		return true;
	}
	
	public Inventory()
	{
		this.gold = 0;
		ArrayList<Product> items = new ArrayList<Product>();
		this.items = items;
	}
	
	public int size()
	{
		return this.items.size();
	}
	
	public Product get(int index)
	{
		return this.items.get(index);
	}
	
	public void addToInventory(Product item)
	{
		this.items.add(item);
		System.out.println(this.items);
	}
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