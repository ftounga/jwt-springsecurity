package com.ngconsulting.jwt.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ngconsulting.jwt.exception.FailedToLoginExeception;
import com.ngconsulting.jwt.model.LoginCredentials;
import com.ngconsulting.jwt.model.MinimaProfile;
import com.ngconsulting.jwt.service.JwtService;
import com.ngconsulting.jwt.service.LoginService;

@RestController
public class LoginController {

	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private JwtService jwtService;
	
	
	@RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)	
	public MinimaProfile login (@RequestBody LoginCredentials credentials, HttpServletResponse response){
		
		return loginService.login(credentials).map(minimaProfile -> {
			try {
				response.setHeader("TOKEN", jwtService.tokenFor(minimaProfile));
			}catch (Exception e) {
				throw new RuntimeException(e);
			}
			return minimaProfile;
		}).orElseThrow(() -> new FailedToLoginExeception(credentials.getUsername()));
	}
}
