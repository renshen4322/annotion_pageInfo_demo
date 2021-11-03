package com.dn.util;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ProjectName: xinan-cloud
 * @Description: bean的工具类
 * @Author: liuhao
 * @CreateDate: 2021/8/20 17:55
 * @Version: 1.0
 */
public class ExtBeansUtils {


    /**
     * deal bean copy
     *
     * @param source
     * @param targetClass
     * @param <T>
     * @return
     */
    public static <T> T map(Object source, Class<T> targetClass) {
        if (Objects.isNull(source)) {
            return null;
        }
        T target = BeanUtils.instantiateClass(targetClass);
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
     * deal arrayList copy
     *
     * @param source
     * @param targetClass
     * @param <T>
     * @param <V>
     * @return
     */
    public static <T, V> List<T> map(List<V> source, Class<T> targetClass) {
        List<T> targetList = new ArrayList<>();
        if (CollectionUtils.isEmpty(source)) {
            return targetList;
        }
        source.forEach(e -> targetList.add(map(e, targetClass)));
        return targetList;
    }

    /**
     * deal PageInfo copy
     *
     * @param pageInfo
     * @param targetClass
     * @param <T>
     * @return
     */
    public static <T> PageInf<T> mapPage(PageInf pageInfo, Class<T> targetClass) {
        List<T> targetList = map(pageInfo.getList(), targetClass);
        PageInf<T> result = map(pageInfo, PageInf.class);
        pageInfo.setList(targetList);
        return result;
    }

}
