
package com.claim.model.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Claim generated by hbm2java
 */
public class Claim implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7912290330472672424L;
	private Integer id;
	private ClaimType claimType;
	private SysUser sysUser;
	private String subject;
	private String description;
	private Boolean isFixed;
	private String userComment;
	private Set<ClaimWorkflowStep>claimWorkflowSteps = new HashSet<ClaimWorkflowStep>(0);
	private Set<ClaimStatus> claimStatuses = new HashSet<ClaimStatus>(0);
	private Set<ClaimDocument> claimDocuments = new HashSet<ClaimDocument>(0);
	private Set<ClaimStatusStep> claimStatusSteps = new HashSet<ClaimStatusStep>(0);
	private Set<ClaimWorkflow> claimWorkflows = new HashSet<ClaimWorkflow> (0);

	public Claim() {
	}

	public Claim(ClaimType claimType, SysUser sysUser) {
		this.claimType = claimType;
		this.sysUser = sysUser;
	}

	public Claim(Integer id, ClaimType claimType, SysUser sysUser, String subject, String description, Boolean isFixed,
			String userComment, Set<ClaimWorkflowStep> claimWorkflowSteps, Set<ClaimStatus> claimStatuses,
			Set<ClaimDocument> claimDocuments, Set<ClaimStatusStep> claimStatusSteps,
			Set<ClaimWorkflow> claimWorkflows) {
		super();
		this.id = id;
		this.claimType = claimType;
		this.sysUser = sysUser;
		this.subject = subject;
		this.description = description;
		this.isFixed = isFixed;
		this.userComment = userComment;
		this.claimWorkflowSteps = claimWorkflowSteps;
		this.claimStatuses = claimStatuses;
		this.claimDocuments = claimDocuments;
		this.claimStatusSteps = claimStatusSteps;
		this.claimWorkflows = claimWorkflows;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ClaimType getClaimType() {
		return claimType;
	}

	public void setClaimType(ClaimType claimType) {
		this.claimType = claimType;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsFixed() {
		return isFixed;
	}

	public void setIsFixed(Boolean isFixed) {
		this.isFixed = isFixed;
	}

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	public Set<ClaimWorkflowStep> getClaimWorkflowSteps() {
		return claimWorkflowSteps;
	}

	public void setClaimWorkflowSteps(Set<ClaimWorkflowStep> claimWorkflowSteps) {
		this.claimWorkflowSteps = claimWorkflowSteps;
	}

	public Set<ClaimStatus> getClaimStatuses() {
		return claimStatuses;
	}

	public void setClaimStatuses(Set<ClaimStatus> claimStatuses) {
		this.claimStatuses = claimStatuses;
	}

	public Set<ClaimDocument> getClaimDocuments() {
		return claimDocuments;
	}

	public void setClaimDocuments(Set<ClaimDocument> claimDocuments) {
		this.claimDocuments = claimDocuments;
	}

	public Set<ClaimStatusStep> getClaimStatusSteps() {
		return claimStatusSteps;
	}

	public void setClaimStatusSteps(Set<ClaimStatusStep> claimStatusSteps) {
		this.claimStatusSteps = claimStatusSteps;
	}

	public Set<ClaimWorkflow> getClaimWorkflows() {
		return claimWorkflows;
	}

	public void setClaimWorkflows(Set<ClaimWorkflow> claimWorkflows) {
		this.claimWorkflows = claimWorkflows;
	}
	
	

}

