package week3.day2Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] miss = {6, 7, 10, 11, 13};
		
		Set<Integer> set = new TreeSet<Integer>();  //To get unique values alone
		
		for(int i=0; i< miss.length ;i++) {
			set.add(miss[i]);
		}
		System.out.println(set);
		
		List<Integer> list = new ArrayList<Integer>(set);  //Conversion is needed to do operation based on index value as 'Set' does not support indexing
		int listSize = list.size();
		System.out.println("listSize: "+listSize);
		
		int j = 0; //To move to next element in the list and j-> represent the index of the array
		for(int i=list.get(0);i<=list.get(listSize-1);i++) {  //i-> represent the value of the array
			if(list.get(j) == i) {
				j++; 
//				System.out.println("i= "+i);
//				System.out.println("j= "+j);
			}else {
				System.out.println("Missing numbers: "+i);
			}
		}
		
		

	}

}
