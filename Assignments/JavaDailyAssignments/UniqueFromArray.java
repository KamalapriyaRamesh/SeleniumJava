package javaCodingPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UniqueFromArray {
		
		public static void main(String[] args) {
			int[] array = {4,1,2,1,2};
			HashMap<Integer,Integer> map = new HashMap<>(array.length);
			for (int num : array) {
				Integer occ = map.get(num);
				map.put(num, occ==null ? 1: occ+1);
			}
			
			for (Map.Entry<Integer, Integer> i : map.entrySet()) {
				if(i.getValue()==1) 
					System.out.println("Unique number from the array: "+ i.getKey());
			}
				
	}

}
