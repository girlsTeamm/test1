package com.claim.model.entity;

/**
 * Status entity. @author MyEclipse Persistence Tools
 */

public class Status implements java.io.Serializable {

	// Fields

	private Short id;
	private String arabicName;
	private String englishName;
	private String code;
	private String description;

	// Constructors

	/** default constructor */
	public Status() {
	}

	/** minimal constructor */
	public Status(String arabicName, String englishName) {
		this.arabicName = arabicName;
		this.englishName = englishName;
	}

	/** full constructor */
	public Status(String arabicName, String englishName, String code, String description) {
		this.arabicName = arabicName;
		this.englishName = englishName;
		this.code = code;
		this.description = description;
	}

	// Property accessors

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

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}