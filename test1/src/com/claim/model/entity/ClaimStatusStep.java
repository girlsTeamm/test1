package com.claim.model.entity;
// Generated 03/04/2018 11:59:14 ? by Hibernate Tools 5.1.0.Beta1

/**
 * ClaimStatusStep generated by hbm2java
 */
public class ClaimStatusStep implements java.io.Serializable {

	private Integer id;
	private Claim claim;
	private Organization organization;
	private Status status;
	private SysUser sysUser;
	private String userComment;

	public ClaimStatusStep() {
	}

	public ClaimStatusStep(Claim claim, Organization organization, Status status, SysUser sysUser) {
		this.claim = claim;
		this.organization = organization;
		this.status = status;
		this.sysUser = sysUser;
	}

	public ClaimStatusStep(Claim claim, Organization organization, Status status, SysUser sysUser, String userComment) {
		this.claim = claim;
		this.organization = organization;
		this.status = status;
		this.sysUser = sysUser;
		this.userComment = userComment;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Claim getClaim() {
		return this.claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public String getUserComment() {
		return this.userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

}