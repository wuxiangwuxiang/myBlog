package com.zzn.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zzn.demo.service.UserService;

@RestController
public class RegisterController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public int insert(@RequestParam(value = "userpwd", required = false) String userpwd,
			@RequestParam(value = "username", required = false) String username) {
		userService.insert(userpwd, username);
		//System.out.println(userService.getUserid());
		return userService.getUserid();
	}

}
