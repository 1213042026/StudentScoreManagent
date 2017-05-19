package com.lyswzs.action;

import com.lyswzs.dao.AdminsDao;
import com.lyswzs.dao.impl.AdminsDaoImpl;

public class AdminAction {
	
	private String admins_pwd;
	private int admins_id;
	public String login(){
		AdminsDao dao=new AdminsDaoImpl();
		return dao.login(admins_id, admins_pwd);
	}
	public String getAdmins_pwd() {
		return admins_pwd;
	}
	public void setAdmins_pwd(String admins_pwd) {
		this.admins_pwd = admins_pwd;
	}
	public int getAdmins_id() {
		return admins_id;
	}
	public void setAdmins_id(int admins_id) {
		this.admins_id = admins_id;
	}
}
