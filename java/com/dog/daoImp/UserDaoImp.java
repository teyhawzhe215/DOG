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

import com.dog.Common.ConnectorHibernate;
import com.dog.dao.UserDao;
import com.dog.entities.User;

@Repository
public class UserDaoImp extends ConnectorHibernate implements UserDao {

 
	
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		Session session=this.getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		session.close();
	
	}

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		System.out.println("coming soon ");
		Session session = this.getSessionFactory().openSession();
		Query query= session.createQuery("Select new User(u.id as id,u.name as name , u.sex as sex , u.tel as tel , u.address as address)  From User u Where u.email =:email");
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
	public Map<String,Object> getUser(String email, String password) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery("Select new map(u.name as name , u.sex as sex , u.tel as tel , u.address as address) From User u Where u.email =:email and u.password=:password");
		//createNativeQuery 才能使用下面的註解
		//query.unwrap(org.hibernate.SQLQuery.class);
		//query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		query.setParameter("email" , email);
		query.setParameter("password" , password);
		
		Map<String,Object> user = (Map<String, Object>) query.getSingleResult();
	 
		for (String index : user.keySet()) {
	     	System.out.println("m: " + index +"   " + user.get(index));
	    }
		session.close();
		
		return user;
	}

}
