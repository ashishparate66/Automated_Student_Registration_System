package com.masai.dto;

public class CourseDTOImpl implements CourseDTO {

	private String courseId;
	private String courseName;
	private int courseDuration;
	private int fee;
	
	public CourseDTOImpl(String courseId, String courseName, int courseDuration, int fee) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.fee = fee;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "CourseDTOImpl [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration="
				+ courseDuration + ", fee=" + fee + "]";
	}
	
	
	
}
