package com.dog.ServiceImp;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dog.Service.DogProfileService;
import com.dog.dao.DogProfileDao;
import com.dog.entities.DogProfile;
import com.dog.entities.DogProfileLeftJoinDogClass;


@Service
public class DogProfileServiceImp implements DogProfileService {

	@Autowired
	DogProfileDao dogProfileDao;

	@Override
	public void sava(DogProfile dogProfile) {
		// TODO Auto-generated method stub
		dogProfileDao.sava(dogProfile);
	}

	@Override
	public List<DogProfileLeftJoinDogClass> getList() {
		// TODO Auto-generated method stub
		return dogProfileDao.getList();
	}

	@Override
	public Blob genBlob(InputStream in) {
		// TODO Auto-generated method stub
		return dogProfileDao.genBlob(in);
	}
	
	
	
}
