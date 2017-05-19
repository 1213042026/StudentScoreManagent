package com.lyswzs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lyswzs.bean.Student;
import com.lyswzs.bean.StudentScore;
import com.lyswzs.dao.StudentDao;
import com.lyswzs.utils.DBUtile;

public class StudentDaoImpl implements StudentDao{
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Student stu;
	@Override
	public List<StudentScore> findScore(int id) {
		String sql="select cour_name,teac_name,score_score from score s INNER JOIN course c on s.score_id=c.cour_id INNER JOIN teacher t on c.teac_id=t.teac_id where stu_id=?";
		List<StudentScore> list=new ArrayList<StudentScore>();
		conn=DBUtile.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			StudentScore stu=null;
			while(rs.next()){
				stu=new StudentScore();
				stu.setCour_name(rs.getString("cour_name"));
				stu.setScore_score(rs.getString("score_score"));
				stu.setTeac_name(rs.getString("teac_name"));
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean update(int stu_id, String stu_pwd, String stu_tel, String stu_address) {
		// TODO Auto-generated method stub
		String sql="update student set stu_pwd=? , stu_tel=? , stu_address=? where stu_id=?";
		conn=DBUtile.getConnection();
		try {
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, stu_pwd);
			ps.setString(2, stu_tel);
			ps.setString(3, stu_address);
			ps.setInt(4, stu_id);
			int n=ps.executeUpdate();
			if(n>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Student findStu(int stu_id) {
		String sql="select * from student where stu_id=?";
		conn=DBUtile.getConnection();
		Student student=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, stu_id);
			rs=ps.executeQuery();
			while(rs.next()){
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<Student> findAll() {
		List<Student> list = new ArrayList<Student>();
		conn = DBUtile.getConnection();
		String sql = "select * from student";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				stu = new Student();
				stu.setStu_id(rs.getInt(1));
				stu.setRole_id(rs.getInt(2));
				stu.setClass_id(rs.getInt(3));
				stu.setStu_name(rs.getString(4));
				stu.setStu_pwd(rs.getString(5));
				stu.setStu_sex(rs.getString(6));
				stu.setStu_tel(rs.getString(7));
				stu.setStu_address(rs.getString(8));
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean deleteById(int stu_id) {
		conn = DBUtile.getConnection();
		String sql = "delete from student where stu_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, stu_id);
			if(ps.executeUpdate()!=0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insert(Student stu) {
		conn = DBUtile.getConnection();
		String sql = "insert into student values( ? , ? , ? , ? , ? , ? , ? , ? ) ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, stu.getStu_id());
			ps.setInt(2, 3);
			ps.setInt(3, stu.getClass_id());
			ps.setString(4, stu.getStu_name());
			ps.setString(5, stu.getStu_pwd());
			ps.setString(6, stu.getStu_sex());
			ps.setString(7, stu.getStu_tel());
			ps.setString(8, stu.getStu_address());
			if(ps.executeUpdate()!=0){
				return true;
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
}