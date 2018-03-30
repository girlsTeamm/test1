package com.claim.model.entity;

/**
 * WorkflowDefinition entity. @author MyEclipse Persistence Tools
 */

public class WorkflowDefinition implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer workflow;
	private Short step;
	private Integer next;
	private Integer previous;
	private Boolean initialStep;
	private Boolean finalStep;

	// Constructors

	/** default constructor */
	public WorkflowDefinition() {
	}

	/** full constructor */
	public WorkflowDefinition(Integer workflow, Short step, Integer next, Integer previous, Boolean initialStep,
			Boolean finalStep) {
		this.workflow = workflow;
		this.step = step;
		this.next = next;
		this.previous = previous;
		this.initialStep = initialStep;
		this.finalStep = finalStep;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWorkflow() {
		return this.workflow;
	}

	public void setWorkflow(Integer workflow) {
		this.workflow = workflow;
	}

	public Short getStep() {
		return this.step;
	}

	public void setStep(Short step) {
		this.step = step;
	}

	public Integer getNext() {
		return this.next;
	}

	public void setNext(Integer next) {
		this.next = next;
	}

	public Integer getPrevious() {
		return this.previous;
	}

	public void setPrevious(Integer previous) {
		this.previous = previous;
	}

	public Boolean getInitialStep() {
		return this.initialStep;
	}

	public void setInitialStep(Boolean initialStep) {
		this.initialStep = initialStep;
	}

	public Boolean getFinalStep() {
		return this.finalStep;
	}

	public void setFinalStep(Boolean finalStep) {
		this.finalStep = finalStep;
	}

}