package com.claim.model.entity;

/**
 * ClaimStatus entity. @author MyEclipse Persistence Tools
 */

public class ClaimStatus implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer claim;
	private Short status;
	private Integer organization;

	// Constructors

	/** default constructor */
	public ClaimStatus() {
	}

	/** full constructor */
	public ClaimStatus(Integer claim, Short status, Integer organization) {
		this.claim = claim;
		this.status = status;
		this.organization = organization;
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

}