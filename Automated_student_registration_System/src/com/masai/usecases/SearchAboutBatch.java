package com.masai.usecases;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import com.masai.dao.BatchDAO;
import com.masai.dao.BatchDAOImpl;
import com.masai.dto.BatchDTO;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class SearchAboutBatch {
	
	public static void searchCourse(Scanner sc) {
		System.out.println("----------------------------------------------");
		System.out.println();
		
		System.out.println("Enter  Batch id");
		
		System.out.println();
		System.out.println("------------------------------------------------");
		String batchId = sc.next();
		//take an object of DAO
		BatchDAO batchDAO = new BatchDAOImpl();
		try {
			System.out.println("=========================================================================");
			System.out.println();
			List<BatchDTO> batchList = batchDAO.searchBatchWithId(batchId);
			Consumer<BatchDTO> con = c -> System.out.println("Batch ID " + c.getBatchId() + " BatchName " + c.getBatchName() 
			+ " Batch Start Date " + c.getBatchStartDate() + " Batch End Date " + c.getBatchEndDate() + " Course Name "+c.getCourseName()+" course id "+c.getCourseId());
			
			
			batchList.forEach(con);
			System.out.println();
			System.out.println("=========================================================================");
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
