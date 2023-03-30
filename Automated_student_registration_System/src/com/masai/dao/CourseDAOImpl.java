package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.CourseDTO;
import com.masai.dto.CourseDTOImpl;
import com.masai.dto.StudentDTO;
import com.masai.dto.StudentDTOImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.utility.DBUtils;

public class CourseDAOImpl implements CourseDAO {

	public void addCoursedao(CourseDTO courseDTO) throws SomethingWentWrongException{
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO course(courseId, courseName,courseDuration,fee) VALUES (?,?,?,?)");
			ps.setString(1,courseDTO.getCourseId() );
			ps.setString(2,courseDTO.getCourseName() );
			ps.setInt(3, courseDTO.getCourseDuration() );
			ps.setInt(4, courseDTO.getFee() );
			
			
			ps.executeUpdate();
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to add course");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			}catch(SQLException ex) {
				
			}
		}
	}
	
	public List<CourseDTO> searchCourseWithName(String courseName) throws SomethingWentWrongException, NoRecordFoundException{
		
		Connection conn = null;
		List<CourseDTO> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "SELECT courseId, courseName, courseDuration, fee FROM course WHERE courseName = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, courseName);
			
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No Course found");
			}
			while(rs.next()) {
				list.add(new CourseDTOImpl(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}
			
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to Search the record now, try again later");
		}finally {
			try {
				DBUtils.closeConnection(conn);					
			}catch(SQLException ex) {
				
			}
		}
		return list;
	}
	
	
	public void updateCourse(CourseDTO course) throws SomethingWentWrongException{
		
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "UPDATE course SET courseName = ?, courseDuration = ?, fee = ? WHERE courseId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, course.getCourseName());
			ps.setInt(2, course.getCourseDuration());
			ps.setInt(3, course.getFee());
			ps.setString(4, course.getCourseId());
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
	
	public List<CourseDTO> getCourseList() throws SomethingWentWrongException, NoRecordFoundException{
		Connection conn = null;
		List<CourseDTO> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "SELECT courseId, courseName,courseDuration,fee FROM course";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No course found");
			}
			while(rs.next()) {
				list.add(new CourseDTOImpl(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4) ));
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
