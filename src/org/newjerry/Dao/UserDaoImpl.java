package org.newjerry.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.newjerry.domain.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	private HibernateTemplate template;

	public Userinfo login(Userinfo user) {
		Userinfo loginU=null;
		Session session = template.getSessionFactory().openSession();
		Query query = session.createQuery("from Userinfo where uname=:name");
		query.setString("name", user.getUname());
		try {
			@SuppressWarnings("unchecked")
			List<Userinfo> loginUser = query.list();
			for (Userinfo u : loginUser) {
				loginU=u;
			}
		} finally {
			session.close();
		}
		if(loginU!=null){
			if(loginU.getUpsw().equals(user.getUpsw())){
				return loginU;
			}
		}
		return null;
	}

	public int addUser(Userinfo user) {
		Session session = template.getSessionFactory().openSession();
		//检查是否存在该用户
		Query query = session.createQuery("from Userinfo where uname=:name");
		query.setString("name", user.getUname());
		@SuppressWarnings("unchecked")
		List<Userinfo> ruser = query.list();
		if (ruser.size()==0) {
			Integer save = (Integer) session.save(user);
			Transaction beginTransaction = session.beginTransaction();
			beginTransaction.commit();
			session.close();
			return save;
		}else {
			session.close();
			return 0;
		}
	}

}
