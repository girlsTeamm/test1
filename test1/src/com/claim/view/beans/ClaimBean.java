package com.claim.view.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.claim.generic.view.utils.BeanUtility;
import com.claim.model.entity.Claim;
import com.claim.model.entity.ClaimType;
import com.claim.model.entity.SysUser;
import com.claim.model.service.ClaimService;
import com.claim.model.service.ClaimTypeService;
import com.claim.model.service.SysUserService;

@ManagedBean
@SessionScoped
public class ClaimBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2053821805477205370L;
	
	private Claim claim;
	private ClaimService claimService;
	private SysUserService sysUserService;
	private ClaimTypeService claimTypeService;
	private String claimTypeString ;
	
	@PostConstruct
	public void init() {
	}
	public ClaimBean(){
		claim = new Claim();
		claimService = (ClaimService) BeanUtility.getBean("claimService");
		sysUserService = (SysUserService) BeanUtility.getBean("sysUserService");
		claimTypeService = (ClaimTypeService) BeanUtility.getBean("claimTypeService");
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

	public String getClaimType() {
		return claimTypeString;
	}
	public void setClaimType(String claimTypeString) {
		this.claimTypeString = claimTypeString;
	}
	public void addClaim(){
		ClaimType claimType = new ClaimType();
		SysUser sysUser = new SysUser();
		Integer id = 1;
		Short claimTypeid = Short.parseShort(claimTypeString);;
		sysUser = sysUserService.getById(id);
		claimType = claimTypeService.getById(claimTypeid);
		claim.setClaimType(claimType);
		claim.setSysUser(sysUser);
		claimService.insert(claim);
	}
	

}
