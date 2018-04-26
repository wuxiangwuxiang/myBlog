package com.zzn.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import com.zzn.demo.pojo.User;

@Mapper
public interface UserMapper {

	@Select("select UserID ,UserPWD,UserName from User where UserID=#{userID}")
	public User getUser(@Param("userID") Integer UserID);
	
	@Insert("insert into User (UserPWD,UserName) values (#{UserPWD},#{UserName})")
	public int insertUser(@Param("UserPWD") String UserPWD,@Param("UserName") String UserName);

	@Select("select UserID from User where UserID=#{userID}")
	public Integer getUser2(@Param("userID") Integer UserID);
}
