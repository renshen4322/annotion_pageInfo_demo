package com.dn.service;

import com.dn.dao.DtscategoryDao;
import com.dn.model.DtsCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ClassName:DtsCategoryService
 * Package:com.dn.service
 * Description:
 *
 * @Date:2021/11/30 0:42
 * @Author: mark
 */
@Service
public class DtsCategoryService {

    @Autowired
    private DtscategoryDao categoryDao;

    public List<DtsCategory> listWithTree() {
        // 1.查询出所有的分类
        List<DtsCategory> entities = categoryDao.selectList();

        // 2.组装成父子的树形结构

        List<DtsCategory> level1Menus = new ArrayList<>();
        // 找到所有的一级分类
        for (DtsCategory entity : entities) {
            if (entity.getPid() == 0) {
                level1Menus.add(entity);
            }
        }

        for (DtsCategory level1Menu : level1Menus) {
            level1Menu.setChildren(getChildrens(level1Menu, entities));
        }
        //排序
        level1Menus.sort(new Comparator<DtsCategory>() {
            @Override
            public int compare(DtsCategory o1, DtsCategory o2) {
                return (o1.getSortOrder() == null ? 0 : o1.getSortOrder()) - (o2.getSortOrder() == null ? 0 : o2.getSortOrder());
            }
        });
        return level1Menus;
    }

    /**
     * 递归查找所有的下级分类
     * 在这一级别的分类中找下级分类
     *
     * @param root 当前级别的分类
     * @param all  全部分类
     * @return 下一级分类
     */
    private List<DtsCategory> getChildrens(DtsCategory root, List<DtsCategory> all) {
        List<DtsCategory> children = new ArrayList<>();
        for (DtsCategory a : all) {
            if (a.getPid().equals(root.getId())) {
                a.setChildren(getChildrens(a, all));
                children.add(a);
            }
        }
        children.sort(new Comparator<DtsCategory>() {
            @Override
            public int compare(DtsCategory o1, DtsCategory o2) {
                return (o1.getSortOrder() == null ? 0 : o1.getSortOrder()) - (o2.getSortOrder() == null ? 0 : o2.getSortOrder());
            }
        });
        return children;
    }
}
