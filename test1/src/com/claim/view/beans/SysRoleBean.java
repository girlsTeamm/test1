package com.claim.view.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.claim.generic.view.utils.BeanUtility;
import com.claim.model.entity.SysRole;
import com.claim.model.entity.SysUser;
import com.claim.model.service.SysRoleService;
import com.claim.model.service.SysUserService;

@SessionScoped
@ManagedBean
public class SysRoleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SysRole sysRole;
	private SysRoleService sysRoleService;
	
	
	public SysRoleBean() {
		super();
		
		sysRole = new SysRole();
		sysRoleService = (SysRoleService) BeanUtility.getBean("sysRoleService");
	}

	
	public void addSysRole() {
		sysRoleService.insert(sysRole);

	}

	public void deletSysRole(SysRole sysRole){
		sysRoleService.delete(sysRole);
		

	}


	public List<SysRole> getListSysRole() {
		return sysRoleService.getAll();

	}


	public SysRole getSysRole() {
		return sysRole;
	}


	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}
	


}
