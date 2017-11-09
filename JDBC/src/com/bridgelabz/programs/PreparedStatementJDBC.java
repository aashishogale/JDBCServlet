package com.bridgelabz.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementJDBC {

	public static void main(String[] args) {
		 Scanner scanner=new Scanner(System.in);
			try{  
			Class.forName("com.mysql.jdbc.Driver");  
			  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","root");  
		
			PreparedStatement pstmt=con.prepareStatement("insert into information values(?,?,?,?)");  
			pstmt.setInt(1,8);//1 specifies the first parameter in the query  
			pstmt.setString(2,"amaya");  
			  
			 
			  
			System.out.println("enter number");
			String number=scanner.nextLine();
			System.out.println("enter profession");
			String profession=scanner.nextLine();
			pstmt.setString(3,number);
			pstmt.setString(4, profession);
			int i=pstmt.executeUpdate(); 
			System.out.println(i+" records inserted");
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}  
			  
			} 

	}


