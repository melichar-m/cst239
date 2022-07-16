package app;

import java.util.*;
/**
 * Cart will contain many products and have the ability to be added to
 * by a store(ArrayList of Salable Products), as well as the ability to
 * add from the cart to the player's inventory via purchasing. The player
 * will be able to cancel items out of their cart before purchasing should
 * they end up changing their mind.
 * @author Michael Melichar
 *
 */
public class Cart
{
	private ArrayList<Product> product;
	
	/**
	 * default constructor instantiates an arraylist for best adding/removing of product
	 */
	public Cart()
	{
		ArrayList<Product> product = new ArrayList<Product>();
		this.product = product;
	}
	
	/**
	 * for all items in cart, get price to be able to have a total
	 * @return float price
	 */
	public float totalPrice()
	{
		float price = 0;
		
		for(int i = 0; i < product.size(); i++)
		{
			price += this.product.get(i).getPrice();
		}
		
		return price;
	}
	
	/**
	 * addToCart method checks if the product is in stock,
	 * adding it to cart if possible and subtracting 1
	 * from quantity available to purchase
	 * @param item
	 */
	public void addToCart(Product item)
	{
		if(item.getQuantity() > 0 && item.isPurchasable())
		{
			this.product.add(item);
			//get index of item, use to set quantity of item being added to cart
			this.product.get(this.product.indexOf(item)).setQuantity(this.product.get(this.product.indexOf(item)).getQuantity() + 1);
			item.setQuantity(item.getQuantity()-1);
		}
	}
	
	/**
	 * removeFromCart method checks if the item is in the cart to avoid
	 * shenanigans with adding an unlimited supply to the store through
	 * removing an item that isn't there or crashing the store 
	 * with an OOB exception, then gets index of desired item for removal
	 * and removes from cart, adding it back into the quantity available
	 * @param item
	 */
	public void removeFromCart(Product item)
	{
		int index = this.product.indexOf(item);
		if(index > -1 && item.isPurchasable())
		{
			this.product.remove(index);
			item.setQuantity(item.getQuantity()+1);
		}
	}
	
	/**
	 * This will use the ArrayList method size in order to
	 * return the size of our cart to us for use in the store
	 * and in other driver methods.
	 * @return int size
	 */
	public int size()
	{
		return this.product.size();
	}
	
	/**
	 * get allows us to get an object at a given index, 
	 * and will traditionally be used with indexOf to 
	 * generically find the user-input item to be
	 * accessed within the cart's arraylist of products
	 * @param index
	 * @return
	 */
	public Product get(int index)
	{
		return this.product.get(index);
	}
	
	public String toString()
	{
		String out = "\nCART\n";
		for(int i = 0; i < product.size(); i++)
		{
			out += product.get(i).toString() + "\n";
		}
		
		return out;
	}
}