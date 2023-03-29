package com.masai.dto;

import java.time.LocalDate;

public interface BatchDTO {
	
	public String getBatchId();
	public void setBatchId(String batchId);
	public String getBatchName();
	public void setBatchName(String batchName);
	public LocalDate getBatchStartDate();
	public void setBatchStartDate(LocalDate batchStartDate);
	public LocalDate getBatchEndDate();
	public void setBatchEndDate(LocalDate batchEndDate);
	public String getCourseName();
	public void setCourseName(String courseName);
	public int getCourseId();
	public void setCourseId(int courseId);
}
