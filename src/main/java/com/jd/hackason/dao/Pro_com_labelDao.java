package com.jd.hackason.dao;

import java.util.List;

import com.jd.hackason.bean.Pro_com_label;

public interface Pro_com_labelDao {
	public int exist(String pro_com_label);
	public void update(String pro_com_label);
	public void insert(Pro_com_label pro_com_label);
	public List<Pro_com_label> getLabelInfo(int id);
}
