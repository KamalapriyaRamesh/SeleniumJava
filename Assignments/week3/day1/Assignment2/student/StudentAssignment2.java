package org.student;

import org.department.DepartmentAssignment2;

public class StudentAssignment2 extends DepartmentAssignment2{
	
	public void studentName() {
		System.out.println("studentName: Kamalapriya");
	}
	
	public void studentDept() {
		System.out.println("studentDept: 123");
	}
	
	public void studentId() {
		System.out.println("studentId: 801323456");
	}
	
	
	public static void main(String args[]) {
		StudentAssignment2 student = new StudentAssignment2();
		student.collegeName();
		student.collegeCode();
		student.collegeRank();
		student.deptName();
		student.studentName();
		student.studentDept();
		student.studentId();
		
	}

}
