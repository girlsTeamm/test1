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
	private UserRoleService userRoleService;
	private SysRoleService sysRoleService;
	private List<SysUser> listuser;
	private Set<UserRole> userRole;
	private String userid;

	
	
	  public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setUserId() {
	      FacesContext fc = FacesContext.getCurrentInstance();
	      Map<String,String> params = 
	         fc.getExternalContext().getRequestParameterMap();
	      userid =  params.get("UserId"); 
	   }
	@PostConstruct
	public void init() {
	}
	public SysUserBean(){
		sysuser= new SysUser();
		sysUserService= (SysUserService) BeanUtility.getBean("sysUserService");
		userRoleService= (UserRoleService)BeanUtility.getBean("userRoleService");
		sysRoleService=(SysRoleService)BeanUtility.getBean("sysRoleService");
		listuser= new ArrayList<SysUser>();
		userRole = new HashSet<UserRole>();
	}
	

	public SysUserBean(SysUser sysuser,UserRoleService userRoleService, SysUserService sysUserService, List<SysUser> listuser,Set<UserRole> userRole) {
		super();
		this.sysuser = sysuser;
		this.sysUserService = sysUserService;
		this.userRoleService= userRoleService;
		this.listuser = listuser;
		this.userRole=userRole;
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

	public List<SysUser> getListuser() {
		return listuser;
	}

	public UserRoleService getUserRoleService() {
		return userRoleService;
	}
	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	public void setListuser(List<SysUser> listuser) {
		this.listuser = listuser;
	}

	public List<SysUser> getListUser(){
		return sysUserService.getAll();	
	}
	public Set getUserRole() {
		return userRole;
	}
	
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	public SysRoleService getSysRoleService() {
		return sysRoleService;
	}
	
	
	public void setSysRoleService(SysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<SysRole> ShowRoleForUser(Integer userid){
		SysUser te= sysUserService.getById(userid);
		userRole=te.getUserRoles();
		
		List<SysRole> listRole=new ArrayList<>();
		
			for(UserRole g:userRole){
				SysRole temp=sysRoleService.getById(g.getSysRole().getId());
				listRole.add(temp);
			}
			return listRole;
		}
	
}
