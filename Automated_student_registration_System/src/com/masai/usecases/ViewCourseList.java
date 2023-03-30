package com.masai.usecases;

import java.util.List;
import java.util.function.Consumer;

import com.masai.dao.CourseDAO;
import com.masai.dao.CourseDAOImpl;
import com.masai.dto.CourseDTO;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class ViewCourseList {

	public static void viewCourse() {
		CourseDAO courseDAO = new CourseDAOImpl();
			try {
				List<CourseDTO> courseList = courseDAO.getCourseList();
				System.out.println("=========================================================================");
				System.out.println();
				Consumer<CourseDTO> con = c -> System.out.println("Course Id: " + c.getCourseId() + " Course Name: " +c.getCourseName() 
				+ " Course Duration : " + c.getCourseDuration() + " Course Fee " + c.getFee()
				);
				courseList.forEach(con);
				
				System.out.println();
				System.out.println("=========================================================================");
			}catch(SomethingWentWrongException | NoRecordFoundException ex) {
				System.out.println(ex.getMessage());
			}
		}
}
