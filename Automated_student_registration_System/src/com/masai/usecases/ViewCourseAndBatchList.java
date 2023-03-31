package com.masai.usecases;

import java.util.List;
import java.util.function.Consumer;

import com.masai.dao.BatchDAO;
import com.masai.dao.BatchDAOImpl;
import com.masai.dto.BatchCourseDTO;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class ViewCourseAndBatchList {

	public static void viewBatchAndCourse() {
		BatchDAO batchDAO = new BatchDAOImpl();
			try {
				List<BatchCourseDTO> batchList = batchDAO.getBatchCourseList();
				System.out.println("=========================================================================");
				System.out.println();
				Consumer<BatchCourseDTO> con = c -> System.out.println("Batch Name: " + c.getBatchName() + ", Course Name: " +c.getCourseName() 
				
				);
				batchList.forEach(con);
				
				System.out.println();
				System.out.println("=========================================================================");
			}catch(SomethingWentWrongException | NoRecordFoundException ex) {
				System.out.println(ex.getMessage());
			}
		}
}
