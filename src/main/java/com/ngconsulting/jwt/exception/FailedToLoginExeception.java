package com.ngconsulting.jwt.exception;

public class FailedToLoginExeception extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	public FailedToLoginExeception(String username){
		super();
		this.username = username;		
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
