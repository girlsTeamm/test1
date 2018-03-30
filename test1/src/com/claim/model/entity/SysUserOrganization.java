package com.claim.model.entity;

/**
 * SysUserOrganization entity. @author MyEclipse Persistence Tools
 */

public class SysUserOrganization implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer sysUser;
	private Integer organization;

	// Constructors

	/** default constructor */
	public SysUserOrganization() {
	}

	/** full constructor */
	public SysUserOrganization(Integer sysUser, Integer organization) {
		this.sysUser = sysUser;
		this.organization = organization;
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

	public Integer getOrganization() {
		return this.organization;
	}

	public void setOrganization(Integer organization) {
		this.organization = organization;
	}

}