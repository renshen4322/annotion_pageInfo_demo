package com.dn.dao;

import com.dn.handler.Encrypt;
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

	@Select("select * from t_user where id=#{id} ")
	User find(@Param("id") String id);

	@Select("select * from t_user where mobile=#{mobile} ")
	User findByMobile(@Param("mobile") Encrypt mobile);

	List<User> query(@Param("userName") String userName);


	int insertInfo(User record);

}
