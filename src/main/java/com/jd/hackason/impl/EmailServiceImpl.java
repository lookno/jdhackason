package com.jd.hackason.impl;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

import com.jd.hackason.dto.EmailParamsDto;
import com.jd.hackason.exception.ServerException;
import com.jd.hackason.service.IEmailService;
@Service
public class EmailServiceImpl implements IEmailService {

	

	@Override
	public void sendEmail(EmailParamsDto e) throws ServerException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.163.com");
		email.setSmtpPort(25);
		email.setAuthenticator(new DefaultAuthenticator("qjcsch@163.com", "tmac1994135"));
		email.setSSLOnConnect(true);
		try{
			email.setFrom("qjcsch@163.com");
			email.setSubject(e.getTitle());
			email.setMsg(e.getContent());
			email.addTo(e.getToEmail());
			email.send();	
		}catch(Exception ex){
			throw new ServerException("发送邮件失败", ex);
		}
		
	}
}
