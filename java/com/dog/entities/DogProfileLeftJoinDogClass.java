package com.dog.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table(name="DogProfile")
public class DogProfileLeftJoinDogClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8145899057941868584L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false , length=45)
	private String dogName;
	
	@Column(nullable = false )
	private int dogAge;
	
	@Column(nullable = false , length=2)
	private String dogSex;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST , fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "dogClass" ,referencedColumnName="dogClass") 
	private DogClass dogClass;
	
	@Column(nullable = false)
	private int dogCounter;
	
	@Column(nullable = false)
	private String dogUser;
	
	private String dogImage;
	
	@Column(nullable = false , length=45)
	private String dogUploadUser;
	
	public DogProfileLeftJoinDogClass() {}
	
	public DogProfileLeftJoinDogClass(int id, String dogName) {
		super();
		this.id = id;
		this.dogName = dogName;
	}

	public DogProfileLeftJoinDogClass(int id, String dogName, int dogAge) {
		super();
		this.id = id;
		this.dogName = dogName;
		this.dogAge = dogAge;
	}

	public DogProfileLeftJoinDogClass(int id, String dogName, int dogAge, String dogSex) {
		super();
		this.id = id;
		this.dogName = dogName;
		this.dogAge = dogAge;
		this.dogSex = dogSex;
	}

	public DogProfileLeftJoinDogClass(int id, String dogName, int dogAge, String dogSex, DogClass dogClass) {
		super();
		this.id = id;
		this.dogName = dogName;
		this.dogAge = dogAge;
		this.dogSex = dogSex;
		this.dogClass = dogClass;
	}


	public DogProfileLeftJoinDogClass(int id, String dogName, int dogAge, String dogSex, DogClass dogClass,
			int dogCounter) {
		super();
		this.id = id;
		this.dogName = dogName;
		this.dogAge = dogAge;
		this.dogSex = dogSex;
		this.dogClass = dogClass;
		this.dogCounter = dogCounter;
	}

	

	public DogProfileLeftJoinDogClass(int id, String dogName, int dogAge, String dogSex, DogClass dogClass,
			int dogCounter, String dogUser) {
		super();
		this.id = id;
		this.dogName = dogName;
		this.dogAge = dogAge;
		this.dogSex = dogSex;
		this.dogClass = dogClass;
		this.dogCounter = dogCounter;
		this.dogUser = dogUser;
	}
	
	

	public DogProfileLeftJoinDogClass(int id, String dogName, int dogAge, String dogSex, DogClass dogClass,
			int dogCounter, String dogUser, String dogImage) {
		super();
		this.id = id;
		this.dogName = dogName;
		this.dogAge = dogAge;
		this.dogSex = dogSex;
		this.dogClass = dogClass;
		this.dogCounter = dogCounter;
		this.dogUser = dogUser;
		this.dogImage = dogImage;
	}

	public DogProfileLeftJoinDogClass(int id, String dogName, int dogAge, String dogSex, DogClass dogClass,
			int dogCounter, String dogUser, String dogImage, String dogUploadUser) {
		super();
		this.id = id;
		this.dogName = dogName;
		this.dogAge = dogAge;
		this.dogSex = dogSex;
		this.dogClass = dogClass;
		this.dogCounter = dogCounter;
		this.dogUser = dogUser;
		this.dogImage = dogImage;
		this.dogUploadUser = dogUploadUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public int getDogAge() {
		return dogAge;
	}

	public void setDogAge(int dogAge) {
		this.dogAge = dogAge;
	}

	public String getDogSex() {
		return dogSex;
	}

	public void setDogSex(String dogSex) {
		this.dogSex = dogSex;
	}

	public DogClass getDogClass() {
		return dogClass;
	}

	public void setDogClass(DogClass dogClass) {
		this.dogClass = dogClass;
	}

	public int getDogCounter() {
		return dogCounter;
	}

	public void setDogCounter(int dogCounter) {
		this.dogCounter = dogCounter;
	}

	public String getDogUser() {
		return dogUser;
	}

	public void setDogUser(String dogUser) {
		this.dogUser = dogUser;
	}

	public String getDogImage() {
		return dogImage;
	}

	public void setDogImage(String dogImage) {
		this.dogImage = dogImage;
	}

	public String getDogUploadUser() {
		return dogUploadUser;
	}

	public void setDogUploadUser(String dogUploadUser) {
		this.dogUploadUser = dogUploadUser;
	}

	@Override
	public String toString() {
		return "DogProfileLeftJoinDogClass [id=" + id + ", dogName=" + dogName + ", dogAge=" + dogAge + ", dogSex="
				+ dogSex + ", dogClass=" + dogClass + ", dogCounter=" + dogCounter + ", dogUser=" + dogUser
				+ ", dogImage=" + dogImage + ", dogUploadUser=" + dogUploadUser + "]";
	}

	
	
	
	
}
