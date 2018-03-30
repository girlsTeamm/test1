package com.claim.model.entity;

/**
 * Organization entity. @author MyEclipse Persistence Tools
 */

public class Organization implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer organization;
	private String arabicName;
	private String englishName;
	private String code;

	// Constructors

	/** default constructor */
	public Organization() {
	}

	/** full constructor */
	public Organization(Integer organization, String arabicName, String englishName, String code) {
		this.organization = organization;
		this.arabicName = arabicName;
		this.englishName = englishName;
		this.code = code;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrganization() {
		return this.organization;
	}

	public void setOrganization(Integer organization) {
		this.organization = organization;
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

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}