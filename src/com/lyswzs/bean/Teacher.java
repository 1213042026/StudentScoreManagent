package com.lyswzs.bean;

public class Teacher {
	private int teac_id;
	private int role_id;
	private String teac_name;
	private String teac_pwd;

	public int getTeac_id() {
		return teac_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public String getTeac_name() {
		return teac_name;
	}

	public String getTeac_pwd() {
		return teac_pwd;
	}

	public void setTeac_id(int teac_id) {
		this.teac_id = teac_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public void setTeac_name(String teac_name) {
		this.teac_name = teac_name;
	}

	public void setTeac_pwd(String teac_pwd) {
		this.teac_pwd = teac_pwd;
	}
}
