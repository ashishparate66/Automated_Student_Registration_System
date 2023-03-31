package com.masai.UI;

import java.util.Scanner;

import com.masai.usecases.Adminmenu;
import com.masai.usecases.ConsoleColors;
import com.masai.usecases.StudentSignUp;
import com.masai.usecases.Studentmenu;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		do {
			System.out.println(ConsoleColors.BLUE_BOLD+"*********"+ConsoleColors.PURPLE_BOLD+"Select your Option"+ConsoleColors.BLUE_BOLD+"**********"+ConsoleColors.RESET );
			
			System.out.println();
			System.out.println(ConsoleColors.RED_BOLD+ConsoleColors.TEAL_BACKGROUND+"|           1. Admin Login           |");
			System.out.println("|           2. Student Sign Up       |");
			System.out.println("|           3. Student Log In        |");
			System.out.println("|           0. Exit                  |"+ConsoleColors.RESET);
			System.out.println();
			System.out.println(ConsoleColors.BLUE_BOLD+"**************************************"+ConsoleColors.RESET);
			choice = sc.nextInt();
			switch(choice) {
				case 0:
					System.out.println(ConsoleColors.GREEN_BOLD+"Thank you, Visit again"+ConsoleColors.RESET);
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
