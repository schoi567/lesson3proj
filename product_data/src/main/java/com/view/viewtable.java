package com.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import product_control.products;

public class viewtable {
	private static Connection getConnection() {
		Connection con=null;
		//Step 1 : load Driver in memory
		try {
			//to call Class loader to load class in memory at dymanic time
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		
			//Step 2: Database information 
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/products", "root","12345678");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	
	public ArrayList<products> getRecords(){
		ArrayList<products> list=new ArrayList<>();
		try {
			Connection con=getConnection();
			//To get all Records
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from Product");
			//Add all Records in ArrayList		
							
			while(rs.next()) {
				
				list.add(new products(rs.getInt(1),rs.getString(2),rs.getString(3)));

				
			}
			stmt.close();
			con.close();
		}
			catch(Exception e) {
			e.printStackTrace();
		}
		return list;}}

	
	
	
	
	

