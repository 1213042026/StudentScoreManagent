package com.lyswzs.dao;

import java.util.List;

import com.lyswzs.bean.Course;
import com.lyswzs.bean.CourseInfo;
import com.lyswzs.bean.Teacher;
import com.lyswzs.bean.TeacherQueryScore;

public interface TeacherDao {
	/**
	 * ��ʦ�ܲ�ѯ�����Լ��Ŀγ��б�
	 * @return
	 */
	public List<Course> courseList(int id);
	
	/**
	 * ��ʦ�޸�����
	 * @param id
	 * @param password
	 * @return
	 */
	public boolean updateTeacheInfo(int id,String password);
	
	/**
	 * ��ѯ����ʦ���̿γ̵�������Щѧ��
	 * @param id
	 * @return
	 */
	public List<CourseInfo> courseInfo(int id,String cour_name);
	
	/**
	 * ��ʦ���ܲ�ѯ�����Լ����ڵĿγ��б�
	 * @return
	 */
	public List<Course> scoreList(int id);
	
	/**
	 * ��ѯ���γ������ѧ���ɼ�
	 * @param id
	 * @param cour_name
	 * @return
	 */
	public List<TeacherQueryScore> scoreInfo(int id,String cour_name);
	public List<Teacher> findAll();
	  
	  public boolean deleteById(int teac_id);
	  
	  public boolean insert(Teacher teac);
}
