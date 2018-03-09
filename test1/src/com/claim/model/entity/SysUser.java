package com.claim.model.entity;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public class SysUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userName;
	private String password;
	private String name;
	private String surname;
	private String fatherName;
	private String motherName;

	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** full constructor */
	public SysUser(String userName, String password, String name, String surname, String fatherName,
			String motherName) {
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.fatherName = fatherName;
		this.motherName = motherName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

}