package com.claim.model.entity;

/**
 * RolePermission entity. @author MyEclipse Persistence Tools
 */

public class RolePermission implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer sysRole;
	private Integer sysPermission;

	// Constructors

	/** default constructor */
	public RolePermission() {
	}

	/** full constructor */
	public RolePermission(Integer sysRole, Integer sysPermission) {
		this.sysRole = sysRole;
		this.sysPermission = sysPermission;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(Integer sysRole) {
		this.sysRole = sysRole;
	}

	public Integer getSysPermission() {
		return this.sysPermission;
	}

	public void setSysPermission(Integer sysPermission) {
		this.sysPermission = sysPermission;
	}

}