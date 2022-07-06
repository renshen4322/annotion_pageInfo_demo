package com.dn.dao;

import com.dn.model.Category;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@CacheNamespace
public interface CategoryDao {
    int deleteByPrimaryKey(Long catId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long catId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> selectListByCid(Integer cid);

    List<Category> selectList();
}