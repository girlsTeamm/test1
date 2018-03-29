package com.claim.model.entity;

/**
 * Claim entity. @author MyEclipse Persistence Tools
 */

public class Claim implements java.io.Serializable {

	// Fields

	private Integer id;
	private String subject;
	private String description;
	private Short claimType;
	private Integer byUser;
	private Boolean isFixed;
	private String userComment;

	// Constructors

	/** default constructor */
	public Claim() {
	}

	/** minimal constructor */
	public Claim(Short claimType, Integer byUser) {
		this.claimType = claimType;
		this.byUser = byUser;
	}

	/** full constructor */
	public Claim(String subject, String description, Short claimType, Integer byUser, Boolean isFixed,
			String userComment) {
		this.subject = subject;
		this.description = description;
		this.claimType = claimType;
		this.byUser = byUser;
		this.isFixed = isFixed;
		this.userComment = userComment;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Short getClaimType() {
		return this.claimType;
	}

	public void setClaimType(Short claimType) {
		this.claimType = claimType;
	}

	public Integer getByUser() {
		return this.byUser;
	}

	public void setByUser(Integer byUser) {
		this.byUser = byUser;
	}

	public Boolean getIsFixed() {
		return this.isFixed;
	}

	public void setIsFixed(Boolean isFixed) {
		this.isFixed = isFixed;
	}

	public String getUserComment() {
		return this.userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

}