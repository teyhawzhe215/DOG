package com.dog.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dog.Service.DogProfileService;
import com.dog.dao.DogProfileDao;
import com.dog.entities.DogProfile;

@Service
public class DogProfileServiceImp implements DogProfileService {

	@Autowired
	DogProfileDao dogProfileDao;

	@Override
	public void sava(DogProfile dogProfile) {
		// TODO Auto-generated method stub
		dogProfileDao.sava(dogProfile);
	}
	
	
	
}
