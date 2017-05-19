package com.lyswzs.service;

import java.util.List;

import com.lyswzs.bean.Course;
import com.lyswzs.bean.CourseInfo;
import com.lyswzs.bean.TeacherQueryScore;
import com.lyswzs.dao.TeacherDao;
import com.lyswzs.dao.impl.TeacherDaoImpl;

public class TeacherService {
	private TeacherDao dao = new TeacherDaoImpl();
	
	/**
	 * ���пγ��б�
	 * @param id
	 * @return
	 */
	public List<Course> courseList(int id){
		return dao.courseList(id);
	}
	
	/**
	 * ��ʦ�����޸�����
	 * @param id
	 * @param password
	 * @return
	 */
	public boolean updateTeacheInfo(int id,String password){
		return dao.updateTeacheInfo(id, password);
	}
	
	/**
	 * �γ���Ϣ
	 * @param id
	 * @return
	 */
	public List<CourseInfo> courseInfo(int id,String cour_name){
		return dao.courseInfo(id,cour_name);
	}
	
	public List<Course> scoreList(int id){
		return dao.scoreList(id);
	}
	
	public List<TeacherQueryScore> scoreInfo(int id,String cour_name){
		return dao.scoreInfo(id, cour_name);
	}
}
