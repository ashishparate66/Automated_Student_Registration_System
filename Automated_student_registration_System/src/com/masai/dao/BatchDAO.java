package com.masai.dao;

import java.util.List;

import com.masai.dto.BatchDTO;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface BatchDAO {
	
	public void addBatchdao(BatchDTO batchDTO) throws SomethingWentWrongException ;
	public List<BatchDTO> searchBatchWithId(String batchId) throws SomethingWentWrongException, NoRecordFoundException;
	public void updateBatch(BatchDTO batch) throws SomethingWentWrongException;
	public List<BatchDTO> getBatchList() throws SomethingWentWrongException, NoRecordFoundException;
}
