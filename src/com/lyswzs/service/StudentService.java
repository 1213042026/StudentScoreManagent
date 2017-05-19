package com.lyswzs.service;

import java.util.List;

import com.lyswzs.bean.Student;
import com.lyswzs.bean.StudentScore;
import com.lyswzs.dao.StudentDao;
import com.lyswzs.dao.impl.StudentDaoImpl;

public class StudentService {
	StudentDao dao=new StudentDaoImpl();
	public List<StudentScore> findScore(int id){
		return dao.findScore(id);
	}
	public boolean update(int stu_id, String stu_pwd, String stu_tel, String stu_address) {
		// TODO Auto-generated method stub
		return dao.update(stu_id,stu_pwd,stu_tel,stu_address);
	}
	public Student findStu(int stu_id) {
		// TODO Auto-generated method stub
		return dao.findStu(stu_id);
	}
}
