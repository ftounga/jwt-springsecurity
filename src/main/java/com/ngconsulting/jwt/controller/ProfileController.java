package com.ngconsulting.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ngconsulting.jwt.exception.ProfileNotFoundExecption;
import com.ngconsulting.jwt.model.MinimaProfile;
import com.ngconsulting.jwt.service.ProfileService;

@RestController
@RequestMapping(value = "/profile")
public class ProfileController {

	@Autowired
	private ProfileService ProfileService;

	@RequestMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	
	public MinimaProfile minimal(@PathVariable String username) {
	 
		return ProfileService.minimal(username).orElseThrow(()-> new ProfileNotFoundExecption(username));
	 }
}
