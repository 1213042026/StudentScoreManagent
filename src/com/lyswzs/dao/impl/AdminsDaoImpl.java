package com.lyswzs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lyswzs.dao.AdminsDao;
import com.lyswzs.utils.DBUtile;

public class AdminsDaoImpl implements AdminsDao{

	private Connection conn;
	private PreparedStatement pst;
	private String sql;
	@Override
	public String login(int admins_id, String admins_pwd) {
		sql="select * from admins where admins_id=? and admins_id=?";
		conn=DBUtile.getConnection();
		String result="error";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,admins_id);
			pst.setString(2, admins_pwd);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				result="ok";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
