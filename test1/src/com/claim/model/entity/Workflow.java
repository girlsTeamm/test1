package com.claim.model.entity;
// Generated 03/04/2018 11:59:14 ? by Hibernate Tools 5.1.0.Beta1

import java.util.HashSet;
import java.util.Set;

/**
 * Workflow generated by hbm2java
 */
public class Workflow implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4834403684479009209L;
	private Integer id;
	private String arabicName;
	private String englishName;
	private String code;
	private Set<WorkflowDefinition> workflowDefinitions = new HashSet<WorkflowDefinition>(0);

	public Workflow() {
	}

	public Workflow(String arabicName, String englishName, String code, Set<WorkflowDefinition> workflowDefinitions) {
		this.arabicName = arabicName;
		this.englishName = englishName;
		this.code = code;
		this.workflowDefinitions = workflowDefinitions;
	}

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

	public Set<WorkflowDefinition> getWorkflowDefinitions() {
		return this.workflowDefinitions;
	}

	public void setWorkflowDefinitions(Set<WorkflowDefinition> workflowDefinitions) {
		this.workflowDefinitions = workflowDefinitions;
	}

}
