package com.zzn.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import com.zzn.demo.pojo.User;

@Mapper
public interface UserMapper {

	//获取登录用的账号密码
	@Select("select UserID ,UserPWD,UserName from User where UserID=#{userID}")
	public User getUser(@Param("userID") Integer UserID);
	
	//注册添加账号
	@Insert("insert into User (UserPWD,UserName) values (#{UserPWD},#{UserName})")
	public int insertUser(@Param("UserPWD") String UserPWD,@Param("UserName") String UserName);

	//前端获取UerID,方法不对,后期解决
	@Select("select UserID from User where UserID=#{userID}")
	public Integer getUser2(@Param("userID") Integer UserID);
	
	//获取所有的个人信息
	/*@Select("select UserID,UserName,")*/
	
	
}
