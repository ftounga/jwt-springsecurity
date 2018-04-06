package com.ngconsulting.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ngconsulting.jwt.exception.ProfileNotFoundExecption;
import com.ngconsulting.jwt.model.DetailedProfile;
import com.ngconsulting.jwt.model.MinimaProfile;
import com.ngconsulting.jwt.service.ProfileService;

@RestController
public class ProfileController {

	@Autowired
	private ProfileService ProfileService;

	@RequestMapping(value = "/profile/{username}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<MinimaProfile> minimal(@PathVariable String username) {	 
		MinimaProfile profile = ProfileService.minimal(username).orElseThrow(()-> new ProfileNotFoundExecption(username));		
		return new ResponseEntity<MinimaProfile>(profile, HttpStatus.OK);
	 }
	
	@RequestMapping(value = "/details/{username}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<DetailedProfile> details(@PathVariable String username) {	
		
		DetailedProfile profile = ProfileService.detailed(username).orElseThrow(()-> new ProfileNotFoundExecption(username));		
		return new ResponseEntity<DetailedProfile>(profile, HttpStatus.OK);
	 }
}
