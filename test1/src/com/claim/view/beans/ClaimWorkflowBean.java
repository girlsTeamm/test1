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
import com.claim.model.entity.SysUser;
import com.claim.model.service.ClaimService;
import com.claim.model.service.ClaimWorkflowService;
import com.claim.model.service.ClaimWorkflowStepService;
import com.claim.model.service.SysUserService;
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
	private SysUserService sysUserService;
	public ClaimWorkflowBean(){
		claim = new Claim();
		sysUserService = (SysUserService) BeanUtility.getBean("sysUserService");
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
	public List<ClaimWorkflow> getAllClaimInCheckerStep(){
		List<ClaimWorkflow> claimWorkflowList =claimWorkflowService.getAll();
		List<ClaimWorkflow> ClaimWorkflowList=new ArrayList<ClaimWorkflow>();
		
		for(ClaimWorkflow temp : claimWorkflowList){
			if(temp.getWorkflowDefinition().getStep().getArabicName().equals("تدقيق")){
				ClaimWorkflowList.add(temp);
			}
		}
		return ClaimWorkflowList;
	}
	public List<Claim> getAllClaim(){
		return claimService.getAll();
	}
	public Claim getFromSession(){
		return SessionUtils.getClaim();
	}
	
	public void putInSeeion(ClaimWorkflow claimWorkflow){
		HttpSession session = SessionUtils.getSession();
		this.claim=claimWorkflow.getClaim();
		claim.getClaimType().getArabicName();
		session.setAttribute("claimWorkflow", claimWorkflow);
	}

	public void SaveINCurrentTable( int numberofNextStep){
		switch(numberofNextStep){
			case 1:{
					claimWorkflow=SessionUtils.getClaimWorkflow();
					Claim temp=claimWorkflow.getClaim();
					temp.setDescription(claim.getDescription());
					temp.setSubject(claim.getSubject());
					ClaimWorkflowStep  claimWorkflowStep=new ClaimWorkflowStep();
					claimWorkflowStep.setClaim(temp);
					SysUser user = sysUserService.getById(1);
					claimWorkflowStep.setSysUser(user);
					claimWorkflowStep.setWorkflowDefinition(claimWorkflow.getWorkflowDefinition());
					temp.getClaimWorkflowSteps().add(claimWorkflowStep);
					temp.getClaimWorkflows().remove(temp.getClaimWorkflows());
					claimWorkflow.setWorkflowDefinition(claimWorkflow.getWorkflowDefinition().getWorkflowDefinitionByPrevious());
					temp.getClaimWorkflows().add(claimWorkflow);
					claimService.merge(temp);
					break;
			}
			case 2:{
					claimWorkflow=SessionUtils.getClaimWorkflow();
					Claim temp=claimWorkflow.getClaim();
					ClaimWorkflowStep  claimWorkflowStep=new ClaimWorkflowStep();
					claimWorkflowStep.setClaim(temp);
					SysUser user = sysUserService.getById(1);
					claimWorkflowStep.setSysUser(user);
					claimWorkflowStep.setWorkflowDefinition(claimWorkflow.getWorkflowDefinition());
					temp.getClaimWorkflowSteps().add(claimWorkflowStep);
					temp.getClaimWorkflows().remove(temp.getClaimWorkflows());
					claimWorkflow.setWorkflowDefinition(claimWorkflow.getWorkflowDefinition().getWorkflowDefinitionByNext());
					temp.getClaimWorkflows().add(claimWorkflow);
					claimService.merge(temp);
					break;
			}
			case 3:{
					claimWorkflow=SessionUtils.getClaimWorkflow();
					Claim temp=claimWorkflow.getClaim();
					ClaimWorkflowStep  claimWorkflowStep=new ClaimWorkflowStep();
					claimWorkflowStep.setClaim(temp);
					SysUser user = sysUserService.getById(1);
					claimWorkflowStep.setSysUser(user);
					claimWorkflowStep.setWorkflowDefinition(claimWorkflow.getWorkflowDefinition());
					temp.getClaimWorkflowSteps().add(claimWorkflowStep);
					temp.getClaimWorkflows().remove(temp.getClaimWorkflows());
					claimWorkflow.setWorkflowDefinition(claimWorkflow.getWorkflowDefinition().getWorkflowDefinitionByNext());
					temp.getClaimWorkflows().add(claimWorkflow);
					//temp.getClaimWorkflowSteps().add();
					claimService.merge(temp);
					break;
			}
		}
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

	public SysUserService getSysUserService() {
		return sysUserService;
	}

	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}
	
}
