package app;

public class HelloWorld 
{
	/**
	 * Prints an entered string, presumably the user's name in chat after "Hello, my name is"
	 * @param name
	 */
	private void sayHello(String name)
	{
		System.out.println("Hello, my name is " + name);
	}
	
	public static void main(String[] args)
	{
		HelloWorld hello = new HelloWorld();
		hello.sayHello("Mike");
	}
}