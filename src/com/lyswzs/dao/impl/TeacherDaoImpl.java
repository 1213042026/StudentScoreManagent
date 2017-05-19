package com.lyswzs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lyswzs.bean.Course;
import com.lyswzs.bean.CourseInfo;
import com.lyswzs.bean.Teacher;
import com.lyswzs.bean.TeacherQueryScore;
import com.lyswzs.dao.TeacherDao;
import com.lyswzs.utils.DBUtile;

public class TeacherDaoImpl implements TeacherDao{
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private List<Course> list;
	private List<CourseInfo> courseinfoList;
	private List<TeacherQueryScore> queryscoreList;
	private Teacher teac;
	
	@Override
	public List<Course> courseList(int id) {
		String sql = "SELECT course.cour_name,course.cour_id,teacher.teac_id FROM teacher INNER JOIN course ON course.teac_id = teacher.teac_id WHERE teacher.teac_id = ?";
		list = new ArrayList<Course>();
		conn = DBUtile.getConnection();
		Course course = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				course = new Course();
				course.setTeac_id(rs.getInt("teac_id"));
				course.setCour_id(rs.getInt("cour_id"));
				course.setCour_name(rs.getString("cour_name"));
				list.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * ��ʦ�޸��Լ�������
	 */
	@Override
	public boolean updateTeacheInfo(int id, String password) {
		String sql = "UPDATE teacher SET teac_pwd = ? WHERE teac_id = ?";
		conn = DBUtile.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, id);
			int n = ps.executeUpdate();
			if (n>0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ��ѯ����ʦ���̿γ�������Щѧ��
	 */
	@Override
	public List<CourseInfo> courseInfo(int id,String cour_name) {
		String sql = "SELECT cour_name,s.stu_id,stu_name from course c "
						+" INNER JOIN teacher t on c.teac_id=t.teac_id "
						+" INNER JOIN stu_course sc on c.cour_id=sc.cour_id "
						+" INNER JOIN student s on sc.stu_id=s.stu_id "
						+" where t.teac_id=? and c.cour_name=?";
		courseinfoList = new ArrayList<CourseInfo>();
		conn = DBUtile.getConnection();
		CourseInfo courseInfo = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, cour_name);
			rs = ps.executeQuery();
			while (rs.next()) {
				courseInfo = new CourseInfo();
				courseInfo.setCour_name(rs.getString("cour_name"));
				courseInfo.setStu_id(rs.getInt("stu_id"));
				courseInfo.setStu_name(rs.getString("stu_name"));
				courseinfoList.add(courseInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return courseinfoList;
	}

	@Override
	public List<Course> scoreList(int id) {
		String sql = "SELECT course.cour_name, course.cour_id FROM course where teac_id = ?";
		list = new ArrayList<Course>();
		Course course = null;
		conn = DBUtile.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				course = new Course();
				course.setCour_id(rs.getInt("cour_id"));
				course.setCour_name(rs.getString("cour_name"));
				list.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * ��ѯĳһ�γ�����ĳɼ�
	 */
	@Override
	public List<TeacherQueryScore> scoreInfo(int id, String cour_name) {
		String sql = "SELECT course.cour_name, student.stu_name,score.score_score FROM course "
					+ "INNER JOIN score ON score.cour_id = course.cour_id "
					+ "INNER JOIN student ON score.stu_id = student.stu_id "
					+ "INNER JOIN teacher ON course.teac_id = teacher.teac_id "
					+ "WHERE teacher.teac_id = ? and course.cour_name = ?";
		queryscoreList = new ArrayList<TeacherQueryScore>();
		TeacherQueryScore queryScore = null;
		conn = DBUtile.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, cour_name);
			rs = ps.executeQuery();
			while (rs.next()) {
				queryScore = new TeacherQueryScore();
				queryScore.setCour_name(rs.getString("cour_name"));
				queryScore.setStu_name(rs.getString("stu_name"));
				queryScore.setScore(rs.getInt("score_score"));
				queryscoreList.add(queryScore);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return queryscoreList;
	}
	
	@Override
	public List<Teacher> findAll() {
		List<Teacher> list = new ArrayList<Teacher>();
		conn = DBUtile.getConnection();
		String sql = "select * from teacher";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				teac = new Teacher();
				teac.setTeac_id(rs.getInt(1));
				teac.setRole_id(rs.getInt(2));
				teac.setTeac_name(rs.getString(3));
				teac.setTeac_pwd(rs.getString(4));
				list.add(teac);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean deleteById(int teac_id) {
		conn = DBUtile.getConnection();
		String sql = "delete from teacher where teac_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, teac_id);
			if(ps.executeUpdate()!=0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insert(Teacher teac) {
		conn = DBUtile.getConnection();
		String sql = "insert into teacher values( ? , 2 , ? , ? ) ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, teac.getTeac_id());
			ps.setString(2, teac.getTeac_name());
			ps.setString(3, teac.getTeac_pwd());
			if(ps.executeUpdate()!=0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
