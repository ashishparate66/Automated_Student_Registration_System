package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.StudentDAO;
import com.masai.dao.StudentDAOImpl;
import com.masai.exception.SomethingWentWrongException;

public class DeleteStudent {

	public static void deleteStudentUI(Scanner sc) {
		System.out.print("Enter registered gmail ");
		String email = sc.next();
		
		//take an object of DAO
		StudentDAO studentDAO = new StudentDAOImpl();
		
		try {
			//call the update employee method
			studentDAO.deleteStudent(email);
			//print success message
			System.out.println("Student deleted successfully");
		}catch(SomethingWentWrongException ex) {
			//print error message if error if there
			System.out.println(ex);
		}
	}
}
