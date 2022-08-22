package week3.day2Assignments;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String company = "PayPal";
		char[] companyCharArray = new char[company.length()];
		
		for(int i=0;i<company.length();i++) {
			companyCharArray[i] = company.charAt(i);
		}
		
		Set<Character> charSet = new HashSet<Character>();
		Set<Character> dupCharSet = new HashSet<Character>();
		
		for(int i=0; i<companyCharArray.length;i++) {
			if(companyCharArray[i]!=(' ')) {
				if(charSet.add(companyCharArray[i])==false) {
					dupCharSet.add(companyCharArray[i]);
				}else {
					charSet.add(companyCharArray[i]);
				}
			}
		}
		
		System.out.println("Duplicate characters in the string: "+dupCharSet);

	}

}
