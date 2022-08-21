package week3.day1Assignment;

public class StudentsMethodOverloadingAssignment {
	
	public void getStudentInfo(int id) {
		System.out.println("This method has only id as argument!");
		System.out.println("Passed ID is: "+id);
	}
	
	public void getStudentInfo(int id, String name) {
		System.out.println("This method has id and name as argument!");
		System.out.println("Passed ID is: "+id+" Passed name is: "+name);
	}
	
	public void getStudentInfo(String emailid,int phonenumber) {
		System.out.println("This method has email-Id and phonenumber as argument!");
		System.out.println("Passed email-Id is: "+emailid+" Passed phonenumber is: "+phonenumber);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentsMethodOverloadingAssignment stud = new StudentsMethodOverloadingAssignment();
		stud.getStudentInfo(100);
		stud.getStudentInfo(100, "Kp");
		stud.getStudentInfo("kp@gmail.com", 123456789);
	}

}
