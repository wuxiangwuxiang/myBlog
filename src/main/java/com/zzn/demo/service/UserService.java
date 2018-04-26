package com.zzn.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zzn.demo.mapper.UserMapper;
import com.zzn.demo.pojo.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User login(Integer userID) {
		return userMapper.getUser(userID);
	}
	
	public int insert(String userPWD,String userName) {
		return userMapper.insertUser(userPWD, userName);
	}
	
	public Integer searchUser(Integer userid) {
		return userMapper.getUser2(userid);
	}

}
