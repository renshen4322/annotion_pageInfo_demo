package com.dn.page;

import com.dn.util.ExtBeansUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * @ProjectName:
 * @Description: 分页工具
 * @Author: mark
 * @CreateDate: 2022/3/30 18:04
 * @Version: 1.0
 */
@Component
public class PageUtils implements BeanFactoryPostProcessor {

    /** Spring应用上下文环境 */
    private static ConfigurableListableBeanFactory beanFactory;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException
    {
        PageUtils.beanFactory = beanFactory;
    }

    /**
     * 分页方法
     *
     * @param page     请求参数
     * @param supplier 查询函数式
     * @param <T>      查询对象model
     * @return
     */
    public static  <T> PageInf<T> executePage(PageRequest page, Supplier<List<T>> supplier) {
        return getListPageInfo(page, supplier);
    }

    /**
     * 分页方法
     *
     * @param page        请求参数
     * @param targetClass 目标对象
     * @param supplier    查询函数式
     * @param <T>         查询对象model
     * @param <V>         目标对象model
     * @return
     */
    public static  <T, V> PageInf<V> executePage(PageRequest page, Class<V> targetClass, Supplier<List<T>> supplier) {
        PageInf<T> listPageInfo = getListPageInfo(page, supplier);
        List<V> targetList = ExtBeansUtils.map(listPageInfo.getList(), targetClass);
        PageInf<V> pageInf = ExtBeansUtils.map(listPageInfo, PageInf.class);
        pageInf.setList(targetList);
        return pageInf;
    }

    public static  <T> PageInf<T> getListPageInfo(PageRequest page, Supplier<List<T>> supplier) {
        Integer pageNo = page.getCurrent();
        Integer pageSize = page.getSize();
        pageNo = Objects.isNull(pageNo) || pageNo < 1 ? 1 : pageNo;
        pageSize = Objects.isNull(pageSize) || pageNo < 1 ? 20 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<T> ts = supplier.get();
        PageInfo pageInfo = new PageInfo(ts);
        PageInf<T> pageInf = new PageInf();
        pageInf.setList(pageInfo.getList());
        pageInf.setTotal(pageInfo.getTotal());
        pageInf.setSize(pageInfo.getSize());
        pageInf.setCurrent(pageInfo.getPageNum());
        pageInf.setPages(pageInfo.getPages());
        PageHelper.clearPage();
        return pageInf;
    }


}
