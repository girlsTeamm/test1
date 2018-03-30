package com.claim.model.entity;

/**
 * Workflow entity. @author MyEclipse Persistence Tools
 */

public class Workflow implements java.io.Serializable {

	// Fields

	private Integer id;
	private String arabicName;
	private String englishName;
	private String code;

	// Constructors

	/** default constructor */
	public Workflow() {
	}

	/** full constructor */
	public Workflow(String arabicName, String englishName, String code) {
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