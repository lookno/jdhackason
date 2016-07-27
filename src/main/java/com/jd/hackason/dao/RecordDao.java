package com.jd.hackason.dao;

import java.util.List;

import com.jd.hackason.bean.OutputRecord;
import com.jd.hackason.bean.Record;
import com.jd.hackason.dto.OutputParamsDto;
import com.jd.hackason.dto.ProfitParamsDto;
import com.jd.hackason.dto.RecordDto;

public interface RecordDao {
	public void insertRecord(Record record);

	public void updateRecord(Record record);

	public List<Record> listRecord(RecordDto recordDto);

	public List<Record> profit(ProfitParamsDto profitParamsDto);

	public List<OutputRecord> output(OutputParamsDto outputParamsDto);

	public void batchInsertRecords(List<Record> list);

	public Integer getTotalNum(RecordDto RecordDto);

	//public List<Record> searchRecord(SearchDto searchDto);

	//public Integer getSearchCount(SearchDto searchDto);
}
