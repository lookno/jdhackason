package com.jd.hackason.service;

import java.util.List;

import com.jd.hackason.bean.OutputRecord;
import com.jd.hackason.bean.Record;
import com.jd.hackason.dto.OutputParamsDto;
import com.jd.hackason.dto.ProfitParamsDto;
import com.jd.hackason.dto.RecordDto;
import com.jd.hackason.exception.ServerException;
import com.jd.hackason.exception.ServiceException;

public interface IRecordService {
	public void insertRecord(Record record) throws ServerException;

	public void updateRecord(Record record) throws ServerException;

	public List<Record> listRecord(RecordDto recordDto) throws ServerException;

	public List<Record> profit(ProfitParamsDto profitParamsDto) throws ServerException;

	public List<OutputRecord> output(OutputParamsDto outputParamsDto) throws ServerException;

	public void batchInsertRecords(String fileName) throws ServerException, ServiceException;

	public Integer getTotalNum(RecordDto RecordDto) throws ServerException, ServiceException;

	//public List<Record> searchRecord(SearchDto searchDto) throws ServerException, ServiceException;

	//public Integer getSearchCount(SearchDto searchDto) throws ServerException, ServiceException;
}
