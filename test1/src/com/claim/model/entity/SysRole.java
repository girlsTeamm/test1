package com.claim.model.entity;
// Generated 03/04/2018 11:59:14 ? by Hibernate Tools 5.1.0.Beta1

import java.util.HashSet;
import java.util.Set;

/**
 * SysRole generated by hbm2java
 */
public class SysRole implements java.io.Serializable {

	

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = -6346759127495765650L;
	private Integer id;
	private String arabicName;
	private String englishName;
	private String description;
	private String code;
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);
	private Set<RolePermission> rolePermissions = new HashSet<RolePermission>(0);

	public SysRole() {
	}

	public SysRole(String arabicName, String englishName) {
		this.arabicName = arabicName;
		this.englishName = englishName;
	}

	public SysRole(String arabicName, String englishName, String description, String code, Set<UserRole> userRoles,
			Set<RolePermission> rolePermissions) {
		this.arabicName = arabicName;
		this.englishName = englishName;
		this.description = description;
		this.code = code;
		this.userRoles = userRoles;
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

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Set<RolePermission> getRolePermissions() {
		return rolePermissions;
	}

	public void setRolePermissions(Set<RolePermission> rolePermissions) {
		this.rolePermissions = rolePermissions;
	}

	
	@Override
	public String toString() {
		return "SysRole [id=" + id + ", arabicName=" + arabicName + ", englishName=" + englishName + ", description="
				+ description + ", code=" + code + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arabicName == null) ? 0 : arabicName.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((englishName == null) ? 0 : englishName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysRole other = (SysRole) obj;
		if (arabicName == null) {
			if (other.arabicName != null)
				return false;
		} else if (!arabicName.equals(other.arabicName))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (englishName == null) {
			if (other.englishName != null)
				return false;
		} else if (!englishName.equals(other.englishName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



}
