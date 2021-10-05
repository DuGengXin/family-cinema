package org.newjerry.service;

import org.newjerry.Dao.UserDao;
import org.newjerry.domain.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	public Userinfo login(Userinfo user) {
		return userDao.login(user);
	}

	public int addUser(Userinfo user) {
		return userDao.addUser(user);
	}

}
