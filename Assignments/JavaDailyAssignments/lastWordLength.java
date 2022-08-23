package javaCodingPractice;

import java.util.Scanner;

public class lastWordLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the sentence: ");
		String s = scan.nextLine();
		String[] s1 = s.split(" ");
		String s2 = s1[s1.length-1];
		System.out.println("The Last word of the given sentence: "+s2);
		int length = s2.length();
		System.out.println("Length of the last word: "+length);
	}

}
