package com.lyswzs.bean;

public class Student {
	private int stu_id;
	private int role_id;
	private int class_id;
	private String stu_name;
	private String stu_pwd;
	private String stu_sex;
	private String stu_tel;
	private String stu_address;
	public int getStu_id() {
		return stu_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public int getClass_id() {
		return class_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public String getStu_pwd() {
		return stu_pwd;
	}
	public String getStu_sex() {
		return stu_sex;
	}
	public String getStu_address() {
		return stu_address;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public void setStu_pwd(String stu_pwd) {
		this.stu_pwd = stu_pwd;
	}
	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}
	public void setStu_address(String stu_address) {
		this.stu_address = stu_address;
	}
	public String getStu_tel() {
		return stu_tel;
	}
	public void setStu_tel(String stu_tel) {
		this.stu_tel = stu_tel;
	}
}
