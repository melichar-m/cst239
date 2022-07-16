package app;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Store will make use of ArrayList of Products inventory and cart
 * in order to place Products into the appropriate locations based
 * on menu selections made entirely through the console. The user
 * should be able to place items in their cart, cancel items from their
 * cart and purchase the items in their cart as of Milestone 1.
 *
 * My take: Currently, I have some issues with how I ended up
 * doing this project. I feel like I have too much bloat
 * in some areas within my code and that they should 
 * serve more singular purposes to enhance readability and therefore,
 * code debugging. I will be looking at refactoring this
 * for the future so that I can complete future milestones easier.
 * 
 * There are some errors within the code that are logic errors.
 * I haven't had enough time to fix them, as I've been traveling
 * visiting my grandmother after a major stroke, and taking care
 * of my grandfather. I am home now, but the airport ate a large
 * portion of my time and despite putting 20+ hours into this code,
 * I still feel like it wasn't enough as I hadn't used Java in 
 * just over 10 years, and it isn't Pythonic at all. I feel like
 * this helped a lot with reintroducing myself to Java, though, so
 * future assignments likely won't take me quite as long to
 * get to a point where I'm debugging code.
 * @author Michael Melichar
 *
 */
public class Store
{
	private Product product;
	private Cart cart;
	private static Inventory inventory;
	private static ArrayList<Product> store;
	
	/**
	 * initializes and returns the store to the caller
	 * @return ArrayList of Products store
	 */
	public static ArrayList<Product> init()
	{
		//Scanner scan = new Scanner(System.in);
		ArrayList<Product> store = new ArrayList<Product>();
		Inventory inventory = new Inventory();
		Cart cart = new Cart();
		
		Weapon sword = new Weapon(0,"Sword","Cuts things",100,2,10);
		Weapon staff = new Weapon(1,"Staff","Use to cast spells",200,2,20);
		
		Armor armor = new Armor(2,"Chainmail","Make things not cut you",500,1,15);
		Armor cloth = new Armor(3,"Magic Robes","A magic dress",750,1,5);
		
		Health potion = new Health(4,"Health Potion","Drink me in case of emergency",50,10,50);
		Health bigPotion = new Health(5,"Bigger Health Potion","Drink me in case of bigger emergencies",100,5,100);
		
		store.add(sword);
		store.add(staff);
		store.add(armor);
		store.add(cloth);
		store.add(potion);
		store.add(bigPotion);
		
		displayMenus(inventory, "Main", store, cart);
		return store;
	}
	
	/**
	 * takes in input as a selection then adds the selected item to the cart
	 * if the player can afford to purchase the item
	 * @param inventory
	 * @param cart
	 * @param store
	 * @param scan
	 */
	public static void placeInCart(Inventory inventory, Cart cart, ArrayList<Product> store,Scanner scan, int qty)
	{
		String in = scan.nextLine();
		//index = selection - 1
		int selectionIndex = Integer.parseInt(in) - 1;
		//if player gold > cost of item
		if(inventory.canPurchase(store.get(selectionIndex)))
		{
			//add item to cart and subtract one from the store
			cart.addToCart(store.get(selectionIndex),qty);
		}
	}
	/**
	 * sets quantity of a given item to a set quantity
	 * @param product
	 * @param quantity
	 */
	public static void setQuantity(Product product, int quantity)
	{
		product.setQuantity(quantity);
	}
	
	/**
	 * based on menuSelection, sets and displays menu options,
	 * then calls helper functions to listen for responses to the menu
	 * options given, then appropriately handle them
	 * @param inventory
	 * @param menuSelection
	 * @param store
	 * @param cart
	 */
	public static void displayMenus(Inventory inventory, String menuSelection, ArrayList<Product> store, Cart cart)
	{
		//String vars for all menu options and flavor text
		String welcome = "Welcome to Xoblob's Odds and Ends!\nPlease, have a look around!\n";
		String cartIntro = "You could swear your basket just moved... \nbut anyway, here's your cart so far: \n";
		String inventoryIntro = "Opening your Bag of Holding, you find: \n";
		String productIntro = "\nUpon further examination, there are odd looking tentacles \nwrithing around near the product\n";
		String options = "\nPress 1 to look at our items for sale\nPress 2 to sell back your items\nPress 3 to look at your cart\n";
		String sellIntro = "What would you like to sell?\n";
		String purchaseIntro = "Would you like to finalize your transaction?\n";
		String quit = "Press 'q' to return to the main menu.";
		String sellItems = "Press 4 to sell items back to the store\n";
		String checkout = "Press 4 to check out with the items currently in your cart\n";
		String playerGold = "\nYou have " + inventory.getGold() +  " gold.\n";
		String cancel = "\nWhat would you like to remove from your cart?\n";
		String cancelOption = "Press 5 to cancel items from your cart\n";
		
		if(menuSelection.equals("Main"))
		{
			//clearscreen();
			System.out.println(welcome + options + quit);
		}
		/*
		 * cart and endcart selections are a bit convoluted so here's my best explanation
		 * cart displays the player's current cart, then returns to print endcart.
		 * After endcart prints to screen, it calls checkoutlistener to wait for
		 * user input to select items to either return to shelf or complete the sale of
		 * the items in their cart.
		 */
		if(menuSelection.equals("Cart"))
		{
			//clearscreen();
			System.out.println(cartIntro + playerGold);
			displaySalables(inventory, cart, store, "checkout");
		}
		if(menuSelection.equals("EndCart"))
		{
			System.out.println(options + checkout + cancelOption + quit);
			checkoutListener(cart, store, inventory);
		}
		if(menuSelection.equals("Inventory"))
		{
			//clearscreen();
			System.out.println(inventoryIntro + playerGold);
			displaySalables(inventory, cart, store, "sell");
			System.out.println(options + quit);
		}
		if(menuSelection.equals("Product"))
		{
			//clearscreen();
			System.out.println(productIntro + playerGold);
			System.out.println(quit + "\n");
			displaySalables(inventory, cart, store, "browse");

		}
		if(menuSelection.equals("Cancel"))
		{
			System.out.println(cancel + quit);
			displaySalables(inventory, cart, store, "cancel");
		}
		if(menuSelection.equals("Selling"))
		{
			//clearscreen();
			System.out.println(sellIntro + playerGold);
			displaySalables(inventory, cart, store, "sell");
		}
		if(menuSelection.equals("EndSelling"))
		{
			System.out.println(options + sellItems + quit);
			//sellListener(inventory, cart, store);
		}
		if(menuSelection.equals("Purchase"))
		{
			//clearscreen();
			System.out.println(purchaseIntro);
			displaySalables(inventory, cart, store, "checkout");
			System.out.println("Press R to remove items\n" + checkout);
		}
	}
	/**
	 * pseudo-clearScreen. It just prints a bunch of blank lines to spam the console window with nothing.
	 */
	public static void clearScreen()
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.println();
		}
	}
	/**
	 * displaySalables pulls relevant information from player inventory/cart or store
	 * to display the correct options in order to place items in the cart, complete a sale
	 * from the cart, sell items back to the store, or remove items from the cart
	 * @param inventory
	 * @param cart
	 * @param store
	 * @param mode
	 */
	public static void displaySalables(Inventory inventory, Cart cart, ArrayList<Product> store, String mode)
	{		
		if(mode.equals("browse"))
		{
			System.out.println("X O B L O B ' S \nO D D S \nA N D \nE N D S");
			//display shop contents NAME | COST | QTY
			for(int i = 0; i < store.size(); i++)
			{
				int j = i + 1;
				System.out.println( j + ". " + store.get(i).getName() 
							+ " || cost: " + store.get(i).getPrice() + " gold.\n"
							+ "In stock: " + store.get(i).getQuantity()); 
			}
			browseListener(cart, store, inventory);
		}
		if(mode.equals("checkout"))
		{
			//display cart contents NAME | COST | QTY
			for(int i = 0; i < cart.size(); i++)
			{
				int j = i + 1;
				System.out.println(j + ". " + cart.get(i).getName() 
							+ " || cost: " + cart.get(i).getPrice() + " gold.\n"
							+ " In cart: " + cart.get(i).getQuantity());
			}
			displayMenus(inventory, "EndCart", store, cart);
		}
		if(mode.equals("cancel"))
		{
			//display cart contents NAME | COST | QTY
			for(int i = 0; i < cart.size(); i++)
			{
				int j = i + 1;
				System.out.println(j + ". " + cart.get(i).getName()
							+ " || cost: " + cart.get(i).getPrice() + " gold.\n"
							+ " In inventory: " + cart.get(i).getQuantity());
			}
			cancelListener(inventory, cart, store);
		}
		if(mode.equals("sell"))
		{
			//display inventory contents NAME | COST | QTY
			for(int i = 0; i < inventory.size(); i++)
			{
				int j = i + 1;
				System.out.println(j + ". " + inventory.get(i).getName() 
							+ " || cost: " + inventory.get(i).getPrice() + " gold.\n"
							+ " In inventory: " + inventory.get(i).getQuantity());
			}
			displayMenus(inventory, "EndSelling", store, cart);
		}
	}
	/**
	 * custom toString that should print store contents with a new line character between each element
	 */
	public String toString()
	{
		String out = "";
		
		for(int i = 0; i < store.size(); i++)
		{
			out += "\n" + store.get(i).toString();
		}
		
		return out;
	}
	/**
	 * checkoutListener gets the total price for the player's cart, 
	 * making sure that they can afford their whole cart
	 * then allows the purchase, exchanging the items for gold.
	 * @param cart
	 * @param store
	 * @param inventory
	 */
	public static void checkoutListener(Cart cart, ArrayList<Product> store, Inventory inventory)
	{
		Scanner scan = new Scanner(System.in);
		String in = scan.nextLine();
		int total = 0;
		
		//now that we're in a new menu, need old menus
		//to still be able to work even with the new option on 4
		if(in.equals("1"))
		{
			displayMenus(inventory, "Product", store, cart);
		}
		if(in.equals("2"))
		{
			displayMenus(inventory, "Selling", store, cart);
		}
		if(in.equals("3"))
		{
			displayMenus(inventory, "Cart", store, cart);
		}
		if(in.equals("4"))
		{
			for(int i = 0; i < cart.size(); i++)
			{
				total += cart.get(i).getPrice();
			}
			//if player has enough gold for total cart
			if(inventory.getGold() > total)
			{
				for(int i = 0; i < cart.size(); i++)
				{
					inventory.addToInventory(cart.get(i));
					setQuantity(cart.get(i),cart.get(i).getQuantity()-1);
				}
				inventory.setGold(inventory.getGold()-total);
				System.out.println("Exchanged " + total + " gold pieces for the contents of your cart\n\n");
				displayMenus(inventory, "Main", store, cart);
			}
			else
			{
				System.out.println("Not enough gold. You have " + inventory.getGold() + ".\n You need a total of " + total + " gold.");
				displayMenus(inventory, "Cart", store, cart);
			}
		}
		if(in.equals("5"))
		{
			displayMenus(inventory, "Cancel", store, cart);
		}
	}
	/*
	public static void confirm(Inventory inventory, ArrayList<Product> store, int index)
	{
		Scanner scan = new Scanner(System.in);
		String in = scan.nextLine();
		//make them sell for a loss!
		System.out.println("Confirm sale of " + inventory.get(index) + " to the shop for " + store.get(index).getPrice() * 0.8);
		
	}
	
	public static void sellListener(Inventory inventory, Cart cart, ArrayList<Product> store)
	{
		Scanner scan = new Scanner(System.in);
		String in = scan.nextLine();
		
		for(int i = 0; i < inventory.size(); i++)
		{
			int selectionIndex = i - 1;
			if(Integer.parseInt(in) == i)
			{
				confirm(inventory, store, selectionIndex);
			}
		}
	}
	*/
	/**
	 * cancelListener semi-recursively keeps the player within the
	 * options loop to remove an item from their cart until the 'q'
	 * button is pushed. It will display relevant output for which
	 * items are removed from the cart to the player
	 * @param inventory
	 * @param cart
	 * @param store
	 */
	public static void cancelListener(Inventory inventory, Cart cart, ArrayList<Product> store)
	{
		Scanner scan = new Scanner(System.in);
		String in = scan.nextLine();
		if(in.equalsIgnoreCase("q"))
		{
			in = "999";
			displayMenus(inventory, "Cart", store, cart);
		}
		int selectionIndex = Integer.parseInt(in)-1;
		boolean firstLoop = true;
		boolean isValid = false;
		while(!isValid)
		{
			if(cart.size() == 0)
			{
				System.out.println("Nothing remaining in your cart.\nReturning you to the main menu.\n");
				displayMenus(inventory, "Main", store, cart);
			}
			if(!firstLoop)
			{
				in = scan.nextLine();
			}
			if(in.equalsIgnoreCase("q"))
			{
				in = "999";
				displayMenus(inventory, "Main", store, cart);
			}
			if(Integer.parseInt(in) <= cart.size() && Integer.parseInt(in) > 0)
			{
				System.out.println("\nRemoved " + cart.get(selectionIndex).toString() + " from your cart.\n");
				cart.removeFromCart(cart.get(selectionIndex),cart.get(selectionIndex).getQuantity());
				if(cart.size() == 0)
				{
					System.out.println("Nothing remaining in your cart.\nReturning you to the main menu.\n");
					displayMenus(inventory, "Main", store, cart);
				}
				if(cart.size() > 0)
				{
				displayMenus(inventory, "Cancel", store, cart);
				}
			}
			if(in.equalsIgnoreCase("999"))
			{
				isValid = true;
			}
			firstLoop = false;
		}
		
	}
	
	/**
	 * browseListener takes in input for a selected item and adds it to the cart
	 * if the player has enough gold
	 * @param cart
	 * @param store
	 */
	public static void browseListener(Cart cart, ArrayList<Product> store, Inventory inventory)
	{
		Scanner scan = new Scanner(System.in);
		
		int selectionIndex = -1;
		boolean isValid = false;
		String in = "";
		while(!isValid)
		{
			in = scan.nextLine();
			if(!in.equals("1") || !in.equals("2") || !in.equals("3") || !in.equals("4") || !in.equals("q") || !in.equals("5") || !in.equals("6"))
			{
				isValid = true;
			}
			else
			{
				System.out.println("Invalid input. Please select a valid input from the current menu.");
			}
		}
		
		//I hate Java's inability to process numberformatexceptions cleanly,
		//open to suggestions on how to do this better/more cleanly
		if(in.equalsIgnoreCase("q"))
		{
			in = "999";
		}
		selectionIndex = Integer.parseInt(in) - 1;
		for(int i = 0; i < store.size(); i++)
		{
			if(selectionIndex == i)
			{
				if(inventory.canPurchase(store.get(selectionIndex)))
				{
					System.out.println("How many would you like to buy?");
					int qty = scan.nextInt();
					if(store.get(selectionIndex).getQuantity() >= qty)
					{
						cart.addToCart(store.get(selectionIndex),qty);
					}
				}
			}
		}
		if(in.equalsIgnoreCase("999"))
		{
			displayMenus(inventory, "Main", store, cart);
		}
		if(!in.equalsIgnoreCase("999"))
		{
			displayMenus(inventory, "Product", store, cart);
		}
	}
	/**
	 * listener waits for input and directs the player to the correct menu based on their input
	 * @param inventory
	 * @param cart
	 * @param store
	 * @param scan
	 */
	public static void listener(Inventory inventory, Cart cart, ArrayList<Product> store, Scanner scan)
	{
		String in = scan.nextLine();
		String last = "";
		
		if("1".equals(in))
		{
			displayMenus(inventory, "Product", store, cart);
		}
		if("2".equals(in))
		{
			displayMenus(inventory, "Inventory", store, cart);
		}
		if("3".equals(in))
		{
			displayMenus(inventory, "Cart", store, cart);
		}
		if("4".equals(in))
		{
			System.out.println();
		}
		if("q".equalsIgnoreCase(in))
		{
			displayMenus(inventory, "Main", store, cart);
		}
		if("5".equals(in))
		{
			displayMenus(inventory, "Cancel", store, cart);
		}
		if(!in.equals("1") && !in.equals("2") && !in.equals("3") && !in.equals("4") && !in.equalsIgnoreCase("q") && !in.equals("5"))
		{
			System.out.println("You look down as the ground beneath your feet begins to crumble away.\n"
					+ "As you begin to fall, Xoblob casts Bigby's Hand,\nmaterializing an enormous purple-gloved hand hovering in midair,\n"
					+ "quickly grabbing you before you fall and bringing you back to a safer area of the shop.\n");
			displayMenus(inventory, "Main", store, cart);
		}
		if(!last.equals(in))
		{
			last = in.toString();
		}

	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Cart cart = new Cart();
		Inventory inventory = new Inventory();
		store = init();
		inventory.setGold(42069);
		boolean isValidInput = false;
		while(!isValidInput)
		{
			listener(inventory, cart, store, scan);
		}
	}
}