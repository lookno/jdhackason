package com.jd.hackason.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.jd.hackason.bean.User;
import com.jd.hackason.dao.UserDao;
import com.jd.hackason.exception.ServerException;
import com.jd.hackason.service.IUserService;

@Service
class UserServiceImpl implements IUserService {
	@Resource
	private UserDao userDao;

	@Override
	public int login(User user) throws ServerException {
		try {
			int i=userDao.select(user);
			System.out.println(i);
			return i;
		} catch (Exception e) {
			throw new ServerException("数据库异常,请稍后再试", e);
		}

	}
}
