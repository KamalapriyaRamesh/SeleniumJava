package week1Assignments;

public class PrintDuplicatesInArrayAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {14,12,13,11,15,14,18,16,17,19,18,17,20};
		int arrLen = arr.length;
		
		for(int i=0; i<=arrLen-1;i++) {
			for(int j=i+1; j<=arrLen-1;j++) {
				if(arr[i]==arr[j]) {
					System.out.println(arr[j]);
				}
			}
			
		}

	}

}
