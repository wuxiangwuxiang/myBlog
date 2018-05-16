package com.zzn.demo.service;

import java.sql.Date;

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

	public int insert(String userPWD, String userName) {
		userMapper.getUserID();
		return userMapper.insertUser(userPWD, userName);
	}

	public Integer searchUser(Integer userid) {
		return userMapper.getUser3(userid);
	}

	/* 根据用户id,获取用户个人信息 */
	public User getUserInfo(Integer userid) {
		return userMapper.getUserInformation(userid);
	}

	/* 更新用户个人资料 */
	public void updateUserInfo(Integer userid, String userName, String userMobile, String userGender,
			String userAddress, String userEmail, Date userBirthday) {
		userMapper.updateUserInformation(userName, userMobile, userGender, userAddress, userEmail, userBirthday,
				userid);
	}
	
	/* 获取新注册的用户ID */
	public int getUserid() {
		return userMapper.getUserID();
	}
}
