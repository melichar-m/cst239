package app;
/**
 * Test contains the main method to test equivalency between
 * many methods as we override the equals method in order to
 * show how overriding and equivalency work in java
 * @author michael melichar
 *
 */
public class Test 
{
	public static void main(String[] args)
	{
		Person person1 = new Person("Andrew","Callaghan");
		Person person2 = new Person("Jack","Black");
		Person person3 = new Person(person1);
		
		if(person1==person2)
			System.out.println("These persons are identical using ==");
		else
			System.out.println("These persons are not identical using ==");
		
		if(person1.equals(person2))
			System.out.println("These persons are identical using ==");
		else
			System.out.println("These persons are not identical using ==");
		
		if(person1.equals(person3))
			System.out.println("These copied person are identical using equals()");
		else
			System.out.println("These copied person are not identical using equals()");
		
		System.out.println(person1);
		System.out.println(person2.toString());
		System.out.println(person3);
	}
}
