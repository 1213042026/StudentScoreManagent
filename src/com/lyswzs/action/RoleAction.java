package com.lyswzs.action;

import com.lyswzs.dao.RoleDao;
import com.lyswzs.dao.impl.RoleDaoImpl;

public class RoleAction {

	private int roleId;
	private RoleDao dao=new RoleDaoImpl();
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getName(){
		dao.getName(roleId);
		return "ok";
	}
}
