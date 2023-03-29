package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.CourseDAO;
import com.masai.dao.CourseDAOImpl;
import com.masai.dto.CourseDTO;
import com.masai.dto.CourseDTOImpl;
import com.masai.exception.SomethingWentWrongException;

public class UpdateCourseDetails {
	
	public static void updateCourseUI(Scanner sc) {
		
		System.out.print("Enter Course Id ");
		String courseId = sc.next();
		
		System.out.print("Enter Course name ");
		String courseName = sc.next();
		
		System.out.print("Enter Course Duration ");
		int courseDuration = sc.nextInt();
		
		System.out.print("Enter Course Fee ");
		int fee = sc.nextInt();
		
		
		
		//Create an object of DTO
		CourseDTO course = new CourseDTOImpl(courseId,courseName, courseDuration, fee);
		
				//take an object of DAO
		CourseDAO courseDAO = new CourseDAOImpl();
		
		try {
			//call the update employee method
			courseDAO.updateCourse(course);
			//print success message
			System.out.println("=========================================================================");
			System.out.println();
			System.out.println("Course updated successfully");
			System.out.println();
			System.out.println("=========================================================================");
		}catch(SomethingWentWrongException ex) {
			//print error message if error if there
			System.out.println(ex);
		}
	}
	
	
}
