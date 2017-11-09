package com.bridgelabz.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Util {

	public static Connection con;
	public static Statement stmt;
	public static PreparedStatement pstmt;
	public static Scanner scanner = new Scanner(System.in);

	public static void getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpDataBase", "root", "root");
			stmt = con.createStatement();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void selectStatement() {
getConnection();
		System.out.println("enter the name");
		String name = scanner.nextLine();
		ResultSet rs;
		try {
			rs = stmt.executeQuery("select * from Employee where name='" + name + "'");
			ResultSetMetaData rmdata = rs.getMetaData();
			while (rs.next())
				for (int i = 1; i <= rmdata.getColumnCount() - 1; i++) {
					System.out.println(rmdata.getColumnLabel(i) + "  " + rs.getString(i));
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void insertImage() {
		getConnection();
		File file = new File("/home/bridgeit/Downloads/image1.jpg");
		System.out.println("enter the name");
		String name = scanner.nextLine();
		try {
			FileInputStream fInputStream = new FileInputStream(file);
			pstmt = con.prepareStatement("Update Employee set image=? where name='" + name + "'");
			pstmt.setBinaryStream(1, (InputStream) fInputStream, (int) file.length());
			pstmt.executeUpdate();
			con.close();
		} catch (FileNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void retrieveImage() {
		getConnection();
		System.out.println("enter the name");
		String name = scanner.nextLine();
		Blob blob;
		byte[] imageBytes = null;
		try {
			ResultSet resultSet = stmt.executeQuery("Select image from Employee where name='" + name + "'");

			while (resultSet.next()) {

				blob = resultSet.getBlob(1);

				imageBytes = blob.getBytes(1, (int) blob.length());
			}

			FileOutputStream fstream = new FileOutputStream(new File("/home/bridgeit/picture.jpg"));
			fstream.write(imageBytes);
			fstream.close();

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void insertStatement() {
		try {
			getConnection();
			pstmt=con.prepareStatement("insert into Employee values(?,?,?,?,?)");
			
			System.out.println("enter id");
			int id=scanner.nextInt();
			scanner.nextLine();
			System.out.println("enter name");
			String name=scanner.nextLine();
			System.out.println("enter position");
			String position=scanner.nextLine();
			System.out.println("enter salary");
			int salary=scanner.nextInt();
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3,position);
			pstmt.setInt(4, salary);
			pstmt.setString(5, null);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	public static void updateName() {
		getConnection();
		File file = new File("/home/bridgeit/Downloads/image1.jpg");
		System.out.println("enter the id");
		int id = scanner.nextInt();
		System.out.println("enter new name");
		String name=scanner.nextLine();
		try {
			FileInputStream fInputStream = new FileInputStream(file);
			pstmt = con.prepareStatement("Update Employee set name=? where id='" + id + "'");
			pstmt.setString(1,name);
			pstmt.executeUpdate();
			con.close();
		} catch (FileNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public static void deleteName() {
			getConnection();
			File file = new File("/home/bridgeit/Downloads/image1.jpg");
			System.out.println("enter the id");
			int id = scanner.nextInt();
			
			try {
				
				pstmt = con.prepareStatement("Delete from Employee where id='" + id + "'");
			
				pstmt.executeUpdate();
				con.close();
			} catch ( SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
