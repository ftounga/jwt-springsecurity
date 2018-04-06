package com.ngconsulting.jwt.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ngconsulting.jwt.model.DetailedProfile;
import com.ngconsulting.jwt.model.MinimaProfile;
import com.ngconsulting.jwt.model.Profile;

@Component
public class ProfileService {
	
	List<Profile> profiles;

	private  Path PROFILES_FILE;
	
	public ProfileService() throws IOException, URISyntaxException{
		
		PROFILES_FILE =Paths.get(this.getClass().getResource("profiles.json").toURI());
		ObjectMapper objectMapper = new ObjectMapper();
		profiles = objectMapper.readValue(PROFILES_FILE.toFile(), new TypeReference<List<Profile>>() {
		});
		
	}
	
	protected Optional<Profile> get(String username) {
		return profiles.stream().filter(profile -> profile.getLogin().getUsername().equals(username)).findFirst();
	}
	
	public Optional<MinimaProfile> minimal(String username){
		return get(username).map(profile -> new MinimaProfile(profile));
	}
	
	public Optional<DetailedProfile> detailed(String username){
		return get(username).map(profile -> new DetailedProfile(profile));
	}
	
}
