package com.dog.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dog.Service.DogClassService;
import com.dog.dao.DogClassDao;
import com.dog.entities.DogClass;

@Service
public class DogClassServiceImp implements DogClassService {

	@Autowired
	DogClassDao daoClassDao;
	
	@Override
	public List<DogClass> getDogClass() {
		// TODO Auto-generated method stub
		return daoClassDao.getDogClass();
	}

}
