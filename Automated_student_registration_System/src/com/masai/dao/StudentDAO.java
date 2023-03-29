package com.masai.dao;

import java.util.List;

import com.masai.dto.StudentDTO;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface StudentDAO {
	public void addStudentdao(StudentDTO stdDTO) throws SomethingWentWrongException ;
	public List<StudentDTO> getStudentList() throws SomethingWentWrongException, NoRecordFoundException;
}
