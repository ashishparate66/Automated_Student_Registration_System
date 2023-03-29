package com.masai.usecases;

import java.util.List;
import java.util.function.Consumer;

import com.masai.dao.BatchDAO;
import com.masai.dao.BatchDAOImpl;
import com.masai.dto.BatchDTO;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class ViewBatchList {

	
	public static void viewBatch() {
		BatchDAO batchDAO = new BatchDAOImpl();
			try {
				List<BatchDTO> stdList = batchDAO.getBatchList();
				System.out.println("=========================================================================");
				System.out.println();
				Consumer<BatchDTO> con = s -> System.out.println("Batch Id: " + s.getBatchId() + " Batch Name: " +s.getBatchName() 
				+ " Batch Start Date: " + s.getBatchStartDate() + " Batch End Date " + s.getBatchEndDate()
				+" Course Name: "+s.getCourseName()+" Course ID: "+s.getCourseId());
				stdList.forEach(con);
				
				System.out.println();
				System.out.println("=========================================================================");
			}catch(SomethingWentWrongException | NoRecordFoundException ex) {
				System.out.println(ex.getMessage());
			}
		}
}
