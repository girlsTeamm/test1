package com.claim.view.beans;

import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.claim.generic.view.utils.BeanUtility;
import com.claim.model.entity.Claim;
import com.claim.model.entity.ClaimType;
import com.claim.model.entity.ClaimWorkflow;
import com.claim.model.entity.SysUser;
import com.claim.model.service.ClaimService;
import com.claim.model.service.ClaimTypeService;
import com.claim.model.service.ClaimWorkflowService;
import com.claim.model.service.SysUserService;
import com.claim.model.service.WorkflowDefinitionService;

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
	private String cltypestring="1" ,UniqeCode = "1";
	private WorkflowDefinitionService workflowDefinitionService ;
	@PostConstruct
	public void init() {
	}
	public ClaimBean(){
		claim = new Claim();
		claimService = (ClaimService) BeanUtility.getBean("claimService");
		sysUserService = (SysUserService) BeanUtility.getBean("sysUserService");
		claimTypeService = (ClaimTypeService) BeanUtility.getBean("claimTypeService");
		workflowDefinitionService=(WorkflowDefinitionService)BeanUtility.getBean("workflowDefinitionService");
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


	public SysUserService getSysUserService() {
		return sysUserService;
	}
	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}
	public ClaimTypeService getClaimTypeService() {
		return claimTypeService;
	}
	public void setClaimTypeService(ClaimTypeService claimTypeService) {
		this.claimTypeService = claimTypeService;
	}
	
	
	
	public String getCltypestring() {
		return cltypestring;
	}
	public void setCltypestring(String cltypestring) {
		this.cltypestring = cltypestring;
	}
	public String getUniqeCode() {
		return UniqeCode;
	}
	public void setUniqeCode(String uniqeCode) {
		UniqeCode = uniqeCode;
	}
	public void addClaim(){
		Random rand = new Random( System.currentTimeMillis() );
		int n = rand.nextInt( 999999 );
		UniqeCode = String.valueOf(n);
		ClaimType claimType = new ClaimType();
		SysUser sysUser = new SysUser();
		Integer id = 1;
		Short claimTypeid = Short.parseShort(cltypestring);
		sysUser = sysUserService.getById(id);
		claimType = claimTypeService.getById(claimTypeid);
		claim.setClaimType(claimType);
		claim.setSysUser(sysUser);
		//send claim to checker
//		ClaimWorkflow claimWorkflow=new ClaimWorkflow();
//		claimWorkflow.setClaim(claim);
//		claimWorkflow.setWorkflowDefinition(workflowDefinitionService.getById(1));
//		claim.getClaimWorkflows().add(claimWorkflow);
		claimService.insert(claim);
		
		claim=new Claim();
		
	
	}
	public WorkflowDefinitionService getWorkflowDefinitionService() {
		return workflowDefinitionService;
	}
	public void setWorkflowDefinitionService(WorkflowDefinitionService workflowDefinitionService) {
		this.workflowDefinitionService = workflowDefinitionService;
	}
}