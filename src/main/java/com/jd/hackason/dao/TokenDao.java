package com.jd.hackason.dao;

import com.jd.hackason.dto.TokenParamsDto;

public interface TokenDao {
	public void insertToken(TokenParamsDto params);

	public int ifTokenValid(TokenParamsDto params);

	public void inValid(TokenParamsDto params);

	public Integer getUserIdByToken(String token);
}
