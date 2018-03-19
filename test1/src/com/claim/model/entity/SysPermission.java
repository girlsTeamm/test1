package com.claim.model.entity;
// Generated 10/03/2018 11:10:21 ? by Hibernate Tools 5.1.0.Beta1

import java.util.HashSet;
import java.util.Set;

/**
 * SysPermission generated by hbm2java
 */
public class SysPermission implements java.io.Serializable {

	private Integer id;
	private String arabicName;
	private String englishName;
	private String description;
	private String code;
	private Set rolePermissions = new HashSet(0);

	public SysPermission() {
	}

	public SysPermission(String arabicName, String englishName, String code) {
		this.arabicName = arabicName;
		this.englishName = englishName;
		this.code = code;
	}

	public SysPermission(String arabicName, String englishName, String description, String code, Set rolePermissions) {
		this.arabicName = arabicName;
		this.englishName = englishName;
		this.description = description;
		this.code = code;
		this.rolePermissions = rolePermissions;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArabicName() {
		return this.arabicName;
	}

	public void setArabicName(String arabicName) {
		this.arabicName = arabicName;
	}

	public String getEnglishName() {
		return this.englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set getRolePermissions() {
		return this.rolePermissions;
	}

	public void setRolePermissions(Set rolePermissions) {
		this.rolePermissions = rolePermissions;
	}

}
