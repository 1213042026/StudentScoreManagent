package com.lyswzs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lyswzs.dao.RoleDao;
import com.lyswzs.utils.DBUtile;

/***
 * 对权限的操作
 * @author syw
 *
 */
public class RoleDaoImpl implements RoleDao {

	private Connection conn;

	private PreparedStatement pst;

	private String sql;
	
	private int role_name;

	/**
	 * 获取权限
	 */
	@Override
	public int getName(int role_id){
		conn = DBUtile.getConnection();
		sql="select role_name from role where role_id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, role_id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				role_name=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role_name;	
	}
//	public static void main(String[] args) {
//		RoleDaoImpl daoi=new RoleDaoImpl();
//		daoi.getName(2);
//	}
}
