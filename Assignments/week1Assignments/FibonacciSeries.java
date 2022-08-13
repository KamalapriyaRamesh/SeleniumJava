package week1Assignments;

public class FibonacciSeries {
	
	public void fibonacci() {
		int num1=0,num2=1,temp=0;
		System.out.print(num1+ " "+num2);
		for(int i=0;i<10;i++) {
		temp = num1+num2;
		System.out.print(" "+temp);
		num1=num2;
		num2=temp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FibonacciSeries fib = new FibonacciSeries();
		fib.fibonacci();
	}

}
