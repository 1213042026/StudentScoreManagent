package com.lyswzs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lyswzs.bean.StuClass;
import com.lyswzs.bean.Student;
import com.lyswzs.dao.StuClassDao;
import com.lyswzs.utils.DBUtile;

public class StuClassDaoImpl  implements StuClassDao{

	private Connection conn;
	private PreparedStatement pst;
	private String sql;
	private StuClass scs;
	
	@Override
	public boolean insert(StuClass cs) {
		
		conn = DBUtile.getConnection();
		sql = "insert into class values( ? , ?  ) ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cs.getClass_id());
			pst.setString(2, cs.getClass_name());
			if(pst.executeUpdate()!=0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(StuClass cs) {
		conn = DBUtile.getConnection();
         sql=" update class set   class_name= ? where class_id= ?";
         try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, cs.getClass_name());
			pst.setInt(2, cs.getClass_id());
			if(pst.executeUpdate()!=0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<StuClass> findAll() {
		List<StuClass> list = new ArrayList<StuClass>();
		conn = DBUtile.getConnection();
		sql = "select * from class";
		try {
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				scs = new StuClass();
				scs.setClass_id(rs.getInt(1));
				scs.setClass_name(rs.getString(2));
				list.add(scs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Student> queryByIdstuclass(String stuclass_id) {
		List<Student> list = new ArrayList<Student>();
		conn = DBUtile.getConnection();
		sql = "select * from student where class_id= ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1,Integer.parseInt(stuclass_id));
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Student stu  = new Student();
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
}
