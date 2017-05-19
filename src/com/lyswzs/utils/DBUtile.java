package com.lyswzs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtile {
	private static String driverName="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost/studentmis";
	private static String user="root";
	private static String password="root";
	
	static{
		try {
			Class.forName(driverName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ���ݿ������
	 * @param url�����ַ���
	 * @param user�û���
	 * @param password����
	 * @return Connection
	 */
	public static Connection getConnection(String url,String user,String password){
		Connection con=null;
		try{
			con=DriverManager.getConnection(url,user,password);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	/**
	 * ʹ��Ĭ�ϵ����û�ȡ���ݿ������
	 * @return Connection
	 */
	public static Connection getConnection(){
		Connection con=null;
		try{
			con=DriverManager.getConnection(url,user,password);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void close(ResultSet rs,Statement stmt,Connection con){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(PreparedStatement pre,Connection con){
		if(pre!=null){
			try {
				pre.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(DBUtile.getConnection());
	}
}
