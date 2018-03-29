package com.claim.model.entity;

/**
 * ClaimWorkflow entity. @author MyEclipse Persistence Tools
 */

public class ClaimWorkflow implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer claim;
	private Integer workflowDefinition;

	// Constructors

	/** default constructor */
	public ClaimWorkflow() {
	}

	/** full constructor */
	public ClaimWorkflow(Integer claim, Integer workflowDefinition) {
		this.claim = claim;
		this.workflowDefinition = workflowDefinition;
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

}