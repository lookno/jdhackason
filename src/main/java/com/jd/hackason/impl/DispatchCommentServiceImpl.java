package com.jd.hackason.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jd.hackason.bean.DispatchComment;
import com.jd.hackason.dao.DispatchCommentDao;
import com.jd.hackason.service.IDispatchCommentService;

@Service
public class DispatchCommentServiceImpl implements IDispatchCommentService{
	@Resource
	private DispatchCommentDao dispatchCommentDao;

	@Override
	public void insert(DispatchComment dispatchComment) {
		dispatchCommentDao.insert(dispatchComment);
	}

}
