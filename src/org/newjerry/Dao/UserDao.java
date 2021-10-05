package org.newjerry.Dao;

import org.newjerry.domain.Userinfo;

public interface UserDao {
	public Userinfo login(Userinfo user);

	public int addUser(Userinfo user);
}
