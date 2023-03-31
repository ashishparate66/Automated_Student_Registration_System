package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
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
			String query = "SELECT stdId, firstName,lastName,address,mobile,email,password,courseId FROM student where is_delete=0";
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
	
	
	public void updateStudent(StudentDTO student) throws SomethingWentWrongException{
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "UPDATE student SET firstName = ?, lastName = ?, address = ?, mobile=?, email=?, password=?, courseId=? WHERE stdId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getLastName());
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getMobile());
			ps.setString(5, student.getEmail());
			ps.setString(6, student.getPassword());
			ps.setInt(7, student.getCourse_id());
			ps.setString(8, student.getStdId());
			
			ps.executeUpdate();
			
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to update the record now, try again later");
		}finally {
			try {
				DBUtils.closeConnection(conn);					
			}catch(SQLException ex) {
				
			}
		}	
	}
	
	public void updatePasswordDao(String password, String Newpassword) throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "UPDATE student SET password = ? WHERE password = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, Newpassword);
			ps.setString(2, password);
			
			int rs = ps.executeUpdate();;
			if(rs == 0) {
				throw new NoRecordFoundException("Invalid Old Password");
			}
			
		
			
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to update Password, try again later");
		}finally {
			try {
				DBUtils.closeConnection(conn);					
			}catch(SQLException ex) {
				
			}
		}	
	}
	
	public void deleteStudent(String email) throws SomethingWentWrongException{
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "UPDATE student set is_delete=1 WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.executeUpdate();
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to delete the student now, try again later");
		}finally {
			try {
				DBUtils.closeConnection(conn);					
			}catch(SQLException ex) {
				
			}
		}
	}
}
