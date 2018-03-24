package com.claim.view.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.claim.generic.view.utils.BeanUtility;
import com.claim.model.entity.SysRole;
import com.claim.model.entity.SysUser;
import com.claim.model.entity.UserRole;
import com.claim.model.service.SysRoleService;
import com.claim.model.service.SysUserService;
import com.claim.model.service.UserRoleService;


@SessionScoped
@ManagedBean
public class SysRoleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SysRole sysRole;
	private SysRoleService sysRoleService;
	private UserRoleService userRoleService;
	private SysUserService sysUserService;
	
	
	public SysRoleBean() {
		super();
		
		sysRole = new SysRole();
		sysRoleService = (SysRoleService) BeanUtility.getBean("sysRoleService");
		userRoleService = (UserRoleService) BeanUtility.getBean("userRoleService");
		sysUserService = (SysUserService) BeanUtility.getBean("sysUserService");
	}

	
	public SysRoleService getSysRoleService() {
		return sysRoleService;
	}


	public void setSysRoleService(SysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}


	public UserRoleService getUserRoleService() {
		return userRoleService;
	}


	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}


	public void addSysRole() {
		sysRoleService.insert(sysRole);

	}

	public void deletUserRole(SysRole Role,String userid){
		
		if (Role != null){
			SysUser sysUser = new SysUser();
			Integer id = Integer.parseInt(userid);
			sysUser = sysUserService.getById(id);
			Set<UserRole> userRole = sysUser.getUserRoles();
			for(UserRole ur:userRole){
				if(ur.getSysRole().equals(Role)){
					sysUser.getUserRoles().remove(ur);
					Role.getUserRoles().remove(ur);
					sysUserService.merge(sysUser);
					sysRoleService.merge(Role);
				}
			}		
		}
		sysRole = new SysRole();
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
