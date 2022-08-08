package week1Assignments;

import java.util.Arrays;

public class MissingElementInAnArrayAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,2,3,4,7,6,8};
		Arrays.sort(arr);
		int n = arr.length;
		int sum = (n+1)*(n+2)/2;
		for(int i=0; i<=n-1;i++) {
			System.out.println("numbers in the array: "+arr[i]);
			sum = sum -arr[i];
		}
		
		System.out.println("Missing number from the array: "+sum);

	}

}
