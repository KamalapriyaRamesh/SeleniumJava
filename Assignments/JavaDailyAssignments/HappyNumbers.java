package javaCodingPractice;

public class HappyNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5;
		int temp1, sqrVal = 0;
		while (i > 4) {
			while (i > 0) {
				temp1 = i % 10;
				sqrVal = sqrVal + (temp1 * temp1);
				System.out.println("sqrVal: " + sqrVal);
				i = i / 10;
				System.out.println("i: " + i);
			}
			i = sqrVal;
			System.out.println("i outside: " + i);
			sqrVal = 0;
		}

		if (i == 1) {
			System.out.println("The given number is a Happy number!");
		} else {
			System.out.println("It is not a happy number!");
		}

	}

}
