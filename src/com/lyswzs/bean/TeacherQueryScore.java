package com.lyswzs.bean;

import java.io.Serializable;

public class TeacherQueryScore implements Serializable{
	private static final long serialVersionUID = 1L;
	private int teac_id;
	private String cour_name;
	private String stu_name;
	private float score;
	public String getCour_name() {
		return cour_name;
	}
	public String getStu_name() {
		return stu_name;
	}
	public float getScore() {
		return score;
	}
	public int getTeac_id() {
		return teac_id;
	}
	public void setTeac_id(int teac_id) {
		this.teac_id = teac_id;
	}
	public void setCour_name(String cour_name) {
		this.cour_name = cour_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
}
