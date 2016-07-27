package com.jd.hackason.impl;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.jd.hackason.bean.User;
import com.jd.hackason.dao.UserDao;
import com.jd.hackason.exception.ServerException;
import com.jd.hackason.exception.ServiceException;
import com.jd.hackason.service.IUserService;

@Service
class UserServiceImpl implements IUserService {
	@Resource
	private UserDao userDao;
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public void register(User user) throws ServerException, ServiceException {
		int bool;
		try {
			bool = userDao.checkUserInfo(user);
		} catch (Exception e) {
			log.error("UserServiceImpl.register occurs an Exception: ", e);
			throw new ServerException("数据库异常,请稍后再试", e);
		}

		if (bool > 0) {
			throw new ServiceException("用户名已存在");
		}
		try {
			userDao.insert(user);
		} catch (Exception e) {
			log.error("UserServiceImpl.register occurs an Exception: ", e);
			throw new ServerException("数据库异常,请稍后再试", e);
		}

	}

	@Override
	public User login(User user) throws ServerException {
		try {
			return userDao.select(user);
		} catch (Exception e) {
			log.error("UserServiceImpl.login occurs an Exception: ", e);
			throw new ServerException("数据库异常,请稍后再试", e);
		}

	}

	@Override
	public int checkUserInfo(User user) throws ServerException {
		try {
			return userDao.checkUserInfo(user);
		} catch (Exception e) {
			log.error("UserServiceImpl.checkUserInfo occurs an Exception: ", e);
			throw new ServerException("数据库异常,请稍后再试", e);
		}
	}

	@Override
	public void changePwd(User user) throws ServerException {
		try {
			userDao.changePwd(user);
		} catch (Exception e) {
			log.error("UserServiceImpl.changePwd occurs an Exception: ", e);
			throw new ServerException("数据库异常,请稍后再试", e);
		}
	}

	@Override
	public int checkPermission(User user) throws ServerException {
		int i;
		try {
			i = userDao.checkPermission(user);
		} catch (Exception e) {
			log.error("UserServiceImpl.checkPermission occurs an Exception: ", e);
			throw new ServerException("数据库异常,请稍后再试", e);
		}
		return i;
	}

	@Override
	public User getUserById(int id) throws ServerException {
		User user ;
		try {
			user = userDao.getUserById(id);
		} catch (Exception e) {
			log.error("UserServiceImpl.getUserById occurs an Exception: ", e);
			throw new ServerException("数据库异常,请稍后再试", e);
		}
		return user;
	}

	@Override
	public User getUserByName(String username) throws ServerException {
		User user ;
		try {
			user = userDao.getUserByName(username);
		} catch (Exception e) {
			log.error("UserServiceImpl.getUserByName occurs an Exception: ", e);
			throw new ServerException("数据库异常,请稍后再试", e);
		}
		return user;
	}

}
