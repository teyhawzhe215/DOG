package com.dog.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=45 ,  nullable= false)
	private String name;
	@Column(length=1 ,  nullable= false)
	private String sex;
	@Column(length=45 ,  nullable= false)
	private String tel;
	@Column(length=45 ,  nullable= false)
	private String address;
	@Column(length=45 ,  nullable= false)
	private String password;
	
	@Column(unique=true , length=45 ,  nullable= false)
	private String email;
	
	public User() {}

	public User(int id, String name, String sex, String tel, String address, String password, String email) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
		this.address = address;
		this.password = password;
		this.email = email;
	}
	
	public User(int id, String name, String sex, String tel, String address) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", sex=" + sex + ", tel=" + tel + ", address=" + address
				+ ", password=" + password + ", email=" + email + "]";
	}
	
	
}
