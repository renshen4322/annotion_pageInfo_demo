package com.dn.dao;

import com.dn.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
@CacheNamespace
public interface UserDao {

	int deleteByPrimaryKey(Long id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	@Select("select id,username from t_user where id=#{id} ")
	User find(@Param("id") String id);

	List<User> query(@Param("userName") String userName);


	int insertInfo(User record);

}
