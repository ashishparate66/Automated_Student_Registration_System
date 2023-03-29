package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.StudentDTO;
import com.masai.dto.StudentDTOImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.utility.DBUtils;

public class StudentDAOImpl implements StudentDAO {

	public void addStudentdao(StudentDTO stdDTO) throws SomethingWentWrongException {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO student(stdId, firstName,lastName,address,mobile,email,password,courseId) VALUES (?,?,?,?,?,?,?,?)");
			ps.setString(1, stdDTO.getStdId());
			ps.setString(2, stdDTO.getFirstName());
			ps.setString(3, stdDTO.getLastName());
			ps.setString(4, stdDTO.getAddress());
			ps.setString(5, stdDTO.getMobile());
			ps.setString(6, stdDTO.getEmail());
			ps.setString(7, stdDTO.getPassword());
			ps.setInt(8, stdDTO.getCourse_id());
			
			ps.executeUpdate();
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to add student");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			}catch(SQLException ex) {
				
			}
		}
	}
	
	public List<StudentDTO> getStudentList() throws SomethingWentWrongException, NoRecordFoundException{
		Connection conn = null;
		List<StudentDTO> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "SELECT stdId, firstName,lastName,address,mobile,email,password,courseId FROM student";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No student found");
			}
			while(rs.next()) {
				list.add(new StudentDTOImpl(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8)  ));
			}
			
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to update the record now, try again later");
		}finally {
			try {
				DBUtils.closeConnection(conn);					
			}catch(SQLException ex) {
				
			}
		}
		return list;
	}
}
