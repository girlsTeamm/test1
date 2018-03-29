package com.claim.model.entity;

/**
 * ClaimStatusStep entity. @author MyEclipse Persistence Tools
 */

public class ClaimStatusStep implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer claim;
	private Short status;
	private Integer organization;
	private String userComment;
	private Integer byUser;

	// Constructors

	/** default constructor */
	public ClaimStatusStep() {
	}

	/** minimal constructor */
	public ClaimStatusStep(Integer claim, Short status, Integer organization, Integer byUser) {
		this.claim = claim;
		this.status = status;
		this.organization = organization;
		this.byUser = byUser;
	}

	/** full constructor */
	public ClaimStatusStep(Integer claim, Short status, Integer organization, String userComment, Integer byUser) {
		this.claim = claim;
		this.status = status;
		this.organization = organization;
		this.userComment = userComment;
		this.byUser = byUser;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClaim() {
		return this.claim;
	}

	public void setClaim(Integer claim) {
		this.claim = claim;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Integer getOrganization() {
		return this.organization;
	}

	public void setOrganization(Integer organization) {
		this.organization = organization;
	}

	public String getUserComment() {
		return this.userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	public Integer getByUser() {
		return this.byUser;
	}

	public void setByUser(Integer byUser) {
		this.byUser = byUser;
	}

}