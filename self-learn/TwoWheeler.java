package week1.day1;

public class TwoWheeler {
	
	int noOfWheels = 2;
	short noOfMirrors = 4566;
	long chassisNumber = 546126873;
	boolean isPunctured = true;
	String bikeName="Jawa";
	double runningKM=8962.545;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoWheeler obj = new TwoWheeler();
		System.out.println("Number of wheels: " +obj.noOfWheels);
		System.out.println("Number of Mirrors: " +obj.noOfMirrors);
		System.out.println("Chassis Number: " +obj.chassisNumber);
		System.out.println("Puncture Status: " +obj.isPunctured);
		System.out.println("Bike Name: " +obj.bikeName);
		System.out.println("Km run: " +obj.runningKM);
	}

}
