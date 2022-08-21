package org.system;

public class DesktopSingleInheritance extends ComputerSingleInheritance{
	
	public void desktopSize() {
		System.out.println("-------------------------------");
		System.out.println("Desktop Size of the Computer");
		System.out.println("14 inch");
	}
	
	public static void main(String args[]) {
		ComputerSingleInheritance computer = new ComputerSingleInheritance();
		computer.computerModel();
		
		DesktopSingleInheritance desktop = new DesktopSingleInheritance();
		desktop.desktopSize();
	}

}
