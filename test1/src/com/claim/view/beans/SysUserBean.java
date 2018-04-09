package com.claim.view.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.claim.generic.view.utils.BeanUtility;
import com.claim.model.entity.SysRole;
import com.claim.model.entity.SysUser;
import com.claim.model.entity.UserRole;
import com.claim.model.service.SysRoleService;
import com.claim.model.service.SysUserService;
import com.claim.model.service.UserRoleService;
import com.claim.view.utils.PageNavigation;
import com.claim.view.utils.SessionUtils;
import com.google.common.collect.Iterables;
import com.claim.view.beans.*;

@ManagedBean
@SessionScoped
public class SysUserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5724499491959046599L;

	private SysUser sysuser;
	private SysRoleBean sysRole=new SysRoleBean();
	private SysUserService sysUserService;
	private SysRoleService sysRoleService;
	private String userid;
	private List <SysRole>toto= new ArrayList<SysRole>() ;
	private List<SysRole> listRole = new ArrayList<SysRole>();
	private Map<SysRole,Boolean>t =new HashMap<SysRole, Boolean>();
	public List<SysRole> getListRole() {
		return listRole;
	}
	public void setListRole(List<SysRole> listRole) {
		this.listRole = listRole;
	}
	public Map<SysRole, Boolean> getT() {
		return t;
	}
	public void setT(Map<SysRole, Boolean> t) {
		this.t = t;
	}
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
	public List<SysRole> getToto() {
		return toto;
	}
	public void setToto(List<SysRole> toto) {
		this.toto = toto;
	}
	public void addtomap(){
		List<SysRole> listRoleNoNe=sysRoleService.getAll();
		toto=listRoleNoNe;
		for(SysRole temp : listRoleNoNe){
	    	t.put(temp, false);
	    }
	}
	
	public List<SysRole> ShowRoleForUser(String userid){
		toto.clear();
		listRole.clear();
		Integer id = Integer.parseInt(userid);
		SysUser user= sysUserService.getById(id);
		Set<UserRole> userRole = user.getUserRoles();
	    listRole = new ArrayList<SysRole>();
		
			for(UserRole temp:userRole){
				listRole.add(temp.getSysRole());
			}
			addtomap();
	    for(SysRole temp : listRole){
	    	t.put(temp, true);
	    }
	    return toto;
	}
	public void putInSeeion(SysUser user){

		HttpSession session = SessionUtils.getSession();
		session.setAttribute("userid", user.getId());
		toto.clear();
	}
	void addNewRole(SysRole toto2){
		listRole.add(toto2);
	}
	public String getFromSession(){
		return SessionUtils.getUserId();
	}
	/**
	 * to check if any changes in the specific user ( add or delete any role for user)
	 * @param id
	 **/
	public void check(String id){
		int userid =Integer.parseInt(id);
		for (Map.Entry <SysRole, Boolean> entry : t.entrySet()) {
			if(entry.getValue()==true){
				boolean t =false;
				for (SysRole object : listRole) {
			        if (object.getId() == entry.getKey().getId()) {
			        	t=true;
			        }
			        }
				if(t==false){
		        	sysRole.addUserRole(entry.getKey(),userid);
				}
				}
				
			else{
				boolean t =false;
				for (SysRole object : listRole) {
					
			        if (object.getId() == entry.getKey().getId()) {
			        	t=true;
			        	
			        }
				}
				if(t==true){
					sysRole.deletUserRole(entry.getKey().getId(),userid);
				}
						
		  }
	    }	
	}
}