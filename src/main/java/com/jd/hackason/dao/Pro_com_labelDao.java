package com.jd.hackason.dao;

import com.jd.hackason.bean.Pro_com_label;

public interface Pro_com_labelDao {
	public int exist(String pro_com_label);
	public void update(String pro_com_label);
	public void insert(Pro_com_label pro_com_label);
}
