package app;

public class Person
{
	private int age;
	private String firstName;
	private String lastName;
	private double weight;
	private double height;
	
	/**
	 * Initialize a person based on some but not all of a
	 * person's basic features.
	 * 
	 * @param age
	 * @param firstName
	 * @param lastName
	 * @param weight
	 * @param height
	 */
	public Person(int age, String firstName, String lastName,
				double weight, double height)
	{
		super();
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.weight = weight;
		this.height = height;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
	
	/**
	 * An example method that takes no parameters,
	 * and does absolutely nothing but print a 
	 * silly message to the console.
	 */
	public void walk()
	{
		System.out.println("I'm walk()ing here!");
	}
	
	/**
	 * An example method that takes a double, distance
	 * and doesn't use it to do anything!
	 * @param distance
	 */
	public void run(double distance)
	{
		System.out.println("I'm run()ning!");
	}
	/**
	 * An example method that takes a sleeping duration as a double
	 * and uses it for a tailored output message into the console
	 * @param duration
	 */
	public void sleep(double duration)
	{
		System.out.println("Zzz... sleeping for " + duration + " hours... Zzz...");
	}
	
	public static void main(String[] args)
	{
		//initializing Steve Harrington, approximately 160lbs, 5'11"(11/12=0.91666...)
		Person person = new Person(18, "Steve", "Harrington", 160, 5.9167);
		System.out.println("My name is " + person.getFirstName() + " " + person.getLastName());
		person.walk();
		person.run(10);
		person.sleep(8);
	}
}