package com.dn.dao;

import com.dn.model.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName:CategoryDao
 * Package:com.dn.dao
 * Description:
 *
 * @Date:2021/11/29 19:55
 * @Author: mark
 */
@Mapper
public interface CategoryDao {
    List<Category> selectList();

    int deleteByPrimaryKey(Long catId);

    int insert(generate.Category record);

    int insertSelective(generate.Category record);

    generate.Category selectByPrimaryKey(Long catId);

    int updateByPrimaryKeySelective(generate.Category record);

    int updateByPrimaryKey(generate.Category record);
}
