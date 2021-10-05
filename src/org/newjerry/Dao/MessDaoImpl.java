package org.newjerry.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.newjerry.domain.Mess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("messDao")
public class MessDaoImpl implements MessDao {
	@Autowired
	private HibernateTemplate template;
	public void addMessage(Mess message) {
		Session session =template.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(message);
		transaction.commit();
		session.close();
	}

	public List<Mess> findAllMessage(int vid) {
		Session session =template.getSessionFactory().openSession();
		List<Mess> messList =null;
		Query query = session.createQuery("from Mess where vid="+vid);
			messList = query.list();
			session.close();
		return messList;
	}
}
