package com.dn.dao;

import com.dn.model.DtsCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 类目表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-11-30 00:32:42
 */
@Mapper
public interface DtscategoryDao {
    List<DtsCategory> selectList();
}
