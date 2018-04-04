package com.claim.model.entity;

/**
 * Claim entity. @author MyEclipse Persistence Tools
 */

public class Claim implements java.io.Serializable {

	// Fields

	private Integer id;
	private String subject;
	private String description;
	private ClaimType claimType;
	private SysUser byUser;
	private Boolean isFixed;
	private String userComment;

	// Constructors

	/** default constructor */
	public Claim() {
	}

	/** minimal constructor */
	public Claim(ClaimType claimType, SysUser byUser) {
		this.claimType = claimType;
		this.byUser = byUser;
	}

	/** full constructor */
	public Claim(String subject, String description, ClaimType claimType, SysUser byUser, Boolean isFixed,
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

	public ClaimType getClaimType() {
		return this.claimType;
	}

	public void setClaimType(ClaimType claimType) {
		this.claimType = claimType;
	}

	public SysUser getByUser() {
		return this.byUser;
	}

	public void setByUser(SysUser byUser) {
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