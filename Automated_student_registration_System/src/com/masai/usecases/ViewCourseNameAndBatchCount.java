package com.masai.usecases;

import java.util.List;
import java.util.function.Consumer;

import com.masai.dao.BatchDAO;
import com.masai.dao.BatchDAOImpl;
import com.masai.dto.NoOfBatchAndCourseNameDTO;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class ViewCourseNameAndBatchCount {

	public static void viewNoOfBatches() {
		BatchDAO batchDAO = new BatchDAOImpl();
			try {
				List<NoOfBatchAndCourseNameDTO> batchList = batchDAO.getNoOfBatches();
				System.out.println("=========================================================================");
				System.out.println();
				Consumer<NoOfBatchAndCourseNameDTO> con = c -> System.out.println("Course Name: " +c.getCourseName()+",  No_of_Batches: "+c.getNo_Batches());
				batchList.forEach(con);
				
				System.out.println();
				System.out.println("=========================================================================");
			}catch(SomethingWentWrongException | NoRecordFoundException ex) {
				System.out.println(ex.getMessage());
			}
		}
}
