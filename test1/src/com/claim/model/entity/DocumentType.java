package com.claim.model.entity;

/**
 * DocumentType entity. @author MyEclipse Persistence Tools
 */

public class DocumentType implements java.io.Serializable {

	// Fields

	private Short id;
	private String arabicName;
	private String englishName;
	private String description;
	private String code;

	// Constructors

	/** default constructor */
	public DocumentType() {
	}

	/** minimal constructor */
	public DocumentType(String arabicName, String englishName) {
		this.arabicName = arabicName;
		this.englishName = englishName;
	}

	/** full constructor */
	public DocumentType(String arabicName, String englishName, String description, String code) {
		this.arabicName = arabicName;
		this.englishName = englishName;
		this.description = description;
		this.code = code;
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

}