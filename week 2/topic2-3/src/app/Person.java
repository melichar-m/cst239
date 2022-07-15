package app;
/**
 * generic person class with overrides for equals and toString
 * @author michael melichar
 *
 */
public class Person 
{
	private String firstName = "Mike";
	private String lastName = "Melichar";
	/**
	 * create a person object with a string firstName and string lastName
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	/**
	 * create a person object with a person object
	 * @param person
	 */
	public Person(Person person)
	{
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
	}
	/**
	 * gets firstName
	 * @return firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}
	/**
	 * gets lastName
	 * @return lastName
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(other == this)
		{
			System.out.println("I am here in other == this");
			return true;
		}
		if(other == null)
		{
			System.out.println("I am here in other == null");
			return false;
		}
		if(getClass() != other.getClass())
		{
			System.out.println("I am here in getClass() != other.getClass()");
			return false;
		}
		Person person = (Person)other;
		return (this.firstName == person.firstName && this.lastName == person.lastName);
	}
	
	@Override
	public String toString()
	{
		return "My class is " + getClass() + " " + this.firstName + " " + this.lastName;
	}
}
