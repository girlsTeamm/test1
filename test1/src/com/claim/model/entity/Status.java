package com.claim.model.entity;
// Generated 03/04/2018 11:59:14 ? by Hibernate Tools 5.1.0.Beta1

import java.util.HashSet;
import java.util.Set;

/**
 * Status generated by hbm2java
 */
public class Status implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3048208942677155877L;
	private Short id;
	private String arabicName;
	private String englishName;
	private String code;
	private String description;
	private Set<ClaimStatus> claimStatuses = new HashSet<ClaimStatus>(0);
	private Set<ClaimStatusStep> claimStatusSteps = new HashSet<ClaimStatusStep>(0);

	public Status() {
	}

	public Status(String arabicName, String englishName) {
		this.arabicName = arabicName;
		this.englishName = englishName;
	}

	public Status(String arabicName, String englishName, String code, String description, Set<ClaimStatus> claimStatuses,
			Set<ClaimStatusStep> claimStatusSteps) {
		this.arabicName = arabicName;
		this.englishName = englishName;
		this.code = code;
		this.description = description;
		this.claimStatuses = claimStatuses;
		this.claimStatusSteps = claimStatusSteps;
	}

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<ClaimStatus> getClaimStatuses() {
		return this.claimStatuses;
	}

	public void setClaimStatuses(Set<ClaimStatus> claimStatuses) {
		this.claimStatuses = claimStatuses;
	}

	public Set<ClaimStatusStep> getClaimStatusSteps() {
		return this.claimStatusSteps;
	}

	public void setClaimStatusSteps(Set<ClaimStatusStep> claimStatusSteps) {
		this.claimStatusSteps = claimStatusSteps;
	}

}
