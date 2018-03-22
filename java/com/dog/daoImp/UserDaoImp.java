package com.dog.daoImp;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dog.dao.UserDao;
import com.dog.entities.User;

@Repository
public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		session.close();
	
	}

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query= session.createQuery("From User u Where u.email =:email");
		query.setParameter("email" , email);
		
		User user = null;
		
		if(query.list().size()>0) {
			user =(User) query.getSingleResult();
			System.out.println(user.toString());
		}
	
		session.close();
	
		return user;
	}

	@Override
	public List<Map<String,Object>> getUser(String email, String password) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createNativeQuery("Select * From User u Where u.email =:email and u.password=:password");
		query.unwrap(org.hibernate.SQLQuery.class);
		query.setParameter("email" , email);
		query.setParameter("password" , password);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String,Object>> user =query.getResultList();
		for (Map<String, Object> m : user) {
	     	System.out.println("m: " + m);
	    }
		session.close();
		
		return user;
	}

}
