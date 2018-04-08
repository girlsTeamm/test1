package com.claim.view.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.claim.generic.view.utils.BeanUtility;
import com.claim.model.entity.Claim;
import com.claim.model.service.ClaimService;

@ManagedBean
@SessionScoped
public class ClaimBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2053821805477205370L;
	
	private Claim claim;
	private ClaimService claimService;
	
	@PostConstruct
	public void init() {
	}
	public ClaimBean(){
		claim = new Claim();
		claimService = (ClaimService) BeanUtility.getBean("claimService");
	}

	

	public ClaimBean(Claim claim) {
		super();
		this.claim = claim;
	}



	public Claim getClaim() {
		return claim;
	}


	public void setClaim(Claim claim) {
		this.claim = claim;
	}
	
	
	
	public ClaimService getClaimService() {
		return claimService;
	}

	public void setClaimService(ClaimService claimService) {
		this.claimService = claimService;
	}

	public void addClaim(){
		claimService.insert(claim);
	}
	

}
