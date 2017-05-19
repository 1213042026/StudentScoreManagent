package com.lyswzs.action;

import java.util.List;

import com.lyswzs.bean.Course;
import com.lyswzs.dao.CourseDao;
import com.lyswzs.dao.impl.CourseDaoImpl;

public class CourseAction {

	private Course course;
	private List<Course> list;
	private CourseDao dao = new CourseDaoImpl();
	private String cour_id;

	public String getCour_id() {
		return cour_id;
	}

	public void setCour_id(String cour_id) {
		this.cour_id = cour_id;
	}

	public CourseDao getDao() {
		return dao;
	}

	public void setDao(CourseDao dao) {
		this.dao = dao;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Course> getList() {
		return list;
	}

	public void setList(List<Course> list) {
		this.list = list;
	}

	public String findAll() {
		String result = "error";
		list = dao.findAll();
		if (list != null) {
			result = "ok";
		}
		return result;
	}

	public String deleteById(){
		String result = "error";
		if (dao.deleteById(Integer.parseInt(cour_id))){
			result = "deleteok";
		}
		return result;
	}

	public String insert(){
		String result = "error";
		if (dao.insert(course)){
			result = "insertok";
		}
		return result;
	}
	
}
