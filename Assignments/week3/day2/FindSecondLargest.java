package week3.day2Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] data = {3,2,11,4,6,7,2,3,3,6,7};
		
		Set<Integer> sec = new TreeSet<Integer>(); //Treeset is used to remove all duplicate data
		for(int i=0;i<data.length;i++) {
			sec.add(data[i]);
		}
		
		List<Integer> list = new ArrayList<>(sec); //Passing set as an arg here will convert set to List
		System.out.println(list);
		
		//Method 1: using Math.max function
		int largest = 0,secondL = 0;
		
		for(int i = 0; i < list.size(); i++)
	    {
	        largest = Math.max(largest, list.get(i));
	    }
		
		for(int i = 0; i < list.size(); i++)
	    {
	        if (list.get(i) != largest)
	        	secondL = Math.max(secondL, list.get(i));
	    }
		System.out.println("Second largest value: "+secondL);
		
		//Method 2: Using list.get
		System.out.println(list.get(list.size() -2));
	}
}


