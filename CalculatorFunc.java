package week1.day2;

import java.util.Scanner;

public class CalculatorFunc {
	
	public int calculation(int a, int b) {
		int cal = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("What function to perform(sub/mul/div): ");
		String func = input.nextLine();
		System.out.println("You chose: "+func);
		if(func.equalsIgnoreCase("sub")) {
			 cal = a-b;	
			 System.out.println("subtraction of num1 "+a+" and num2 "+b+" : "+cal);
		}else if(func.equalsIgnoreCase("mul")){
			 cal = a*b;	
			 System.out.println("multiplication of num1 "+a+" and num2 "+b+" : "+cal);
		}else if(func.equalsIgnoreCase("div")) {
			 cal = a/b;
			 System.out.println("division of num1 "+a+" and num2 "+b+" : "+cal);
		}
		
		return cal;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculatorFunc calNumbers = new CalculatorFunc();
		calNumbers.calculation(8, 2);
	}

}
