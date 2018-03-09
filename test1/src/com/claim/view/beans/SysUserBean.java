package com.claim.view.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.claim.generic.view.utils.BeanUtility;
import com.claim.model.entity.SysUser;
import com.claim.model.service.SysUserService;

@ManagedBean
@SessionScoped
public class SysUserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5724499491959046599L;

	private SysUser sysuser;
	private SysUserService sysUserService;
	private List<SysUser> listuser;
	
	@PostConstruct
	public void init() {
	}
	public SysUserBean(){
		sysuser= new SysUser();
		sysUserService= (SysUserService) BeanUtility.getBean("sysUserService");
		listuser= new ArrayList<SysUser>();
	}
	

	public SysUserBean(SysUser sysuser, SysUserService sysUserService, List<SysUser> listuser) {
		super();
		this.sysuser = sysuser;
		this.sysUserService = sysUserService;
		this.listuser = listuser;
	}

	public void addUser() {
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

	public void setListuser(List<SysUser> listuser) {
		this.listuser = listuser;
	}

	public List<SysUser> getListUser(){
		return sysUserService.getAll();	
	}
}
