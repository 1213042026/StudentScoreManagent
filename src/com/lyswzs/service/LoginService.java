package com.lyswzs.service;

import com.lyswzs.bean.Admins;
import com.lyswzs.bean.Student;
import com.lyswzs.bean.Teacher;
import com.lyswzs.dao.LoginDao;
import com.lyswzs.dao.impl.LoginDaoImpl;

public class LoginService {
	private LoginDao dao = new LoginDaoImpl();
	
	public Admins isAdminsLoginSuccess(int id,String password){
		return dao.isAdminsLoginSuccess(id, password);
	}
	
	public Student isStudentLoginSuccess(int id,String password){
		return dao.isStudentLoginSuccess(id, password);
	}
	
	public Teacher isTeacherLoginSuccess(int id,String password){
		return dao.isTeacherLoginSuccess(id, password);
	}
}
