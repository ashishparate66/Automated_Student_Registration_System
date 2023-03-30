package com.masai.usecases;

import java.util.Scanner;

public class Studentmenu {
	
	static void displayUserMenu() {
		System.out.println("========================*** Welcome ***==========================");
		System.out.println();
		
		System.out.println("1. Can Update Personel Details");
		System.out.println("2. Can Change Password");
		System.out.println("3. Can See All the Availble Course List");
		System.out.println("4. Can see All Batches Course Wise along with available Seats");
		System.out.println("5. Registered himself Course");
		System.out.println("6. Delete Acoount");
		System.out.println("0. Logout Account");
		
		System.out.println();
		System.out.println("=========================================================================");
	}
	
	public static void studentLogin(Scanner sc) {
		if(!StudentUI.login(sc))
			return;
		//you are here means login is successful
		int choice = 0;
		do {
			displayUserMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					UpdateStudentDetails.UpdateStudent(sc);
					break;
				case 2:
					UpdatePassword.updatepassword(sc);
					break;
				case 3:
					ViewCourseList.viewCourse();
					break;
				case 4:
					//userUI.updateNameOfUser();
					break;
				case 5:
					//userUI.changePassword();
					break;
				case 6:
					//userUI.deleteUser();
				case 0:
					StudentUI.logout();
					break;
				default:
					System.out.println("Invalid Selection, try again");
			}
		}while(choice != 0);
	}
}
