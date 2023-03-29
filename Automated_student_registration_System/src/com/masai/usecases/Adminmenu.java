package com.masai.usecases;

import java.util.Scanner;

public class Adminmenu {

	static void displayAdminMenu() {
		
		System.out.println("\n1. Add new Course");
		System.out.println("2. Search about the Course");
		System.out.println("3. Update Details of Course");
		System.out.println("4. Create a batch under a course");
		System.out.println("5. Search information about batch");
		System.out.println("6. Update details of batch");
		System.out.println("7. View Student Details");
		System.out.println("8. View the List of Batch");
		System.out.println("9. Total student every batch");
		System.out.println("10.Total Batches And Total student every Course");
		System.out.println("0. Log out Admin");
	}
	
	static void adminMenu(Scanner sc) {
		int choice = 0;
		do {
			displayAdminMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			switch(choice) {
				case 0:
					System.out.println("Logout admin");
					break;
				case 1:
					AddNewCourse.addCourse(sc);
					break;
				case 2:
					SearchAboutCourse.searchCourse(sc);
					break;
				case 3:
					UpdateCourseDetails.updateCourseUI(sc);
					break;
				case 4:
					AddNewBatch.addBatch(sc);
					break;
				case 5:
					SearchAboutBatch.searchCourse(sc);
					break;
				case 6:
					UpdateBatchDetails.updateCourseUI(sc);
					break;
				case 7:
					ViewStudentList.viewStudent();
					break;
				case 8:
					ViewBatchList.viewBatch();
					break;
				default:
					System.out.println("Invalid Selection, try again");
			}
		}while(choice != 0);
	}
	
	
	public static void adminLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			adminMenu(sc);
		}else {
			System.out.println("Invalid Username and Password");
		}
	}
}
