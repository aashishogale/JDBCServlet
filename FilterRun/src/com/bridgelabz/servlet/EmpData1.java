package com.bridgelabz.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpData1 {

	public Connection con;
	public Statement stmt;
	public PreparedStatement pstmt;

	public String name;
	public String posi;
	public String quali;

	EmpData1() {

	}

	EmpData1(String name, String posi, String quali) {
		this.name = name;
		this.posi = posi;
		this.quali = quali;

	}

	public void getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpDataBase", "root", "root");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public int insertStatement() {
		int i = 0;
		try {
			getConnection();
			pstmt = con.prepareStatement("insert into register(name,position,qualifi) values(?,?,?)");

			pstmt.setString(1, name);
			pstmt.setString(2, posi);
			pstmt.setString(3, quali);

			i = pstmt.executeUpdate();
			System.out.println(i);
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public int insertLogin(String name, String passw) {
		int i = 0;
		try {
			getConnection();
			pstmt = con.prepareStatement("insert into login(name,password) values(?,?)");

			pstmt.setString(1, name);
			pstmt.setString(2, passw);

			i = pstmt.executeUpdate();
			System.out.println(i);
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public int selectid(String name) {
		getConnection();
		int id = 0;
		try {
			pstmt = con.prepareStatement("select id from register where name='" + name + "'");

			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				id = rset.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	public boolean selectid(String name1, String passw) {
	
		boolean isResult = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpDataBase", "root", "root");
			System.out.println(con);
			pstmt = con.prepareStatement("select name,password from login where name='" + name1 + "'");

			isResult = pstmt.execute();
			System.out.println(isResult);
			return isResult;
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isResult;
	}

	public ResultSet getinfo(String name) {
		getConnection();
		ResultSet rset = null;
		try {
			pstmt = con.prepareStatement("select * from register where name='" + name + "'");

			rset = pstmt.executeQuery();
			return rset;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rset;
	}

}
