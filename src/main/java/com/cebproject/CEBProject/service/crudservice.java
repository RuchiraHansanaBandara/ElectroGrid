package com.cebproject.CEBProject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
		String insert = "insert into branch(branchName,location,branchCode) values(?,?,?) ";
		System.out.println(branch.getbranchCode());
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, branch.getBranchName());
			ps.setString(2, branch.getLocation());
			ps.setString(3, branch.getbranchCode());
			
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +" data insert unsuccess");
		}
		
		return branch;
	}
	
	public ArrayList<crudmodel> getbranch() throws SQLException{
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		
		String select = "select * from branch";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			crudmodel model = new crudmodel();
			model.setId(rs.getInt("id"));
			model.setBranchName(rs.getString("branchName"));
			model.setLocation(rs.getString("location"));
			model.setbranchCode(rs.getString("branchCode"));
			
			data.add(model);
		}
		
		return data;
	}
	
	public ArrayList<crudmodel> getbranchById(int id) throws SQLException{
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		
		String select = "select * from branch where id =?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			crudmodel model = new crudmodel();
			model.setId(rs.getInt("id"));
			model.setBranchName(rs.getString("branchName"));
			model.setLocation(rs.getString("location"));
			model.setbranchCode(rs.getString("branchCode"));
			
			
			data.add(model);
		}
		
		return data;
	}
	
	public crudmodel updateBranch(crudmodel branch) {
		String insert = "update branch set branchName= ? , location= ? , branchCode= ?  where id =? ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, branch.getBranchName());
			ps.setString(2, branch.getLocation());
			ps.setString(3, branch.getbranchCode());
			ps.setInt(4, branch.getId());
			
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +" data insert unsuccess");
		}
		
		return branch;
	}
	
	public int deleteBranch(int id) {
		String insert = "delete from branch where id =? ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, id);
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +" data insert unsuccess");
		}
		
		return id;
	}
}
