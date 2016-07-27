package com.jd.hackason.dao;

import java.util.List;

import com.jd.hackason.bean.RType;

public interface RTypeDao {
	public List<RType> getRTypes();
	public void addRType(RType rType);
	public void updateRType(RType rType);
}
