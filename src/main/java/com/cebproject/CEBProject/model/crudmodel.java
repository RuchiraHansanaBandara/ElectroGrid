package com.cebproject.CEBProject.model;

public class crudmodel {
	
	private int id;
	private String branchName;
	private String location;
	private String branchCode;
	
	
	// add new
	
	public crudmodel() {
		
	}




	public crudmodel(int id, String branchName, String location, String branchCode) {
		super();
		this.id = id;
		this.branchName = branchName;
		this.location = location;
		this.branchCode = branchCode;
	}




	public String getBranchCode() {
		return branchCode;
	}




	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getBranchName() {
		return branchName;
	}




	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}
		
	
	
}
