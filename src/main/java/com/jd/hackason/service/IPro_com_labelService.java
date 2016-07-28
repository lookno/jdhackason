package com.jd.hackason.service;

import java.util.List;

import com.jd.hackason.bean.Pro_com_label;

public interface IPro_com_labelService {
	public void update_table(String[] labels_name);

	public List<Pro_com_label> getLabelInfo(int id);
}
