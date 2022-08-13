package week1Assignments;

public class CalculatorAssignment {
	
	public int addition(int a, int b, int c) {
		int sum = a+b+c;
		System.out.println("Sum of 3 numbers: "+sum);
		return sum;
	}
	
	public int subtraction(int a, int b) {
		int sub = a-b;
		System.out.println("Subtraction of 2 numbers: "+sub);
		return sub;
	}
	
	public double multiplication(double a, double b) {
		double product = a*b;
		System.out.println("Multiplication of 2 numbers: "+product);
		return product;
	}
	
	public float divide(float a, float b) {
		float product = a/b;
		System.out.println("Division of 2 numbers: "+product);
		return product;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculatorAssignment calc = new CalculatorAssignment();
		calc.addition(5, 7, 8);
		calc.subtraction(8, 4);
		calc.multiplication(854826, 654982165);
		calc.divide(827.08f, 4.056f);

	}

}
