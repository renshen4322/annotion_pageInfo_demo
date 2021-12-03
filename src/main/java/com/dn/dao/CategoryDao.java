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
}
