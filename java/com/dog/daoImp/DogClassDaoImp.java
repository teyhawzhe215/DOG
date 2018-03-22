package com.dog.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.dog.Common.ConnectorHibernate;
import com.dog.dao.DogClassDao;
import com.dog.entities.DogClass;

@Repository
public class DogClassDaoImp extends ConnectorHibernate implements DogClassDao {

	@Override
	public List<DogClass> getDogClass() {
		// TODO Auto-generated method stub
	
		Session session = this.getSessionFactory().openSession(); 
		Query query = session.createQuery("from DogClass d");
		
		List<DogClass> list = query.list();
		
		session.close();

		return list;
	}

}
