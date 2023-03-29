package com.masai.UI;

import java.util.Scanner;

import com.masai.usecases.Adminmenu;
import com.masai.usecases.StudentSignUp;
import com.masai.usecases.Studentmenu;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		do {
			System.out.println("=============Select your Option================");
			System.out.println("1. Admin Login\n2. Student Sign Up\n3. Student Log In \n0. Exit");
			System.out.println("================================================");
			choice = sc.nextInt();
			switch(choice) {
				case 0:
					System.out.println("Thank you, Visit again");
					break;
				case 1:
					Adminmenu.adminLogin(sc);
					break;
				case 2:
					StudentSignUp.addStudent(sc);
					break;
				case 3:
					Studentmenu.studentLogin(sc);
					break;
				default:
					System.out.println("Invalid Selection, try again");
			}
		}while(choice != 0);
		sc.close();
		
	}
}
