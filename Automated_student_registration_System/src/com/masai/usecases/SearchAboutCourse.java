package com.masai.usecases;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import com.masai.dao.CourseDAO;
import com.masai.dao.CourseDAOImpl;
import com.masai.dto.CourseDTO;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class SearchAboutCourse {
	
	public static void searchCourse(Scanner sc) {
		System.out.println("-----------------------------------");
		System.out.println("Enter  Course Name");
		System.out.println("------------------------------------");
		String courseName = sc.next();
		//take an object of DAO
		CourseDAO courseDAO = new CourseDAOImpl();
		try {
			System.out.println("=========================================================================");
			System.out.println();
			
			List<CourseDTO> courseList = courseDAO.searchCourseWithName(courseName);
			Consumer<CourseDTO> con = c -> System.out.println("Course ID " + c.getCourseId() + " CourseName " + c.getCourseName() 
			+ " Course Duration " + c.getCourseDuration() + " Course fee " + c.getFee());
			courseList.forEach(con);
			System.out.println();
			System.out.println("=========================================================================");
			
			
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
