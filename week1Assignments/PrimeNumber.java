package week1Assignments;

public class PrimeNumber {
	
	 int i = 2;

	// Function check whether a number
	// is prime or not
	public boolean isPrime(int n)
	{
		
		// Case1: Corner cases
		if (n == 0 || n == 1)
			return false;

		// Case2: Checking Prime
		if (n == i)
			return true;
			
		// Case3: Base cases
		if (n % i == 0)
			return false;
		i++;

		return isPrime(n);
	}

		public static void main(String[] args)
		{
			PrimeNumber prm = new PrimeNumber();
			if (prm.isPrime(3))
			{
				System.out.println("true");
			}
			else
			{
				System.out.println("false");
			}
		}

		// This code is contributed by divyeshrabadiya07


	}

