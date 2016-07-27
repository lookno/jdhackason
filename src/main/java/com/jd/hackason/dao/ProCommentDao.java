package com.jd.hackason.dao;

import java.util.List;

import com.jd.hackason.bean.ProComment;
import com.jd.hackason.dto.ProCommentDto;

public interface ProCommentDao {
	public List<ProComment> select(ProCommentDto proCommentDto);
	public void insert(ProComment procomment);
}
