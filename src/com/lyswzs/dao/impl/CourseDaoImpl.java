package com.lyswzs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lyswzs.bean.Course;
import com.lyswzs.dao.CourseDao;
import com.lyswzs.utils.DBUtile;

public class CourseDaoImpl implements CourseDao{

	private Connection conn;
	private PreparedStatement pst;
	private String sql;
	private Course cour;
	
	@Override
	public List<Course> findAll() {
		List<Course> list = new ArrayList<Course>();
		conn = DBUtile.getConnection();
		sql = "select * from course";                       
		try {
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				cour = new Course();
				cour.setCour_id(rs.getInt(1));
				cour.setTeac_id(rs.getInt(2));
				cour.setCour_name(rs.getString(3));
				list.add(cour);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean deleteById(int cour_id){
		conn = DBUtile.getConnection();
		sql = "delete from course where cour_id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cour_id);
			if(pst.executeUpdate()!=0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insert(Course cour) {
		conn = DBUtile.getConnection();
		sql = "insert into course values( ? , ? , ? ) ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cour.getCour_id());
			pst.setInt(2, cour.getTeac_id());
			pst.setString(3, cour.getCour_name());
			if(pst.executeUpdate()!=0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
