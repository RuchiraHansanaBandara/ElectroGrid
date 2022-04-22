package com.cebproject.CEBProject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cebproject.CEBProject.model.crudmodel;

public class crudservice {

	Connection con;
	

	
	public crudservice() {
		try {
			
			String url = String.format("jdbc:mysql://localhost:3306/cebproject");
			String uname = "root";
			String pwd = "";
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch(Exception e) {
			System.out.println(e + "data insert unsuccess.");
		}
		
	}
	
	public crudmodel insertBranch(crudmodel branch) {
		String insert = "insert into branch(branchName,location) values(?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, branch.getBranchName());
			ps.setString(2, branch.getLocation());
			
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +" data insert unsuccess");
		}
		
		return branch;
	}
}
