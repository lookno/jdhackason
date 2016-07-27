package com.jd.hackason.service;

import com.jd.hackason.dto.TokenParamsDto;
import com.jd.hackason.exception.ServerException;

public interface ITokenService {
	public void insertToken(TokenParamsDto params) throws ServerException;

	public int ifTokenValid(TokenParamsDto params) throws ServerException;

	public void inValid(TokenParamsDto params) throws ServerException;

	public Integer getUserIdByToken(String token) throws ServerException;
}
