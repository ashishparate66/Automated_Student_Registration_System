package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.StudentDAO;
import com.masai.dao.StudentDAOImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class UpdatePassword {

	public static void updatepassword(Scanner sc) {
		System.out.println("=========================================================================");
		System.out.println();
		
		System.out.println("Enter Old Password");
		String password = sc.next();
		System.out.println("Enter New Password");
		String Newpassword = sc.next();
		System.out.println("=========================================================================");
		StudentDAO stdDAO = new StudentDAOImpl();
		try {
			stdDAO.updatePasswordDao(password, Newpassword);
			System.out.println("=========================================================================");
			System.out.println();
			System.out.println("********Password Update Successfully*********");
			System.out.println();
			System.out.println("=========================================================================");
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex);
			
		}
	}
}
