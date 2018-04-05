package com.ngconsulting.jwt.exception;

public class ProfileNotFoundExecption extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	public ProfileNotFoundExecption(String username){
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
