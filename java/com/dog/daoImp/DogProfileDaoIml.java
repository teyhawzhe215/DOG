package com.dog.daoImp;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.dog.Common.ConnectorHibernate;
import com.dog.dao.DogProfileDao;
import com.dog.entities.DogProfile;

@Repository
public class DogProfileDaoIml extends ConnectorHibernate implements DogProfileDao {

	@Override
	public void sava(DogProfile dogProfile) {
		// TODO Auto-generated method stub
		Session session =	this.getSessionFactory().openSession();
		session.getTransaction().begin();
		session.persist(dogProfile);
		session.getTransaction().commit();
		session.close();
	}

	
}
