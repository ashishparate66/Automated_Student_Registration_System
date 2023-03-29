package com.masai.usecases;

import java.time.LocalDate;
import java.util.Scanner;

import com.masai.dao.BatchDAO;
import com.masai.dao.BatchDAOImpl;
import com.masai.dto.BatchDTO;
import com.masai.dto.BatchDTOImpl;
import com.masai.exception.SomethingWentWrongException;

public class UpdateBatchDetails {

	public static void updateCourseUI(Scanner sc) {
			
			System.out.print("Enter Batch id ");
			String batchId = sc.next();
			System.out.print("Enter Batch name ");
			String batchName = sc.next();
			System.out.print("Enter Batch Start Date ");
			LocalDate batchStartDate = LocalDate.parse(sc.next());
			System.out.print("Enter Batch end Date ");
			LocalDate batchEndDate = LocalDate.parse(sc.next());
			System.out.print("Enter Course name ");
			String courseName = sc.next();
			System.out.print("Enter Course id ");
			int courseId = sc.nextInt();
				
				
			BatchDTO batch = new BatchDTOImpl(batchId, batchName, batchStartDate, batchEndDate,courseName,courseId);
			
			BatchDAO batchDAO = new BatchDAOImpl();
			try {
				batchDAO.updateBatch(batch);
				System.out.println("=========================================================================");
				System.out.println();
				System.out.println("batch update successfully");	
				System.out.println();
				System.out.println("=========================================================================");
			}catch(SomethingWentWrongException ex) {
				System.out.println(ex);
			}
			
		
		}
}
