package com.lyswzs.bean;

public class Admins {
	private int admins_id;
	private int role_id;
	private String admins_pwd;
	public int getAdmins_id() {
		return admins_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public String getAdmins_pwd() {
		return admins_pwd;
	}
	public void setAdmins_id(int admins_id) {
		this.admins_id = admins_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public void setAdmins_pwd(String admins_pwd) {
		this.admins_pwd = admins_pwd;
	}
}
