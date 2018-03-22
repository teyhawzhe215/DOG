package com.dog.dao;

import org.springframework.transaction.annotation.Transactional;

import com.dog.entities.DogProfile;

public interface DogProfileDao {

	@Transactional
	public void sava(DogProfile dogProfile);
}
