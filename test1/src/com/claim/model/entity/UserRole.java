package com.claim.model.entity;

/**
 * UserRole entity. @author MyEclipse Persistence Tools
 */

public class UserRole implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer sysUser;
	private Integer sysRole;

	// Constructors

	/** default constructor */
	public UserRole() {
	}

	/** full constructor */
	public UserRole(Integer sysUser, Integer sysRole) {
		this.sysUser = sysUser;
		this.sysRole = sysRole;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(Integer sysUser) {
		this.sysUser = sysUser;
	}

	public Integer getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(Integer sysRole) {
		this.sysRole = sysRole;
	}

}