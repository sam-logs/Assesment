package com.assesment2.ashaSoftware;
import java.util.*;
import java.lang.*;
public class Distance {
static Scanner sc = new Scanner(System.in);

	public static double distance()
	{
		System.out.println("Enter Lattitude: ");
		double lon = sc.nextDouble();
		System.out.println("Enter Longitude: ");
		double lat = sc.nextDouble();
		

		lon = Math.toRadians(lon);

		lat = Math.toRadians(lat);

		double a = Math.pow(Math.sin(lat / 2), 2)
				+ Math.cos(lat) * Math.cos(lat)
				* Math.pow(Math.sin(lon / 2),2);

		double res = 2 * Math.asin(Math.sqrt(a));
		System.out.println("Enter Radius");
		double radius = sc.nextDouble();		
		double dis = res*radius;
		
		return(dis);
		
	}
	
	public void display() {
		System.out.println(distance());
	}

}
