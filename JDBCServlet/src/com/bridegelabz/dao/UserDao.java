package com.bridegelabz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridelabz.model.User;

public class UserDao {

	public Connection con;
	public Statement stmt;
	public PreparedStatement pstmt;

	public String name;
	public String posi;
	public String quali;
	public User user = new User();

	public UserDao(User user) {
		this.user = user;

	}

	public UserDao() {

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

			pstmt = con
					.prepareStatement("insert into register1(name,email,password,mobile,location) values(?,?,?,?,?)");
			System.out.println(user.getName() + user.getEmail());
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getMobile());
			pstmt.setString(5, user.getLocation());

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
			pstmt = con.prepareStatement("select id from register1 where email='" + name + "'");

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
	
	public String selectpassword(String email) {
		getConnection();
		String id = "";
		try {
			pstmt = con.prepareStatement("select password from register1 where email='" + email + "'");

			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				id = rset.getString(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	public boolean selectid(String email, String passw) {

		boolean isResult = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpDataBase", "root", "root");
			System.out.println(con);
			pstmt = con
					.prepareStatement("select id from register1 where email='" + email + "'&&password='" + passw + "'");
			System.out.println(email);
			isResult = pstmt.execute();
			System.out.println(isResult);
			return isResult;
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isResult;
	}

	public boolean returnmail(String email, String passw) {
		getConnection();
		try {
			pstmt = con.prepareStatement(
					"select email from register1 where email='" + email + "' AND password='" + passw + "'");

			ResultSet rSet = pstmt.executeQuery();
			while (rSet.next()) {
				System.out.println(rSet.getString(1));
				if (rSet.getString(1).equals(email)) {
					System.out.println(rSet.getString(1));
					return true;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

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
