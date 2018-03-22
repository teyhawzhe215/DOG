package com.dog.entities;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DogProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7241294029446852596L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false , length=45)
	private String dogName;
	
	@Column(nullable=false)
	private int dogAge;
	
	@Column(nullable=false , length=2)
	private String dogSex;
	
	@Column(nullable=false , length=45)
	private String dogClass;
	
	
	private int dogCounter;

	private String dogUser;
	
	@Column(nullable=false)
	private byte[] dogImage;
	
	@Column(nullable=false , length=45)
	private String dogUploadUser;
	
	public DogProfile() {}

	public DogProfile(int id, String dogName, int dogAge, String dogSex, String dogClass, int dogCounter,
			String dogUser, byte[] dogImage, String dogUploadUser) {
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

	public String getDogClass() {
		return dogClass;
	}

	public void setDogClass(String dogClass) {
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

	public byte[] getDogImage() {
		return dogImage;
	}

	public void setDogImage(byte[] dogImage) {
		this.dogImage = dogImage;
	}

	public String getDogUploadUser() {
		return dogUploadUser;
	}

	public void setDogUploadUser(String dogUploadUser) {
		this.dogUploadUser = dogUploadUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DogProfile [id=" + id + ", dogName=" + dogName + ", dogAge=" + dogAge + ", dogSex=" + dogSex
				+ ", dogClass=" + dogClass + ", dogCounter=" + dogCounter + ", dogUser=" + dogUser + ", dogImage="
				+ Arrays.toString(dogImage) + ", dogUploadUser=" + dogUploadUser + "]";
	}
	
	
	
	
	
	
	
}
