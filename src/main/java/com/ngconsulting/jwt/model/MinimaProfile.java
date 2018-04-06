package com.ngconsulting.jwt.model;

import java.net.URL;

public class MinimaProfile {

	private  String username;
	private  Name name;
	private  URL thumbnail;
	
	public MinimaProfile(Profile profile){
		name = profile.getName();
		username = profile.getLogin().getUsername();
		thumbnail = profile.getPicture().getThumbnail();
	}

	public MinimaProfile() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public URL getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(URL thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	        
}
