package com.dog.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dog.entities.DogProfile;
import com.dog.entities.DogProfileLeftJoinDogClass;


public interface DogProfileDao {

	@Transactional
	public void sava(DogProfile dogProfile);
	
	@Transactional
	public List<DogProfileLeftJoinDogClass> getList();
	
	
	public Blob genBlob(InputStream in);
	
}
