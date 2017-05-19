package com.lyswzs.bean;

import java.io.Serializable;

public class CourseInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String cour_name;
	private int stu_id;
	private String stu_name;
	public String getCour_name() {
		return cour_name;
	}
	public int getStu_id() {
		return stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setCour_name(String cour_name) {
		this.cour_name = cour_name;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
}
