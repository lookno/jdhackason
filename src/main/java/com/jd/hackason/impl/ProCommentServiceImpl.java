package com.jd.hackason.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.jd.hackason.bean.ProComment;
import com.jd.hackason.dao.ProCommentDao;
import com.jd.hackason.dto.ProCommentDto;
import com.jd.hackason.service.IProCommentService;

@Service
public class ProCommentServiceImpl implements IProCommentService {
	@Resource
	private ProCommentDao proCommentDao;

	@Override
	public List<ProComment> select(ProCommentDto proCommentDto) {
		return proCommentDao.select(proCommentDto);
	}

	@Override
	public void insert(ProComment procomment) {
		proCommentDao.insert(procomment);
	}

}
