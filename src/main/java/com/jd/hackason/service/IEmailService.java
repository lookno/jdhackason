package com.jd.hackason.service;

import com.jd.hackason.dto.EmailParamsDto;
import com.jd.hackason.exception.ServerException;

public interface IEmailService {
	public void sendEmail(EmailParamsDto e) throws ServerException;
}
