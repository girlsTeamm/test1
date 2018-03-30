package com.claim.model.entity;

/**
 * ClaimDocument entity. @author MyEclipse Persistence Tools
 */

public class ClaimDocument implements java.io.Serializable {

	// Fields

	private String id;
	private Integer claim;
	private Short documentType;
	private byte[] data;

	// Constructors

	/** default constructor */
	public ClaimDocument() {
	}

	/** minimal constructor */
	public ClaimDocument(Integer claim, Short documentType) {
		this.claim = claim;
		this.documentType = documentType;
	}

	/** full constructor */
	public ClaimDocument(Integer claim, Short documentType, byte[] data) {
		this.claim = claim;
		this.documentType = documentType;
		this.data = data;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getClaim() {
		return this.claim;
	}

	public void setClaim(Integer claim) {
		this.claim = claim;
	}

	public Short getDocumentType() {
		return this.documentType;
	}

	public void setDocumentType(Short documentType) {
		this.documentType = documentType;
	}

	public byte[] getData() {
		return this.data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}