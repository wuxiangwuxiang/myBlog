package com.zzn.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zzn.demo.pojo.User;
import com.zzn.demo.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/searchUser", method = RequestMethod.GET)
	public Integer searchUser(@RequestParam(value = "userid", required = false) Integer userid ,HttpSession session){
			Integer id = (Integer)session.getAttribute("userid");
			//System.out.println(userService.searchUser(id));
			return id;
	}

	/* 根据用户id,获取用户个人信息 */
	@RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
	public User getUserInfo(@RequestParam(value="userid",required = false) Integer userid,HttpSession session) {
		Integer uid = (Integer)session.getAttribute("userid");
		//userService.getUserInfo(uid);
		//System.out.println(uid);
		//System.out.println(userService.getUserInfo(uid));
		return userService.getUserInfo(uid);
	}
	
	/* 更新用户个人资料 */
	@RequestMapping(value="/updateUserInfo" ,method = RequestMethod.GET)
	public void updateUserInfo(@RequestParam(value="userid",required = false) Integer userid,HttpSession session) {
		Integer uid = (Integer)session.getAttribute("userid");
		userService.updateUserInfo(uid);
	}
}
