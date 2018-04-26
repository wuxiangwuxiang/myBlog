package com.zzn.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zzn.demo.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;

	// 登录
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "userid", required = false) Integer userid,
			@RequestParam(value = "userpwd", required = false) String userpwd, HttpSession session) {
		if (userpwd.equals(userService.login(userid).getUserPWD())) {
			session.setAttribute("userid", userid);
			session.setAttribute("userpwd", userpwd);
			return "yes";
		} else {
			return "error";
		}
	}
}
