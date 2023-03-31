package com.masai.dto;

public class NoOfBatchAndCourseNameDTOImpl implements NoOfBatchAndCourseNameDTO{

	private String courseName;
	private int No_Batches;
	
	public NoOfBatchAndCourseNameDTOImpl(String courseName, int no_Batches) {
		super();
		this.courseName = courseName;
		No_Batches = no_Batches;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getNo_Batches() {
		return No_Batches;
	}

	public void setNo_Batches(int no_Batches) {
		No_Batches = no_Batches;
	}

	@Override
	public String toString() {
		return "NoOfBatchAndCourseNameDTOImpl [courseName=" + courseName + ", No_Batches=" + No_Batches + "]";
	}
	
	
}
