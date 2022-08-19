package week1.day2;

public class CarDetailsAndCalc {
	
	public String brand() {
		return "BMW";
	}
	
	public String colour() {
		return "Mac Black";
	}
	
	public int EngineNumber() {
		return 8661542;
	}
	
	public int subtraction(int a, int b) {
		int sub = a-b;	
		return sub;
	}
	
	public int multiplication(int a, int b) {
		int mul = a*b;	
		return mul;
	}
	
	public int division(int a, int b) {
		int div = a/b;
		return div;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarDetailsAndCalc cdc = new CarDetailsAndCalc();
		String brand = cdc.brand();
		System.out.println("Car Brand: "+brand);
		String colour = cdc.colour();
		System.out.println("Car Colour: "+colour);
		int engineNumber = cdc.EngineNumber();
		System.out.println("Engine Number: "+engineNumber);
		int subtraction = cdc.subtraction(52, 22);
		System.out.println("subtraction of 2 numbers: "+subtraction);
		int multiplication = cdc.multiplication(9, 6);
		System.out.println("multiplication of 2 numbers: "+multiplication);
		int division = cdc.division(4, 2);
		System.out.println("division of 2 numbers: "+division);
	}

}
