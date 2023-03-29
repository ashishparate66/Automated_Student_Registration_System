package com.masai.usecases;

import java.util.List;
import java.util.function.Consumer;

import com.masai.dao.StudentDAO;
import com.masai.dao.StudentDAOImpl;
import com.masai.dto.StudentDTO;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class ViewStudentList {
	
	public static void viewStudent() {
	StudentDAO stdDAO = new StudentDAOImpl();
		try {
			List<StudentDTO> stdList = stdDAO.getStudentList();
			System.out.println("=========================================================================");
			System.out.println();
			Consumer<StudentDTO> con = s -> System.out.println("Student Id: " + s.getStdId() + " first Name: " +s.getFirstName() 
			+ " Last Name: " + s.getLastName() + " Address " + s.getAddress()
			+" Mobile: "+s.getMobile()+" email: "+s.getEmail()+" Password: "+s.getPassword()
			+" course ID: "+s.getCourse_id());;
			stdList.forEach(con);
			
			System.out.println();
			System.out.println("=========================================================================");
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
