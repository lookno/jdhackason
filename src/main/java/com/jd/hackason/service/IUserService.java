package com.jd.hackason.service;

import com.jd.hackason.bean.User;
import com.jd.hackason.exception.ServerException;
import com.jd.hackason.exception.ServiceException;

public interface IUserService {
	public User login(User user) throws ServerException;
}
