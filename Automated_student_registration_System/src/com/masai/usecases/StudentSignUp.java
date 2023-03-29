package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.StudentDAO;
import com.masai.dao.StudentDAOImpl;
import com.masai.dto.StudentDTO;
import com.masai.dto.StudentDTOImpl;
import com.masai.exception.SomethingWentWrongException;

public class StudentSignUp {

	public static void addStudent(Scanner sc) {
		System.out.println("=========================================================================");
		System.out.println();
		
		System.out.print("Enter student id ");
		String stdId = sc.next();
		System.out.print("Enter student first name ");
		String firstName = sc.next();
		System.out.print("Enter student last name ");
		String lastName = sc.next();
		System.out.print("Enter address ");
		String address = sc.next();
		System.out.print("Enter mobile ");
		String mobile = sc.next();
		System.out.print("Enter email ");
		String email = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		System.out.print("Enter course_id ");
		int course_id = sc.nextInt();
		
		System.out.println();
		System.out.println("=========================================================================");
		
		//stuff data to DTO
		StudentDTO student = new StudentDTOImpl(stdId, firstName, lastName, address, mobile, email, password, course_id);
		
		StudentDAO stdDAO = new StudentDAOImpl();
		try {
			stdDAO.addStudentdao(student);
			System.out.println("=========================================================================");
			System.out.println();
			System.out.println("Student added successfully");	
			System.out.println();
			System.out.println("=========================================================================");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}
}
