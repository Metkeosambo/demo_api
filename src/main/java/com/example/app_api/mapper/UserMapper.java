package com.example.app_api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Mapper;

import com.example.app_api.dto.User;
@Mapper
public interface UserMapper {

	@Insert("insert into users (user_name,gender,dob,created_by,create_date) values (#{userName},#{gender},#{dob},#{createBy},CURRENT_TIMESTAMP())")
	//@Options(useGeneratedKeys=true, keyProperty="userId")
	@SelectKey(statement="select max(user_id) from users", keyProperty="userId", before=false, resultType=long.class)
	public Long createUser(User user);
	
	@Select("SELECT * FROM users  WHERE user_id = #{userId}")
	@Results({
		@Result(property = "userId", column = "user_id"),
	    @Result(property = "userName", column = "user_name"),
	    @Result(property = "createBy", column = "created_by"),
	    @Result(property = "createDate", column = "create_date")})
	public User getUser(@Param("userId") Long userId);
	
	@Select("select * from users")
	@Results({
		@Result(property = "userId", column = "user_id"),
	    @Result(property = "userName", column = "user_name"),
	    @Result(property = "createBy", column = "created_by"),
	    @Result(property = "createDate", column = "create_date")})
	public List<User> getAllUser();
}
