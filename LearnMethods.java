package week1.day2;

public class LearnMethods {
	
	public String getLocation() {
		return "Chennai";
	}
	
	public int addTwoNumbers(int a, int b) {
		int c = a+b;
		return c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LearnMethods method = new LearnMethods();
		String loc = method.getLocation();
		System.out.println(loc);
		int sum = method.addTwoNumbers(5, 6);
		System.out.println("Adding two numbers: "+sum);
	}

}
