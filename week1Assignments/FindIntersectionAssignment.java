package week1Assignments;

public class FindIntersectionAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = {3,2,11,4,6,7};
		int[] arr2 = {1,2,8,4,9,7};
		
		for(int i=0; i<=arr1.length-1;i++) {
			for(int j=0; j<=arr2.length-1;j++) {
				if(arr1[i]==arr2[j]) {
					System.out.println("Common numbers present in array1: "+arr1[i]);
				}
			}
		}

	}

}
