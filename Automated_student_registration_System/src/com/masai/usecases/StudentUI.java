package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.StudentloginDAO;
import com.masai.dao.StudentrloginDAOImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class StudentUI {

		static boolean login(Scanner sc) {
			System.out.print("Enter email ");
			String email = sc.next();
			System.out.print("Enter password ");
			String password = sc.next();
			StudentloginDAO stDAO = new StudentrloginDAOImpl();
			try {
				stDAO.login(email, password);
			}catch(SomethingWentWrongException | NoRecordFoundException ex) {
				System.out.println(ex);
				return false;
			}
			return true;
		}
		
		static void logout() {
			StudentloginDAO stDAO = new StudentrloginDAOImpl();
			stDAO.logout();
		}
	}

