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

	@Override
	public double avarageOfSen() {
		return proCommentDao.avarageOfSen();
	}

	@Override
	public int getGoodInfo(int pro_id) {
		// TODO Auto-generated method stub
		return proCommentDao.getGoodInfo(pro_id);
	}

	@Override
	public int getMidInfo(int pro_id) {
		// TODO Auto-generated method stub
		return proCommentDao.getMidInfo(pro_id);
	}

	@Override
	public int getBadInfo(int pro_id) {
		// TODO Auto-generated method stub
		return proCommentDao.getBadInfo(pro_id);
	}

	@Override
	public int getNum(int pro_id) {
		// TODO Auto-generated method stub
		return proCommentDao.getNum(pro_id);
	}

	@Override
	public int getPicInfo(int pro_id) {
		// TODO Auto-generated method stub
		return proCommentDao.getPicInfo(pro_id);
	}

	@Override
	public int getAddContentInfo(int pro_id) {
		// TODO Auto-generated method stub
		return proCommentDao.getAddContentInfo(pro_id);
	}

}
