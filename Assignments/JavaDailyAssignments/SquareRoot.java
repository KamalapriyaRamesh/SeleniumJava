package javaCodingPractice;

public class SquareRoot {
	
	public static int squareRoot(int num) {
		int temp;
		int squar = num/2;
		
		do {
			temp = squar;
			squar = (temp+(num/temp))/2;			
		}while((temp-squar)!=0);
		return squar;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The Square root of given number: "+squareRoot(16));
	}

}
