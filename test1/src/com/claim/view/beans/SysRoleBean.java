package com.claim.view.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import com.claim.generic.view.utils.BeanUtility;
import com.claim.model.entity.RolePermission;
import com.claim.model.entity.SysPermission;
import com.claim.model.entity.SysRole;
import com.claim.model.entity.SysUser;
import com.claim.model.entity.UserRole;

import com.claim.model.service.RolePermissionService;
import com.claim.model.service.SysPermissionService;
import com.claim.model.service.SysRoleService;
import com.claim.model.service.SysUserService;
import com.claim.model.service.UserRoleService;
import com.claim.view.utils.SessionUtils;


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
	private SysPermissionService sysPermissionService;
	private RolePermissionService rolePermissionService;
	private List<SysPermission> listPermission = new ArrayList<SysPermission>();
	private List <SysPermission>listPermission2= new ArrayList<SysPermission>() ;
	private Map<SysPermission,Boolean>Role =new HashMap<SysPermission, Boolean>();
	public SysRoleBean() {
		super();
		
		sysRole = new SysRole();
		sysRoleService = (SysRoleService) BeanUtility.getBean("sysRoleService");
		userRoleService = (UserRoleService) BeanUtility.getBean("userRoleService");
		sysUserService = (SysUserService) BeanUtility.getBean("sysUserService");
		sysPermissionService =(SysPermissionService)BeanUtility.getBean("sysPermissionService");
		rolePermissionService =(RolePermissionService) BeanUtility.getBean("rolePermissionService");
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

	public  void deletUserRole(int  Role,int userid){
		SysRole tr= sysRoleService.getById(Role);
		for(UserRole temp: userRoleService.getAll()){
			if((temp.getSysRole().equals(tr)) && (temp.getSysUser().getId()== userid)){
				userRoleService.delete(temp);
				break;
			}
			   
		}
	}

    public void deleteAllRolesforUser(String userid){
    	
    	Integer id = Integer.parseInt(userid);
		SysUser user= sysUserService.getById(id);
		/*for(UserRole temp:user.getUserRoles()){
			userRoleService.delete(temp);
		}*/	
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
	public List<SysRole> getListRole(){
		return sysRoleService.getAll();
	}
	/**
	 * to fill map with all Permission founded in database
	 **/
	public void addtomap(){
		List<SysPermission> listPermissionNoNe=sysPermissionService.getAll();
		listPermission2=listPermissionNoNe;
		for(SysPermission temp : listPermissionNoNe){
			Role.put(temp, false);
	    }
	}
	/**
	 * this function for get all permission assign for specific role
	 * and we fill map role Permission with true if permission assign for specific role
	 * @param roleid
	 * @return list of All sysPermission in dataBase
	 */
	public List<SysPermission> ShowPermissionForRole(String roleid){
		listPermission2.clear();
		listPermission.clear();
		Integer id = Integer.parseInt(roleid);
		SysRole user= sysRoleService.getById(id);
		Set<RolePermission> userRole = user.getRolePermissions();
		listPermission = new ArrayList<SysPermission>();
		for(RolePermission temp:userRole){
			listPermission.add(temp.getSysPermission());
		}
		addtomap();
	    for(SysPermission temp : listPermission){
	    	Role.put(temp, true);
	    }
	    return listPermission2;
	}
	public void putInSeeion(SysRole role){
		HttpSession session = SessionUtils.getSession();
		session.setAttribute("Roleid", role.getId());
	}
	public String getFromSession(){
		return SessionUtils.getRoleId();
	}
	/**
	 * add role for user 
	 * we assign role and user object to role user object then insert it
	 **/
	public  void addUserRole(SysRole roleid, int userid) {
		// TODO Auto-generated method stub
		SysUser user= sysUserService.getById(userid);
		UserRole userRole=new UserRole();
		userRole.setSysRole(roleid);
		userRole.setSysUser(user);
		userRoleService.insert(userRole);
	}


	public SysUserService getSysUserService() {
		return sysUserService;
	}


	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}


	public SysPermissionService getSysPermissionService() {
		return sysPermissionService;
	}


	public void setSysPermissionService(SysPermissionService sysPermissionService) {
		this.sysPermissionService = sysPermissionService;
	}


	public RolePermissionService getRolePermissionService() {
		return rolePermissionService;
	}


	public void setRolePermissionService(RolePermissionService rolePermissionService) {
		this.rolePermissionService = rolePermissionService;
	}


	public List<SysPermission> getlistPermission2() {
		return listPermission2;
	}


	public void setlistPermission2(List<SysPermission> toto) {
		this.listPermission2 = toto;
	}


	public Map<SysPermission, Boolean> getRole() {
		return Role;
	}
	public void setRole(Map<SysPermission, Boolean> Role) {
		this.Role = Role;
	}
	public void setListRole(List<SysPermission> listRole) {
		this.listPermission = listRole;
	}
	/**
	 * to check if any changes in the specific role( add or delete any permission for role)
	 * @param id
	 **/
	public void check(String id){
		int Roleid =Integer.parseInt(id);
		for (Map.Entry <SysPermission, Boolean> entry : Role.entrySet()) {
			if(entry.getValue()==true){
				boolean t =false;
				for (SysPermission object : listPermission) {
			        if (object.getId() == entry.getKey().getId()) {
			        	t=true;
			        }
			    }
				if(t==false){
		        	addRolePermission(entry.getKey(),Roleid);
				}
			}else{
				boolean t =false;
				for (SysPermission object : listPermission) {
			        if (object.getId() == entry.getKey().getId()) {
			        	t=true;
			        }
				}
				if(t==true){
					deletRolePermission(entry.getKey().getId(),Roleid);
				}
		  }
	    }	
	}
	/**
	 * delete role for permission 
	 * we search in the whole rolePermission tale for this object then delete it 
	 **/
	public  void deletRolePermission(int  permissionid,int Roleid){
		SysRole sysRole= sysRoleService.getById(Roleid);
		for(RolePermission temp: rolePermissionService.getAll()){
			if((temp.getSysRole().equals(sysRole)) && (temp.getSysPermission().getId()== permissionid)){
				rolePermissionService.delete(temp);
				break;
			} 
		}
	}
	/**
	 * add role for permission 
	 * we assign role and permission object to role permission object then insert it
	 **/
	public  void addRolePermission(SysPermission permission, int Roleid) {
		// TODO Auto-generated method stub
		SysRole role= sysRoleService.getById(Roleid);
		RolePermission rolePermissio=new RolePermission();
		rolePermissio.setSysPermission(permission);
		rolePermissio.setSysRole(role);
		rolePermissionService.insert(rolePermissio);
	}
}