package com.masai.dto;

import java.time.LocalDate;

public class BatchDTOImpl implements BatchDTO {

	private String batchId;
	private String batchName;
	private LocalDate batchStartDate;
	private LocalDate batchEndDate;
	private String courseName;
	private int courseId;
	
	public BatchDTOImpl(String batchId, String batchName, LocalDate batchStartDate, LocalDate batchEndDate,
			String courseName, int courseId) {
		super();
		this.batchId = batchId;
		this.batchName = batchName;
		this.batchStartDate = batchStartDate;
		this.batchEndDate = batchEndDate;
		this.courseName = courseName;
		this.courseId = courseId;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public LocalDate getBatchStartDate() {
		return batchStartDate;
	}

	public void setBatchStartDate(LocalDate batchStartDate) {
		this.batchStartDate = batchStartDate;
	}

	public LocalDate getBatchEndDate() {
		return batchEndDate;
	}

	public void setBatchEndDate(LocalDate batchEndDate) {
		this.batchEndDate = batchEndDate;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "BatchDTOImpl [batchId=" + batchId + ", batchName=" + batchName + ", batchStartDate=" + batchStartDate
				+ ", batchEndDate=" + batchEndDate + ", courseName=" + courseName + ", courseId=" + courseId + "]";
	}
	
	
	
}
