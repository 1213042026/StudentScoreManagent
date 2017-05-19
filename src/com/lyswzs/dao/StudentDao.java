package com.lyswzs.dao;

import java.util.List;

import com.lyswzs.bean.Student;
import com.lyswzs.bean.StudentScore;

public interface StudentDao {
	public List<StudentScore> findScore(int id);

	public boolean update(int stu_id, String stu_pwd, String stu_tel, String stu_address);

	public Student findStu(int stu_id);
	
	 public List<Student> findAll();
	  
	  public boolean deleteById(int stu_id);
	  
	  public boolean insert(Student stu);

}
