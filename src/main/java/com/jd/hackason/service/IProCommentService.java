package com.jd.hackason.service;

import java.util.List;

import com.jd.hackason.bean.ProComment;
import com.jd.hackason.dto.ProCommentDto;

public interface IProCommentService {
	public List<ProComment> select(ProCommentDto proCommentDto);

	public void insert(ProComment procomment);

	public double avarageOfSen();

	public int getNum(int pro_id);

	public int getGoodInfo(int pro_id);

	public int getMidInfo(int pro_id);

	public int getBadInfo(int pro_id);

	public int getPicInfo(int pro_id);

	public int getAddContentInfo(int pro_id);
}
