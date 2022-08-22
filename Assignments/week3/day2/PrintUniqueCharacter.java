package week3.day2Assignments;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name = "Kamala";
		char[] ch = new char[name.length()];
		
		for(int i=0;i<name.length();i++) {
			ch[i] = name.charAt(i);
		}
		
		Set<Character> nameSet = new HashSet<Character>();
		
		for(int i=0;i<ch.length;i++) {
			nameSet.add(ch[i]);
		}
		
		System.out.println(nameSet);
		
	}

}
