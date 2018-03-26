package com.dog.Service;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import com.dog.entities.DogProfile;
import com.dog.entities.DogProfileLeftJoinDogClass;

public interface DogProfileService {
	public void sava(DogProfile dogProfile);
	
	public List<DogProfileLeftJoinDogClass> getList();
	
	public Blob genBlob(InputStream in);
}
