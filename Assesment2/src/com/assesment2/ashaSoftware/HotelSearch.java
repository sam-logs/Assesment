package com.assesment2.ashaSoftware;

import java.util.Iterator;
import java.util.Vector;

public class HotelSearch implements SearchHotel {
	public void findHotel() {
		// TODO Auto-generated method stub
		//searching hotels which is nearby user i.e. within 1.5km radius.
		Vector<String> vec = new Vector<String>();
		vec.add("Taj");
		vec.add("Biryani Mahal");
		vec.add("Picnic Garden");
		vec.add("Grand Paradise");
		System.out.println("Displaying Hotels Within 1.5kms nearby you!!!");
		Iterator itr=vec.iterator();
		while(itr.hasNext()){  
			System.out.println(itr.next()); 
		} 
	}
	public void distanceHotels() {	
		//searching hotels which is little far by user i.e. within 2.5km radius.
		System.out.println("Displaying Hotels Within 2.5 km radius!!!");
		Vector<String> vec1 = new Vector<String>();
		vec1.add("Taj");
		vec1.add("Biryani Mahal");
		vec1.add("Picnic Garden");
		vec1.add("Grand Paradise");
		vec1.add("Panache");
		vec1.add("Gargee Grand");
		vec1.add("HBT");
		vec1.add("Raj Resort");
		vec1.add("Takshak");
		vec1.add("SitiLite");

		Iterator itr=vec1.iterator();
		while(itr.hasNext()){  
			System.out.println(itr.next()); 
		}

	}


}
