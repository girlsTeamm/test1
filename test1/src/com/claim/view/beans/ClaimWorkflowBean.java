package com.claim.view.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import com.claim.generic.view.utils.BeanUtility;
import com.claim.model.entity.Claim;
import com.claim.model.entity.ClaimWorkflow;
import com.claim.model.entity.ClaimWorkflowStep;
import com.claim.model.entity.SysRole;
import com.claim.model.service.ClaimService;
import com.claim.model.service.ClaimWorkflowService;
import com.claim.model.service.ClaimWorkflowStepService;
import com.claim.view.utils.SessionUtils;

@ManagedBean
@SessionScoped

public class ClaimWorkflowBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClaimWorkflow claimWorkflow;
	private Claim claim ;
	private ClaimWorkflowService claimWorkflowService;
	private ClaimService claimService;
	private ClaimWorkflowStepService  claimWorkflowStepService;
	
	public ClaimWorkflowBean(){
		claim = new Claim();
		claimWorkflowService =(ClaimWorkflowService)BeanUtility.getBean("claimWorkflowService");
		claimService = (ClaimService)BeanUtility.getBean("claimService");
		claimWorkflowStepService = (ClaimWorkflowStepService)BeanUtility.getBean("claimWorkflowStepService");
	}
	
	public ClaimWorkflow getClaimWorkflow() {
		return claimWorkflow;
	}
	public void setClaimWorkflow(ClaimWorkflow claimWorkflow) {
		this.claimWorkflow = claimWorkflow;
	}
	public ClaimWorkflowService getClaimWorkflowService() {
		return claimWorkflowService;
	}
	public void setClaimWorkflowService(ClaimWorkflowService claimWorkflowService) {
		this.claimWorkflowService = claimWorkflowService;
	}
	
	public List<ClaimWorkflow> getAllClaimInCorrectStep(){
		List<ClaimWorkflow> claimWorkflowList =claimWorkflowService.getAll();
		List<ClaimWorkflow> ClaimWorkflowList=new ArrayList<ClaimWorkflow>();
		
		for(ClaimWorkflow temp : claimWorkflowList){
			if(temp.getWorkflowDefinition().getStep().getArabicName().equals("تصحيح")){
				ClaimWorkflowList.add(temp);
			}
		}
		return ClaimWorkflowList;
	}
	
	public Claim getFromSession(){
		return SessionUtils.getClaim();
	}
	
	public void putInSeeion(ClaimWorkflow claimWorkflow){
		HttpSession session = SessionUtils.getSession();
		this.claim=claimWorkflow.getClaim();
		session.setAttribute("claimWorkflow", claimWorkflow);
	}
	
	public void Save(){
		//claimService.merge(claim);
		claimWorkflow=SessionUtils.getClaimWorkflow();
		Claim temp=claimWorkflow.getClaim();
		temp.setDescription(claim.getDescription());
		temp.setSubject(claim.getSubject());
		claimService.merge(temp);
		//ClaimWorkflowStep temp =new ClaimWorkflowStep();
		//temp.setClaim(claim);
		//temp.setWorkflowDefinition(claimWorkflow.getWorkflowDefinition());
		//claimWorkflowStepService.insert(temp);
		//claimWorkflow.setWorkflowDefinition(claimWorkflow.getWorkflowDefinition().getWorkflowDefinitionByNext());
		//claimWorkflowService.merge(claimWorkflow);
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

	public ClaimWorkflowStepService getClaimWorkflowStepService() {
		return claimWorkflowStepService;
	}

	public void setClaimWorkflowStepService(ClaimWorkflowStepService claimWorkflowStepService) {
		this.claimWorkflowStepService = claimWorkflowStepService;
	}
}
