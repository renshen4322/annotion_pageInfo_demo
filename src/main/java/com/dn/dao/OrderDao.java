package com.dn.dao;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dn.model.Order;


@Mapper
@CacheNamespace
public interface OrderDao {

	List<Order> query(@Param("customerId") String customerId);

	int deleteByPrimaryKey(String id);

	int insert(Order record);

	int insertSelective(Order record);

	Order selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Order record);

	int updateByPrimaryKey(Order record);
}
