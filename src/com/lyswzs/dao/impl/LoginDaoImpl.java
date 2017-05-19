package com.lyswzs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lyswzs.bean.Admins;
import com.lyswzs.bean.Student;
import com.lyswzs.bean.Teacher;
import com.lyswzs.dao.LoginDao;
import com.lyswzs.utils.DBUtile;

public class LoginDaoImpl implements LoginDao{

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public Admins isAdminsLoginSuccess(int id, String password) {
		String sql = "select * from admins where admins_id=? and admins_pwd=?";
		conn = DBUtile.getConnection();
		Admins admins=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()){
				admins=new Admins();
				admins.setAdmins_id(rs.getInt("admins_id"));
				admins.setAdmins_pwd(rs.getString("admins_pwd"));
				admins.setRole_id(rs.getInt("role_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admins;
	}


	@Override
	public Student isStudentLoginSuccess(int id, String password) {
		String sql = "select * from student where stu_id = ? and stu_pwd = ?";
		conn = DBUtile.getConnection();
		Student student = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()){
				student = new Student();
				student.setClass_id(rs.getInt("class_id"));
				student.setStu_name(rs.getString("stu_name"));
				student.setRole_id(rs.getInt("role_id"));
				student.setStu_address(rs.getString("stu_address"));
				student.setStu_id(rs.getInt("stu_id"));
				student.setStu_pwd(rs.getString("stu_pwd"));
				student.setStu_sex(rs.getString("stu_sex"));
				student.setStu_tel(rs.getString("stu_tel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}


	@Override
	public Teacher isTeacherLoginSuccess(int id, String password) {
		String sql = "select * from teacher where teac_id=? and teac_pwd=?";
		conn = DBUtile.getConnection();
		Teacher teacher = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()){
				teacher = new Teacher();
				teacher.setRole_id(rs.getInt("role_id"));
				teacher.setTeac_id(rs.getInt("teac_id"));
				teacher.setTeac_name(rs.getString("teac_name"));
				teacher.setTeac_pwd(rs.getString("teac_pwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}
	
}
