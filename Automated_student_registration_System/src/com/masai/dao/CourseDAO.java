package com.masai.dao;

import java.util.List;

import com.masai.dto.CourseDTO;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface CourseDAO {
	public void addCoursedao(CourseDTO courseDTO) throws SomethingWentWrongException ;
	public List<CourseDTO> searchCourseWithName(String courseName) throws SomethingWentWrongException, NoRecordFoundException;
	public void updateCourse(CourseDTO course) throws SomethingWentWrongException;
}
