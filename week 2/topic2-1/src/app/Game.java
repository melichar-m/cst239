package app;

import java.util.Random;

public class Game 
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		
		System.out.println("Creating superheroes");
		Superman clarkKent = new Superman(rand.nextInt(999)+1);
		Batman whinyRichOrphan = new Batman(rand.nextInt(999)+1);
		System.out.println("Superheroes created");
		
		/* I included these to give a slight bit more information since 
		 * there really isn't anything to say starting health, and 
		 * just what the damage ends up being
		 */
		System.out.println(String.format("%s: %d Starting health", whinyRichOrphan.getName(),whinyRichOrphan.getHealth()));
		System.out.println(String.format("%s: %d Starting health", clarkKent.getName(),clarkKent.getHealth()));
		System.out.println("FIGHT!");
		while(!clarkKent.isDead() && !whinyRichOrphan.isDead())
		{
			clarkKent.attack(whinyRichOrphan);
			whinyRichOrphan.attack(clarkKent);
			if(clarkKent.isDead())
			{
				System.out.println("Batman wins!");
			}
			if(whinyRichOrphan.isDead())
			{
				System.out.println("Superman wins!");
			}
		}
	}
}
