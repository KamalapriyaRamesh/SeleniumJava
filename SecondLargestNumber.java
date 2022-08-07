package week1.day2;

import java.util.Arrays;

public class SecondLargestNumber {
	
	public void findSecondLargest() {
		int[] numbers = {22,67,98,1,34,58,99};
		int first,second;
		Arrays.sort(numbers);
		for(int i=0;i<=numbers.length-1;i++) {
			System.out.println("Sorted Array: "+numbers[i]);
		}
			System.out.println("-----------------------");
			System.out.println("Second largest number: "+numbers[numbers.length-2] );
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecondLargestNumber sln = new SecondLargestNumber();
		sln.findSecondLargest();
	}

}
