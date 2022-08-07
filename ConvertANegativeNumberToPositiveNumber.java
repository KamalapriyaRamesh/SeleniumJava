package week1.day1;

import java.util.Scanner;

public class ConvertANegativeNumberToPositiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a number to convert to positive number: ");
		int number= sc.nextInt();
		if(number<0) {
			int convnum = number * -1;
			System.out.println("The converted number: "+convnum);
		}

	}

}
