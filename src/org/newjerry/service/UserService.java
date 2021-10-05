package org.newjerry.service;

import org.newjerry.domain.Userinfo;

public interface UserService {
	// 登录
	public Userinfo login(Userinfo user);

	// 注册
	public int addUser(Userinfo user);
}
