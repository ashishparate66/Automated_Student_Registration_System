package com.masai.dto;

public class BatchCourseDTOImpl implements BatchCourseDTO {

	private String batchName;
	private String CourseName;
	
	public BatchCourseDTOImpl(String batchName, String courseName) {
		super();
		this.batchName = batchName;
		CourseName =  courseName;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	@Override
	public String toString() {
		return "BatchCourseDTOImpl [batchName=" + batchName + ", CourseName=" + CourseName + "]";
	}
	
	
}
