package com.lyswzs.bean;

import java.io.Serializable;

public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	private int cour_id;
	private int teac_id;
	private String cour_name;

	public int getCour_id() {
		return cour_id;
	}

	public int getTeac_id() {
		return teac_id;
	}

	public String getCour_name() {
		return cour_name;
	}

	public void setCour_id(int cour_id) {
		this.cour_id = cour_id;
	}

	public void setTeac_id(int teac_id) {
		this.teac_id = teac_id;
	}

	public void setCour_name(String cour_name) {
		this.cour_name = cour_name;
	}
}
