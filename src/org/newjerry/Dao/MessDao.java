package org.newjerry.Dao;

import java.util.List;

import org.newjerry.domain.Mess;


public interface MessDao {
	void addMessage(Mess message);
	List<Mess> findAllMessage(int vid);
}
