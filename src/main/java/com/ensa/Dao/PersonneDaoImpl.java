package com.ensa.Dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ensa.entities.Personne;

@Repository
public class PersonneDaoImpl implements PersonneDao {
	
	

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void ajoutPersonne(Personne p) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(p);
	}

}
