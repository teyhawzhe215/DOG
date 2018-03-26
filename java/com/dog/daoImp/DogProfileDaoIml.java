package com.dog.daoImp;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.dog.Common.ConnectorHibernate;
import com.dog.dao.DogProfileDao;
import com.dog.entities.DogProfile;
import com.dog.entities.DogProfileLeftJoinDogClass;


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

	@Override
	public List<DogProfileLeftJoinDogClass> getList() {
		// TODO Auto-generated method stub
		
		Session session =	this.getSessionFactory().openSession();
		//不能寫成left join 如果資料已經在entity關聯的話  會發生查2次的情況 然後資料無法封裝
		Query query = session.createQuery("From DogProfileLeftJoinDogClass");

		List<DogProfileLeftJoinDogClass> list = query.getResultList();
		
		session.close();
		
		return list;
	}

	@Override
	public Blob genBlob(InputStream in) {
		// TODO Auto-generated method stub
		Session session =	this.getSessionFactory().openSession();
		LobHelper lobHelper = session.getLobHelper();
		Blob blob=null;
		try {
			blob = (Blob) lobHelper.createBlob(in, in.available());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("blob error!");
		}
		
		return blob;
	}

	
}
