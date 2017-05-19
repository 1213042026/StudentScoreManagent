package com.lyswzs.dao;

import com.lyswzs.bean.Admins;
import com.lyswzs.bean.Student;
import com.lyswzs.bean.Teacher;

public interface LoginDao {
	public Admins isAdminsLoginSuccess(int id,String password);
	
	public Student isStudentLoginSuccess(int id,String password);
	
	public Teacher isTeacherLoginSuccess(int id,String password);
}
