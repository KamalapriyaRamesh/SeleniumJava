package week3.day1Assignment;

public class AxisBankAssignment extends BankInfoAssignment{
	
	public void deposit() {
		System.out.println("deposit method from AxisBank class");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AxisBankAssignment axis = new AxisBankAssignment();
		axis.saving();
		axis.fixed();
		axis.deposit();
	}

}
