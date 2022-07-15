package com.dn.service;

import com.dn.dao.CategoryDao;
import com.dn.dao.OrderDao;
import com.dn.dao.PlatformPingTuanDayStatisticsMapper;
import com.dn.model.Category;
import com.dn.model.PlatformPingTuanDayStatistics;
import com.dn.page.ListQueryResult;
import com.dn.request.PingTuanDayStatQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ClassName:CategoryService
 * Package:com.dn.service
 * Description:
 *
 * @Date:2021/11/29 19:53
 * @Author: mark
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private PlatformPingTuanDayStatisticsMapper pingTuanDayStatisticsMapper;

    public List<Category> listWithTree() {
        // 1.查询出所有的分类
        List<Category> entities = categoryDao.selectList();

        // 2.组装成父子的树形结构

        List<Category> level1Menus = new ArrayList<>();
        // 找到所有的一级分类
        for (Category entity : entities) {
            if (entity.getParentCid() == 0) {
                level1Menus.add(entity);
            }
        }

        for (Category level1Menu : level1Menus) {
            level1Menu.setChildren(getChildrens(level1Menu, entities));
        }
        //排序
        level1Menus.sort(new Comparator<Category>() {
            @Override
            public int compare(Category o1, Category o2) {
                return (o1.getSort() == null ? 0 : o1.getSort()) - (o2.getSort() == null ? 0 : o2.getSort());
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
    private List<Category> getChildrens(Category root, List<Category> all) {
        List<Category> children = new ArrayList<>();
        for (Category a : all) {
            if (a.getParentCid().equals(root.getCatId())) {
                a.setChildren(getChildrens(a, all));
                children.add(a);
            }
        }
        children.sort(new Comparator<Category>() {
            @Override
            public int compare(Category o1, Category o2) {
                return (o1.getSort() == null ? 0 : o1.getSort()) - (o2.getSort() == null ? 0 : o2.getSort());
            }
        });
        return children;
    }

    public ListQueryResult<PlatformPingTuanDayStatistics> getPingTuanDayStatList(PingTuanDayStatQuery query) {
        ListQueryResult<PlatformPingTuanDayStatistics> dayListQueryResult = new ListQueryResult<>(0, null);
        Integer count = pingTuanDayStatisticsMapper.getDayPingTuanInfoCount(query);
        if (null == count || 0 >= count) {
            return dayListQueryResult;
        }
        dayListQueryResult.setTotal(count);
        List<PlatformPingTuanDayStatistics> docList = pingTuanDayStatisticsMapper.getPingTuanDayStatList(query);
        dayListQueryResult.setRows(docList);
        return dayListQueryResult;
    }
}
