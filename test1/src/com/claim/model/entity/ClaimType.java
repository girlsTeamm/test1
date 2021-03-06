package com.claim.model.entity;
// Generated 03/04/2018 11:59:14 ? by Hibernate Tools 5.1.0.Beta1

import java.util.HashSet;
import java.util.Set;

/**
 * ClaimType generated by hbm2java
 */
public class ClaimType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3100823260621042245L;
	private Short id;
	private String arabicName;
	private String englishName;
	private String description;
	private String code;
	private Set<Claim> claims = new HashSet<Claim>(0);

	public ClaimType() {
	}

	public ClaimType(String arabicName, String englishName, String description, String code, Set<Claim> claims) {
		this.arabicName = arabicName;
		this.englishName = englishName;
		this.description = description;
		this.code = code;
		this.claims = claims;
	}

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
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

	public Set<Claim> getClaims() {
		return this.claims;
	}

	public void setClaims(Set<Claim> claims) {
		this.claims = claims;
	}

}
