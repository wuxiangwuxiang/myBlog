package com.zzn.demo.mapper;

import java.sql.Date;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zzn.demo.pojo.User;

@Mapper
public interface UserMapper {

	// 获取登录用的账号密码
	@Select("select UserID ,UserPWD,UserName from User where UserID=#{userID}")
	public User getUser(@Param("userID") Integer UserID);

	// 注册添加账号
	@Insert("insert into User (UserPWD,UserName) values (#{UserPWD},#{UserName})")
	public int insertUser(@Param("UserPWD") String UserPWD, @Param("UserName") String UserName);

	// 前端获取UerID,方法不对,后期解决
	@Select("select UserID from User where UserID=#{userID}")
	public Integer getUser3(@Param("userID") Integer UserID);

	// 获取用户个人信息
	@Select("select UserID,UserName,userMobile,userGender,userAddress,userEmail,userBirthday from User Where UserID=#{userID}")
	public User getUserInformation(@Param("userID") Integer UserID);

	/* 更新用户个人资料 */
	@Update("UPDATE User SET UserName =#{userName}, userMobile =#{userMobile},userGender =#{userGender}, userAddress =#{userAddress}, userEmail =#{userEmail}, userBirthday =#{userBirthday} WHERE UserID = #{userID}")
	public void updateUserInformation(@Param("userName") String UserName, @Param("userMobile") String userMobile,
			@Param("userGender") String userGender, @Param("userAddress") String userAddress,
			@Param("userEmail") String userEmail, @Param("userBirthday") Date userBirthday,
			@Param("userID") Integer UserID);

	/* 获取新注册的用户ID */
	@Select("select last_insert_id()")
	public Integer getUserID();
}
