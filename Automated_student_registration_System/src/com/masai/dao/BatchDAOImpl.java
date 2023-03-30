package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.BatchDTO;
import com.masai.dto.BatchDTOImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.utility.DBUtils;

public class BatchDAOImpl  implements BatchDAO{

	public void addBatchdao(BatchDTO batchDTO) throws SomethingWentWrongException{
		
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO batch(batchId, batchName, batchStartDate, batchEndDate,courseName,courseId) VALUES (?,?,?,?,?,?)");
			ps.setString(1,batchDTO.getBatchId());
			ps.setString(2,batchDTO.getBatchName());
			ps.setDate(3, Date.valueOf(batchDTO.getBatchStartDate()));
			ps.setDate(4, Date.valueOf(batchDTO.getBatchEndDate()));
			ps.setString(5,batchDTO.getCourseName());
			ps.setInt(6, batchDTO.getCourseId());
			
			ps.executeUpdate();
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to add batch");
		}finally {
			try {
				DBUtils.closeConnection(conn);
			}catch(SQLException ex) {
				
			}
		}
	}
	
	public List<BatchDTO> getBatchList() throws SomethingWentWrongException, NoRecordFoundException{
		Connection conn = null;
		List<BatchDTO> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "SELECT batchId, batchName, batchStartDate, batchEndDate,courseName,courseId FROM batch";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No batch found");
			}
			while(rs.next()) {
				list.add(new BatchDTOImpl(rs.getString(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getDate(4).toLocalDate(), rs.getString(5),rs.getInt(6)));
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
	
public List<BatchDTO> searchBatchWithId(String batchId) throws SomethingWentWrongException, NoRecordFoundException{
		
		Connection conn = null;
		List<BatchDTO> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "SELECT batchId, batchName,batchStartDate ,batchEndDate, courseName,courseId FROM batch WHERE batchId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, batchId);
			
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No Batch found");
			}
			while(rs.next()) {
				list.add(new BatchDTOImpl(rs.getString(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getDate(4).toLocalDate(),rs.getString(5),rs.getInt(6)));
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

	public void updateBatch(BatchDTO batch) throws SomethingWentWrongException{
		
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "UPDATE batch SET batchName = ?, batchStartDate = ?, batchEndDate = ?,courseName=? WHERE batchId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, batch.getBatchName());
			ps.setDate(2, Date.valueOf(batch.getBatchStartDate()));
			ps.setDate(3, Date.valueOf(batch.getBatchEndDate()));
			ps.setString(4, batch.getCourseName());
			ps.setString(5, batch.getBatchId());
			
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
}
