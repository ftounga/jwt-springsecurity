package com.ngconsulting.jwt.model;

import java.net.URL;

public class Name {

	private String title;
	private String first;
	private String last;
	
	public Name(){
		
	}
	
	public Name(String name){
		this.first = name;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	
	
}
