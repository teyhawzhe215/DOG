package com.dog.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name="dog_class")
public class DogClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false , length=45)
	private String dogClass;
	
	@Column(nullable=false , length=45)
	private String dogName;
	
	public DogClass() {}

	public DogClass(int id, String dogClass, String dogName) {
		super();
		this.id = id;
		this.dogClass = dogClass;
		this.dogName = dogName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDogClass() {
		return dogClass;
	}

	public void setDogClass(String dogClass) {
		this.dogClass = dogClass;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	@Override
	public String toString() {
		return "DogClass [id=" + id + ", dogClass=" + dogClass + ", dogName=" + dogName + "]";
	}
	
	
	
}
