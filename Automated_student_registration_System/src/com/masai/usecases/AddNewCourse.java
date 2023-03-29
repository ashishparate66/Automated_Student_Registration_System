package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.CourseDAO;
import com.masai.dao.CourseDAOImpl;
import com.masai.dto.CourseDTO;
import com.masai.dto.CourseDTOImpl;
import com.masai.exception.SomethingWentWrongException;

public class AddNewCourse {

	public static void addCourse(Scanner sc) {
		System.out.print("Enter Course id ");
		String courseId = sc.next();
		System.out.print("Enter Course name ");
		String courseName = sc.next();
		System.out.print("Enter Course Duration ");
		int courseDuration = sc.nextInt();
		System.out.print("Enter fee ");
		int fee = sc.nextInt();
		
		
		//stuff data to DTO
		CourseDTO course = new CourseDTOImpl(courseId, courseName, courseDuration, fee);
		
		CourseDAO courseDAO = new CourseDAOImpl();
		try {
			courseDAO.addCoursedao(course);
			System.out.println("=========================================================================");
			System.out.println();
			System.out.println("Course added successfully");
			System.out.println();
			System.out.println("=========================================================================");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}
}
