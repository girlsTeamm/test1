package com.claim.view.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import com.claim.generic.view.utils.BeanUtility;
import com.claim.model.entity.SysRole;
import com.claim.model.entity.SysUser;
import com.claim.model.entity.UserRole;
import com.claim.model.service.SysRoleService;
import com.claim.model.service.SysUserService;
import com.claim.model.service.UserRoleService;
import com.claim.view.utils.PageNavigation;


@ManagedBean
@SessionScoped
public class SysUserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5724499491959046599L;

	private SysUser sysuser;
	private SysUserService sysUserService;
	private SysRoleService sysRoleService;
	private String userid;

	
	@PostConstruct
	public void init() {
	}
	public SysUserBean(){
		sysuser= new SysUser();
		sysUserService= (SysUserService) BeanUtility.getBean("sysUserService");
		sysRoleService=(SysRoleService)BeanUtility.getBean("sysRoleService");
	}
	

	public SysUserBean(SysUser sysuser) {
		super();
		this.sysuser = sysuser;
	}

	public void addUser(){
		sysUserService.insert(sysuser);
	}

	public SysUser getSysuser() {
		return sysuser;
	}

	public void setSysuser(SysUser sysuser) {
		this.sysuser = sysuser;
	}

	public SysUserService getSysUserService() {
		return sysUserService;
	}

	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	public List<SysUser> getListUser(){
		return sysUserService.getAll();	
	}
	public SysRoleService getSysRoleService() {
		return sysRoleService;
	}
	
	
	public void setSysRoleService(SysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}
	
	
    public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	

	public List<SysRole> ShowRoleForUser(String userid){
		Integer id = Integer.parseInt(userid);
		SysUser user= sysUserService.getById(id);
		Set<UserRole> userRole = user.getUserRoles();
		List<SysRole> listRole = new ArrayList<SysRole>();
		
			for(UserRole temp:userRole){
				listRole.add(temp.getSysRole());
			}
			return listRole;
	}
	
	
	
}