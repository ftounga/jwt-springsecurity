package com.ngconsulting.jwt.model;

import java.net.URL;

public class MinimaProfile {

	private final String username;
	private final Name name;
	private final URL thumbnail;
	
	public MinimaProfile(Profile profile){
		name = profile.getName();
		username = profile.getLogin().getUsername();
		thumbnail = profile.getPicture().getThumbnail();
	}
	        
}
