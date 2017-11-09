package com.bridgelabz.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.DatabaseMetaData;

import java.sql.ResultSetMetaData;

public class StatementJDBC {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");

			Statement stmt = con.createStatement();
			System.out.println("enter the name");
			String name = scanner.nextLine();
			ResultSet rs = stmt.executeQuery("select * from information where name='" + name + "'");

			ResultSetMetaData rmdata = rs.getMetaData();
			while (rs.next())
				for (int i = 1; i <= rmdata.getColumnCount(); i++) {
					System.out.println(rmdata.getColumnLabel(i) + "  " + rs.getString(i));
				}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
