package com.jd.hackason.service;

import java.util.List;

import com.jd.hackason.bean.ProComment;
import com.jd.hackason.dto.ProCommentDto;

public interface IProCommentService {
	public List<ProComment> select(ProCommentDto proCommentDto);
	public void insert(ProComment procomment);
	public double avarageOfSen();
}
