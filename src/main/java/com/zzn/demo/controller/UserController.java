package com.zzn.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzn.demo.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/searchUser", method = RequestMethod.GET)
	@ResponseBody
	public Integer searchUser(@RequestParam(value = "userid", required = false) Integer userid ,HttpSession session){
			Integer id = (Integer)session.getAttribute("userid");
			//System.out.println(userService.searchUser(id));
			return id;
	}

}
