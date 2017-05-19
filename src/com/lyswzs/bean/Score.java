package com.lyswzs.bean;

public class Score {
	private int score_id;
	private int cour_id;
	private int stu_id;
	private float score_score;
	public int getScore_id() {
		return score_id;
	}
	public int getCour_id() {
		return cour_id;
	}
	public int getStu_id() {
		return stu_id;
	}
	public float getScore_score() {
		return score_score;
	}
	public void setScore_id(int score_id) {
		this.score_id = score_id;
	}
	public void setCour_id(int cour_id) {
		this.cour_id = cour_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public void setScore_score(float score_score) {
		this.score_score = score_score;
	}
}
