package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.util.Util;

public class JDBCCrud {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		char enter;
		do {
			System.out.println("enter choice");
			System.out.println("1.insert");
			System.out.println("2.display");
			System.out.println("3.update");
			System.out.println("4.delete");

			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				Util.insertStatement();
				break;
			case 2:
				Util.selectStatement();
				break;
			case 3:
				Util.updateName();
				break;
			case 4:
				Util.deleteName();
				break;
			default:
				System.out.println("enter correct choice ");
				break;

			}

			enter = scanner.next().charAt(0);

		} while (enter != 'n');
	}
}
