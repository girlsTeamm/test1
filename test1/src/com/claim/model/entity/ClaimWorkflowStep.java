package com.claim.model.entity;

/**
 * ClaimWorkflowStep entity. @author MyEclipse Persistence Tools
 */

public class ClaimWorkflowStep implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer claim;
	private Integer workflowDefinition;
	private Integer byUser;
	private String userComment;

	// Constructors

	/** default constructor */
	public ClaimWorkflowStep() {
	}

	/** minimal constructor */
	public ClaimWorkflowStep(Integer claim, Integer workflowDefinition, Integer byUser) {
		this.claim = claim;
		this.workflowDefinition = workflowDefinition;
		this.byUser = byUser;
	}

	/** full constructor */
	public ClaimWorkflowStep(Integer claim, Integer workflowDefinition, Integer byUser, String userComment) {
		this.claim = claim;
		this.workflowDefinition = workflowDefinition;
		this.byUser = byUser;
		this.userComment = userComment;
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

	public Integer getWorkflowDefinition() {
		return this.workflowDefinition;
	}

	public void setWorkflowDefinition(Integer workflowDefinition) {
		this.workflowDefinition = workflowDefinition;
	}

	public Integer getByUser() {
		return this.byUser;
	}

	public void setByUser(Integer byUser) {
		this.byUser = byUser;
	}

	public String getUserComment() {
		return this.userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

}