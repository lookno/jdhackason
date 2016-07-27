package com.jd.hackason.service;

import java.util.List;

import com.jd.hackason.bean.GType;
import com.jd.hackason.bean.RType;
import com.jd.hackason.exception.ServerException;
import com.jd.hackason.exception.ServiceException;

public interface ITypeService {
	public List<GType> getGTypes() throws ServerException, ServiceException;

	public void addGType(GType gType) throws ServerException, ServiceException;;

	public List<RType> getRTypes() throws ServerException, ServiceException;

	public void addRType(RType rType) throws ServerException, ServiceException;

	public void updateGType(GType GType) throws ServerException, ServiceException;

	public void updateRType(RType rType) throws ServerException, ServiceException;
}
