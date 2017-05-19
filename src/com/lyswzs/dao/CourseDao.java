package com.lyswzs.dao;

import java.util.List;

import com.lyswzs.bean.Course;

public interface CourseDao {
	public List<Course> findAll();
	  
	  public boolean deleteById(int cour_id);
	  
	  public boolean insert(Course cour);
	  }
