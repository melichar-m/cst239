package app;

import java.util.Scanner;

public class Cylinder
{
	private double volume;
	private double radius;
	private double height;
	
	public Cylinder(double radius, double height)
	{
		this.radius = radius;
		this.height = height;
	}
	
	public double computeVolume()
	{
		this.volume = this.height * Math.pow(this.radius,2) * Math.PI;
		return this.volume;
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter radius: ");
		double radius = scan.nextDouble();
		System.out.println("Enter height: ");
		double height = scan.nextDouble();
		Cylinder c = new Cylinder(radius, height);
		System.out.println("Volume: " + c.computeVolume() + " units");
	}
}