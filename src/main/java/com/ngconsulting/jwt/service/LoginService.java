package com.ngconsulting.jwt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngconsulting.jwt.model.LoginCredentials;
import com.ngconsulting.jwt.model.MinimaProfile;

@Service
public class LoginService {

	
	@Autowired
	ProfileService profileService;
	
	public Optional<MinimaProfile> login (LoginCredentials credentials){
		
		return profileService.get(credentials.getUsername()).filter(profile -> profile.getLogin().getPassword().equals(credentials.getPassword())).map(profile -> new MinimaProfile(profile));
	}
}
