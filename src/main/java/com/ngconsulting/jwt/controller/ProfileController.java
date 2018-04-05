package com.ngconsulting.jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {


	 @RequestMapping(value = "/profile", method = RequestMethod.GET)
	 public String getProfile() {

	  return "OK";

	 }
}
